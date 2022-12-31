public class DoublyLinkedListImplementation {
    Node head = null;
    Node tail = null;

    public void addAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAtPosition(int position, int data) {
        --position;
        if (position > length() || position < 0) {
            System.out.println("Invalid position");
        } else if (position == 0) {
            addAtBeginning(data);
        } else {
            int pos = 0;
            Node newNode = new Node(data);
            Node temp = head;
            while (pos < position - 1) {
                temp = temp.next;
                ++pos;
            }
            Node temp2 = temp.next;

            newNode.next = temp2;
            temp.next = newNode;
            newNode.prev = temp;
            if (position != length() - 1) {
                temp2.prev = newNode;
            } else {
                tail = newNode;
            }
        }
    }

    public int length() {
        Node temp = head;
        int len = 0;
        while (temp != null) {
            ++len;
            temp = temp.next;
        }
        return len;
    }

    public void display() {
        Node temp = head;
        if (temp == null) {
            System.out.println("Linked list is empty");
        } else {
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
        System.out.println();
    }

    public void displayInReverseOrder(){
        if(tail==null){
            System.out.println("Linked list is empty");
        }else{
            Node temp = tail;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp = temp.prev;
            }
            System.out.println();
        }
    }

    public void deleteByPosition(int position) {
        --position;
        if (position < 0 || position >= length()) {
            System.out.println("Invalid position");
        } else if (position == 0) {
            head = head.next;
        } else {
            Node temp = head;
            int pos = 0;
            while (pos < position - 1) {
                temp = temp.next;
                ++pos;
            }
            if (position != length() - 1) {
                Node temp2 = temp.next;
                Node temp3 = temp2.next;
                temp.next = temp3;
                temp3.prev = temp;
            } else {
                temp.next = null;
                tail = tail.prev;
            }
        }
    }

    public void reverse() {
        Node temp, nextNode, currentNode = head;
        while (currentNode != null) {
            nextNode = currentNode.next;
            temp = currentNode.prev;
            currentNode.prev = currentNode.next;
            currentNode.next = temp;
            currentNode = nextNode;
        }
        temp = head;
        head = tail;
        tail = temp;
    }
}