package com.justdoit.elementlibrary.imageloader.loader;

import android.content.Context;
import android.view.View;

import com.justdoit.elementlibrary.base.BaseApplication;
import com.justdoit.elementlibrary.imageloader.config.SingleConfig;
import com.justdoit.elementlibrary.imageloader.utils.DownLoadImageService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ImageLoader {

    @Inject
    ILoader loader;

    /**
     * 获取当前的Loader
     *
     * @return
     */
    public static ILoader getActualLoader() {
        return BaseApplication.getInstance().getAppComponent().imageLoader();
    }

    /**
     * 加载普通图片
     *
     * @param context
     * @return
     */
    public static SingleConfig.ConfigBuilder with(Context context) {
        return new SingleConfig.ConfigBuilder(context);
    }

    public static void trimMemory(Context context, int level) {
        getActualLoader().trimMemory(context, level);
    }

    public static void onLowMemory(Context context) {
        getActualLoader().onLowMemory(context);
    }

    public static void pauseRequests(Context context) {
        getActualLoader().pause(context);

    }

    public static void resumeRequests(Context context) {
        getActualLoader().resume(context);
    }

    /**
     * Cancel any pending loads Glide may have for the view and free any resources that may have been loaded for the view.
     *
     * @param view
     */
    public static void clearMemoryCache(Context context, View view) {
        getActualLoader().clearMemoryCache(context, view);
    }

    /**
     * Clears disk cache.
     * <p>
     * <p>
     * This method should always be called on a background thread, since it is a blocking call.
     * </p>
     */
    public static void clearDiskCache(Context context) {
        getActualLoader().clearDiskCache(context);
    }

    /**
     * Clears as much memory as possible.
     */
    public static void clearMemory(Context context) {
        getActualLoader().clearMemory(context);
    }

    /**
     * 图片保存到相册
     *
     * @param downLoadImageService
     */
    public static void saveImageIntoGallery(DownLoadImageService downLoadImageService) {
        getActualLoader().saveImageIntoGallery(downLoadImageService);
    }

    public static String getCacheSize(Context context) {
        return getActualLoader().getCacheSize(context);
    }
}

