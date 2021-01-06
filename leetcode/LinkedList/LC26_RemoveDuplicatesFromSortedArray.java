package leetcode.LinkedList;

public class LC26_RemoveDuplicatesFromSortedArray {
//    Two pointers: i being slow pointer and j being fast pointer
//    if(nums[j]==nums[i]), we continue incrementing the j pointer
//    if(nums[j]!=nums[i]), pass the value nums[j] to nums[i+1] by first incrementing i
//    when j reaches the end, the length must be slow pointer i and 1 extra element (where j is at)

    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0){
                return 0;
            }
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i + 1;
        }
    }
}
