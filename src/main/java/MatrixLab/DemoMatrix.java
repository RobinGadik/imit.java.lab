package MatrixLab;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DemoMatrix {

    public static  void streanMatrixOut(IMatrix m, DataOutputStream out) throws IOException {

        for(int i=0;i<m.getSize();i++){
            for(int j=0;j<m.getSize();j++){
                out.writeDouble(m.get(i,j));
            }
        }

    }

    public static void streamMatrixIn(IMatrix m, DataInputStream in) throws IOException {



        for(int i=0;i<m.getSize();i++){
            for(int j=0;j<m.getSize();j++){
                m.set(i,j,in.readDouble());
            }
        }

    }

    public static void consoleBeatiful(IMatrix m){
        for(int i=0;i<m.getSize();i++){
            for(int j=0;j<m.getSize();j++){
                System.out.println(m.get(i,j));
                System.out.println(' ');
            }
            System.out.println('\n');
        }
    }

    public static double elemSum(IMatrix m){
        double res=0;
        for(int i=0;i<m.getSize();i++){
            for(int j=0;j<m.getSize();j++){
                res += m.get(i,j);
            }
        }
        return res;
    }

    public static void main(String[] args){
        IMatrix A = new Matrix(2);
        IInvertableMatrix I = new InvertableMatrix(2);
    }

}
