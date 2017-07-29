package ngocamha.com.expanablelistview;

/**
 * Created by PL on 7/25/2017.
 */

public class ChildrenModel {
    String name;
    int id;

    public ChildrenModel(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
