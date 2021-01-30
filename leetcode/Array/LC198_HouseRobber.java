package leetcode.Array;

public class LC198_HouseRobber {
//     dp
//     dp[i]: the largest amount for the first k house
//     nums[i]: the amount at ith house
//     Base case:   dp[0] = nums[0]
//     dp[1] = Math.max(nums[0], nums[1])
//
//     for future steps:
//     you can either choose to rob the 3rd + 1st, or not rob 3rd and keep Max(1, 2)
//     dp[i] = max(dp[i-2]+nums[i], dp[i-1]);

    class Solution1 {
        public int rob(int[] nums) {
            if(nums.length<=1){
                return nums.length==0 ? 0 : nums[0];
            }
            int[] dp = new int[nums.length+1];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for(int i=2; i<nums.length; i++){
                dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
            }
            return dp[nums.length-1];
        }
    }

    class Solution2 {
//        since we only need to record dp[i-2] and dp[i-1] to compute dp[i], we can simplify our space complexity
        public int rob(int[] nums) {
            if(nums.length<=1){
                return nums.length==0 ? 0 : nums[0];
            }
            int prevMax = 0;
            int currMax = 0;

            for(int amount : nums){
                int temp = currMax;
                currMax = Math.max(prevMax+amount, temp);
                prevMax = temp;
            }
            return currMax;
        }
    }

}
