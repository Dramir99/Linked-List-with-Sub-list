package hw05;

/**
 *  This class is a Generic class which will be a single "Node" in my (@code LinkedList)
 *  class that has three different parameters.
 *
 * @author daniel ramirez
 * @version 1.0
 * @param <G1> Generic Type one
 * @param <G2> Generic Type two
 * @param <G3> Generic Type third
 */

public class Node <G1 extends Comparable<G1>,G2 extends Comparable<G2>,G3 extends Comparable<G3>> {

    //first category.
    protected G1 category1;
    //second category.
    protected G2 category2;
    //third category.
    protected G3 category3;

    //Variable used to move to the right(next) in a linked list.
    protected Node right;
    //Variable used to move to left(backwards) in a linked list.
    protected Node left;
    //Variable used to move to down(Sub-List) in a linked list.
    protected Node down;

    /**
     *  this will instantiate the variables (@code category1,category2,category3)
     *  which the constructor is used.
     *
     *  this public constructor will instantiate the three different parameters
     *  for each category
     *
     * @param category1 First category(group) of the Generic type parameter
     * @param category2 Second category(group) of the Generic type parameter
     * @param category3 Third category(group) of the Generic type parameter
     */
    public Node(G1 category1, G2 category2, G3 category3){
        //instantiate the three different parameters.
        this.category1 = category1;
        this.category2 = category2;
        this.category3 = category3;

    }

    /**
     * this will return the Node in the first category from the class (@code Node)
     *
     * this method will return the First category the class (@code Node)
     *
     * @return the first category from the class (@code Node)
     */
    public G1 getCategory1() {
        return this.category1;
    }

    /**
     * this will return the Node in the Second category from the class (@code Node)
     *
     * this method will return the Second category the class (@code Node)
     *
     * @return the second category from the class (@code Node)
     */
    public G2 getCategory2() {
        return this.category2;
    }

    /**
     * this will return the Node in the Third category from the class (@code Node)
     *
     * this method will return the third category the class (@code Node)
     *
     * @return the third category from the class (@code Node)
     */
    public G3 getCategory3() {
        return this.category3;
    }

    /**
     * this will change category one to a new category
     *
     * this method will get the new category the user wants to change it to and
     * will return the new One category
     *
     * @param category1 The First Generic Type Category
     */
    public void setCategory1(G1 category1) {
        this.category1 = category1;
    }

    /**
     * this will change category two to a new category
     *
     * this method will get the new category the user wants to change it to and
     * will return the new Second category
     *
     * @param category2 The Second Generic Type Category
     */
    public void setCategory2(G2 category2) {
        this.category2 = category2;
    }

    /**
     * this will change category three to a new category
     *
     * this method will get the new category the user wants to change it to and
     * will return the new Third category
     *
     * @param category3 The Third Generic Type Category
     */
    public void setCategory3(G3 category3) {
        this.category3 = category3;
    }

}
