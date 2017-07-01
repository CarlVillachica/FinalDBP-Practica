package carl.finaldbp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String s=getIntent().getExtras().getString("ID");

        setContentView(R.layout.activity_profile);
        TextView nombre =(TextView) findViewById(R.id.user_profile_name);
        nombre.setText(s);
    }
}
