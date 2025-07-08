/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node curr = head;

        //insert clone node
        while(curr!=null){
            Node newnode = new Node(curr.val);
            newnode.next = curr.next;
            curr.next = newnode;

            curr = newnode.next;
        }
        
        //add random
        curr = head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        //detach the list
        curr = head;
        Node dummy = new Node(0);
        Node newcurr = dummy;

        while(curr!=null){
           newcurr.next = curr.next;
           curr.next = curr.next.next; 

           curr = curr.next;
           newcurr = newcurr.next;
        }
        return dummy.next; 
    }
}