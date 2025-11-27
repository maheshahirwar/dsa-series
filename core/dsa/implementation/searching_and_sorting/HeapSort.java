package core.dsa.implementation.searching_and_sorting;

public class HeapSort implements SortingArray {

	@Override
	public void sort(int[] a) {
		int n = a.length;
		// build max heap
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(a, n, i);
		// extract elements
		for (int i = n - 1; i > 0; i--) {
			int tmp = a[0];
			a[0] = a[i];
			a[i] = tmp;
			heapify(a, i, 0);
		}
	}

	private void heapify(int[] a, int n, int i) {
		int largest = i;
		int l = 2 * i + 1, r = 2 * i + 2;
		if (l < n && a[l] > a[largest])
			largest = l;
		if (r < n && a[r] > a[largest])
			largest = r;
		if (largest != i) {
			int tmp = a[i];
			a[i] = a[largest];
			a[largest] = tmp;
			heapify(a, n, largest);
		}
	}

}
