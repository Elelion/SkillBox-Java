package module_18_efficiency._18_9_lecture_buffering;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    private static String dbName = "SkillBox";
    private static String dbUser = "root";
    private static String dbPass = "administrator";

    public static Connection getConnection() {
        if (connection == null) {
            try {

                /**
                 * DriverManager - это класс в Java, который обеспечивает
                 * взаимодействие с базой данных с помощью
                 * JDBC (Java Database Connectivity), который является стандартным
                 * интерфейсом для работы с реляционными базами данных в Java.
                 */
                connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + dbName +
                        "?user=" + dbUser + "&password=" + dbPass);
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
                connection.createStatement().execute("CREATE TABLE voter_count(" +
                    "id INT NOT NULL AUTO_INCREMENT, " +
                    "name TINYTEXT NOT NULL, " +
                    "birthDate DATE NOT NULL, " +
                    "`count` INT NOT NULL, " +
                    "PRIMARY KEY(id))");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;

    }

    public static void countVoter(String name, String birthDay) throws SQLException {
        birthDay = birthDay.replace('.', '-');
        String sql =
            "SELECT id FROM voter_count WHERE birthDate='" + birthDay + "' AND name='" + name + "'";

        /**
         * ResultSet - это интерфейс в Java, который представляет результаты
         * выполнения запроса к базе данных. Объект ResultSet содержит набор строк,
         * каждая из которых представляет отдельную запись в результирующей выборке.
         *
         * ResultSet предоставляет различные методы для работы с результирующей
         * выборкой, такие как next() для перехода к следующей строке,
         * getInt(int columnIndex) для получения значения определенного
         * столбца текущей строки в виде целого числа, getString(int columnIndex)
         * для получения значения определенного столбца текущей строки в виде строки и т.д.
         *
         * createStatement() -  является методом объекта типа Connection
         * из JDBC API и возвращает объект типа Statement, что бы потом
         * выполнить SQL запрос
         * тут мы просто объеденили все в одну строку, по раздельности это делается так:
         *
         * // получаем соединение с базой данных
         * Connection connection = DBConnection.getConnection();
         *
         * // создаем объект Statement
         * Statement statement = connection.createStatement();
         *
         * // выполняем запрос к базе данных
         * ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");
         */
        ResultSet rs = module_18_efficiency._18_9_lecture_buffering.DBConnection.getConnection().createStatement().executeQuery(sql);

        if (!rs.next()) {
            module_18_efficiency._18_9_lecture_buffering.DBConnection.getConnection()
                .createStatement()
                .execute("INSERT INTO voter_count(name, birthDate, `count`) VALUES('" +
                    name + "', '" + birthDay + "', 1)");
        } else {
            Integer id = rs.getInt("id");

            module_18_efficiency._18_9_lecture_buffering.DBConnection.getConnection()
                .createStatement()
                .execute("UPDATE voter_count SET `count`=`count`+1 WHERE id=" + id);
        }

        rs.close();
    }

    public static void printVoterCounts() throws SQLException {
        String sql = "SELECT name, birthDate, `count` FROM voter_count WHERE `count` > 1";
        ResultSet rs = module_18_efficiency._18_9_lecture_buffering.DBConnection.getConnection()
            .createStatement()
            .executeQuery(sql);

        while (rs.next()) {
            System.out.println("\t" + rs.getString("name") + " (" +
                rs.getString("birthDate") + ") - " + rs.getInt("count"));
        }
    }

}
