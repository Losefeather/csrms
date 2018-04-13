package wanmao.csrms.Fragment;

import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import wanmao.csrms.R;
import wanmao.csrms.UI.RecordButton;

/**
 * Created by a1111 on 18/4/8.
 */

public class PhotoFragment extends RxFragment {
    private String TAG ="PhotoFragment";

    private View view;
    @Bind(R.id.sfv_main)
    public SurfaceView surfaceView;
    @Bind((R.id.btn_takePicture))
    public RecordButton recordButton;
    private Camera mCamera;
    private MediaRecorder mRecorder=new MediaRecorder();
    private SurfaceHolder mSurfaceHolder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_video_photo,container,false);
        ButterKnife.bind(this,view);
        initCamera();
        initRecord();
        OnClick();
        return view;
    }
    private void initRecord(){
        mRecorder.setCamera(mCamera);
        // 这两项需要放在setOutputFormat之前
        mRecorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
        mRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);

        // Set output file format
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);

        // 这两项需要放在setOutputFormat之后
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);

        mRecorder.setVideoSize(1920, 1080);
        mRecorder.setVideoFrameRate(30);
        mRecorder.setVideoEncodingBitRate(3 * 1024 * 1024);
        mRecorder.setOrientationHint(90);
        //设置记录会话的最大持续时间（毫秒）
        mRecorder.setMaxDuration(30 * 1000);
        mRecorder.setPreviewDisplay(mSurfaceHolder.getSurface());
    }
    private void initCamera(){

    }
    private void OnClick(){
        recordButton.setClickListener(new RecordButton.ClickListener() {
            @Override
            public void onClick() {
//                requestTakePicture();
            }
            @Override
            public void onLongClickStart() {
                try {
                    mRecorder.prepare();
                    mRecorder.start();
                }catch (Exception e){
                    e.printStackTrace();
                }

//                hideTips();
//                hideAllControlBtn();
//                if(canUseMediaCodec){
//                    cameraView.getGlRender().setFileSavedCallback(new FileUtils.FileSavedCallback() {
//                        @Override
//                        public void onFileSaved(String filePath) {
//                            if(!GlobalConfig.PREVIEW_WHEN_SHOT) return;
//                            startDecorateActivity(filePath, MimeType.VIDEO);
//                        }
//                    });
//                    cameraView.getGlRender().startRecording();
//                }else{
//                    showHint(getString(R.string.not_support_media_codec));
//                }
                Log.d(TAG, "onLongClickStart");
            }
            @Override
            public void onLongClickEnd() {
//            showAllControlBtn();
//            if(canUseMediaCodec){
//                cameraView.getGlRender().stopRecording();
//            }
//
            try {
                mRecorder.stop();
                mRecorder.reset();
                mRecorder.release();

                if (mCamera != null) {
                    mCamera.release();
                    mCamera = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
                Log.d(TAG, "onLongClickEnd");
            }
        });
    }
//    private void initCamera(int camera,SurfaceHolder holder){
//        try{
//            if(mCamera!=null){
//                mCamera.stopPreview();
//                mCamera.stopFaceDetection();
//                mCamera.release();
//            }
//            mCamera = Camera.open(camera);
//            parameters = mCamera.getParameters();
//            mCamera.setPreviewDisplay(holder);
//            if(camera==Camera.CameraInfo.CAMERA_FACING_FRONT){
//                if (this.getResources().getConfiguration().orientation
//                        != Configuration.ORIENTATION_LANDSCAPE) {
//                    parameters.set("orientation", "portrait");
//                    mCamera.setDisplayOrientation(90);
//                    parameters.setRotation(270);
//                } else {
//                    parameters.set("orientation", "landscape");
//                    mCamera.setDisplayOrientation(0);
//                    parameters.setRotation(0);
//                }
//            }else if(camera==Camera.CameraInfo.CAMERA_FACING_BACK) {
//                if (this.getResources().getConfiguration().orientation
//                        != Configuration.ORIENTATION_LANDSCAPE) {
//                    parameters.set("orientation", "portrait");
//                    mCamera.setDisplayOrientation(90);
//                    parameters.setRotation(90);
//                } else {
//                    parameters.set("orientation", "landscape");
//                    mCamera.setDisplayOrientation(0);
//                    parameters.setRotation(0);
//                }
//                parameters.setPreviewSize(1920, 1080);
//                parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO);
//            }else{
//                return;
//            }
//
//            mCamera.setParameters(parameters);
//            mCamera.startPreview();
//            mCamera.stopFaceDetection();
//        }catch(Exception e){
//            Log.e(TAG,"Exception"+e.toString());
//        }
//    }
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
