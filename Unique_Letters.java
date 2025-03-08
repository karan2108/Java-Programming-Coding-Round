// Unique letters
// You're a software engineer tasked with creating a function for a new text analysis tool. 
// This function needs to identify and return only the unique letters from a given string, 
// disregarding any repeated characters. 
// Your algorithm should efficiently parse through the string and ensure accuracy, 
// even with longer and more complex inputs.

// Sample Test Case:
// Sample Input:
// bdbdac
// Expected Output:
// [a, c]


import java.util.*;

public class Unique_Letters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = 0; 
        String str = scan.nextLine();
        
        HashSet<Character> unique = new HashSet<>();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (unique.contains(ch) == true) {
                // this character has already occured
                unique.remove(ch);
            }
            else {
                unique.add(ch);
            }
        }
        
        if (unique.size() == 0) {
            System.out.println("There are no unique characters");
        }
        else {
            for (Character ch : unique) {
                a++;
            }
            
            String arr[] = new String[a];
            int i = 0; 
            for (Character ch : unique) {
                arr[i] = String.valueOf(ch);
                i++;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
