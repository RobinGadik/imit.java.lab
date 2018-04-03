package MatrixLab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    @Test
    void testing() {
        assertTrue(Matrix.testing());
    }

    @Test
    void get(){
        Matrix a = new Matrix();
        a.set(0,0,2);
        assertEquals(2,a.get(0,0));
    }

    @Test
    void determinant(){
        Matrix matr = new Matrix();
        matr.set(0,0,0);
        assertEquals(0, matr.determinant());

        Matrix matr1 = new Matrix(2);
        matr1.set(0,0,1);
        matr1.set(1,1,1);
        matr1.set(1,0,0);
        matr1.set(0,1,0);
        assertEquals(1, matr1.determinant());
    }

}