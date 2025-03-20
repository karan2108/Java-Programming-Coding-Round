// Bridge Stability Analysis

// A city is monitoring an old bridge made up of multiple segments. 
// Each segment has a unique ID and a stability value that decreases as vehicles cross over it.
// However, stability does not decrease in a simple way. Instead, it follows these rules:
// • First time a vehicle crosses a segment → Stability is reduced to half (rounded up).
// • For every additional crossing → Stability decreases by the sum of the digits of the segment ID.

// After all vehicles have crossed, the system checks if the bridge is stable or at risk of collapsing.

// The bridge is stable if, after sorting the segment stabilities, 
// the sum of the two weakest segments is greater than or equal to the strongest segment. 
// Otherwise, the bridge collapses and needs immediate attention.


// Input Format:
// • First line: A space-separated string of integers representing the bridge segment IDs.
// • Second line: A space-separated string of integers representing the segment IDs where vehicles have crossed.

// Output Format:
// • A list of final stability values for each segment in the order of input.
// • A single line indicating whether the bridge is stable or collapsing.


import java.util.*;

public class BridgeStabilityAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read bridge segment IDs 
        String[] segmentInput = sc.nextLine().split(" ");
        int n = segmentInput.length;
        int[] segments = new int[n];
        Map<Integer, Integer> stabilityMap = new HashMap<>();
        
        // Initialize segments and assign initial stability (same as segments IDs)
        for (int i = 0; i < n; i++) {
            segments[i] = Integer.parseInt(segmentInput[i]);
            stabilityMap.put(segments[i], segments[i]);     // Initial stability equals segment ID 
        }
        
        // Read vehicle crossings 
        String[] crossings = sc.nextLine().split(" ");
        for (String cross : crossings) {
            int segmentID = Integer.parseInt(cross);
            if (stabilityMap.containsKey(segmentID)) {
                int currentStability = stabilityMap.get(segmentID);
                
                // If first time crossing, reduce stablity to half (rounded up)
                if (currentStability == segmentID) {
                    stabilityMap.put(segmentID, (int) Math.ceil(segmentID / 2.0));
                }
                
                // For subsequent crossings, reduce stablity by sum of segment ID digitd
                else {
                    stabilityMap.put(segmentID, Math.max(0, currentStability - sumOfDigits(segmentID)));
                }
            }
        }
        
        // Print final stability values in the original order 
        List<Integer> stabilityValues = new ArrayList<>();
        for (int id : segments) {
            stabilityValues.add(stabilityMap.get(id));
        }
        System.out.println(stabilityValues);
        
        // Check bridge stability condition
        Collections.sort(stabilityValues);
        if (stabilityValues.size() >= 3 && 
        stabilityValues.get(0) + stabilityValues.get(1) < stabilityValues.get(stabilityValues.size() - 1)) {
            System.out.println("Bridge Collapses");
        }
        else {
            System.out.println("Bridge is Stable");
        }
    }
    
    // Helper function to calculate sum of digits of a Number
    private static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        
        return sum;
    }
}
