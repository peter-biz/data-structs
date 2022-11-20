import java.util.*;
public class DS1_BST {
    public static void main(String args[]) {
        //input: root = [4, 2, 7, 1, 3, null, null], val = 2   ouput: [2, 1, 3]
        /*
         * find sub tree test cases
        */

        ArrayList<String> tree1 = new ArrayList<String>(Arrays.asList("4", "2", "7", "1", "3", "null", "null"));
        System.out.println(findSubTree(tree1, 2));

       /*
        * find LCA tree cases
        */
        //root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        ArrayList<String> tree2 = new ArrayList<String>(Arrays.asList("3","5","1","6","2","0","8","null","null","7","4"));
        System.out.println(findLCA(tree2, 5, 1));

    }

    //function finds node equals to val and returns the subtree rooted with that node. If such a node does not exist, return null.
    public static String findSubTree(ArrayList<String> a, int val) {
        //returns a subtree rooted with the node that has the node value equals to val
        //if the root is null, return null
        //for example if the input is [4, 2, 7, 1, 3, null, null], val = 2, output should be [2, 1, 3]
        if (a.get(0).equals("null")) {
            return "null";
        }
        //if the root is the value we are looking for, return the whole tree
        if (Integer.parseInt(a.get(0)) == val) {
            return a.toString();
        }
        //if the root is not the value we are looking for, check the left and right subtree
        String left = findSubTree(new ArrayList<String>(a.subList(1, a.size() / 2 + 1)), val);
        String right = findSubTree(new ArrayList<String>(a.subList(a.size() / 2 + 1, a.size())), val);
        //if the left and right subtree both return null, return null
        if (left.equals("null") && right.equals("null")) {
            return "null";
        }
        //if the left subtree is not null, return the left subtree
        if (!left.equals("null")) {
            return left;
        }
        //if the right subtree is not null, return the right subtree
        if (!right.equals("null")) {
            return right;
        }
        return "null";
        
        //TODO this output is not correct, need to fix it outputs [2,7,1], should be [2,1,3]
    }


    public static String findLCA(ArrayList<String> a, int val1, int val2) {
        //if the root is null, return null
        if(a.get(0) == "null")
        {
            return null;
        }
        //if the root is equal to the value, return the root
        if(a.get(0) == Integer.toString(val1) || a.get(0) == Integer.toString(val2))
        {
            return a.get(0);
        }
        //if the value is less than the root, search the left subtree
        if(val1 < Integer.parseInt(a.get(0)) && val2 < Integer.parseInt(a.get(0)))
        {
            ArrayList<String> left = new ArrayList<String>();
            left.add(a.get(1));
            left.add(a.get(3));
            left.add(a.get(4));
            return findLCA(left, val1, val2);
        }
        //if the value is greater than the root, search the right subtree
        if(val1 > Integer.parseInt(a.get(0)) && val2 > Integer.parseInt(a.get(0)))
        {
            ArrayList<String> right = new ArrayList<String>();
            right.add(a.get(2));
            right.add(a.get(5));
            right.add(a.get(6));
            return findLCA(right, val1, val2);
        }
        //if the value is greater than the root, search the right subtree
        if(val1 < Integer.parseInt(a.get(0)) && val2 > Integer.parseInt(a.get(0)))
        {
            ArrayList<String> right = new ArrayList<String>();
            right.add(a.get(2));
            right.add(a.get(5));
            right.add(a.get(6));
            return findLCA(right, val1, val2);
        }
        //if the value is greater than the root, search the right subtree
        if(val1 > Integer.parseInt(a.get(0)) && val2 < Integer.parseInt(a.get(0)))
        {
            ArrayList<String> right = new ArrayList<String>();
            right.add(a.get(2));
            right.add(a.get(5));
            right.add(a.get(6));
            return findLCA(right, val1, val2);
        }
        return null;


    }
}