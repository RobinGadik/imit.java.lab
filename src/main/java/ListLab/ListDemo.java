package ListLab;

import java.util.*;

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
            if(!h.equals(b))c.add(new Human(h));
        }

        return c;
    }

    public static List<Set<Integer>> noCommonWith(List<Set<Integer>> a, Set<Integer> b){
        List<Set<Integer>> c = new ArrayList<Set<Integer>>();

        loop: for(Set<Integer> s:a){
            //boolean flag = true;
            for(Integer i:s){
                if(b.contains(i)) continue loop;//flag = false;
            }
            c.add(s);
        }

        return c;
    }

    public static <T extends Human> Set<T> oldest(List<T> a){
        Set<T > c;
        c = new HashSet<T>();
        int max = -Integer.MAX_VALUE;
        for(T i:a){
            if(i.getAge()>max)max = i.getAge();
        }

        for(T i:a){
            if(i.getAge() == max) c.add(i);
        }
        return c;
    }

    public static <T extends Human> List<T> SNFsortedArray(List<T> a){
        List<T> c = new ArrayList<T>(a);
        c.sort((o1, o2) -> {
            if(!o1.getSurname().equals(o2.getSurname())) return o1.getSurname().compareTo(o2.getSurname());
            if(!o1.getName().equals(o2.getName())) return o1.getName().compareTo(o2.getName());
            return o1.getFatherName().compareTo(o2.getFatherName());
        });

/*        for(T i:a){
            if(c.isEmpty())c.add(i);
            else {
                boolean flag = false;
                for (int j = 0; j < c.size(); j++) {

                    if (c.get(j).getSurname().compareTo(i.getSurname()) < 0) {
                        flag = true;
                    } else if (c.get(j).getName().compareTo(i.getName()) < 0) {
                        flag = true;
                    } else if (c.get(j).getFatherName().compareTo(i.getFatherName()) < 0) {
                        flag = true;
                    }


                    if (flag) {
                        c.add(j, i);
                        j=c.size();
                    }
                }
                if (!flag) {
                    c.add(i);
                }
            }


        }*/
        return c;
    }

    public static Set<Human> choosens(Map<Integer,Human> a, Set<Integer> b){
        Set<Human> c = new HashSet<>();

        for(Integer i:b){
            if(a.containsKey(i)) {
                c.add(a.get(i));
            }

        }

        return c;
    }

    public static List<Integer> youngetThen18(Map<Integer,Human> a){
        int up = 18;
        List<Integer> c = new ArrayList<Integer>();

        for(Integer i:a.keySet()){
            if(a.get(i).getAge() < up){
                c.add(i);
            }
        }
        return c;
    }
}
