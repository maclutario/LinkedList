// Java implementation of a linkedlist.

class Node {
    int value;
    Node link;
    
    public Node() {
        link = null;
        value = 0;
    }
    
    public Node(int v, Node n) {
        value = v;
        link = n;
    }
    
    public void setLink(Node n) {
        link = n;
    }
    
    public void setData(int v) {
        value = v;
    }
    
    public Node getLink() {
        return link;
    }
    
    public int getValue() {
        return value;
    }
}

class linkedList {
    Node head;
    Node tail;
    public int length;
    
    public linkedList() {
        head = null;
        tail = null;
        length = 0;
    }
    
    // check if linkedlist is empty
    public boolean isEmpty() {
        return head == null;
    }
    
    // get the length of the linked list
    public int getLength() {
        return length;
    }
    
    // insert node at the head
    public void insertAtHead(int value) {
        Node n = new Node(value, null);
        length++;
        if (head == null) {
            head = n;
            tail = head;
        } else {
            n.setLink(head);
            head = n;
        }
    }
    
    // insert node at the tail
    public void insertAtTail(int value) {
        Node n = new Node(value, null);
        length++;
        if (tail == null) {
            head = n;
            tail = head;
        } else {
            tail.setLink(n);
            tail = n;
        }
    }
    
    // insert at specific position
    public void insertSpecific(int value, int position) {
        Node n1 = new Node(value, null);
        Node n2 = head;
        position = position - 1;
        for (int i = 1; i < length; i++) {
            if (i == position) {
                Node tmp = n2.getLink();
                n2.setLink(n1);
                n1.setLink(tmp);
                break;
            }
            n2 = n2.getLink();
        }
        length++;
    }
    
    // delete node at head
    public void deleteHead() {
        head = head.getLink();
        length--;
    }
    
    // delete node at tail
    public void deleteTail() {
        Node h = head;
        Node t = tail;
        while (h != tail) {
            t = h;
            h = h.getLink();
        }
        tail = t;
        tail.setLink(null);
        length--;
    }
    
    // delete at specific position
    public void deleteSpecific(int position) {
        if (position == 1) {
            deleteHead();
            return;
        }
        if (position == length) {
            deleteTail();
            return;
        }
        Node n = head;
        position = position - 1;
        for (int i = 1; i < length - 1; i++) {
            if (i == position) {
                System.out.println(position);
                Node tmp = n.getLink();
                tmp = tmp.getLink();
                n.setLink(tmp);
                break;
            }
            n = n.getLink();
        }
        length--;
    }
    
    public void deleteGreater(int value) {
        Node n1 = head;
        Node n2 = n1.getLink();
        while (value > n1.getValue() && n2 != null) {
            deleteSpecific(1);
            n1 = head;
            n2 = n1.getLink();
        }
        
        while (n2 != null && n2.getLink() != null) {
            if (value > n2.getValue()) {
                n1.setLink(n2.getLink());
                n2 = n2.getLink();
                length--;
            } else {
                n1 = n1.getLink();
                n2 = n1.getLink();
            }
        }
        
        if (n2 != null && value > n2.getValue() && n2.getLink() == null) {
            tail = n1;
            tail.setLink(null);
            length--;
        }
        
        if (value > head.getValue()) {
            head = null;
            tail = null;
            length = 0;
        }
    }
    
    // print linked list
    public void print() {
        System.out.print("Linked List (length: " + length + ") = ");
        if (length == 0) {
            System.out.print("empty\n");
            return;
        }
        if (head.getLink() == null) {
            System.out.println(head.getValue());
            return;
        }
        Node n = head;
        System.out.print(head.getValue()+ "->");
        n = head.getLink();
        while (n.getLink() != null) {
            System.out.print(n.getValue()+ "->");
            n = n.getLink();
        }
        System.out.print(n.getValue()+ "\n");
            
    }
}

public class Simple {
    public static void main(String args[]) {
        System.out.println("**Create new instance of linkedList**");
        linkedList list = new linkedList();
        list.print();
        
        System.out.println("\n**Insert values 10, 20, 30 at the head**");
        list.insertAtHead(10);
        list.insertAtHead(20);
        list.insertAtHead(30);
        list.print();
        
        
        System.out.println("\n**Insert values 40, 50, 60 at the tail**");
        list.insertAtTail(40);
        list.insertAtTail(50);
        list.insertAtTail(60);
        list.print();
        
        System.out.println("\n**Insert value 100 at specific position 5**");
        list.insertSpecific(100, 5);
        list.print();
        
        System.out.println("\n**Delete value at head**");
        list.deleteHead();
        list.print();
        
        System.out.println("\n**Delete value at tail**");
        list.deleteTail();
        list.print();
        
        System.out.println("\n**Delete nodes greater than value 50**");
        list.deleteGreater(50);
        list.print();
        
        System.out.println("\n**Delete at specific position 2**");
        list.deleteSpecific(2);
        list.print();
    }
}