package carl.finaldbp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        //setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, presidents));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, presidents);
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
    }

}
