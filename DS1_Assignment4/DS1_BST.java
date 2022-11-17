import java.util.*;

public class DS1_BST {
 
    public static void main() {
        //input: root = [4, 2, 7, 1, 3, null, null], val = 2
        
        
    }

    public class Node {
        int val;
        Node left;
        Node right;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    
    
    //finds the node in the BST that has the node value equals to (variable) val and returns the subtree rooted witht hat node. If such a node does not exist, return null.
    public Node search(Node root, int val)
    {

    }

    //finds the lowest common ancestor of two nodes in the BST. If either of the nodes does not exist in the BST, return null. If both nodes are the same, return that node.

    public Node LCA(int val1, int val2) {
        
    }

}
