import java.util.Stack;

import javax.naming.ldap.PagedResultsControl;
public class DS1_BST {
 
    public static void main() {
        //input: root = [4, 2, 7, 1, 3, null, null], val = 2
        //create a tree
        tNode root = new tNode(4);
        root.left = new tNode(2);
        root.right = new tNode(7);
        root.left.left = new tNode(1);
        root.left.right = new tNode(3);
        root.right.left = null;
        root.right.right = null;
        
        //search for value 2
        int val = 2;
        System.out.println(searchBST(root, val));


        //TODO: ME THINKS THIS IS WRONG AND YOU SHOULD FEEL BAD, ME ALSO THINKS THAT YOU SHOULD USE AN ARRAY LIST(MAYBE) FOR INPUT INSTEAD OF MAKING TREE NODES
        //CRY ABOUT IT - real
        


    }

    public class tNode {
        int val;
        tNode left;
        tNode right;
        tNode parent;
        tNode() {}
        tNode(int val) { this.val = val; }
        tNode(int val, tNode left, tNode right, tNode parent) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        
    }

    
    
     //finds the node in the BST that has the node value equals to (variable) val and returns the subtree rooted witht hat node. If such a node does not exist, return null.
    public String searchBST(tNode root, int val)
    {
        //if the root is null, return null
        if(root == null)
        {
            return null;
        }
        //if the root is equal to the value, return the root
        if(root.val == val)
        {
            return root.toString();
        }
        //if the value is less than the root, search the left subtree
        if(val < root.val)
        {
            return searchBST(root.left, val);
        }
        //if the value is greater than the root, search the right subtree
        if(val > root.val)
        {
            return searchBST(root.right, val);
        }
        return null;
    }
   

    public tNode LCA (tNode root, int val1, int val2) {
         //finds the lowest common ancestor of two nodes in the BST. If either of the nodes does not exist in the BST, return null. If both nodes are the same, return that node.
         //using a stack
        Stack<tNode> stack = new Stack<tNode>();
        //push the root onto the stack 
        stack.push(root);
        //while the stack is not empty
        while(!stack.isEmpty())
        {
            //pop the top of the stack
            tNode node = stack.pop();
            //if the node is null, continue
            if(node == null)
            {
                continue;
            }
            //if the node is equal to the first value, return the node
            if(node.val == val1)
            {
                return node;
            }
            //if the node is equal to the second value, return the node
            if(node.val == val2)
            {
                return node;
            }
            //if the node is greater than the first value and less than the second value, return the node
            if(node.val > val1 && node.val < val2)
            {
                return node;
            }
            //if the node is less than the first value and greater than the second value, return the node
            if(node.val < val1 && node.val > val2)
            {
                return node;
            }
            //push the left child onto the stack
            stack.push(node.left);
            //push the right child onto the stack
            stack.push(node.right);
        }
        return null;

    }

}
