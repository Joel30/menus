package com.example.ejemplomenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    private ListView mListView;
    private String[] contacts = {"Joseph", "David", "Marian", "Luis"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.listViewID);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, contacts
        );
        mListView.setAdapter(adapter);
        registerForContextMenu(mListView);

        //listView.setOnItemClickListener(this); //to MENU 3
    }
        // MENU 1
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        menu.setHeaderTitle("Select Action");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.callAction){
            Toast.makeText(this, "Call Selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.SMSaction){
            Toast.makeText(this, "SMS selected", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return false;
        }
    }
        //MENU 2
    public void showPopup(View v){
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(MainActivity.this);
        popup.inflate(R.menu.menu);
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return true;
    }

        //MENU 3
    /*@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }*/

        //MENU 1.1
    /*    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

        getMenuInflater().inflate(R.menu.item_menu, menu);
        menu.setHeaderTitle(info.position).getName());
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.item_reset: {
                arrayList.get(info.position);
                break;
            }
            default:
                Toast.makeText(this, "Menu", Toast.LENGTH_SHORT).show(); break;
        }
        return true;
    }*/
}

