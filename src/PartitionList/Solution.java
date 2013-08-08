package PartitionList;

public class Solution {
public ListNode partition(ListNode head, int x) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (head==null) return head;
    ListNode less=null;
    ListNode more=head;
    ListNode mprev = null;
    ListNode lprev = null;
    while (more != null && more.val<x) {
            mprev=more;
            more = more.next;
    }
    if (more == null) return head;
    less=more.next;
    lprev = more;
    while(less!=null) {
        if (less.val >= x) {
            lprev = less;
            less = less.next;
            continue;
        }
        lprev.next = less.next;
        if (head!=more) {
            mprev.next = less;
            less.next = more;
            mprev=less;
            less=lprev.next;
        } else {
            less.next = more;
            mprev=less;
            head = less;
            less=lprev.next;
        }

    }
    return head;        
}
}