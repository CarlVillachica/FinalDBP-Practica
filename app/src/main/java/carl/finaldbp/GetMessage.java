package carl.finaldbp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class GetMessage extends AppCompatActivity {
    EditText nombre;
    EditText apellido;
    EditText correo;
    FloatingActionButton editar;
    FloatingActionButton regresar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provide_message);
        final ContentMessageProvider db = new ContentMessageProvider(this);
        nombre = (EditText)findViewById(R.id.input_nombre);
        apellido = (EditText) findViewById(R.id.input_apellido);
        correo = (EditText) findViewById(R.id.input_correo);
        editar = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        regresar = (FloatingActionButton) findViewById(R.id.floatingActionButton3);

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.insertarContacto(nombre.getText().toString(),apellido.getText().toString(),correo.getText().toString());
                Toast.makeText(GetMessage.this,"Added Contact",Toast.LENGTH_SHORT).show();
            }
        });

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GetMessage.this,"Back Button",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
