class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;

        int len = 0;
        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            len++;
        }
        
        // If the head is to be removed
        if (len == n)
            return head.next;

        // Taking the 'curr' to the node 'before' the node to be removed 
        curr = head;
        for (int i = 0; i < len - n - 1; i++)
            curr = curr.next;

        // Delete the node
        curr.next = curr.next.next;
            
        return head;
    }
}
