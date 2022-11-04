import java.util.ArrayList;
import java.util.LinkedList;

class DS1_MyHashMap {
    LinkedList<Integer> keys;
    ArrayList<Integer> values;

    public static void main(String args[])
    {
        DS1_MyHashMap h = new DS1_MyHashMap();
        h.put(1, 1); // The map is now [[1,1]]
        h.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(h.get(1));  // return 1, The map is now [[1,1], [2,2]]
        System.out.println(h.get(3)); // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        h.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(h.get(2));    // return 1, The map is now [[1,1], [2,1]]
        h.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(h.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]
        //final output should be (1,-1,1,-1)   (passed i think)
    }

    public DS1_MyHashMap() {
        keys = new LinkedList<Integer>(); 
        values = new ArrayList<Integer>();
    }

    //adds a key-value pair to the map
    public void put(int key, int value) {
        if(keys.contains(key)) //if key already exists, update value
        {
            int index = keys.indexOf(key);
            values.set(index, value);
        }
        else  //add key and value
        {
            keys.add(key);
            values.add(value);
        }
    }

    //returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
    public int get(int key) {
        if(keys.contains(key))  //if key exists, return value
        {
            int index = keys.indexOf(key);  //get index of key
            int value = values.get(index);  //get value at index
            return value;
        }
        else 
        {
            return -1;
        }
    }

    //removes the mapping of the specified value key if this map contains a mapping for the key
    public void remove(int key) {
        if(keys.contains(key))  //if key exists, remove key and value
        {
            int index = keys.indexOf(key); //get index of key
            keys.remove(index); 
            values.remove(index);
        }
    }    
}
