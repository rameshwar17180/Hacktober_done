package codechef;
import java.util.*;
import java.io.*;
public class Equal {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(reader.readLine().trim());
		for(int i=0;i<t;i++) {
			String[] nk=reader.readLine().trim().split("\\s+");
			int n=Integer.parseInt(nk[0]);
			int k=Integer.parseInt(nk[1]);
			HashMap<Integer,Integer> map=new HashMap<>();
			ArrayList<Integer> map1=new ArrayList<>();
			ArrayList<Integer> map2=new ArrayList<>();
			
			int values=0;
			int values1=0;
			int mand=n/k;
			int mand1=n%k;
			//int count=mand1;
			int[] arr=new int[mand1];
			int index=0;
			String[] inp=reader.readLine().trim().split("\\s+");
			for(int j=0;j<n;j++) {
				int v=Integer.parseInt(inp[j]);
				if(map.containsKey(v)) {
					int val=map.get(v);
					map.put(v, val+1);
					if(mand1!=0 && map.get(v)%(mand+1)==0 && values1<mand1){
						//System.out.println("hi1"+" "+map.get(v));
						values1++;
						map2.add(v);
						map.remove(v);
						//System.out.println(map1.contains(v));
						map1.remove(new Integer(v));
					}
					else if(map.get(v)%mand==0) {
						//System.out.println("hi"+" "+map.get(v));
						values++;
						map1.add(v);
					}
					
					//System.out.println(values+" "+v);
				}
				else {
					map.put(v,1);
					if(map.get(v)%mand==0) {
						map1.add(v);
						values++;
					}
					if(mand1!=0 && map.get(v)%(mand+1)==0 && values1<mand1){
						values1++;
						map.remove(v);
						map1.remove(new Integer(v));
						map2.add(v);
					}
				}
				
				
			}
			int[] ans=new int[n];
			int cur=0;
			if(values<k) System.out.println("NO");
			else if(values1<mand1) System.out.println("NO");
			else {
				System.out.println("YES");
				Iterator<Integer> i1=map2.iterator();
				while(i1.hasNext()) {
					int pp=i1.next();
					for(int j=cur;j<n;j+=k) {
						ans[j]=pp;
					}
					cur++;
				}
				Iterator<Integer> i2=map1.iterator();
				while(i2.hasNext()) {
					int pp=i2.next();
					for(int j=cur;j<n;j+=k) {
						ans[j]=pp;
					}
					cur++;
				}
				for(int j=0;j<n;j++) {
					System.out.print(ans[j]+" ");
				}
				System.out.println();
			}
			
			}
			
	}
}
