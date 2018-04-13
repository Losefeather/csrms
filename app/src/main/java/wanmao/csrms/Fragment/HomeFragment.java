package wanmao.csrms.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle.components.support.RxFragment;

import wanmao.csrms.R;

/**
 * Created by a1111 on 18/3/20.
 */

public class HomeFragment extends RxFragment{

    private String TAG=this.getClass().getName().toString();

    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_upload_main,container,false);



        return view;
    }
}
