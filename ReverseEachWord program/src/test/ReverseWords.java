package test;

public class ReverseWords {
	
	
	    public static boolean reverseEachWord(char str[]) 
	    { 
	        // Initialize left and right pointers 
	        int rightPointer = str.length - 1, leftPointer = 0; 
	  
	        // Traverse string from both ends until 
	        // 'left' and 'right' 
	        while (leftPointer < rightPointer) 
	        { 
	            // Ignore special characters 
	            if (!Character.isAlphabetic(str[leftPointer]))
	            	
	            	leftPointer++; 
	            
	            else if(!Character.isAlphabetic(str[rightPointer])) 
	            	
	            	rightPointer--; 
	  
	            // Both str[leftPointer] and str[rightPointer] are not spacial 
	            else 
	            { 
	                char temp = str[leftPointer]; 
	                str[leftPointer] = str[rightPointer]; 
	                str[rightPointer] = temp; 
	                leftPointer++; 
	                rightPointer--; 
	            } 
	        }
			return true;
			 
	    }
	public static void main(String[] args) {
		{ 
	        String testStr = "String; 2be reversed..."; 
	        
	        char[] charArray = testStr.toCharArray(); 
	  
	        System.out.println("Input string: " + testStr); 
	        
	        reverseEachWord(charArray); 
	        
	        String revStr = new String(charArray); 
	  
	        System.out.println("Output string: " + revStr); 
	         
	        assert reverseEachWord(charArray);
	        
	        return;
	    
	    } 
		
	} 
	}


