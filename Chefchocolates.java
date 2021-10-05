package codechef;
import java.io.*;
import java.util.*;
import java.math.*;
public class Chefchocolates{
    public static void main(String[] args) throws IOException{
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(reader.readLine().trim());
        for(int i=0;i<t;i++){
            String n1=reader.readLine().trim();
            String k1=reader.readLine().trim();
            BigInteger n=new BigInteger(n1);
            BigInteger k=new BigInteger(k1);
            BigInteger two=new BigInteger("2");
            BigInteger result=new BigInteger("0");
            BigInteger one=new BigInteger("1");
            if(n.compareTo(k)==0){
             writer.write(result+"\n");
            }
            else if(k.compareTo(n)==-1){
                if(k.compareTo(n.subtract(k))==0){
                    result=(k.multiply(two)).subtract(one);
                }
                else{
                    BigInteger min=k.min(n.subtract(k));
              //System.out.println(min);
              result=min.multiply(two);
                }
              
              //System.out.println(min);
              writer.write(result+"\n");
            }
            else{
                BigInteger mm=k.mod(n);
                //System.out.println(mm);
                if(mm.compareTo(n.subtract(mm))==0){
                	//System.out.println(mm.multiply(two));
                    result=(mm.multiply(two)).subtract(one);
                    //System.out.println(result);
                }
                else{ 
                	BigInteger min=mm.min(n.subtract(mm));
                    result=min.multiply(two);
                }
               
               // System.out.println(min+"hi");
                writer.write(result+"\n");
            }
            }
           
            //int [] arr = new int[n];
            
        
        writer.close();
    }
}
class myram {
	
	public static void main(String args[]) {
		Scanner sc =new Scanner(System.in);
		int t=sc.nextInt();
		AVLTree tree=new AVLTree();
		for (int j=0;j<t;j++) {
			String s=sc.next();
			if(s.compareTo("INSERT")==0) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				storevalues s1=new storevalues();
				s1.t=tree;
				s1.size=tree.size;
				s1.p=new int[tree.size];
				s1.store(tree.root);
				tree.printleaf(tree.root, a, b, s1.p);
				System.out.println();
				
				//System.out.print(tree.size);
			}
			else if(s.compareTo("FIND")==0) {
				int nom=sc.nextInt();
				tree.root=tree.insert(tree.root, nom);
			}
		}
	tree.print(tree.root);
	
		
	
}
}

class AVLTree
{
    int size;
	Node root;
    int height(Node N)
    {
        if (N == null)
             return 0;
         return N.height;
    }
   
    Node rightRotate(Node strike)
    {
        Node le = strike.left;
        Node ri = le.right;       
        le.right = strike;
        strike.left = ri;
        strike.height = Math.max(height(strike.left), height(strike.right)) + 1;
        le.height = Math.max(height(le.left), height(le.right)) + 1;
        return le;
    }
    Node leftRotate(Node strike)
    {
        Node y = strike.right;
        Node T2 = y.left;
        y.left = strike;
        strike.right = T2;
        strike.height = Math.max(height(strike.left), height(strike.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }
    
 
    Node insert(Node node, int data)
    {
        if (node == null) {
        	size++;
            return (new Node(data));
        }
        if (data< node.data)
            node.left = insert(node.right, data);
        else if (data > node.data)
            node.right = insert(node.left, data);
        else
            return node;
        node.height = 1 + Math.max(height(node.right),
                              height(node.left));
         int balance = getBalance(node);
        if (balance > 1 && data < node.left.data)
            return rightRotate(node);
         if (balance < -1 && data > node.right.data)
            return leftRotate(node);
        if (balance > 1 && data > node.left.data)
        {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
         if (balance < -1 && data < node.right.data)
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        
        return node;
    }
    
    void printleaf(Node root,int a,int b,int[] a1) {
    	
    	
    	int l1=0;
    	myc q=new myc();
    	q.a=new int[a1.length];
    	for(int l=0,h=1;h<a1.length;h++,l++) {
    		boolean r=false;
	    		if(a1.length>1){
	    			if(a1[l]>a1[h]) {
	    				q.push(a1[l]);
	    			}
	    			else {
	    				while(q.size!=0 && a1[h]>q.top()) {
	    					q.pop();
	    					r=true;
	    				}
	    			}
	    		}
	    		if(r!=true && a1[l]>=b && a1[l]==a) {
	    			l1=1;
		    		System.out.print(a1[l]+" ");
	    	}
	    		
	    	
	    	}
    	if(a1.length!=0 && a1[a1.length-1]>=a && a1[a1.length-1]<=b) {
			System.out.print(a1[a1.length-1]);
			l1=1;
		}
    	if(l1==0) {
    		System.out.print(-1);
    	}
    	}
    }	
    	

class Node {
    int data, height;
    Node left;
    Node right;
 
    Node(int d) {
        data = d;
        height = 1;
    }
}
class myc {
	int t=-1;
	int size=0;
	int [] a;
	int pop() {
		int k=a[t];
		t=t-1;
		size--;
		return k;
	}
	void push(int q) {
		a[++t]=q;
		size++;
	}
	int top() {
		return a[t];
	}
}
class storevalues{
	AVLTree t;
	int size;
	int index =0;
	int [] p;
	void store(Node root) {
		if(root!=null) {
			p[index++]=root.data;
			store(root.left);
			store(root.right);
		}
	}
}
class myheap{
	int h[];
	int sizeh=0;
	int un[];
	myheap(int k){
		h=new int[k-1];
		sizeh=0;
	}
	int parent(int child) {
		int t=(child+1)/2;
		return t;
	}
	int Child(int i,int k) {
		return i*3+k;
	}
	public void insert(int data) {
		if(sizeh<h.length) {
			h[sizeh++]=data;
			hepup(sizeh-1);
		}
	}
	public void hepup(int child) {
        int temp = h[child];    

        while (child > 0 && temp < h[parent(child)])

        {
        	h[child] = h[ parent(child) ];
            child = parent(child);
        }                   
        h[child] = temp;

    }
	public void hepdown(int child) {
		int minch;
		int temp1=h[child];
		while(Child(child,1)<sizeh) {
			minch=min(child);
			if(h[minch]<temp1)
				h[child]=~h[minch];
			else 
				break;
			child=minch;
		}
		h[child]=temp1;
	}
	public int min(int parent) {
	    {

	        int fst = Child(parent, 1);
	        int k=2;
	        int sec =Child(parent, 2);
	        while ((k <= 2) && (sec < sizeh)) 
	        {
	            if (h[sec] < h[fst]) 
	                fst = sec;
	            sec = Child(parent, k++);
	        }    

	        return fst;
	}
}
	public int minimum() {
		return h[0];
	}
	public int extractmin() {
		int y=h[0];
		extract(0);
		return y;
	}
	public int extract(int index) {
        int req = h[index];
        h[index] = h[sizeh - 1];
        sizeh--;
        hepdown(index);        
        return req;
	}
	public void print() {
		for(int i=0;i<sizeh;i++) {
			System.out.println(h[i]+" ");
		}
	}
	
}


