package wanmao.csrms.Entity;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by a1111 on 18/3/21.
 */

public class InfrastructureEntity implements Serializable{
    private String TAG=this.getClass().getName().toString();
    //提交人
    private String Author="";
    //数据类型
    private int  EventDataType=0;
    //问题类型
    private int EventType=0;
    //经度
    private String Longitude="";
    //纬度
    private String Latitude="";
    //文本文件
    private String Text="";
    //事件id
    private String Id="";
    //提交时间
    private String Time="";
    //项目名称
    private String ProjectName="";
    //照片列表
    private ArrayList<String> photoList= new ArrayList<>();
    //视频列表
    private ArrayList<String> videoList  = new ArrayList<>();
    //音频列表
    private ArrayList<String> audioList = new ArrayList<>();

    public String getTAG() {
        return TAG;
    }

    public void setTAG(String TAG) {
        this.TAG = TAG;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        this.Author = author;
    }

    public int getEventDataType() {
        return EventDataType;
    }

    public void setEventDataType(int eventDataType) {
        EventDataType = eventDataType;
    }

    public int getEventType() {
        return EventType;
    }

    public void setEventType(int eventType) {
        EventType = eventType;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public ArrayList<String> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(ArrayList<String> photoList) {
        this.photoList = photoList;
    }

    public ArrayList<String> getVideoList() {
        return videoList;
    }

    public void setVideoList(ArrayList<String> videoList) {
        this.videoList = videoList;
    }

    public ArrayList<String> getAudioList() {
        return audioList;
    }

    public void setAudioList(ArrayList<String> audioList) {
        this.audioList = audioList;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public void printlnInfo(){

        Log.e(TAG,"Author:"+this.Author+"\nTime:"+this.Time+"\nEventType:"+this.EventType+"\nEventDataType"+this.EventDataType+
        "\nId"+this.Id+"\nLatitude:"+this.Latitude+"\nLongitude"+this.Longitude+"\nText"+Text);
    }


}
