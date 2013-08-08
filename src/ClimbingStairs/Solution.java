//You are climbing a stair case. It takes n steps to reach to the top.

//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


package ClimbingStairs;

public class Solution {  
    public int climbStairs(int n) {  
        if (n == 0 || n == 1) return 1;  
        if (n < 0) return 0;  
        return climbStairs(n - 1) + climbStairs(n - 2);        
    }  
}  

//From the code above, it is not hard to observe that this problem is almost identical to the Fibonacci Problem, if n is large, 
//it takes a long time to find out the result. Therefore, we need to use DP to solve this problem.
/*public class Solution {  
    public int climbStairs(int n) {  
        if (n == 0 || n == 1) return 1;  
        int prev = 1;  
        int current = 1;  
        for (int i = 2; i <= n; i++) {  
            int temp = current + prev;  
            prev = current;  
            current = temp;  
        }  
        return current;        */
    }  
}  