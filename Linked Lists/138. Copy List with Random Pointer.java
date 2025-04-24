class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node curr = head;
        
        while(curr != null) {
            Node newNode = new Node(curr.val);
            
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }

        // Connecting Random Pointers
        curr = head;
        while (curr != null) {
            curr.next.random = (curr.random != null) ? curr.random.next : null;
            curr = curr.next.next;
        }

        Node oldHead = head;
        Node newHead = head.next;
        
        Node oldPtr = oldHead;
        Node newPtr = newHead;

        while (newPtr.next != null) {
            oldPtr.next = oldPtr.next.next;
            oldPtr = oldPtr.next;

            newPtr.next = newPtr.next.next;
            newPtr = newPtr.next;    
        }
        oldPtr.next = null;
        return newHead;
    }
}
