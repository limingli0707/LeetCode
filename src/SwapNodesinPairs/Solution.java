/*
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
 package SwapNodesinPairs;
 
//
// public class Solution {
//	    public ListNode swapPairs(ListNode head) {
//	        // Start typing your Java solution below
//	        // DO NOT write main() function
//	        ListNode preNode =null;
//	        ListNode currentNode =null;
//	        preNode =head;
//	        currentNode =head.next;
//	        preNode.next =currentNode.next;
//	        currentNode.next =pre;
//	        if(preNode.next!=null&&preNode.next!=null)
//	        swapPairs(preNode.next);
//	    }
//	}
 /**
  * Definition for singly-linked list.
  * struct ListNode {
  *     int val;
  *     ListNode *next;
  *     ListNode(int x) : val(x), next(NULL) {}
  * };
  */
 /*C++
 class Solution {
 public:
     ListNode *swapPairs(ListNode *head) {
         // Start typing your C/C++ solution below
         // DO NOT write int main() function
         if(head==NULL || head->next==NULL) return head;
         
         ListNode* p=head, *q=head->next;
         
         p->next = q->next;
         q->next = p;
         head = q;
         
         ListNode * pre = p;
         p=p->next;

         while(p!=NULL && p->next !=NULL) {
             q=p->next;
             
             p->next = q->next;
             q->next = p;
             pre->next = q;
             
             pre = p;
             p=p->next;
         }
         return head;
     }
 };