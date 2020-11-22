package practice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;

public class BasicsProgram2 {

	public static void main(String args[]) {

		// removeWhiteSpaces();

		// twoArraysContainsSameElementsUsingSort();
		// twoArraysContainsSameElementsUsingmap();
		// twoArraysContainsSameElementsUsingSinglemap(); // efficient way

		// Hashmapconcept();

		//stringsAreRotationofEachOther();
		
		//firstNonRepeatedCharacter();
		
		//stringContainsOnlyDigits();
		
		//removeDuplicatesFromArrayInt();
		
		//maxCharacterRepeated();
		
		countWordsInStringContainingNumandInvalidWords();

	}

	public static void removeWhiteSpaces() {

		System.out.println("----------remove whitespaces--------");
		String s = "Ra jan Dube y";
		StringBuilder sb = new StringBuilder();
		char ch[] = s.toCharArray();

		for (int i = 0; i < ch.length; i++) {
			char z = ch[i];
			if (z == ' ') {

			} else {
				sb.append(z);
			}

		}

		System.out.println("output : " + sb);
	}

	public static void twoArraysContainsSameElementsUsingSort() {
		/*
		 * logic: Liner comparison check for length. if not equal then arrays not same.
		 * sort both arrays. compare both arrays linearly i.e. 1st poistion of a with
		 * 1st position of b and so on. This is because we have sorted so it is arranged
		 * ascending order.
		 */

		int a[] = { 1, 3, 5, 4, 5 };
		int b[] = { 1, 5, 3, 4, 5 };

		int alen = a.length;
		int blen = b.length;

		if (alen != blen) {
			System.out.println("two arrays are not equal");
		} else {
			int flag = 0;
			Arrays.sort(a);
			Arrays.sort(b);

			for (int i = 0; i < a.length; i++) {
				if (a[i] != b[i]) {
					flag = 1;
					break;
				}
			}
			if (flag == 1) {
				System.out.println("array not same");
			} else {
				System.out.println("arrays same");
			}

		}

	}

	public static void twoArraysContainsSameElementsUsingmap() {

		/*
		 * Logic: (Not efficient way) check length of both arrays. if not same then
		 * arrays are not same. Take 2 maps. for both the arrays put keys and values in
		 * map. now run one more for loop. take value for key from both the maps and
		 * match if it is equal then arrays are same.
		 */

		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();

		int a[] = { 1, 3, 5, 4, 5 };
		int b[] = { 1, 5, 3, 4, 5 };

		int alen = a.length;
		int blen = b.length;

		if (alen != blen) {
			System.out.println("two arrays are not equal");
		} else {
			for (int ar : a) {
				if (map1.containsKey(ar) == false) {
					map1.put(ar, 1);
				} else {
					int val = map1.get(ar);
					val = val + 1;
					map1.put(ar, val);
				}
			}

			for (int br : b) {
				if (map2.containsKey(br) == false) {
					map2.put(br, 1);
				} else {
					int val = map2.get(br);
					val = val + 1;
					map2.put(br, val);
				}
			}

			System.out.println("map1 : " + map1);
			System.out.println("map2 : " + map2);
			int flag = 0;
			for (int x : a) {
				if (map2.containsKey(x)) {
					int m2 = map2.get(x);
					int m1 = map1.get(x);
					if (m1 != m2) {
						System.out.println("arr not same");
						flag = 1;
						break;
					}
				}

			}
			if (flag == 0) {
				System.out.println("array same");
			}
		}
	}

	public static void twoArraysContainsSameElementsUsingSinglemap() {

		/*
		 * Logic : first check if length are same. if not then elements will not be same
		 * for sure. insert all elements of array1 into map. take one by one all
		 * elements of array2 and check if it is present in map. if it is present in
		 * map. take its value and decrease value by 1 and put again in map. at last
		 * check if any value is greater than 0. If yes then it is not same. all are
		 * zero then it is same since we are decreasing count so if elements are present
		 * same number of time count will be zero.
		 * 
		 */

		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();

		int a[] = { 1, 3, 5, 4, 5 };
		int b[] = { 1, 5, 3, 3, 5 };

		int alen = a.length;
		int blen = b.length;

		if (alen != blen) {
			System.out.println("two arrays are not equal");
		} else {
			for (int ar : a) {
				if (map1.containsKey(ar) == false) {
					map1.put(ar, 1);
				} else {
					int val = map1.get(ar);
					val = val + 1;
					map1.put(ar, val);
				}
			}

			for (int x : b) {

				if (map1.containsKey(x)) {
					int c = map1.get(x);
					c--;
					map1.put(x, c);
				}
			}

			Set<Entry<Integer, Integer>> set = map1.entrySet();
			for (Entry<Integer, Integer> val : set) {
				// System.out.println(val.getKey()+"-------------"+val.getValue());
				if (val.getValue() > 0) {
					System.out.println("both arrays not same");
					break;
				}
			}

		}
	}

	public static void Hashmapconcept() {

		// TreeMap<String,String> map = new TreeMap<String,String>(); // asending order
		TreeMap<String, String> map = new TreeMap<String, String>(new MyComparator()); // desending order
		// LinkedHashMap<String,String> map = new LinkedHashMap<String,String>(); //
		// insertion order maintained
		// HashMap<String,String> map = new HashMap<String,String>(); //unordered

		map.put("b", "1");
		map.put("a", "2");
		map.put("m", "5");
		map.put("d", "4");
		map.put("z", "20");
		map.put("k", "7");
		map.put("o", "10");
		map.put("f", "15");
		map.put("n", "12");

		System.out.println(map);
	}

	public static void stringsAreRotationofEachOther() {

		/*
		 * Logic: create concatenation of 1st string to 1st string itself and store in
		 * temp. check if 2nd string is subset of temp. if it is them both string are
		 * rotation of each other.
		 */

		System.out.println("----------two strings rotation of each other----------");
		String s1 = "abcd"; // all possible rotation dabc , cdab, bcda
		String s2 = "dcab";
		String temp;
		temp = s1.concat(s1);
		System.out.println("temp: " + temp + " s1: " + s1 + " s2: " + s2);

		int val = temp.indexOf(s2);

		if (val > 0) // val >0 , since if substring will not be found, val will be -1.
		{ 
			System.out.println("Strings are rotation of each other");
		} else {
			System.out.println("not rotation strings");
		}
	}
	
	
	public static void firstNonRepeatedCharacter(){
		
		String s = "aaanaaabaaaa";
		char[] a = s.toCharArray();
	System.out.println("-----------------Method 1 -------------------");	
		int flag=0;
		char b = 0;
		for(int i=0;i<a.length;i++) {
			if(a[i]!=a[i+1]) {
				b = a[i+1];
				flag=1;
				break;
			}
		}
		
		if(flag==1) {
			System.out.println("First non repeated ch : "+b);
		}
		
		System.out.println("--------------------Method 2----------------------");
		LinkedHashMap<Character,Integer> map = new LinkedHashMap<Character,Integer>();
		
			for(char c:a) {
			
				if(map.containsKey(c)==false) {
					map.put(c, 1);		
			}else {
				int v = map.get(c);
				v= v+1;
				map.put(c, v);
			}
		}
			Set<Entry<Character, Integer>> es = map.entrySet();
			for(Entry<Character, Integer> z:es) {
				if(z.getValue()==1) {
					System.out.println("First non repeated char : "+z.getKey());
					break;
				}
			}
		
	}
	
	public static void stringContainsOnlyDigits() {
		
		String s = "45h768";
		
		for(int i=0;i<s.length();i++) {
			 char a = s.charAt(i);
			 
			 if(Character.isDigit(a)) {
				 System.out.println(a+" is digit");
			 }else {
				 System.out.println(a+" is not digit");
			 }
			 
		}
	}
	
	public static void removeDuplicatesFromArrayInt() {
		System.out.println("remove duplicates from array of integers");
		/*
		 * declare empty array
		 * copy one by one element from 1st array to 2nd array if the element of 1st array 
		 * does not exist in 2nd array
		 */
		
		int arr[]= {1,2,3,3,2,1}; //given array
		int brr[] = new int[arr.length];
		int k=0;
		for(int i=0;i<arr.length;i++) {
			int exist =0;
			for(int j=0;j<i;j++) {
				if(arr[i]==brr[j]) {
					exist =1;
					break;
				}
			}
			if(exist==0) {
				brr[k]=arr[i];
				k++;
			}
		}
		
		for(int i=0;i<k;i++) {
			System.out.println(brr[i]);
		}
	}
	
	public static void maxCharacterRepeated() {
		
		String s = "Raajanddddubeeeeeeeyyyyy"; //op = rajn
		
		 char[] a = s.toCharArray();
		 
		 HashMap<Character,Integer> map1 = new HashMap<Character,Integer>();
		 for(char c:a) {
				
				if(map1.containsKey(c)==false) {
					map1.put(c, 1);		
			}else {
				int v = map1.get(c);
				v= v+1;
				map1.put(c, v);
			}
		}
		 
		 System.out.println(map1);
		 
		 int highest=0;
		 Character kyname = null;
		 Integer va;
			Set<Entry<Character, Integer>> es = map1.entrySet();
			for(Entry<Character, Integer> z:es) {
				 va = z.getValue();
				if(va >highest) {
					highest=va;
					kyname = z.getKey();
				}
			}
			
			System.out.println("k : "+kyname+" h : "+highest);
			
}
	
	public static void countWordsInStringContainingNumandInvalidWords() {
		
		String s = "hay your are wrong, i am rigth. plz contact me on 12345. my passwrd is ADF%^%^GF^";
		
		String[] sa = s.split(" ");
		
		int count=0;
		
		for(int i=0;i<sa.length;i++) {
			boolean flag= false;
			char[] ca = sa[i].toCharArray();
			
			for(int j=0;j<ca.length;j++) {
				
				char c = ca[j];
				int len = ca.length;
				if(Character.isLetter(c)||c=='?'||c=='!'||c=='.'||c==',') {
					if(len==j+1) {
						flag=true;
					}
				}else {
					break;
				}
			}
			
			if(flag==true) {
				count++;
				System.out.println(sa[i]);
			}
			
		}
	
	System.out.println("total words "+count);
		
		/*char a = '*';
		
		System.out.println(":::::"+Character.isLetter(a));*/
	}
	
	
	
	
	
	
	
}






















class MyComparator implements Comparator {

	public int compare(Object obj1, Object obj2) {
		String s1 = obj1.toString();
		String s2 = obj2.toString();

		return s2.compareTo(s1);
	}
}
