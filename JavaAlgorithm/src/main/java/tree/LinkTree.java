package tree;

/**
 * Created by zf
 * Date: 2017/8/10
 */
public class LinkTree<T> {

    private Node<T> rootNode;

    public Node<T> getRootNode() {
        return rootNode;
    }

    public Node<T> initTree(T data) {
        System.out.println("初始化树结构...数据类型为：" + data.getClass());
        rootNode = new Node<>();
        rootNode.setData(data);
        rootNode.setParent(null);
        rootNode.setLeft(null);
        rootNode.setRight(null);
        return rootNode;
    }

    //明确父结点的情况
    public void addTreeNode(Node<T> parent, T data, boolean lr) {
        Node<T> node = new Node<>();
        node.setParent(parent);
        node.setData(data);
        node.setLeft(null);
        node.setRight(null);
        if (lr) {
            parent.setLeft(node);
        } else {
            parent.setRight(node);
        }
    }

    //不明确父结点的情况，只知道父结点的数据
    public void addTreeNode(T parentData, T data, boolean lr) {
        Node<T> parent = findTreeNode(rootNode, parentData);
        if (parent == null) {
            System.out.println("添加结点错误，无数据为 " + parentData + " 的父结点");
            return;
        }
        addTreeNode(parent, data, lr);
    }

    //从treeNode结点开始查找数据为data的结点
    public Node<T> findTreeNode(Node<T> treeNode, T data) {
        if (treeNode == null || data == null) {
            return null;
        }
        Node<T> ptr;
        if (treeNode.getData().equals(data)) {
            return treeNode;
        } else {
            ptr = findTreeNode(treeNode.getLeft(), data);
            if (ptr != null) {
                return ptr;
            }
            ptr = findTreeNode(treeNode.getRight(), data);
            if (ptr != null) {
                return ptr;
            }
            return null;
        }
    }


    public Node<T> getLeftNode(Node<T> treeNode) {
        if (treeNode != null) {
            return treeNode.getLeft();
        } else {
            return null;
        }
    }

    public Node<T> getRightNode(Node<T> treeNode) {
        if (treeNode != null) {
            return treeNode.getRight();
        } else {
            return null;
        }
    }

    //计算深度
    public int getTreeDepth(Node<T> treeNode) {
        int depLeft, depRight;
        if (treeNode == null) {
            return 0;
        } else {
            depLeft = getTreeDepth(treeNode.getLeft());
            depRight = getTreeDepth(treeNode.getRight());

            return depLeft > depRight ? depLeft+1 : depRight+1;
        }
    }

    public boolean isEmptyTree() {
        return rootNode == null;
    }

    //清空treeNode的子树
    public void clearTree(Node<T> treeNode) {
        if (treeNode != null) {
            clearTree(treeNode.getLeft());
            clearTree(treeNode.getRight());
            treeNode.clear();
        }
    }

    //先序遍历
    public void DLRTree(Node<T> treeNode) {
        if (treeNode != null) {
            System.out.print(treeNode.getData()+"  ");
            DLRTree(treeNode.getLeft());
            DLRTree(treeNode.getRight());
        }
    }

    //中序遍历
    public void LDRTree(Node<T> treeNode) {
        if (treeNode != null) {
            LDRTree(treeNode.getLeft());
            System.out.print(treeNode.getData()+"  ");
            LDRTree(treeNode.getRight());
        }
    }

    //后序遍历
    public void LRDTree(Node<T> treeNode) {
        if (treeNode != null) {
            LRDTree(treeNode.getLeft());
            LRDTree(treeNode.getRight());
            System.out.print(treeNode.getData()+"  ");
        }
    }
}
