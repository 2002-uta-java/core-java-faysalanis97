package com.revature.eval.java.core;


import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
				
	public String reverse(String string) {
			int length = string.length();
			char[] reversed = new char[length];
			for (int i = 0; i < string.length(); i++) {
				reversed[--length] = string.charAt(i);
			}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
			String word = phrase.toUpperCase();
			String[] wordArray = word.split(" |-");

			String acronym = "";
			for(String words : wordArray) { // for loop for string counter of words till the length of the wordArray
				if( words.length()>0) {
					acronym = acronym + words.charAt(0); // adds the 1st character to the enhanced for loop
				}
			}
			return acronym;
	}
	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
				if (sideOne == sideTwo && sideOne == sideThree && sideTwo == sideThree) {
					return true;
				}
				else 
					return false;
		}
  
		public boolean isIsosceles() {
				if (sideOne == sideTwo || sideOne == sideThree || sideTwo == sideThree) {
					return true;
		}
				else 
					return false;
		}
		
		public boolean isScalene() {
				if (sideOne != sideTwo && sideOne != sideThree && sideTwo != sideThree) {
					return true;
				}
				else
					return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		int total = 0;

		String word = "";
		char wordArray[];
		
		word = string.toLowerCase(); //change word to all lowercase
		
		int length = string.length(); 
		wordArray = word.toCharArray(); // convert word to character array with index i
		
		for (int i = 0; i < length; i++) {
			
			switch (wordArray[i]) // switch statement to input scrabble values to the running total
			{
			case 'g':
				total += 2;
				break;
			case 'b': 
			case 'c':
			case 'm':
			case 'p':	
				total += 3;
				break;
			case 'f':
			case 'h':
			case 'v':
			case 'w':
			case 'y':
				total += 4;
				break;
			case 'k':
				total += 5;
				break;
			case 'j':
			case 'x':
				total +=8;
				break;
			case 'q':
			case 'z':
				total += 10;
				break;
			default: // if none of the cases above ( vowels, etc.) add 1
				total += 1;
			}	
		}	
		
		return total;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		string = string.replaceAll("[^0-9]", ""); // gets rid of everything that is not a number 

		if (string.length() == 10) { // if the length is 10 then the output is valid
		return string;
		}
		else 
			throw new IllegalArgumentException("The number is not valid");
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
        string = string.replaceAll("\n", "");
		String[] phrase = string.split("[^a-zA-Z]"); // splits at points on phrase that isnt a letter
		HashMap<String, Integer> occuranceMap = new HashMap<String, Integer>(); 
        
            for (String str: phrase) { // str variable goes through the phrase to see if the str matches another str
                if (occuranceMap.containsKey(str)) {
                    int count = occuranceMap.get(str); // if matches, puts the string and count of the string into Map
                    occuranceMap.put(str, Integer.valueOf(count + 1));
                } else {
                    occuranceMap.put(str, 1); // if it doesn't match puts a 1
                }
            }
	return occuranceMap;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
//			Integer input = Integer.parseInt("" + t);
//			int listSize = sortedList.size();
//			
//			int startIndex = 0;
//			int midIndex = 0;
//			
//			if(listSize % 2 == 0) {
//				midIndex = listSize/2 + startIndex - 1;
//			}else {
//				midIndex = listSize/2 + startIndex;
 			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		string = string.toLowerCase(); // convert string to lower case
		String[] wordArray = string.split(" ");
		int index = -1;
		String latinWord = "";
		
		for(String words : wordArray) {
		for (int i = 0; i < words.length(); i++) { // for loop for the length of the string
			if (isVowel(words.charAt(i))) { // pass characters to isVowel method
				index = i;
				break;
			}
		}
			latinWord = string.substring(index) + string.substring(0, index) + "ay";
		}
		return latinWord;
	}

    public static Boolean isVowel(char letter) {
        if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
            return true; // boolean expression to determine if the character is a vowel
        }
        return false;
    }
	

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		
		int i = 0;
		int value = 0;
		int modulus, originalNumber;
		
		originalNumber = input;
		
		for (;originalNumber != 0; originalNumber /= 10) {     // runs loop with no initialization, with pre increments and 
			i++;}                                               // condition to divide input by 10 to see how many times loop counter (i) needs to run
		originalNumber = input; //resets variable 
		
		for (;originalNumber != 0; originalNumber /= 10) {
			modulus = originalNumber % 10;
			value += Math.pow(modulus, i); // Math lang to multiply modulus by a power of input numbers length
		}
		if (value == input) { // returns boolean expression after comparing values
			return true;
		}
		else 
			return false;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> factorization = new ArrayList<Long>(); // converts list of long to array list 
		for (long i = 2; i <= l/i; i++) {
			while (l % i == 0) {		// while loop to continuous divide by 2++ (i) until the remainder is 0
				factorization.add(i); // add the long to the arraylist if while is true
				l /= i;
			}
		}
		if (l > 1) { // if not divisible add "prime" number to arraylist
			factorization.add(l);
		}
		return factorization; // return the arraylist of longs
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			StringBuffer caesar = new StringBuffer(); // create output as a string buffer

	        for (int i=0; i<string.length(); i++) // for loop for length of string
	        { 
	            if (Character.isUpperCase(string.charAt(i)))  {  // if character is upper case execute based off ASCII
	                char letter = (char)(((int)string.charAt(i) + key - 65) % 26 + 65); 
	                caesar.append(letter); 
	            } 
	            else if (Character.isLowerCase(string.charAt(i))) { // if not upper case execute based off lower case ASCII 
	                char letter = (char)(((int)string.charAt(i) + key - 97) % 26 + 97); // adds the key to the character, then 
	                caesar.append(letter); // adds the letter to the string buffer
	            }
	            else if (!Character.isAlphabetic(string.charAt(i))){ //if the character is not an alphabetic value
	            	char letter = (char)((int)string.charAt(i)); // add that value back to the string buffer
	            	caesar.append(letter);
	            } 
	        }
	        return caesar.toString();			
		}
	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		int count = 0; // initialize variables to determine amount of time for and while loop will run based off input i
		int num = 1; // start prime number at 1
		int n; // counter variable
		
		if (i <= 0) {
			throw new IllegalArgumentException("Cannot be a number < 0");
		}
		
		while (count < i) { // duration of for loop based off initial input
		      num += 1; // evaluates at every number after 1
		      for (n = 2; n <= num; n++){ // determines if the num variable is a prime number
		        if (num % n == 0) {
		          break; // goes to next iteration of for loop
		        }
		      }
		      if ( n == num){ // goes to next iteration of while loop
		        count += 1;
		      }
		    }
		return num; // return prime number
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			
			String cipher = "zyxwvutsrqponmlkjihgfedcba";
			char[] cipherArray = cipher.toCharArray();
			
			string = string.replaceAll(" ", ""); // gets rid of spaces
			string = string.toLowerCase(); // changes string to lower case
			string = string.replaceAll("[^a-z0-9]", ""); // gets rid of anything that isn't a letter or number
			
			char[] characters = string.toCharArray();
			StringBuilder chiperCharacters = new StringBuilder();
			
			int spaceCounter = 0;
			
			for(char c : characters) {
				
				if(spaceCounter >= 5) { // inserts a space if the character string reaches 5 values
					chiperCharacters.append(' ');
					spaceCounter = 0; // reset counter to 0
				}
				
				int cipherIndex = c - 'a'; // subtracts a character ASCII from initialed enhanced loop
				
				if(cipherIndex >= 0 && cipherIndex <= 25) {
					chiperCharacters.append(cipherArray[cipherIndex]); // add the character to the character array
				}
				else {
					chiperCharacters.append(c);
				}
				spaceCounter++;
			}
			return chiperCharacters.toString();
		}			
		

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			
			String cipher = "zyxwvutsrqponmlkjihgfedcba"; // set chiper as a string
			char[] cipherArray = cipher.toCharArray(); // convert to character array
			
			string = string.replaceAll(" ", ""); // get rid of spaces
			
			char[] characters = string.toCharArray(); // convert input string to character array
			StringBuilder dechiperCharacters = new StringBuilder();
			
			
			for(char c : characters) { // enhanced for loop for duration of characters
				
				int cipherIndex = c - 'a'; // takes each character and subtracts from a ASCII
				
				if(cipherIndex >= 0 && cipherIndex <= 25) {
					dechiperCharacters.append(cipherArray[cipherIndex]); // sets the character to be added to the array
				}
				else {
					dechiperCharacters.append(c);
				}
			}
			return dechiperCharacters.toString(); // converts stringbuilder to string
		}			
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
        string = string.replaceAll("-", "");

        int sum = 0; 
        for (int i = 0; i < 9; i++)  // computes the sum of first 9 digits
        { 
            int number = string.charAt(i) - '0'; // remove ASCII value of 48 from the character
            if (0 > number || 9 < number) // validates to see if the number is out of bounds
                return false; 
            sum += (number * (10 - i)); // executes math logic if it is a valid number
        } 
  
        char last = string.charAt(9);  // checks if the last number is valid
        if (last != 'X' && (last < '0' || last > '9')) 
            return false; 
  
        sum += ((last == 'X') ? 10 : (last - '0'));  // condition operator to add either 10 or the last number
        sum = sum % 11; // find value of the sum modulus 11
        
        if (sum == 0) {
        	return true;
        }
        else 
        	return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		
	      boolean[] alphabetArr = new boolean[26]; // true false array of boolean for each letter
	      int index = 0;
	      int validity = 1;
	      for (int i = 0; i < string.length(); i++) { // determines if the ASCII value is less than or greater than a and z
	    	  if( string.charAt(i) >= 'a' &&  string.charAt(i) <= 'z') { 
	            index = string.charAt(i) - 'a'; // if it is valid then it stores it in the index
	         }
	         alphabetArr[index] = true; // sets that index point as true in alphaList array
	      }
	      for (int i = 0; i <= 25; i++) { // if any condition shows that a character doesn't satisfy 
	         if (alphabetArr[i] == false)   // for loop, set the letter in array as false
	            validity = 0;
	      }	
	      if (validity == 1) {
	    	  return true;
	      }
	      else
	    	  return false;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		
		LocalDateTime myDateTime; // import util packages
		
		if(given.isSupported(ChronoUnit.SECONDS)) { // checks if the seconds unit can be added to date time
			myDateTime = (LocalDateTime) given;
		}else {
			myDateTime = LocalDateTime.of(((LocalDate)given).getYear(), ((LocalDate)given).getMonth(), ((LocalDate)given).getDayOfMonth(), 0, 0);
		} // gets the year, month, and day if the seconds are not present in the input
		
		myDateTime = myDateTime.plusSeconds(1000000000); // adds 10^9 to the input time
		
		return myDateTime;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		List<Integer> findMultiples = new ArrayList<Integer>();
		int sum = 0;
		
		for(int t : set) { // for loop iteration for every multiple in the set
			
			int multiple = t;
			int multiplier = 1;
			
			while(multiple<i) { // while loop to determine if the multiple iteration is less than the input for i (number)
				if(!findMultiples.contains(multiple)) { // if the multiple is not present in array list
					findMultiples.add(multiple); //add it to the array list
				}
				multiplier++; // add 1 to multiplier so that it can be multiplied to the next multiple
				multiple = multiplier * t;
			}
		}
		
		for(int t: findMultiples) {
			sum += t; // once all multiples are found, sum the values together
		}
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		string = string.replaceAll(" ", "");
		
		int sum = 0;
		boolean secondNumber = false;
		
		for (int i = string.length() - 1; i >= 0; i--) { // counter starting from the right
			int number = string.charAt(i) - '0'; // subtracts ASCII value from character
			
			if(secondNumber == true) { // if second number multiply by 2
				number *= 2;
			}
			sum += number/10; // if the doubled number is greater than 10
			sum += number%10; // subtracts 9 by taking int/10 and modulus added to sum
			
			secondNumber = !secondNumber; // sets boolean to true if second, then false if not in for loop
		}
		return (sum % 10 == 0); // returns sum as true if divisible by 10
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		
		Scanner calc = new Scanner(string); // scanner utility to read the string
		
		int firstValue = Integer.parseInt(calc.findInLine("[0-9]*")); // finds a number in the string
	    String operator = calc.findInLine("[^0-9]*").trim(); // finds the operator in between first and last number
	    int secondValue = Integer.parseInt(calc.findInLine("[0-9]*")); // finds the second number in the string
	    
	    switch (operator){ // uses the string to find the correct operation that needs to be done
	        case "add":
	            return firstValue + secondValue;
	        case "minus":
	            return firstValue - secondValue;
	        case "divided by":
	            return firstValue / secondValue;
//	        case "multiplied by":
//	            return firstValue * secondValue;
	        default:
	            throw new RuntimeException("unknown operator: "+operator);
	    }		
	}

}
