import echa.larik.Larik;

import java.util.Arrays;

public class MainW06 {
	public static void main(String[] args) {
		int[] array = Larik.generateArrayRandom(100, 0, 100);
		int[] array2 = Arrays.copyOf(array, array.length);
	}


}
