package tree;

/**
 * Created by zf
 * Date: 2017/8/10
 */
public class LinkTreeTest {

    private static final boolean left = true;//添加到左子树
    private static final boolean right = false;//添加到右子树

    public static void main(String[] args) {

        LinkTree<String> linkTree = new LinkTree<>();
        linkTree.initTree("a");

        /*
        * 隐式添加结点，不用自己new Node出来，直接往已知结点后加
        * */
        linkTree.addTreeNode("a", "b", left);
        linkTree.addTreeNode("a", "c", right);

        linkTree.addTreeNode("b", "d", left);
        linkTree.addTreeNode("b", "e", right);

        linkTree.addTreeNode("e", "g", left);
        linkTree.addTreeNode("e", "h", right);

        linkTree.addTreeNode("c", "f", right);

        /*
        * 显式添加结点，自己链接各个node
        * */
        /*Node<String> b = new Node<>();
        b.setData("b");
        Node<String> c = new Node<>();
        c.setData("c");
        Node<String> d = new Node<>();
        d.setData("d");
        Node<String> e = new Node<>();
        e.setData("e");
        Node<String> f = new Node<>();
        f.setData("f");
        Node<String> g = new Node<>();
        g.setData("g");
        Node<String> h = new Node<>();
        h.setData("h");*/

        System.out.println();
        System.out.println("先序遍历：");
        linkTree.DLRTree(linkTree.getRootNode());
        System.out.println();
        System.out.println("中序遍历：");
        linkTree.LDRTree(linkTree.getRootNode());
        System.out.println();
        System.out.println("后序遍历：");
        linkTree.LRDTree(linkTree.getRootNode());
        System.out.println();
        System.out.println("二叉树深度："+ linkTree.getTreeDepth(linkTree.getRootNode()));
    }
}
