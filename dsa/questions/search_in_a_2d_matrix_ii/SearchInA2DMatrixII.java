package dsa.questions.search_in_a_2d_matrix_ii;

import java.util.Arrays;

/**
 * Search in a 2D Matrix II
 * 
 * Approach: Binary Search TC: O(n log m) SC: O(1) where n is the number of rows
 * and m is the number of columns
 */
class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		for (int[] row : matrix) {
			if ((Arrays.binarySearch(row, target) >= 0))
				return true;
		}
		return false;
	}
}

/**
 * Search in a 2D Matrix II
 * 
 * Approach: Better Approach TC: O(n + m) SC: O(1) where n is the number of rows
 * and m is the number of columns
 */
class BetterSolution extends Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		int row = 0, col = cols - 1;

		while (row < rows && col >= 0) {
			if (matrix[row][col] == target) {
				return true;
			} else if (matrix[row][col] > target) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}
}

public class SearchInA2DMatrixII {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		int target = 5;
		boolean found = solution.searchMatrix(matrix, target);
		System.out.println("Target " + target + " found in matrix: " + found);

		BetterSolution betterSolution = new BetterSolution();
		target = 20;
		found = betterSolution.searchMatrix(matrix, target);
		System.out.println("Target " + target + " found in matrix: " + found);
	}

}
