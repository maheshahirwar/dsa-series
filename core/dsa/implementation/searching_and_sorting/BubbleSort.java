package core.dsa.implementation.searching_and_sorting;

public class BubbleSort implements SortingArray {

	@Override
	public void sort(int[] a) {
		int n = a.length;
		boolean swapped;
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
					swapped = true;
				}
			}
			if (!swapped)
				break; // optimization
		}
	}

}
