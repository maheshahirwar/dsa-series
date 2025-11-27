package core.dsa.implementation.searching_and_sorting;

public class QuickSort implements SortingArray {

	@Override
	public void sort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	private static void quickSort(int[] a, int low, int high) {
		if (low >= high)
			return;
		int p = partition(a, low, high);
		quickSort(a, low, p - 1);
		quickSort(a, p + 1, high);
	}

	private static int partition(int[] a, int low, int high) {
		int pivot = a[high];
		int i = low;
		for (int j = low; j < high; j++) {
			if (a[j] <= pivot) {
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				i++;
			}
		}
		int tmp = a[i];
		a[i] = a[high];
		a[high] = tmp;
		return i;
	}

}
