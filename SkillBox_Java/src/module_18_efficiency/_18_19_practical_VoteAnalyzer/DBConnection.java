package module_18_efficiency._18_19_practical_VoteAnalyzer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
    private static final int BATCH_SIZE = 100_000;
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
         * если insertQuery пустой то добавляем пустую строку,
         * если там что то есть, то добавляем запятую
         * это нужно для разделения строк
         */
        boolean isStart = insertQuery.length() == 0;
        insertQuery.append( (isStart ? "" : ",") +
            "('" + name + "', '" + birthDay + "', 1)" );

        if (insertQuery.length() >= BATCH_SIZE) {
            executeMultiInsert();
        }
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

        // Формат записи: ('Омельков Логгин', '1985-08-25', 1)
        // System.out.println(insertQuery);

        String sql = "INSERT INTO voter_count(name, birthDate, `count`)" +
            "VALUES" + insertQuery.toString() +
            "ON DUPLICATE KEY UPDATE `count`=`count` + 1";

        DBConnection.getConnection()
            .createStatement()
            .execute(sql);

        insertQuery.setLength(0);
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
