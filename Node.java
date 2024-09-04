public class Node<T extends Comparable<? super T>> implements Cloneable {
    private T key;
    private short balance;
    private Node<T> left, right;

    public Node() {
        key = null;
        balance = 0;
        left = right = null; 
    }

    public Node(T x) {
        key = x; 
        balance = 0;
        left = right = null; 
    }

    public T getKey() {
        if(null == key)
            throw new IllegalStateException("Key is undefiened.");
        return key;
    }

    public void setKey(T newKey) {
        this.key = newKey;
    }

    public short getBalance() {
        return balance;
    }

    public void setBalance(short newBalance) {
        if(newBalance < -1 || newBalance > 1)
            throw new IllegalStateException("Valid values for balance: -1 or 0 or 1.");
        this.balance = newBalance;
    }

    public Node<T> getLeft() { return left; }
    public void setLeft(Node<T> newLeft) { left = newLeft; }
    public Node<T> getRight() { return right; }
    public void setRight(Node<T> newRight) { right = newRight; }


    @Override
    public String toString() {
        return "Node key: %s, balance: %d".formatted(key != null ? key.toString() : "null", balance);
    }

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
    }
}