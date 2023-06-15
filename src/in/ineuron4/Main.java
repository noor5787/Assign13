package in.ineuron4;
class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {
    Node head;
    
    void reverseAlternateKNodes(int k) {
        head = reverseAlternateKNodesUtil(head, k, true);
    }
    
    Node reverseAlternateKNodesUtil(Node node, int k, boolean reverse) {
        if (node == null) {
            return null;
        }
        
        Node current = node;
        Node next = null;
        Node prev = null;
        
        int count = 0;
        
        // Reverse k nodes if 'reverse' is true
        while (count < k && current != null) {
            next = current.next;
            
            if (reverse) {
                current.next = prev;
            }
            
            prev = current;
            current = next;
            count++;
        }
        
        // If 'reverse' is true, recursively call the function for next k nodes
        if (reverse) {
            node.next = reverseAlternateKNodesUtil(current, k, !reverse);
        }
        // If 'reverse' is false, set the next of last reversed node to the current node
        else {
            node.next = current;
        }
        
        // Return the new head of the reversed list
        return prev;
    }
    
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(7);
        list.head.next.next.next.next.next.next.next = new Node(8);
        list.head.next.next.next.next.next.next.next.next = new Node(9);
        
        int k = 3;
        
        System.out.println("Original Linked List:");
        list.printList();
        
        list.reverseAlternateKNodes(k);
        
        System.out.println("Modified Linked List:");
        list.printList();
    }
}
