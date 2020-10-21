
package codechef;
import java.io.*;
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

public class GFG {
    public static void main(String args[] ) throws IOException {
    	String arf[]= {"a","g"};
    	Driver_class d=new Driver_class();
    	System.out.print("hi");
    	//d.main(arf);
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] nm=reader.readLine().trim().split("\\s+");
        int n=Integer.parseInt(nm[0]);
        int m=Integer.parseInt(nm[1]);
        String[] inp=reader.readLine().trim().split("\\s+");
        ArrayList<Integer>[] count=new ArrayList[2*100000+11];
        for(int i=0;i<count.length;i++) {
        	count[i]=new ArrayList<Integer>();
        	//System.out.println(count[i].size());
        }
        for(int i=1;i<=n;i++) {
        	int k=Integer.parseInt(inp[i-1]);
        	int cur=0;
        	//System.out.print(count.get(k));
        	//count.get(k).add(cur);
        	count[k].add(cur);
        	while(k>0){
        		k/=2;
        		cur++;
        		count[k].add(cur);
        		//System.out.print(count[k].size()+" ");
        	}
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<count.length;i++) {
        	ArrayList<Integer> aa=count[i];
        	if(aa.size()<m) {
        		continue;
        	}
        	
        		Collections.sort(aa);
        		int sum=0;
        		for(int j=0;j<m;j++) {
        			sum+=(aa.get(j));
        		}
        		ans=Math.min(sum, ans);
        		//System.out.print(sum+" "+i+" ");
        	
        }
        System.out.println(ans);*/
    }
}
//Initial Template for Java
class Driver_class {
  
  
  public static void main(String args[])throws IOException
  {
      BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
      int t  =Integer.parseInt(read.readLine());
      while(t-- > 0)
      {
          String str[] = read.readLine().trim().split(" ");
          int V = Integer.parseInt(str[0]);
          int E = Integer.parseInt(str[1]);
          ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
          for(int i=0; i<V; i++) {
              ArrayList<Integer> temp = new ArrayList<>();
              for(int j = 0; j < V; j++)
                  temp.add(Integer.MAX_VALUE);
              graph.add(temp);
          }
          str = read.readLine().trim().split(" ");
          int k = 0;
          while(E-- > 0)
          {
              int u = Integer.parseInt(str[k++]);
              int v = Integer.parseInt(str[k++]);
              int w = Integer.parseInt(str[k++]);
              u--;
              v--;
              graph.get(u).set(v, w);
              graph.get(v).set(u, w);
          }
          System.out.println(new MST().spanningTree(V,E,graph));
      }
  }
}
/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class MST
{
	int [] parent;
	int[] dist;
	int[] done;
  static int spanningTree(int V, int E, ArrayList<ArrayList<Integer>> graph)
  {
	  MST one=new MST();
	  one.parent=new int[V];
	  one.dist=new int[V];
	  one.done=new int[V];
	  Arrays.fill(one.parent, -1);
	  Arrays.fill(one.dist, Integer.MAX_VALUE);
	  Arrays.fill(one.done, 0);
	  one.dist[0]=0;
	  for(int i=0;i<V-1;i++) {
		  
		  int ind=one.findmin(one);
		  one.done[ind]=1;
		  ArrayList<Integer> child=graph.get(ind);
		  for(int j=0;j<V;j++) {
			  //System.out.println(child.get(j)+"k");
			  if(child.get(j)!=Integer.MAX_VALUE && one.dist[j]>child.get(j) && one.done[j]==0) {
				  //System.out.println("ho"+" "+j);
				  one.dist[j]=child.get(j);
				  one.parent[j]=ind;
			  }
		  }
		  /*one.print(one.parent);
		  System.out.println();
		  one.print(one.dist);
		  System.out.println();*/
		  
	  }
	  int mi=0;
	  //one.print(one.dist);
	  for(int i=0;i<V;i++) {
		  mi+=one.dist[i];
	  }
	  return mi;
  }
  int findmin(MST one) {
	  int min=Integer.MAX_VALUE;
	  int minind=-1;
	  for(int i=0;i<dist.length;i++) {
		  if(done[i]==0 && dist[i]<min) {
			  min=dist[i];
			  minind=i;
		  }
	  }
	  return minind;
  }
  void print(int[] arr) {
  	for(int i:arr) {
  		System.out.print(" "+i+" ");
  	}
  }

}
