package pl.markitsoft.java.benchmarks;

import java.util.Set;

public class StreamFindStringInternSet {

    public static final long ITERATIONS = 10_000_000;

    public static void main(String[] args) {

        Set<String> testSet = Set.of("ONE".intern(), "TWO".intern(), "THREE".intern(), "FOUR".intern(),
                "FIVE".intern(), "SIX", "SEVEN".intern(), "EIGHT".intern(), "NINE".intern(), "TEN".intern());

        emptyLoop("ONE".intern());
        setByFor(testSet, "ONE".intern());
        setByStream(testSet, "ONE".intern());
        setByStream2(testSet, "ONE".intern());

        emptyLoop("TEN".intern());
        setByFor(testSet, "TEN".intern());
        setByStream(testSet, "TEN".intern());
        setByStream2(testSet, "TEN".intern());
    }

    private static void setByStream(Set<String> testSet, String ten) {
        long t0 = System.nanoTime();
        for (long i = 0; i < ITERATIONS; i++) {
            testSet.stream().filter(x -> x.equals(ten)).findFirst().get();
        }
        long t1 = System.nanoTime();
        displayResults(t1 - t0, "setInternByStream: ", ten);
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
        displayResults(t1 - t0, "setInternStream func: ", ten);
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
        displayResults(t1 - t0, "setInternByFor: ", expected);
    }

    private static void emptyLoop(String expected) {
        long t0 = System.nanoTime();

        for (long i = 0; i < ITERATIONS; i++) { }
        long t1 = System.nanoTime();
        displayResults(t1 - t0, "empty loop: ", expected);
    }

}
