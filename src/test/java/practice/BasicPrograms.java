package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BasicPrograms {

	public static void main(String[] args) {
		
		
		System.out.println("------------------------------------");
		System.out.println("factorial of no");
		
		int p =5;
		int f=1;
		for(int i=5;i>0;i--) {
			f =f*i;
		}
		System.out.println(f);
		
		
		System.out.println("------------------------------------");
		System.out.println("Armstrong no");
		
		int num = 153;
		int sum =0;
		int rem;
		while(num!=0) {
		 rem = num%10;
		 num = num/10;
		System.out.println(rem);
		sum = sum +(rem*rem*rem);
		
		}
		
		
		
		
		System.out.println("sum "+sum);
		
		System.out.println("------------------------------------");
		System.out.println("Second highest no in array");
		int z[] = new int [] {10,5,20,50,40,100,80};
		int temp;
		for(int i=0;i<z.length;i++) { 
			
			if(i==z.length-1) {
				break;
			}
				if(z[i]>z[i+1]) {
					temp = z[i];
					z[i]=z[i+1];
					z[i+1]=temp;
				}
				
		}
		System.out.println("sorted no : ");
		for(int i=0;i<z.length;i++) { 
			System.out.println(z[i]);	
		}
		System.out.println("second hightest is : "+z[z.length-2]);
		
	//Method 2	
		int largest =z[0];
		int secondlarge = z[0];
		int smallest = z[0];
		for(int i=0;i<z.length;i++) { 
			
			if(largest<z[i]) { //at largest this condition will not satisfy
				secondlarge=largest; //value prior to largest value
				largest=z[i]; //largest value
			}
			if(z[i]<smallest) {
				smallest=z[i];
			}
		}
		
		System.out.println("largest : "+largest +" secondlarge : "+secondlarge+" smallest : "+smallest);
		
		
		
		System.out.println("------------------------------------");
		System.out.println("fibonacci series");
		int fr = 0,sec = 1,th;
	for(int j=0; j<10;j++) { //10 times loop with iterate
		
		th = fr+sec;
		System.out.println(th);
		fr=sec;
		sec=th;
	}
		
		System.out.println("-------------------------");
		System.out.println("number is prime or not");
		int no =12;
		int flag =0;
		for(int i=2;i<=no/2;i++) { // here i<=no/2 ? because no is not divisible by more than its half of number.
			
			if(no%i==0) {
				flag =1;
				break;
			}
		}
		if(flag==1) {
			System.out.println(no+" not prime number");
		}
		else {
			System.out.println(no+" is prime number");
		}
		
		
		
		System.out.println("---------------------------------------------");
		System.out.println("count no of words in string");
		String s = "Rajan Dubey Rajan Dubey rajan";
		String[] st = s.split(" ");
		int c = 0;
		Map<String,Object> map1 = new HashMap<String,Object>();
		System.out.println(st);
		for(String newst:st) {
			String newch = newst.toLowerCase(); // if not done this it will treat Rajan and rajan as different word
			if(!map1.containsKey(newch)) {
				 c=0;
				//System.out.println("inside if");
				map1.put(newch, ++c);
			//	System.out.println("if"+ count);
			}
			else {
			//	System.out.println("inside else");
			int oval = (Integer) map1.get(newch);	
			int nval = oval+1;
			map1.put(newch, nval);
			//System.out.println("else count"+nval);
			}
		
		}
		
		Set<Entry<String, Object>> stset = map1.entrySet();
		for(Entry<String, Object> op:stset) {
			System.out.println(op.getKey()+" "+op.getValue());

		}
		
		
		System.out.println("---------------------------------------------");
		System.out.println("count no of characters in string");
		String a = "Rajan";
	
		char[] ch = a.toCharArray();
		Map<Character,Object> map = new HashMap<Character,Object>();
		System.out.println(ch);
		for(Character newch:ch) {
			if(!map.containsKey(newch)) {
				//System.out.println("inside if");
				map.put(newch, 1);
			//	System.out.println("if"+ count);
			}
			else {
			//	System.out.println("inside else");
			int oval = (Integer) map.get(newch);	
			int nval = oval+1;
			map.put(newch, nval);
			//System.out.println("else count"+nval);
			}
		
		}
		
		Set<Entry<Character, Object>> enset = map.entrySet();
		for(Entry<Character, Object> op:enset) {
			System.out.println(op.getKey()+" "+op.getValue());

		}
		
		
		
		System.out.println("-----------------------------------------------");
		System.out.println("reverse string without using 3rd variable");
		System.out.println(a.length());
		for(int i=a.length()-1;i>=0;i--) {
			System.out.println(a.charAt(i));
		}
		
		System.out.println("------------------------------------------");
		System.out.println("reverse string without using 3rd variable");
			char t ;
		 char[] b = a.toCharArray();
		for(int i=0;i<=a.length()/2;i++) {
			t =b[i];
			b[i]=b[a.length()-1-i];
			b[a.length()-1-i]=t;
		}
		
		System.out.println(b);
	
	}
}


