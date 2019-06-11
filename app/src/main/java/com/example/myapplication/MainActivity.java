package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



public void testp(View view){
//        if (Build.VERSION.SDK_INT >= 23){
//
//
//        if ( ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
//
//
////           if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_CONTACTS)){
////               Toast.makeText(this, "==================================", Toast.LENGTH_SHORT).show();
////           }else {
////               Toast.makeText(this, "你拒绝了，开始申请", Toast.LENGTH_SHORT).show();
////               ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_CONTACTS},0);
////           }
//
//            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},0);
//
//
//        }else {
//
//            Toast.makeText(this, "你已经同意了权限111111111的申请", Toast.LENGTH_SHORT).show();
//        }
//
//        }else{
//            Toast.makeText(this, "版本太低了", Toast.LENGTH_SHORT).show();
//        }



       PermissionListener listener = new PermissionListener() {
        @Override
        public void onSucceed(int requestCode, List<String> grantedPermissions) {
            // 权限申请成功回调。

            // 这里的requestCode就是申请时设置的requestCode。
            // 和onActivityResult()的requestCode一样，用来区分多个不同的请求。
            if(requestCode == 200) {
                // TODO ...
                Toast.makeText(MainActivity.this, "你已经同意了权限的申请", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailed(int requestCode, List<String> deniedPermissions) {
            // 权限申请失败回调。
            if(requestCode == 200) {
                // TODO ...
                Toast.makeText(MainActivity.this, "你拒绝了，开始申请", Toast.LENGTH_SHORT).show();
            }
        }
    };


    AndPermission.with(this)
            .requestCode(200)
            .permission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            .callback(listener)
            .start();
}

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//
//        if (requestCode==0){
//            if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
//
//                Toast.makeText(this, "你已经同意了权限的申请", Toast.LENGTH_SHORT).show();
//            }else {
//                Toast.makeText(this, "你拒绝了", Toast.LENGTH_SHORT).show();
//            }
//        }
//       super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }
}
