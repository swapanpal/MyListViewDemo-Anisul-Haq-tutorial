package android.example.com.mylistviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    String[] countryName, descriptions;
    int[] flags = {
            R.drawable.australia,R.drawable.bangladesh, R.drawable.bhutan,
            R.drawable.canada,R.drawable.denmark, R.drawable.egypt,
            R.drawable.finland,R.drawable.germany, R.drawable.honduras,
            R.drawable.india,R.drawable.japan, R.drawable.kenya,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // grab the data from string to java String
        countryName = getResources().getStringArray(R.array.country_names);
        descriptions = getResources().getStringArray(R.array.country_decs);

        // Find a reference of the listView
        listView = findViewById(R.id.list_view_id);
        CustomAdapter adapter = new CustomAdapter(this,countryName,descriptions,flags);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = countryName[i];
                Toast.makeText(getApplicationContext(),value + " position: " + i,Toast.LENGTH_SHORT).show();
            }
        });


    }
}