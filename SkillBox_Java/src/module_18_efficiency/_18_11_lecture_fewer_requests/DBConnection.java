package module_18_efficiency._18_11_lecture_fewer_requests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    private static String dbName = "skillbox";
    private static String dbUser = "root";
    private static String dbPass = "administrator";

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

                // переписываем наш запрос
                connection.createStatement().execute("CREATE TABLE voter_count(" +
                    "id INT NOT NULL AUTO_INCREMENT, " +
                    "name TINYTEXT NOT NULL, " +
                    "birthDate DATE NOT NULL, " +
                    "`count` INT NOT NULL, " +
                    "PRIMARY KEY(id), " +
                    "UNIQUE KEY name_date(name(50), birthDate))");
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
     * закомментированный код оставляем для примера и наглядности
     */
    public static void countVoter(String name, String birthDay) throws SQLException {
        birthDay = birthDay.replace('.', '-');

        /**
         * ON DUPLICATE KEY UPDATE - если такой ключ встречается в индексе, то
         * мы просто добавляем к полю count +1
         */
        String sql = "INSERT INTO voter_count(name, birthDate, `count`) " +
            "VALUES('" + name + "', '" + birthDay + "', 1)" +
            "ON DUPLICATE KEY UPDATE `count`=`count` + 1";

        module_18_efficiency._18_11_lecture_fewer_requests.DBConnection.getConnection()
            .createStatement()
            .execute(sql);

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

    public static void printVoterCounts() throws SQLException {
        String sql = "SELECT name, birthDate, `count` FROM voter_count WHERE `count` > 1";
        ResultSet rs = module_18_efficiency._18_11_lecture_fewer_requests.DBConnection.getConnection().createStatement().executeQuery(sql);

        while (rs.next()) {
            System.out.println("\t" + rs.getString("name") + " (" +
                rs.getString("birthDate") + ") - " + rs.getInt("count"));
        }
    }

}
