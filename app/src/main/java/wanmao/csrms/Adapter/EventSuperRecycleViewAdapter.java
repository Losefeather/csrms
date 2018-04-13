package wanmao.csrms.Adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.superrecycleview.superlibrary.adapter.BaseViewHolder;
import com.superrecycleview.superlibrary.adapter.SuperBaseAdapter;

import java.util.ArrayList;

import wanmao.csrms.Entity.InfrastructureEntity;
import wanmao.csrms.R;
import wanmao.csrms.UI.NineGirdLayout.NineGridTestLayout;

/**
 * Created by a1111 on 18/3/28.
 */

public class EventSuperRecycleViewAdapter extends SuperBaseAdapter<InfrastructureEntity>{

    private String TAG = this.getClass().getName().toString();
    private Context context ;
    private ArrayList<InfrastructureEntity> infrastructureEntityList;
    public EventSuperRecycleViewAdapter(Context context) {
        super(context);
    }

    public EventSuperRecycleViewAdapter(Context context, ArrayList<InfrastructureEntity> data) {
        super(context, data);
        this.context=context;
        this.infrastructureEntityList=data;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
    }

    @Override
    protected InfrastructureEntity getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        super.setOnItemClickListener(onItemClickListener);
    }

    @Override
    protected void convert(BaseViewHolder holder, InfrastructureEntity item, int position) {
        TextView tv_time = holder.getView(R.id.tv_recycview_item_time);
        TextView tv_gps = holder.getView(R.id.tv_recycbiew_item_gps);
        TextView tv_author = holder.getView(R.id.tv_recycbiew_item_commit_name);
        TextView tv_problem = holder.getView(R.id.tv_recycbiew_item_problem);
        TextView tv_projectName=holder.getView(R.id.tv_recycbiew_item_project_name);
        NineGridTestLayout nineGridTestLayout = holder.getView(R.id.ninegridayout);
        tv_time.setText(item.getTime());
        tv_gps.setText(item.getLatitude()+" ,"+item.getLongitude());
        tv_author.setText(item.getAuthor());
        tv_projectName.setText(item.getProjectName());
        //tv_problem.setText(item.getEventType());
        tv_problem.setText("基建问题");
        nineGridTestLayout.setUrlList(item.getPhotoList());
        nineGridTestLayout.setIsShowAll(false);
    }

    @Override
    protected int getItemViewLayoutId(int position, InfrastructureEntity item) {
        int layout_id=0;
        layout_id = R.layout.recycview_info_item;
        return layout_id;
    }
}
