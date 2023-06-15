package in.ineuron1;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addNode(int data) {
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

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public LinkedList mergeLists(LinkedList list1, LinkedList list2) {
        LinkedList mergedList = new LinkedList();

        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            if (current1.data >= current2.data) {
                mergedList.addNode(current1.data);
                current1 = current1.next;
            } else {
                mergedList.addNode(current2.data);
                current2 = current2.next;
            }
        }

        while (current1 != null) {
            mergedList.addNode(current1.data);
            current1 = current1.next;
        }

        while (current2 != null) {
            mergedList.addNode(current2.data);
            current2 = current2.next;
        }

        return mergedList;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addNode(5);
        list1.addNode(2);
        list1.addNode(3);
        list1.addNode(8);

        LinkedList list2 = new LinkedList();
        list2.addNode(1);
        list2.addNode(7);
        list2.addNode(4);
        list2.addNode(5);

        LinkedList mergedList = new LinkedList();
        mergedList = mergedList.mergeLists(list1, list2);

        System.out.print("New list = ");
        mergedList.display();
    }
}
