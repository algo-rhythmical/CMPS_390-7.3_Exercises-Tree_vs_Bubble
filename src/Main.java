import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(System.in);
            Scanner textFileReader;
            String fileName;
            File numtextFile;
            NonSortLinkedList numList;
            Node current;
            NumTree treeOfMight;
            BrutalSort brutality;
            int entryNum;
            int entryCount = 0;
            int[] numArray;
            int[] brutalArray;

            //creating scanner to read from textfile
            System.out.print("Enter name of text file: ");
            fileName = keyboard.nextLine()+".txt";
            numtextFile = new File("src\\" + fileName);
            textFileReader = new Scanner(numtextFile);

            //reading integers from textfile into linkedlist(unsorted)
            numList = new NonSortLinkedList();
            while(textFileReader.hasNextLine()) {
                entryNum = textFileReader.nextInt();
                numList.insert(entryNum);
                entryCount++;
            }

            //loading integers from list to array(unsorted)
            numArray = new int[entryCount];
            current = numList.front;
            for(int i = 0; i < numArray.length; i++) {
                    numArray[i] = current.data;
                    current = current.next;
            }

            //printing unsorted array that will be used in sorting methods later
            System.out.println("\n"+"Array of integers from textfile without sorting: ");
            for(int i = 0; i < numArray.length; i++) {
                System.out.println(numArray[i]);
            }
            System.out.println();

            //building ordered binary tree with array
            treeOfMight = new NumTree();
            treeOfMight.buildOrderedTree(numArray);
            System.out.println("Ordered binary tree has been created!: "+"\n");


            //printing out binary tree recursively
            System.out.println("All values in the binary tree printed in order recursively: ");
            treeOfMight.recursiveInOrderPrint(treeOfMight.root);
            System.out.println();

            //print binary tree iteratively from low to high. entryCount needed for node array used by stack class
            treeOfMight.iterativeInOrderPrintLowHigh(entryCount);

            //number of comparisons needed to build ordered binary tree
            System.out.println("\n"+"The number of comparisons for building the ordered binary tree with " +entryCount+
                    " number(s) is " +treeOfMight.compares+"\n");

            //brute sort using bubbleSort method
            brutality = new BrutalSort();
            brutalArray = brutality.bubbleSort(numArray);
            System.out.println("The bubble-sorted array has been created: ");
            for (int i = 0; i < brutalArray.length; i++) {
                System.out.println(brutalArray[i]);
            }
            System.out.println();
            System.out.println("The number of comparisons for sorting an array using bubble-sort with " +entryCount+
                    " number(s) is " +brutality.compares);

        }
        catch(FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
