package module_5;

public class _5_6_lecture_main {
    public static void main(String[] args) {
        _5_6_lecture_BankDetails details = new _5_6_lecture_BankDetails();
//        _5_6_lecture_BankDetails details = new _5_6_lecture_BankDetails("1", "2", "3", "4", "5");

        // при иммутабельности каждый метод будет создавать новый объект...
        details.setBillNumber("setBillNumber");
//        System.out.println(details.setBillNumber("setBillNumber"));
//        System.out.println(details.setCorrespondenceBill("setCorrespondenceBill"));

        System.out.println("details:");
//        System.out.println(details);
//        System.out.println("---");

        _5_6_lecture_company company = new _5_6_lecture_company("Смарт-Экспресс", details);
        details.setBillNumber("555544433");
//        System.out.println(company);
//        System.out.println("---");

        // для копирования объекта делаем так
        _5_6_lecture_BankDetails copy = new _5_6_lecture_BankDetails(
                details.getBillNumber(),
                details.getCorrespondenceBill(),
                details.getBikNumber(),
                details.getBankName(),
                details.getCity()
        );

        System.out.println(copy);
    }
}
