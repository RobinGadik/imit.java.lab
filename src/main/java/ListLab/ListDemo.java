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
        List<Human> d = new ArrayList<>(a);
        for(Human h:d){
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
        List<T> c = new ArrayList<T>();

        for(T i:a){
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


        }
        return c;
    }

    public static Set<Human> choosens(Map<Integer,Human> a, Set<Integer> b){
        Set<Human> c = new HashSet<>();

        for(Integer i:b){
            c.add(a.get(i));
        }

        return c;
    }

    public static Set<Integer> youngetThen18(Map<Integer,Human> a){
        int up = 18;
        Set<Integer> c = new HashSet<Integer>();

        for(Integer i:a.keySet()){
            if(a.get(i).getAge() < up){
                c.add(i);
            }
        }
        return c;
    }
}
