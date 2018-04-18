package ReflectionLab;

import ListLab.Human;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ReflectionDemo {

    public static int humanListCheck(List<Object> a) {
        int res = 0;
        for (Object o : a) {
            Class c = o.getClass();
            while (c != Object.class) {
                if (c == Human.class) {
                    res++;
                }
                c = c.getSuperclass();

            }
        }

        return res;
    }

    public static List<String> methodsList(Object o) {
        List<String> a = new ArrayList<>();

        Method[] met = o.getClass().getMethods();

        for (Method m : met) {
            a.add(m.getName());
        }

        return a;
    }

    public static List<String> superClassList(Object o) {
        List<String> a = new ArrayList<>();

        Class c = o.getClass().getSuperclass();

        while (c != Object.class) {
            a.add(c.getSimpleName());
            c = c.getSuperclass();
        }

        a.add(c.getSimpleName());

        return a;
    }


    public static int execution(List<Object> a) {
        int res = 0;
        for (Object o : a) {
            Class c = o.getClass();

            if (Executable.class.isAssignableFrom(c)) {
                ((Executable) o).execute();
                res++;
            }
        }
        return res;
    }


    public static List<String> getGettersSetters(Object o) {
        List<String> a = new ArrayList<>();
        Class c = o.getClass();
        while (true) {
            Method[] methods = c.getDeclaredMethods();
            for (Method m : methods) {

                String s = m.getName();
                if (s.startsWith("set") && m.getParameterCount() == 1 && (m.getReturnType() == Void.class ||
                        (m.getReturnType() == void.class)) ) {
                    a.add(m.getName());
                }

                if (s.startsWith("get") && m.getParameterCount() == 0 && (m.getReturnType() != Void.class &&
                        m.getReturnType() != void.class) ){
                    a.add(m.getName());
                }

                if ((s.startsWith("has") || s.startsWith("is"))
                        && m.getParameterCount() == 0 && (m.getReturnType() == Boolean.class ||
                        m.getReturnType() == boolean.class) ) {
                    a.add(m.getName());
                }

            }
            if (c != Object.class) {
                c = c.getSuperclass();
            } else {
                break;
            }
        }

        return a;
    }

}
