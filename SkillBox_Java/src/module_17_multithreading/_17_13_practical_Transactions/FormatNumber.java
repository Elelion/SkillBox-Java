package module_17_multithreading._17_13_practical_Transactions;

import java.text.NumberFormat;

public interface FormatNumber {
    default String convertFormatNumber(int amount) {
        NumberFormat formatNum = NumberFormat.getInstance();
//        System.out.println( formatNum.format(amount) );
        return formatNum.format(amount);
    }
}
