package module_16_working_with_mysql._16_2_lecture_JBDC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {
    public JDBC() {
        /**
         * JDBC - Java DataBase Connectivity
         *
         * для подключения к mysql нам нужно расширение
         * mysql:mysql-connector-java
         *
         * Docker:
         * если подлючаемся к докеру, то докер надо запускать с параметром -p
         * и указать порт 3306:3306
         * те я прокину порт между докером и хостом
         */

        /**
         * обычно подобные данные нужно выносить в отдельный файл,
         * который будет скрыт , типа как в PHP когда мы выносили его
         * в отдельный файл конфига
         */

        // обычно одно приложение использует одну БД - указываем сразу и БД
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "administrator";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM good");

            while (resultSet.next()) {
                String courseName = resultSet.getString("name");
                System.out.println(courseName);
            }

            /**
             * ВАЖНО !!!
             *
             * если не закрыть соединение, и программа будет выполняться дальше
             * то наше соединение зависнет в памяти, и память будет излишне
             * заниматься
             */
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
