package module_17_multithreading._17_6_lecture_atomic_variables;

public class AtomicVariables {
    public AtomicVariables() {
        ValueStorage valueStorage = new ValueStorage();

        for (int i = 0; i < 4; i++) {

            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    valueStorage.incrementValue();
                }

                System.out.println(valueStorage.getValue());
            }).start();
        }
    }
}
