public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                } else
                    break;
            }
            arr[j + 1] = key;
        }
    }
 public static void quickSort(int[] arr) {
        quickSortUtil(arr, 0, arr.length - 1);
    }

    public static void quickSortUtil(int[] arr, int lo, int hi) {
        if (lo >= hi)
            return;
        int partition = partitionUtil(arr, lo, hi);
        if (partition - 1 > lo)
            quickSortUtil(arr, lo, partition - 1);
        if (partition + 1 < hi)
            quickSortUtil(arr, partition + 1, hi);
    }

    public static int partitionUtil(int[] arr, int lo, int hi) {
        int pivot = lo;
        lo++;
        while (lo <= hi) {
            while (lo <= hi && arr[pivot] >= arr[lo])
                lo++;
            while (arr[pivot] < arr[hi])
                hi--;
            if (hi > lo) {
                swap(arr, lo, hi);
            }
        }
        swap(arr, pivot, hi);
        return hi;
    }
