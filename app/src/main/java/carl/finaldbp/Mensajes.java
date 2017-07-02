package carl.finaldbp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



public class Mensajes extends AppCompatActivity {

    private ListView listView;
    private View btnSend;
    private View btnProfile;
    private EditText editText;
    boolean isMine = true;
    private List<Message> chatMessages;
    private ArrayAdapter<Message> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String s=getIntent().getExtras().getString("ID");

        final int idContacto = getIntent().getExtras().getInt("id");
        setTitle(s);
        setContentView(R.layout.activity_mensajes);

        chatMessages = new ArrayList<>();

        listView = (ListView) findViewById(R.id.list_msg);
        btnSend = findViewById(R.id.button);
        btnProfile = findViewById(R.id.profile);
        final ContentMessageProvider db = new ContentMessageProvider(this);

        editText = (EditText) findViewById(R.id.editTextNum);

        Cursor c  = db.getMensajeContacto(idContacto);
        while (c.moveToNext()){
            String mensaje = c.getString(c.getColumnIndex("mensaje"))+"\n "+c.getString(c.getColumnIndex("fecha"));
            Message chatMessage = new Message(mensaje, !isMine);
            chatMessages.add(chatMessage);
        }

        //set ListView adapter first
        adapter = new MessageAdapter(this, R.layout.item_recieve, chatMessages);
        listView.setAdapter(adapter);

        //event for button SEND
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().trim().equals("")) {
                    Toast.makeText(Mensajes.this, "Please input some text...", Toast.LENGTH_SHORT).show();
                } else {
                    //add message to list
                    Message chatMessage = new Message(editText.getText().toString(), isMine);
                    String S = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
                    db.insertMensajes(idContacto,editText.getText().toString().trim(),S);
                    chatMessages.add(chatMessage);
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                    if (isMine) {
                        isMine = false;
                    } else {
                        isMine = true;
                    }
                }
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener(){
        @Override

            public void onClick(View v){
            Intent intent = new Intent(Mensajes.this, Profile.class);
            intent.putExtra("ID",s);
            startActivity(intent);
        }
                                      }

        );

    }
}