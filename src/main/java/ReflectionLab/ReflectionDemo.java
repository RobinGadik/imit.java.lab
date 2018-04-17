package ReflectionLab;

import ListLab.Human;
import sun.reflect.generics.tree.ReturnType;

import java.lang.annotation.Annotation;
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

    public List<String> superClassList(Object o){
        List<String> a = new ArrayList<>();

        Class c = o.getClass();

        while(c.getSuperclass() != Object.class){
            a.add(c.getName());
            c = o.getClass().getSuperclass();
        }
        a.add(c.getName());

        return a;
    }


    public int execution(List<Object> a){
        int res=0;
        for(Object o:a){
            for(Class c:o.getClass().getInterfaces()){
                if(c == Executable.class){
                    ((Executable) o).execute();
                    res++;
                    break;
                }
            }

        }
        return res;
    }


    public List<String> getGettersSetters(Object o){
        List<String> a = new ArrayList<>();

        Method[] methods = o.getClass().getDeclaredMethods();

        for(Method m:methods){

            if(m.getModifiers() == Modifier.PUBLIC){
                String s = m.getName();
                if(s.startsWith("set") && m.getParameterCount() == 1 && m.getReturnType() == void.class){
                    a.add(m.getName());
                }

                if( s.startsWith("get" ) && m.getParameterCount() == 0 && m.getReturnType() != void.class){
                    a.add(m.getName());
                }

                if( (s.startsWith("has") ||  s.startsWith("is") )
                        && m.getParameterCount() == 0 && m.getReturnType() == boolean.class){
                    a.add(m.getName());
                }
            }


        }

        return a;
    }

}
