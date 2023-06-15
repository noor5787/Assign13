package in.ineuron6;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeSortedLinkedLists {
    public static Node mergeLists(Node a, Node b) {
        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        Node result;
        if (a.data <= b.data) {
            result = a;
            result.next = mergeLists(a.next, b);
        } else {
            result = b;
            result.next = mergeLists(a, b.next);
        }

        return result;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create the first linked list: 5 -> 10 -> 15
        Node a1 = new Node(5);
        Node a2 = new Node(10);
        Node a3 = new Node(15);
        a1.next = a2;
        a2.next = a3;

        // Create the second linked list: 2 -> 3 -> 20
        Node b1 = new Node(2);
        Node b2 = new Node(3);
        Node b3 = new Node(20);
        b1.next = b2;
        b2.next = b3;

        // Merge the two lists and print the result
        Node merged = mergeLists(a1, b1);
        printList(merged);

        // Create the first linked list: 1 -> 1
        Node c1 = new Node(1);
        Node c2 = new Node(1);
        c1.next = c2;

        // Create the second linked list: 2 -> 4
        Node d1 = new Node(2);
        Node d2 = new Node(4);
        d1.next = d2;

        // Merge the two lists and print the result
        Node merged2 = mergeLists(c1, d1);
        printList(merged2);
    }
}
