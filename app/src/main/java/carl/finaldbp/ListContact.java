package carl.finaldbp;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListContact extends AppCompatActivity {

    String[] presidents = {
            "Dwight D. Eisenhower",
            "John F. Kennedy",
            "Lyndon B. Johnson",
            "Richard Nixon",
            "Gerald Ford",
            "Jimmy Carter",
            "Ronald Reagan",
            "George H. W. Bush",
            "Bill Clinton",
            "George W. Bush",
            "Barack Obama"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact);
        ContentMessageProvider db = new ContentMessageProvider (this);

        Cursor c = db.getTodosContactos();
        List<ContactItem> contactos = new ArrayList<>();

        while (c.moveToNext()){
            String nombre = c.getString(c.getColumnIndex("nombre"));
            String apellido = c.getString(c.getColumnIndex("apellido"));
            String fullname = nombre +" "+apellido;
            contactos.add(new ContactItem(Integer.parseInt(c.getString(c.getColumnIndex("id"))),fullname));
        }


        //setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, presidents));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, presidents);

        FloatingActionButton prueba = (FloatingActionButton)findViewById(R.id.floatingActionButton5);
        final ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) lv.getItemAtPosition(position);

                Intent startIntent = new Intent(ListContact.this, Mensajes.class);
                startIntent.putExtra("ID",itemValue);
                startActivity(startIntent);

            }
        });

        prueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListContact.this,GetMessage.class);
                startActivity(intent);
            }
        });


    }

}
