import java.util.*;
import java.io.*;

class WordSorter {
    public static void main(String[] args) {
        String filename = enterFileName(); //We get the namefile 
    }

    static String enterFileName() {
        Scanner scann = new Scanner(System.in);
        String str; //This string will be use to store the entered value 

        do { //This loop does not allow having a blank file name
            System.out.print("Enter the file name: ");
            String enter = scann.nextLine();

            str = enter; //str is initialized
        } while (str.isBlank());

        System.out.println("The file name is <<" + str + ">>");

        return str;
    }
} 
