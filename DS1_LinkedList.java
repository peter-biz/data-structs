public class DS1_LinkedList {
    //node
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



        Node sizeOneNode = new Node(1);

        //run test cases
        removeMid(firstHead);
        removeMid(secondHead);
        removeMid(sizeOneNode);
    }


    public static void removeMid(Node head)
    {   
        if(!(head == null))
        {  //uses two pointer variables to TODO
            Node slow = head;
            Node fast = head;
            Node prev = null;

            while(fast != null && fast.next != null)
            {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            if(prev != null)
            {
                prev.next = slow.next;
            }
            else
            {
                head = null;
                System.out.println("\nOne noded list, element removed, list: " + head);
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


