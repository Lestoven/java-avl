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

        AvlTree<Integer> avlTree = new AvlTree<>(100);
        avlTree.insert(130);
        avlTree.insert(70);
        avlTree.insert(150);
        avlTree.insert(140);
        avlTree.insert(80);
        avlTree.insert(65);
        avlTree.insert(90);
        avlTree.insert(200);
        avlTree.insert(135);
        avlTree.insert(240);
        avlTree.insert(500);

        System.out.println(avlTree);
        System.out.println(avlTree.avlRemMin());
        System.out.println(avlTree);
    }
}