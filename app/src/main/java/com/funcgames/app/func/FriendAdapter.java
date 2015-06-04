package com.funcgames.app.func;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FriendAdapter extends ArrayAdapter<Friend> {

    private LayoutInflater layoutInflater;
    private Context mContext;

    public FriendAdapter(Context context, ArrayList<Friend> friends){
        super(context, 0, friends);
        layoutInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolderItem viewHolder;

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.friend_list_item, null);

            viewHolder = new ViewHolderItem();
            viewHolder.tv = (TextView) convertView.findViewById(R.id.friend_name);
            viewHolder.iv = (ImageView) convertView.findViewById(R.id.friend_pic);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolderItem)convertView.getTag();
        }

        Friend f = getItem(position);

        if(f != null){
            viewHolder.tv.setText(f.getName());
            viewHolder.iv.setImageDrawable(mContext.getResources().getDrawable(R.drawable.user));
//            if (viewHolder.iv != null) {
//                new ImageDownloaderTask(viewHolder.iv).execute();   //pass in url when necessary
//            }
        }

        return convertView;
    }

    static class ViewHolderItem{
        TextView tv;
        ImageView iv;
    }

}
