/*
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */
package ReverseNodesink_Group;


 // Definition for singly-linked list. 
   class ListNode { 
      int val; 
     ListNode next; 
     ListNode(int x) { 
         val = x; 
         next = null; 
     } 
  } 
 
public class Solution {  
    public ListNode reverseKGroup(ListNode head, int k) {  
        // Start typing your Java solution below  
        // DO NOT write main() function  
        if(head==null || k==1) return head;  
          
        ListNode start = new ListNode(0);  
        start.next = head;  
        ListNode pre = null;  
        ListNode cur = head;  
        ListNode next = null;  
        ListNode end = null;  
        head = start;  
          
        while( cur != null) {            
            int i=k;  
            end = cur;  
            while(--i>0 && end != null ){  
                end = end.next;  
            }  
            if(end==null) return head.next;   
              
            i=k;  
            while(i-->0) {  
                next = cur.next;  
                cur.next = pre;  
                pre = cur;  
                cur = next;  
            }  
            start.next.next = cur;  
            ListNode t = start.next;  
            start.next = pre;  
            start = t;  
        }    
          
        return head.next;  
    }  
}  
