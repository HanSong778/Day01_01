package commd.jy.zl.day01_01;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Bean.RecentBean> beans;
    private Context context;

    public List<Bean.RecentBean> getBeans() {
        return beans;
    }

    public void setBeans(List<Bean.RecentBean> beans) {
        this.beans = beans;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public MyAdapter(List<Bean.RecentBean> beans, Context context) {

        this.beans = beans;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context,R.layout.layout_frag1_1,null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder, final int i) {
    viewHolder.tv1.setText(beans.get(i).getTitle());
    viewHolder.tv2.setText(beans.get(i).getNews_id()+"");
        Glide.with(context).load(beans.get(i).getThumbnail()).into(viewHolder.img);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            onItemClick.onItem(v,i);
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemClick.onLongItem(v,i);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv1;
        TextView tv2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_frag1);
            tv1 = itemView.findViewById(R.id.title_frag1);
            tv2 = itemView.findViewById(R.id.desc_frag1);
        }
    }
    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public interface OnItemClick{
        void onItem(View view,int i);
        void onLongItem(View view,int i);
    }
}
