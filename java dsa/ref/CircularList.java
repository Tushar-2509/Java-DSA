public class CircularList {
    Node head = null;

    class Node {
        int data;
        Node next;

        Node(int value) {
            data = value;
            next = null;
        }
    }

    void add(int value) {
        Node new1 = new Node(value);
        if (head == null) {
            head = new1;
            head.next = head;

        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = new1;
            new1.next = head;

        }
    }

    void add_first(int value) {
        Node new1 = new Node(value);
        if (head == null) {
            head = new1;
            head.next = head;

        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = new1;
            new1.next = head;
            head = new1;

        }
    }

    void delete() {
        Node temp = head;
        while (temp.next.next != head) {
            temp = temp.next;
        }
        temp.next = head;

    }

    void display() {
        Node temp = head;
        while (temp.next != head) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print(temp.data + "-> null");
    }

    public static void main(String[] args) {
        CircularList c = new CircularList();
        c.add(100);
        c.add(200);
        c.add(300);

        c.add_first(10);
        c.delete();
        c.display();

    }

}

// ADD FIRST
// INSERT POSITION
// DELETE
// CHECK IF IT BE CIRCULAR OR NOT
