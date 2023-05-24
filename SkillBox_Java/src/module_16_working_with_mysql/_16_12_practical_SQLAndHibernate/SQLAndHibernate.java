package module_16_working_with_mysql._16_12_practical_SQLAndHibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLAndHibernate {
    public SQLAndHibernate(String url, String user, String pass) {
        /**
         * выносим все в отдельный файл (/data/config.proporties)
         *
         * String url = "jdbc:mysql://localhost:3306/skillbox";
         * String user = "root";
         * String pass = "administrator";
         */

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                "SELECT COUNT(course_name) / (MAX(MONTH(subscription_date)) - MIN(MONTH(subscription_date)) + 1) count, course_name " +
                    "FROM PurchaseList pl " +
                    "WHERE YEAR(subscription_date) = 2018 " +
                    "GROUP BY course_name"
            );

            while (resultSet.next()) {
                String courseName = resultSet.getString("count") + " - " + resultSet.getString("course_name");
                System.out.println(courseName);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Для примера:
     *
     * SELECT COUNT(course_name)/(MAX(MONTH(subscription_date)) - MIN(MONTH(subscription_date)) + 1) count, course_name
     * FROM SkillBox.PurchaseList
     * WHERE YEAR(subscription_date) = 2018
     * GROUP BY course_name;
     *
     * #1 2 3 4 5 6 7 8
     * #8-1 = 7
     *
     * #5 6 7
     * #7-5 = 2
     */
}
