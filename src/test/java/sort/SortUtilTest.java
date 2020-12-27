package sort;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.spec.RSAOtherPrimeInfo;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class SortUtilTest {

    int nums[];
    int scale = 100000;
    Logger logger = LoggerFactory.getLogger(SortUtilTest.class);
    SimpleDateFormat sdf = new SimpleDateFormat();
    private static SortUtil sortUtil = new SortUtil();
    private StopWatch stopWatch = new StopWatch();
    @BeforeClass
    public static void init1(){

    }
    @Before
    public void init(){
        logger.info("construct test array...");
        nums = new int[scale];
        for(int i =0; i<scale;i++){
            nums[i] = ThreadLocalRandom.current().nextInt(1,10000+1);
        }

    }
    @Test
    public void bubbleSort() {
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");
        Date t1 = new Date();
        logger.info("bubble sort started at: " + sdf.format(t1));
        stopWatch.start();
        System.out.println(nums[0]);
        sortUtil.bubbleSort(nums,0,scale);
        stopWatch.stop();
        Date t2 = new Date();
        logger.info("bubble sort finished at: " + sdf.format(t2));
        logger.info(Arrays.toString(nums));
        long seconds = (t2.getTime() - t1.getTime())/1000;
        logger.info("bubble sort cost " + seconds + " seconds!" + stopWatch.getTime(TimeUnit.SECONDS));
    }

    @Test
    public void quickSortTest(){
        logger.info(Arrays.toString(nums));
        stopWatch.start();
        sortUtil.quickSort(nums, 0, nums.length);
        stopWatch.stop();
        logger.info("quick sort cost: " + stopWatch.getTime(TimeUnit.SECONDS) + " seconds!");
        logger.info(Arrays.toString(nums));
    }
}