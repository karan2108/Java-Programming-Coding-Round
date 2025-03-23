// Multi-Thread Calculator
// Dr. Aryan, a researcher, is working on complex numerical computations. 
// He frequently needs to calculate Factorial and Fibonacci for different numbers 
// simultaneously to speed up his research. Instead of computing them one by one, 
// he wants a multi-threaded program where both calculations run at the same time. 
// Your task is to help Dr. Aryan by implementing a multi-threaded calculator that 
// computes both Factorial and Fibonacci numbers for a given input simultaneously.

// Requirements:
// 1. Implement a thread to compute the Factorial of a given number.
// 2. Implement a thread to generate the Fibonacci series up to that number.
// 3. Use multi-threading to execute both tasks simultaneously.
// 4. Ensure that both computations finish independently.
// 5. Display results.

// Input Format:
// • An integer (n) representing the number for which:
// • Factorial is calculated.

// Fibonacci series is generated.
// Output Format:
// Print the Factorial of n.
// Print the Fibonacci series up to n.

import java.util.Scanner;

class FactorialThread extends Thread {
    private int num;
    
    public FactorialThread(int num) {
        this.num = num;
    }
    
    public void run() {
        long fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        System.out.println("Factorial of " + num + ": " + fact);
    }
}

class FibonacciThread extends Thread {
    private int num;
    
    public FibonacciThread(int num) {
        this.num = num;
    }
    
    public void run() {
        System.out.print("Fibonacci Series up to " + num + ": ");
        int a = 0; 
        int b = 1;
        System.out.print(a + " " + b + " ");
        for (int i = 3; i <= num; i++) {
            int next = a + b;
            System.out.print(next + " ");
            a = b;
            b = next;
        }
        System.out.println();
    }
}

public class MultiThreadCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        try {
            FactorialThread factorialThread = new FactorialThread(num);
            FibonacciThread fibonacciThread = new FibonacciThread(num);
            
            factorialThread.start();
            factorialThread.join();
            fibonacciThread.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        sc.close();
    }
}
