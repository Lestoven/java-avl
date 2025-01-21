public class Main {
    public static void main(String[] args) {
        /*AvlTree<Integer> avlTree = new AvlTree<>(11);
 
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

        System.out.println(avlTree);

        AvlTree<Integer> smallAvlTree = new AvlTree<>(500);
        System.out.println(smallAvlTree);
        smallAvlTree.insert(404);
        System.out.println(smallAvlTree);
        smallAvlTree.insert(300);
        System.out.println(smallAvlTree);
        smallAvlTree.insert(12000);
        System.out.println(smallAvlTree);
        smallAvlTree.insert(433);
        System.out.println(smallAvlTree);
        smallAvlTree.insert(503);
        System.out.println(smallAvlTree);*/

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

        System.out.println(avlTree);
        System.out.println(avlTree.remMin());
        System.out.println(avlTree);

        avlTree.delete(40);
        System.out.println(avlTree);
    }
}