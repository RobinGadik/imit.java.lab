package ReflectionLab;

import ListLab.Human;
import org.junit.jupiter.api.Test;

import javax.jws.Oneway;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionDemoTest {
    @Test
    void humanListCheck() {
        List<Object> a = new ArrayList<>();
        a.add(new Object());
        a.add(new Human());
        assertEquals(1,ReflectionDemo.humanListCheck(a));
    }

    @Test
    void methodsList() {
        Object o = new Human();
        List<String> exp = new ArrayList<String>();

        exp.add("equals");
        exp.add( "hashCode");
        exp.add("getName");
        exp.add( "setName");
        exp.add( "setFatherName");
        exp.add(  "setSurname");
        exp.add(  "getSurname");
        exp.add(  "getFatherName");
        exp.add(  "setAge");
        exp.add(   "getAge");
        exp.add(   "toString");
        exp.sort((String o1,String o2) -> o1.compareTo(o2));
        List<String> ans = ReflectionDemo.methodsList(o);
        ans.sort((o1, o2) -> o1.compareTo(o2));
        assertEquals(exp,ans);
    }

    @Test
    void superClassList() {
    }

    @Test
    void execution() {
    }

    @Test
    void getGettersSetters() {
    }

}