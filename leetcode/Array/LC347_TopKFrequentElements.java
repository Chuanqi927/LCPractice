package leetcode.Array;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC347_TopKFrequentElements {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            if(k==nums.length) {
                return nums;
            }
            HashMap<Integer, Integer> hm = new HashMap();
            for(int n:nums){
                hm.put(n, hm.getOrDefault(n,0)+1);
            }

            Queue<Integer> heap = new PriorityQueue<>(
                    (n1,n2)->hm.get(n1)-hm.get(n2));

            for(int n:hm.keySet()){
                heap.add(n);
                if(heap.size()>k){
                    heap.poll();
                }
            }
            int[] ans = new int[k];
            for(int i=k-1; i>=0; i--){
                ans[i]=heap.poll();

            }
            return ans;
        }
    }
}
