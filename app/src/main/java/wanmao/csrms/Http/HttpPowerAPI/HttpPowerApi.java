package wanmao.csrms.Http.HttpPowerAPI;

import com.google.gson.JsonObject;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle.components.support.RxFragment;
import com.trello.rxlifecycle.components.support.RxFragmentActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.HttpManagerApi;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextSubListener;

import wanmao.csrms.Http.HttpPowerService;


/**
 * Created by a1111 on 17/10/31.
 */

public class HttpPowerApi extends HttpManagerApi {
    public String TAG = "HttpPowerApi";

    public HttpPowerApi(HttpOnNextListener onNextListener, RxAppCompatActivity appCompatActivity) {
        super(onNextListener, appCompatActivity);
        //   setCache(true);
    }

    public HttpPowerApi(HttpOnNextSubListener onNextSubListener, RxAppCompatActivity appCompatActivity) {
        super(onNextSubListener, appCompatActivity);
        //    setCache(true);
    }

    public HttpPowerApi(HttpOnNextListener onNextListener, RxFragmentActivity fragmentActivity) {
        super(onNextListener, fragmentActivity);
        //    setCache(true);
    }

    public HttpPowerApi(HttpOnNextSubListener onNextSubListener, RxFragmentActivity fragmentActivity) {
        super(onNextSubListener, fragmentActivity);
        //     setCache(true);
    }

    public HttpPowerApi(HttpOnNextListener onNextListener, RxFragment fragment) {
        super(onNextListener, fragment);
        //    setCache(true);
    }

    public HttpPowerApi(HttpOnNextSubListener onNextSubListener, RxFragment fragment) {
        super(onNextSubListener, fragment);
        // setCache(true);
    }

    public HttpPowerApi(HttpOnNextSubListener onNextSubListener) {
        super(onNextSubListener);
        // setCache(true);
    }

    public HttpPowerApi(HttpOnNextListener onNextListener) {
        super(onNextListener);
        // setCache(true);
    }
    public void getGPS(int isFragment, String methodName,String userId,String X,String Y,String LV,String id,String iccid,String phoneNumber) {
        /*也可单独设置请求，会覆盖统一设置*/
        //setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
    if (isFragment == 0) {
            doHttpDealForFragment(httpService.getGPS(getPGSList(userId,X,Y,LV,id,iccid,phoneNumber)));
        } else if (isFragment == 1) {
            doHttpDeal(httpService.getGPS(getPGSList(userId,X,Y,LV,id,iccid,phoneNumber)), false);
        } else {
           doHttpDealForBackground(httpService.getGPS(getPGSList(userId,X,Y,LV,id,iccid,phoneNumber)));
        }
        //Log.e(TAG, "" + httpService.getLogin(busiName, name, password, SecretUtils.getToken()).toString());
    }
    public void getLib(int isFragment, String methodName,String userId) {
        /*也可单独设置请求，会覆盖统一设置*/
        //setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if (isFragment == 0) {
            doHttpDealForFragment(httpService.getLib(getLibList(userId)));
        } else if (isFragment == 1) {
             doHttpDeal(httpService.getLib(getLibList(userId)),false);
        } else {
            doHttpDealForBackground(httpService.getLib(getLibList(userId)));
        }
        //Log.e(TAG, "" + httpService.getLogin(busiName, name, password, SecretUtils.getToken()).toString());

    }
    public void getLogin(int isFragment, String methodName,  String userName,  String passWord) {
        /*也可单独设置请求，会覆盖统一设置*/
        //setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if (isFragment == 0) {
            doHttpDealForFragment(httpService.getLogin(getLoginList(userName,passWord)));
        } else if (isFragment == 1) {
             doHttpDeal(httpService.getLogin(getLoginList(userName,passWord)), false);
        } else {
            doHttpDealForBackground(httpService.getLogin(getLoginList(userName,passWord)));
        }
        //Log.e(TAG, "" + httpService.getLogin(busiName, name, password, SecretUtils.getToken()).toString());

    }
    public void getLinesName(int isFragment, String methodName,  String userId,String x,String y,String distance) {
        /*也可单独设置请求，会覆盖统一设置*/
        //setCache(false);
        setMethod(methodName);
        HttpPowerService httpService = getRetrofit().create(HttpPowerService.class);
        if (isFragment == 0) {
            doHttpDealForFragment(httpService.getLinesName(getLinesNameList(userId,x,y,distance)));
        } else if (isFragment == 1) {
            doHttpDeal(httpService.getLinesName(getLinesNameList(userId,x,y,distance)), false);
        } else {
            doHttpDealForBackground(httpService.getLinesName(getLinesNameList(userId,x,y,distance)));
        }
        //Log.e(TAG, "" + httpService.getLogin(busiName, name, password, SecretUtils.getToken()).toString());

    }
    public String getLoginList( String userName, String password) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("username", userName);
        jsonObject.addProperty("password", password);
        return jsonObject.toString();
    }
    public String getLibList( String userId) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userid", userId);
        return jsonObject.toString();
    }
    public String getPGSList( String userId,String x,String y,String ginal_lv,String deviceId,String iccid,String phoneNumber) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userid",userId);
        jsonObject.addProperty("longitude",x);
        jsonObject.addProperty("latitude",y);
        jsonObject.addProperty("ginallv",ginal_lv);
        jsonObject.addProperty("deviceid",deviceId);
        jsonObject.addProperty("phonenumber", phoneNumber);
        jsonObject.addProperty("iccid", iccid);
        jsonObject.addProperty("time", String.valueOf(System.currentTimeMillis()));
        return jsonObject.toString();
    }
    public String getLinesNameList(String userId,String x,String y,String distance){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userid",userId);
        jsonObject.addProperty("longitude",x);
        jsonObject.addProperty("latitude",y);
        jsonObject.addProperty("distance",distance);
        return jsonObject.toString();
    }
//    public String getTransientStateInfoList( String busiName, String stationName,String gdName,int page, int count, String type, String startTime, String endTime) {
//        JsonObject jsonObject = new JsonObject();
//        jsonObject.addProperty("BUSI_NAME", busiName);
//        jsonObject.addProperty("token", SecretUtils.getToken());
//        jsonObject.addProperty("line_index", stationName);
//        jsonObject.addProperty("gd_index", gdName);
//        jsonObject.addProperty("page", page);
//        jsonObject.addProperty("pageSize", count);
//        jsonObject.addProperty("type", type);
//        jsonObject.addProperty("startTime", startTime);
//        jsonObject.addProperty("endTime", endTime);
//        return jsonObject.toString();
//    }

}
