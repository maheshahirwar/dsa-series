package core.dsa.implementation.searching_and_sorting;

public class SearchingApplication {

	public static void main(String[] args) {

		System.out.println("......................START...................\n");
		int[] arr = { 7, 2, 9, 4, 3 };
		int target = 4;
		SearchElement searchElement = new LinearSearch();

		System.out.println("LinearSearch :: index = " + searchElement.search(arr, target));

		arr = new int[] { 1, 3, 4, 6, 8, 10, 12 };
		target = 8;
		searchElement = new BinarySearch();

		System.out.println("BinarySearch :: Index = " + searchElement.search(arr, target));

		System.out.println("\n......................END.....................");
	}

}
