// The Legend of the Twin Realms: Even and Odd's Trial

// In Numeria, two kingdoms shape destiny-the Even Empire and the Odd Dominion.
// • Citizens of the Even Empire grow stronger by summing all even numbers before them.
// • Warriors of the Odd Dominion prove their might by being Prime Guardians, divisible only by themselves and one., 
//   so we have to check the no.of warriors of the odd Dominion are Prime Guardian or not a prime Guardian

// task:
// 1. If the number is even → It belongs to the Even Empire, and we calculate the sum of all even numbers before it (including itself).
// 2. If the number is odd → It belongs to the Odd Dominion, and we check whether it is a Prime Guardian (a prime number) or not.

// Sample Test Case:
// Sample Input:
// 17
// Expected Output:
// Odd Dominion: Prime Guardian!

import java.util.Scanner;

public class EvenAndOddTrial {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        if (num % 2 == 0) {
            // Even Empire: Summing all even numbers before it 
            int sum = 0;
            for (int i = 2; i <= num; i += 2) {
                sum += i;
            }
            System.out.println("Even Empire: Strength is " + sum);
        }
        else {
            // Odd Dominion: Checking if the number is Prime Guardian 
            if (isPrime(num)) {
                System.out.println("Odd Dominion: Prime Guardian!");
            }
            else {
                System.out.println("Odd Dominion: Not a Prime Guardian.");
            }
        }
    }
    
    // Method to check if a number is Prime
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
