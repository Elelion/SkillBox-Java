package module_2;

public class _2_11_2_AgeComparator {
    public static void main(String[] args) {
        /**
         * TODO: Задача 2.11 - 2
         * - написать код который будет присваивать и печатать возраст
         * согласно названиям переменным, те найти мин, мах и средний возраст
         */

        int vasyaAge = 29;
        int katyaAge = 14;
        int mishaAge = 36;

        int min = 0;
        int middle = 0;
        int max = 0;

        /**/

        if (vasyaAge < katyaAge && vasyaAge < mishaAge) {
            min = vasyaAge;
            System.out.println("vasyaAge min: " + min);
        } else if (katyaAge < vasyaAge && katyaAge < mishaAge) {
            min = katyaAge;
            System.out.println("katyaAge min: " + min);
        } else if (mishaAge < vasyaAge && mishaAge < katyaAge) {
            min = mishaAge;
            System.out.println("mishaAge min: " + min);
        } else if (vasyaAge == katyaAge || vasyaAge == mishaAge) {
            min = vasyaAge;
            System.out.println("vasyaAge min: " + min);
        }

        /**/

        if (vasyaAge > katyaAge && vasyaAge > mishaAge) {
            max = vasyaAge;
            System.out.println("vasyaAge max: " + max);
        } else if (katyaAge > vasyaAge && katyaAge > mishaAge) {
            max = katyaAge;
            System.out.println("katyaAge max: " + max);
        } else if (mishaAge > vasyaAge && mishaAge > katyaAge) {
            max = mishaAge;
            System.out.println("mishaAge max: " + max);
        } else if (katyaAge == vasyaAge || katyaAge == mishaAge) {
            max = katyaAge;
            System.out.println("katyaAge max: " + max);
        }

        /**/

        if (vasyaAge < katyaAge && vasyaAge > mishaAge || vasyaAge < mishaAge && vasyaAge > katyaAge) {
            middle = vasyaAge;
            System.out.println("vasyaAge middle: " + middle);
        } else if (katyaAge < vasyaAge && katyaAge > mishaAge || katyaAge < mishaAge && katyaAge > vasyaAge) {
            middle = katyaAge;
            System.out.println("katyaAge middle: " + middle);
        } else if (mishaAge < vasyaAge && mishaAge > katyaAge || mishaAge < katyaAge && mishaAge < vasyaAge) {
            middle = mishaAge;
            System.out.println("mishaAge middle: " + middle);
        } else if (mishaAge == vasyaAge || mishaAge == katyaAge) {
            middle = mishaAge;
            System.out.println("mishaAge middle: " + middle);
        }
    }
}
