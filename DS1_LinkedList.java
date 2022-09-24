public class DS1_LinkedList {
    //node class
    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String arg[])
    {
        //test cases
        Node head = new Node(10);  //odd size: 5
        Node firstHead = head;

        //add nodes to linked list
        for(int r = 2; r <= 5; r++)
        {
            head.next = new Node(r * 10);
            head = head.next;  
        } //{10, 20, 30, 40, 50}

        Node head2 = new Node(1); //even size: 4
        Node secondHead = head2;
        for(int s = 2; s <= 4; s++)
        {
            head2.next = new Node(s);
            head2 = head2.next;
        } //{1, 2, 3, 4}

        Node sizeOneNode = new Node(1); //test case for if a list is only one node long

        //run test cases
        removeMid(firstHead);
        removeMid(secondHead);
        removeMid(sizeOneNode);
    }

    public static void removeMid(Node head)
    {   
        if(!(head == null))
        {  //uses two pointer variables to 
            Node slow = head; //slow pointer
            Node fast = head; //fast pointer 
            Node prev = null; //previous pointer

            while(fast != null && fast.next != null)  // while the fast pointer is not null and the next node is not null
            {
                prev = slow;  //sets the previous pointer to the slow pointer
                slow = slow.next; //moves the slow pointer one node ahead 
                fast = fast.next.next; //moves the fast pointer two nodes ahead
            }
            if(prev != null) //if the previous pointer is not null
            {
                prev.next = slow.next; //sets the previous pointer to the next node of the slow pointer
            }
            else  
            {
                head = null;
                System.out.println("\nOne noded list, element removed, list: " + head);  //for the case of a one node list
                return;
            }

            //output, sends to print function 
            print(head);

        }
    }
    
    public static void print(Node head)
    {   
        System.out.print("\nList with middle node removed: " );
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}

/*
 * TIME COMPLEXITY IS: O(n)
 */
