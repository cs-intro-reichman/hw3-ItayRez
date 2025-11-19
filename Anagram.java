/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");

	}  
//end of main


	// Returns true if the two given strings are anagrams, false otherwise.
	public static bgit oolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length()){
			return false;
		}
		String lowerStr1 = preProcess(str1);
		String lowerStr2 = preProcess(str2);
		//lowerStr1 = whithoutSpace(lowerStr1);
		//lowerStr2 = whithoutSpace(lowerStr1);

		

		for (int i = 0; i < lowerStr1.length(); i ++){
			boolean anagram = false;

			for (int j = 0; j < lowerStr2.length(); j++){
			char firstStr = lowerStr1.charAt(i);
			char secondStr = lowerStr2.charAt(j);


			if (firstStr == secondStr){
				lowerStr2 = lowerStr2.substring(0,j) + '*' + lowerStr2.substring(j+1);
				anagram = true;
				break;
			}
		}

		if (!anagram) {
			return false;
		}

	}

	return true;
}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
    	String lowerCase = str.toLowerCase();
    	int length = str.length();
		String preProcessed = "";

    for (int i = 0; i < length; i++) {
        char c = lowerCase.charAt(i);
        if ((c >= 'a' && c <= 'z')) {
            preProcessed = preProcessed + c;
        }
    }
    return preProcessed;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String originalStr = str;
		String randomStr = "";
		int length = originalStr.length();

		for (int i = 0; i < length; i++){
			int randomIndex = (int)(Math.random() * originalStr.length());
			char a = originalStr.charAt(randomIndex);
			randomStr += a;

			originalStr = originalStr.substring(0, randomIndex) + originalStr.substring(randomIndex + 1);
		}
	
		return randomStr;
	}


	public static String whithoutSpace(String str) {
    	String lowerCase = str.toLowerCase();
    	int length = str.length();
		String preProcessed = "";

    for (int i = 0; i < length; i++) {
        char c = lowerCase.charAt(i);
        if ((c >= 'a' && c <= 'z')) {
            preProcessed = preProcessed + c;
        }
    }
    return preProcessed;
	} 
}
