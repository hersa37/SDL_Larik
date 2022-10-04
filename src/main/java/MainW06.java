import larik.Larik;

public class MainW06 {
    public static void main(String[] args) {
        int[] array = Larik.generateArrayRandom(100, 0, 100);
        Larik.cetak(array);
        Larik.mergeSort(array, 0, 99);
        Larik.cetak(array);
    }


}
