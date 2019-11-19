package commd.jy.zl.day01_01;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.xts.greendaodemo.db.SqlBeanDao;

import java.util.List;

import retrofit2.http.GET;

public class Fragment2 extends Fragment {
    private View view;
    private RecyclerView mRlv2;
    private SqlBeanDao beanDao;
    private Frag2Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_frag2, null);
        initView(view);
        initData();
        return view;
    }

    public void initData() {
        beanDao = BaseApp.getInstance().getDaoSession().getSqlBeanDao();
        List<SqlBean> sqlBeans = beanDao.loadAll();
        Log.d("TAg",sqlBeans.toString());
        adapter = new Frag2Adapter(sqlBeans, getContext());
        mRlv2.setAdapter(adapter);
    }

    private void initView(View view) {
        mRlv2 = (RecyclerView) view.findViewById(R.id.rlv2);
        mRlv2.setLayoutManager(new LinearLayoutManager(getContext()));
        mRlv2.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayout.VERTICAL));
    }
}
