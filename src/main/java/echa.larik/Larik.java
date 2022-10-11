package echa.larik;

import java.util.Arrays;
import java.util.Random;

public class Larik {

	public static void cetak(int[] array) {
		String index = "Index :";
		String value = "Value :";
		for (int i = 0; i < array.length; i++) {
			index += String.format(" %4d", i);
			value += String.format(" %4d", array[i]);
		}
		System.out.println(index);
		System.out.println(value);
	}

	public static int sequentialSearch(int[] array, int key) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				return i;
			}
		}
		return -1;
	}


	public static int binarySearch(int[] array, int key) {
		int high = array.length - 1;
		return binaryRecursive(array, key, 0, high);
	}

	private static int binaryRecursive(int[] array, int key, int low, int high) {
		if (low > high) {
			return -1;
		} else {
			int mid = (low + high) / 2;
			if (key == array[mid]) {
				return mid;
			} else if (key > array[mid]) {
				return binaryRecursive(array, key, mid + 1, high);
			} else return binaryRecursive(array, key, low, mid - 1);
		}
	}

	public static int interpolationSearch(int[] array, int key) {
		int high = array.length - 1;
		return interpolationRecursive(array, key, 0, high);
	}

	private static int interpolationRecursive(int[] array, int key, int low, int high) {
		if (low > high) {
			return -1;
		} else {
			int mid = low + (((key - array[low]) * (high - low)) / (array[high] - array[low]));
			if (key == array[mid]) {
				return mid;
			} else if (key > array[mid]) {
				return interpolationRecursive(array, key, mid + 1, high);
			} else return interpolationRecursive(array, key, low, mid - 1);
		}
	}

	public static int[] generateArrayUniform(int length, int min, int space) {
		int[] array = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = min;
			min += space;
		}
		return array;
	}

	public static int[] generateArrayRandom(int length, int min, int max) {
		int[] array = new int[length];
		Random random = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(max - min) + min;
		}
		return array;
	}

	public static int[] randomizeArray(int[] array) {
		Random random = new Random();
		int[] arrayTemp = Arrays.copyOf(array, array.length);

		for (int i = arrayTemp.length - 1; i > 0; i--) {
			int index = random.nextInt(i + 1);
			int temp = arrayTemp[index];
			arrayTemp[index] = arrayTemp[i];
			arrayTemp[i] = temp;
		}
		return arrayTemp;
	}

	public static boolean checkSorted(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if ((array[i] > array[i + 1])) {
				return false;
			}
		}
		return true;
	}

	public static void selectionSort(int[] array, boolean isAscending) {

		int factor = 1;
		if (!isAscending) factor = -1;

		for (int i = 0; i < array.length - 1; i++) {
			int mIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if ((array[j] * factor) < (array[mIndex] * factor)) {
					mIndex = j;
				}
			}
			swap(array, mIndex, i);
		}
	}

	public static void bubbleSort(int[] array, boolean isAscending) {

		int factor = 1;
		if (!isAscending) factor = -1;

		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < array.length - i; j++) {
				if (array[j] * factor > array[j + 1] * factor) {
					swap(array, j, j + 1);
				}
			}
		}
	}

	public static void swap(int[] array, int firstIndex, int secondIndex) {
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}

	public static void bubbleComplex(int[] array, boolean isAscending) {
		int factor = 1;
		if (!isAscending) factor = -1;
		int tukar = 0;
		int compare = 0;
		System.out.println("-----------------------------------------------");
		for (int i = 1; i < array.length; i++) {
			System.out.println("Iterasi " + i);
			System.out.printf("%5s | %5s | %6s | %6s%n", "Count", "Key", "Compare", "Tukar");
			for (int j = 0; j < array.length - i; j++) {
				System.out.printf("%5s | %5d | %6d ", j + 1, array[j], array[j + 1]);
				compare++;
				if (array[j] * factor > array[j + 1] * factor) {
					swap(array, j, j + 1);
					tukar++;
					System.out.printf(" | %6s%n", "Ya");
				} else {
					System.out.printf(" | %6s%n", "Tidak");
				}
			}
			System.out.print("Array di akhir iterasi : ");
			for (int each : array) {
				System.out.print(each + " ");
			}
			System.out.println("\n");
		}
		System.out.println("Tukar total = " + tukar);
		System.out.println("Banding total = " + compare);
		System.out.println("-----------------------------------------------");
	}

	public static void selectionComplex(int[] array, boolean isAscending) {
		int factor = 1;
		String m = "Min";
		int compare = 0;
		int switching = 0;

		if (!isAscending) {
			factor = -1;
			m = "Max";
		}
		System.out.println("-----------------------------------------------");

		for (int i = 0; i < array.length - 1; i++) {
			int mIndex = i;
			int count = 1;

			System.out.println("Iterasi " + (i + 1));
			System.out.printf("%5s | %5s | %6s | %6s%n", "Count", "Key", "Compare", m);
			for (int j = i + 1; j < array.length; j++) {
				System.out.printf("%5s | %5d | %6d ", count++, array[mIndex], array[j]);
				compare++;
				System.out.printf(" | %6d%n", mIndex);
				if ((array[j] * factor) < (array[mIndex] * factor)) {
					mIndex = j;
				}

			}
			System.out.println("Index " + i + " ditukar dengan index " + mIndex);
			swap(array, mIndex, i);
			switching++;
			System.out.print("Array di akhir iterasi : ");
			for (int each : array) {
				System.out.print(each + " ");
			}
			System.out.println("\n");
		}
		System.out.println("Banding total\t: " + compare);
		System.out.println("Tukar total\t\t: " + switching);

		System.out.println("-----------------------------------------------");
	}

	public static void selectionComplexBig(int[] array, boolean isAscending) {
		int factor = 1;

		if (!isAscending) {
			factor = -1;
		}
		System.out.println("-----------------------------------------------");

		for (int i = 0; i < array.length - 1; i++) {
			int mIndex = i;
			int count = 1;

			System.out.println("\tIterasi " + (i + 1));
			for (int j = i + 1; j < array.length; j++) {
				if ((array[j] * factor) < (array[mIndex] * factor)) {
					mIndex = j;
				}

			}
			swap(array, mIndex, i);

		}

	}

	public static void insertionSort(int[] array, boolean isAscending) {
		int factor = 1;
		if (!isAscending) {
			factor = -1;
		}
		for (int i = 1; i < array.length; i++) {
			int key = array[i];
			int j = i - 1;

			while (j >= 0 && ((key) < (array[j]))) {
				array[j + 1] = array[j];
				j--;
			}

			array[j + 1] = key;
		}
	}

	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int key = array[i];
			int j = i - 1;
			while (j >= 0 && ((key) < (array[j]))) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}
	}

	public static void insertionComplex(int[] array, boolean isAscending) {
		int factor = 1;
		if (!isAscending) {
			factor = -1;
		}
		for (int i = 1; i < array.length; i++) {
			int key = array[i];
			int j = i - 1;
			System.out.println("Iterasi 1:");
			System.out.println((key) + " " + (array[j]));
			while (j >= 0 && (key * factor) < (array[j] * factor)) {
				array[j + 1] = array[j];
//                System.out.println(array);
				j--;
			}

			array[j + 1] = key;
		}
	}

	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int lowIndex, int highIndex) {
		if (lowIndex < highIndex) {
			int i = lowIndex + 1;
			int j = highIndex;

			while (i <= highIndex && array[i] <= array[lowIndex]) {
				i++;
			}
			while (j > lowIndex && array[j] > array[lowIndex]) {
				j--;
			}
			while (i < j) {
				swap(array, i, j);
				while (i <= highIndex && array[i] <= array[lowIndex]) {
					i++;
				}
				while (j > lowIndex && array[j] > array[lowIndex]) {
					j--;
				}
			}
			swap(array, lowIndex, j);
			quickSort(array, lowIndex, j - 1);
			quickSort(array, j + 1, highIndex);
		}
	}

	public static void quickSortDesc(int[] array) {
		quickSortDesc(array, 0, array.length - 1);
	}

	private static void quickSortDesc(int[] array, int lowIndex, int highIndex) {
		if (lowIndex < highIndex) {
			int i = lowIndex + 1;
			int j = highIndex;

			while (i <= highIndex && array[i] > array[lowIndex]) {
				i++;
			}
			while (j > lowIndex && array[j] <= array[lowIndex]) {
				j--;
			}
			while (i < j) {
				swap(array, i, j);
				while (i <= highIndex && array[i] > array[lowIndex]) {
					i++;
				}
				while (j > lowIndex && array[j] <= array[lowIndex]) {
					j--;
				}
			}
			swap(array, lowIndex, j);
			quickSortDesc(array, lowIndex, j - 1);
			quickSortDesc(array, j + 1, highIndex);
		}
	}

	public static void mergeSort(int[] array) {
		mergeSort(array, Arrays.copyOf(array, array.length), 0, array.length - 1);
	}

	private static void mergeSort(int[] array, int[] auxArray, int lowIndex, int highIndex) {
		if (highIndex <= lowIndex +10) {
			insertionSort(array, lowIndex, highIndex);
			return;
		}
		int mid = (highIndex + lowIndex) / 2;

		mergeSort(auxArray, array, lowIndex, mid);
		mergeSort(auxArray, array, mid + 1, highIndex);

		mergeArrays(auxArray, array, lowIndex, mid, highIndex);
	}

	private static void mergeArrays(int[] array, int[] auxArray, int lowIndex, int mid, int highIndex) {

		int i = lowIndex;
		int j = mid + 1;
		for (int x = lowIndex; x <= highIndex; x++) {
			if (i > mid) {
				auxArray[x] = array[j++];
			} else if (j > highIndex) {
				auxArray[x] = array[i++];
			} else if (array[j] < array[i]) {
				auxArray[x] = array[j++];
			} else {
				auxArray[x] = array[i++];
			}
		}
	}

	public static void insertionSort(int[] array, int lowIndex, int highIndex) {
		for (int i = lowIndex; i < highIndex; i++) {
			int key = array[i];
			int j = i - 1;
			while (j >= 0 && ((key) < (array[j]))) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}
	}


}