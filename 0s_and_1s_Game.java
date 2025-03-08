// 0’s and 1’s Game 
// A computer engineer is tasked with creating a program for a digital circuit factory. 
// The program should be able to separate 0’s on the left side and 1’s on the right side 
// of an array of 0’s and 1’s in a random order. Assume yourself as an engineer and complete your task.

// Sample Test Case:
// Sample Input: 
// 4
// 0  0  1  0 
// Expected Output:
// circuit code
// [0, 0, 0, 1]

import java.util.*;
public class 0s_and_1s_Game {
  public static void main(String[] args) 
  {
	  Scanner scan = new Scanner(System.in);
	  int size = scan.nextInt();
	  int arr[] = new int[size];
	  for (int i = 0; i <= arr.length-1; i++) 
	  {
		  int num = scan.nextInt();
		  if (num == 0 || num == 1) {
			  arr[i] = num;
		  } 
		  else { 
			  System.out.println("Invalid code");
			  return;
		  }
	  }
	  int result[];
	  result = separate0and1(arr, size);
	  System.out.println("circuit code");
	  System.out.println(Arrays.toString(result));
  }
  
  static int [] separate0and1(int arr[], int n) 
  {
	  int count = 0;
	  for (int i=0; i < n; i++) {
		  if (arr[i] == 0) {
			  count++;
		  }
	  }
		
    for (int i=0; i < count; i++) {
			arr[i] = 0;
		}
		
    for (int i = count; i < n; i++) {
			arr[i] = 1;
		}
	  return arr;
  }
}
