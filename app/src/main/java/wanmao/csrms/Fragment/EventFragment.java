package wanmao.csrms.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.superrecycleview.superlibrary.recycleview.SuperRecyclerView;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import wanmao.csrms.Adapter.EventSuperRecycleViewAdapter;
import wanmao.csrms.Entity.InfrastructureEntity;
import wanmao.csrms.R;

/**
 * Created by a1111 on 18/3/28.
 */

public class EventFragment extends RxFragment {
    public static String TAG="EventFragment";
    private View view;
    @Bind(R.id.bt_fragment_event_list_back)
    public Button bt_back;
    @Bind(R.id.super_recycle_view)
    public SuperRecyclerView superRecyclerView;
    private ArrayList<InfrastructureEntity> infrastructureEntityArrayList = new ArrayList<>();
    private EventSuperRecycleViewAdapter eventSuperRecycleViewAdapter;
    private String[] mUrls = new String[]{"http://d.hiphotos.baidu.com/image/h%3D200/sign=201258cbcd80653864eaa313a7dca115/ca1349540923dd54e54f7aedd609b3de9c824873.jpg",
            "http://d.hiphotos.baidu.com/image/h%3D200/sign=ea218b2c5566d01661199928a729d498/a08b87d6277f9e2fd4f215e91830e924b999f308.jpg",
            "http://img4.imgtn.bdimg.com/it/u=3445377427,2645691367&fm=21&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=2644422079,4250545639&fm=21&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=1444023808,3753293381&fm=21&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=882039601,2636712663&fm=21&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=4119861953,350096499&fm=21&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=2437456944,1135705439&fm=21&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=3251359643,4211266111&fm=21&gp=0.jpg",
            "http://img4.duitang.com/uploads/item/201506/11/20150611000809_yFe5Z.jpeg",
            "http://img5.imgtn.bdimg.com/it/u=1717647885,4193212272&fm=21&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=2024625579,507531332&fm=21&gp=0.jpg"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_event_list_main,container,false);
        ButterKnife.bind(this,view);
        initData();
        eventSuperRecycleViewAdapter = new EventSuperRecycleViewAdapter(this.getActivity(),infrastructureEntityArrayList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        superRecyclerView.setLayoutManager(layoutManager);
        superRecyclerView.setRefreshEnabled(false);//可以定制是否开启下拉刷新
        superRecyclerView.setLoadMoreEnabled(false);
        superRecyclerView.setAdapter(eventSuperRecycleViewAdapter);
        return view;
    }
    public void goBack(){

    }
    private void initData(){
        for(int i=0;i<10;i++) {
            ArrayList<String> photoList = new ArrayList<>();
            InfrastructureEntity infrastructureEntity = new InfrastructureEntity();
            infrastructureEntity.setAuthor("作者" + i);
            infrastructureEntity.setText("这里面有个坑");
            infrastructureEntity.setLatitude("");
            infrastructureEntity.setLongitude("");
            infrastructureEntity.setProjectName("基建项目"+i);
            infrastructureEntity.setId(i+"");
            infrastructureEntity.setTime("2018-03-02 \n 08:34:24");
            for(int p=0;p<9;p++){
                photoList.add(mUrls[p]);
            }
            infrastructureEntity.setPhotoList(photoList);
            infrastructureEntityArrayList.add(infrastructureEntity);
        }
    }
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
