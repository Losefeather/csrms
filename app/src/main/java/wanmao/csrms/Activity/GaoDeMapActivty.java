package wanmao.csrms.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;

import com.trello.rxlifecycle.components.support.RxFragmentActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import wanmao.csrms.Fragment.FragmentFactory;
import wanmao.csrms.Fragment.GaodeMapFragment2;
import wanmao.csrms.R;

/**
 * Created by a1111 on 18/4/11.
 */

public class GaoDeMapActivty extends RxFragmentActivity {
    private final String TAG=this.getClass().getName().toString();
    @Bind(R.id.fl_base)
    public FrameLayout frameLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaodemap_main);
        ButterKnife.bind(this);
        FragmentFactory.getFragmentInstance(this.getSupportFragmentManager(), GaodeMapFragment2.TAG);
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
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
