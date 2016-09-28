package com.dicoding.realmcrudsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
    implements AdapterView.OnItemClickListener{
    private ListView lvItem;
    private PersonAdapter adapter;
    private PersonHelper personHelper;
    private ArrayList<Person> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItem = (ListView)findViewById(R.id.lv_item);
        list = new ArrayList<>();

        adapter = new PersonAdapter(this);
        adapter.setList(list);

        lvItem.setAdapter(adapter);
        lvItem.setOnItemClickListener(this);

        personHelper = new PersonHelper();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add){
            startActivity(new Intent(this, AddEditActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (list.size() > 0){
            list.clear();
        }

        if (personHelper != null){
            ArrayList<Person> listPerson = personHelper.get();
            if (listPerson != null){
                list.addAll(listPerson);

                adapter.setList(list);
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, AddEditActivity.class);
        intent.putExtra(AddEditActivity.EXTRA_NAME, list.get(position).getName());
        intent.putExtra(AddEditActivity.EXTRA_ID, list.get(position).getId());
        startActivity(intent);
    }

}
