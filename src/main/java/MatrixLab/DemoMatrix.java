package MatrixLab;

import java.io.*;
import java.nio.ByteBuffer;

public class DemoMatrix {

    public static  void streanMatrixOut(IMatrix m, OutputStream out) throws IOException {
        out.write(m.getSize());
        for(int i=0;i<m.getSize();i++){
            for(int j=0;j<m.getSize();j++){
                byte[] b;
                b = ByteBuffer.allocate(8).putDouble(m.get(i,j)).array();

                out.write(b,0,8);
            }
        }

    }

    public static void streamMatrixIn(IMatrix m, InputStream in) throws Exception {
        int avv = 0;
        avv = in.available();
        int s = in.read();
        if(s != m.getSize())throw new Exception("Size incorrect");

        for(int i=0;i<m.getSize();i++){
            for(int j=0;j<m.getSize();j++){

                avv = in.available();
                byte[] b = new byte[8];
                in.read(b,0,8);
                double lf = 0;
                lf = ByteBuffer.allocate(8).wrap(b).getDouble();
                avv = in.available();
                m.set(i,j, lf);
            }
        }

        avv = in.available();
    }

    public static void consoleBeatiful(IMatrix m){
        for(int i=0;i<m.getSize();i++){
            for(int j=0;j<m.getSize();j++){
                System.out.print(m.get(i,j));
                System.out.print(' ');
            }
            System.out.print('\n');
        }
    }

    public static void streamOutputBeatiful(IMatrix m, Writer wr) throws IOException {

        wr.write( Integer.toString(m.getSize() ) );

        wr.write('\n');
        for(int i=0;i<m.getSize();i++){
            for(int j=0;j<m.getSize();j++){
                wr.write( String.valueOf(m.get(i,j) )  );
                wr.write(' ');
            }
            wr.write('\n');
        }
    }

    public static IMatrix streamInputBeatiful(Reader r) throws IOException {
        System.out.println(r.read());
        //int size = r.read();
        //System.out.println(size);
        IMatrix m = new Matrix(2);//size);
        for(int i=0;i<m.getSize();i++){
            for(int j=0;j<m.getSize();j++){
                m.set(i,j,r.read() );
            }
        }
        return m;
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

    public static void main(String[] args) throws IOException {
        IMatrix A = new Matrix(2);
        IInvertableMatrix I = new InvertableMatrix(2);
        FileInputStream i = null;
        FileOutputStream o = null;

        try {
            o = new FileOutputStream("1.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        A.set(0,0,1);
        A.set(0,1,0);
        A.set(1,0,1);
        A.set(1,1,1);
        try {
            streanMatrixOut(A,o);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            o.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Writer wr = new FileWriter("4.txt");
        streamOutputBeatiful(A,wr);
        wr.close();

        Reader r = new FileReader("4.txt");
        IMatrix NA = streamInputBeatiful(r);
        r.close();

        consoleBeatiful(NA);
        try {
            i = new FileInputStream("1.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int avv=0;
        try {
            avv = i.available();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            streamMatrixIn(I,i);
        } catch (Exception e) {
            e.printStackTrace();
        }

        consoleBeatiful(I);

        System.out.println("\n Elem sum is");
        System.out.println(elemSum(I));


        System.out.println("\n Determinant is");
        System.out.println(I.determinant());

        System.out.println("\n Invert matrix is");
        consoleBeatiful(I.getInversionMatrix());



        System.out.println("\n Serialization public test");
        ObjectOutputStream seria = null;

        try {
            seria = new ObjectOutputStream(new FileOutputStream("2.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            seria.writeObject(I);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            seria.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectInputStream seriaIn = null;

        try {
            seriaIn = new ObjectInputStream(new FileInputStream("2.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Object what = null;

        try {
            what = seriaIn.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(null != what && what.getClass() == InvertableMatrix.class){
            InvertableMatrix WOW = (InvertableMatrix) what;
            consoleBeatiful(WOW);
            if(WOW.equals(I))System.out.println("Serialization ok");
            else System.out.println("Serialization fail");
        }

    }

}
