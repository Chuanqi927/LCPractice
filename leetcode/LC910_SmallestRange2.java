package leetcode;

import java.util.*;

public class LC910_SmallestRange2 {
    class Solution {
//        Sort the array A (-----++++)
//        We should always choose (+,-) instead of (-,+) because (+, -) is a subset
//        let a=A[i], b=A[i+1], the new Max will be Math.max(A[n-1]-k, a+k) and new Min will be Math.min(A[0]+k, b-k)
        public int smallestRangeII(int[] A, int K) {
            int n = A.length;
            int k = Math.abs(K);
            Arrays.sort(A);
            int ans = A[n-1]-A[0];
            for(int i=0; i<n-1; i++){
                int a = A[i];
                int b = A[i+1];

                int newMax = Math.max(A[n-1]-k, a+k);
                int newMin = Math.min(A[0]+k, b-k);
                ans = Math.min(ans, newMax-newMin);
            }
            return ans;
        }
    }
}
