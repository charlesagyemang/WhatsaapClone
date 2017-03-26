package com.example.pianoafrik.whatsaapclone.apiadapter;

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
import com.example.pianoafrik.whatsaapclone.apimodel.Call;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by pianoafrik on 3/24/17.
 */

public class CallAdapter extends ArrayAdapter<Call> {

    private static class ViewHolder {

        ImageView callerPicture,   callTypeIcon;
        TextView  callerName,date, timeOfCall, numberOfCalls;

    }


    public CallAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Call> objects) {
        super(context, resource, objects);
    }



    @Nullable
    @Override
    public Call getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Call call = getItem(position);

        ViewHolder viewHolder;

        if(convertView == null){

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.calls_page_item, parent, false);
            viewHolder.callerPicture = (ImageView)convertView.findViewById(R.id.iv_caller_picture);
            viewHolder.callTypeIcon = (ImageView)convertView.findViewById(R.id.iv_caller_type_icon);
            viewHolder.callerName = (TextView)convertView.findViewById(R.id.tvCallerName);
            viewHolder.date = (TextView)convertView.findViewById(R.id.tv_call_date);
            viewHolder.timeOfCall = (TextView)convertView.findViewById(R.id.tv_time_of_call);
            viewHolder.numberOfCalls = (TextView)convertView.findViewById(R.id.tv_number_of_calls);

            convertView.setTag(viewHolder);

        } else {

            viewHolder = (ViewHolder) convertView.getTag();

        }

        Picasso.with(this.getContext())
                .load(call.getCallerPicture())
                .into(viewHolder.callerPicture);


       // viewHolder.callTypeIcon.setImageResource(call.getCallTypeIcon());

        if(call.getCallTypeIcon() == true){

            viewHolder.callTypeIcon.setImageResource(R.drawable.pic_three);

        } else {

            viewHolder.callTypeIcon.setImageResource(R.drawable.pic_two);
        }

        viewHolder.callerName.setText(call.getCallerName());
        viewHolder.timeOfCall.setText(""+ call.getTimeOfCall());
        viewHolder.date.setText(""+ call.getDate());
        viewHolder.numberOfCalls.setText("(" + call.getNumberOfCalls() + ")");


        return convertView;


    }
}
