package module_5_objects_and_classes_Part_2;

// Задание 1
public class _5_6_lecture_BankDetails {
    private final String billNumber;
    private final String correspondenceBill;
    private final String bikNumber;
    private final String bankName;
    private final String city;

    public _5_6_lecture_BankDetails(String billNumber, String correspondenceBill,
                                    String bikNumber, String bankName, String city) {
        this.billNumber = billNumber;
        this.correspondenceBill = correspondenceBill;
        this.bikNumber = bikNumber;
        this.bankName = bankName;
        this.city = city;
    }

    public _5_6_lecture_BankDetails() {
        billNumber = "N/A";
        correspondenceBill = "N/A";
        bikNumber = "N/A";
        bankName = "N/A";
        city = "N/A";
    }

    /**/

    /**
     * тем самым что бы изменить наши константы - мы делаем некий обход
     * те мы создаем в методе новый объект и передаем в него только то значение,
     * которое хотим изменить, а остальные значения берем из констант-переменных
     * значение которых мы определяем в контсрукторе при создании
     */
    public _5_6_lecture_BankDetails setBillNumber(String billNumber) {
        return new _5_6_lecture_BankDetails(billNumber, correspondenceBill, bikNumber, bankName, city);
    }

    public _5_6_lecture_BankDetails setCorrespondenceBill(String correspondenceBill) {
        return new _5_6_lecture_BankDetails(billNumber, correspondenceBill, bikNumber, bankName, city);
    }

    public _5_6_lecture_BankDetails setBikNumber(String bikNumber) {
        return new _5_6_lecture_BankDetails(billNumber, correspondenceBill, bikNumber, bankName, city);
    }

    public _5_6_lecture_BankDetails setBankName(String bankName) {
        return new _5_6_lecture_BankDetails(billNumber, correspondenceBill, bikNumber, bankName, city);
    }

    public _5_6_lecture_BankDetails setCity(String city) {
        return new _5_6_lecture_BankDetails(billNumber, correspondenceBill, bikNumber, bankName, city);
    }

    /**
     * тк мы сделали все переменные константами, и менять их теперь нельзя
     * то менять мы их будем за счет создания нового объекта
     */
    /*
    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public void setCorrespondenceBill(String correspondenceBill) {
        this.correspondenceBill = correspondenceBill;
    }

    public void setBikNumber(String bikNumber) {
        this.bikNumber = bikNumber;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setCity(String city) {
        this.city = city;
    }
    */

    /**/

    public String getBillNumber() {
        return billNumber;
    }

    public String getCorrespondenceBill() {
        return correspondenceBill;
    }

    public String getBikNumber() {
        return bikNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public String getCity() {
        return city;
    }

    /**/

    // вызовиться автоматически при создании объекта
    public String toString() {
        return "счет: " + billNumber + "\n" +
                "к/с: " + correspondenceBill + "\n" +
                "БИК: " + bikNumber + "\n" +
                "в " + bankName + " (" + city + ")";
    }

}
