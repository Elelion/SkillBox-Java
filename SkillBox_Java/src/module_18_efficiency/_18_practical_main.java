package module_18_efficiency;

import module_17_multithreading._17_21_practical_ForkJoinPool.SiteMapGenerator;
import module_18_efficiency._18_18_practical_CarNumberGenerator.CarNumberGenerator;
import module_18_efficiency._18_19_practical_VoteAnalyzer.Loader;
import module_18_efficiency._18_19_practical_VoteAnalyzer.Voter;

import java.io.IOException;

public class _18_practical_main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Практика 18.18");
//        new CarNumberGenerator();
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        System.out.println("---");

        /* ----------------------------------------------------------------- */

        System.out.println("Практика 18.19");
//        new Voter();
        try {
            new Loader();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        System.out.println("---");
    }

}
