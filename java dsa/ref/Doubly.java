public class Doubly {
    Node head = null;
    Node tail = null;

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int v) {
            data = v;
            next = null;
            prev = null;
        }
    }

    void add_last(int v) {
        Node new1 = new Node(v);
        if (head == null) {
            head = new1;
            tail = new1;

        } else {
            tail.next = new1;
            new1.prev = tail;
            tail = tail.next;

        }
    }

    void del_first() {
        Node temp = head;

        head = head.next;
        temp.next = null;
        head.prev = null;

    }

    void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "<=>");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        Doubly d = new Doubly();
        d.add_last(100);
        d.add_last(200);
        d.add_last(300);
        d.add_last(400);
        d.del_first();
        d.display();
    }

}
