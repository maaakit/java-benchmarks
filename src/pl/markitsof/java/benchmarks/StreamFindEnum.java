package pl.markitsof.java.benchmarks;

import java.util.stream.Stream;

public class StreamFindEnum {

    public static final long ITERATIONS = 10_000_000;


    public enum TestEnum {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN
    }

    public static void main(String[] args) {

        System.out.println("Benchmark of finding element in enum");

        emptyLoop(TestEnum.ONE);
        enumByFor(TestEnum.ONE);
        enumByForEquals(TestEnum.ONE);
        enumByStream(TestEnum.ONE);
        enumByStreamEquals(TestEnum.ONE);
        enumByStream2(TestEnum.ONE);
        enumByStream2Equals(TestEnum.ONE);

        emptyLoop(TestEnum.TEN);
        enumByFor(TestEnum.TEN);
        enumByForEquals(TestEnum.TEN);
        enumByStream(TestEnum.TEN);
        enumByStreamEquals(TestEnum.TEN);
        enumByStream2(TestEnum.TEN);
        enumByStream2Equals(TestEnum.TEN);

    }

    private static void separator(String s) {
        System.out.println(s);
    }

    private static void enumByStreamEquals(TestEnum ten) {
        long t0 = System.nanoTime();
        for (long i = 0; i < ITERATIONS; i++) {
            Stream.of(TestEnum.values()).filter(x -> x.equals(ten)).findFirst().get();
        }
        long t1 = System.nanoTime();
        displayResults(t1 - t0, "enumByStreamEquals: ", ten);
    }
    private static void enumByStream(TestEnum ten) {
        long t0 = System.nanoTime();
        for (long i = 0; i < ITERATIONS; i++) {
            Stream.of(TestEnum.values()).filter(x -> x ==ten).findFirst().get();
        }
        long t1 = System.nanoTime();
        displayResults(t1 - t0, "enumByStream == :", ten);
    }

    private static void displayResults(long t, String testName, TestEnum expected) {
        System.out.println(String.format("%-32s %-10s %12d ns ", testName, expected, t));
    }

    private static void enumByStream2Equals(TestEnum ten) {
        long t0 = System.nanoTime();
        for (long i = 0; i < ITERATIONS; i++) {
            streamFilterEquals(ten);
        }
        long t1 = System.nanoTime();
        displayResults(t1 - t0, "enumByStream func equals: ", ten);
    }

    private static void enumByStream2(TestEnum ten) {
        long t0 = System.nanoTime();
        for (long i = 0; i < ITERATIONS; i++) {
            streamFilter(ten);
        }
        long t1 = System.nanoTime();
        displayResults(t1 - t0, "enumByStream func == :", ten);
    }

    private static TestEnum streamFilterEquals(TestEnum ten) {
        return Stream.of(TestEnum.values()).filter(x -> x.equals(ten)).findFirst().get();
    }
    private static TestEnum streamFilter(TestEnum ten) {
        return Stream.of(TestEnum.values()).filter(x -> x == ten).findFirst().get();
    }

    private static void enumByFor(TestEnum expected) {
        long t0 = System.nanoTime();
        for (long i = 0; i < ITERATIONS; i++) {
            for (TestEnum item : TestEnum.values()) {
                if (item ==  expected) {
                    break;
                }
            }
        }
        long t1 = System.nanoTime();
        displayResults(t1 - t0, "enumByFor == : ", expected);
    }
    private static void enumByForEquals(TestEnum expected) {
        long t0 = System.nanoTime();
        for (long i = 0; i < ITERATIONS; i++) {
            for (TestEnum item : TestEnum.values()) {
                if (item.equals(expected)) {
                    break;
                }
            }
        }
        long t1 = System.nanoTime();
        displayResults(t1 - t0, "enumByForEquals: ", expected);
    }

    private static void emptyLoop(TestEnum expected) {
        long t0 = System.nanoTime();

        for (long i = 0; i < ITERATIONS; i++) {
        }
        long t1 = System.nanoTime();
        displayResults(t1 - t0, "empty loop: ", expected);
    }

}
