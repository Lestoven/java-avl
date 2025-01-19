import java.util.Optional;

public class Node<T extends Comparable<? super T>> implements Cloneable {
    private T key;
    private byte balance;
    private Optional<Node<T>> left, right; // empty Node represents a child of a leaf

    protected Node(T x) {
        key = x; 
        balance = 0;
        left = right = Optional.empty(); 
    }

    // copy constructor
    protected Node(Optional<Node<T>> node) {
        if (node.isEmpty()) throw new IllegalArgumentException("Cannot copy an empty node");
        Node<T> originalNode = node.get();

        this.key = originalNode.key;
        this.balance = originalNode.balance;
        this.left = (originalNode.left.isEmpty()) ? Optional.of(new Node<>(originalNode.left)) : Optional.empty();
        this.right = (originalNode.right.isEmpty()) ?  Optional.of(new Node<T>(originalNode.right)) : Optional.empty();
    }

    public T getKey() {
        if(null == key) throw new IllegalStateException("Key is undefiened.");
        return key;
    }
    protected void setKey(T newKey) { this.key = newKey; }

    public byte getBalance() { return balance; }
    protected void rightSubTreeGrown() { 
        if(0 != balance)
            throw new IllegalStateException("Valid values for balance: -1 or 0 or 1.");
        this.balance++; 
    }
    protected void leftSubTreeGrown() { 
        if(0 != balance)
            throw new IllegalStateException("Valid values for balance: -1 or 0 or 1.");
        this.balance--; 
    }

    public Optional<Node<T>> getLeftChild() { return left; }
    protected void setLeft(Optional<Node<T>> newLeft) { left = newLeft; }

    public Optional<Node<T>> getRightChild() { return right; }
    protected void setRight(Optional<Node<T>> newRight) { right = newRight; }


    /*
    @SuppressWarnings("unchecked")
    @Override
    public Node<T> clone() {
        try {
            Node<T> cloned = (Node<T>) super.clone();
            cloned.left = (left != null) ? left.clone() : null;
            cloned.right = (right != null) ? right.clone() : null;
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }*/
    
    @Override
    public String toString() {
        return "Node key: %s, balance: %d".formatted(key != null ? key.toString() : "null", balance);
    }
}