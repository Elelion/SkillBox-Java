package module_14_exceptions_debug_test_log._14_9_1_practical_ConsoleCustomerList;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    private final String name;
    private final String phone;
    private final String email;
    private final String regexMailCheck = "[A-Za-z0-9+]+(@{1})+([A-Za-z0-9+])+(\\.{1})+([A-Za-z]{2,})";
    private final String regexPhoneCheck = "[+]\\d{11}";
    private static final Logger logger = LogManager.getLogger(Customer.class);

    /**/

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Customer(String name, String phone, String email) {
        logger.log(Level.WARN, "Start check for email & phone");

        this.email = isEmailCheck(email) ? email : null;
        this.phone = isPhoneCheck(phone) ? phone : null;
        this.name = name;
    }

    private boolean isEmailCheck(String email) {
        Pattern pattern = Pattern.compile(regexMailCheck);
        Matcher matcher = pattern.matcher(email);

        if (matcher.find()) {
            logger.log(Level.INFO, "email check - ok");
            return true;
        } else {
            String error = "Wrong email format";
            logger.log(Level.ERROR, error);
            throw new IllegalArgumentException(error);
        }
    }

    private boolean isPhoneCheck(String phone) {
        if (phone.matches(regexPhoneCheck)) {
            logger.log(Level.INFO, "phone check - ok");
            return true;
        } else {
            String error = "Wrong phone format";
            logger.log(Level.ERROR, error);
            throw new IllegalArgumentException(error);
        }
    }

    public String toString() {
        return name + " - " + email + " - " + phone;
    }









}
