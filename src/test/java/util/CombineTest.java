package util;

import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class CombineTest extends TestCase {
    Logger logger = LoggerFactory.getLogger(CombineTest.class);
    @Test
    public void testCombine(){
        ArrayList<Integer> a1 = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            a1.add(i);
        }
        Combine<Integer> combine = new Combine<>();
        ArrayList<ArrayList<Integer>> results = combine.getCombine(a1, 6);
        logger.info(results.toString());
    }

}