package leetcode.LinkedList;

public class LC92_ReverseLinkedList2 {
    static class Solution{
        private static int LENGTH = 10;
//        use global variable to keep track of the next node after first N nodes
        private static ListNode successor;

        public static ListNode reverseBetween(ListNode head, int m, int n) {
            if(m==1){
                return reverseFirstN(head, n);
            }
            head.next = reverseBetween(head.next, m - 1, n - 1);
            return head;
        }

//        reverse the first N nodes of a singly linked list
        public static ListNode reverseFirstN(ListNode head, int n){
            if(n==1){
                successor = head.next;
                return head;
            }
            ListNode last = reverseFirstN(head.next, n-1);
            head.next.next = head;
            head.next = successor;
            return last;
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

//            check reverseFirstN
//            System.out.println("check reverseFirstN");
//            successor = null;
//            head = reverseFirstN(ptr, 4);
//            while(head!=null){
//                System.out.println(head.val);
//                head = head.next;
//            }

//            check reverseBetween
//            System.out.println("check reverseBetween");
//            successor = null;
//            head = reverseBetween(head, 4, 7);
//            while(head!=null){
//                System.out.println(head.val);
//                head = head.next;
//            }
        }
    }
}
