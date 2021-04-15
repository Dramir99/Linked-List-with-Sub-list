package Linked_List_W_Sub_List;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  This class is a Generic Linked List that will hold a list of "Node's" each with
 *  three different parameters
 *
 * @author daniel ramirez
 * @version 1.0
 * @param <G1> Generic Type one
 * @param <G2> Generic Type two
 * @param <G3> Generic Type three
 */
public class LinkedList<G1 extends Comparable<G1>, G2 extends Comparable<G2>, G3 extends Comparable<G3>> {

    // a "Node" that points/refers to the first "Node" in the list
    protected Node head;
    // a number that keeps count of how many "Nodes" are in the Main-list and Sub-list
    private int size;
    //first category Label.
    private G1 category1Label;
    //second category Label.
    private G2 category2Label;
    //third category Label.
    private G3 category3Label;
    // a number that checks how the "Nodes" should be Organized.
    private int groupingCategory;

    /**
     *  this will instantiate the variables (@code size,groupingCategory)
     *  which the constructor is used.
     *
     *  this public constructor will instantiate the (@code size) and
     *  (@code groupingCategory) when creating an empty list.
     *
     */
    public LinkedList() {
        this.size = 0;
        this.groupingCategory = 1;
    }

    /**
     * this will instantiate the variables (@code size) and (@code groupingCategory) to
     * (@code category) for the Linked list
     *
     *  this public constructor will instantiate the (@code size) and
     *  (@code groupingCategory) to (@code category) when creating an empty list.
     *
     * @param category Number to set the (@code groupingCategory).
     */
    public LinkedList(int category) {
        this.size = 0;
        this.groupingCategory = category;
    }

    /**
     * @param file
     * @param category
     */
    public LinkedList(File file, int category) {
        try{

            if (category > 3 || category <= 0){
                throw new IndexOutOfBoundsException("!! Category is greater than 3 or less than or equal to 0 !!");
            }

            Scanner fReader = new Scanner(file);

        }
        catch (FileNotFoundException e){
            System.out.println("!! file not Found !!");
        }
        catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * This will add one new "Node" into the Linked List taking into account what is the current
     * (@code groupingCategory)
     *
     * this method will update the list with a new "Node" checking what the current
     * (@code groupingCategory) is.
     *
     * @param value1 first category value
     * @param value2 Second category value
     * @param value3 third category value
     */
    public void add(G1 value1, G2 value2, G3 value3) {

        this.category1Label = value1;
        this.category2Label = value2;
        this.category3Label = value3;

        if (this.size == 0) {
            Node temp = new Node(this.category1Label, this.category2Label, this.category3Label);
            this.head = temp;
            this.size++;

        } else {

            Node temp = new Node(this.category1Label, this.category2Label, this.category3Label);
            Node current = this.head;

            switch (this.groupingCategory) {
                case 1:
                    if (current.category1.compareTo(this.category1Label) != 0) {

                        boolean checker = true;

                        while (checker) {


                            if (current.category1.compareTo(this.category1Label) == 0 && current != null) {

                                if (current.down == null) {
                                    current.down = temp;
                                    checker = false;
                                }
                                current = current.down;

                            } else {

                                if (current.right == null) {
                                    current.right = temp;
                                    checker = false;
                                }

                                Node old = current;
                                current = current.right;
                                current.left = old;


                            }


                        }
                    } else if (current.category1.compareTo(this.category1Label) == 0) {
                        boolean checker = true;

                        while (checker) {

                            if (current.down == null) {
                                current.down = temp;
                                checker = false;
                            }
                            current = current.down;

                        }


                    }

                    break;
                case 2:

                    if (current.category2.compareTo(this.category2Label) != 0) {


                        boolean checker = true;

                        while (checker) {


                            if (current.category2.compareTo(this.category2Label) == 0 && current != null) {

                                if (current.down == null) {
                                    current.down = temp;
                                    checker = false;
                                }
                                current = current.down;

                            } else {

                                if (current.right == null) {
                                    current.right = temp;
                                    checker = false;
                                }

                                Node old = current;
                                current = current.right;
                                current.left = old;


                            }


                        }
                    } else if (current.category2.compareTo(this.category2Label) == 0) {
                        boolean checker = true;

                        while (checker) {

                            if (current.down == null) {
                                current.down = temp;
                                checker = false;
                            }
                            current = current.down;

                        }


                    }
                    break;

                case 3:

                    if (current.category3.compareTo(this.category3Label) != 0) {


                        boolean checker = true;

                        while (checker) {


                            if (current.category3.compareTo(this.category3Label) == 0 && current != null) {

                                if (current.down == null) {
                                    current.down = temp;
                                    checker = false;
                                }
                                current = current.down;

                            } else {

                                if (current.right == null) {
                                    current.right = temp;
                                    checker = false;
                                }

                                Node old = current;
                                current = current.right;
                                current.left = old;


                            }


                        }
                    } else if (current.category3.compareTo(this.category3Label) == 0) {
                        boolean checker = true;

                        while (checker) {

                            if (current.down == null) {
                                current.down = temp;
                                checker = false;
                            }
                            current = current.down;

                        }


                    }
                    break;

                default:
                    break;
            }
            this.size++;
        }


    }

    /**
     * this will delete one single "Node" from the list and return the same list updated with
     * the nodes still attached to each other
     *
     * this method will delete one "Node" and update the list with each node still connected
     * to each other
     *
     * @param mainIndex a number from the main-list from (@code groupingCategory)
     * @param subIndex a number from the Sub-list
     */
    public void delete(int mainIndex, int subIndex) {

        if (this.head == null) {
            System.out.println("the list is empty");
            return;
        } else if (mainIndex < 0 && subIndex < 0) {
            System.out.println("main Index must be greater than 0");
            return;
        } else if (mainIndex > size()) {
            System.out.println("main index is greater than size!!");
            return;
        } else if (mainIndex == 0 && subIndex == 0) {
            this.deleteFirst();
        } else if ( (mainIndex == size()-1) && subIndex == 0) {
            this.deleteLast();
        } else {

            Node current = this.head;

            int counter = 0;

            while (counter < mainIndex) {
                current = current.right;
                counter++;
            }

            if (subIndex >= 1) {

                if (current.down == null) {
                    System.out.println("there is no Sub index");
                    return;
                }

                int downCounter = 0;

                while (downCounter < (subIndex - 1)) {
                    current = current.down;
                    downCounter++;
                }

                Node skip = current.down;

                if (skip == null || skip.down == null) {
                    current.down = null;
                } else {
                    current.down = current.down.down;
                }
                this.size--;
            }
                else if (subIndex == 0) {

                    if (current.down == null) {
                        Node prev = current.left;
                        prev.right = current.right;
                        current.right.left = prev;

                    } else {
                        Node below = current.down;
                        below.left = current.left;
                        below.right = current.right;
                        current.left.right = below;
                        current.right.left = below;
                    }
                    this.size--;
                }

        }
    }

    /**
     * this will return a String of the the category chosen by the user from the Main-List.
     *
     * this method will check if the Main-index exist and will return the category
     * from that "Node" in the list.
     *
     * @param mainIndex a number from the list starting from 0
     * @param category the category the user chooses to see
     *
     * @return the category from the Main-List.
     */
    public String get(int mainIndex, int category) {
        String result = "";

        try {

            if (mainIndex >= this.size || mainIndex < 0) {
                throw new IndexOutOfBoundsException("!! Main Index was greater than (or equal to) or less than the size of the list !!");
            } else if (category > 3 || category <= 0) {
                throw new IndexOutOfBoundsException("!! category was greater than 3 or  less than ( or equal to ) zero !!");
            } else {

                Node current = this.head;
                int counter = 0;

                while (counter < mainIndex) {
                    current = current.right;
                    counter++;
                }

                if (category == 1) {
                    result = String.valueOf(current.getCategory1());
                } else if (category == 2) {
                    result = String.valueOf(current.getCategory2());
                } else {
                    result = String.valueOf(current.getCategory3());
                }

            }
        } catch (IndexOutOfBoundsException e) {
            result = e.getMessage();
        }


        return result;
    }

    /**
     *  this will return a String of the the category chosen by the user from the Sub-List.
     *
     * this method will check if the Sub-index and Main-Index exist and will return the category
     * from that "Node" in the list.
     *
     * @param mainIndex a number from the list starting from 0
     * @param subIndex a number from the Sub-list starting at 0
     * @param category the category the user chooses to see
     *
     * @return the category from the Sub-List.
     */
    public String get(int mainIndex, int subIndex, int category) {
        String result = "";
        try{
            if(mainIndex >= this.size || mainIndex < 0){
                throw new IndexOutOfBoundsException("!! Main Index was greater than (or equal to) or less than the size of the list !!");
            }
            else if(category > 3 || category <= 0){
                throw new IndexOutOfBoundsException("!! category was greater than 3 or  less than ( or equal to ) zero !!");
            }
            else if(subIndex < 0){
                throw new IndexOutOfBoundsException("!! Sub Index was less than zero. !!");
            }
            else{
                int counter = 0;

                Node current = this.head;

                while(counter < mainIndex){
                    current = current.right;
                    counter++;
                }

                int downCounter = 0;

                current = current.down;

                while(downCounter < subIndex && current != null){
                    current = current.down;
                    downCounter++;
                }

                if (current == null){
                    throw new IndexOutOfBoundsException("!! Sub Index does not Exist !!");
                }
                else{

                    if (category == 1){
                        result = String.valueOf(current.getCategory1());
                    }
                    else if (category == 2){
                        result = String.valueOf(current.getCategory2());
                    }
                    else{
                        result = String.valueOf(current.getCategory3());
                    }

                }
            }
        }
        catch (IndexOutOfBoundsException e){
            result = e.getMessage();
        }

        return result;
    }

    /**
     * this will update the Linked list with the new (@code groupingCategory)
     *
     * this method will change the (@code groupingCategory) to the new Number and update
     * the list accordingly
     *
     * @param groupingCategoryNumber the new (@code groupingCategory)
     */
    public void regroup(int groupingCategoryNumber) {
        try {
            if (groupingCategoryNumber > 3) {
                throw new IndexOutOfBoundsException("Index was greater than the 3 categories in the list");
            } else if (groupingCategoryNumber <= 0) {
                throw new IndexOutOfBoundsException("Index was less than or equal to zero");
            }
//            else if(groupingCategoryNumber == groupingCategory){
//                throw new IndexOutOfBoundsException("Number is already equal the group");
//            }

                else {

                this.groupingCategory = groupingCategoryNumber;

                Node current = this.head;

                int copySize = 0;

                if (current == null){
                    return;
                }
                else{



                    LinkedList<G1, G2, G3> copy = new LinkedList<>(groupingCategory);

                    while(current != null && copySize < size()){

                        G1 one =  (G1)current.getCategory1();
                        G2 two = (G2) current.getCategory2();
                        G3 three = (G3) current.getCategory3();

                        copy.add(one,two,three);

                        if (current.down == null){

                            int Maincounter = 0;

                            copySize++;

                            current = this.head;

                            while(Maincounter < copySize){

                                current = current.right;
                                Maincounter++;
                            }

                        }
                        else{

                            current = current.down;
                        }

                    }

                    this.size = copy.size;
                    this.head = copy.head;

                }

            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * this will delete the first node in the Main-List and reattach any sub-List
     * back into the Main-list so to not lose any Nodes in the process
     *
     * this method will update the list with the first node deleting and reattach
     * the sub list to be in the Main-List
     *
     */
    public void deleteFirst() {

        if (this.head == null) {
            return;
        }

        else if(this.head.down == null){


            if(this.head.right == null) {
                System.out.println("list is empty");
                    this.size = 0;
                    this.head = null;
                    return;
            }
            this.head = this.head.right;
            this.size--;
        }
        else {

            Node old = this.head.down;

            if (this.head.right != null){
                old.right = this.head.right;
                this.head.right.left = old;
                this.head = old;
            }
            else{
                this.head = old;
            }

            this.size--;
        }
    }

    /**
     * this will delete the last node in the Main-List and reattach any sub-List
     * back into the Main-list so to not lose any Nodes in the process
     *
     * this method will update the list with the last node deleting and reattach
     * the sub list to be in the Main-List if it exist
     */
    public void deleteLast() {


        if (this.head == null) {
            return;
        }
        else {
            Node current = this.head;

            while (current.right != null) {
                current = current.right;
            }

            if (current.down == null){

                if (current.left != null){
                    this.size--;

                    current = current.left;
                    current.right = null;
                }
                else{
                    this.head = null;
                    this.size = 0;
                }


            }
            else{

                Node old = current.down;

                if (current.left != null){

                    old.left = current.left;
                    current.left.right = old;
                    this.size--;
                }
                else{

                    current = old;
                    this.head = current;
                    this.size--;
                }


            }



        }
    }

    /**
     * this will clear the list of any "Nodes" and reset the values to default
     *
     * this method will reset the list to null and (@code groupingCategory) to 1 and
     * size to be zero
     */
    public void clear() {
        this.groupingCategory = 1;
        this.head = null;
        this.size = 0;
    }

    /**
     * this will return the size of the Main-list from the Linked list
     *
     * this method will check how many "Nodes" are in the Main-List
     *
     * @return the number of "Nodes" in the Main-List
     */
    public int size() {
        if (this.head == null){
            return 0;
        }
        else{

            int counter = 0;
            Node current = this.head;
            while(current != null){
                current = current.right;
                counter++;
            }

            return counter;
        }
    }

    /**
     * this will return the size of the Sub-list from the Linked list
     *
     * this method will check how many "Nodes" are in the Sub-List relative from the Main-list
     *
     * @param index the number of where to stop from the Main-List
     * @return the number of "Nodes" in the Sub-list relative to the Main-List
     */
    public int size(int index) {

        try{

            if (index < 0){
                throw new IndexOutOfBoundsException("!! Index was less than zero !!");
            }

            int subList = 0;
            int counter = 0;
            Node current = this.head;

            while (counter < index && current != null){
                current = current.right;
                counter++;
            }

            if (current == null){
                throw new IndexOutOfBoundsException("!! Index was greater than the size of the List !!");
            }
            else{

                while (current != null){
                    current = current.down;
                    subList++;
                }

                return subList;

            }

        }
        catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            return 0;
        }
    }

    /**
     * @return
     */
    public String toString() {

        String value = "";

        Node current = this.head;

        while (current != null) {

            if (groupingCategory == 1){
                value += current.getCategory1() + " " + current.getCategory2() + " " + current.getCategory3() + "\n";
            }
            else if (groupingCategory == 2){
                value += current.getCategory2() + " " + current.getCategory3() + " " + current.getCategory1() + "\n";
            }
            else{
                value += current.getCategory3() + " " + current.getCategory1() + " " + current.getCategory2() + "\n";
            }

            current = current.right;

        }

        return value;
    }


}
