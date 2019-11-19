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

public class Frag2Adapter extends RecyclerView.Adapter {
    private List<SqlBean> sqlBeans;
    private Context context;

    public Frag2Adapter(List<SqlBean> sqlBeans, Context context) {
        this.sqlBeans = sqlBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==1){
            View view = View.inflate(context,R.layout.layout_frag2_1,null);
            V1 v1 = new V1(view);
            return v1;
        }else {
            View view = View.inflate(context,R.layout.layout_frag2_2,null);
            V2 v2 = new V2(view);
            return v2;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int type = getItemViewType(i);
        if (type==1){
            V1 v1 = (V1) viewHolder;
            v1.tv1.setText(sqlBeans.get(i).getTitle());
            v1.tv1_2.setText(sqlBeans.get(i).getDesc());
            Glide.with(context).load(sqlBeans.get(i).getImg()).into(v1.img1);
        }else {
            V2 v2 = (V2) viewHolder;
            v2.tv2.setText(sqlBeans.get(i).getTitle());
            v2.tv2_2.setText(sqlBeans.get(i).getDesc());
            Glide.with(context).load(sqlBeans.get(i).getImg()).into(v2.img2);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==0){
            return 1;
        }else {
            return 2;
        }
    }

    @Override
    public int getItemCount() {
        return sqlBeans.size();
    }
    public class V1 extends RecyclerView.ViewHolder {
        ImageView img1;
        TextView tv1;
        TextView tv1_2;
        public V1(@NonNull View itemView) {
            super(itemView);
            img1 = itemView.findViewById(R.id.img_frag2);
            tv1 = itemView.findViewById(R.id.title_frag2);
            tv1_2 = itemView.findViewById(R.id.desc_frag2);
        }
    }
    public class V2 extends RecyclerView.ViewHolder {
        ImageView img2;
        TextView tv2;
        TextView tv2_2;
        public V2(@NonNull View itemView) {
            super(itemView);
            img2 = itemView.findViewById(R.id.img_frag2_2);
            tv2 = itemView.findViewById(R.id.title_frag2_2);
            tv2_2 = itemView.findViewById(R.id.desc_frag2_2);
        }
    }
}
