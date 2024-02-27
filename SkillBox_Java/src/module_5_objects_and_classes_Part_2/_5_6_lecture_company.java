package module_5_objects_and_classes_Part_2;

// Задание 1
public class _5_6_lecture_company {
    private final String name;
    private final _5_6_lecture_BankDetails bankDetails;

    public _5_6_lecture_company(String name, _5_6_lecture_BankDetails bankDetails) {
        this.name = name;
        this.bankDetails = bankDetails;
    }

    /**/

//    public String getName() {
//        return name;
//    }

//    public _5_6_lecture_BankDetails getBankDetail() {
//        return bankDetails;
//    }

    public String toString() {
        return name + "\n" + bankDetails;
    }

}
