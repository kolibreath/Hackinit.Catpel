package com.example.kolibreath.demo2;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private ListView listView;
    List<AppInfos> list;

    private List<AppInfos> getAppInfos(){
        List<AppInfos> appInfosList = new ArrayList<>();
        PackageManager packageManager = getPackageManager();
        List<PackageInfo> packageInfoList = packageManager.getInstalledPackages(0);
        for(PackageInfo pinfo:packageInfoList) {
            //Log.d("icon", info.applicationInfo.icon);
            if ((pinfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                AppInfos infos = new AppInfos(pinfo.applicationInfo.loadIcon(packageManager), pinfo.packageName);
                infos.appIntent = packageManager.getLaunchIntentForPackage(pinfo.packageName);
//                infos.appIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED | Intent.FLAG_ACTIVITY_CLEAR_TOP) ;
                appInfosList.add(infos);
            }
        }
        return appInfosList;
    }

    private void initView(){
        listView = (ListView) findViewById(R.id.appinfo_list);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        list = getAppInfos();
        AppinfoAdapter adapter = new AppinfoAdapter(getApplicationContext(),R.layout.appinfo_listitem,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               startActivity(list.get(i).appIntent);
            }
        });
    }
}
