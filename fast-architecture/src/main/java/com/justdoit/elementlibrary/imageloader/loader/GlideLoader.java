package com.justdoit.elementlibrary.imageloader.loader;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.justdoit.elementlibrary.imageloader.config.AnimationMode;
import com.justdoit.elementlibrary.imageloader.config.DiskCacheStrategyMode;
import com.justdoit.elementlibrary.imageloader.config.PriorityMode;
import com.justdoit.elementlibrary.imageloader.config.ScaleMode;
import com.justdoit.elementlibrary.imageloader.config.ShapeMode;
import com.justdoit.elementlibrary.imageloader.config.SingleConfig;
import com.justdoit.elementlibrary.imageloader.utils.DownLoadImageService;
import com.justdoit.elementlibrary.imageloader.utils.GlideCacheUtil;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.ColorFilterTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropSquareTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import jp.wasabeef.glide.transformations.gpu.BrightnessFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.InvertFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.PixelationFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SepiaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SketchFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SwirlFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation;


/**
 * 参考:
 * https://mrfu.me/2016/02/28/Glide_Sries_Roundup/
 */

public class GlideLoader implements ILoader {

    @Override
    public void request(final SingleConfig config) {

        GlideRequests glideRequests = GlideApp.with(config.getContext());

        GlideRequest request = getGlideRequest(config, glideRequests);

        if (request == null) {
            return;
        }

        if (config.getPlaceHolderResId() != 0)//设置占位符
            request.placeholder(config.getPlaceHolderResId());

        if (config.getErrorResId() != 0)//设置错误的图片
            request.error(config.getErrorResId());

        if (config.getFallbackResId() != 0)//后备回调符
            request.fallback(config.getFallbackResId());

        int scaleMode = config.getScaleMode();

        switch (scaleMode) {
            case ScaleMode.CENTER_CROP:
                request.centerCrop();
                break;
            case ScaleMode.FIT_CENTER:
                request.fitCenter();
                break;
            case ScaleMode.CIRCLE_CROP:
                request.circleCrop();
                break;
//            case ScaleMode.CENTER_INSIDE:
//                request.centerInside();
//                break;
            default:
                break;
        }

        setShapeModeAndBlur(config, request);

        //设置缩略图
        if (config.getThumbnail() != 0) {
            request.thumbnail(config.getThumbnail());
        }

        //设置图片加载的分辨 sp
        if (config.getoWidth() != 0 && config.getoHeight() != 0) {
            request.override(config.getoWidth(), config.getoHeight());
        }

        //是否跳过磁盘存储
        setDiskCacheStrategy(config, request);

        //设置图片加载动画
        setAnimator(config, request);

        //设置图片加载优先级
        setPriority(config, request);

        if (config.getRequestListener() != null) {
            request.listener(new RequestListener() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target target, boolean isFirstResource) {
                    config.getRequestListener().onFail();
                    return false;
                }

                @Override
                public boolean onResourceReady(Object resource, Object model, Target target, DataSource dataSource, boolean isFirstResource) {
                    config.getRequestListener().onSuccess();
                    return false;
                }
            });
        }

        if (config.getTarget() instanceof ImageView) {
            request.into((ImageView) config.getTarget());

        }

    }

    /**
     * 设置加载优先级
     *
     * @param config
     * @param request
     */
    private void setPriority(SingleConfig config, GlideRequest request) {
        switch (config.getPriority()) {
            case PriorityMode.PRIORITY_LOW:
                request.priority(Priority.LOW);
                break;
            case PriorityMode.PRIORITY_NORMAL:
                request.priority(Priority.NORMAL);
                break;
            case PriorityMode.PRIORITY_HIGH:
                request.priority(Priority.HIGH);
                break;
            case PriorityMode.PRIORITY_IMMEDIATE:
                request.priority(Priority.IMMEDIATE);
                break;
            default:
                request.priority(Priority.IMMEDIATE);
                break;
        }
    }

    private void setDiskCacheStrategy(SingleConfig config, GlideRequest request) {

        int mode = config.getDiskCacheStrategyMode();

        switch (mode) {
            case DiskCacheStrategyMode.ALL:
                request.diskCacheStrategy(DiskCacheStrategy.ALL);
                break;
            case DiskCacheStrategyMode.NONE:
                request.diskCacheStrategy(DiskCacheStrategy.NONE);
                break;
            case DiskCacheStrategyMode.SOURCE:
                request.diskCacheStrategy(DiskCacheStrategy.DATA);
                break;
            case DiskCacheStrategyMode.RESULT:
                request.diskCacheStrategy(DiskCacheStrategy.RESOURCE);
                break;
            case DiskCacheStrategyMode.AUTOMATIC:
                request.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
                break;
            default:
                break;
        }
    }

//    /**
//     * 设置加载进入动画
//     *
//     * @param config
//     * @param request
//     */
    private void setAnimator(SingleConfig config, GlideRequest request) {
        TransitionOptions transitionOptions = null;
        if (config.isAsBitmap()) {
            transitionOptions = new BitmapTransitionOptions();
        } else {
            transitionOptions = new DrawableTransitionOptions();
        }

        if (config.getAnimationType() == AnimationMode.ANIMATIONID) {
            transitionOptions.transition(config.getAnimationId());
        }
        request.transition(transitionOptions);
    }

    @Nullable
    private GlideRequest getGlideRequest(SingleConfig config, GlideRequests requestManager) {

        if (config.isGif()) {
            return requestManager.asGif().load(config.getUrl());
        }

        if (config.isAsBitmap()) {
            return requestManager.asBitmap().load(config.getUrl());
        }

        return requestManager.load(config.getUrl());
    }

    /**
     * 设置图片滤镜和形状
     *
     * @param config
     * @param request
     */
    private void setShapeModeAndBlur(SingleConfig config, GlideRequest request) {

        int count = 0;

        Transformation[] transformation = new Transformation[statisticsCount(config)];

        if (config.isNeedBlur()) {
            transformation[count] = new BlurTransformation(config.getBlurRadius());
            count++;
        }

        if (config.isNeedBrightness()) {
            transformation[count] = new BrightnessFilterTransformation(config.getBrightnessLeve()); //亮度
            count++;
        }

        if (config.isNeedGrayscale()) {
            transformation[count] = new GrayscaleTransformation(); //黑白效果
            count++;
        }

        if (config.isNeedFilteColor()) {
            transformation[count] = new ColorFilterTransformation(config.getFilteColor());
            count++;
        }

        if (config.isNeedSwirl()) {
            transformation[count] = new SwirlFilterTransformation(0.5f, 1.0f, new PointF(0.5f, 0.5f)); //漩涡
            count++;
        }

        if (config.isNeedToon()) {
            transformation[count] = new ToonFilterTransformation(); //油画
            count++;
        }

        if (config.isNeedSepia()) {
            transformation[count] = new SepiaFilterTransformation(); //墨画
            count++;
        }

        if (config.isNeedContrast()) {
            transformation[count] = new ContrastFilterTransformation(config.getContrastLevel()); //锐化
            count++;
        }

        if (config.isNeedInvert()) {
            transformation[count] = new InvertFilterTransformation(); //胶片
            count++;
        }

        if (config.isNeedPixelation()) {
            transformation[count] = new PixelationFilterTransformation(config.getPixelationLevel()); //马赛克
            count++;
        }

        if (config.isNeedSketch()) {
            transformation[count] = new SketchFilterTransformation(); //素描
            count++;
        }

        if (config.isNeedVignette()) {
            transformation[count] = new VignetteFilterTransformation(new PointF(0.5f, 0.5f),
                    new float[]{0.0f, 0.0f, 0.0f}, 0f, 0.75f);//晕映
            count++;
        }

        switch (config.getShapeMode()) {
            case ShapeMode.RECT:

                break;
            case ShapeMode.RECT_ROUND:
                transformation[count] = new RoundedCornersTransformation
                        (config.getRectRoundRadius(), 0, RoundedCornersTransformation.CornerType.ALL);
                count++;
                break;
            case ShapeMode.OVAL:
                transformation[count] = new CropCircleTransformation();
                count++;
                break;

            case ShapeMode.SQUARE:
                transformation[count] = new CropSquareTransformation();
                count++;
                break;
            default:
                break;
        }

        if (transformation.length != 0) {
            request.transforms(transformation);
        }

    }

    private int statisticsCount(SingleConfig config) {
        int count = 0;

        if (config.getShapeMode() == ShapeMode.OVAL || config.getShapeMode() == ShapeMode.RECT_ROUND || config.getShapeMode() == ShapeMode.SQUARE) {
            count++;
        }

        if (config.isNeedBlur()) {
            count++;
        }

        if (config.isNeedFilteColor()) {
            count++;
        }

        if (config.isNeedBrightness()) {
            count++;
        }

        if (config.isNeedGrayscale()) {
            count++;
        }

        if (config.isNeedSwirl()) {
            count++;
        }

        if (config.isNeedToon()) {
            count++;
        }

        if (config.isNeedSepia()) {
            count++;
        }

        if (config.isNeedContrast()) {
            count++;
        }

        if (config.isNeedInvert()) {
            count++;
        }

        if (config.isNeedPixelation()) {
            count++;
        }

        if (config.isNeedSketch()) {
            count++;
        }

        if (config.isNeedVignette()) {
            count++;
        }

        return count;
    }

    @Override
    public void pause(Context context) {
        Glide.with(context).pauseRequestsRecursive();

    }

    @Override
    public void resume(Context context) {
        GlideApp.with(context).resumeRequestsRecursive();
    }

    @Override
    public void clearDiskCache(Context context) {
        Observable.just(0)
                .observeOn(Schedulers.io())
                .subscribe(integer -> GlideApp.get(context).clearDiskCache());

    }

    @Override
    public void clearMemoryCache(Context context, View view) {
        GlideApp.with(context).clear(view);
    }

    @Override
    public void clearMemory(Context context) {
        GlideApp.get(context).clearMemory();
    }

    @Override
    public void clearAllCache(Context context) {
        clearMemory(context);
        clearDiskCache(context);
    }

    @Override
    public boolean isCached(String url) {
        return false;
    }

    @Override
    public void trimMemory(Context context, int level) {
        GlideApp.get(context).onTrimMemory(level);
    }

    @Override
    public void onLowMemory(Context context) {
        GlideApp.get(context).onLowMemory();
    }

    @Override
    public void saveImageIntoGallery(DownLoadImageService downLoadImageService) {
        new Thread(downLoadImageService).start();
    }

    @Override
    public String getCacheSize(Context context) {
        return GlideCacheUtil.getCacheSize(context);
    }

}
