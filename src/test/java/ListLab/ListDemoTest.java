package ListLab;

import org.junit.jupiter.api.Test;

import java.util.*;
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
        ArrayList<Human> a = new ArrayList<>();
        ArrayList<Human> c = new ArrayList<>();
        Human b = new Human("1","1","1",13);
        a.add(new Human("1","1","1",13));
        c.add(new Human("2","2","2",2));
        a.add(new Human("2","2","2",2));
        assertEquals(c, ListDemo.goOutHuman(a,b));
        a.get(1).setName("123");
        assertNotEquals(a.get(1),c.get(0));
    }

    @Test
    void noCommonWith() {
        List<Set<Integer>> a = new ArrayList<>();
        List<Set<Integer>> c = new ArrayList<>();
        Set<Integer> b = new TreeSet<>();
        b.add(1);
        b.add(2);
        a.add(new TreeSet<>());
        a.get(0).add(1);
        a.add(new TreeSet<>());
        a.get(1).add(2);
        a.add(new TreeSet<>());
        a.get(2).add(3);
        c.add(new TreeSet<>());
        c.get(0).add(3);

        assertEquals(c,ListDemo.noCommonWith(a,b));
    }

    @Test
    void oldest() {
        List<Human> a = new ArrayList<>();
        List<Human> c = new ArrayList<>();

        a.add(new Human("1","2","3",13));
        a.add(new Human("1","3","5",87));
        a.add(new Human("2","6","6",87));

        c.add(new Human("1","3","5",87));
        c.add(new Human("2","6","6",87));

        assertTrue(c.containsAll(ListDemo.oldest(a)));
    }

    @Test
    void SNFsortedArray() {
        List<Human> a = new ArrayList<>();
        List<Human> c = new ArrayList<>();

        a.add(new Human("2","2","1",3));
        a.add(new Human("1","2","1",2));
        a.add(new Human("2","2","2",4));
        a.add(new Human("1","1","1",1));

        c.add(new Human("2","2","2",4));
        c.add(new Human("2","2","1",3));
        c.add(new Human("1","2","1",2));
        c.add(new Human("1","1","1",1));

        assertEquals(c,ListDemo.SNFsortedArray(a));
    }

    @Test
    void choosens() {
        Map<Integer,Human> a = new HashMap<>();
        Set<Integer> b = new HashSet<>();
        Set<Human> c = new HashSet<>();
        c.add(new Human("1","1","1",1));
        c.add(new Human("1","1","1",2));

        b.add(1);
        b.add(2);

        a.put(1,new Human("1","1","1",1));
        a.put(2,new Human("1","1","1",2));
        a.put(3,new Human("1","1","1",3));

        assertEquals(c,ListDemo.choosens(a,b));
    }

    @Test
    void youngetThen18() {
        Map<Integer,Human> a = new HashMap<>();

        Set<Integer> c = new HashSet<>();
        c.add(1);
        c.add(2);

        a.put(1,new Human("1","1","1",12));
        a.put(2,new Human("1","1","2",15));
        a.put(3,new Human("1","1","3",35));

        assertEquals(c,ListDemo.youngetThen18(a));
    }

}