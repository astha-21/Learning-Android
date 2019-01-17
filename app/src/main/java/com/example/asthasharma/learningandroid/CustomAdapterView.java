package com.example.asthasharma.learningandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 8/23/2016.
 */
public class CustomAdapterView extends BaseAdapter {

    List<UserModel> data;
    Context c;

    public void setData(List<UserModel> data) {
        this.data = data;
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

            UserModel userModel = data.get(position);
            return userModel;
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        if(data!=null)
        {

            UserModel userModel = data.get(position);
            return userModel.getId();
        }
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.list_item_view,null);
        if(data!=null)
        {

            final UserModel userModel = data.get(position);
            TextView nameTextView= (TextView) v.findViewById(R.id.name_text);
            TextView emailTextView= (TextView) v.findViewById(R.id.email_text);
            TextView numberTextView= (TextView) v.findViewById(R.id.number_text);
            nameTextView.setText(userModel.getName());
            emailTextView.setText(userModel.getEmail());
            numberTextView.setText(userModel.getPhone_number());
            ImageButton delImageButton= (ImageButton) v.findViewById(R.id.delete_user_img);
            delImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((FragmentInteractionListener)c).deleteUser(userModel.getId());
                }
            });
        }
        return v;
    }
}
