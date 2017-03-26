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
import com.example.pianoafrik.whatsaapclone.fakemodel.Status;

import java.util.List;

/**
 * Created by pianoafrik on 3/23/17.
 */

public class StatusAdapter  extends ArrayAdapter<Status>{



    private static class ViewHolderOne {
        ImageView profilePicture;
        TextView name, message;

    }

    public StatusAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Status> objects) {
        super(context, resource, objects);
    }


    @Nullable
    @Override
    public Status getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Status status = getItem(position);

        ViewHolderOne viewHolder;

        if (convertView == null) {

            viewHolder = new ViewHolderOne();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.status_page_item, parent, false);
            viewHolder.profilePicture = (ImageView)convertView.findViewById(R.id.profile_picture);
            viewHolder.name = (TextView)convertView.findViewById(R.id.tvNameOfSender);
            viewHolder.message = (TextView)convertView.findViewById(R.id.tvMessageDel);

            convertView.setTag(viewHolder);

        } else {

            viewHolder = (ViewHolderOne)convertView.getTag();
        }

       viewHolder.profilePicture.setImageResource(status.getProfilePicture());
        viewHolder.name.setText(status.getNameOfSender());
        viewHolder.message.setText(status.getMessage());



        return  convertView;
    }
}
