package commd.jy.zl.day01_01;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String myurl = "http://news-at.zhihu.com/api/4/news/";
    @GET("hot")
    Observable<Bean> getjson();
}
