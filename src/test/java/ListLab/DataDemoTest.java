package ListLab;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataDemoTest {
    @Test
    void getAll() {
        Data d = new Data("Testing",
                new Group(0,1,1,1),
                new Group(2,1,2,3),
                new Group(5,5,-1,2));
        List<Integer> c = new ArrayList<>();
        c.add(1);c.add(1);c.add(1);c.add(1);
        c.add(2);c.add(3);
        c.add(5);c.add(-1);c.add(2);

        System.out.print(c);

        assertEquals(c,DataDemo.getAll(d));
    }

}