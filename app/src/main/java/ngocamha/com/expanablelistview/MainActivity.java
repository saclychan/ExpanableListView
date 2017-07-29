package ngocamha.com.expanablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ExpandableListView expandableListView  = (ExpandableListView) findViewById( R.id.expandable_listview);

        ArrayList<ChildrenModel> childrenModels1 = new ArrayList<>();
        ChildrenModel child1 =  new ChildrenModel("Child1", 1);
        ChildrenModel child2 =  new ChildrenModel("Child2", 2);
        childrenModels1.add(child1);
        childrenModels1.add(child2);

        ArrayList<ParrentModel> parrentModels = new ArrayList<>();
        ParrentModel par1 =  new ParrentModel("Parent 1", childrenModels1);
        parrentModels.add(par1);

        ArrayList<ChildrenModel> childrenModels2 = new ArrayList<>();
        ChildrenModel child4 =  new ChildrenModel("Child4", 4);
        ChildrenModel child3 =  new ChildrenModel("Child3", 3);
        childrenModels2.add(child4);
        childrenModels2.add(child3);

        ParrentModel par2 = new ParrentModel("Parrent 2", childrenModels2);
        parrentModels.add(par2);

        ExpanableAdapter expanableAdapter  =  new ExpanableAdapter(MainActivity.this, parrentModels);
        expandableListView.setAdapter(expanableAdapter);
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                TextView tvPar  = (TextView) view.findViewById(R.id.tv_parrent);
                String strPar = tvPar.getText().toString();
                Toast.makeText(MainActivity.this, "parent clicked :"+strPar+" , po: "+i + " id "+ l , Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                TextView tvName = (TextView) view.findViewById(R.id.tv_children);
                String strChildName = tvName.getText().toString();
                Toast.makeText(MainActivity.this, "Childed "+strChildName+"position:"+i1+" , id:"+l, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
}
