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

class Commvault {

	public static void main(String[] args) {
		trie tr=new trie();
		String ss="ram/ram/shyam.txt";
		directory dr=new directory();
		dr.insert("index/ram.txt");
		dr.insert("index/ram.java");
		
		fileobject f1=dr.search("index/ram.txt");
		String path="ram";
		//File fk=new File(path);
		//System.out.println(fk.mkdir());
		System.out.println(f1.path);
		f1.write("");
		f1.read();
		//dr.delete("index/ram.txt");
		dr.printall();
		//System.out.println(dr.search("index/ram.txt")==null? "-1":dr.search("index/ram.java").name);
	}

}
class directory{
	directoryNode root;
	directory(){
		root=new directoryNode("current");
	}
	void insert(String path) {
		String[] pathutil=path.split("/");
		insert(root,pathutil,0,new StringBuilder());
	}
	void insert(directoryNode node,String[] path,int index,StringBuilder sb) {
		sb.append(path[index]);
		if(index==path.length-1) {
			fileobject val=node.files.search(path[index]);
			System.out.println(sb.toString());
			if(val==null) {
				node.files.insert(path[index], new fileobject(path[index],sb.toString()));
			}
			else {
				System.out.println("already there");
			}
		}
		else {
			directoryNode next=node.subd.get(path[index]);
			File temp=new File(sb.toString());
			if(!temp.exists()){
				System.out.println(sb.toString());
				System.out.println(temp.mkdir()+","+sb.toString()+"created");
				
			}
			if(next==null) {
				next=new directoryNode(path[index]);
				node.subd.put(path[index], next);
			}
			node=next;
			sb.append("//");
			insert(node,path,index+1,sb);
		}
		
	}
	fileobject search(String path) {
		String[] pathutil=path.split("/");
		return search(root,pathutil,0);
	}
	fileobject search(directoryNode node,String[] path,int index) {
		if(index==path.length-1) {
			return (node.files.search(path[index])==null? null: node.files.search(path[index]));
		}
		directoryNode next=node.subd.get(path[index]);
		if(next==null) return null;
		return search(next,path,index+1);
	}
	void delete(String path) {
		String[] pathutil=path.split("/");
		delete(pathutil,0,root,new StringBuilder());
	}
	boolean delete(String[] path,int index,directoryNode node,StringBuilder sb) {
		sb.append(path[index]);
		if(index==path.length-1) {
			File temp=new File(sb.toString());
			System.out.println(temp.delete());
			if(node.files.search(path[index])==null) {
				return false;
			}
			
			node.files.delete(path[index]);
			return node.files.size==0;
		}
		directoryNode next=node.subd.get(path[index]);
		if(next==null) return false;
		sb.append("//");
		boolean val=delete(path,index+1,next,sb);
		if(val) {
			node.subd.remove(path[index]);
		}
		return node.subd.size()==0;
	}
	void printall(directoryNode node) {
		if(node==null) return;
		node.files.print();;
		for(Map.Entry<String, directoryNode> entry:node.subd.entrySet()) {
			printall(entry.getValue());
		}
	}
	void printall() {
		printall(root);
	}
}
class directoryNode{
	trie files;
	String name;
	TreeMap<String,directoryNode> subd;
	directoryNode(String n){
		files=new trie();
		subd=new TreeMap<>();
		name=n;
	}

}
class trie{
	trienode root;
	int size;
	trie(){
		root=new trienode();
		size=0;
	}
	void insert(String s, fileobject file) {
		trienode cur=root;
		size++;
		for(int i=0;i<s.length();i++) {
			trienode node=cur.map.get(s.charAt(i));
			if(node==null) {
				node=new trienode();
				cur.map.put(s.charAt(i), node);
			}
			cur=node;
		}
		cur.isend=true;
		cur.file=file;
	}
	fileobject search(String s) {
		trienode cur=root;
		for(char c:s.toCharArray()) {
			trienode node=cur.map.get(c);
			if(node==null) return null;
			cur=node;
		}
		return (cur.isend? cur.file:null);
	}
	boolean delete_util(String s,int ind,trienode cur) {
		if(ind==s.length()) {
			if(!cur.isend) return false;
			size--;
			return cur.map.size()==0;
		}
		trienode node=cur.map.get(s.charAt(ind));
		boolean value=delete_util(s,ind+1,node);
		if(value) {
			cur.map.remove(s.charAt(ind));
		}
		return cur.map.size()==0;
	}
	void delete(String s) {
		
		delete_util(s,0,root);
	}
	void print(trienode node,String s) {
		if(node.isend) {
			System.out.println(s);
		}
		for(Map.Entry<Character, trienode> entry:node.map.entrySet()) {
			print(entry.getValue(),entry.getKey()+s);
		}
	}
	void print() {
		print(root,"");
	}
}
class trienode{
	boolean isend;
	fileobject file;
	HashMap<Character,trienode> map;
	trienode(){
		map=new HashMap<>();
	}
}
class fileobject{
	String name;
	File file;
	String path;
	fileobject(String s,String path){
		name=s;
		this.path=path;
		file=new File(path);
		try {
			boolean val=file.createNewFile();
			System.out.println(val);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	void read() {
		try {
			FileInputStream fstr=new FileInputStream(file.getAbsolutePath());
			BufferedReader reader = new BufferedReader(new InputStreamReader(fstr));
			String line=reader.readLine();
			while(line!=null) {
				System.out.println(line);
				line=reader.readLine();
			}
			reader.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	void write(String s) {
		try {
			FileWriter myWriter = new FileWriter(file.getAbsolutePath());
			myWriter.write("Files in Java might be tricky, but it is fun enough!");
       		myWriter.close();
       		System.out.println("Successfully wrote to the file.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

