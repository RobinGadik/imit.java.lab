package ListLab;

import java.util.LinkedList;
import java.util.List;

public class DataDemo {
    public static List<Integer> getAll(Data d){
        List<Integer> c = new LinkedList<Integer>();
        DataIterator a = d.iterator();
        while(a.hasNext()){
            c.add(a.next());
        }
        return c;
    }
}
