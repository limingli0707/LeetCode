/*
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,
 */
//��Ȼ��˫ָ��˼�룬����ָ�����n-1��ÿ������ָ�����һ����������һ��ָ��û�к���ˣ�ǰ��һ��ָ�����Ҫɾ���Ľڵ㡣
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