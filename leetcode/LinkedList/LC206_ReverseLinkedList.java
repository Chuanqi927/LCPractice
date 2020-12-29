package leetcode.LinkedList;

public class LC206_ReverseLinkedList {
    static class Solution{
        private static int LENGTH = 10;

        public static ListNode reverseList(ListNode head) {
            if(head==null || head.next==null){
                return head;
            }
            ListNode curr = reverseList(head.next);

//            base case: curr is the last node of linked list
            head.next.next = head;
            head.next = null;
            return curr;
        }

        public static void main(String[] args) {
            int count = 1;
            ListNode head = new ListNode(0);
            ListNode ptr = head;
            while(count<LENGTH){
                head.next = new ListNode(count);
                count++;
                head = head.next;
            }

            head = reverseList(ptr);
            while(head!=null){
                System.out.println(head.val);
                head = head.next;
            }
        }
    }
}
