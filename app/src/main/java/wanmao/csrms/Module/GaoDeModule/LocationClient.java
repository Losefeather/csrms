package wanmao.csrms.Module.GaoDeModule;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.location.AMapLocationListener;


/**
 * Created by a1111 on 18/3/22.
 */

public class LocationClient{

    private String TAG=this.getClass().getName().toString();

    public AMapLocationClient mlocationClient;

    public AMapLocationClientOption mLocationOption = null;

    private static LocationClient locationClient;

    private double mLatitude=0.0,mLongitude=0.0;

    private float mAccuracy=0;
    private Context context;
    private AMapLocationListener aMapLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {

            if (aMapLocation != null) {
                if (aMapLocation.getErrorCode() == 0) {
                    //可在其中解析amapLocation获取相应内容。
                    mLatitude= aMapLocation.getLatitude();
                    mLongitude=aMapLocation.getLatitude();
                    mAccuracy=aMapLocation.getAccuracy();//获取精度信息
                }else {
                    //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                    Log.e(TAG,"location Error, ErrCode:"
                            + aMapLocation.getErrorCode() + ", errInfo:"
                            + aMapLocation.getErrorInfo());
                }
            }

        }
    };
    private LocationListener locationListener=new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    public static LocationClient getInstance(Context context) {
        if (locationClient == null) {
            synchronized (LocationClient.class) {
                locationClient = new LocationClient(context);
            }
        }
        return locationClient;
    }
    private LocationClient(Context context) {
        this.context=context;

        mlocationClient = new AMapLocationClient(context);
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        mlocationClient.setLocationListener(aMapLocationListener);
        mLocationOption.setLocationMode(AMapLocationMode.Hight_Accuracy);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
        //设置定位参数
        mlocationClient.setLocationOption(mLocationOption);
    }

    public void start(){
        if(mlocationClient!=null) {
            mlocationClient.startLocation();
        }
    }

    public double[] getLastLocation(){
        double[] doubles =new double[2];
        if(mlocationClient!=null){
            doubles=new double[]{mLatitude,mLongitude};
        }
        return doubles;
    }
    public void stop(){
        if(mlocationClient!=null) {
            mlocationClient.stopLocation();
        }
    }

    public void onDestory(){
        if(mlocationClient!=null) {
            mlocationClient.onDestroy();
            //销毁之后，再次启用定位必须重新开启定位
            mlocationClient=null;
        }
    }

    public AMapLocation getLastKnownLocation(String tag){
        AMapLocation mapLocation = new AMapLocation(tag);
        if(mlocationClient!=null) {
            mapLocation=mlocationClient.getLastKnownLocation();
        }
        return mapLocation;
    }
    public void setLocationMode(int locationMode){
        if(mLocationOption!=null){

        }
    }
}

