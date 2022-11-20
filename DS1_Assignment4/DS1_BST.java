import java.util.*;
public class DS1_BST {
    public static void main(String args[]) {
        
        /*
         * find sub tree test cases
        */
        // root = [4, 2, 7, 1, 3, null, null]
        ArrayList<String> tree = new ArrayList<String>(Arrays.asList("4", "2", "7", "1", "3", "null", "null"));
        System.out.println("\nSub Tree Test Cases");
        System.out.println("Test1: " + findSubTree(tree, 2));  //output [2, 1, 3]
        System.out.println("Test2: " + findSubTree(tree, 5));  //ouput: []

       /*
        * find LCA tree cases
        */
        //root = [3,5,1,6,2,0,8,null,null,7,4]
        ArrayList<String> lcaTree = new ArrayList<String>(Arrays.asList("3","5","1","6","2","0","8","null","null","7","4"));
        System.out.println("\n\nLCA Test Cases");
        System.out.println("Test1: " + findLCA(lcaTree, 5, 1));  //p = 5, q = 1,  output should be 3
        System.out.println("Test2: " + findLCA(lcaTree, 5, 4));  //p = 5, q = 4,  ouptut should be 5

        ArrayList<String> lcaTree2 = new ArrayList<String>(Arrays.asList("1", "2"));
        System.out.println("Test3: " + findLCA(lcaTree2, 1, 2));  //p = 1, q = 2,  ouptut should be 1
    }

    //function finds node equals to val and returns the subtree rooted with that node. If such a node does not exist, return null.
    public static ArrayList<Integer> findSubTree(ArrayList<String> a, int val) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int root = Integer.parseInt(a.get(0));
        int distance = 0; 
         //TODO: this output is not correct, need to fix it outputs [2,7,1,3], should be [2,1,3]
        if (root == val) {
            for (int i = 1; i < a.size(); i++) {
                if (a.get(i) != "null") {
                    result.add(Integer.parseInt(a.get(i)));
                }
            }
            return result;
        } else {
            for (int i = 1; i < a.size(); i++) {
                if (a.get(i) != "null") {
                    if (Integer.parseInt(a.get(i)) == val) {
                        distance = i;
                        break;
                    }
                }
            }
            if (distance == 0) {
                return result;
            } else {
                for (int i = distance; i < a.size(); i++) {
                    if (a.get(i) != "null") {
                        result.add(Integer.parseInt(a.get(i)));
                    }
                }
                return result;
            }
        }
    }

    //function finds the lowest common ancestor of two given nodes in the BST.
    public static ArrayList<Integer> findLCA(ArrayList<String> a, int val1, int val2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int root = Integer.parseInt(a.get(0));
        int distance1 = 0;
        int distance2 = 0;
        if (root == val1 || root == val2) {
            result.add(root);
            return result;
        } else {
            for (int i = 1; i < a.size(); i++) {
                if (a.get(i) != "null") {
                    if (Integer.parseInt(a.get(i)) == val1) {
                        distance1 = i;
                        break;
                    }
                }
            }
            for (int i = 1; i < a.size(); i++) {
                if (a.get(i) != "null") {
                    if (Integer.parseInt(a.get(i)) == val2) {
                        distance2 = i;
                        break;
                    }
                }
            }
            if (distance1 == 0 || distance2 == 0) {
                return result;
            } else {
                int parent1 = distance1 / 2;
                int parent2 = distance2 / 2;
                if (parent1 == parent2) {
                    result.add(Integer.parseInt(a.get(parent1)));
                    return result;
                } else {
                    result.add(root);
                    return result;
                }
            }
        }
    }
}