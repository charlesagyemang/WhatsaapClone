package com.example.pianoafrik.whatsaapclone.fakeadapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pianoafrik.whatsaapclone.R;
import com.example.pianoafrik.whatsaapclone.fakemodel.Chat;

import java.util.List;

/**
 * Created by pianoafrik on 3/23/17.
 */

public class ChatAdapter extends ArrayAdapter<Chat> {


    private static class ViewHolder {
        ImageView profilePicture;
        TextView name, message, timeSent;

    }

    public ChatAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Chat> objects) {
        super(context, resource, objects);
    }


    @Nullable
    @Override
    public Chat getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Chat chat = getItem(position);

        ViewHolder viewHolder;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.chat_page_item, parent, false);

            viewHolder.profilePicture = (ImageView)convertView.findViewById(R.id.img_status_profile);

            viewHolder.name = (TextView)convertView.findViewById(R.id.tvName);
            viewHolder.message = (TextView)convertView.findViewById(R.id.tvMessage);
            viewHolder.timeSent = (TextView)convertView.findViewById(R.id.tvTimeSent);

            convertView.setTag(viewHolder);

        } else {

            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.profilePicture.setImageResource(chat.getProfilePicture());

        viewHolder.name.setText(chat.getNameOfSender());
        viewHolder.message.setText(chat.getMessge());
        viewHolder.timeSent.setText("" + chat.getMessageSent());


        return  convertView;
    }
}
