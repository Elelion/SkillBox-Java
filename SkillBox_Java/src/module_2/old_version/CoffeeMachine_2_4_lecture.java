package module_2;

public class CoffeeMachine_2_4_lecture {
    public static void main(String[] args) {
        int moneyAmount = 180;
        int cappuccinoPrice = 180;
        int lattePrice = 120;
        int espressoPrice = 80;

        boolean canByeAnything = false;
        boolean isMilkEnough = true;

        boolean moneyEnoughForCappuccino = moneyAmount >= cappuccinoPrice;
        if (moneyEnoughForCappuccino && isMilkEnough == true) {
            System.out.println("Вы можете купить капучино");
            canByeAnything = true;
        }

        // isMilkEnough == true писать не обязательно! будет и так true / false
        if (moneyAmount >= lattePrice && isMilkEnough) {
            System.out.println("Вы можете купить лате");
            canByeAnything = true;
        }

        if (moneyAmount >= espressoPrice) {
            System.out.println("Вы можете купить експрессо");
            canByeAnything = true;
        }

        // равносильно что и canByeAnything == false
        // if (!canByeAnything) {...}

        // тернарный оператор
        System.out.println(canByeAnything ? "Выберите напиток" : "Не достаточно средств");
    }
}
