package module_7_primitives;

public class _7_3_lecture_types_of_primitives {
    public _7_3_lecture_types_of_primitives() {
        /**
         * если задать значение больше чем может хранить - byte (127 / 1 байт)
         * то код будет подчеркнут красным
         */
        // byte b = 200;

        // так то же будет ошибка, тк компилятор проверит это перед выполнеинем
        // byte b = 120;
        // byte a = b + b; // тк 120 + 120 = 240 это > 127

        /**/

        // значения по умолчанию
        boolean a = false;
        byte a1 = 0;
        char a2 = 0; // symbol
        short a3 = 0;
        int a4 = 0;
        long a5 = 0;
        float a6 = 0.0F;
        double a7 = 0.0;
    }
}
