package core.dsa.implementation.searching_and_sorting;

public class LinearSearch implements SearchElement {

	@Override
	public int search(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target)
				return i;
		}
		return -1;
	}

}
