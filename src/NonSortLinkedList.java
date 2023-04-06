public class NonSortLinkedList {
    Node front;

    NonSortLinkedList() {
        front = null;
    }

    Node makeNode(int num) {
        Node n = new Node();
        n.data = num;
        n.next = null;
        return n;
    }

    void insert(int num) {
        Node current, temp;
        if(front == null) {
            front = makeNode(num);
        }
        else {
            current = front;
            while (current.next != null) {
                current = current.next;
            }
            temp = makeNode(num);
            current.next = temp;
        }
    }

    void showList() {
        Node current;
        current = front;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
