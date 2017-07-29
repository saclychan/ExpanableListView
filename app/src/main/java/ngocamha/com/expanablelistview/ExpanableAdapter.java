package ngocamha.com.expanablelistview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by PL on 7/25/2017.
 */

public class ExpanableAdapter extends BaseExpandableListAdapter{
    Context mContext;
    LayoutInflater mInflater;
    ArrayList<ParrentModel> parrentModels;

    public ExpanableAdapter(Context mContext, ArrayList<ParrentModel> parrentModels) {
        this.mContext = mContext;
        this.parrentModels = parrentModels;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getGroupCount() {
        return parrentModels.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return parrentModels.get(i).getChildrenModels().size();
    }

    @Override
    public Object getGroup(int i) {
        return parrentModels.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return parrentModels.get(i).getChildrenModels().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return parrentModels.get(i).getChildrenModels().get(i1).getId();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        ParentHolder parentHolder;
        if(view == null){
            parentHolder =  new ParentHolder();
            view = mInflater.inflate(R.layout.item_parrent, null);

            parentHolder.tvParentName = (TextView) view.findViewById(R.id.tv_parrent);
            view.setTag(parentHolder);
        }else{
            parentHolder = (ParentHolder) view.getTag();
        }
        parentHolder.tvParentName.setText(parrentModels.get(i).getName());
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ChildrenHolder childrenHolder;
        if(view == null){
            childrenHolder = new ChildrenHolder();
            view = mInflater.inflate(R.layout.item_children, viewGroup, false);

            childrenHolder.tvChildId = (TextView) view.findViewById(R.id.tv_id);
            childrenHolder.tvChildName  = (TextView) view.findViewById(R.id.tv_children);

            view.setTag(childrenHolder);

        }else{
            childrenHolder = (ChildrenHolder) view.getTag();
        }

        childrenHolder.tvChildId.setText(""+parrentModels.get(i).getChildrenModels().get(i1).getId());
        childrenHolder.tvChildName.setText(parrentModels.get(i).getChildrenModels().get(i1).getName());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    public static class ParentHolder{
        TextView tvParentName;
    }

    public static class ChildrenHolder{
        TextView tvChildId;
        TextView tvChildName;
    }
}
