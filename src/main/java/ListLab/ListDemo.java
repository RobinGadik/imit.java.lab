package ListLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public static  List<Human> goOutHuman(List<Human> a,Human b){
        List<Human> c = new ArrayList<Human>();
        for(Human h:a){
            if(!h.equals(b))c.add(h);
        }

        return c;
    }

    public static List<Set<Integer>> noCommonWith(List<Set<Integer>> a, Set<Integer> b){
        List<Set<Integer>> c = new ArrayList<Set<Integer>>();

        for(Set<Integer> s:a){
            boolean flag = true;
            for(Integer i:s){
                if(b.contains(i))flag = false;
            }
            if(flag)c.add(s);
        }

        return c;
    }


}
