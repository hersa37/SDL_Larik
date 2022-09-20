import java.util.Arrays;

public class SDL_W04 {

    public static long start, end;
    static int[] array = {5, 8, 26, 15, 11, 31};
    static int[] array1000 = Larik.generateArrayRandom(1000, 0, 1000);
    static int[] array10000 = Larik.generateArrayRandom(10000, 0, 10000);
    static int[] array100000 = Larik.generateArrayRandom(100000, 0, 100000);
    static int[] array1000000 = Larik.generateArrayRandom(1000000, 0, 1000000);
    static int[] array10000000 = Larik.generateArrayRandom(10000000, 0, 10000000);

    public static void main(String[] args) {

        System.out.println("Bubble ascending :");
        bubble(array, true, "array");
        bubble(array1000, true, "array1000");
        bubble(array10000, true, "array10000");
        System.out.println("Bubble desc : ");
        bubble(array, false, "array");
        bubble(array1000, false, "array1000");
        bubble(array10000, false, "array10000");

        System.out.println("\nSelection ascending : ");
        selection(array, true, "array");
        selection(array1000, true, "array1000");
        selection(array10000, true, "array10000");
        System.out.println("Selection descending : ");
        selection(array, false, "array");
        selection(array1000, false, "array1000");
        selection(array10000, false, "array10000");

    }


    public static void bubble(int[] array, boolean isAscending, String arrayName) {
        int[] bArray = Arrays.copyOf(array, array.length);
        long start = System.nanoTime();
        Larik.bubbleSort(bArray, isAscending);
        long end = System.nanoTime();
        System.out.printf("%15s% time : %s%");
    }

    public static void selection(int[] array, boolean isAscending, String arrayName) {
        int[] sArray = Arrays.copyOf(array, array.length);
        long start = System.nanoTime();
        Larik.selectionSort(sArray, isAscending);
        long end = System.nanoTime();
        System.out.println(arrayName + " time \t: " + time(start, end) + "s");
    }

    public static String time(long start, long end) {
        return String.format("%10.10f", ((double)end - (double)start)/1000000000);
    }

}
