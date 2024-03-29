/*
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
package AddTwoNumbers;

/**
 * Definition for singly-linked list.
 */
class ListNode {
     int val;
      ListNode next;
      ListNode(int x) {this.val=x;next=null;}
  }
 
class Solution {

   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while ((l1!=null) || (l2!=null)) {
            if (l1!=null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2!=null) {
                carry += l2.val;
                l2 = l2.next;
            }
            if (head==null) {
                tail = head = new ListNode(carry % 10);
            }
            else {
                tail = tail.next = new ListNode(carry % 10);
            }
            carry /= 10;
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        return head;
    }
}