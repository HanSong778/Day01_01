package commd.jy.zl.day01_01.Modle;

import commd.jy.zl.day01_01.ApiService;
import commd.jy.zl.day01_01.Bean;
import commd.jy.zl.day01_01.ResultCallBack;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragModle {
    public void getData(final ResultCallBack<Bean> resultCallBack) {
        Retrofit builder = new Retrofit.Builder()
                .baseUrl(ApiService.myurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        apiService.getjson()
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<Bean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Bean bean) {
                resultCallBack.ok(bean);
            }

            @Override
            public void onError(Throwable e) {
                resultCallBack.no(e.toString());
            }

            @Override
            public void onComplete() {

            }
        });

    }
}
