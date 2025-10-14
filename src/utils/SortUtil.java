package utils;

import shapes.Shape;
import java.util.Comparator;
import java.util.Arrays;
/**
 * utility class for sorting shapes
 */

public class SortUtil 
{
	// Bubble Sort:
	public static void bubbleSort(Shape[] shapes, Comparator<Shape> comparator) {
		int n = shapes.length;
		boolean swapped;
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - 1 - i; j++) {
				if (comparator.compare(shapes[j], shapes[j + 1]) > 0) {
					// Swap shapes[j] and shapes[j + 1]
					Shape temp = shapes[j];
					shapes[j] = shapes[j + 1];
					shapes[j + 1] = temp;
					swapped = true;
				}
			}
			// If no two elements were swapped in the inner loop, then break
			if (!swapped) break; // array is sorted
		}
	}
	
	//Insertion Sort:
	public static void insertionSort(Shape[] shapes, Comparator<Shape> comparator) {
		int n = shapes.length;
		for (int i = 1; i < n; i++) {
			Shape key = shapes[i];
			int j = i - 1;
			// Move elements of shapes[0..i-1], that are greater than key,
			// to one position ahead of their current position
			while (j >= 0 && comparator.compare(shapes[j], key) > 0) {
				shapes[j + 1] = shapes[j];
				j = j - 1;
			}
			shapes[j + 1] = key;
		}
	}
	
	
	// Selection Sort:
	public static void selectionSort(Shape[] shapes, Comparator<Shape> comparator) {
		int n = shapes.length;
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in the unsorted array
			int minIdx = i;
			for (int j = i + 1; j < n; j++) {
				if (comparator.compare(shapes[j], shapes[minIdx]) < 0) {
					minIdx = j;
				}
			}
			// Swap the found minimum element with the first element
			Shape temp = shapes[minIdx];
			shapes[minIdx] = shapes[i];
			shapes[i] = temp;
		}
	}
	
	
	// Merge Sort:
	
	
	
	// Quick Sort:
	
	
	
	// Heap Sort (choice):
	public static void heapSort(Shape[] shapes, Comparator<Shape> comparator) {
		int n = shapes.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(shapes, n, i, comparator);
		}

		// One by one extract an element from heap
		for (int i = n - 1; i > 0; i--) {
			// Move current root to end
			Shape temp = shapes[0];
			shapes[0] = shapes[i];
			shapes[i] = temp;

			// call max heapify on the reduced heap
			heapify(shapes, i, 0, comparator);
		}
	}
	
	public static void heapify(Shape[] shapes, int n, int i, Comparator<Shape> comparator) {
		int largest = i; // Initialize largest as root
		int left = 2 * i + 1; // left = 2*i + 1
		int right = 2 * i + 2; // right = 2*i + 2

		// If left is larger than root
		if (left < n && comparator.compare(shapes[left], shapes[largest]) > 0) {
			largest = left;
		}

		// If right is larger than largest so far
		if (right < n && comparator.compare(shapes[right], shapes[largest]) > 0) {
			largest = right;
		}

		// If largest is not root
		if (largest != i) {
			Shape swap = shapes[i];
			shapes[i] = shapes[largest];
			shapes[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(shapes, n, largest, comparator);
		}
	}
}
