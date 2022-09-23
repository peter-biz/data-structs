import java.util.*;

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
        int count = 0;
        Node head = new Node(10);
        Node firstHead = head;

        //add nodes to linked list
        for(int x = 2; x <= 5; x++)
        {
            head.next = new Node(x * 10);
            System.out.println(head.data + "");
            head = head.next;  
            System.out.println("head next: " + head.data + "");
            count++;
        } //{10, 20, 30, 40, 50}

        System.out.println("count" + count);
        Node sizeOneNode = new Node(1);


        //run test cases
        removeMid(firstHead, count);
        
        removeMid(sizeOneNode, 69);
    }


    public static void removeMid(Node head, int count)
    {   
        if(count <= 1)
        {
            head = null;
            return;
        }
        else if(!(head == null))
        {
            //using two pointer variables, find the middle of the node and delete it then output result
            Node slow = head;
            Node fast = head;
            Node prev = null;

            while(fast != null && fast.next != null)
            {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            prev.next = slow.next;
            
            //output
            System.out.print("\n List with middle node removed: " );
            for(int x = 0; x < count; x++)
            {
                if(head == null)
                {
                    return;
                }
                System.out.print(head.data + " ");
                head = head.next;
            }
        }
        
    }
}
