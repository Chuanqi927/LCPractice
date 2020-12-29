package leetcode.LinkedList;

public class LC24_SwapNodesInPairs {
    class Solution {
        public ListNode swapPairs(ListNode head) {
//         make a dummy head and prev node to store the pointer
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;

            ListNode prev = dummyHead;

            while(head!=null && head.next!=null){
                ListNode firstNode = head;
                ListNode secondNode = head.next;

//             swap
                prev.next = secondNode;
                firstNode.next = secondNode.next;
                secondNode.next = firstNode;

//             reinitialize the head and prev for next step
                prev = firstNode;
                head = firstNode.next;
            }
            return dummyHead.next;
        }
    }
}
