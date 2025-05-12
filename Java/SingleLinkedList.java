// Single Linked List

class SingleLinkedList{

    // Node class
    private static class Node {
        int data;
        Node next;

        // Node Constructor
        Node (int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // SLL Constructor
    public SingleLinkedList(){
        this.head = null;
    }

    public void add(int data){
        Node newNode = new Node (data);
        // if List is empty
        if (head == null){
            head = newNode;
        }
        // if List is filled
        else{
            Node current = head;
            //move to last position
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void addArray(int[] data){
        for (int num: data){
            add(num);
        }
    }

    public void remove(int data){
        if (head == null) return;

        // remove head
        if (head.data == data){
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data){
            current = current.next;
        }
        if (current.next != null){
            current.next = current.next.next;
        }
    }

    public void printList(){
        Node current = head;
        while (current != null){
            if(current.next == null){
                System.out.print(current.data);
            }
            else{
                System.out.print(current.data + " --> ");
            }
            current = current.next;
        }
    }

    public static void main(String args[]){
        SingleLinkedList List = new SingleLinkedList();
        int[] numbers = {1,2,3,4,5};
        List.addArray(numbers);
        List.printList();

    }
}

