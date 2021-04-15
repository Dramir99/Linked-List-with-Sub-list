package Linked_List_W_Sub_List;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    private File inFile;

    public FileReader(){
        inFile = new File("nothing");
    }
    public FileReader(File test){
        inFile = test;
    }
    public LinkedList readFile(){
        //set Scanner to null
        Scanner fReader = null;
        //get an array list of the people
        LinkedList people = new LinkedList(1);

        //test the file
        try {
            fReader = new Scanner(inFile);
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR! the file could not be found");
        }
        int counter = 0;
        //read the file
        while (fReader.hasNextLine()) {
            String nextLine = fReader.nextLine();

            String[] token = nextLine.split(",");

            //check the first token to see the object type
            people.add(token[0],token[1],token[2]);

        }


        return people;
    }
}
