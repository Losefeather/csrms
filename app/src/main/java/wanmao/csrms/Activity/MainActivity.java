package wanmao.csrms.Activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.trello.rxlifecycle.components.support.RxFragmentActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import wanmao.csrms.Fragment.EventFragment;
import wanmao.csrms.Fragment.FragmentFactory;
import wanmao.csrms.Fragment.GaodeMapFragment;
import wanmao.csrms.R;

/**
 * Created by a1111 on 18/3/23.
 */

public class MainActivity extends RxFragmentActivity {
    @Bind(R.id.content)
    public FrameLayout frameLayout;
    @Bind(R.id.rl_main_map)
    public RelativeLayout relativeLayout_map;
    @Bind(R.id.rl_main_uoload)
    public RelativeLayout relativeLayout_upload;
    @Bind(R.id.rl_main_list)
    public RelativeLayout relativeLayout_list;
    @Bind(R.id.rl_main_user)
    public RelativeLayout relativeLayout_user;
    @Bind(R.id.iv_main_map)
    public ImageView imageView_map;
    @Bind(R.id.iv_main_upload)
    public ImageView imageView_upload;
    @Bind(R.id.iv_main_list)
    public ImageView imageView_list;
    @Bind(R.id.iv_main_user)
    public ImageView imageView_user;
    @Bind(R.id.tv_main_upload)
    public TextView textView_upload;
    @Bind(R.id.tv_main_list)
    public TextView textView_list;
    @Bind(R.id.tv_main_map)
    public TextView textView_map;
    @Bind(R.id.tv_main_user)
    public TextView textView_user;

    private int selectitem=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        checkPermission();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        refreshButtomUI(selectitem);
        //initData();
        OnClick();
    }
    public void OnClick(){
        relativeLayout_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshButtomUI(0);
                FragmentFactory.getFragmentInstance(getSupportFragmentManager(), GaodeMapFragment.TAG);
            }
        });
        relativeLayout_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshButtomUI(1);
                FragmentFactory.getFragmentInstance(getSupportFragmentManager(), EventFragment.TAG);
            }
        });
        relativeLayout_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshButtomUI(2);
            }
        });
        relativeLayout_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshButtomUI(3);
            }
        });
    }
    public void refreshButtomUI(int i){
        refresh();
        switch (i){
            case 0:
                imageView_map.setBackground(getDrawable(R.mipmap.map_choose));
                textView_map.setTextColor(getColor(R.color.tab_selected_color));
                break;
            case 1:
                imageView_upload.setBackground(getDrawable(R.mipmap.upload_choose));
                textView_upload.setTextColor(getColor(R.color.tab_selected_color));
                break;
            case 2:
                imageView_list.setBackground(getDrawable(R.mipmap.list_choose));
                textView_list.setTextColor(getColor(R.color.tab_selected_color));
                break;
            case 3:
                imageView_user.setBackground(getDrawable(R.mipmap.user_choose));
                textView_user.setTextColor(getColor(R.color.tab_selected_color));
                break;
        }
    }
    private void refresh(){
        imageView_map.setBackground(getDrawable(R.mipmap.map_unchoose));
        imageView_upload.setBackground(getDrawable(R.mipmap.upload_unchoose));
        imageView_list.setBackground(getDrawable(R.mipmap.list_unchoose));
        imageView_user.setBackground(getDrawable(R.mipmap.user_unchoose));
        textView_upload.setTextColor(getColor(R.color.tab_normal_color));
        textView_list.setTextColor(getColor(R.color.tab_normal_color));
        textView_map.setTextColor(getColor(R.color.tab_normal_color));
        textView_user.setTextColor(getColor(R.color.tab_normal_color));
    }

    public void checkPermission(){
        String[] strings = new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE};
        for(int i=0;i<strings.length;i++){
            if (ContextCompat.checkSelfPermission(this, strings[i]) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,strings,i);
                //自定义的code
            }else{
                //
            }
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
