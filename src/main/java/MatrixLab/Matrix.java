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


        return res;
    }
}
