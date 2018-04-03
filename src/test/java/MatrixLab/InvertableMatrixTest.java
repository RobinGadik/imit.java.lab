package MatrixLab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvertableMatrixTest {
    @Test
    void getInversionMatrix() {
        InvertableMatrix m = new InvertableMatrix(2);
        m.set(0,0,1);
        m.set(0,1,0);
        m.set(1,0,1);
        m.set(1,1,1);

        InvertableMatrix exp = new InvertableMatrix(2);
        exp.set(0,0,1);
        exp.set(0,1,0);
        exp.set(1,0,-1);
        exp.set(1,1,1);

        assertEquals(exp,m.getInversionMatrix());
    }

}