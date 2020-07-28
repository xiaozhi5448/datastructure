package tree;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
class BinaryNode<T> {
    T element;
    BinaryNode<T> left;
    BinaryNode<T> right;
}

@Getter
@ToString
public class BinarySearchTree<E extends Comparable<? super E>> {

    BinaryNode<E> root;

    public BinarySearchTree() {
        root = null;
    }

    private void makeEmptyUtil(BinaryNode<E> tree) {
        if (tree == null) {
            return;
        }
        if (tree.element != null) {
            makeEmptyUtil(tree.getLeft());
            makeEmptyUtil(tree.getRight());
        }
        tree.element = null;
    }

    public void makeEmpty() {
        makeEmptyUtil(this.root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    private BinaryNode<E> findElementUtil(E value, BinaryNode<E> tree) {
        if (tree == null) {
            return null;
        }
        if (value.compareTo(tree.element) > 0) {
            return findElementUtil(value, tree.right);
        } else if (value.compareTo(tree.element) < 0) {
            return findElementUtil(value, tree.left);
        } else if (value.compareTo(tree.element) == 0) {
            return tree;
        } else {
            return null;
        }

    }

    public BinaryNode<E> findElement(E value) {
        return findElementUtil(value, this.root);
    }

    /**
     * @param value
     * @param node
     * @return
     */
    private boolean contains(E value, BinaryNode<E> node) {
        if (node == null) {
            return false;
        }
        int compareResult = value.compareTo(node.getElement());
        if (compareResult < 0) {
            return contains(value, node.getLeft());
        } else if (compareResult > 0) {
            return contains(value, node.getRight());
        } else {
            return true;
        }
    }

    public boolean contains(E value) {
        return contains(value, root);
    }

    private E findMax(BinaryNode<E> node) {
        BinaryNode<E> tmpNode = node;
        if (tmpNode == null) {
            return null;
        } else {
            while (tmpNode.getRight() != null) {
                tmpNode = tmpNode.getRight();
            }
            return tmpNode.getElement();
        }
    }

    public E findMax() {
        return findMax(this.root);
    }

    private E findMin(BinaryNode<E> node) {
        if (node == null) {
            return null;
        }
        if (node.getLeft() != null) {
            return findMin(node.getLeft());
        } else {
            return node.getElement();
        }
    }

    public E findMin(){
        return findMin(root);
    }

    private BinaryNode<E> insert(E value, BinaryNode<E> node){
        if(node == null){
            return new BinaryNode<E>(value, null, null);
        }
        int compareResult = value.compareTo(node.getElement());
        if(compareResult < 0){
            node.left = insert(value, node.getLeft());
        }else if(compareResult > 0){
            node.right = insert(value, node.getRight());
        }else{
            // find element with value, already exists
        }
        return node;
    }

    public void insert(E value){
        root = insert(value, root);
    }

    private BinaryNode<E> remove(E value, BinaryNode<E> node){
        if(node == null){
            return null;
        }
        int compareResult = value.compareTo(node.getElement());
        if(compareResult<0){
            node.left = remove(value, node.getLeft());
        }else if(compareResult > 0){
            node.right = remove(value, node.getRight());
        }else{
            if(node.left != null && node.right != null){
                node.setElement(findMin(node.getRight()));
                node.right = remove(node.element, node.getRight());
            }else{
                node = node.left != null? node.left: node.right;
            }
        }
        return node;
    }
    public void remove(E value){
        remove(value, root);
    }

    private void traverse(BinaryNode<E> node){
        if(node != null){
            System.out.println(node.getElement());
        }
        if(node.getLeft() != null){
            traverse(node.getLeft());
        }
        if(node.getRight() != null){
            traverse(node.getRight());

        }
    }

    public void traverse(){
        traverse(this.root);
    }

}
