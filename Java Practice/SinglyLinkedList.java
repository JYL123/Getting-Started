public class SinglyLinkedList {
    Node head = null; 
    int length = 0;
    
    public SinglyLinkedList (Node node) {
        this.head = node;

        Node current = head;
        while(current != null) {
            length++;
            current = current.next;
        }
    }

    public vois add(Node node){
        Node current = head;
        if(head != null) {
            while(current.next != null) {
                current = current.next;
            }
            current.next = node;
        } else {
            head = node;
        }
    }
}

