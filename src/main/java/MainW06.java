import echa.larik.Larik;

import java.util.Arrays;

public class MainW06 {
	static int[] baseArray = {5, 8, 26, 15, 11, 31, 7, 40, 23, 25};
	static int[] base1k = Larik.generateArrayRandom(1000, 0, 2000);
	static int[] base10k = Larik.generateArrayRandom(10000, 0, 20000);
	static int[] base100k = Larik.generateArrayRandom(100000, 0, 200000);
	static int[] base1m = Larik.generateArrayRandom(1000000, 0, 2000000);
	static int[] base10m = Larik.generateArrayRandom(10000000, 0, 20000000);

	public static void main(String[] args) {
		int[] arrayQuickSort;
		double timeQuick, timeQuick1k, timeQuick10k, timeQuick100k, timeQuick1m, timeQuick10m;
		arrayQuickSort = copy(baseArray);

		System.out.println("\nQuick Sort Ascend");
		System.out.println("Unsorted");
		//{5,8,26,15,11,31,7,40,23,25}
		Larik.cetak(baseArray);
		timeQuick = quickSortTime(arrayQuickSort);
		System.out.println("Sorted");
		Larik.cetak(arrayQuickSort);
		//Big arrays
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
		System.out.printf(timeFormat, "100k", timeQuick100k);
		System.out.printf(timeFormat, "1m", timeQuick1m);
		System.out.printf(timeFormat, "10m", timeQuick10m);


		System.out.println("\nQuick Sort Descend");

		double timeQuickDesc, timeQuick1kDesc, timeQuick10kDesc, timeQuick100kDesc, timeQuick1mDesc, timeQuick10mDesc;
		//{5,8,26,15,11,31,7,40,23,25}
		int[] arrayQuickSortDesc = copy(baseArray);
		System.out.println("Unsorted");
		Larik.cetak(baseArray);
		timeQuickDesc = quickSortTimeDesc(arrayQuickSortDesc);
		System.out.println("Sorted");
		Larik.cetak(arrayQuickSortDesc);
		//BigArrays
		timeQuick1kDesc = quickSortTimeDesc(copy(base1k));
		timeQuick10kDesc = quickSortTimeDesc(copy(base10k));
		timeQuick100kDesc = quickSortTimeDesc(copy(base100k));
		timeQuick1mDesc = quickSortTimeDesc(copy(base1m));
		timeQuick10mDesc = quickSortTimeDesc(copy(base10m));

		System.out.printf("\n%5s | %5s\n", "Size", "Waktu");
		System.out.println("----------------------------");
		System.out.printf(timeFormat, "Base", timeQuickDesc);
		System.out.printf(timeFormat, "1k", timeQuick1kDesc);
		System.out.printf(timeFormat, "10k", timeQuick10kDesc);
		System.out.printf(timeFormat, "100k", timeQuick100kDesc);
		System.out.printf(timeFormat, "1m", timeQuick1mDesc);
		System.out.printf(timeFormat, "10m", timeQuick10mDesc);

		double timeMerge, timeMerge1k, timeMerge10k, timeMerge100k, timeMerge1m, timeMerge10m;
		int[] arrayMerge = copy(baseArray);

		System.out.println("\nMerge Sort Ascend");
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
		System.out.printf(timeFormat, "100k", timeMerge100k);
		System.out.printf(timeFormat, "1m", timeMerge1m);
		System.out.printf(timeFormat, "10m", timeMerge10m);

		double timeBubble, timeSelection, timeInsertion;
		long start = System.nanoTime();
		Larik.bubbleSort(copy(base1m), true);
		long end = System.nanoTime();
		timeBubble = time(start, end);

		start = System.nanoTime();
		Larik.selectionSort(copy(base1m), true);
		end = System.nanoTime();
		timeSelection = time(start, end);

		start = System.nanoTime();
		Larik.insertionSort(copy(base1m));
		end = System.nanoTime();
		timeInsertion = time(start, end);

		String format = "%10s | %5.10f s\n";
		System.out.printf("\n%10s | %5s", "Algo", "Waktu");
		System.out.printf(format, "Bubble", timeBubble);
		System.out.printf(format, "Selection", timeSelection);
		System.out.printf(format, "Insertion", timeInsertion);
		System.out.printf(format, "Quick", timeQuick1m);
		System.out.printf(format, "Merge", timeMerge1m);


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

	public static double quickSortTimeDesc(int[] array) {
		long start = System.nanoTime();
		Larik.quickSortDesc(array);
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
