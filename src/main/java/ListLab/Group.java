package ListLab;

public class Group {
    int index;
    int[] data;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int[] getData() {
        return data;
    }

    public int getDataLength() {
        return data.length;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public Group(int index, int... data) {

        this.index = index;
        this.data = data;
    }

}
