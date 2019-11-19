package commd.jy.zl.day01_01;

public interface ResultCallBack<T> {
    void ok(T bean);
    void no(String msg);
}
