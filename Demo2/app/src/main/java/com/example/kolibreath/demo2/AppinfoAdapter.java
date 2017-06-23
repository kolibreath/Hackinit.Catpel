package com.example.kolibreath.demo2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kolibreath on 17-6-23.
 */

public class AppinfoAdapter extends ArrayAdapter {

    private Context context;
    private int itemId;
    private List<AppInfos> list;
    private AppInfos infos;

    public AppinfoAdapter(Context context, int itemId, List<AppInfos> list){
        super(context,itemId,list);
        this.context = context;
        this.itemId = itemId;
        this.list = list;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        infos = (AppInfos) getItem(i);
        View rview = LayoutInflater.from(getContext()).inflate(itemId,null);

        ImageView imageView =  rview.findViewById(R.id.app_icon);
        TextView textView = rview.findViewById(R.id.app_packagename);
        CheckBox checkBox = rview.findViewById(R.id.app_chechbox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                infos.ifChecked = true;
            }
        });

        imageView.setImageDrawable(infos.icon);
        textView.setText(infos.packageName);
        return rview;
    }


}
