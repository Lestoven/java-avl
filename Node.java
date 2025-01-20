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
        if (!node.isPresent()) throw new IllegalArgumentException("Cannot copy an empty node");
        Node<T> originalNode = node.get();

        this.key = originalNode.key;
        this.balance = originalNode.balance;
        this.left = (originalNode.left.isPresent()) ? Optional.of(new Node<>(originalNode.left)) : Optional.empty();
        this.right = (originalNode.right.isPresent()) ?  Optional.of(new Node<T>(originalNode.right)) : Optional.empty();
    }

    public T getKey() {
        if (null == key) throw new IllegalStateException("Key is undefiened.");
        return key;
    }
    protected void setKey(T newKey) { this.key = newKey; }

    public byte getBalance() { return balance; }
    protected void rightSubTreeGrown() { 
        assert balance == 0 || balance == -1 : "Increaseing balance is only valid if the current balance is 0 or -1.";
        this.balance++; 
    }
    protected void leftSubTreeGrown() { 
        assert balance == 0 || balance == 1 : "Decreasing balance is only valid if the current balance is 0 or 1.";
        this.balance--; 
    }
    protected void setBalance(byte balance) {
        assert balance == -1 || balance == 0 || balance == 1 : "Increaseing balance is only valid if the current balance is 0 or -1.";
        this.balance = balance;
    }

    public Optional<Node<T>> getLeft() { return left; }
    protected void setLeft(Optional<Node<T>> newLeft) { left = newLeft; }

    public Optional<Node<T>> getRight() { return right; }
    protected void setRight(Optional<Node<T>> newRight) { right = newRight; }
    
    @Override
    public String toString() {
        return "Node key: %s, balance: %d".formatted(key != null ? key.toString() : "null", balance);
    }
}