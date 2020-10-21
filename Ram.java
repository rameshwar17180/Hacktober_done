package geeksforgeeks;
import java.util.*;
public class Ram {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for (int i=0;i<t;i++) {
			int n=sc.nextInt();
			long s=sc.nextLong();
			long[] arr=new long[n];
			long sum=0;
			long[] pre=new long[n];
			int l=0;
			int c=0;
			//System.out.print(s+" "+n+" ");
			for(int j=0;j<n;j++) {
				long k=sc.nextInt();
				arr[j]=k;
				if(j==0) {
					pre[j]=k;
				}
				else {
					pre[j]=pre[j-1]+k;
				}
				sum+=k;
				if(sum==s && c==0) {
					System.out.println((l+1)+" "+(j+1));
					
					c=1;
				}
				else if(sum>s && c==0) {
					while(l<n && sum>s) {
						sum-=arr[l++];
					}
					if(sum==s) {
						System.out.println((l+1)+" "+(j+1));
						
						c=1;
					}
				}
				else {}
				
			}
			if(c==0) {
				System.out.println("-1");
			}
		}
	}
}
