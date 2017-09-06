package tree;

/**
 * Created by zf
 * Date: 2017/8/10
 */
public class Node<T> {
    private T data;             //数据
    private Node<T> left;       //左子树
    private Node<T> right;      //右子树
    private Node<T> parent;     //父结点

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    //清空结点
    public void clear() {
        left = null;
        right = null;
        parent = null;
    }
}
