package MatrixLab;

import java.util.Arrays;

public class Matrix implements IMatrix {
    public static boolean testing(){return true;}

    private double[] m;
    private int size;
    private boolean calcDeterminant = false;
    private double detCalc;


    Matrix(){
        m = new double[1];
        size = 1;
    }

    Matrix(int n){
        m = new double[n*n];
        size = n;
    }

    public int getSize(){
        return size;
    }

    public void set(int str, int clm, double vol) {
        calcDeterminant = false;
        m[str*size+clm] = vol;
    }

    public double get(int str, int clm) {
        return m[str*size+clm];
    }

    public double determinant() {
        if(calcDeterminant)return detCalc;
        double res=0;
        if(1 == size){
            return this.get(0,0);
        }
        int flag = 1;

        for(int j=0;j<size;j++) {
            Matrix minor = new Matrix(size - 1);
            for (int str = 1;str<size;str++) {
                for(int clm=0;clm<j;clm++){
                    minor.set(str-1,clm,this.get(str,clm));
                }
                for(int clm=j+1;clm<size;clm++) {
                    minor.set(str - 1, clm - 1, this.get(str, clm));
                }
            }

            res+=flag*minor.determinant();
            flag*=-1;
        }

        calcDeterminant = true;
        detCalc = res;
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix matrix = (Matrix) o;

        if (size != matrix.size) return false;
        return Arrays.equals(m,matrix.m);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(m);
        result = 31 * result + size;
        return result;
    }
}
