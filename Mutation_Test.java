// Mutation Test for Superhuman Abilities
// In a futuristic world, due to an unknown mutation, some humans are developing special abilities. Scientists have devised a simple Mutation Test to identify such individuals based on their first and last names. The test involves analyzing a person's first name and last name and checking if they are anagrams. If they are anagrams, the person is considered a superhuman. If not, their mutation strength is calculated based on specific letter values.
// Rules:
// If the first name and last name are anagrams, print: You have a special ability
// If they are not anagrams, calculate a mutation strength based on the following letter values:
// a = 1 b = 2 c = 3 d = 4 e = 5 f = 6 6.Find the sum of these values from both names.
// Sample Test Case:
// Sample Input:
// flash thompson
// Expected Output:
// You have strength of 7



import java.util.*;

public class Mutation_Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String firstName = scan.next().toLowerCase();
        String lastName = scan.next().toLowerCase();
        
        if (areAnagrams(firstName, lastName)) {
            System.out.println("You have a special ability");
        }
        else {
            int mutationStrength = calculateStrength(firstName) + calculateStrength(lastName);
            System.out.println("You have strength of " + mutationStrength);
        }
        
        scan.close();
    }
    
    private static boolean areAnagrams(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
    
    private static int calculateStrength(String name) {
        Map<Character, Integer> valueMap = new HashMap<>();
        valueMap.put('a',1);
        valueMap.put('b',2);
        valueMap.put('c',3);
        valueMap.put('d',4);
        valueMap.put('e',5);
        valueMap.put('f',6);
        
        int strength = 0;
        for (char ch : name.toCharArray()) {
            strength += valueMap.getOrDefault(ch, 0);
        }
        return strength;
    }
}
