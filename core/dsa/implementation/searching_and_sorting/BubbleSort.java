package core.dsa.implementation.searching_and_sorting;

public class BubbleSort implements SortingArray {

	@Override
	public void sort(int[] a) {
		boolean swapped = false;

		for (int i = 0; i < a.length - 1; i++) {
			swapped = false;
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					// swap
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					swapped = true;
				}
			}
			// If no two elements were swapped by inner loop, then break
			if (!swapped) {
				break;
			}
		}
	}

}
