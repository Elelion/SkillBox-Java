package module_17_multithreading._17_13_practical_Transactions;

public interface RandomAmount {
    default int getRandomAmount(int from, int to) {
        return from + (int) (Math.random() * to);
    }
}
