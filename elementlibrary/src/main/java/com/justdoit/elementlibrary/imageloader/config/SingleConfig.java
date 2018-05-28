package com.justdoit.elementlibrary.imageloader.config;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;

import com.blankj.utilcode.util.SizeUtils;
import com.justdoit.elementlibrary.imageloader.loader.ILoader;
import com.justdoit.elementlibrary.imageloader.loader.ImageLoader;

import javax.inject.Inject;


public class SingleConfig {
    private Context context;
    private Object url;
    private float thumbnail; //缩略图缩放倍数

    private boolean isGif; //是否是GIF图
    private View target;
    private int oWidth;
    private int oHeight;
    private boolean isIgnorePicTextMode;

    //滤镜
    private boolean isNeedVignette; //是否需要晕映
    private boolean isNeedSketch; //是否需要素描
    private float pixelationLevel; //是否需要马赛克
    private boolean isNeedPixelation; //是否需要马赛克
    private boolean isNeedInvert; //是否需要胶片
    public float contrastLevel;  //锐化等级
    private boolean isNeedContrast; //是否需要锐化
    private boolean isNeedSepia; //是否需要墨画
    private boolean isNeedToon; //是否需要油画
    private boolean isNeedSwirl;  // 是否需要漩涡
    private boolean isNeedGrayscale; //是否需要黑色
    private boolean isNeedBrightness; //是否需要亮度
    private float brightnessLeve; //是否需要亮度
    private boolean needBlur;//是否需要模糊
    private boolean needFilteColor;//是否需要模糊
    private int filteColor;

    private int priority;

    private int animationType;
    private int animationId;
    private Animator animator;
    private Animation animation;

    private int blurRadius;
    private int placeHolderResId;
    private int fallbackResId;
    private int errorResId;

    private int shapeMode;//默认矩形,可选直角矩形,圆形/椭圆
    private int rectRoundRadius;//圆角矩形时圆角的半径
    private int diskCacheStrategyMode;//是否跳过磁盘存储
    private int scaleMode;//填充模式,默认centercrop,可选fitXY,centerInside...

    private RequestListener requestListener;

    @Inject
    ILoader mImageLoader;

    public SingleConfig(ConfigBuilder builder) {
        this.context = builder.context;
        this.url = builder.url;
        this.thumbnail = builder.thumbnail;

        this.target = builder.target;

        this.oWidth = builder.oWidth;
        this.oHeight = builder.oHeight;
        this.isIgnorePicTextMode=builder.isIgnorePicTextMode;

        this.shapeMode = builder.shapeMode;
        if (shapeMode == ShapeMode.RECT_ROUND) {
            this.rectRoundRadius = builder.rectRoundRadius;
        }
        this.scaleMode = builder.scaleMode;

        this.diskCacheStrategyMode = builder.diskCacheStrategyMode;

        this.animationId = builder.animationId;
        this.animationType = builder.animationType;
        this.animator = builder.animator;
        this.animation = builder.animation;

        this.priority = builder.priority;
        //滤镜
        this.isNeedVignette = builder.isNeedVignette; //是否需要晕映
        this.isNeedSketch = builder.isNeedSketch; //是否需要素描
        this.pixelationLevel = builder.pixelationLevel; //是否需要马赛克
        this.isNeedPixelation = builder.isNeedPixelation; //是否需要马赛克
        this.isNeedInvert = builder.isNeedInvert; //是否需要胶片
        this.contrastLevel = builder.contrastLevel; //锐化等级
        this.isNeedContrast = builder.isNeedContrast; //是否需要锐化
        this.isNeedSepia = builder.isNeedSepia; //是否需要亮度
        this.isNeedToon = builder.isNeedToon; //是否需要亮度
        this.isNeedSwirl = builder.isNeedSwirl; //是否需要亮度
        this.isNeedGrayscale = builder.isNeedGrayscale; //是否需要黑色
        this.isNeedBrightness = builder.isNeedBrightness; //是否需要亮度
        this.brightnessLeve = builder.brightnessLeve; //是否需要亮度
        this.filteColor = builder.filteColor;
        this.needBlur = builder.needBlur;
        this.needFilteColor = builder.needFilteColor;
        this.placeHolderResId = builder.placeHolderResId;

        this.asBitmap = builder.asBitmap;
        this.requestListener = builder.requestListener;
        this.isGif = builder.isGif;
        this.blurRadius = builder.blurRadius;
        this.errorResId = builder.errorResId;
        this.fallbackResId = builder.fallbackResId;
    }

    public boolean isAsBitmap() {
        return asBitmap;
    }

    private boolean asBitmap;//只获取bitmap

    public Context getContext() {
        return context;
    }

    public int getDiskCacheStrategyMode() {
        return diskCacheStrategyMode;
    }

    public int getErrorResId() {
        return errorResId;
    }

    public int getFallbackResId() {
        return fallbackResId;
    }

    public boolean isNeedBlur() {
        return needBlur;
    }

    public boolean isIgnorePicTextMode() {
        return isIgnorePicTextMode;
    }

    public int getPlaceHolderResId() {
        return placeHolderResId;
    }

    public int getRectRoundRadius() {
        return rectRoundRadius;
    }

    public int getScaleMode() {
        return scaleMode;
    }

    public int getShapeMode() {
        return shapeMode;
    }

    public View getTarget() {
        return target;
    }

    public Object getUrl() {
        return url;
    }

    public int getoWidth() {
        return oWidth;
    }

    public int getoHeight() {
        return oHeight;
    }

    public int getAnimationType() {
        return animationType;
    }

    public int getAnimationId() {
        return animationId;
    }

    public Animator getAnimator() {
        return animator;
    }

    public Animation getAnimation() {
        return animation;
    }

    public int getPriority() {
        return priority;
    }

    public int getFilteColor() {
        return filteColor;
    }

    public float getContrastLevel() {
        return contrastLevel;
    }

    public boolean isNeedFilteColor() {
        return needFilteColor;
    }

    public float getBrightnessLeve() {
        return brightnessLeve;
    }

    public boolean isNeedBrightness() {
        return isNeedBrightness;
    }

    public RequestListener getRequestListener() {

        return requestListener;
    }

    public float getThumbnail() {
        return thumbnail;
    }

    private void show() {
        ImageLoader.getActualLoader().request(this);
    }

    public boolean isGif() {
        return isGif;
    }

    public int getBlurRadius() {
        return blurRadius;
    }

    public boolean isNeedGrayscale() {
        return isNeedGrayscale;
    }

    public boolean isNeedSwirl() {
        return isNeedSwirl;
    }

    public boolean isNeedToon() {
        return isNeedToon;
    }

    public boolean isNeedSepia() {
        return isNeedSepia;
    }

    public boolean isNeedContrast() {
        return isNeedContrast;
    }

    public boolean isNeedInvert() {
        return isNeedInvert;
    }

    public boolean isNeedPixelation() {
        return isNeedPixelation;
    }

    public float getPixelationLevel() {
        return pixelationLevel;
    }

    public boolean isNeedSketch() {
        return isNeedSketch;
    }

    public boolean isNeedVignette() {
        return isNeedVignette;
    }

    public interface RequestListener {
        void onSuccess();

        void onFail();
    }

    public static class ConfigBuilder {
        private Context context;

        /**
         * 图片源
         * 类型	SCHEME	示例
         * 远程图片	http://, https://	HttpURLConnection 或者参考 使用其他网络加载方案
         * 本地文件	file://	FileInputStream
         * Content provider	content://	ContentResolver
         * asset目录下的资源	asset://	AssetManager
         * res目录下的资源	  res://	Resources.openRawResource
         * Uri中指定图片数据	data:mime/type;base64,	数据类型必须符合 rfc2397规定 (仅支持 UTF-8)
         *
         * @param config
         * @return
         */
        private Object url;
        private float thumbnail;
        private boolean isGif = false;

        private View target;
        private boolean asBitmap;//只获取bitmap
        private RequestListener requestListener;

        // TODO: 2017/4/24 宽高的获取
        private int width;
        private int height;

        private int oWidth; //选择加载分辨率的宽
        private int oHeight; //选择加载分辨率的高
        private boolean isIgnorePicTextMode;

        //滤镜
        private boolean isNeedVignette; //是否需要晕映
        private boolean isNeedSketch; //是否需要素描
        private float pixelationLevel; //是否需要马赛克
        private boolean isNeedPixelation; //是否需要马赛克
        private boolean isNeedInvert; //是否需要胶片
        private float contrastLevel; //是否需要墨画
        private boolean isNeedContrast = false; //是否需要墨画
        private boolean isNeedSepia = false; //是否需要墨画
        private boolean isNeedToon = false; //是否需要油画
        private boolean isNeedSwirl = false; //是否需要漩涡
        private boolean isNeedGrayscale = false; //是否需要亮度
        private boolean isNeedBrightness = false; //是否需要亮度
        private float brightnessLeve; //亮度等级
        private boolean needBlur = false;//是否需要模糊
        private boolean needFilteColor = false;//是否需要滤镜颜色
        private int blurRadius;

        //UI:
        private int placeHolderResId;

        private int fallbackResId;

        private int errorResId;

        private int shapeMode;//默认矩形,可选直角矩形,圆形/椭圆
        private int rectRoundRadius;//圆角矩形时圆角的半径

        private int diskCacheStrategyMode;

        private int scaleMode;//填充模式,默认centercrop,可选fitXY,centerInside...

        private int priority; //请求优先级

        private int filteColor; //滤镜颜色

        public int animationId; //动画资源id
        public int animationType; //动画资源Type
        public Animator animator; //动画资源
        public Animation animation; //动画资源

        public ConfigBuilder(Context context) {
            this.context = context;
        }

        /**
         * 缩略图
         *
         * @param thumbnail
         * @return
         */
        public ConfigBuilder thumbnail(float thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public ConfigBuilder isIgnorePicTextMode(boolean isIgnore) {
            this.isIgnorePicTextMode = isIgnore;
            return this;
        }


        /**
         * error图
         *
         * @param errorResId
         * @return
         */
        public ConfigBuilder error(int errorResId) {
            this.errorResId = errorResId;
            return this;
        }

        public ConfigBuilder load(Object url) {
            this.url = url;
            return this;
        }

        public ConfigBuilder listener(RequestListener listener) {
            this.requestListener = listener;
            return this;
        }


        public void into(View targetView) {
            this.target = targetView;
            new SingleConfig(this).show();
        }

        public ConfigBuilder asBitmap() {
            this.asBitmap = true;
            return this;
        }

        /**
         * 加载图片的分辨率
         *
         * @param oWidth
         * @param oHeight
         * @return
         */
        public ConfigBuilder override(int oWidth, int oHeight) {
            this.oWidth = SizeUtils.dp2px(oWidth);
            this.oHeight = SizeUtils.dp2px(oHeight);
            return this;
        }

        /**
         * 占位图
         *
         * @param placeHolderResId
         * @return
         */
        public ConfigBuilder placeHolder(int placeHolderResId) {
            this.placeHolderResId = placeHolderResId;
            return this;
        }


        public ConfigBuilder fallback(int fallbackResId) {
            this.fallbackResId = fallbackResId;
            return this;
        }


        /**
         * 是否需要高斯模糊
         *
         * @return
         */
        public ConfigBuilder blur(int blurRadius) {
            this.needBlur = true;
            this.blurRadius = blurRadius;
            return this;
        }

        /**
         * 圆角
         *
         * @return
         */
        public ConfigBuilder asCircle() {
            this.shapeMode = ShapeMode.OVAL;
            return this;
        }

        public ConfigBuilder asGif() {
            this.isGif = true;
            return this;
        }

        /**
         * 形状为圆角矩形时的圆角半径
         *
         * @param rectRoundRadius
         * @return
         */
        public ConfigBuilder rectRoundCorner(int rectRoundRadius) {
            this.rectRoundRadius = SizeUtils.dp2px(rectRoundRadius);
            this.shapeMode = ShapeMode.RECT_ROUND;
            return this;
        }


        /**
         * 正方形
         *
         * @return
         */
        public ConfigBuilder asSquare() {
            this.shapeMode = ShapeMode.SQUARE;
            return this;
        }


        /**
         * 磁盘缓存
         */
        public ConfigBuilder diskCacheStrategy(int diskCacheStrategyMode) {
            this.diskCacheStrategyMode = diskCacheStrategyMode;
            return this;
        }

        /**
         * 拉伸/裁剪模式
         *
         * @param scaleMode 取值ScaleMode
         * @return
         */
        public ConfigBuilder scale(int scaleMode) {
            this.scaleMode = scaleMode;
            return this;
        }


        public ConfigBuilder animate(int animationId) {
            this.animationType = AnimationMode.ANIMATIONID;
            this.animationId = animationId;
            return this;
        }

        public ConfigBuilder animate(Animator animator) {
            this.animationType = AnimationMode.ANIMATOR;
            this.animator = animator;
            return this;
        }

        public ConfigBuilder animate(Animation animation) {
            this.animationType = AnimationMode.ANIMATION;
            this.animation = animation;
            return this;
        }

        public ConfigBuilder priority(int priority) {
            this.priority = priority;

            return this;
        }

        public ConfigBuilder colorFilter(int filteColor) {
            this.filteColor = filteColor;
            this.needFilteColor = true;
            return this;
        }

        public ConfigBuilder brightnessFilter(float level) {
            this.isNeedBrightness = true;
            this.brightnessLeve = level;
            return this;
        }

        public ConfigBuilder grayscaleFilter() {
            this.isNeedGrayscale = true;
            return this;
        }

        public ConfigBuilder swirlFilter() {
            this.isNeedSwirl = true;
            return this;
        }

        public ConfigBuilder toonFilter() {
            this.isNeedToon = true;
            return this;
        }

        public ConfigBuilder sepiaFilter() {
            this.isNeedSepia = true;
            return this;
        }

        public ConfigBuilder contrastFilter(float constrasrLevel) {
            this.contrastLevel = constrasrLevel;
            this.isNeedContrast = true;
            return this;
        }

        public ConfigBuilder invertFilter() {
            this.isNeedInvert = true;
            return this;
        }

        public ConfigBuilder pixelationFilter(float pixelationLevel) {
            this.pixelationLevel = pixelationLevel;
            this.isNeedPixelation = true;
            return this;
        }

        public ConfigBuilder sketchFilter() {
            this.isNeedSketch = true;
            return this;
        }

        public ConfigBuilder vignetteFilter() {
            this.isNeedVignette = true;
            return this;
        }


    }


}