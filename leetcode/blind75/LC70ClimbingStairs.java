package dsa.leetcode.blind75;

import java.util.HashMap;

public class LC70ClimbingStairs {

    public int solve(int idx, int n, HashMap<Integer, Integer> hm){
        if(idx == n) return 1;
        if(idx > n) return 0;

        if(hm.containsKey(idx)){
            return hm.get(idx);
        }

        int stepOne = solve(idx+1, n, hm);
        int stepTwo = solve(idx+2, n, hm);

        hm.put(idx, stepOne + stepTwo);

        return stepOne + stepTwo;
    }

    public int solveItr(int n, int[]dp){
        if(n == 1) return 1;
        if(n ==2) return 2;

        dp[dp.length-1] = 1;
        dp[dp.length -2] = 2;
        for(int i = dp.length-3; i >=0; i--){

            dp[i] = dp[i+1] + dp[i+2];
        }
        return dp[0];
    }
}
