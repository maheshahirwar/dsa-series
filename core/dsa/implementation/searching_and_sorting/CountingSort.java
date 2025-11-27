package core.dsa.implementation.searching_and_sorting;

import java.util.Arrays;

public class CountingSort implements SortingArray {

	@Override
	public void sort(int[] a) {
		int maxValue = Arrays.stream(a).max().getAsInt();
		int[] count = new int[maxValue + 1];
		for (int v : a)
			count[v]++;
		int i = 0, k = 0;
		while (i <= maxValue) {
			while (count[i]-- > 0)
				a[k++] = i;
			i++;
		}
	}

}
