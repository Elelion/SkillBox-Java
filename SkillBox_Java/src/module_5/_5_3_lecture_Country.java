package module_5;

public class _5_3_lecture_Country {
    /**
     * TODO: Задание №1
     * Создайте класс Country, который будет использоваться для хранения данных
     * о странах, со следующими полями:
     * • название (класс String);
     * • численность населения (тип int);
     * • площадь в квадратных километрах (тип double);
     * • название столицы (класс String);
     * • наличие выхода к морю (тип boolean).
     *
     * Имена полей установите самостоятельно так, чтобы они были понятными и
     * соответствовали хранящимся в них данным.
     *
     * - Создайте также в этом классе:
     * • конструктор с одним параметром — названием страны;
     * • методы-геттеры для всех полей класса;
     * • методы-сеттеры для всех полей класса.
     *
     * - В методе main класса Main напишите код, проверяющий работу хотя бы двух
     * геттеров и сеттеров в этом классе. Запустите этот код и убедитесь, что
     * он работает верно.
     *
     * - Если что-то не получилось, постарайтесь самостоятельно внести
     * исправления в свой код так, чтобы он стал работать.
     *
     * - В случае возникновения трудностей вы, как и всегда в заданиях для
     * самостоятельного выполнения, можете воспользоваться рекомендациями
     * под видео, под которым была указана ссылка на это задание.
     *
     * - Если всё получилось, поздравляем! Теперь вы умеете создавать
     * POJO-классы, геттеры и сеттеры!
     */

    private String name;
    private int population;
    private double area;
    private String capital;
    private boolean hasSeaAccess;

    /**/

    public _5_3_lecture_Country(String name) {
        this.name = name;
    }

    /**/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public boolean isHasSeaAccess() {
        return hasSeaAccess;
    }

    public void setHasSeaAccess(boolean hasSeaAccess) {
        this.hasSeaAccess = hasSeaAccess;
    }
}
