public class Main {

    // коротко напечатать psvm + tab
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(8 * 231);

        /**/

        int numberInt = 80;
        double numberDouble = 2.954;
        String stringText = "some text";

        // var - определяет тип переменной сам, в зависимости от значения
        var someVal = "str";
        System.out.println(someVal);

        // генерируем случаенно число (точка не на что не влияет - 3500.)
        int randomHeight = (int) (1000 + 3500. * Math.random());
        System.out.println("randomHeight: " + randomHeight);
        int randomHeight2 = (int) (1000 + 3500 * Math.random());
        System.out.println("randomHeight2: " + randomHeight2);
    }
}