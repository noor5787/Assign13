package in.ineuron5;

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

    void deleteLastOccurrence(int key) {
        if (head == null)
            return;

        Node lastOccurrence = null;
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.data == key)
                lastOccurrence = prev;

            prev = current;
            current = current.next;
        }

        if (lastOccurrence == null) {
            if (head.data == key)
                head = head.next;
        } else {
            lastOccurrence.next = lastOccurrence.next.next;
        }
    }

    void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(5);
        list.insert(2);
        list.insert(10);

        System.out.println("Original list:");
        list.display();

        int key = 2;
        list.deleteLastOccurrence(key);

        System.out.println("List after deleting the last occurrence of " + key + ":");
        list.display();
    }
}
