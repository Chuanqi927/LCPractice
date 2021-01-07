package leetcode.Array;

public class LC11_ContainerWithMostWater {
    class Solution {
//        two pointer approach:
//        pointer i starting from beginning, pointer j starting from end, having the maxWidth at first
//        moving the pointer with shorter height to find possible larger height in order to increase area
        public int maxArea(int[] height) {
            int maxA = 0;
            int i = 0;
            int j = height.length-1;
            while(i<j){
                maxA = Math.max(maxA, Math.min(height[i], height[j])*(j-i));

                if(height[i]>height[j]){
                    j--;
                }else{
                    i++;
                }
            }
            return maxA;
        }
    }
}
