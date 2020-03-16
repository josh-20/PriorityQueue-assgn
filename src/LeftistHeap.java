public class LeftistHeap<Anytype extends Comparable<? super Anytype>> {
    private Node<Anytype> root;
    public LeftistHeap(){root = null;}
    private static class Node<Anytype>{
        Node(Anytype theElement){
            this( theElement, null, null );
        }
        Node(Anytype theElement, Node<Anytype> lt, Node<Anytype> rt,){
            element = theElement;
            left = lt;
            right = rt;
            npl = 0;
        }
        Anytype element;
        Node<Anytype> left;
        Node<Anytype> right;
        int npl;
    }
    private Node<Anytype> root;
    public void merge(LeftistHeap<Anytype> rhs){

    }
    public void insert(Anytype x){

    }
    public Anytype findMin(){

    }
    public Anytype deleteMin(){

    }
    public boolean isEmpty(){return root == null;}
    public void makeEmpty(){root = null;}


}
