package util;

import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class ArangeTest extends TestCase {
    Logger logger = LoggerFactory.getLogger(ArangeTest.class);
    @Test
    public void testComb(){
        Arange<Integer> arange = new Arange<Integer>();
        ArrayList<Integer> a1 = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            a1.add(i);
        }
        ArrayList<ArrayList<Integer>> results = arange.getArange(a1, 5);
        logger.info(results.toString());
    }
}