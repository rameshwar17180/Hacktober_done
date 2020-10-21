package geeksforgeeks;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
public class Ram1 {
	public static void main(String[] args) throws IOException{
		/*dog a=new dog();
		dog b=a;
		a.name="cat";
		System.out.println(b.name);*/
		Scanner sc=new Scanner(System.in);
		Reader.init(System.in);
		int t=Reader.nextInt();
		for(int i=0;i<t;i++){
			int n=Reader.nextInt();
			int [] arr=new int[n];
			
			for(int j=0;j<n;j++){
				int k=Reader.nextInt();
				arr[j]=k;
			}
			
				long maxn=arr[0];
				long curr=arr[0];
				for(int i1=1;i1<n;i1++){
					curr=Math.max(arr[i1], arr[i1]+curr);
					maxn=Math.max(curr, maxn);
				}
				System.out.println(maxn);
			

		}
	}
}
class dog{
	String name="rat";
	void bark() {
		System.out.println("h");
	}
}
class a extends dog{
	void bark() {
		System.out.println("h1");
	}
}
class Reader {
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




