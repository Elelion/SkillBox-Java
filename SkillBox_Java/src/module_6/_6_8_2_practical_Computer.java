package module_6;

public class _6_8_2_practical_Computer {
    /**
     * - Задание выполняйте в директории “ObjectsAndClasses_StaticFinal”
     * репозитория “java_basics”.
     *
     * - Создайте новый проект и класс Computer со свойствами-комплектующими.
     * Класс Computer должен иметь методы, позволяющие менять его комплектующие
     * с помощью сеттеров: процессор, оперативную память, накопитель, экран и
     * клавиатуру.
     * Для каждого такого свойства создайте классы с перечисленными полями
     * (имена классов и полей, а также типы полей придумайте самостоятельно)
     * для хранения следующих сущностей:
     * Процессор:
     * • частота;
     * • количество ядер;
     * • производитель;
     * • вес.
     *
     * Оперативная память:
     * • тип;
     * • объём;
     * • вес.
     *
     * Накопитель информации:
     * • тип — HDD, SSD;
     * • объём памяти;
     * • вес.
     *
     * Экран:
     * • диагональ;
     * • тип (IPS, TN, VA);
     * • вес.
     *
     * Клавиатура:
     * • тип;
     * • наличие подсветки;
     * • вес.
     *
     * - Все эти классы должны быть иммутабельными (все поля должны быть final).
     * Имена классов и полей, а также типы полей придумайте самостоятельно. Сам
     * класс Computer иммутабельным быть не должен!
     *
     * - В классе Computer также создайте текстовые поля vendor (производитель)
     * и name (название), задаваемые при создании компьютера (в конструкторе).
     * Они также должны быть final.
     *
     * - Реализуйте в классе Computer следующие методы:
     * • Метод расчёта общей массы компьютера, возвращающий суммарный вес всех
     * его комплектующих.
     * • Геттеры и сеттеры для всех комплектующих компьютера.
     * • Метод toString, возвращающий в удобочитаемом формате всю информацию о
     * компьютере и его комплектующих.
     *
     * - Напишите в методе main код, который будет создавать несколько
     * компьютеров и выводить в консоль всю информацию о них.
     */

    private final String vendor;
    private final String name;

    public _6_8_2_practical_cpu cpu;
    public _6_8_2_practical_ram ram;
    public _6_8_2_practical_drive drive;
    public _6_8_2_practical_monitor monitor;
    public _6_8_2_practical_keyboard keyboard;

    public _6_8_2_practical_Computer(String vendor, String name) {
        this.vendor = vendor;
        this.name = name;

        System.out.println(getVendorName());
    }

    public _6_8_2_practical_Computer(String vendor, String name, _6_8_2_practical_cpu cpu,
                                     _6_8_2_practical_ram ram,
                                     _6_8_2_practical_drive drive,
                                     _6_8_2_practical_monitor monitor,
                                     _6_8_2_practical_keyboard keyboard
    ) {
        this.vendor = vendor;
        this.name = name;

        this.cpu = cpu;
        this.ram = ram;
        this.drive = drive;
        this.monitor = monitor;
        this.keyboard = keyboard;
    }

    /**/

    public void setCpu(int frequency, int core,
       _6_8_2_practical_cpuManufacturerType manufacturer, double weight
    ) {
        this.cpu = new _6_8_2_practical_cpu(frequency, core, manufacturer, weight);
    }

    public void setRAM(_6_8_2_practical_ramType type, int volume, double weight) {
        this.ram = new _6_8_2_practical_ram(type, volume, weight);
    }

    public void setDrive(_6_8_2_practical_driveType type, int volume, double weight) {
        this.drive = new _6_8_2_practical_drive(type, volume, weight);
    }

    public void setMonitor(double size, _6_8_2_practical_monitorType type,
       double weight
    ) {
        this.monitor = new _6_8_2_practical_monitor(size, type, weight);
    }

    public void setKeyboard(_6_8_2_practical_keyboardType type,
        boolean illumination, double weight
    ) {
        this.keyboard = new _6_8_2_practical_keyboard(type, illumination, weight);
    }

    /**/

    private double getTotalWeight() {
         return cpu.getWeight() + ram.getWeight() + drive.getWeight() +
                 monitor.getWeight() + keyboard.getWeight();
    }

    private String getVendorName() {
        return "+----------------------------------------+ \n" +
                "| Название: " + name + "\n" +
                "| Производитель: " + vendor + "\n" +
                "+----------------------------------------+ \n";
    }

    public String toString() {
        return getVendorName() +
                "Процессор: " + cpu + "\n" +
                "ОЗУ: " + ram + "\n" +
                "Диск: " + drive + "\n" +
                "Монитор: " + monitor + "\n" +
                "Клавиатура: " + keyboard + "\n" +
                "Вес ПК: " + getTotalWeight();
    }
}
