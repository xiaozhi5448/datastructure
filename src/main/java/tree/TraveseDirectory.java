package tree;

import java.io.File;
import java.util.ArrayList;

public class TraveseDirectory {
    public void dir(File dir, int Deepth, ArrayList<String> results){
        String prefix = "";
        if(Deepth == 0){
        }else{
            prefix = "\t".repeat(Deepth-1) + "|---";
        }

        System.out.println(prefix + dir.getName());
        results.add(dir.getAbsolutePath());
        if(dir.isDirectory()) {
            for (File tmpfile : dir.listFiles()) {
                dir(tmpfile, Deepth + 1, results);
            }
        }
    }

    public ArrayList<String> listDir(String dirname){
        ArrayList<String> results = new ArrayList<>();
        File startpoint = new File(dirname);
        if(startpoint.exists()){
            dir(startpoint, 0, results);
        }
        return results;
    }
}
