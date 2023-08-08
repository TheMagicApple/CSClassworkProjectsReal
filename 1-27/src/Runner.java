public class Runner{
    public static void main(String[] args){
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.add(90);
        tree.add(80);
        tree.add(70);
        tree.add(85);
        tree.add(100);
        tree.add(98);
        tree.add(120);

        System.out.println(tree.toStringPreOrder());
        System.out.println(tree.toString());
        System.out.println(tree.getHeight());
        System.out.println(tree.getLevel());
        System.out.println(tree.getHeight(100));
        System.out.println(tree.getHeight(70));

        tree.clear();

        tree.add(90);
        tree.add(150);
        tree.add(170);
        tree.add(160);
        tree.add(151);
        tree.add(171);
        
        System.out.println(tree.toStringPreOrder());
        System.out.println(tree.toString());
        System.out.println(tree.getHeight());
        System.out.println(tree.getLevel());
        System.out.println(tree.getHeight(150));
        System.out.println(tree.getHeight(151));
        
    }
}