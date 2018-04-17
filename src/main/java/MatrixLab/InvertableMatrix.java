package MatrixLab;

import ListLab.Data;
import ListLab.DataDemo;
import com.sun.org.apache.bcel.internal.generic.ClassGenException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class InvertableMatrix extends Matrix implements IInvertableMatrix , Serializable {

    public InvertableMatrix getInversionMatrix() {
        double t;
        InvertableMatrix R = new InvertableMatrix(this.getSize());
        InvertableMatrix E = new InvertableMatrix(this.getSize());
        if(Math.abs(this.determinant())<1.0E-9){
            throw new ClassGenException();
        }


        for (int i = 0; i < this.getSize(); i++) {
            for (int j = 0; j < this.getSize(); j++) {
                E.set(i, j, 0);
                R.set(i, j, this.get(i, j));
                if (i == j)
                    E.set(i, j, 1);
            }
        }
        int N = this.getSize();

        for (int k = 0; k < N; k++) {
            t = R.get(k, k);
            if(Math.abs(t) < 1.0E-09) {
                int p;
                for(p=k+1;p<N;p++) {
                    if (Math.abs(R.get(p, k)) > 1.0E-09) {
                        break;
                    }
                }
                for(int y=0;y<N;y++){
                    double temp = R.get(p,y);
                    R.set(p,y,R.get(k,y));
                    R.set(k,y,temp);

                    temp = E.get(p,y);
                    E.set(p,y,E.get(k,y));
                    E.set(k,y,temp);
                }

                //DemoMatrix.consoleBeatiful(R);
               // DemoMatrix.consoleBeatiful(E);


            }

            t = R.get(k, k);
            for (int j = 0; j < N; j++) {
                R.set(k, j, R.get(k, j) / t);
                E.set(k, j, E.get(k, j) / t);
            }

            for (int i = k + 1; i < N; i++) {
                t = R.get(i, k);

                for (int j = 0; j < N; j++) {
                    R.set(i, j, R.get(i, j) - R.get(k, j) * t);
                    E.set(i, j, E.get(i, j) - E.get(k, j) * t);
                }
            }
        }


        //DemoMatrix.consoleBeatiful(R);
        //DemoMatrix.consoleBeatiful(E);

        for (int k = N - 1; k > 0; k--) {
            for (int i = k - 1; i >= 0; i--) {
                t = R.get(i, k);
                for (int j = 0; j < N; j++) {
                    R.set(i, j, R.get(i, j) - R.get(k, j) * t);
                    E.set(i, j, E.get(i, j) - E.get(k, j) * t);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                R.set(i, j, E.get(i, j));
            }
        }

        return R;
    }




    InvertableMatrix(){
        super();
    }
    InvertableMatrix(int n){
        super(n);
    }
}
