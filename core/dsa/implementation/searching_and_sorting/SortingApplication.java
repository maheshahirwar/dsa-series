package core.dsa.implementation.searching_and_sorting;

import java.util.Arrays;

public class SortingApplication {

	public static void main(String[] args) {

		System.out.println("......................START...................\n");
		int[] arr = { 5, 2, 9, 1 };
		SortingArray sortingArray = new BubbleSort();
		System.out.println("=================Bubble Sort==================\n");
		System.out.println("Before sorting : " + Arrays.toString(arr));
		sortingArray.sort(arr);
		System.out.println("After sorting : " + Arrays.toString(arr));

		arr = new int[] { 64, 25, 12, 22, 11 };
		sortingArray = new SelectionSort();
		System.out.println("\n==================Selection Sort==============\n");
		System.out.println("Before sorting : " + Arrays.toString(arr));
		sortingArray.sort(arr);
		System.out.println("After sorting : " + Arrays.toString(arr));

		arr = new int[] { 8, 3, 5, 4 };
		sortingArray = new InsertionSort();
		System.out.println("\n==================Insertion Sort==============\n");
		System.out.println("Before sorting : " + Arrays.toString(arr));
		sortingArray.sort(arr);
		System.out.println("After sorting : " + Arrays.toString(arr));

		arr = new int[] { 38, 27, 43, 3, 9, 82, 10 };
		sortingArray = new MergeSort();
		System.out.println("\n===================Merge Sort=================\n");
		System.out.println("Before sorting : " + Arrays.toString(arr));
		sortingArray.sort(arr);
		System.out.println("After sorting : " + Arrays.toString(arr));

		arr = new int[] { 9, 3, 4, 2, 7, 10, 5 };
		sortingArray = new QuickSort();
		System.out.println("\n===================Quick Sort=================\n");
		System.out.println("Before sorting : " + Arrays.toString(arr));
		sortingArray.sort(arr);
		System.out.println("After sorting : " + Arrays.toString(arr));

		arr = new int[] { 4, 10, 3, 5, 1 };
		sortingArray = new HeapSort();
		System.out.println("\n===================Heap Sort==================\n");
		System.out.println("Before sorting : " + Arrays.toString(arr));
		sortingArray.sort(arr);
		System.out.println("After sorting : " + Arrays.toString(arr));

		arr = new int[] { 4, 2, 2, 8, 3, 3, 1 };
		sortingArray = new CountingSort();
		System.out.println("\n==================Counting Sort===============\n");
		System.out.println("Before sorting : " + Arrays.toString(arr));
		sortingArray.sort(arr);
		System.out.println("After sorting : " + Arrays.toString(arr));
		System.out.println("\n......................END......................");
	}

}
