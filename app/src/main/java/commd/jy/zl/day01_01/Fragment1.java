package commd.jy.zl.day01_01;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.xts.greendaodemo.db.SqlBeanDao;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import commd.jy.zl.day01_01.Persents.FragPersents;
import commd.jy.zl.day01_01.View.FragView;

public class Fragment1 extends Fragment implements FragView, View.OnClickListener, MyAdapter.OnItemClick {
    private View view;
    private RecyclerView mRlv1;
    private FragPersents fragPersents;
    private MyAdapter myAdapter;
    private Button but1;
    private PopupWindow popupWindow;
    private List<Bean.RecentBean> beans;
    private Button but11;
    private Button but2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_frag1, null);
        initView(view);
        fragPersents = new FragPersents(this);
        initData();
        return view;
    }

    private void initData() {
        fragPersents.getData();
    }

    private void initView(View view) {
        mRlv1 = (RecyclerView) view.findViewById(R.id.rlv1);
        mRlv1.setLayoutManager(new LinearLayoutManager(getContext()));
        mRlv1.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayout.VERTICAL));
    }

    @Override
    public void setData(Bean bean) {

        beans = bean.getRecent();
        myAdapter = new MyAdapter(beans, getContext());
        mRlv1.setAdapter(myAdapter);

        View view1 = View.inflate(getContext(),R.layout.layout_pop,null);
        popupWindow = new PopupWindow(view1, RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        but11 = view1.findViewById(R.id.but1_pop);
        but2 = view1.findViewById(R.id.but2_pop);

        myAdapter.setOnItemClick(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItem(View view, int i) {
        startActivity(new Intent(getContext(),Main2Activity.class));
        EventBus.getDefault().postSticky(beans.get(i).getUrl());
    }

    @Override
    public void onLongItem(View view, final int i) {

        but11.setOnClickListener(new View.OnClickListener() {

            private SqlBeanDao beanDao;

            @Override
            public void onClick(View v) {
                beanDao = BaseApp.getInstance().getDaoSession().getSqlBeanDao();
                beanDao.insertOrReplace(new SqlBean((long) i,beans.get(i).getThumbnail(),beans.get(i).getTitle(),beans.get(i).getUrl()+""));
                Toast.makeText(getContext(), "插入成功", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popupWindow.showAtLocation(mRlv1,Gravity.CENTER,0,0);
        popupWindow.setOutsideTouchable(true);
    }

}
