package com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.upload;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Sink;

/**
 * Created by a1111 on 18/4/2.
 */

public class UploadFileRequstBody extends RequestBody {
    private String TAG=this.getClass().getName().toString();
    private RequestBody delegate=new RequestBody() {
        @Override
        public MediaType contentType() {
            return null;
        }

        @Override
        public void writeTo(BufferedSink sink) throws IOException {

        }
    };
    //进度回调接口
    //private final UploadProgressListener progressListener;
    private CountingSink countingSink;
    private final UploadProgressListener progressListener;

    public UploadFileRequstBody(UploadProgressListener progressListener,File file){
        this.progressListener=progressListener;

    }
    @Override
    public long contentLength() throws IOException {
        return super.contentLength();
    }

    @Override
    public MediaType contentType() {
        return null;
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {

    }
    protected final class CountingSink extends ForwardingSink {
        private long byteWritten;
        public CountingSink(Sink delegate) {
            super(delegate);
        }

        /**
         * 上传时调用该方法,在其中调用回调函数将上传进度暴露出去,该方法提供了缓冲区的自己大小
         * @param source
         * @param byteCount
         * @throws IOException
         */
        @Override
        public void write(Buffer source, long byteCount) throws IOException {
            super.write(source, byteCount);
            byteWritten += byteCount;
            progressListener.onProgress(byteWritten, contentLength());
        }
    }
}
