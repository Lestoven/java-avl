import java.util.Optional;

public class AvlTree<T extends Comparable<? super T>>  {
    private Optional<Node<T>> root;

    public AvlTree() { root = Optional.empty(); } // create an empty tree
    public AvlTree(T key) { root = Optional.of(new Node<>(key)); }

    public void insert(T newKey) {
        if (!root.isPresent()) {
            root = Optional.of(new Node<>(newKey));
        } else {
            root = Optional.of(insert(root.get(), newKey, new BooleanWrapper(false)));
        }
    }

    private Node<T> insert(Node<T> node, T newKey, BooleanWrapper heightGrown) {
        if(0 == node.getKey().compareTo(newKey)) {
            heightGrown.setValue(false);
        } else if (0 < node.getKey().compareTo(newKey)) {
            Optional<Node<T>> left = node.getLeft();
            if (!left.isPresent()) {
                node.setLeft(Optional.of(new Node<>(newKey)));
                heightGrown.setValue(true);
            } else {
                node.setLeft(Optional.of(insert(left.get(), newKey, heightGrown)));
            }

            if (heightGrown.getValue()) {
                node = leftSubTreeGrown(node, heightGrown);
            }
        } else {
            Optional<Node<T>> right = node.getRight();
            if (!right.isPresent()) {
                node.setRight(Optional.of(new Node<>(newKey)));
                heightGrown.setValue(true);
            } else {
                node.setRight(Optional.of(insert(right.get(), newKey, heightGrown)));
            }

            if (heightGrown.getValue()) {
                node = rightSubTreeGrown(node, heightGrown);
            }
        }

        return node;
    }

    private Node<T> leftSubTreeGrown(Node<T> node, BooleanWrapper heightGrown) {
        assert node.getLeft().isPresent() : "Left sub tree cannot be empty!";

        if (-1 == node.getBalance()) {
            Node<T> left = node.getLeft().get();
            if(-1 == left.getBalance()) {
                node = balanceMMm(node, left);
            } else {
                node = balanceMMp(node, left);
            }
            heightGrown.setValue(false);
        } else {
            node.leftSubTreeGrown();
            heightGrown.setValue(node.getBalance() < 0);
        }

        return node;
    }

    private Node<T> rightSubTreeGrown(Node<T> node, BooleanWrapper heightGrown) {
        assert node.getRight().isPresent() : "Right sub tree cannot be empty!";

        if (1 == node.getBalance()) {
            Node<T> right = node.getRight().get();
            if(1 == right.getBalance()) {
                node = balancePPp(node, right);
            } else {
                node = balancePPm(node, right);
            }
            heightGrown.setValue(false);
        } else {
            node.rightSubTreeGrown();
            heightGrown.setValue(node.getBalance() > 0);
        }

        return node;
    }

    private Node<T> balanceMMm(Node<T> node, Node<T> left) {
        node.setLeft(left.getRight());
        left.setRight(Optional.of(node));
        node.setBalance((byte)0);
        left.setBalance((byte)0);
        return left;
    }

    private Node<T> balanceMMp(Node<T> node, Node<T> left) {
        assert node.getRight().isPresent() : "Right sub tree of node cannot be empty!";

        Node<T> right = left.getRight().get();
        left.setRight(right.getLeft());
        node.setLeft(right.getRight());
        right.setLeft(Optional.of(left));
        right.setRight(Optional.of(node));
        int balanceLeft = -(int)((right.getBalance() + 1)/2);
        int balanceNode = (int)((1 - right.getBalance())/2);
        left.setBalance((byte)balanceLeft);
        node.setBalance((byte)balanceNode);
        right.setBalance((byte)0);
        return right;
    }

    private Node<T> balancePPp(Node<T> node, Node<T> right) {
        node.setRight(right.getLeft());
        right.setLeft(Optional.of(node));
        node.setBalance((byte)0);
        right.setBalance((byte)0);
        return right;
    }

    private Node<T> balancePPm(Node<T> node, Node<T> right) {
        assert node.getLeft().isPresent() : "Left sub tree of node cannot be empty!";

        Node<T> left = right.getLeft().get();
        node.setRight(left.getLeft());
        right.setLeft(left.getRight());
        left.setLeft(Optional.of(node));
        left.setRight(Optional.of(right));
        int balanceNode = -(int)((left.getBalance() + 1)/2);
        int balanceRight = (int)((1 - left.getBalance())/2);
        node.setBalance((byte)balanceNode);
        right.setBalance((byte)balanceRight);

        left.setBalance((byte)0);
        return left;
    }

    //public Node getRoot() { return new Node(root); }
    public boolean isEmptyTree() { return !root.isPresent(); }
    public Optional<Node<T>> getRoot() { return root; }

    public int getHeight() {
        int height = -1;

        Optional<Node<T>> node = root;
        while(node.isPresent()) {
            if (node.get().getBalance() == 1) {
                node = node.get().getRight();
            } else {
                node = node.get().getLeft();
            }
        }

        return height;
    }

    private void printTree(Node<T> node, StringBuilder sb) {
        if (node.getLeft().isPresent()) {
            sb.append("(");
            printTree(node.getLeft().get(), sb);
            sb.append(")");
        }
        sb.append(node.getLeft().isPresent() || node.getRight().isPresent() ? " " + node.getKey().toString() + " " : node.getKey().toString());
        if (node.getRight().isPresent()) {
            sb.append("(");
            printTree(node.getRight().get(), sb);
            sb.append(")");
        }
    }

    @Override
    public String toString() {
        if(!root.isPresent()) return "()";
        StringBuilder sb = new StringBuilder();
        printTree(root.get(), sb);
        return sb.toString();
    }
}