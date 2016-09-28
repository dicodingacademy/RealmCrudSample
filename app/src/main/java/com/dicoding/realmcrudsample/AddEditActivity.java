package com.dicoding.realmcrudsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddEditActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtName;
    private Button btnSubmit;

    public static String EXTRA_ID = "id";
    public static String EXTRA_NAME = "name";
    private String personName;
    private long personId;

    private PersonHelper personHelper;
    private boolean isEdit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        edtName = (EditText)findViewById(R.id.edt_name);
        btnSubmit = (Button)findViewById(R.id.btn_add_edit);

        personName = getIntent().getStringExtra(EXTRA_NAME);
        personId = getIntent().getLongExtra(EXTRA_ID, 0);

        personHelper = new PersonHelper();

        String title = null;
        String btnTitle = null;
        if (!TextUtils.isEmpty(personName)){
            isEdit = true;
            title = "Edit";
            btnTitle = "Update";

            edtName.setText(personName);
        }else{
            title = "Add";
            btnTitle = "Submit";
        }

        getSupportActionBar().setTitle(title);
        btnSubmit.setText(btnTitle);
        btnSubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_add_edit){
            String name = edtName.getText().toString().trim();
            if (!TextUtils.isEmpty(name)){
                String message = null;
                if (isEdit){
                    message = "Satu item berhasil diupdate";
                    personHelper.update(personId, name);
                }else{
                    message = "Satu item berhasil ditambahkan";
                    personHelper.insert(System.currentTimeMillis(), name);
                }

                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_delete){
            if (isEdit){
                personHelper.delete(personId);
                Toast.makeText(this, "Satu item berhasil ditampilkan", Toast.LENGTH_SHORT).show();
            }
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
