package core.dsa.implementation.searching_and_sorting;

public class InsertionSort implements SortingArray {

	@Override
	public void sort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int key = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > key) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = key; // insert key at correct position
		}

	}

}
