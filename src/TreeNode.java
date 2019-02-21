import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TreeNode<T> {

    T data;
    TreeNode<T> parent;
    LinkedList<TreeNode<T>> children;

    public TreeNode(T data){
        this.data = data;
        this.children = new LinkedList<TreeNode<T>>();
        this.parent = null;
    }

    public TreeNode(T data, TreeNode<T> parent){
        this.data = data;
        this.parent = parent;
        this.children = new LinkedList<TreeNode<T>>();
    }

    public TreeNode<T> addChild(T child){
        TreeNode<T> childNode = new TreeNode<T>(child, this);
        this.children.add(childNode);
        return childNode;
    }

    /*public void Inset(TreeNode newNode){
        if(this != null && newNode != null){
            TreeNode temp;
            temp = this.getParent();
            this.setParent(newNode);
            newNode.setParent(temp);
        }
    }*/


    public TreeNode<T> getParent(){
        return parent;
    }

    public T getData(){
        return data;
    }

    public LinkedList<TreeNode<T>> getChild(){
        return children;
    }

    public void setData(T data1){
        this.data = data1;
    }

    public void setParent(TreeNode<T> getParent){
        this.parent = parent;
    }

    public String toString(){
        return this.data.toString();
    }

}
