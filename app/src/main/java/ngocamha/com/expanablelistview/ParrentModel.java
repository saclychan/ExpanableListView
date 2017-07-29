package ngocamha.com.expanablelistview;

import java.util.ArrayList;

/**
 * Created by PL on 7/25/2017.
 */

public class ParrentModel {
    String name;
    //chứa những thằng con
    ArrayList<ChildrenModel> childrenModels;

    public ParrentModel(String name, ArrayList<ChildrenModel> childrenModels) {
        this.name = name;
        this.childrenModels = childrenModels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ChildrenModel> getChildrenModels() {
        return childrenModels;
    }

    public void setChildrenModels(ArrayList<ChildrenModel> childrenModels) {
        this.childrenModels = childrenModels;
    }
}
