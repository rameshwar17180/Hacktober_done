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
