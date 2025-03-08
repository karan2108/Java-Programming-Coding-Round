// Armstrong and Perfect Number in List
// Madhan and Gopal are preparing a seminar on special numbers, but they find it challenging to make it engaging. 
// To capture their classmates' interest, they decide to write a program that checks whether numbers in a given list are Armstrong numbers or Perfect numbers.
// To make it interactive, they invite their classmates to input numbers and let the program determine the results.
// Your task is to:
// • If there are Armstrong numbers or Perfect numbers in the input, the program should display two separate lists: one for Armstrong numbers and another for Perfect numbers.
// • If no such numbers are found, the program should print empty lists.

// Sample Test Case:
// Sample Input:
// 1
// 153
// Expected Output:
// Armstrong Numbers: [153]
// Perfect Numbers: []

import java.util.ArrayList;
import java.util.Scanner;

public class ArmstrongAndPerfectNumber
{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }
        
        ArrayList<Integer> armstrongNumbers = new ArrayList<>();
        ArrayList<Integer> perfectNumbers = new ArrayList<>();
        
        // Checking each numbers
        for (int num : numbers) {
            if (isArmstrong(num)) {
                armstrongNumbers.add(num);
            }
            
            if (isPerfect(num)) {
                perfectNumbers.add(num);
            }
        }
        
        // Printing results
        System.out.println("Armstrong Numbers: " + armstrongNumbers);
        System.out.println("Perfect Numbers: " + perfectNumbers);
	}
	
	// Method to check if a number is Armstrong
	public static boolean isArmstrong(int num) {
	    int sum = 0; 
	    int temp = num;
	    int digits = String.valueOf(num).length();
	    while (temp > 0) {
	        int digit = temp % 10;
	        sum += Math.pow(digit, digits);
	        temp /= 10;
	    }
	    return sum == num;
	}
	
	// Method to check if a number is Perfect
	public static boolean isPerfect(int num) {
	    int sum = 0; 
	    for (int i = 1; i <= num / 2; i++) {
	        if (num % i == 0) {
	            sum += i;
	        }
	    }
	    return sum == num;
	}
}
