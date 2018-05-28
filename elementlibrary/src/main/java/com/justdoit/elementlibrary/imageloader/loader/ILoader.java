package com.justdoit.elementlibrary.imageloader.loader;

import android.content.Context;
import android.view.View;

import com.justdoit.elementlibrary.imageloader.config.SingleConfig;
import com.justdoit.elementlibrary.imageloader.utils.DownLoadImageService;


/**
 * Created by doudou on 2017/4/10.
 */

public interface ILoader {

//    void init(Context context, int cacheSizeInM, MemoryCategory memoryCategory, boolean isInternalCD);

    void request(SingleConfig config);

    void pause(Context context);

    void resume(Context context);

    void clearDiskCache(Context context);

    void clearMemoryCache(Context context, View view);

    void clearMemory(Context context);

    void clearAllCache(Context context);

    boolean  isCached(String url);

    void trimMemory(Context context, int level);

    void onLowMemory(Context context);

    void saveImageIntoGallery(DownLoadImageService downLoadImageService);

    String getCacheSize(Context context);
}
