package leetcode;

import java.io.*;
import java.util.*;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.*;
import java.lang.*;
import java.io.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

public class Solution {
    public static void main(String[] args) throws Exception{
    	Scanner sc=new Scanner(System.in);
    	System.out.println(gcd(10,5));
    	/*solution1 s=new solution1();
    	
    	s.main(arf);*/
    	int [] myarr=new int[] {1,2,4};
    	System.out.println(Arrays.binarySearch(myarr, 3));
    	String arf[]= {"a","g"};
    	GFG d=new GFG();
    	d.main(arf);
    	int t=sc.nextInt();
    	for(int i=0;i<t;i++) {
    		int n=sc.nextInt();int k=sc.nextInt();
    		int[] arr=new int[n];
    		int count=1;
    		for(int j=0;j<n;j++) {
    			arr[j]=sc.nextInt();
    		}
    		if(k==0) {
    			System.out.println(1);
    			continue;
    		}
    		Arrays.sort(arr);
    		if(arr[0]==arr[k-1] && k-1!=0) {
    			for(int j=k-1;j<n-1;j++) {
        			if(arr[j]==arr[j+1]) count++;
        			else {
        				break;
        			}
        		}
    			count=(count*(count+1)/2);
    			System.out.println(count);
    		}
    		else {
    		for(int j=k-1;j<n-1;j++) {
    			if(arr[j]==arr[j+1]) count++;
    			else {
    				break;
    			}
    		}
    		System.out.println(count);
    		}
    	}
    }
    public static int gcd(int a,int b) {
    	if(a==0) return b;
    	return gcd(b%a,a);
    }
    public static String delete(String s,int i){
        if(i<s.length()-1)
            return s.substring(0,i)+s.substring(i+1,s.length());
        else{
            return s.substring(0,i);
        }
    }
}
class solution1{
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println(fib(50));
		int t=sc.nextInt();
	}
	static long fib(long n) { 
		double phi = (1 + Math.sqrt(5)) / 2; 
		return (long) Math.round(Math.pow(phi, n)  
		                        / Math.sqrt(5)); 
		} 
}
class DetectCycle
{
    int[] arr;
    int count=0;
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
      DetectCycle c=new DetectCycle();
      c.arr=new int[V];
      Arrays.fill(c.arr, 0);
      c.dfs(list, V);
      if(c.count==1) return true;
      else return false;
    }
    void dfs(ArrayList<ArrayList<Integer>> list, int V){
    	for(int i=0;i<V;i++) {
    		if(arr[i]==0) {
    			dfsvisit(list, i,-1);	
    		}
    	}
    }
    void dfsvisit(ArrayList<ArrayList<Integer>> list, int V,int parent){
        ArrayList<Integer> k=list.get(V);
        arr[V]=1;
        Iterator it=k.iterator();
        int pk=0;
        while(it.hasNext()){
        	int p=(int)it.next();
        	//System.out.println(p);
            if(arr[p]==0){
                arr[p]=1;
                dfsvisit(list,p,V);
            }
            else if(arr[p]==1 && p!=parent) {
            	//if(count==0) System.out.println(p);
            	count=1;
            }
            if(p==parent) pk++;
            if(pk==2) count=1;
        }
        arr[V]=2;
        //System.out.println(count);
    }
    void print(int[] arr) {
    	for(int i:arr) {
    		System.out.print(" "+i+" ");
    	}
    }
}
class driver{
public static void main (String[] args) throws IOException{
    BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
    String[] inp=reader.readLine().trim().split("\\s+");
    int n=Integer.parseInt(inp[0]);int m=Integer.parseInt(inp[1]);
    int[] arr=new int[n];
    int[] size=new int[n];Arrays.fill(size,1);
    Arrays.fill(arr, -1);
    for(int i=0;i<m;i++) {
    	String[] inpa=reader.readLine().trim().split("\\s+");
    	int root=find(Integer.parseInt(inpa[0])-1,arr);
    	int root1=find(Integer.parseInt(inpa[1])-1,arr);
    	if(root!=root1) {
    		union(arr,size,root,root1);
    	}
    	print(size);
    }
    
  }
	static void print(int[] arr) {
		int[] p=new int[arr.length];
		for(int i=0;i<p.length;i++) {
			p[i]=arr[i];
		}
		Arrays.sort(p);
		for(int k:p) {
			if(k!=0) {
				System.out.print(k+" ");
			}
		}
		System.out.println();
	}
	static int find(int root,int[] arr) {
		if(arr[root]<0) return root;
		else return find(arr[root],arr);
	}
	static void union(int[] arr,int[] size,int root1,int root2) {
		arr[root1]=root2;
		size[root2]+=size[root1];
		size[root1]=0;
	}
}

/*package whatever //do not write package name here */



/*import java.io.*;
import java.util.*;
import java.io.*;
import java.math.*;*/
class GFG {
    int[] visit;int[] parent;int[] disc;int time;int[] low;int count;int visited;int count1;int count2;
	public static void main (String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(System.out));
		int t=Integer.parseInt(reader.readLine().trim());
		for(int i=0;i<t;i++){
		    String[] inpa=reader.readLine().trim().split("\\s+");
		    int n=Integer.parseInt(inpa[0]);
		    int e=Integer.parseInt(inpa[1]);
		    ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		    for(int j=0;j<n;j++){
		        list.add(new ArrayList<>());
		    }
		    //System.out.println(list.size());
		    for(int j=0;j<e;j++){
		    	String[] in=reader.readLine().trim().split("\\s+");
		        int u=Integer.parseInt(in[0]);
		        int v=Integer.parseInt(in[1]);
		        list.get(u-1).add(v-1);
		        list.get(v-1).add(u-1);
		    }
		    GFG g=new GFG();
		    g.visit=new int[n];
		    g.parent=new int[n];
		    g.visit=new int[n];
		    g.low=new int[n];
		    g.disc=new int[n];
		    g.count=0;
		    g.count1=0;
		    g.count2=0;
		    
		    g.visited=0;
		    g.time=0;
		    
		    Arrays.fill(g.parent,-1);Arrays.fill(g.low, 0);Arrays.fill(g.visit, 0);Arrays.fill(g.disc, 0);
		    /*for(int j=0;j<g.parent.length;j++) {
		    	g.parent[j]=-1;
		    }*/
		    //System.out.println(g.parent[0]);
		    g.dfs(list,n,new Stack<edge>());
		   if(g.count>1) {
			   System.out.println("NO"+g.count);
		   }
		   else {
			   System.out.println("YES");
		   }
		   	//System.out.println(g.count2+" "+g.count1);
		    
		}
		writer.close();
	}
	void dfs(ArrayList<ArrayList<Integer>> list,int i,Stack<edge> e) {
		for(int i1=0;i1<i;i1++) {
			if(visit[i1]==0) {
				dfsvisit(list,i1,e);
				int pp=0;
				HashSet<Integer> set=new HashSet<>();
				while(!e.isEmpty()) {
					edge kk=e.pop();
					if(!set.contains(kk.pointa)) {
						pp++;
						set.add(kk.pointa);
					}
					if(!set.contains(kk.pointb)) {
						pp++;
						set.add(kk.pointb);
					}
				}
				if(pp>0 && pp%2==0) count1++;
				else if(pp>0 && pp%2!=0) count2++;
			}
		}
	}
	void dfsvisit(ArrayList<ArrayList<Integer>> list,int i,Stack<edge> e){
	    visit[i]=1;
	    int child=0;
	    visited++;
	    low[i]=disc[i]=++time;
	    //System.out.println(i+" "+parent[i]);
	    for(int j=0;j<list.get(i).size();j++){
	        int v=list.get(i).get(j);
	        if(visit[v]!=1){
	        	e.push(new edge(i,v));
	            parent[v]=i;
	            //System.out.println(v+" "+i);
	            child++;
	            dfsvisit(list,v,e);
	            low[i]=Math.min(low[i],low[v]);
	            
	        if(parent[i]!=-1 && disc[i]<=low[v]) {
	        	count++;
	        	int pp=0;
	        	HashSet<Integer> set=new HashSet<>();
	        	//System.out.println(i);
	        	while(!e.isEmpty()) {
	        		if(e.peek().pointa==i && e.peek().pointb==v) {
	        			edge kk=e.pop();
						if(!set.contains(kk.pointa)) {
							pp++;
							set.add(kk.pointa);
						}
						if(!set.contains(kk.pointb)) {
							pp++;
							set.add(kk.pointb);
						}
	        			break;
	        		}
	        		edge kk=e.pop();
					if(!set.contains(kk.pointa)) {
						pp++;
						set.add(kk.pointa);
					}
					if(!set.contains(kk.pointb)) {
						pp++;
						set.add(kk.pointb);
					}
	        	}
	        	if(pp%2==0) count1++;
	        	else count2++;
	        	//System.out.println("hi"+" "+parent[i]+" "+i+" "+disc[i]+" "+low[i]);
	        }
	        if(parent[i]==-1 && child>1) {
	        	//System.out.println("hi1");
	        	count++;
	        	int pp=0;
	        	HashSet<Integer> set=new HashSet<>();
	        	//System.out.println(i);
	        	while(!e.isEmpty()) {
	        		if(e.peek().pointa==i && e.peek().pointb==v) {
	        			edge kk=e.pop();
						if(!set.contains(kk.pointa)) {
							pp++;
							set.add(kk.pointa);
						}
						if(!set.contains(kk.pointb)) {
							pp++;
							set.add(kk.pointb);
						}
	        			break;
	        		}
	        		edge kk=e.pop();
					if(!set.contains(kk.pointa)) {
						pp++;
						set.add(kk.pointa);
					}
					if(!set.contains(kk.pointb)) {
						pp++;
						set.add(kk.pointb);
					}
	        	}
	        	if(pp%2==0) count1++;
	        	else count2++;
	        }
	        }
	        else if(parent[i]!=v && low[i]>disc[v]){
	            low[i]=Math.min(low[i],low[v]);
	            e.push(new edge(i,v));
	        }
	    }
	}
}
class edge{
	int pointa;
	int pointb;
	edge(int a,int b){
		pointa=a;
		pointb=b;
	}
}

