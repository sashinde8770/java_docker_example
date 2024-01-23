public class SingleReverseLL {
    Node head;
    class Node{
        String data;
        Node next;
        Node(String data){
            this.data = data;
            this.next = null;
        }
    }

    //add at first
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node currNode = head;
        newNode.next = currNode;
        head = newNode;
    }

    //add at last
    public void addLast(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }

        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    //remove first

    public void deleteFirst(){
        if(head == null){
            System.out.println("List is empty ");
            return;
        }
        else if (head.next == null) {
            head = null;
            return;
        }
        Node currentNode = head.next;
        head = currentNode;
    }

    //remove last
    public void deleteLast(){
        if(head == null){
            System.out.println("List is empty ");
            return;
        }
        else if (head.next == null) {
            head = null;
            return;
        }
        Node last = head.next;
        Node secondLast = head;
        while (last.next != null) {
            last = last.next;
            secondLast= secondLast.next;
        }
        secondLast.next = null;
    }

    //print List
    public void printList(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node lastNode = head;
        while (lastNode != null) {
            System.out.print(lastNode.data + " -> ");
            lastNode = lastNode.next;
        }
        System.out.print(" Null ");
    }

    //Reverse LL itr3tive way
    public void reverseLL(){
        if(head == null || head.next == null){
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;
        while(currNode !=null){
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            //update
            prevNode = currNode;
            currNode = nextNode;
        }

        head.next = null;
        head = prevNode;
    }

    //Reverse LL recursive

    public Node reverseRec(Node head){
        if(head == null ||head.next == null ){
            return head;
        }
        Node newHead = reverseRec(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        SingleReverseLL list = new SingleReverseLL();
        list.addFirst("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.deleteLast();
        list.printList();
        System.out.println("Plain list ");
        list.reverseLL();
        System.out.println("Reverse itrate ");
        list.printList();
        System.out.println("Reverse recursive ");
        list.head = list.reverseRec(list.head);

        list.printList();
    }
}
