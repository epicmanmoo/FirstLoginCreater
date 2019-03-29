import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class accountinfo extends AppCompatActivity{
    TextView tv2;
    Button b1, b2, b3, b4;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountinfo);
        tv2= (TextView)findViewById(R.id.tv2);
        b1= (Button)findViewById(R.id.logout);
        db= new DatabaseHelper(this);
        b2= (Button)findViewById(R.id.goals);
        b3= (Button)findViewById(R.id.classes);
        b4=(Button)findViewById(R.id.converter);


        Intent iin= getIntent();
        final Bundle b = iin.getExtras();

        if(b!=null)
        {
            String s =(String) b.get("name");
            tv2.setText("Welcome "+ s + "!");
        }


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(accountinfo.this, MainActivity.class);
                Toast.makeText(getApplicationContext(), "Logging out", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i= new Intent(accountinfo.this, Goals.class);
            startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(accountinfo.this, Classes.class);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(accountinfo.this, Converter.class);
                startActivity(i);
            }
        });
    }

        }





