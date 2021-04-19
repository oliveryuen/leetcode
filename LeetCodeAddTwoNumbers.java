/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class LeetCodeAddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution1 {

        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode resultsHead = null;
            ListNode results = null;
            ListNode p = l1;
            ListNode q = l2;
            int carry = 0;
            while(p != null || q != null) {
                int pVal = 0;
                int qVal = 0;
                if (p != null) {
                    pVal = p.val;
                }
                if (q != null) {
                    qVal = q.val;
                }
                int sum = pVal + qVal + carry;
                carry = sum / 10;
                sum = sum % 10;

                // generate results
                if (results == null) {
                    results = new ListNode(sum);
                    resultsHead = results;
                } else {
                    results.next = new ListNode(sum);
                    results = results.next;
                }

                // move cursors
                if (p != null)
                    p = p.next;
                if (q != null)
                    q = q.next;
            }

            // add the last carry if any
            if (carry == 1) {
                results.next = new ListNode(1);
            }

            return resultsHead;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4, new ListNode(3));
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6, new ListNode(4));
        ListNode result = null;

        result = LeetCodeAddTwoNumbers.Solution1.addTwoNumbers(l1, l2);
        ListNode next = result;
        System.out.printf("Solution1: \n");
        while (next != null) {
            System.out.println(next.val);
            next = next.next;
        }
    }
}
