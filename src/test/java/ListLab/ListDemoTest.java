package ListLab;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class ListDemoTest {
    @Test
    void firstSymbolEquals() {
        ArrayList<String> a = new ArrayList<String>();
        ArrayList<String> b = new ArrayList<String>();
        a.add("aaa");
        b.add("aaa");
        a.add("cfb");
        assertEquals(b, ListDemo.firstSymbolEquals(a,'a'));
    }

    @Test
    void sameSurname() {
        ArrayList<Human> a = new ArrayList<>();
        ArrayList<Human> c = new ArrayList<>();
        Human b = new Human("1","1","1",13);
        a.add(new Human("1","1","2",12));
        c.add(new Human("1","1","2",12));
        a.add(new Human("1","2","2",2));
        assertEquals(c, ListDemo.sameSurname(a,b));
    }

    @Test
    void goOutHuman() {

    }

    @Test
    void noCommonWith() {
    }

    @Test
    void oldest() {
    }

    @Test
    void SNFsortedArray() {
    }

    @Test
    void choosens() {
    }

    @Test
    void youngetThen18() {
    }

}