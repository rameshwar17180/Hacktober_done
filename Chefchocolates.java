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
