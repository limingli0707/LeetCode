/*
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,
 */
//依然是双指针思想，两个指针相隔n-1，每次两个指针向后一步，当后面一个指针没有后继了，前面一个指针就是要删除的节点。
package RemoveNthNodeFromEndofList;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	
        if(head == null) return null;
        
    	int i = 0;
    	ListNode phead = head;
    	ListNode prevhead = head;
    	
    	while(i < n)
    	{
    		phead = phead.next;
    		i++;
    	}
    	
    	while(phead != null && phead.next != null)
    	{
    		head = head.next;
    		phead = phead.next;
    	}
    	
    	if(phead == null) return prevhead.next;
    	head.next = head.next.next;
    	
    	return prevhead;
    }
}