package module_16_working_with_mysql._16_3_lecture_without_ResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class WithoutResultSet {
    public WithoutResultSet() {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "administrator";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();

            // изменяем данные без resultSet
            statement.execute("UPDATE good SET name = 'WebDev' WHERE id = 1");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM good LIMIT 10");

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");

                System.out.println("id: " + id + " | " + name);
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
