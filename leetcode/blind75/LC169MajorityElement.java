package dsa.leetcode.blind75;

public class LC169MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ele = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == ele){
                count++;
            }else{
                count--;
                if(count == 0){
                    ele = nums[i];
                    count++;
                }
            }
        }
        return ele;
    }
}
