
/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;



/**
 * Implementation of a positional list stored as a doubly linked list.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class  CircularLinkedPositionalList<E extends Comparable<E>> implements PositionalList<E> {

    private Node<E> header;
    private int size; 
    public Iterator<E> iterator(){
        return null;
    }
    //---------------- nested Node class ----------------
    /**
     * Node of a  linked list, which stores a reference to its
     * element and to both the previous and next node in the list.
     */
    private static class Node<E> implements Position<E> {

        /** The element stored at this node */
        private E element;               // reference to the element stored at this node

        /** A reference to the preceding node in the list */
        private Node<E> prev;            // reference to the previous node in the list

        /** A reference to the subsequent node in the list */
        private Node<E> next;            // reference to the subsequent node in the list

        /**
         * Creates a node with the given element and next node.
         *
         * @param e  the element to be stored
         * @param p  reference to a node that should precede the new node
         * @param n  reference to a node that should follow the new node
         */
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public Integer getIntegerAmount() {
            String empty="";
            if(element!=null) {
                empty+=element;
                return Integer.parseInt(empty);	//	Burada alinan E nesnesi string uzerinden parse edilir.
            }
            return 0;
        }


        // public accessor methods
        /**
         * Returns the element stored at the node.
         * @return the stored element
         * @throws IllegalStateException if node not currently linked to others
         */
        public E getElement() throws IllegalStateException {
            if (next == null)                         // convention for defunct node
                throw new IllegalStateException("Position no longer valid");
            return element;
        }

        /**
         * Returns the node that precedes this one (or null if no such node).
         * @return the preceding node
         */
        public Node<E> getPrev() {
            return prev;
        }

        /**
         * Returns the node that follows this one (or null if no such node).
         * @return the following node
         */
        public Node<E> getNext() {
            return next;
        }

        // Update methods
        /**
         * Sets the node's element to the given element e.
         * @param e    the node's new element
         */
        public void setElement(E e) {
            element = e;
        }

        /**
         * Sets the node's previous reference to point to Node n.
         * @param p    the node that should precede this one
         */
        public void setPrev(Node<E> p) {
            prev = p;
        }

        /**
         * Sets the node's next reference to point to Node n.
         * @param n    the node that should follow this one
         */
        public void setNext(Node<E> n) {
            next = n;
        }
    }
    //----------- end of nested Node class -----------

    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
        Node<E> node = (Node<E>) p;     // safe cast
        if (node.getNext() == null)     // convention for defunct node
            throw new IllegalArgumentException("p is no longer in the list");
        return node;
    }

    /** Constructs a new empty list. */
    public CircularLinkedPositionalList() {
        size=0;
        header= new Node<E>(null, header, header);
        header.setNext(header);
        header.setPrev(header);
    }
    

     
    /**
     * Returns the given node as a Position, unless it is a sentinel, in which case
     * null is returned (so as not to expose the sentinels to the user).
     */
    private Position<E> position(Node<E> node) {
        if(node == header)
            return null;
        return node;
    }

    // public accessor methods
    /**
     * Returns the number of elements in the list.
     * @return number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Tests whether the list is empty.
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if(size==0){
            return true;
        }
        return false;
    }

    /**
     * Returns the first Position in the list.
     *
     * @return the first Position in the list (or null, if empty)
     */
    @Override
    public Position<E> first() {
        return position(header.getNext());
    }

    /**
     * Returns the last Position in the list.
     *
     * @return the last Position in the list (or null, if empty)
     */
    @Override
    public Position<E> last() {
        return position(header.getPrev());
    }

    /**
     * Returns the Position immediately before Position p.
     * @param p   a Position of the list
     * @return the Position of the preceding element (or null, if p is first)
     * @throws IllegalArgumentException if p is not a valid position for this list
     */
    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> p1=validate(p);
        return p1.getPrev();
    }

    /**
     * Returns the Position immediately after Position p.
     * @param p   a Position of the list
     * @return the Position of the following element (or null, if p is last)
     * @throws IllegalArgumentException if p is not a valid position for this list
     */
    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> p1=validate(p);
        return p1.getNext();
    }

    // private utilities
    /**
     * You do not have to implement addBetween method.
     * Adds an element to the linked list between the given nodes.
     * The given predecessor and successor should be neighboring each
     * other prior to the call.
     *
     * @param pred     node just before the location where the new element is inserted
     * @param succ     node just after the location where the new element is inserted
     * @return the new element's node
     */

    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> k=new Node<E>(e, pred, succ);
        size++;
        pred.setNext(k);
        succ.setPrev(k);
        return k;
    }

    // public update methods
    /**
     * Inserts an element at the front of the list.
     *
     * @param e the new element
     * @return the Position representing the location of the new element
     */
    @Override
    public Position<E> addFirst(E e) {       // just after the header
        return addBetween(e, header, header.getNext());
    }

    /**
     * Inserts an element at the back of the list.
     *
     * @param e the new element
     * @return the Position representing the location of the new element
     */
    @Override
    public Position<E> addLast(E e) {
           // just before the header
           return addBetween(e, header.getPrev(), header);
    }

    /**
     * Inserts an element immediately before the given Position.
     *
     * @param p the Position before which the insertion takes place
     * @param e the new element
     * @return the Position representing the location of the new element
     * @throws IllegalArgumentException if p is not a valid position for this list
     */
    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> p1=validate(p);
        return addBetween(e,p1.getPrev(),p1);
    }

    /**
     * Inserts an element immediately after the given Position.
     *
     * @param p the Position after which the insertion takes place
     * @param e the new element
     * @return the Position representing the location of the new element
     * @throws IllegalArgumentException if p is not a valid position for this list
     */
    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> p1=validate(p);
        return addBetween(e,p1,p1.getNext());
    }

    /**
     * Replaces the element stored at the given Position and returns the replaced element.
     *
     * @param p the Position of the element to be replaced
     * @param e the new element
     * @return the replaced element
     * @throws IllegalArgumentException if p is not a valid position for this list
     */
    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> p1=validate(p);
        p1.setElement(e);
        return e;
    }

    /**
     * Removes the element stored at the given Position and returns it.
     * The given position is invalidated as a result.
     *
     * @param p the Position of the element to be removed
     * @return the removed element
     * @throws IllegalArgumentException if p is not a valid position for this list
     */
    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> p1=validate(p);
        size--;
        p1.getPrev().setNext(p1.getNext());
        p1.getNext().setPrev(p1.getPrev());
        p1.setNext(null);
        return p1.element;
    }


    // Debugging code
    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
        Node<E> e;
        String upperside="";
        String lowerside="";
        e=header.getNext();
        for (int i = 0; i < (size+1)/2-1; i++) {
            upperside +="\t" + e.getNext().getElement();
            e=e.getNext();
        }
        E inf=e.getNext().getElement();
        if(size%2==1){
            lowerside +="\t ";
        }
        e=header;
        for (int i = 0; i < size/2-1; i++) {
            lowerside +="\t" + e.getPrev().getElement();
            e=e.getPrev();
        }
        String total="";
        total+=upperside+"\n";
        String mid=header.getNext().getElement().toString();
        for (int i = 0; i < (size+1)/2; i++) {
            mid+="\t";
        }
        mid+=inf.toString();
        total+=mid +"\n";
        total+=lowerside;







        return total;




































    }
}
