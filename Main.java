public class Main {
    public static void main(String[] args) {
        AvlTree<Integer> avlTree = new AvlTree<>(30);
        avlTree.insert(7);
        avlTree.insert(40);
        avlTree.insert(32);
        avlTree.insert(50);
        avlTree.insert(4);
        avlTree.insert(18);
        avlTree.insert(20);
        avlTree.insert(35);
        avlTree.insert(42);
        avlTree.insert(60);
        avlTree.insert(55);

        System.out.println("AVL tree: " + avlTree);
        System.out.println("Minimum node: " + avlTree.remMin());
        System.out.println("AVL tree after removing the minimum node: " + avlTree);

        avlTree.delete(40);
        System.out.println("AVL tree after deleting the node with the key of '40': " + avlTree);
        System.out.println("Height: " + avlTree.getHeight());
    }
}