package practice;

public class reverse {

	public static void main(String[] args) {
		//reverse string with spaces maintained at original place
		
		String str = "R aj and ube"; //o/p : e bu dna jaR
		
		String spchar = "R@aj#andu*bey"; //o/p : y@eb#udna*jaR
		
		reverseStringSpaceMaintainedForLoop(str);
		reverseStringSpaceMaintainedWhileLoop(str);
		reverseStringSpecialCharacterMaintainedWhileLoop(spchar);
		

	}
	
	public static void reverseStringSpaceMaintainedForLoop(String str) {
		char[] input = str.toCharArray();
		int size = input.length;
		char result[] = new char[size];
		
		for(int i=0;i<size;i++) {
			if(input[i]==' ') {
				result[i]=' ';
				System.out.println("space loaction : "+i);
			}
		}
		
		int j=size-1;
		for(int i=0;i<size;i++) {
			
			if(input[i]!=' ') {
				if(result[j]==' ') {
					j--;
				}
				
				result[j]=input[i];
				j--;
			
			}
			
		}
		
		System.out.println("for op : "+String.valueOf(result));
		
		
	}
	

	public static void reverseStringSpaceMaintainedWhileLoop(String str) {
		
		char[] input = str.toCharArray();
		int size = input.length;
		int start =0;
		int end = size-1;
		
		while(start<end) {
			if(input[start]==' ') {
				start++;
				continue;
			}else if(input[end]==' ') {
				end--;
				continue;
			}
			else {
				char t = input[start];
				input[start]=input[end];
				input[end]=t;
				
				start++;
				end--;
			}
			
		}
		
		System.out.println("while op : "+String.valueOf(input));
	}
	
	

	public static void reverseStringSpecialCharacterMaintainedWhileLoop(String str) {
		
		char[] input = str.toCharArray();
		int size = input.length;
		int start =0;
		int end = size-1;
		
		while(start<end) {
	/*		if(!(('a'<=input[start]&&input[start]<='z')||('A'<=input[start]&&input[start]<='Z')) ) {
				start++;
				continue;
			}else if(!(('a'<=input[end]&&input[end]<='z')||('A'<=input[end]&&input[end]<='Z')) ) {
				end--;
				continue;*/
			if(!Character.isAlphabetic(input[start])) {
				start++;
				continue;
			}else if(!Character.isAlphabetic(input[end])) {
				end--;
				continue;
			}
			else {
				char t = input[start];
				input[start]=input[end];
				input[end]=t;
				
				start++;
				end--;
			}
			
		}
		
		System.out.println("special char rev op : "+String.valueOf(input));
	
		
	}
	
	
	}

