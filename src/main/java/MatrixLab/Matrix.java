package MatrixLab;

public class Matrix implements IMatrix {
    public static boolean testing(){return true;}

    double[] m;
    int size;
    Matrix(){
        m = new double[1];
        size = 1;
    }

    Matrix(int n){
        m = new double[n*n];
        size = n;
    }

    public void set(int str, int clm, double vol) {
        m[str*size+clm] = vol;
    }

    public double get(int str, int clm) {
        return m[str*size+clm];
    }

    public double determinant() {
        return 0;
    }
}
