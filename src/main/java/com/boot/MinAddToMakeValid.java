package com.boot;

public class MinAddToMakeValid {

    public static int minAddToMakeValid(String s) {
        int openCount = 0;  // Count of unmatched '(' parentheses
        int closeCount = 0; // Count of unmatched ')' parentheses
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount++;  // Increment for every '('
            } else if (c == ')') {
                // If we have an unmatched '(', match it with ')'
                if (openCount > 0) {
                    openCount--;
                } else {
                    // If no unmatched '(', we have an unmatched ')'
                    closeCount++;
                }
            }
        }
        
        // The total number of additions required is the sum of unmatched '(' and unmatched ')'
        return openCount + closeCount;
    }

    public static void main(String[] args) {
        String input = "())";
        System.out.println("Minimum additions to make valid: " + minAddToMakeValid(input)); // Output: 1
        
        input = "(((";
        System.out.println("Minimum additions to make valid: " + minAddToMakeValid(input)); // Output: 3
    }
}
