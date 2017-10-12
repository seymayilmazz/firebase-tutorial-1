package com.seyma.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SEYMA1 on 12.10.2017.
 */
public class UsersAdapter extends ArrayAdapter<User> {

    private Context context;

    public UsersAdapter(Context context, List<User> userList) {
        super(context, -1, userList);
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /* ilk datayi aliyoruz */
        User userInfo = getItem(position);

        /* view'i xml dosyasindan olusturuyoruz */
        convertView = LayoutInflater.from(context).inflate(
                R.layout.list_item_user, parent, false
        );

        /* olusturlan layout view'i icerisindeki viewlere erismek icin
         * view holder'i kullanacagiz
         */
        ViewHolder viewHolder = new ViewHolder(convertView);
        viewHolder.textViewName.setText(userInfo.getName());
        viewHolder.textViewAge.setText(String.valueOf(userInfo.getAge()));

        return convertView;
    }

    public class ViewHolder{

        TextView textViewName;
        TextView textViewAge;

        public ViewHolder(View itemView){
            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewAge = (TextView) itemView.findViewById(R.id.textViewAge);
        }

    }


}
