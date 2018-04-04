package ListLab;

import java.util.*;

public class PhoneBook {
    private Map<Human, List<String>> map;

    public PhoneBook() {
        map = new HashMap<>();
    }

    public PhoneBook(Map<Human, List<String>> map) {
        this.map = map;
    }

    public void addPhone(Human a,String b){
        if(!map.containsKey(a) ) {
            map.put(a, new ArrayList<String>());
        }
        if(!map.get(a).contains(b))map.get(a).add(b);

    }

    public void popNumber(String a){
        for(Human h:map.keySet()){
            map.get(h).remove(a);
        }
    }

    public List<String> getPhones(Human a){
        List<String> c = new ArrayList<String>();

        if(map.containsKey(a)){
            c = new ArrayList<String>(map.get(a));
        }

        return c;
    }

    public Set<Human> find(String a){
        Set<Human> c = new TreeSet<Human>();

        for(Human i:map.keySet()){
            if(map.get(i).contains(a)){
                c.add(i);
            }
        }

        return c;
    }
}
