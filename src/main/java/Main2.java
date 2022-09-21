import java.util.Arrays;

public class Main2 {

    static int[] baseArray = {5, 8, 26, 15, 11, 31};
    static int[] baseArray1K = Larik.generateArrayRandom(1000, 0, 1000);
    static int[] baseArray10K = Larik.generateArrayRandom(10000, 0, 10000);
    static int[] baseArray100k = Larik.generateArrayRandom(100000, 0, 100000);
    static int[] baseArray1M = Larik.generateArrayRandom(1000000, 0, 1000000);
    static int[] baseArray10M = Larik.generateArrayRandom(10000000, 0, 10000000);
    static double timeBArrayAsc, timeBArray1KAsc, timeBArray10KAsc, timeBArray100KAsc, timeBArray1MAsc, timeBArray10MAsc;
    static double timeBArrayDesc, timeBArray1KDesc, timeBArray10KDesc, timeBArray100KDesc, timeBArray1MDesc, timeBArray10MDesc;
    static double timeSArrayAsc, timeSArray1KAsc, timeSArray10KAsc, timeSArray100KAsc, timeSArray1MAsc, timeSArray10MAsc;
    static double timeSArrayDesc, timeSArray1KDesc, timeSArray10KDesc, timeSArray100KDesc, timeSArray1MDesc, timeSArray10MDesc;

    public static void main(String[] args) throws InterruptedException {


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
        System.out.printf("%5s | %5.8f | %5.8f | %5.8f%n", "Asc", timeBArrayAsc, timeSArrayAsc,
                Math.abs(timeBArrayAsc - timeSArrayAsc));
        System.out.printf("%5s | %5.8f | %5.8f | %5.8f%n", "Desc", timeBArrayDesc, timeSArrayDesc,
                Math.abs(timeBArrayDesc - timeSArrayDesc));

        System.out.println("\nBubble ascend");
        Larik.bubbleComplex(Arrays.copyOf(baseArray, baseArray.length), true);

        System.out.println("\nBubble descend");
        Larik.bubbleComplex(Arrays.copyOf(baseArray, baseArray.length), false);

        System.out.println("\nSelection ascend");
        Larik.selectionComplex(Arrays.copyOf(baseArray, baseArray.length), true);

        System.out.println("\nSelection descend");
        Larik.selectionComplex(Arrays.copyOf(baseArray, baseArray.length), false);


        //Bubble big array
        //Ascending
        Thread first = new Thread(() -> {
            bigBArrayAsc();
        });

        //Descending
        Thread second = new Thread(() -> {
            bigBArrayDesc();
        });

        //Selection big array
        //Ascending
        Thread third = new Thread(() -> {
            bigSArrayAsc();
        });

        //Descending
        Thread fourth = new Thread(() -> {
            bigSArrayDesc();
        });

        first.start();
        ;
        second.start();
        third.start();
        fourth.start();

        first.join();
        second.join();
        third.join();
        fourth.join();

        timeSArrayAsc = 1013400245;
        //Print time
        //Bubble
        String numberFormat = "%n%5s| %15.5f | %15.5f | %15.5f | %15.5f | %15.5f |";
        System.out.println("\nBubble sort");
        System.out.printf("%5s| %15s | %15s | %15s | %15s | %15S |", "", "1K", "10K", "100K", "1M", "10M");
        System.out.printf(numberFormat, "Asc", timeBArray1KAsc, timeBArray10KAsc,
                timeBArray100KAsc, timeBArray1MAsc, timeBArray10MAsc);
        System.out.printf(numberFormat, "Desc", timeBArray1KDesc, timeBArray10KDesc,
                timeBArray100KDesc, timeBArray1MDesc, timeBArray10MDesc);

        //Selection
        System.out.println("\nSelection sort");
        System.out.printf("%5s| %15s | %15s | %15s | %15s | %15S |", "", "1K", "10K", "100K", "1M", "10M");
        System.out.printf(numberFormat, "Asc", timeSArray1KAsc, timeSArray10KAsc,
                timeSArray100KAsc, timeSArray1MAsc, timeSArray10MAsc);
        System.out.printf(numberFormat, "Desc", timeSArray1KDesc, timeSArray10KDesc,
                timeSArray100KDesc, timeSArray1MDesc, timeSArray10MDesc);

        System.out.println("\n\n");


    }

    public static double time(long start, long end) {
        return (((double) end - (double) start) / 1000000000);
    }

    public static String timeFormat(double time) {
        return String.format("%5.10f", time);
    }

    public static double bigBArray(int[] array, boolean isAscending) {
        int[] tempArray = Arrays.copyOf(array, array.length);
        long start = System.nanoTime();
        Larik.bubbleSort(tempArray, isAscending);
        long end = System.nanoTime();
        return time(start, end);
    }


    public static double bigSArray(int[] array, boolean isAscending) {
        int[] tempArray = Arrays.copyOf(array, array.length);
        long start = System.nanoTime();
        Larik.selectionSort(tempArray, isAscending);
        long end = System.nanoTime();
        return time(start, end);
    }

    public static void bigBArrayAsc() {
        boolean asc = true;
        timeBArray1KAsc = bigBArray(Arrays.copyOf(baseArray1K, baseArray1K.length), asc);
        timeBArray10KAsc = bigBArray(Arrays.copyOf(baseArray10K, baseArray10K.length), asc);
        timeBArray100KAsc = bigBArray(Arrays.copyOf(baseArray100k, baseArray100k.length), asc);
        timeBArray1MAsc = bigBArray(Arrays.copyOf(baseArray1M, baseArray1M.length), asc);
        /*        timeBArray10MAsc = bigBArray(Arrays.copyOf(baseArray10M, baseArray10M.length), asc);*/
    }

    public static void bigBArrayDesc() {
        boolean asc = false;
        timeBArray1KDesc = bigBArray(Arrays.copyOf(baseArray1K, baseArray1K.length), asc);
        timeBArray10KDesc = bigBArray(Arrays.copyOf(baseArray10K, baseArray10K.length), asc);
        timeBArray100KDesc = bigBArray(Arrays.copyOf(baseArray100k, baseArray100k.length), asc);
        /*timeBArray1MDesc = bigBArray(Arrays.copyOf(baseArray1M, baseArray1M.length), asc);
        timeBArray10MDesc = bigBArray(Arrays.copyOf(baseArray10M, baseArray10M.length), asc);*/
    }

    public static void bigSArrayAsc() {
        boolean asc = true;
        timeSArray1KAsc = bigSArray(Arrays.copyOf(baseArray1K, baseArray1K.length), asc);
        timeSArray10KAsc = bigSArray(Arrays.copyOf(baseArray10K, baseArray10K.length), asc);
        timeSArray100KAsc = bigSArray(Arrays.copyOf(baseArray100k, baseArray100k.length), asc);
        /*timeSArray1MAsc = bigSArray(Arrays.copyOf(baseArray1M, baseArray1M.length), asc);
        timeSArray10MAsc = bigSArray(Arrays.copyOf(baseArray10M, baseArray10M.length), asc);*/
    }

    public static void bigSArrayDesc() {
        boolean asc = false;
        timeSArray1KDesc = bigSArray(Arrays.copyOf(baseArray1K, baseArray1K.length), asc);
        timeSArray10KDesc = bigSArray(Arrays.copyOf(baseArray10K, baseArray10K.length), asc);
        timeSArray100KDesc = bigSArray(Arrays.copyOf(baseArray100k, baseArray100k.length), asc);
        /*timeSArray1MDesc = bigSArray(Arrays.copyOf(baseArray1M, baseArray1M.length), asc);
        timeSArray10MDesc = bigSArray(Arrays.copyOf(baseArray10M, baseArray10M.length), asc);*/
    }
}
