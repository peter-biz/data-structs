import java.util.ArrayList;

class DS1_MyHashMap {
    public static void main(String args[])
    {
        DS1_MyHashMap myHashMap = new DS1_MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
        myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
    }

    public DS1_MyHashMap() {
        ArrayList<Integer> list = new ArrayList<>();


    }

    public void put(int key, int value) {
        
    }

    public int get(int key) {
        return 0;
    }

    public void remove(int key) {

    }

    public void hashPrint() {

    }
}
