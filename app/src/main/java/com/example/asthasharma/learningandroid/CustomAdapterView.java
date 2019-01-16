package com.example.asthasharma.learningandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class CustomAdapterView extends BaseAdapter {
    List<Adapter> data;
    Context c;
    public void setData(List<Adapter> data){
        this.data=data;
    }

    public CustomAdapterView(Context c) {
        this.c = c;
    }
    @Override
    public int getCount() {
        if(data!=null)
        {
            return data.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if(data!=null)
        {
            Adapter adapter=data.get(position);
            return adapter;
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        if(data!=null)
        {
            Adapter adapter=data.get(position);
            return adapter.getId();
        }
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=layoutInflater.inflate(R.layout.list_item_view,null);
        if(data!=null)
        {
            final Adapter adapter=data.get(position);
            TextView nameTextView=v.findViewById(R.id.name_text);
            TextView emailTextView=v.findViewById(R.id.email_text);
            TextView passwordTextView=v.findViewById(R.id.password_text);
            nameTextView.setText(adapter.getName());
            emailTextView.setText(adapter.getEmail());
            passwordTextView.setText(adapter.getPassword());
            ImageButton delimagebutton=v.findViewById(R.id.delete_user_img);
            delimagebutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((FragmentInteractionListener)c).deleteUser(adapter.getId());
                }
            });
        }
        return v;
    }
}

