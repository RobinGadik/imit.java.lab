package ListLab;

public class Data implements Iterable<Integer>{
    private String name;
    private Group[] m;

    public DataIterator iterator(){
        return new DataIterator(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group[] getM() {
        return m;
    }

    public void setM(Group[] m) {
        this.m = m;
    }

    public int getMLength() {
        return m.length;
    }


    public Data(String name, Group... m) {

        this.name = name;
        this.m = m;
    }
}
