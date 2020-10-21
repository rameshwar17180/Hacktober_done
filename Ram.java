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
class myclassss {
	public static void main(String a[]) {
		Slist t=new Slist();
		t.rear(1);
		t.rear(3);
		t.rear(2);
		t.rear(4);
		t.rear(5);
		t.rear(6);
		t.quick();
		t.printlist();
	}
}
class Slist{
	Node front=null;
	int number=0;
	Node end=null;
	public void rear(int n) {
		Node n1=new Node(n);
		if(front==null) {
			front=n1;
			end=n1;
		}
		else {
			end.link=n1;
			n1.prev=end;
			end=n1;
		}
		number+=1;
	}
	public void printlist() {
		if(number==0) {
			System.out.println();
		}
		else {
			Node pp=front;
			while (pp.link!=null) {
				System.out.print(pp.data+" ");
				pp=pp.link;
			}
			System.out.println(pp.data);
			
		}
	}
	public void quick() {
		quick(front,end);
	}
	public void quick(Node pivot,Node end1) {
		Node ptr1=pivot.link;
		Node ptr2=end1;
		while(ptr1.prev.data!=ptr2.data) {
			while(ptr1.data<pivot.data) {
				ptr1=ptr1.link;
			}
			while(ptr2.data>pivot.data) {
				ptr2=ptr2.prev;
			}
			if(ptr1.prev.data!=ptr2.data) {
				int temp=ptr1.data;
				ptr1.data=ptr2.data;
				ptr2.data=temp;
			}
		}
		int temp=pivot.data;
		pivot.data=ptr2.data;
		ptr2.data=temp;
		if(ptr2.data!=front.data) {
			quick(front,ptr2.prev);
		}
		if(ptr1.data!=end.data) {
			quick(ptr1,end);
		}
	}
	
}
class Node{
	public int data;
	public  Node link;
	public Node prev;
	
	//public  static Node front=null;
	public Node(int a ,Node b,Node c) {
		data=a;
		link=b;
		prev=c;
		
	}
	public Node(int a) {
		data=a;
		link=null;
		prev=null;
		
	}
	public Node() {
		
		link=null;
		prev=null;
		
	}
	

}
class hard {
	public static void main(String args[]) {
		Scanner a=new Scanner(System.in);
		int t=a.nextInt();
		for(int i=0;i<t;i++) {
			Slist s=new Slist();
			int n=a.nextInt();
			int k=a.nextInt();
			for (int i1=0;i1<n;i1++) {
				int j=a.nextInt();
				//System.out.println(s.number);
				if(s.number==0) {
					s.addfront(j);
					//System.out.println(s.front.data);
				}
				else {
					
					//System.out.println(s.front.data);
					if((s.front.data<=j) && (s.front.data+j==k)){
						//System.out.println(s.front.data);
						s.pop();
						
					}
					else {
						s.addfront(j);
						
					}
				}
			}
			//System.out.println(s.number);
			if(s.number==0) {
				System.out.println("GOOD");
			}
			else {
				System.out.println("BAD");
			}
			
		}
			
	}
}
class Slist {
	Node front=null;
	Node end=null;

	int number=0;
	public void rear(int a) {
		Node a1=new Node(a);
		if(front==null) {
			//a1.link=end;
			front=a1;
			
			end=a1;
			//end.prev=a1;
		}
		else {
			a1.prev=end;
			end.link=a1;
			end=a1;
		}
		number+=1;
	}
	public void addfront(int a) {
		Node a1=new Node(a);
		if(front==null) {
			//a1.link=end;
			front=a1;
			
			end=a1;
			//end.prev=a1;
		}
		else {
			a1.link=front;
			front.prev=a1;
			front=a1;
		}
		number+=1;
	}
	public int pop() {
		int k=front.data;
		front=front.link;
		number-=1;
		return k;
	}
	public void inc(int p,int q) {
		Node temp=end;
		for(int i=0;i<p;i++) {
			temp.data=temp.data+q;
			temp=temp.prev;
		}
	}
	public void printtop() {
		if(number==0) {
			System.out.println("EMPTY");
		}
		else {
			System.out.println(front.data);
		}
	}
}
	class Node{
		public int data;
		public  Node link;
		public Node prev;
		
		//public  static Node front=null;
		public Node(int a ,Node b,Node c) {
			data=a;
			link=b;
			prev=c;
			
		}
		public Node(int a) {
			data=a;
			link=null;
			prev=null;
			
		}
		public Node() {
			
			link=null;
			prev=null;
			
		}
		

	}
