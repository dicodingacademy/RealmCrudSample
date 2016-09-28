package com.dicoding.realmcrudsample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sidiqpermana on 9/28/16.
 */

public class PersonAdapter extends BaseAdapter {
    private ArrayList<Person> list;
    private Activity activity;
    private LayoutInflater inflater;

    public PersonAdapter(Activity activity) {
        this.activity = activity;
        inflater = LayoutInflater.from(activity);
    }

    public ArrayList<Person> getList() {
        return list;
    }

    public void setList(ArrayList<Person> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return getList().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_row_person, null);
            holder = new ViewHolder();
            holder.tvPersonName = (TextView)convertView.findViewById(R.id.tv_person);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvPersonName.setText(getList().get(position).getName());

        return convertView;
    }

    static class ViewHolder{
        TextView tvPersonName;
    }
}
