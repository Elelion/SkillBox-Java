package module_14_exceptions_debug_test_log._14_2_lecture_catching_exceptions;

public class Customer {
    private String name;
    private String phone;
    private String eMail;

    public Customer(String name, String phone, String eMail) {
        this.name = name;
        this.phone = phone;
        this.eMail = eMail;
    }

    public String toString() {
        return name + " - " + eMail + " - " + phone;
    }

}
