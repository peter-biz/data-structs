import java.util.Arrays;

public class DS1_Arrays{
    public static void main(String args[])
    {
        //Array method test cases
        int[] test1 = {4, 1, 1, 10, 10, 5}; //initial length of 6, should output array = 4,1,10,5 with a length of 4
        int[] test2 = {5, 1, 10, 0, 1, 5, 4}; //initial length of 7, should output array =5,1,10,0,4 with a length of 5
        int[] test3 = {1, 2}; //initial length of 2, should output array = 1,2 with a lenght of 2
        int[] emptyArr = {};

        removeDuplicates(test1);
        removeDuplicates(test2);
        removeDuplicates(test3);
        removeDuplicates(emptyArr);
    }

    //remove duplicates method, removes duplicates from given array and outputs the new array and the size of the new array
    public static void removeDuplicates(int[] arr)
    {
        int[] finArray = new int[arr.length];
        int finArraySize = 0;

        for(int i = 0; i < arr.length; i++)
        {
            boolean duplicate = false;
            for(int j = 0; j < finArraySize; j++)
            { 
                if(arr[i] == finArray[j])
                {
                    duplicate = true;  //if the number is a duplicate, it will not be added to the new array
                    break;
                }
            }
            if(!duplicate)
            {
                finArray[finArraySize] = arr[i];
                finArraySize++;  //adds to the size
            }
        }

        finArray = Arrays.copyOf(finArray, finArraySize); //truncates the array

        System.out.println("\nArray: " + Arrays.toString(finArray));
        System.out.println("Array size: " + finArraySize);
    }
}

/*
 * TIME COMPLEXITY is O(n^2)
 */
