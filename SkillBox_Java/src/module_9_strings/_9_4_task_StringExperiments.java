package module_9_strings;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class _9_4_task_StringExperiments {
    public _9_4_task_StringExperiments() {
        System.out.println("Введите текст:");
        String text = new Scanner(System.in).nextLine();

//        System.out.println("Введите имя исходной кодировки:");
//        String srcEncoding = new Scanner(System.in).nextLine();

        System.out.println("Введите имя целевой кодировки:");
        String dstEncoding = new Scanner(System.in).nextLine();

        String encoded = null;
        try {
            encoded = new String(
//                text.getBytes(srcEncoding),
                text.getBytes(),
                dstEncoding
            );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println("Результат: " + encoded);
    }
}
