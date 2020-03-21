public class LeftistHeap<Anytype extends Comparable<? super Anytype>> {
    public LeftistHeap(){root = null;}
    private static class Node<Anytype>{
        Node(Anytype theElement){
            this( theElement, null, null );
        }
        Node(Anytype theElement, Node<Anytype> lt, Node<Anytype> rt){
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

    // All Merge -----------------------------------------------------------
    public void merge(LeftistHeap<Anytype> n){
        if (this == null){
            return;
        }
        root = merge(root,n.root);
        n.root = null;
    }
    public void insert(Anytype x){
        root = merge(new Node<>(x),root);
    }
   public Anytype findMin(){
        return root.element;

   }
    public Anytype deleteMin(){
        if (isEmpty())
            System.out.println("Node is Empty");
        Anytype minItem = root.element;
        root = merge(root.left,root.right);
        return minItem;
    }
    public boolean isEmpty(){return root == null;}
    public void makeEmpty(){root = null;}
    private Node<Anytype> merge ( Node<Anytype> h1, Node<Anytype> h2){
        if(h1 == null) return h2;
        if( h2 == null) return h1;
        if( h1.element.compareTo(h2.element) < 0)return merge1(h1,h2);
        else
            return merge1(h2,h1);

    }
    private Node<Anytype> merge1(Node<Anytype> h1, Node<Anytype> h2){
        if( h1.left == null) h1.left = h2;
        else{
            h1.right = merge( h1.right, h2 );
            if( h1.left.npl < h1.right.npl ){
                swapChildren(h1);
            }
            h1.npl = h1.right.npl + 1;
        }
        return h1;
    }
    private void swapChildren(Node<Anytype> h1){
        Node<Anytype> tempL = h1.left;
        Node<Anytype> tempR = h1.right;
        h1.right = tempL;
        h1.left = tempR;
    }
    public void printTree()
    {
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else
            printTree( root,"");
    }
    private void printTree( Node<Anytype> t, String indent )
    {
        if( t != null )
        {
            printTree( t.right, indent+"   " );
            System.out.println( indent+ t.element );
            printTree( t.left, indent+"   " );
        }
    }

    // -------------------------------------------------------------------
}
