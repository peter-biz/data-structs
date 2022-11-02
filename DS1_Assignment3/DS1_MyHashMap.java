import java.util.LinkedList;
import java.util.OptionalInt;


class DS1_MyHashMap {
 
    private int size;
    String[] indices;
    LinkedList<Integer> values = new LinkedList<Integer>();

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
     

    }

    //adds a key-value pair to the map
    public void put(int key, int value) {
        //if the key is already in the map, update existing value
        
        if(indices[key] != null)
        {
            values.add(key, value);
        }
        hashPrint();


    }

    //returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
    public int get(int key) {
        
        return 0;
    }

    //removes the mapping of the specified value key if this map contains a mapping for the key
    public void remove(int key) {
       
        hashPrint();
    }

    //prints the hashmap
    public void hashPrint() {
        

    }
}
