package MatrixLab;

public interface IMatrix {
    void set(int str, int clm, double vol);
    int getSize();
    double get(int str,int clm);
    double determinant();

}
