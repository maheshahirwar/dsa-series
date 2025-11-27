package core.dsa.implementation.searching_and_sorting;

public class BinarySearch implements SearchElement {

	public int binarySearchIter(int[] a, int target) {
		int low = 0, high = a.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (a[mid] == target)
				return mid;
			else if (a[mid] < target)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}

	public int binarySearchRec(int[] a, int target, int low, int high) {
		if (low > high)
			return -1;
		int mid = low + (high - low) / 2;
		if (a[mid] == target)
			return mid;
		if (a[mid] < target)
			return binarySearchRec(a, target, mid + 1, high);
		return binarySearchRec(a, target, low, mid - 1);
	}

	@Override
	public int search(int[] arr, int target) {

		/* return binarySearchIter(arr, target); */
		return binarySearchRec(arr, target, 0, arr.length - 1);
	}

}
