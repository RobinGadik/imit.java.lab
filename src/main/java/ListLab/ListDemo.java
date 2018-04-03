package ListLab;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static List<String> firstSymbolEquals(List<String> a,char b){
        List<String> c = new ArrayList<String>();
        for (String i: a) {
            if(i.charAt(0) == b) {
                c.add(i);
            }
        }
        return c;
    }

    public static  List<Human> sameSurname(List<Human> a,Human b){
        List<Human> c = new ArrayList<Human>();
        for(Human h:a){
            if(h.getSurname().equals(b.getSurname())){
                c.add(h);
            }
        }
        return c;
    }


}
