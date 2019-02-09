package sorting.algorithms;

import java.util.Arrays;

public class SortingUtil {
    // Bubble Sort
    public void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap two indices
                    arr[j] = arr[j] + arr[j + 1] - (arr[j + 1] = arr[j]);
                }
            }
        }
    }

    // Selection Sort
    public void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            // Current minimum index
            int minId = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minId] > arr[j]) {
                    minId = j;
                }
            }
            // Swap the current index with minIdx
            arr[i] = arr[i] + arr[minId] - (arr[minId] = arr[i]);
        }
    }

    // Insertion Sort
    public void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int currentValue = arr[i];
            int j = i;
            while (j >= 1 && arr[j - 1] > currentValue) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = currentValue;

        }
    }

    //Merge Sort
    public void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    // Merge two sorted arrays
    public void merge(int arr[], int left, int mid, int right) {
        int sz1 = mid - left + 1;
        int sz2 = right - mid;
        int temp1[] = new int[sz1];
        int temp2[] = new int[sz2];
        for (int i = 0; i < sz1; i++) {
            temp1[i] = arr[left + i];
        }
        for (int i = 0; i < sz2; i++) {
            temp2[i] = arr[mid + 1 + i];
        }
        int k = left;
        int i = 0, j = 0;
        while (i < sz1 && j < sz2) {
            if (temp1[i] <= temp2[j]) {
                arr[k] = temp1[i];
                i++;
            }
            else if (temp1[i] > temp2[j]) {
                arr[k] = temp2[j];
                j++;

            }
            k++;
        }
        while (i < sz1) {
            arr[k] = temp1[i];
            i++;
            k++;
        }
        while (j < sz2) {
            arr[k] = temp2[j];
            j++;
            k++;
        }
    }

    // Quick Sort
    public void quickSort(int arr[]) {

    }

    public static void main(String[] args) {
        SortingUtil sortUtil = new SortingUtil();
        int arr[] = {5,77,33,92,3,0,7};
        //sortUtil.bubbleSort(arr);
        //sortUtil.selectionSort(arr);
        //sortUtil.insertionSort(arr);
        sortUtil.mergeSort(arr,0,arr.length-1);
        sortUtil.printArray(arr);
    }

    public void printArray(int arr[]){
        Arrays.stream(arr).forEach(t -> System.out.print(t + " "));
    }
}
