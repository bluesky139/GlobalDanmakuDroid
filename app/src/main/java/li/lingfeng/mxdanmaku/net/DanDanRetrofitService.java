package li.lingfeng.mxdanmaku.net;

import io.reactivex.Observable;
import li.lingfeng.mxdanmaku.bean.DanDanCommentBean;
import li.lingfeng.mxdanmaku.bean.DanDanMatchBean;
import li.lingfeng.mxdanmaku.bean.DanDanSearchEpisodeBean;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DanDanRetrofitService {

    @POST("match")
    @FormUrlEncoded
    @Headers({"Accept: application/json"})
    Observable<DanDanMatchBean> match(@Field("fileName") String fileName, @Field("fileHash") String fileHash,
                                      @Field("fileSize") int fileSize, @Field("videoDuration") int videoDuration,
                                      @Field("matchMode") String matchMode);

    @GET("search/episodes")
    @Headers({"Accept: application/json"})
    Observable<DanDanSearchEpisodeBean> searchEpisode(@Query("anime") String anime);

    @GET("comment/{episodeId}")
    @Headers({"Accept: application/json"})
    Observable<DanDanCommentBean> getComments(@Path("episodeId") int episodeId, @Query("withRelated") boolean withRelated);
}