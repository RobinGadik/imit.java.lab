package ListLab;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DataIterator implements Iterator<Integer> {
    Data d;
    int groupNumber;
    int elemNumber;


    public DataIterator(Data d) {
        this.d = d;
        groupNumber=0;
        elemNumber=0;
    }

    public boolean hasNext() {
        if(d.getM()[groupNumber].getDataLength() > elemNumber + 1 ){
            return true;
        }
        for(int i=groupNumber;i<d.getMLength();i++){
            if(d.getM()[i].getDataLength()>0)return true;
        }

        return false;
    }

    public Integer next() {
        if(d.getM()[groupNumber].getDataLength() > elemNumber + 1 ){
            elemNumber++;
            return d.getM()[groupNumber].getData()[elemNumber];
        }
        for(int i=groupNumber;i<d.getMLength();i++){
            if(d.getM()[i].getDataLength()>0){
                groupNumber = i;
                elemNumber = 0;
                return d.getM()[groupNumber].getData()[elemNumber];
            }
        }
        throw new NoSuchElementException("No such elems");
    }

    public void remove() {
        int[] c = d.getM()[groupNumber].getData();
        int[] b = new int[c.length-1];
        for(int i=0;i<elemNumber;i++){
            b[i] = c[i];
        }
        for(int i=elemNumber+1;i<c.length;i++){
            b[i-1] = c[i];
        }
        d.getM()[groupNumber].setData(b);
    }

    public void forEachRemaining(Consumer<? super Integer> action) {

    }
}
