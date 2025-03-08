// Street Food Word Jumble
// You are given two street food names that you need to creatively jumble following specific rules. Your goal is to confuse your friends by jumbling the two words given to you. To avoid confusion, follow a pattern to jumble the letters.
// The pattern to be followed is as follows: Pick a character from the first word and pick another character from the second word. Continue this process until both words are exhausted while maintaining the subsequence. If one of the words is exhausted before the other, append the remaining letters from the other word all at once.
// Here's how you should create the jumbled word:
// • Start with two strings, str1 and str2, as input.
// • Initialize an empty string, jumbledword, to store the jumbled result.
// • Traverse both str1 and str2 simultaneously, picking one character from each string alternately.
// • If one of the characters is a vowel, ensure that the sequence of vowels is maintained.
// • If both characters are vowels, maintain the vowel sequence while alternating between the words.
// • Append the selected characters to the jumbledWord according to the pattern.
// • If one of the strings is exhausted before the other, append the remaining characters from the other string to jumbledWord.

// Write a Java program that takes two street food names, str1 and str2, as input and outputs the creatively jumbled version of the words while preserving the sequence of vowels and characters from both names.
// Conditions:
// Both input words, str1 and str2, consist of uppercase and lowercase letters.
// • The length of each word is at most 100 characters.
// • The input words may contain vowels (A, E, I, O, U) in both uppercase and lowercase.
// • The input words may contain non-alphabetical characters.
// Note:
// • Vowels are the letters A, E, I, O, and U, in both uppercase and lowercase.

// Sample Test Case:
// Sample Input:
// IceCream
// Hot Dog
// Expected Output:
// IcHeoCtrDeoamg

import java.util.*;

public class StreetFoodWordJumble {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();
        String jumbleWord = "";
        
        int i = 0;
        int j = 0;
        while (i < str1.length() && j < str2.length()) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j);
            
            // Check if both characters are vowels
            if (isVowel(ch1) && isVowel(ch2)) {
                jumbleWord += ch1;
                jumbleWord += ch2;
                i++;
                j++;
            }
            else if (isVowel(ch1)) {
                jumbleWord += ch1;
                i++;
            }
            else if (isVowel(ch2)) {
                jumbleWord += ch2;
                j++;
            }
            else {
                jumbleWord += ch1;
                jumbleWord += ch2;
                i++;
                j++;
            }
        }
        
        // Append remaining characters from str1 and str2, if any
        while (i < str1.length()) {
            jumbleWord += str1.charAt(i);
            i++;
        }
        
        while (j < str2.length()) {
            jumbleWord += str2.charAt(j);
            j++;
        }
        
        System.out.println(jumbleWord);
    }
    
    // Function to check if a character is vowel
    static boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }
}
