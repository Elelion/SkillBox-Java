package module_5;

public class _5_3_lecture_main {
    public static void main(String[] args) {
        _5_3_lecture_Country country = new _5_3_lecture_Country("Малайзия");
        country.setPopulation(32763726);
        country.setArea(329758);
        country.setCapital("Куала-Лумпур");
        country.setHasSeaAccess(true);

        System.out.println("Страна: " + country.getName());
        System.out.println("Столица: " + country.getCapital());
    }
}
