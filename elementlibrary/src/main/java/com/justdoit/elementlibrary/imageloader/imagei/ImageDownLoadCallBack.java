package com.justdoit.elementlibrary.imageloader.imagei;

import android.graphics.Bitmap;


public interface ImageDownLoadCallBack {

    void onDownLoadSuccess(Bitmap bitmap);

    void onDownLoadFailed();
}
