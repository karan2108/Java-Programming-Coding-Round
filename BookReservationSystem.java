// Book Reservation System
// A library has introduced a new book reservation system for its members to help manage the books they want to borrow. 
// The system works as follows:
// 1. Book Reservation:
//     • The library keeps track of books using a list of book identifiers (unique IDs).
//     • When a member reserves a book:
//       • If the book has already been reserved, its priority is increased.
//       • If the book has never been reserved, it is added to the list with a priority of 1.
// 2. Priority Check (Arithmetic Progression Check):
//     • After each reservation, the system checks if the priorities of the reserved books form a consistent pattern.
//     • The system checks if the difference between each consecutive priority is the same, which is known as an Arithmetic Progression (AP).
//     • If the priorities follow an AP, the library can be more efficient in managing reservations.

// Input Format:
// • n: An integer representing the number of books in the library.
// • A list of n integers representing the book identifiers.
// • m: An integer representing the number of reservations to be made.
// • A list of m integers representing the book identifiers for each reservation.

// Output Format:
// • Print the transformed list of book priorities.
// • Print "Yes" if the transformed priorities form an Arithmetic Progression; otherwise, print "No".

// Sample Test Case:
// Sample Input:
// 4
// 411 412 413 414
// 5
// 412 413 414 413 412

// Expected Output:
// Transformed Priorities: [1, 3, 3, 2]
// Is Arithmetic Progression? false


import java.util.*;

public class BookReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input number of books (n)
        int n = sc.nextInt();
        
        // Input list of books identifiers 
        int [] books = new int[n];
        for (int i = 0; i < n; i++) {
            books[i] = sc.nextInt();
        }
        
        // Input number of reservations (m)
        int m = sc.nextInt();
        
        // Input list of reservations (book identifiers)
        List<Integer> reservations = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            reservations.add(sc.nextInt());
        }
        
        // Transform the list of books based on the reservations 
        int[] priorities = transformPriorities(books, reservations);
        
        // Output the transformed priorities
        System.out.println("Transformed Priorities: " + Arrays.toString(priorities));
        
        // Check if the Transformed priorities form an Arithmetic Progression 
        boolean isAP = isArithmeticProgression(priorities);
        System.out.println("Is Arithmetic Progression? " + isAP);
    }
    
    // Method to transform the array based on reservations
    public static int[] transformPriorities(int[] arr, List<Integer> reservations) {
        // HashMap to store the book identifier and its priority 
        Map<Integer,Integer> bookPriorityMap = new HashMap<>();
        
        // Initialize book priorities 
        for (int i = 0; i < arr.length; i++) {
            bookPriorityMap.put(arr[i], 1); // Every book starts with priority 1
        }
        
        // Update priorities based on reservations  
        for (int bookId : reservations) {
            if (bookPriorityMap.containsKey(bookId)) {
                bookPriorityMap.put(bookId, bookPriorityMap.get(bookId) + 1);
            }
        }
        
        // Create an array to store the updated priority
        int [] priorities = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            priorities[i] = bookPriorityMap.get(arr[i]);   
            
        }
         
         return priorities;
    } 
    
    // Method to check if the priorities form an Arithmetic Progression (AP)
    public static boolean isArithmeticProgression (int[] arr) {
        // If the array has less than 2 elements, it's trivially an AP
        if (arr.length < 2) {
            return true;
        }
        
        // Sort the array to check the differences easily
        Arrays.sort(arr);
        
        // Calculate the common difference
        int commonDifference = arr[1] - arr[0];

        // Check if the difference between consecutive elements is constant
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != commonDifference) {
                return false;
            }
        }
        
        return true;
    }
}
