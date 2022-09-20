import java.util.Arrays;
import java.util.Random;

public class Larik {
    public static void cetak(int[] array) {
        System.out.printf("%s%8s\n", "Index", "Value");
        for (int index = 0; index < array.length; index++) {
            System.out.printf("%5d%8d\n", index, array[index]);
        }
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
            min += space;
            array[i] = min;
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

    public static void selectionSort(int[] array, boolean ascending) {

        int factor = 1;
        if (!ascending) factor = -1;

        for (int i = 0; i < array.length - 1; i++) {
            int mIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] * factor < array[mIndex] * factor) {
                    mIndex = j;
                }
            }
            swap(array, mIndex, i);
        }
    }

    public static void bubbleSort(int[] array, boolean ascending) {

        int factor = 1;
        if(!ascending) factor = -1;

        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
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

}