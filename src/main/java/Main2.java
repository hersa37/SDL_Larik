import java.sql.Array;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Main2 {

    static int[] baseArray = {5, 8, 26, 15, 11, 31};
    static int[] baseArray1K = Larik.generateArrayRandom(1000, 0, 1000);
    static int[] baseArray10K = Larik.generateArrayRandom(10000, 0, 10000);
    static int[] baseArray100k = Larik.generateArrayRandom(100000, 0, 100000);
    static int[] baseArray1M = Larik.generateArrayRandom(1000000, 0, 1000000);
    static int[] baseArray10M = Larik.generateArrayRandom(10000000, 0, 10000000);

    public static void main(String[] args) {
        double timeBArrayAsc, timeBArray1KAsc, timeBArray10KAsc, timeBArray100KAsc, timeBArray1MAsc, timeBArray10MAsc;
        double timeBArrayDesc, timeBArray1KDesc, timeBArray10KDesc, timeBArray100KDesc, timeBArray1MDesc, timeBArray10MDesc;
        double timeSArrayAsc, timeSArray1KAsc, timeSArray10KAsc, timeSArray100KAsc, timeSArray1MAsc, timeSArray10MAsc;
        double timeSArrayDesc, timeSArray1KDesc, timeSArray10KDesc, timeSArray100KDesc, timeSArray1MDesc, timeSArray10MDesc;

        //{5, 8, 26, 15, 11, 31}
        //Ascending
        //Bubble
        int[] array = Arrays.copyOf(baseArray, baseArray.length);
        System.out.println("unsorted");
        Larik.cetak(array);
        long start = System.nanoTime();
        Larik.bubbleSort(array, true);
        long end = System.nanoTime();
        System.out.println("\nSorted");
        Larik.cetak(array);
        timeBArrayAsc = time(start, end);

        //Selection
        array = Arrays.copyOf(baseArray, baseArray.length);
        start = System.nanoTime();
        Larik.selectionSort(array, true);
        end = System.nanoTime();
        timeSArrayAsc = time(start, end);

        //Descending
        //Bubble
        array = Arrays.copyOf(baseArray, baseArray.length);
        start = System.nanoTime();
        Larik.bubbleSort(array, false);
        end = System.nanoTime();
        timeBArrayDesc = time(start, end);

        //Selection
        array = Arrays.copyOf(baseArray, baseArray.length);
        start = System.nanoTime();
        Larik.selectionSort(array, false);
        end = System.nanoTime();
        timeSArrayDesc = time(start, end);

        System.out.printf("%n%5s | %-10s | %-10s | %-10s%n", "", "Bubble", "Selection", "Delta");
        System.out.println("----------------------------");
        System.out.printf("%5s | %5.8f | %5.8f | %5.8f%n","Asc", timeBArrayAsc, timeSArrayAsc,
                Math.abs(timeBArrayAsc - timeSArrayAsc));
        System.out.printf("%5s | %5.8f | %5.8f | %5.8f%n","Desc", timeBArrayDesc, timeSArrayDesc,
                Math.abs(timeBArrayDesc - timeSArrayDesc));

        System.out.println("bubble ascend");
        Larik.bubbleComplex(Arrays.copyOf(baseArray, baseArray.length), true);

        System.out.println("\nbubble descend");
        Larik.bubbleComplex(Arrays.copyOf(baseArray, baseArray.length), false);
    }

    public static double time(long start, long end) {
        return (((double)end - (double)start)/1000000000);
    }

    public static String timeFormat(double time) { return String.format("%5.10f", time);}
}
