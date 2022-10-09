import echa.larik.Larik;

import java.util.Arrays;

public class MainW06 {
	static int[] baseArray = {5,8,26,15,11,31,7,40,23,25};
	static int[] base1k = Larik.generateArrayRandom(1000, 0, 2000);
	static int[] base10k = Larik.generateArrayRandom(10000, 0, 20000);
	static int[] base100k = Larik.generateArrayRandom(100000, 0, 200000);
	static int[] base1m = Larik.generateArrayRandom(1000000, 0, 2000000);
	static int[] base10m = Larik.generateArrayRandom(10000000, 0, 20000000);

	public static void main(String[] args) {
		int[] arrayQuickSort;
		double timeQuick, timeQuick1k, timeQuick10k, timeQuick100k, timeQuick1m, timeQuick10m;
		arrayQuickSort = copy(baseArray);
		//{5,8,26,15,11,31,7,40,23,25}
		Larik.cetak(baseArray);
		timeQuick = quickSortTime(arrayQuickSort);
		Larik.cetak(arrayQuickSort);

		timeQuick1k = quickSortTime(copy(base1k));
		timeQuick10k = quickSortTime(copy(base10k));
		timeQuick100k = quickSortTime(copy(base100k));
		timeQuick1m = quickSortTime(copy(base1m));
		timeQuick10m = quickSortTime(copy(base10m));

		String timeFormat = "%5s | %5.10f s\n";
		System.out.printf("\n%5s | %5s\n", "Size", "Waktu");
		System.out.println("----------------------------");
		System.out.printf(timeFormat, "Base", timeQuick);
		System.out.printf(timeFormat, "1k", timeQuick1k);
		System.out.printf(timeFormat, "10k", timeQuick10k);
		System.out.printf(timeFormat, "100k",timeQuick100k);
		System.out.printf(timeFormat, "1m", timeQuick1m);
		System.out.printf(timeFormat,"10m",timeQuick10m);

		double timeMerge, timeMerge1k, timeMerge10k, timeMerge100k, timeMerge1m, timeMerge10m;
		int[] arrayMerge = copy(baseArray);

		System.out.println("merge sort");
		timeMerge = mergeSortTime(copy(arrayMerge));
		timeMerge1k = mergeSortTime(copy(base1k));
		timeMerge10k = mergeSortTime(copy(base10k));
		timeMerge100k = mergeSortTime(copy(base100k));
		timeMerge1m = mergeSortTime(copy(base1m));
		timeMerge10m = mergeSortTime(copy(base10m));

		Larik.mergeSort(arrayMerge);
		Larik.cetak(arrayMerge);
		System.out.printf("\n%5s | %5s\n", "Size", "Waktu");
		System.out.println("----------------------------");
		System.out.printf(timeFormat, "Base", timeMerge);
		System.out.printf(timeFormat, "1k", timeMerge1k);
		System.out.printf(timeFormat, "10k", timeMerge10k);
		System.out.printf(timeFormat, "100k",timeMerge100k);
		System.out.printf(timeFormat, "1m", timeMerge1m);
		System.out.printf(timeFormat,"10m",timeMerge10m);

		double timeBubble, timeInsertion;



	}

	public static int[] copy(int[] array) {
		return Arrays.copyOf(array, array.length);
	}

	public static double quickSortTime(int[] array) {
		long start = System.nanoTime();
		Larik.quickSort(array);
		long end = System.nanoTime();
		return time(start, end);
	}

	public static double mergeSortTime(int[] array) {
		long start = System.nanoTime();
		Larik.mergeSort(array);
		long end = System.nanoTime();
		return time(start, end);
	}

	public static double time(long start, long end) {
		return (((double) end - (double) start) / 1000000000);
	}


}
