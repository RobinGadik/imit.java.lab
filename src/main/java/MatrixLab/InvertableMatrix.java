package MatrixLab;

public class InvertableMatrix extends Matrix implements IInvertableMatrix {

    public InvertableMatrix getInversionMatrix() {
        double t;
        InvertableMatrix R = new InvertableMatrix(this.getSize());
        InvertableMatrix E = new InvertableMatrix(this.getSize());


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
