// Web Practical Exam
// Guru Pandey, a teacher in Class A, is conducting a practical exam where students must write well-formed XML or HTML tags. 
// The goal is to evaluate how well students understand opening and closing tags.
// If the tags are correctly written, the enclosed content should be processed based on its length. 
// Otherwise, the output should be "Fail".

// Rules:
// 1. The start tag and end tag must be the same. (e.g., <h1>Hello World</h1> is valid, but <h1>Hello World</h2> is invalid).
// 2. Tags can be nested, but only the innermost enclosed content should be considered valid. (e.g., <h1> <a>valid</a>invalid</h1>, only "valid" is considered).
// 3. Tags consist of any printable characters (alphanumeric, symbols, etc.).
// 4. If the tags are valid, process the content length. If the content length is a multiple of 6, score = length × 6. Otherwise, print "Just Pass".
// 5. if invalided tag print "fail".
// create a Java Program to help Guru Pandey validate students' XML or HTML tags by following the above rules.

// Sample Test Case:
// Sample Input:
// 2 (number of sample test case)
// <h1>Cupper Super</h1>
// <p>Winner</p>
// ?
// Expected Output:
// Score: 72
// Score: 36

import java.util.*;
import java.util.regex.*;

public class WebPracticalExam {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // Number of test cases 
        scan.nextLine();
        
        while (n > 0) {
            String line = scan.nextLine();
            Pattern pattern = Pattern.compile("<([^<>]+)>([^<>]+)</\\1>");  // Regex for valid tags
            Matcher matcher = pattern.matcher(line);
            boolean found = false;
            String validContent = "";
            
            while (matcher.find()) {
                validContent = matcher.group(2);    // Extract valid validContent
                found = true;
            }
            
            if (found) {
                processContent(validContent);
            }
            else {
                System.out.println("Fail");
            }
            n--;
        }
        scan.close();
    }
    
    private static void processContent(String content) {
        int length = content.length();
        if (length % 6 == 0) {
            System.out.println("Score: " + (length * 6));
        }
        else {
            System.out.println("Just Pass");
        }
    }
}
