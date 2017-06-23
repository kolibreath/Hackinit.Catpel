package com.example.kolibreath.demo2;

import android.content.Intent;
import android.graphics.drawable.Drawable;

/**
 * Created by kolibreath on 17-6-23.
 */

public class AppInfos {

    public int resourceId;
    public Drawable icon;
    public String packageName;
    public Intent appIntent;
    public boolean ifChecked;

    public AppInfos(int resourceId,String packageName){
        this.resourceId = resourceId;
        this.packageName = packageName;
    }

    public AppInfos(Drawable icon,String PackageName){
        this.packageName = PackageName;
        this.icon = icon;
    }
}
