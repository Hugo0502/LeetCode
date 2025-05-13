public class DoubleLinkedList {
    
    private static class Node {
        
        int data;
        Node next;
        Node previous;

        //Constructor
        Node (int data){
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    private Node head;

    // DLL Constructor
    DoubleLinkedList(){
        this.head = null;
    }

    public void add(int data){
        
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else{
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.previous = current;
        }
    }

    public void addArray(int[] data){
        for(int num : data){
            add(num);
        }
    }

    public void remove(int data){
        if(head == null) return;

        if (head.data == data) {
            head = head.next;
            head.previous = null;
        }
        else{
            Node current = head;
            while (current.data != data && current.next != null){
                current = current.next;
            }
            current.next.previous = current.previous;
            current.previous.next = current.next;
        }
    }

    public void printList(){
        Node current = head;
        while (current != null) {
            if (current.next == null){
                System.out.println(current.data);
            }
            else{
                System.out.print(current.data + " <-> ");
            }
            current = current.next;
        }
    }

    public DoubleLinkedList.Node getHead(){
        return this.head;
    }

    public static void main(String[] args){
        DoubleLinkedList List = new DoubleLinkedList();
        int[] nums = {1,2,3,4,5};
        List.addArray(nums);
        List.printList();
        List.remove(3);
        List.printList();
        
    }
}
