package searhing.algorithms;

import java.util.Arrays;

public class SearchingUtil {
    /**
     * Linear Search in Array of integers
     * returns the index(0 Based) of element or -1
     * Time Complexity O(n)
     */
    int linearSearch(int arr[],int searchValue){
        int idx = -1;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == searchValue){
                idx = i;
                break;
            }
        }
        return idx;
    }

    /**
     * Array Must Be Sorted to Apply Binary Search
     * Binary Search in Array of integers
     * returns the index(0 Based) of element or -1
     * Time Complexity O(log(n))
     */
    public int binarySearch(int arr[],int searchValue){
        int low = 0, high = arr.length-1;
        int mid;
        while (low < high){
            // It is same as (low + high)/2
            // To avoid over flow
            mid = low + (high-low)/2;
            if(arr[mid] == searchValue){
                return mid;
            }else if(arr[mid] > searchValue){
                high  = mid;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchingUtil searchUtil = new SearchingUtil();
        int arr[] = {1,7,3,8,28,26,34,0};
        System.out.println(searchUtil.linearSearch(arr,26));
        Arrays.sort(arr);
        System.out.println(searchUtil.binarySearch(arr,26));
    }
}
