package dsa.leetcode;

public class LC268MissingNumber {
    public static int missingNumber(int[] nums) {
        int[] visited = new int[nums.length+1];

        for (int num : nums) {
            visited[num] = 1;
        }

        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == 0) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};

        System.out.println(missingNumber(nums));
    }
}
