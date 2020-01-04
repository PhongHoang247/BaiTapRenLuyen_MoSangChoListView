package com.phong.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.phong.baitaprenluyen_mosangcholistview.MainActivity;
import com.phong.baitaprenluyen_mosangcholistview.R;
import com.phong.model.Contact;

public class ContactAdapter extends ArrayAdapter<Contact> {
    Activity context;
    int resource;
    public ContactAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = this.context.getLayoutInflater().inflate(this.resource,null);
        Contact c = getItem(position);
        TextView txtTen = view.findViewById(R.id.txtTen);
        TextView txtSDT = view.findViewById(R.id.txtSDT);
        txtTen.setText(c.getName());
        txtSDT.setText(c.getPhone());

        Animation animation = AnimationUtils.loadAnimation(this.context,R.anim.mo_roi_sang);
        view.startAnimation(animation);
        return view;
    }
}
