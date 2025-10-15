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
	
	public static void mergeSort(Shape[] shapes, Comparator<Shape> comparator) {
		if(shapes == null || shapes.length < 2) return;
		Shape[] aux = new Shape[shapes.length];
		mergeSortHelper(shapes, aux, 0, shapes.length -1, comparator);
	}
	
	private static void mergeSortHelper(Shape[] arr, Shape[] aux, int left, int right, Comparator<Shape> comp) {
		if(left >= right) return;
		int mid = (right + left) /2;
		mergeSortHelper(arr, aux, left, mid, comp);
		mergeSortHelper(arr, aux, mid+ 1, right, comp);
		merge(arr, aux, left, mid, right, comp);
	}
	
	private static void merge(Shape[] arr, Shape[] aux, int left, int mid,int right, Comparator<Shape> comp) {
		// copy to auxiliary array
		for(int k = left; k <= right; k++) {
			aux[k] = arr[k];
		}
		int i = left;
		int j = mid + 1;
		int k = left;
		
		while(i < mid && j <= right) {
			if(comp.compare(aux[i], aux[j]) <= 0) {
				arr[k++] = aux[i++];
			} else {
				arr[k++] = aux[j++];
			}
		}
		// copy remaining left half (if any)
		while (i <= mid) {
			arr[k++] = aux [i++];
		}
		// Right half remaining (if any) are already in place
	}
	
	
	
	// Quick Sort:
	
	public static void quickSort(Shape[] shapes, Comparator<Shape> comparator) {
		if(shapes == null || shapes.length < 2) return;
		quickSortHelper(shapes, 0, shapes.length -1, comparator);
	}
	
	private static void quickSortHelper(Shape[] arr, int low, int high, Comparator<Shape> comp) {
		if(low < high) {
			int p = partition(arr, low, high, comp);
			quickSortHelper(arr, low, p -1, comp);
			quickSortHelper(arr, p + 1,high, comp);
		}
	}
	// lomuto partition using the last element as pivot
	
	private static int partition(Shape[] arr, int low, int high, Comparator <Shape> comp) {
		Shape pivot = arr[high];
		int i = low; // place for  swapping
		for(int j = low; j < high; j++) {
			if(comp.compare(arr[j], pivot) <= 0) {
				Shape tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
			}
		}
		
		Shape tmp = arr[i];
		arr[i] = arr[high];
		arr[high] = tmp;
		return i;
	}
	
	
	
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
