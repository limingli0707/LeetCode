package MergekSortedLists;

//C++
/*
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
/*
class Solution {
public:
    ListNode *merge(ListNode *node1, ListNode *node2)
    {
        if (node1 == NULL)
            return node2;
            
        if (node2 == NULL)
            return node1;
            
        ListNode *head = NULL;
        ListNode *curNode = NULL;
        ListNode *p = node1;
        ListNode *q = node2;
        
        while(p && q)
        {
            ListNode *node;
            if (p->val < q->val)
            {
                node = p;
                p = p->next;
            }
            else
            {
                node = q;
                q = q->next;
            }
            
            if (head == NULL)
            {
                head = curNode = node;
            }
            else
            {
                curNode->next = node;
                node->next = NULL;
                curNode = node;
            }
        }
        
        if (p)
        {
            curNode->next = p;
        }
        else if (q)
        {
            curNode->next = q;
        }
        
        return head;        
    }
    
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (lists.size() == 0)
            return NULL;
            
        ListNode *head = lists[0];
        
        for(int i = 1; i < lists.size(); i++)
            head = merge(head, lists[i]);
            
        return head;
    }
};
*/