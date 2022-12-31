public class Runner {
    public static void main(String[] args) {
        DoublyLinkedListImplementation dll = new DoublyLinkedListImplementation();
        dll.addAtBeginning(10);
        dll.display();
        System.out.println("Length: "+dll.length());
        dll.append(20);
        dll.append(30);
        dll.append(40);
        dll.display();
        dll.displayInReverseOrder();
        dll.insertAtPosition(5, 25);
        dll.display();
        System.out.println("Length: "+dll.length());
        dll.deleteByPosition(5);
        dll.reverse();
        dll.display();
    }
}
