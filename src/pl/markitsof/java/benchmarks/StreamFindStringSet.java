package pl.markitsof.java.benchmarks;

import java.util.Set;

public class StreamFindStringSet {

    public static final long ITERATIONS = 10_000_000;

    public static void main(String[] args) {

        Set<String> testSet = Set.of("ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN");

        emptyLoop("ONE");
        setByFor(testSet, "ONE");
        setByStream(testSet, "ONE");
        setByStream2(testSet, "ONE");

        emptyLoop("TEN");
        setByFor(testSet, "TEN");
        setByStream(testSet, "TEN");
        setByStream2(testSet, "TEN");
    }

    private static void setByStream(Set<String> testSet, String ten) {
        long t0 = System.nanoTime();
        for (long i = 0; i < ITERATIONS; i++) {
            testSet.stream().filter(x -> x.equals(ten)).findFirst().get();
        }
        long t1 = System.nanoTime();
        displayResults(t1 - t0, "setByStream: ", ten);
    }

    private static void displayResults(long t, String testName, String expected) {
        System.out.println(String.format("%-32s %-10s %12d ns", testName, expected, t));
    }

    private static void setByStream2(Set<String> testSet, String ten) {
        long t0 = System.nanoTime();
        for (long i = 0; i < ITERATIONS; i++) {
            streamFilter(testSet, ten);
        }
        long t1 = System.nanoTime();
        displayResults(t1 - t0, "setByStream func: ", ten);
    }

    private static String streamFilter(Set<String> testSet, String ten) {
        return testSet.stream().filter(x -> x.equals(ten)).findFirst().get();
    }

    private static void setByFor(Set<String> testSet, String expected) {
        long t0 = System.nanoTime();

        for (long i = 0; i < ITERATIONS; i++) {
            for (String item : testSet) {
                if (item.equals(expected)) {
                    break;
                }
            }
        }
        long t1 = System.nanoTime();
        displayResults(t1 - t0, "setByFor: ", expected);
    }

    private static void emptyLoop(String expected) {
        long t0 = System.nanoTime();

        for (long i = 0; i < ITERATIONS; i++) {
        }
        long t1 = System.nanoTime();
        displayResults(t1 - t0, "empty loop: ", expected);
    }

}
