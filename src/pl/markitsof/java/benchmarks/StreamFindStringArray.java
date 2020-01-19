package pl.markitsof.java.benchmarks;

import java.util.stream.Stream;

public class StreamFindStringArray {

    public static final long ITERATIONS = 10_000_000;

    public static void main(String[] args) {

        String[] testArray = new String[] {"ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN"};

        emptyLoop("ONE");
        arrayByFor(testArray, "ONE");
        arrayByStream(testArray, "ONE");
        arrayByStream2(testArray, "ONE");

        emptyLoop("TEN");
        arrayByFor(testArray, "TEN");
        arrayByStream(testArray, "TEN");
        arrayByStream2(testArray, "TEN");
    }

    private static void arrayByStream( String[] testSet, String ten) {
        long t0 = System.nanoTime();
        for (long i = 0; i < ITERATIONS; i++) {
            Stream.of(testSet).filter(x -> x.equals(ten)).findFirst().get();
        }
        long t1 = System.nanoTime();
        displayResults(t1 - t0, "arrayByStream: ", ten);
    }

    private static void displayResults(long t, String testName, String expected) {
        System.out.println(String.format("%-32s %-10s %12d ns", testName, expected, t));
    }

    private static void arrayByStream2( String[] testSet, String ten) {
        long t0 = System.nanoTime();
        for (long i = 0; i < ITERATIONS; i++) {
            streamFilter(testSet, ten);
        }
        long t1 = System.nanoTime();
        displayResults(t1 - t0, "arrayByStream func: ", ten);
    }

    private static String streamFilter(String[] testSet, String ten) {
        return Stream.of(testSet).filter(x -> x.equals(ten)).findFirst().get();
    }

    private static void arrayByFor(String[] testArray, String expected) {
        long t0 = System.nanoTime();

        for (long i = 0; i < ITERATIONS; i++) {
            for (String item : testArray) {
                if (item.equals(expected)) {
                    break;
                }
            }
        }
        long t1 = System.nanoTime();
        displayResults(t1 - t0, "arrayByFor: ", expected);
    }

    private static void emptyLoop(String expected) {
        long t0 = System.nanoTime();

        for (long i = 0; i < ITERATIONS; i++) { }
        long t1 = System.nanoTime();
        displayResults(t1 - t0, "empty loop: ", expected);
    }

}
