package leetcode.Mathmeticals;

public class LC908_SmallestRange1 {
    class Solution {
        public int smallestRangeI(int[] A, int K) {
//            we want to minimize the max value and maximize the min value
//            the ans is difference of min+k and max-k
//            smallest difference can not be less than 0
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int k = Math.abs(K);
            for(int num:A){
                min = Math.min(num, min);
                max = Math.max(num, max);
            }

            min = min+k;
            max = max-k;
            return Math.max(0, max - min);
        }
    }
}
