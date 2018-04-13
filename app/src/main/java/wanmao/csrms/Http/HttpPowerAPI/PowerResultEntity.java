package wanmao.csrms.Http.HttpPowerAPI;

import com.google.gson.annotations.SerializedName;

/**
 * Created by a1111 on 17/11/10.
 */

public class PowerResultEntity<T> {

    //  判断标示
    @SerializedName("code")
    private String resCode;
    //    提示信息
    @SerializedName("code_desc")
    private String resCodeStr;
    //显示数据（用户需要关心的数据）
    @SerializedName("param")
    private T data;

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResCodeStr() {
        return resCodeStr;
    }

    public void setResCodeStr(String resCodeStr) {
        this.resCodeStr = resCodeStr;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
