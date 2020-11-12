package android.example.com.mylistviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String[] countryName;
    String[] descriptions;
    int[] flags;

    public CustomAdapter(Context context, String[] countryName, String[] descriptions, int[] flags) {
        this.context = context;
        this.countryName = countryName;
        this.descriptions = descriptions;
        this.flags = flags;
    }

    @Override
    public int getCount() {
        return countryName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        if (converView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            converView = inflater.inflate(R.layout.sample_layout,parent,false);

            ImageView flagView = converView.findViewById(R.id.image_view_id);
            flagView.setImageResource(flags[position]);

            TextView countryNameTextView = converView.findViewById(R.id.title_textView_id);
            countryNameTextView.setText(countryName[position]);

            TextView descriptionTextView = converView.findViewById(R.id.desc_textView_id);
            descriptionTextView.setText(descriptions[position]);
        }
        return converView;
    }
}
