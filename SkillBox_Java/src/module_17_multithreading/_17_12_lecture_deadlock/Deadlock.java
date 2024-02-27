package module_17_multithreading._17_12_lecture_deadlock;

public class Deadlock {
    public Deadlock() {
        final Friend vasya = new Friend("Вася");
        final Friend vitya = new Friend("Витя");

        new Thread(() -> vasya.throwBallTo(vitya)).start();
        new Thread(() -> vitya.throwBallTo(vasya)).start();
    }
}
