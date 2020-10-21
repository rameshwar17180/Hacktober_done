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
	    }
	    int count=0;
	    for(int i=0;i<n;i++) {
	    	for(int j=0;j<m;j++) {
	    		arr[i][j]^=pos[i][j];
	    		pos[i][j+1]^=pos[i][j];
	    		pos[i+1][j+1]^=pos[i][j];
	    		pos[i+1][j]^=pos[i][j];
	    		if(arr[i][j]==0 && i+k<=n && j+k<=m) {
	    			arr[i][j]=1;
	    			pos[i][j]^=1;
	    			pos[i+1][j]^=1;
	    			pos[i][j+1]^=1;
	    			pos[i+1][j+1]^=1;
	    			pos[i+k][j]^=1;
	    			pos[i][j+k]^=1;
	    			pos[i+k][j+k]^=1;
	    			count+=1;
	    		}
	    		else if(arr[i][j]==0){
	    			count=-1;
	    			System.out.println(count);
	    			return;
	    		}
	    	}
	    }
	    System.out.println(count);
	}
}
