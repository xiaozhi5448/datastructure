package tree;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class TraveseDirectoryTest {
    @Test
    public void testDir(){
        TraveseDirectory dirs = new TraveseDirectory();
        ArrayList<String> items = dirs.listDir("f:\\code\\java");
        System.out.println(items);
    }

}