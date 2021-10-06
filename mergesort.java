package Algorithms;

import java.util.*;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = new int[] { 490, -45, 3, 40, 250, 3, 2, 79, -42, 400 };
        // merge(0, arr.length - 1, , arr);
        quickSort(arr);
        printArr(arr);
        int[] a=new int[]{1, 1, 0, 0, 1, 1};
        System.out.println(solve(a, 1));
        
    }
   

    
    public static void mergeSort(int[] arr) {
        mergeSortUtil(arr, 0, arr.length - 1);
    }

    public static void mergeSortUtil(int[] arr, int lo, int hi) {
        if (lo == hi || lo > hi)
            return;
        int mid = lo + (hi - lo) / 2;
        mergeSortUtil(arr, lo, mid);
        mergeSortUtil(arr, mid + 1, hi);
        merge(lo, hi, mid, arr);
    }

    public static void mergeSortIterative(int[] arr) {
        int n = arr.length;
        for (int size = 1; size < n; size *= 2) {
            for (int lo = 0; lo < n - size; lo += 2 * size) {
                merge(lo, Math.min(lo + size + size - 1, n - 1), lo + size - 1, arr);
            }
        }
    }

    public static void merge(int lo, int hi, int mid, int[] arr) {
        int[] left = new int[mid - lo + 1];
        int[] right = new int[hi - mid];
        for (int i = 0; i < mid - lo + 1; i++) {
            left[i] = arr[lo + i];
        }
        for (int i = 0; i < hi - mid; i++) {
            right[i] = arr[mid + i + 1];
        }
        int k = lo;
        int l = 0;
        int h = 0;
        while (l <= mid - lo && h < hi - mid) {
            if (left[l] <= right[h]) {
                arr[k] = left[l];
                k++;
                l++;
            } else {
                arr[k] = right[h];
                k++;
                h++;
            }
        }
        while (l <= mid - lo) {
            arr[k] = left[l];
            k++;
            l++;
        }
        while (h < hi - mid) {
            arr[k] = right[h];
            k++;
            h++;
        }
    }

}
