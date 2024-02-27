package module_17_multithreading._17_12_lecture_deadlock;

public class Friend implements Comparable<Friend> {
    private final String name;

    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public synchronized void _throwBallTo(Friend catcher) {
        System.out.format(
            "%s: %s кинул мне мяч!%n",
            catcher.getName(),
            this.name);

        /**
         * 1ый поток входит сюда и хочет выполнить этот метод
         * 2ой поток входит сюда же и пытается выполнить этот же метод
         * НО 2ой поток не может выполнить метод ниже тк этот метод
         * уже пытается выполнить 1ый поток
         * и оба потока начинают ждать друг друга
         *
         * самый простой способ убрать deadlock это создать synchronize блока
         * см этот метод же ниже
         */
        catcher.throwBallTo(this);
    }

    public void throwBallTo(Friend catcher) {
        System.out.format(
            "%s: %s кинул мне мяч!%n",
            catcher.getName(),
            this.name);

        /**
         * устанавливаем очередность блока
         * для этого мы будем сравнивать объекты класса с помощью compareTo()
         * и определять какой из них меньше и блокировать только по тому объекту
         * который меньше
         *
         * те мы будем сравнивать по catcher
         *
         * но в конечном итоге у нас произойдет ошибка - StackOverflowError
         * переполнение стека вызова, тк бесконечные вызовы в стеке делать
         * нельзя
         */
        synchronized (compareTo(catcher) > 0 ? catcher : this) {
            catcher.throwBallTo(this);
        }
    }

    @Override
    public int compareTo(Friend o) {
        return this.getName().compareTo(o.getName());
    }
}
