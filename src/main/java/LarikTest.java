/*
import java.util.Arrays;

public class LarikTest {
    public static void main(String[] args) {
        int[] array = {5, 8, 26, 15, 11, 31};
        int[] array2 = Larik.generateArrayRandom(50,5,175);

        int key = 26;
        System.out.println("Larik acak: ");
        Larik.cetak(array);
        System.out.println("Key : " + key);
        System.out.println("Sequential: " + Larik.sequentialSearch(array, key));

        System.out.println("\n\nLarik urut:");
        Arrays.sort(array);
        Larik.cetak(array);
        System.out.println("Sequential: " + Larik.sequentialSearch(array, key));
        System.out.println("Binary: " + Larik.binarySearch(array, key));
        System.out.println("Interpolation: " + Larik.interpolationSearch(array, key));

        Larik.cetak(array2);
        */
/*System.out.println("\n\nSelection:");
        Larik.selectionSort(array2);
        Larik.cetak(array2);*//*


        */
/*System.out.println("\n\nBubble:");
        Larik.bubbleSort(array2, false);
        Larik.cetak(array2);*//*


        System.out.println("\n\nSelection: ");
        long startTime = System.nanoTime();
        Larik.selectionSort(array2, false);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime));
        Larik.cetak(array2);
    }
}*/
