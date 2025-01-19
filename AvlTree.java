import java.util.Optional;

public class AvlTree<T extends Comparable<? super T>>  {
    private Optional<Node<T>> root;

    public AvlTree() { root = Optional.empty(); } // create an empty tree
    public AvlTree(T key) { root = Optional.of(new Node<>(key)); }

    //public Node getRoot() { return new Node(root); }
    public boolean isEmptyTree() { return root.isEmpty(); }
    public Optional<Node<T>> getRoot() { return root; }

    public int getHeight() {
        int height = -1;

        Optional<Node<T>> node = root;
        while(!node.isEmpty()) {
            if(node.get().getBalance() == 1) {
                node = node.get().getRightChild();
            } else {
                node = node.get().getLeftChild();
            }
        }

        return height;
    }
}