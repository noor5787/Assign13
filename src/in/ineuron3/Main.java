package in.ineuron3;
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        head = null;
    }

    // Function to reverse the linked list in groups of size k
    Node reverseInGroups(Node head, int k) {
        Node current = head;
        Node prev = null;
        Node next = null;
        int count = 0;

        // Reverse the first k nodes of the linked list
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // If there are more nodes, recursively reverse them
        if (next != null) {
            head.next = reverseInGroups(next, k);
        }

        // 'prev' is the new head of the input list
        return prev;
    }

    // Function to insert a node at the beginning of the linked list
    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // Function to print the linked list
    void display(Node head) {
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
        list.insert(8);
        list.insert(7);
        list.insert(6);
        list.insert(5);
        list.insert(4);
        list.insert(2);
        list.insert(2);
        list.insert(1);

        int k = 4;
        System.out.println("Original Linked List:");
        list.display(list.head);

        list.head = list.reverseInGroups(list.head, k);
        System.out.println("Reversed Linked List:");
        list.display(list.head);
    }
}
