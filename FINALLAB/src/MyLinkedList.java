import java.util.NoSuchElementException;

/**
 * A simple singly-linked LinkedList class
 *
 * <p>Purdue University -- CS18000 -- Spring 2020 -- LB15</p>
 */

public class MyLinkedList {
    private Node head;
    //TO DO: Add MyLinkedList data member head

    /**
     * Simple Node class, represents a Node
     * contained within a MyLinkedList instance
     */
    private class Node {

        //TO DO: Add Node data members
        int data;
        Node link;

        /**
         * Constructor for Node
         *
         * @param data Integer data associated with the Node
         */
        Node(int data) {
            //TO DO: initialize data to the parameter and link to null
            this.data = data;
            this.link = null;
        }
    }

    /**
     * Default constructor for MyLinkedList class
     */
    public MyLinkedList() {
        //TO DO: initialize head to null
        this.head = null;
    }

    /**
     * A method to create and insert a node at the end of the list
     *
     * @param data Integer data associated with the new Node
     */
    public void addNode(int data) {
        //TO DO
        Node newEntry = new Node(data);

        if (head == null) {
            head = newEntry;
            return;
        }
        Node current = head;
        while (current.link != null) {
            current = current.link;
        }
        current.link = newEntry;
    }


    /**
     * A method to delete the first occurrence of a Node whose data matches value.
     *
     * @param value Integer value associated with the Node to be deleted.
     * @throws NoSuchElementException if the specified value is not in the list.
     */
    public void deleteNode(int value) throws NoSuchElementException {
        //TO DO
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node current = head;
        Node previous = null;
        if (current.data == value) {
            head = current.link;
            return;
        }
        while (current != null && current.data != value) {
            previous = current;
            current = current.link;
        }
        if (current == null) {
            throw new NoSuchElementException();
        }
        previous.link = current.link;
    }

    /**
     * A helper function to print out an
     * instance of MyLinkedList to help
     * visualize the list and assist with debugging
     */
    public void printList() {
        Node current = this.head;
        System.out.println("-----");
        while (current != null) {
            if (current.link != null) {
                System.out.print(current.data + "->");
            } else {
                System.out.println(current.data + "->X");
            }
            current = current.link;
        }
        System.out.println("-----");
    }


}