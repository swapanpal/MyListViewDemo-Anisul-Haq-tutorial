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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // grab the data from string to java String
        final String[] countryName = getResources().getStringArray(R.array.country_names);
        // Find a reference of the listView
        listView = findViewById(R.id.list_view_id);

        // Create an ArrayAdapter for single list item that pull data from data source and convert
        // it to a view and set it to the listView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                R.layout.sample_layout,R.id.text_view_id,countryName);

        // set the adapter with listView
        listView.setAdapter(adapter);

        // Set listener with listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // retrived country name from above mention String
                String value = countryName[position];
                Toast.makeText(getApplicationContext(),value + " position: " + position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}