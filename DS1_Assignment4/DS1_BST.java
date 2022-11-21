import java.util.*;
public class DS1_BST {
    public static void main(String args[]) {
        
        /*
         * find sub tree test cases
        */
        // root = [4, 2, 7, 1, 3, null, null]
        ArrayList<Integer> tree = new ArrayList<Integer>(Arrays.asList(4, 2, 7, 1 , 3, null, null));
        System.out.println("\nSub Tree Test Cases");
        System.out.println("Test1: " + findSubTree(tree, 2));  //output [2, 1, 3]
        System.out.println("Test2: " + findSubTree(tree, 5));  //ouput: []
        System.out.println("Test3: " + findSubTree(tree, 4));  //ouput: [4, 2, 7, 1, 3]

       /*
        * find LCA tree cases
        */
        //root = [3,5,1,6,2,0,8,null,null,7,4]
        ArrayList<Integer> lcaTree = new ArrayList<Integer>(Arrays.asList(3,5,1,6,2,0,8,null,null,7,4));
        System.out.println("\n\nLCA Test Cases");
        System.out.println("Test1: " + findLCA(lcaTree, 5, 1));  //p = 5, q = 1,  output should be 3
        System.out.println("Test2: " + findLCA(lcaTree, 5, 4));  //p = 5, q = 4,  ouptut should be 5

        ArrayList<Integer> lcaTree2 = new ArrayList<Integer>(Arrays.asList(1, 2));
        System.out.println("Test3: " + findLCA(lcaTree2, 1, 2));  //p = 1, q = 2,  ouptut should be 1
    }

    //function finds node equals to val and returns the subtree rooted with that node. If such a node does not exist, return null.
    public static ArrayList<Integer> findSubTree(ArrayList<Integer> a, int val) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        int distance = 0; 
        int root = a.get(0);
        int left = a.get(1);
        int right = a.get(2);

        if (root == val) {
            for (int i = 0; i < a.size(); i++) {
                if(a.get(i) != null) {
                    result.add(a.get(i));
                }
            }
            return result;
        }

        //do not return the right side of the tree if the value is not on that side
        if (left == val) {
            for (int i = 1; i < a.size(); i++) {
                if(a.get(i) != null  && (a.get(i) != right)) {
                    result.add(a.get(i));
                }
            }
            return result;
        }

        //do not return the left side of the tree if the value is not on that side
        if (right == val) {
            for (int i = 2; i < a.size(); i++) {
                if(a.get(i) != null) {
                    result.add(a.get(i));
                }
            
            }
            return result;
        }

        //if the value is not on the left or right side of the tree, return an empty array
        if (left != val && right != val) {
            return result;
        }
        return result;
    }  

    //function finds the lowest common ancestor of two nodes in a binary tree
    public static int findLCA(ArrayList<Integer> a, int p, int q) {
        int result = 0;
        if(a.size() <= 2) {
            return a.get(0);
        }
        int root = a.get(0);
        int left = a.get(1);
        int right = a.get(2);
        
       //if input is [3,5,1,6,2,0,8,null,null,7,4] p = 5, q = 1, output should be 3, if p = 5, q = 4, output should be 3
        if (root == p || root == q) {
            return root;
        }
        if (left == p || left == q) {
            return left;
        }
        if (right == p || right == q) {
            return right;
        }
        if (p > root && q > root) {
            for (int i = 2; i < a.size(); i++) {
                if (a.get(i) != null) {
                    if (a.get(i) == p || a.get(i) == q) {
                        result = a.get(i);
                        break;
                    }
                }
            }
        } else if (p < root && q < root) {
            for (int i = 1; i < a.size(); i++) {
                if (a.get(i) != null) {
                    if (a.get(i) == p || a.get(i) == q) {
                        result = a.get(i);
                        break;
                    }
                }
            }
        } else {
            result = root;
        }
        return result;
                            //TODO test1 output should be 3, is instead outputting 5
    }
}
