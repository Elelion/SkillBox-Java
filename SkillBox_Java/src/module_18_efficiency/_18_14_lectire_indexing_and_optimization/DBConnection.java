package module_18_efficiency._18_14_lectire_indexing_and_optimization;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    private static String dbName = "skillbox";
    private static String dbUser = "root";
    private static String dbPass = "administrator";

    private static StringBuilder insertQuery = new StringBuilder();

    /**
     * при первом подключении к БД мы проверим вернет ли нам что нибудь наш
     * connection или нет, а тк база будет пустая, то мы сразу содаем в ней
     * таблицу, и при повторном обращении к БД connection уже НЕ вернет null
     */
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + dbName +
                        "?user=" + dbUser + "&password=" + dbPass);

                // очищаем таблицу если в ней есть данные
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");

                /**
                 * переписываем наш запрос
                 * KEY(name(50)) - создаем индекс на поле name
                 * позволяет быстрее найти значение
                 * работает только при больших БД в нашем случае от 1gb и выше
                 */
                connection.createStatement().execute("CREATE TABLE voter_count(" +
                    "id INT NOT NULL AUTO_INCREMENT, " +
                    "name TINYTEXT NOT NULL, " +
                    "birthDate DATE NOT NULL, " +
                    "`count` INT NOT NULL, " +
                    "PRIMARY KEY(id), KEY(name(50)) )");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;

    }

    /**
     * Каждый SQL запрос к БД занимает общее время выполнения программы
     * для уменьшения времени выполнения сократим наши SQL запросы
     *
     * тк в Loader мы каждую итерацию цикла вызываем данный метод countVoter
     *
     * закомментированный код оставляем для примера и наглядности
     */
    public static void countVoter(String name, String birthDay) throws SQLException {
        birthDay = birthDay.replace('.', '-');

        /**
         * оптимизируем запрос
         *
         * ON DUPLICATE KEY UPDATE - если такой ключ встречается в индексе, то
         * мы просто добавляем к полю count +1
         *
         * INSERT - позволяет делать множественные вставки
         * перепишем код, что бы был МНОЖЕСТВЕННЫЙ INSERT запрос
         * используем для этого StringBuilder в который заталкаем много запросов
         * а потом разом выполним его
         *
         * тк в старом коде - у нас КАЖДЫЙ раз выполнялся новый INSERT - это
         * расходует много ресурсов
         */

        // новый код

        /**
         * если insertQuery пустой то добавляем пустую строку,
         * если там что то есть, то добавляем запятую
         * это нужно для разделения строк
         */
        boolean isStart = insertQuery.length() == 0;
        insertQuery.append( (isStart ? "" : ",") +
            "('" + name + "', '" + birthDay + "', 1)");

        // старый код перенесен в - executeMultiInsert

        /**/
        // старый не оптимизированный вариант SQL обращения

        // String sql =
        //    "SELECT id FROM voter_count WHERE birthDate='" + birthDay + "' AND name='" + name + "'";

        /**
         * ResultSet в Java представляет собой таблицу данных, которые были
         * получены после выполнения SQL-запроса к базе данных. Он содержит
         * результаты запроса в виде объекта Java, который можно использовать
         * для получения, изменения и обновления данных. ResultSet предоставляет
         * методы для чтения данных из таблицы и просмотра их содержимого. Он
         * также поддерживает курсор, который может быть перемещен вперед и
         * назад по строкам результатов.
         *
         * createStatement() - это метод класса Connection, который возвращает
         * объект типа Statement. Объект Statement используется для выполнения
         * SQL-запросов к базе данных. В результате вызова createStatement()
         * возвращается объект Statement, который можно использовать для выполнения
         * запросов к базе данных.
         */
        // ResultSet rs = DBConnection.getConnection()
        //    .createStatement()
        //    .executeQuery(sql);

        /**
         * Метод next() в интерфейсе ResultSet перемещает курсор к следующей
         * строке в наборе результатов, и возвращает true если такая строка
         * существует, и false, если строки больше нет.
         */
        /*
        if (!rs.next()) {

            // вставляем данные из XML в нашу БД
            DBConnection.getConnection()
                .createStatement()
                .execute("INSERT INTO voter_count(name, birthDate, `count`) VALUES('" +
                    name + "', '" + birthDay + "', 1)");
        } else {
            Integer id = rs.getInt("id");
            DBConnection.getConnection()
                .createStatement()
                .execute("UPDATE voter_count SET `count`=`count`+1 WHERE id=" + id);
        }

        rs.close();
         */
    }

    /**
     * выбираем просто одного пользователя из нашей БД
     */
    public static int customerSelect() throws SQLException {
        String sql = "SELECT id FROM voter_count WHERE name='Лунькин Гордий'";
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);

        if (!rs.next()) {
            return -1;
        } else {
            return rs.getInt("id");
        }
    }

    /**
     * это наш старый код, который мы взяли из - countVoter
     * вставляем сюда insertQuery за место наших параметров
     */
    public static void executeMultiInsert() throws SQLException {

        // ('Омельков Логгин', '1985-08-25', 1)
        // System.out.println(insertQuery);

        String sql = "INSERT INTO voter_count(name, birthDate, `count`)" +
            "VALUES" + insertQuery.toString() +
            "ON DUPLICATE KEY UPDATE `count`=`count` + 1";

        DBConnection.getConnection()
            .createStatement()
            .execute(sql);
    }

    public static void printVoterCounts() throws SQLException {
        String sql = "SELECT name, birthDate, `count` FROM voter_count WHERE `count` > 1";
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);

        while (rs.next()) {
            System.out.println("\t" + rs.getString("name") + " (" +
                rs.getString("birthDate") + ") - " + rs.getInt("count"));
        }
    }

}
