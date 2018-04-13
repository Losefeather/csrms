package wanmao.csrms.Http;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by a1111 on 17/10/31.
 */


public interface HttpPowerService {
    //登录接口
    @FormUrlEncoded
    @POST("login")
    Observable<String> getLogin(@Field("obj") String object);
    @FormUrlEncoded
    @POST("getlib")
    Observable<String> getLib(@Field("obj") String object);
    @FormUrlEncoded
    @POST("getgps")
    Observable<String> getGPS(@Field("obj") String object);
    @POST("getlinesname")
    Observable<String> getLinesName(@Field("obj") String object);
    //指标概览接口
    @FormUrlEncoded
    @POST("app/busioper/dataOper")
    Observable<String> getPowerList(@Field("BUSI_NAME") String businame, @Field("token") String secretKey, @Field("startTime") String starttime, @Field("endTime") String endtime);
    //监测点总览接口
    @FormUrlEncoded
    @POST("app/busioper/dataOper")
    Observable<String> getStationList(@Field("BUSI_NAME") String businame, @Field("token") String secretKey, @Field("line_index") String stationId, @Field("line_name") String stationName, @Field("page") int page, @Field("pageSize") int count);
    //暂态告警接口
    @FormUrlEncoded
    @POST("app/busioper/dataOper")
    Observable<String> getTransientStatePowerList(@Field("BUSI_NAME") String businame, @Field("token") String secretKey, @Field("startTime") String startTime, @Field("endTime") String endTime);
    //暂态告警详情接口
    @FormUrlEncoded
    @POST("app/busioper/dataOper")
    Observable<String> getTransientStateInfoList(@Field("BUSI_NAME") String businame, @Field("token") String secretKey, @Field("line_index") String stationName, @Field("gd_index") String gdName, @Field("page") int page, @Field("pageSize") int count, @Field("type") String type, @Field("startTime") String starttime, @Field("endTime") String endtime);
    //稳态告警接口
    @FormUrlEncoded
    @POST("app/busioper/dataOper")
    Observable<String> getSteadyStatePowerList(@Field("BUSI_NAME") String businame, @Field("token") String secretKey, @Field("startTime") String starttime, @Field("endTime") String endtime);
    //稳态告警详情接口
    @FormUrlEncoded
    @POST("app/busioper/dataOper")
    Observable<String> getSteadyStateInfoList(@Field("BUSI_NAME") String businame, @Field("token") String secretKey, @Field("line_index") String stationName, @Field("page") int page, @Field("pageSize") int count, @Field("type") String type, @Field("startTime") String starttime, @Field("endTime") String endtime);
    //获取监测点名称及id
    @FormUrlEncoded
    @POST("app/busioper/dataOper")
    Observable<String> getStationIdList(@Field("BUSI_NAME") String businame, @Field("token") String secretKey);
    @FormUrlEncoded
    @POST("app/busioper/dataOper")
    Observable<String> getExit(@Field("BUSI_NAME") String businame, @Field("token") String secretKey);
    @FormUrlEncoded
    @POST("app/busioper/dataOper")
    Observable<String> getObj(@Field("obj") String object);
    @Multipart
    @POST("app/")
    Observable<String> uploadfromInfo( @Url String url,@PartMap() Map<String, RequestBody> maps);

}
