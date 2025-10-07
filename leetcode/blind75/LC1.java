package dsa.leetcode.blind75;

import java.util.HashMap;

public class LC1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] ans = new int[2];

        for(int i = 0; i < nums.length; i++){
            int compliment = target - nums[i];
            if(!hm.containsKey(compliment)){
                hm.put(nums[i], i);
            }else{
                int idx = hm.get(compliment);
                ans[0] = i;
                ans[1] = idx;
                return ans;
            }
        }
        return ans;

        //dummy
    }
}
