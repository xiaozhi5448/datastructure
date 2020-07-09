package tree;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class TraveseDirectoryTest extends TestCase {
    @Test
    public void testDir(){
        TraveseDirectory dirs = new TraveseDirectory();
        ArrayList<String> items = dirs.listDir("/home/xiaozhi/workspace");
        System.out.println(items);
    }

}