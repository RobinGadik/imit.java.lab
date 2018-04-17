package ReflectionLab;

import ListLab.Human;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ReflectionDemo {

    public int humanListCheck(List<Object> a){
        int res=0;
        for(Object o:a){
            if(o.getClass() == Human.class || o.getClass().getSuperclass() == Human.class){
                res++;
            }
        }

        return res;
    }

    public List<String> methodsList(Object o){
        List<String> a = new ArrayList<>();

        Method[] met = o.getClass().getMethods();

        for(Method m:met){
            if(m.getModifiers() == Modifier.PUBLIC){
                a.add(m.getName());
            }
        }

        return a;
    }




}
