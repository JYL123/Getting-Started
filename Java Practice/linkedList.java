public class linkedList {

    public static SinglyLinkedList removeDups(SinglyLinkedList ll) {
        ArrayList<Node> nodes = new ArrayList<Node>();

        Node current = ll.head;
        Node prev = null;
        while(current != null) {
            if (!nodes.contains(current)) {
                nodes.add(current);
                prev = current;
                current = current.next;
            }
            else {
                prev.next = current.next;
                current = current.next;
            }            
        }
        return ll;
    }

    public static Node returnKthToLast(SinglyLinkedList ll, int k) {
        Node target = ll.head;

        int counter = ll.length - k;
        while(counter >= 0) {
            target = target.next;
        }
         
        return target;
    }

    public static SinglyLinkedList deleteMiddleNode (SinglyLinkedList ll) {


        return ll;
    }

    public static SinglyLinkedList partiton (SinglyLinkedList ll, int k) {

        Node starter1, starter2;
        int index1 = 0, index2 = 0;
        SinglyLinkedList tmpList1;
        SinglyLinkedList tmpList2;

        Node current = ll.head;
        while(current != null) {
            if (current.val < k) {
                tmpList1.add(current);
                if(index1 == 0) {
                    starter1 = current;
                    index1++;
                }
            }
            else {
                tmpList2.add(current);
                if(index2 == 0) {
                    starter2 = current;
                    index2++;
                }
            }
            current = current.next;
        }

        /** new linked list */
        current = starter1;
        while (start1 != null) {
            starter1 = start1.next;
        }
        starter1.next = starter2;
        ll.head = current;

        return ll;
    }

    public static SinglyLinkedList sumList(SinglyLinkedList l1, SinglyLinkedList l2) {
        SinglyLinkedList ans;

        ans = l1.length < l2.length ? l1 : l2;

        Node current1 = l1.head;
        Node current2 = l2.head;
        int carray = 0;
        while (current1 != null) {
            int val = current1.val + current2.val + carry;
            val = val > 10 ? val-10 : val;
            carry = val > 10 ? 1 : 0;

            ans.add(new Node(null, val));
        }

        return SinglyLinkedList;
    }

    public static boolean palindrome (SinglyLinkedList ll) {
        boolean isPalindrome = true;

        Node p1 = ll.head;
        Node p2 = ll.head;
        while (p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        p1 = ll.head;
        p2 = ll.length % 2 == 0 ? p1 : p1.next;

        while(p2.next !=  null && p1.next !=  null) {
            if(p1.val != p2.val) isPalindrome = false;
        }

        if(p2.next == null && p1.next != null) isPalindrome = false;
        if(p1.next == null && p2.next != null) isPalindrome = false;

        return isPalindrome;
    }

    public static Node loopDetection(SinglyLinkedList ll) {
        Node repeatedNode = ll.head;
        ArrayList<Node> nodes = new ArrayList<Node>();

        Node current = ll.head;
        while(current != null) {
            if(!nodes.contains(current)) {
                nodes.add(current);
                current = current.next;
            }
            else repeatedNode = current;
        }
        return repeatedNode;
    }
    

    public static void main(String[] args){


    }
}