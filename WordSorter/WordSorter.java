import java.util.*;
import java.io.*;

class WordSorter {
    public static void main(String[] args) {
        String filename = enterFileName(); //We get the namefile 
        testSortAlgoritm();

        String[] words = getWordsFromFile(filename);
        System.out.println(Arrays.toString(words));
    }

    //Zero Method 
    static String enterFileName() {
        Scanner scann = new Scanner(System.in);
        String str; //This string will be use to store a initialized value 

        do { //This loop does not allow having a blank file name
            System.out.print("Enter the file name: ");
            String enter = scann.nextLine();

            str = enter; //str is initialized
        } while (str.isBlank());

        System.out.println("The file name is <<" + str + ">>");
        return str;
    }

    //First Method 
    static String[] getWordsFromFile(String filename) {
        ArrayList<String> openingWords = new ArrayList<>(); //Here we storing the words that don't know their quantity
        String[] words; //Here we will copy the words knowing their quantity 
                        
        Scanner reader;
        try {
            reader = new Scanner(new FileReader(filename)); //We make the instance for reading
            while (reader.hasNextLine()) {
                openingWords.add(reader.nextLine()); //We use scann methods for reading
            }
            reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("There is a error: " + e.getMessage());
        }

        int i = 0; //Control variable for string array
        words = new String[openingWords.size()]; //We instantiate the string array
                                                 
        for (String s : openingWords) { //We copy the words to string array
            words[i] = s;
            i++;
        }

        return words;
    }

    //Fourth Method 
    static void mergeSort(int[] arr) {
        int lastIndex = arr.length - 1;
        if (lastIndex <= 0) return; //The array needs more than one element

        //We make two arrays with the elements of 'arr' 
        int[] left = new int[(lastIndex + 1) / 2];
        int[] right = new int[lastIndex + 1 - left.length];

        for (int i = 0; i < left.length; i++) { //First array
            left[i] = arr[i];
        }

        for (int i = left.length; i < arr.length; i++) { //Second array with init index equal to length first array
            right[i - left.length] = arr[i];
        }

        //Recursive calls to have little sorted arrays
        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right); //This method sorts firts the little arrays, them sorth the next arrays
    }

    static void merge(int[] arr, int[] left, int[] right) {
        int  k = 0, i = 0, j = 0;
        while (i < left.length && j < right.length) { //This loop fills the array with elements until all elements from either the left or right array have been consumed
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];  
                j++;
            }
            k++;
        }

        //These loops complete filling the array using the elements left in the unproccesed array (left or right)
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    static void testSortAlgoritm() {
        int[] FIRST_ARRAY = {100, 99, 93, 11, -1, 0, -1, 12, -10, 100, 11};
        int[] SECOND_ARRAY = {-1, 0, -1, -5, -1, 0, -1, 0, -1, 0, 0, 0, -1, -1};

        System.out.println("\nThe test begins - These are our arrays"); //Before sort
        System.out.println("Array 1: " + Arrays.toString(FIRST_ARRAY));
        System.out.println("Array 2: " + Arrays.toString(SECOND_ARRAY));

        mergeSort(FIRST_ARRAY); //Sort 
        mergeSort(SECOND_ARRAY); //Sort

        System.out.println("\nOur sorted arrays"); //After sort
        System.out.println("Array 1: " + Arrays.toString(FIRST_ARRAY));
        System.out.println("Array 2: " + Arrays.toString(SECOND_ARRAY));
    }
} 
