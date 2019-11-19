package commd.jy.zl.day01_01;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.xts.greendaodemo.db.SqlBeanDao;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTbl;
    private ArrayList<Fragment> fragments;
    private FragAdapter adapter;
    private Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initVp();
    }

    private void initVp() {
        fragments = new ArrayList<>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        adapter = new FragAdapter(getSupportFragmentManager(), fragments);
        mVp.setAdapter(adapter);
        mTbl.setupWithViewPager(mVp);
        mTbl.getTabAt(0).setText("我的");
        mTbl.getTabAt(1).setText("收藏");
        mTbl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            private SqlBeanDao beanDao;

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 1:
                        Fragment2 fragment = (Fragment2) fragments.get(1);
                        fragment.initData();
                       break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mTbl = (TabLayout) findViewById(R.id.tbl);
    }
}
