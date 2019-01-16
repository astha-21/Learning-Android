package com.example.asthasharma.learningandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements FragmentInteractionListener {
    DatabaseHandler dbDatabaseHandler;
    CustomAdapterView customAdapterView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbDatabaseHandler=new DatabaseHandler(this);
        ListView listView=findViewById(R.id.contact_list);
        customAdapterView=new CustomAdapterView(this);
        customAdapterView.setData(dbDatabaseHandler.getAllUser());
        listView.setAdapter(customAdapterView);
        Button add_user=findViewById(R.id.user_add_button);
        add_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialogFragment alertDialogFragment=new AlertDialogFragment();
                alertDialogFragment.show(getSupportFragmentManager(),"Registerialog");
            }
        });

    }
    @Override
    public void registerUser(String name,String email, String password){
        Adapter adapter=new Adapter();
        adapter.setName(name);
        adapter.setEmail(email);
        adapter.setPassword(password);
        dbDatabaseHandler.addUser(adapter);
        customAdapterView.setData(dbDatabaseHandler.getAllUser());
        customAdapterView.notifyDataSetChanged();
    }
    @Override
    public void deleteUser(int id){
        dbDatabaseHandler.deleteUser(id);

    }
}
