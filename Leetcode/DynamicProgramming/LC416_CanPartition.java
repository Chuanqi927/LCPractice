package Leetcode.DynamicProgramming;

public class LC416_CanPartition {
    class Solution_Brute_Force {
        public boolean canPartition(int[] nums) {
            int totalSum = 0;
            for(int num:nums){
                totalSum+=num;
            }
//            check if totalSum is not even
            if(totalSum%2!=0)   return false;

            int subsetSum = totalSum/2;
            int length = nums.length;

            return dfs(nums,length, subsetSum);
        }

        public boolean dfs(int[] nums, int length, int subsetSum){
            if(subsetSum==0)    return true;
            if(length==0 || subsetSum<0)    return false;
//            for each element x in nums, check if it is in the subset
//            if yes, subsetSum = subsetSum - x
//            if no, subsetSum = subsetSum
            boolean ans = dfs(nums, length-1, subsetSum-nums[length-1]) ||
                    dfs(nums, length-1, subsetSum);
            return ans;
        }
    }

    class Solution_DP{
        public boolean canPartition(int[] nums) {
//            2D array dp[element i][subsetSum]
//            dp[i][j] = true if j can be formed by any elements in subset(nums[0], nums[1])
//            dp[i][j] = true if it satisfies:
//              1. j can be formed without nums[i], which means dp[i-1][j] = true
//              2. j can be formed with nums[i], which means dp[i-1][j-nums[i]] = true
//            Base: dp[0][0] = true
            int totalSum = 0;
            for(int num:nums){
                totalSum+=num;
            }
//            check if totalSum is not even
            if(totalSum%2!=0)   return false;

            int subsetSum = totalSum/2;
            int length = nums.length;

            boolean dp[][] = new boolean[length+1][subsetSum+1];
            dp[0][0] = true;
            for(int i=1; i<dp.length; i++){
                int current = nums[i-1];
                for(int j=0; j<dp[0].length; j++){
                    if(j<current){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-current];
                    }
                }
            }
            return dp[length][subsetSum];
        }

    }
}
