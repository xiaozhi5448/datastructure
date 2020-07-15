package tree;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BinarySearchTree<E extends Comparable<E>> {

    E element;
    BinarySearchTree<E> left;
    BinarySearchTree<E> right;

    public BinarySearchTree(){

    }

    private void makeEmptyUtil(BinarySearchTree<E> tree){
        if(tree != null){
            makeEmptyUtil(tree.left);
            makeEmptyUtil(tree.right);
            tree.element = null;
        }
    }

    public void makeEmpty(){
        makeEmptyUtil(this);
    }

    private BinarySearchTree<E> findElementUtil(E value, BinarySearchTree<E> tree){
        if(tree == null){
            return null;
        }
        if(value.compareTo(tree.element) > 0){
            return findElementUtil(value, tree.right);
        }else if(value.compareTo(tree.element) < 0){
            return findElementUtil(value, tree.left);
        }else if(value.compareTo(tree.element) == 0){
            return tree;
        }else{
            return null;
        }

    }
    public BinarySearchTree<E> findElement(E value){
        return findElementUtil(value, this);
    }


}
