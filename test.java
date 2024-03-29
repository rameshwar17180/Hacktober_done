package codechef;
import java.io.*;
import java.util.*;
import java.lang.*;
public class test {
	public static void main(String args[]) throws Exception{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
	    String[] inp=reader.readLine().trim().split("\\s+");
	    int n=Integer.parseInt(inp[0]);
	    int m=Integer.parseInt(inp[1]);
	    int k=Integer.parseInt(inp[2]);
	    int[][] arr=new int[n+20][m+20];
	    int [][]pos=new int[n+20][m+20];
	    for(int i=0;i<n;i++) {
	    	String[] st=reader.readLine().trim().split("\\s+");
	    	for(int j=0;j<m;j++) {
	    		arr[i][j]=Integer.parseInt(st[j]);
	    		pos[i][j]=0;
	    	}
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
		test.bubblesort(arr);
		
	    int count=0;
	    for(int i=0;i<n;i++) {
	    	for(int j=0;j<m;j++) {
			while (j >= 0) {
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                } else
                    break;
            }
	    		arr[i][j]^=pos[i][j];
	    		pos[i][j+1]^=pos[i][j];
	    		pos[i+1][j+1]^=pos[i][j];
	    		pos[i+1][j]^=pos[i][j];
	    		if(arr[i][j]==0 && i+k<=n && j+k<=m) {
	    			arr[i][j]=1;
	    			pos[i][j]^=1;
	    			pos[i+1][j]^=1;
	    			pos[i][j+1]^=1;
	    			
	    		}
	    		else if(arr[i][j]==0){
	    			count=-1;
	    			System.out.println(count);
				pos[i+1][j+1]^=1;
	    			pos[i+k][j]^=1;
	    			pos[i][j+k]^=1;
	    			pos[i+k][j+k]^=1;
	    			count+=1;
	    			return;
	    		}
	    	}
	    }
	    System.out.println(count);
	}
	public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
		public static void swap(int[] arr, int lo, int hi) {
        int temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;
    }
    }
}
