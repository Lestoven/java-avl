public class Main {
    public static void main(String[] args) {
        AvlTree<Integer> avlTree = new AvlTree<>(11);
 
        avlTree.insert(9);
        avlTree.insert(6);
        avlTree.insert(5);
        avlTree.insert(4);
        
        avlTree.insert(14);
        avlTree.insert(15);
        avlTree.insert(20);
        avlTree.insert(10);
        avlTree.insert(12);
        avlTree.insert(13);

        System.out.println(avlTree.getRoot());
        System.out.println(avlTree.getRoot().get().getLeft());

        System.out.println(avlTree.getRoot().get().getRight());

        System.out.println(avlTree.getRoot().get().getRight().get().getLeft());
        System.out.println(avlTree.getRoot().get().getRight().get().getRight());
    }
}