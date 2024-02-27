package module_4_objects_and_classes_Part_1;

public class _4_6_lecture_IM_employee {
    private String name;
    private String email = "не задан";
    private int phone;

    public _4_6_lecture_IM_employee() {
        System.out.println("Информация о сотруднике");
    }

    public _4_6_lecture_IM_employee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public _4_6_lecture_IM_employee(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }

    public _4_6_lecture_IM_employee(String name, String email, int phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public void printInfo() {
        System.out.println("Имя: " + name);
        System.out.println("E-mail: " + email);
        System.out.println("Телефон: " + ((phone > 0) ? phone : "не задан"));
        System.out.println();
    }
}
