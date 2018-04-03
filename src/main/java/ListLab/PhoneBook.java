package ListLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<Human, List<String>> map;

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

    public List<String> gettPhones(Human a){
        List<String> c = new ArrayList<String>();

        if(map.containsKey(a)){
            c = new ArrayList<String>(map.get(a));
        }

        return c;
    }
}
