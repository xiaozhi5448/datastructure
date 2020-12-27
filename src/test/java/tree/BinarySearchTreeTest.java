package tree;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {


    BinarySearchTree<Integer> btree;
    Logger logger = null;

    @Before
    public  void setUp() throws Exception {
        btree = new BinarySearchTree<>();
        logger = LoggerFactory.getLogger(BinarySearchTreeTest.class);
        logger.info(String.format("empty: " + btree.isEmpty()));
        int[] arr = {1, 3, 6, 2, 5, 0,9};
        for(Integer num: arr){
            btree.insert(num);
        }
    }

    @After
    public  void tearDown() throws Exception {
    }

    @Test
    public void makeEmpty() {
    }

    @Test
    public void isEmpty() {
        logger.info("is empty: " + btree.isEmpty());
    }

    @Test
    public void findElement() {
        BinaryNode res = btree.findElement(5);
        logger.info(String.format("find element with value %d: %s", 5, res.toString()));
    }

    @Test
    public void contains() {
        boolean res = btree.contains(5);
        logger.info(String.format("contains 5: " + res));
    }

    @Test
    public void findMax() {
        int res = btree.findMax();
        logger.info(String.format("max value: %d", res));
    }

    @Test
    public void findMin() {
        int res = btree.findMin();
        logger.info(String.format("min value: %d",  res));
    }

    @Test
    public void insert() {
    }

    @Test
    public void remove() {
        btree.remove(3);
        btree.remove(2);
        btree.traverse();
    }

    @Test
    public void traverse() {
        btree.traverse();
    }
}