import java.util.ArrayList;
import java.util.Arrays; 

public class arraysAndStrings {

	public static int changeInt(int input) {
		input = 12;
		return input;
	}

	public static boolean isUniqueChars(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			int test = 1 << val;
			System.out.println(val + " " + test);

			if ((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);
 		}
		return true;
	}

	public static boolean isUnique(String word) {
		boolean result = false;

		ArrayList <Character> chars = new ArrayList<Character>();

		for (int i = 0; i < word.length(); i++) {
			if (chars.contains(word.charAt(i))) result = true;
		}

		return result;
	}

	public static boolean checkPermutation(String s1, String s2) {
		boolean isPermutation = false;

		char[] s1Array = s1.toCharArray();
		Arrays.sort(s1Array);
		char[] s2Array = s2.toCharArray();
		Arrays.sort(s2Array);

		/**
		 * 2 ways to construct a new String from an array of chars 
		 *  */
		String sortedS1 = new String(s1Array);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s2Array.length; i ++) {
			sb.append(s2Array[i]);
		}
		String sortedS2 = sb.toString();

		if (sortedS1.equals(sortedS2)) isPermutation =true; 

		return isPermutation;
	}

	public static String URLify(String url) {
		String modifiedUrl = "";

		String[] words = url.split(" ");
		String connector = "%20";
		modifiedUrl = words[0];

		for(int i = 1; i < words.length; i++) {
			modifiedUrl += connector;
			modifiedUrl += words[i];
		}

		return modifiedUrl;
	}

	public static boolean palindromPermutation(String s1, String s2) {
		boolean isPalindromPermutation =  false;
		/** remove all spaces in a string */
		s1 = s1.replaceAll("\\s", "");
		s2 = s2.replaceAll("\\s", "");

		int interval= (int) s1.length()/2;;
		for(int i = 0; i < interval; i++) {
			int j = s1.length() - i - 1;
			if(s1.charAt(i) != s1.charAt(j)) return false;
		}

		char[] s1Array = s1.toCharArray();
		char[] s2Array = s1.toCharArray();

		Arrays.sort(s1Array);
		Arrays.sort(s2Array);

		if((new String(s1Array)).equals(new String(s2Array))) isPalindromPermutation = true;

		return isPalindromPermutation;
	}

	public static boolean oneAway(String s1, String s2) {
		boolean isOneAway = true;

		if(s1.length() == s2.length()) {
			int count = 0;
			for (int i = 0; i < s1.length(); i++) {
				if(s1.charAt(i) != s2.charAt(i)) count++;
			}
			if (count > 1)  isOneAway = false;
		} else if (s1.length() > s2.length()) {
			isOneAway = isSubsetBy1(s1, s2);
		} else {
			isOneAway = isSubsetBy1(s2, s1);
		}
		return isOneAway;
	}

	public static boolean isSubsetBy1 (String longString, String shortString) {
		boolean answer = true;
		int count = 0;

		ArrayList<Character> letters = new ArrayList<Character>();
		char[] shortStringCharArray = shortString.toCharArray();
		for(Character letter : shortStringCharArray) {
			letters.add(letter);
		}

		for(int i = 0; i < longString.length(); i++) {
			char current = longString.charAt(i);
			if(!letters.contains(current)) count++;
		}

		if (count > 1) answer = false;

		return answer;
	}

	public static String stringCompression(String word) {
		System.out.println(word);
		String compressedStirng = "";

		char current = word.charAt(0);
		int index = 1;
		for (int i = 1; i < word.length(); i++) {
			if (word.charAt(i) == current) index ++;
			else {
				
				/** convert char to string */
				compressedStirng += Character.toString(current); 
				compressedStirng += index; 
				
				current = word.charAt(i);
				index = 1;
			} 
		}

		/** don't forget the last one */
		compressedStirng += Character.toString(current); 
		compressedStirng += index; 

		return (compressedStirng.length() < word.length() ? compressedStirng : word);
	}

	public static int[][] rotateMatirx (int[][] matrix) {
		/** get int[][] #.rows and #.cols */
		int[][] rotatedMatrix = new int[matrix.length][matrix[0].length];

		for(int i = 0; i < matrix.length; i ++) {
			int[] currentRow = matrix[i];

			for (int j = 0; j < matrix[i].length; j++) {
				rotatedMatrix[matrix[i].length - 1 - j][i] = currentRow[j];
			}
		}

		return rotatedMatrix;
	}

	/** just return a matrix with all zero? */
	public static int[][] zeroMatrix (int[][] matrix) {
		for (int i = 0; i < matrix.length; i ++) {
			for(int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = 0;
			}
		}
		return matrix;
	}

	public static void main(String[] args) {
		System.out.println(isUniqueChars("acdec"));
		System.out.println(isUnique("acdec"));
		System.out.println(checkPermutation("acdec", "aedcc"));
		System.out.println(URLify("Mr John Smith  "));
		System.out.println(palindromPermutation("taco cat", "atco cta"));
		System.out.println(oneAway("pale", "bake"));
		System.out.println(stringCompression("aabcccccaaa"));

		int[][] inputArray = {
			{1, 2},
			{3, 4}
		}; 

		int[][] outputArray = rotateMatirx(inputArray);
		for (int i = 0; i < outputArray.length; i++) {
			for (int j = 0; j < outputArray[i].length; j++) {
				System.out.print(outputArray[i][j]);
			}
			System.out.println();
		}

		int[][] zeroMatrix = zeroMatrix(inputArray);
	}
}





