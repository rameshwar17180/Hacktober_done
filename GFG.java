
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
package lab11ap;

class box {
	int length;
	int breadth;
	int height;
	box(){
		length=breadth=height=0;
	}
	box(int a,int b,int c){
		length=a;
		breadth=b;
		height=c;
	}
	box(int y){
		length=y;
		breadth=y;
		height=y;
	}
	void printvolume() {
		System.out.println(length*breadth*height);
	}
	public static void main(String args[]) {
		box b1=new box();
		b1.printvolume();
		box b2=new box(1,2,3);
		b2.printvolume();
		box b3=new box(4);
		b3.printvolume();
	}
}
class fibanacci {
	
	long[] fibo;
	int max_size=100;
	int curr_size;
	public int get() {
		return curr_size;
	}
	void generatesequence(int n) {
		fibo=new long[n];
		int k;
		if(n==1) {
			fibo[0]=0;
		}
		else {
			fibo[0]=0;
			fibo[1]=1;
		}
		k=max_size;
		
		if(n<=max_size) {
			k=n;
			curr_size=k;
		}
		else {
			k=max_size;
			curr_size=k;
		}
		fib(k);
	}
	void fib(int n) {
		
		for(int i=2;i<n;i++) {
			fibo[i]=(fibo[i-1]+fibo[i-2]);
		}
	}
	void displayseq() {
		for (int o=0;o<curr_size;o++) {
			//System.out.print(curr_size);
			System.out.print(fibo[o]+" ");
		}
			
		
	}
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("max size");
		int m=sc.nextInt();
		System.out.println("curr size");
		int k=sc.nextInt();
		fibanacci fib=new fibanacci();
		fib.max_size=m;
		fib.generatesequence(k);
		fib.displayseq();
		//System.out.print(fib.curr_size);
	}
}

class xyz {
	static int count=0;
	
	static char[] a3;
	static int n;
	public static void sum() {
		fin(0,n);
		}
	public static void fin(int w,int n) {
		
		if (n==1) {
				if((a3[0]=='O') || (a3[0]=='S') ||(a3[0]=='B')) {
					
				}
				else {
					count-=1;
				}
		}
		else {
			if (w==0) {
				if((a3[w]=='O') && ((a3[w+1]=='O') || (a3[w+1]=='S'))) {
					count+=1;
					fin(w+1,n);
				}
				else if ((a3[w]=='S') && (a3[w+1]=='S')) {
					count+=1;
					fin(w+1,n);
				}
				else if (a3[w]=='B'){
					count+=1;
					fin(w+1,n);
				}
				else
					return;
			}
			else if(w<n-1) {
				if((a3[w]=='O') && ((a3[w+1]=='O') || (a3[w+1]=='S')) && ((a3[w-1]=='B') || (a3[w-1]=='O'))) {
					count+=1;
					fin(w+1,n);
				}
				else if ((a3[w]=='S') && (a3[w+1]=='S')){
					count+=1;
					fin(w+1,n);
				}
				else if ((a3[w]=='B') && ((a3[w+1]=='B') || (a3[w+1]=='O') || (a3[w+1]=='S'))) {
					count+=1;
					fin(w+1,n);
				}
				else
					return;
				
				
			}
			else
				return;
		}
	}
	static class Reader {
	    static BufferedReader reader;
	    static StringTokenizer tokenizer;

	    /** call this method to initialize reader for InputStream */
	    static void init(InputStream input) {
	        reader = new BufferedReader(
	                     new InputStreamReader(input) );
	        tokenizer = new StringTokenizer("");
	    }

	    /** get next word */
	    static String next() throws IOException {
	        while ( ! tokenizer.hasMoreTokens() ) {
	            //TODO add check for eof if necessary
	            tokenizer = new StringTokenizer(
	                   reader.readLine() );
	        }
	        return tokenizer.nextToken();
	    }

	    static int nextInt() throws IOException {
	        return Integer.parseInt( next() );
	    }
		
	    static double nextDouble() throws IOException {
	        return Double.parseDouble( next() );
	    }
	}
	public static void main(String args[]) throws IOException {
		xyz f =new xyz();
		Reader.init(System.in);
		int c=Reader.nextInt();
		
		String[] y=new String[c];
		for (int i=0;i<c;i++) {
			f.count=0;
			String a2=Reader.next();
			f.a3=a2.toCharArray();
			f.n=a3.length;
			f.sum();
			if (f.count==(f.n-1))
				System.out.println("yes");
			else
				System.out.println("no");
		}
				
	}
	
}


