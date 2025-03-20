// Emergency Response System
// A city's disaster management center is responsible for handling emergency reports from different areas. 
// Each area is identified by a unique ID, and whenever an emergency-such as a fire, flood, or accident-is reported, 
// the system updates the priority level for that area.
// However, not all emergencies escalate at the same rate. 
// Some situations grow in severity faster based on past reports,
// making priority changes unpredictable yet fair.
// The priority of an area is determined using the following formula:

// P_new=P_prev1 + 2 x P_prev2 + (areaID mod10)

// where:
// • P_prev1 is the last recorded priority of the area.
// • P_prev2 is the second last recorded priority of the area.
// After all reports have been processed, the system performs a final check to determine whether emergency priorities are distributed efficiently or if the system is unbalanced.

// The system is considered well-optimized if, for every area in the list, its priority is greater than the absolute difference between the two previous priorities. Otherwise, the system is considered inefficient, indicating that certain areas may be receiving disproportionate attention.

// Input Format:
// • n: An integer representing the number of areas in the city.
// • A list of n integers representing area IDs.
// • m: An integer representing the number of emergency reports.
// • A list of m integers representing area IDs where emergencies were reported.

// Output Format:
// • Emergency Priorities: A list of updated priority values for each area in the same order as input.
// • Response Efficiency: Print "Well-Optimized" if the priority distribution is balanced, otherwise print "Inefficient".

// Sample Test Case:
// Sample Input:
// 6
// 601 602 603 604 605 606
// 4
// 602 604 606 606

// Expected Output:
// Emergency Priorities: [1, 2, 1, 2, 1, 10]
// Inefficient


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input number of areas 
        int n = sc.nextInt();
        int [] areas = new int[n];
        for (int i = 0; i < n; i++) {
            areas[i] = sc.nextInt();
        }
        
        // Input number of emergency reports
        int m = sc.nextInt();
        List<Integer> reports = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            reports.add(sc.nextInt());
        }
        
        // Transform priorities based on reports
        int[] priorities = updateEmergencyPriorities(areas, reports);
        
        // Output the transformed priorities
        System.out.println("Emergency Priorities: " + Arrays.toString(priorities));
        
        // Check if the distribution is well-optimized
        boolean isOptimized = checkEfficientDistribution(priorities);
        System.out.println(isOptimized ? "Well-Optimized" : "Inefficient");
    }
    
    // Method to transform the priorities based on emergency reports
    public static int[] updateEmergencyPriorities(int[] areas, List<Integer> reports) {
        Map<Integer, List<Integer>> priorityMap = new HashMap<>();
        
        // Initialize each area with priority 1 and store previous values 
        for (int area : areas) {
            priorityMap.put(area, new ArrayList<>(Arrays.asList(1)));
        }
        
        // Update priorities based on reports using the Fibonacci-like complex logic 
        for (int report : reports) {
            if (priorityMap.containsKey(report)) {
                List<Integer> prevPriorities = priorityMap.get(report);
                int size = prevPriorities.size();
                
                // Apply custom logic for new priority 
                int newPriority;
                if (size == 1) {
                    newPriority = 2; // First increment is always 2
                }
                else {
                    int prev1 = prevPriorities.get(size - 1);
                    int prev2 = prevPriorities.get(size - 2);
                    newPriority = prev1 + (2 * prev2) + (report % 10);  // Unique, unpredictable
                    
                }
                
                prevPriorities.add(newPriority);
            }
        }
        
        // Contruct the updated priority List
        int [] priorities = new int[areas.length];
        for (int i = 0; i < areas.length; i++) {
            List<Integer> values = priorityMap.get(areas[i]);
            priorities[i] = values.get(values.size() - 1);  // Get the lats updated priority 
            
        }
         
         return priorities;
    } 
    
    // Method to check if the emergency priorities follow an efficient distribution 
    public static boolean checkEfficientDistribution(int[] priorities) {
        // Check the uUnique Alternating Sum Pattern (hidden condition) 
        for (int i = 2; i < priorities.length; i++) {
            if (priorities[i] <= Math.abs(priorities[i - 1] - priorities[i - 2])) {
                return false;   // Condition fails, meaning it's inefficient 
            }
        }
        
        return true;    // Follows the pattern, meaning it's Well-Optimized
    }
}
