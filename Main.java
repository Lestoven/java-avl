public class Main {
    public static void main(String[] args) {
        /*Node<Integer> root = new Node<>(10);
        //Avl.avlInsert(root, 12, new BooleanWrapper(false));
        root = Avl.avlInsert(root, 4, new BooleanWrapper(false));

        System.out.println(root);
        System.out.println(root.getRight());
        System.out.println(root.getLeft());

        root = Avl.avlInsert(root, 3, new BooleanWrapper(false));

        System.out.println(root);
        System.out.println(root.getRight());
        System.out.println(root.getLeft());

        root = Avl.avlInsert(root, 2, new BooleanWrapper(false));
        root = Avl.avlInsert(root, 1, new BooleanWrapper(false));

        System.out.println(root);
        System.out.println(root.getRight());
        System.out.println(root.getLeft());
        System.out.println(root.getLeft().getLeft());
        System.out.println(root.getLeft().getRight());*/

        Node<Integer> root = new Node<>(30);
        //Avl.avlInsert(root, 12, new BooleanWrapper(false));
        root = Avl.avlInsert(root, 112, new BooleanWrapper(false));
        root = Avl.avlInsert(root, 20, new BooleanWrapper(false));

        root = Avl.avlInsert(root, 15, new BooleanWrapper(false));
        root = Avl.avlInsert(root, 22, new BooleanWrapper(false));
        root = Avl.avlInsert(root, 21, new BooleanWrapper(false));

        System.out.println(root);
        System.out.println(root.getRight());
        System.out.println(root.getRight().getLeft());
        System.out.println(root.getRight().getRight());
        System.out.println(root.getLeft());
        System.out.println(root.getLeft().getLeft());
        System.out.println(root.getLeft().getRight());

        //Avl.printTree(root, "", true);
    }
}