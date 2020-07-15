package util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Combine<E> {
    public ArrayList<ArrayList<E>> getCombine(List<E> data, int length){
        ArrayList<ArrayList<E>> l1 = new ArrayList<ArrayList<E>>();
        HashSet<E> originalSet = new HashSet<>();
        for(E item:data){
            originalSet.add(item);
        }
        l1.add(new ArrayList<E>());
        l1.get(0).add(data.get(0));
        ArrayList<ArrayList<E>> l2 = new ArrayList<ArrayList<E>>();


        for(int i = 0; i<length-1; i++){
            for(List<E> items:l1){
                HashSet<E> loopSet = new HashSet<>();
                for(E item:items){
                    loopSet.add(item);
                }
                HashSet<E> tmpSet = new HashSet<>(originalSet);
                tmpSet.removeAll(loopSet);
                for(E newElement: tmpSet){
                    ArrayList<E> loopArray = new ArrayList<>(items);
                    loopArray.add(newElement);
                    l2.add(loopArray);
                }

            }
            l1 = l2;
            l2 = new ArrayList<ArrayList<E>>();

        }

        return l1;
    }
}
