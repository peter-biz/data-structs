import java.util.ArrayList;
import java.util.LinkedList;

class DS1_MyHashMap {
 
    
    LinkedList<Integer> keys;
    ArrayList<Integer> values;

    public static void main(String args[])
    {
        System.out.println("Output format(key/value pairs) is as follows: \n [Key : Value] , [Key : Value] \n\n");


        DS1_MyHashMap h = new DS1_MyHashMap();
        h.put(1, 1); // The map is now [[1,1]]
        h.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(h.get(1));  // return 1, The map is now [[1,1], [2,2]]
        System.out.println(h.get(3)); // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        h.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(h.get(2));
        System.out.println(h.get(2));    // return 1, The map is now [[1,1], [2,1]]
        h.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(h.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]

        
    }

    public DS1_MyHashMap() {
        keys = new LinkedList<Integer>();
        values = new ArrayList<Integer>();


    }

    //adds a key-value pair to the map
    public void put(int key, int value) {
        //if the key is already in the map, update existing value
        
        //if(indices[key] == null || indices[key] == "8") //TODO logic :0, rethinking the need for an if statment here, at the very least think the condition is wrong
      
        if(keys.contains(key))
        {
            int index = keys.indexOf(key);
            values.set(index, value);
        }
        else
        {
            keys.add(key);
            values.add(value);
        }
    }

    //returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
    public int get(int key) {
        if(keys.contains(key))
        {
            int index = keys.indexOf(key);
            int value = values.get(index);
           
            return value;
        }
        else
        {
           
            return -1;
        }
    }

    //removes the mapping of the specified value key if this map contains a mapping for the key
    public void remove(int key) {
        if(keys.contains(key))
        {
            int index = keys.indexOf(key);
            keys.remove(index);
            values.remove(index);
        }


    }
    // public String toString() {
    //     String s = "";
    //     for(int i = 0; i < keys.size(); i++)
    //     {
    //         s += "[" + keys.get(i) + " : " + values.get(i) + "], ";
    //     }
    //     return s;
    // }

    
}
