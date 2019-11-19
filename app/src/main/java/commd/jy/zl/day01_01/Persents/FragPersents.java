package commd.jy.zl.day01_01.Persents;

import commd.jy.zl.day01_01.Bean;
import commd.jy.zl.day01_01.Fragment1;
import commd.jy.zl.day01_01.Modle.FragModle;
import commd.jy.zl.day01_01.ResultCallBack;
import commd.jy.zl.day01_01.View.FragView;

public class FragPersents {
    private final FragModle fragModle;
    private FragView fragView;

    public FragPersents(FragView fragView) {
        this.fragView = fragView;
        fragModle = new FragModle();
    }

    public void getData() {
        fragModle.getData(new ResultCallBack<Bean>() {
            @Override
            public void ok(Bean bean) {
                if (bean!= null && bean.getRecent()!= null && bean.getRecent().size()>0){
                    fragView.setData(bean);
                }

            }

            @Override
            public void no(String msg) {

            }
        });
    }
}
