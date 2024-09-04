public class Avl {
    public static <T extends Comparable<? super T>> Node<T> avlInsert(Node<T> t, T newKey, BooleanWrapper d) {
        if(null == t) {
            t = new Node<T>(newKey);
            d.value = true;
        } else if(t.getKey().compareTo(newKey) > 0) { // if newKey is smaller
            t.setLeft(avlInsert(t.getLeft(), newKey, d));
            if(d.value) {
                t = leftSubTreeGrown(t, d);
            }
        }  
        else if(t.getKey().compareTo(newKey) < 0) { // if newKey is bigger
            t.setRight(avlInsert(t.getRight(), newKey, d));
            if(d.value) {
                t = rightSubTreeGrown(t, d);
            }
        } else { // if newKey is already inside "t"
            // Ignore
        }

        return t;
    } 

    private static <T extends Comparable<? super T>> Node<T> leftSubTreeGrown(Node<T> t, BooleanWrapper d) {
        if(t.getBalance() == -1) {
            Node<T> l = t.getLeft();
            if(-1 == l.getBalance()) {
                t = balanceMMm(t, l);
            } else {
                t = balanceMMp(t, l);
            }
            d.value = false;
        } else {
            t.setBalance((short)(t.getBalance() - 1));
            d.value = t.getBalance() < 0;
        }
        return t;
    }

    private static <T extends Comparable<? super T>> Node<T> rightSubTreeGrown(Node<T> t, BooleanWrapper d) {
        if(t.getBalance() == 1) {

        } else {
            t.setBalance((short)(t.getBalance() + 1));
            d.value = t.getBalance() > 0;
        }
        return t;
    }

    private static <T extends Comparable<? super T>> Node<T> balanceMMm(Node<T> t, Node<T> l) {
        t.setLeft(l.getRight());
        l.setRight(t);
        t.setBalance((short)0);
        l.setBalance((short)0);
        return l;
    }

    private static <T extends Comparable<? super T>> Node<T> balanceMMp(Node<T> t, Node<T> l) {
        Node<T> r = l.getRight();
        l.setRight(r.getLeft());
        t.setLeft(r.getRight());
        r.setLeft(l);
        r.setRight(t);
        int balanceLeft = -(int)((r.getBalance() + 1)/2);
        int balanceRight = -(int)((1 - r.getBalance())/2);
        l.setBalance((short)balanceLeft);
        r.setBalance((short)balanceRight);
        r.setBalance((short)0);
        return r;
    }

    public static void printTree(Node<?> node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                indent += "   ";
            } else {
                indent += "|  ";
            }
            System.out.println(node.getKey());
            printTree(node.getLeft(), indent, false);
            printTree(node.getRight(), indent, true);
        }
    }
}