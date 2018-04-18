package ReflectionLab;

import ListLab.Human;
import ListLab.Student;
import org.junit.jupiter.api.Test;

import javax.jws.Oneway;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionDemoTest {

    class Student2 extends Student {
        private void hiddenMethod() { }

        public void setVoid() { }

        public  Boolean isTrue() { return true; }

        public final boolean hasTrue() { return true; }

        public final int isInt( ) { return 0; }

        public int getXY(int x, int y) { return x + y; }

        public void setXY(int x, int y) { }

        public void getVoid() { }
    }

    @Test
    void humanListCheck() {


        List<Object> a = new ArrayList<>();
        a.add(new Object());
        a.add(new Human());
        a.add(new Student2());
        assertEquals(2,ReflectionDemo.humanListCheck(a));
    }

    @Test
    void methodsList() {
        Object o = new Student2();
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


        exp.add(   "getFaculty");
        exp.add(   "setFaculty");

        exp.add(   "getClass");
        exp.add(   "getVoid");
        exp.add(   "getXY");
        exp.add(   "hasTrue");
        exp.add(   "isInt");
        exp.add(   "isTrue");
        exp.add(   "notify");
        exp.add(   "notifyAll");
        exp.add(   "setVoid");
        exp.add(   "setXY");

        exp.add(   "wait");
        exp.add(   "wait");
        exp.add(   "wait");
        exp.sort(String::compareTo);
        List<String> ans = ReflectionDemo.methodsList(o);
        ans.sort(String::compareTo);
        assertEquals(exp,ans);
    }

    @Test
    void superClassList() {
        Object o = new Student2();
        ArrayList<String> a = new ArrayList<String>();
        a.add("Student");
        a.add("Human");
        a.add("Object");
        assertEquals(a,ReflectionDemo.superClassList(o));
    }


    int SU = 0;
    @Test
    void execution() {
        class test implements Executable{

            @Override
            public void execute() {
               // System.out.println("OH MY (GOD or SHINDERY)");
                SU += 2;
            }
        }

        class test2 extends test {
            @Override
            public void execute() {
                SU += 3;
            }

        }

        SU=0;
        ArrayList<Object> a = new ArrayList<>();
        a.add(new Object());
        a.add(new test());
        a.add(new Student());
        a.add(new test());
        a.add(new test2());
        int r = ReflectionDemo.execution(a);
        assertEquals(3,r);
        assertEquals(7,SU);
    }

    @Test
    void getGettersSetters() {
        Object o = new Student2();
        List<String> exp = new ArrayList<String>();

        exp.add("getName");
        exp.add( "setName");
        exp.add( "setFatherName");
        exp.add(  "setSurname");
        exp.add(  "getSurname");
        exp.add(  "getFatherName");
        exp.add(  "setAge");
        exp.add(   "getAge");


        exp.add(   "hasTrue");
        exp.add(   "isTrue");
        exp.add(   "getFaculty");
        exp.add(   "setFaculty");
        exp.add(   "getClass");
        exp.sort(String::compareTo);
        List<String> ans = ReflectionDemo.getGettersSetters(o);
        ans.sort(String::compareTo);
        assertEquals(exp,ans);
    }

}