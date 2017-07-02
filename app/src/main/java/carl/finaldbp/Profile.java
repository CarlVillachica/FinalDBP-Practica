package carl.finaldbp;

import android.content.Intent;
import android.media.Image;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //final String s=getIntent().getExtras().getString("ID");

        setContentView(R.layout.activity_profile);


        //TextView nombre =(TextView) findViewById(R.id.user_profile_name);
        ImageView prueba = (ImageView) findViewById(R.id.eliminar);
        //nombre.setText(s);


        prueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this,GetMessage.class);
                startActivity(intent);
            }
        });
    }
}
