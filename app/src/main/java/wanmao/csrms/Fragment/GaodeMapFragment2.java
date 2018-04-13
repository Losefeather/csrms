package wanmao.csrms.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.SupportMapFragment;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.gongwen.marqueen.SimpleMF;
import com.gongwen.marqueen.SimpleMarqueeView;

import java.util.Arrays;
import java.util.List;

import wanmao.csrms.R;

import static android.support.design.widget.BottomSheetBehavior.STATE_COLLAPSED;
import static android.support.design.widget.BottomSheetBehavior.STATE_HIDDEN;

/**
 * Created by a1111 on 18/4/12.
 */

public class GaodeMapFragment2  extends SupportMapFragment {
    public static String TAG="GaodeMapFragment";

    private MapView mapView;
    private AMap aMap;
    private View view,bottomSheet;
    private Button amap_type1,amap_type2,amap_type3;
    private SimpleMarqueeView<String> marqueeView;
    private CameraUpdate cameraUpdate;
    private Intent intent;
    private MarkerOptions selectMarkerOptions;
    private Marker selectMarker;
    private BottomSheetBehavior behavior;
    private SimpleMF<String> marqueeFactory;
    private boolean isOnLongClick =false;
    private int zoomLevel = 0;
    private AMap.OnMarkerClickListener markerClickListener = new AMap.OnMarkerClickListener() {
        @Override
        public boolean onMarkerClick(Marker marker) {
            zoomLevel=13;
            cameraUpdate = CameraUpdateFactory.newCameraPosition(new CameraPosition(marker.getPosition(),zoomLevel,30,0));

            aMap.animateCamera(cameraUpdate, 1000, new AMap.CancelableCallback() {
                @Override
                public void onFinish() {

                }

                @Override
                public void onCancel() {

                }
            });
//            intent = new Intent(getActivity(),NaviActivity.class);
//            intent.putExtra("sLatitude",aMap.getMyLocation().getLatitude());
//            intent.putExtra("sLongitude",aMap.getMyLocation().getLongitude());
//            intent.putExtra("eLatitude",marker.getPosition().latitude);
//            intent.putExtra("eLongitude",marker.getPosition().longitude);
//
//            try {
//                startActivity(intent);
//            }catch (Exception e){
//                Log.e(TAG,"e"+e.toString());
//            }
//            Log.e(TAG,"end");
            return false;
        }
    };

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        view=layoutInflater.inflate(R.layout.fragment_map_main2,viewGroup,false);
        amap_type1=view.findViewById(R.id.bt_map_type1);
        amap_type2=view.findViewById(R.id.bt_map_type2);
        amap_type3=view.findViewById(R.id.bt_map_type3);
        mapView=view.findViewById(R.id.mv_main);
        bottomSheet = view.findViewById(R.id.design_bottom_sheet);
        behavior = BottomSheetBehavior.from(bottomSheet);
        //默认设置为隐藏
        behavior.setState(STATE_HIDDEN);
        mapView.onCreate(bundle);
        aMap=mapView.getMap();
        aMap.getUiSettings().setZoomPosition(1);
        aMap.getUiSettings().setMyLocationButtonEnabled(true);// 设置默认定位按钮是否显示
        aMap.setMyLocationEnabled(true);// 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        aMap.setMyLocationType(AMap.LOCATION_TYPE_LOCATE);
        cameraUpdate = CameraUpdateFactory.newCameraPosition(new CameraPosition(new LatLng(39.120000,117.200000),18,30,0));
        aMap.moveCamera(cameraUpdate);
        aMap.moveCamera(CameraUpdateFactory.zoomTo(10));
        aMap.setOnMarkerClickListener(markerClickListener);
        aMap.setOnMapLongClickListener(new AMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                Log.e(TAG,"longclick");
                isOnLongClick=true;
                showPostion(latLng);
                showBottomSheet(behavior);
            }
        });
        aMap.setOnMapClickListener(new AMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Log.e(TAG,"onclick");
               if(behavior.getState()  ==STATE_COLLAPSED){
                   behavior.setState(STATE_HIDDEN);
               }
            }
        });
        initUI();
        initData();
        onClick();
        return view;
    }
    private void showBottomSheet(BottomSheetBehavior behavior) {
        if (behavior.getState() == STATE_HIDDEN) {
            behavior.setState(STATE_COLLAPSED);
        } else {
            behavior.setState(STATE_HIDDEN);
        }
    }
    private void initUI(){
        List<String> datas = Arrays.asList("《赋得古原草送别》", "离离原上草，一岁一枯荣。", "野火烧不尽，春风吹又生。", "远芳侵古道，晴翠接荒城。", "又送王孙去，萋萋满别情。");
        marqueeView = (SimpleMarqueeView) view.findViewById(R.id.simpleMarqueeView);
        marqueeFactory = new SimpleMF(this.getContext());
        marqueeFactory.setData(datas);
        marqueeView.setMarqueeFactory(marqueeFactory);
        marqueeView.startFlipping();

    }
    private void showPostion(LatLng latLng){
        if(selectMarker!=null) {
            if (selectMarker.isVisible()) {
                selectMarker.remove();
            }
        }
        if(selectMarkerOptions==null){
            selectMarkerOptions = new MarkerOptions().anchor(0.5f,0.5f).icon(BitmapDescriptorFactory.fromResource(R.drawable.purple_pin));
        }
        if(latLng!=null){
            selectMarkerOptions.position(latLng);
            selectMarker = aMap.addMarker(selectMarkerOptions);
        }
    }
    private void onClick(){
        amap_type1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aMap.setMapType(AMap.MAP_TYPE_NORMAL);// 矢量地图模式
            }
        });
        amap_type2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aMap.setMapType(AMap.MAP_TYPE_NIGHT);//夜景地图模式
            }
        });
        amap_type3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aMap.setMapType(AMap.MAP_TYPE_SATELLITE);// 卫星地图模式
            }
        });
    }
    private void initData(){
        LatLng  localPoint3= new LatLng(39.13353950134224,117.05598751714649);
        LatLng  localPoint4= new LatLng(39.114319991328394,117.05502318149249);
        LatLng  localPoint5= new LatLng(39.8256490579789392216,117.0633675740361138264);
        LatLng  localPoint6= new LatLng(39.0688659408912642216,117.05598751714649);
        Marker marker3= aMap.addMarker(new MarkerOptions().position(localPoint3).title("北京").snippet("DefaultMarker"));
        Marker marker4= aMap.addMarker(new MarkerOptions().position(localPoint4).title("北京").snippet("DefaultMarker"));
        Marker marker5= aMap.addMarker(new MarkerOptions().position(localPoint5).title("北京").snippet("DefaultMarker"));
        Marker marker6= aMap.addMarker(new MarkerOptions().position(localPoint6).title("北京").snippet("DefaultMarker"));
    }







    @Override
    public void onResume() {
        mapView.onResume();
        if(marqueeView!=null) {
            Log.e(TAG,"startFlipping");
            marqueeView.startFlipping();
        }
        Log.e(TAG,"onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e(TAG,"onPause");
        mapView.onPause();
        if(marqueeView!=null) {
            Log.e(TAG,"stopFlipping");
            marqueeView.stopFlipping();
        }
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        Log.e(TAG,"onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        mapView.onDestroy();
        Log.e(TAG,"onDestroy");
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        Log.e(TAG,"onLowMemory");
        mapView.onLowMemory();
        super.onLowMemory();
    }
}

