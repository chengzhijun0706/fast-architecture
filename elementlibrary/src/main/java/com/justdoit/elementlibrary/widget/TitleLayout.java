package com.justdoit.elementlibrary.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.justdoit.elementlibrary.R;
import com.justdoit.elementlibrary.R2;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class TitleLayout extends LinearLayout {
    public static final int BUTTON_LEFT = 0x01;
    public static final int BUTTON_CENTER = 0x02;
    public static final int BUTTON_RIGHT = 0x03;

    @BindView(R2.id.lyt_root)
    LinearLayout mLytRoot;
    @BindView(R2.id.img_left)
    ImageView mImgLeft;
    @BindView(R2.id.tv_left)
    TextView mTvLeft;
    @BindView(R2.id.img_title)
    ImageView mImgTitle;
    @BindView(R2.id.tv_title)
    TextView mTvTitle;
    @BindView(R2.id.img_right)
    ImageView mImgRight;
    @BindView(R2.id.tv_right)
    TextView mTvRight;

    //定义一个集合存储控件设置的监听
    private Map<Integer, OnTitleClickListener> mListenerMap;

    public TitleLayout(Context context) {
        this(context, null);
    }

    public TitleLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mListenerMap = new HashMap<>();
        inflate(context, R.layout.layout_title, this);
        ButterKnife.bind(this);
    }

    public TitleLayout setBackground(int color) {
        mLytRoot.setBackgroundColor(color);
        return this;
    }

    public TitleLayout setText(int position, CharSequence title) {
        switch (position) {
            case BUTTON_LEFT:
                mTvLeft.setText(title);
                mTvLeft.setVisibility(VISIBLE);
                break;
            case BUTTON_CENTER:
                mTvTitle.setText(title);
                mTvTitle.setVisibility(VISIBLE);
                break;
            case BUTTON_RIGHT:
                mTvRight.setText(title);
                mTvRight.setVisibility(VISIBLE);
                break;
            default:
                break;
        }
        return this;
    }

    public TitleLayout setText(int position, int res) {
        switch (position) {
            case BUTTON_LEFT:
                mTvLeft.setText(res);
                mTvLeft.setVisibility(VISIBLE);
                break;
            case BUTTON_CENTER:
                mTvTitle.setText(res);
                mTvTitle.setVisibility(VISIBLE);
                break;
            case BUTTON_RIGHT:
                mTvRight.setText(res);
                mTvRight.setVisibility(VISIBLE);
                break;
            default:
                break;
        }
        return this;
    }

    public TitleLayout setTextSize(int position, int size) {
        switch (position) {
            case BUTTON_LEFT:
                mTvLeft.setTextSize(size);
                break;
            case BUTTON_CENTER:
                mTvTitle.setTextSize(size);
                break;
            case BUTTON_RIGHT:
                mTvRight.setTextSize(size);
                break;
            default:
                break;
        }
        return this;
    }

    public TitleLayout setTextColor(int position, int color) {
        switch (position) {
            case BUTTON_LEFT:
                mTvLeft.setTextColor(color);
                break;
            case BUTTON_CENTER:
                mTvTitle.setTextColor(color);
                break;
            case BUTTON_RIGHT:
                mTvRight.setTextColor(color);
                break;
            default:
                break;
        }
        return this;
    }

    public CharSequence getText(int position) {
        switch (position) {
            case BUTTON_LEFT:
                return mTvLeft.getText();
            case BUTTON_CENTER:
                return mTvTitle.getText();
            case BUTTON_RIGHT:
                return mTvRight.getText();
            default:
                return null;
        }
    }

    public Drawable getButtonImage(int position) {
        switch (position) {
            case BUTTON_LEFT:
                return mImgLeft.getDrawable();
            case BUTTON_CENTER:
                return mImgTitle.getDrawable();
            case BUTTON_RIGHT:
                return mImgRight.getDrawable();
            default:
                return null;
        }
    }

    public TitleLayout setButtonImage(int position, int res) {
        switch (position) {
            case BUTTON_LEFT:
                mImgLeft.setImageResource(res);
                mImgLeft.setVisibility(VISIBLE);
                break;
            case BUTTON_CENTER:
                mImgTitle.setImageResource(res);
                mImgTitle.setVisibility(VISIBLE);
                break;
            case BUTTON_RIGHT:
                mImgRight.setImageResource(res);
                mImgRight.setVisibility(VISIBLE);
                break;
            default:
                break;
        }
        return this;
    }

    public TitleLayout setButtonImage(int position, Bitmap bitmap) {
        switch (position) {
            case BUTTON_LEFT:
                mImgLeft.setImageBitmap(bitmap);
                mImgLeft.setVisibility(VISIBLE);
                break;
            case BUTTON_CENTER:
                mImgTitle.setImageBitmap(bitmap);
                mImgTitle.setVisibility(VISIBLE);
                break;
            case BUTTON_RIGHT:
                mImgRight.setImageBitmap(bitmap);
                mImgRight.setVisibility(VISIBLE);
                break;
            default:
                break;
        }
        return this;
    }

    public TitleLayout setButtonImage(int position, Drawable drawable) {
        switch (position) {
            case BUTTON_LEFT:
                mImgLeft.setImageDrawable(drawable);
                mImgLeft.setVisibility(VISIBLE);
                break;
            case BUTTON_CENTER:
                mImgTitle.setImageDrawable(drawable);
                mImgTitle.setVisibility(VISIBLE);
                break;
            case BUTTON_RIGHT:
                mImgRight.setImageDrawable(drawable);
                mImgRight.setVisibility(VISIBLE);
                break;
            default:
                break;
        }
        return this;
    }

    public TitleLayout setOnTitleClickListener(int position, OnTitleClickListener listener) {
        if (listener != null) {
            mListenerMap.put(position, listener);
        } else {
            mListenerMap.remove(position);
        }
        return this;
    }

    @OnClick({R2.id.lyt_left, R2.id.lyt_title, R2.id.lyt_right})
    public void onViewClicked(View view) {
        OnTitleClickListener listener;
        Context context = getContext();
        switch (view.getId()) {
            case R2.id.lyt_left:
                boolean result = false;
                if (mListenerMap.containsKey(BUTTON_LEFT)) {
                    listener = mListenerMap.get(BUTTON_LEFT);
                    result = listener.onClick(this, view, BUTTON_LEFT);
                }
                //默认操作
                if (!result && context instanceof Activity) {
                    ((Activity) context).finish();
                }
                break;
            case R2.id.lyt_title:
                if (mListenerMap.containsKey(BUTTON_CENTER)) {
                    listener = mListenerMap.get(BUTTON_CENTER);
                    listener.onClick(this, view, BUTTON_CENTER);
                }
                break;
            case R2.id.lyt_right:
                if (mListenerMap.containsKey(BUTTON_RIGHT)) {
                    listener = mListenerMap.get(BUTTON_RIGHT);
                    listener.onClick(this, view, BUTTON_RIGHT);
                }
                break;
            default:
                break;
        }
    }

    public interface OnTitleClickListener {
        boolean onClick(TitleLayout parent, View view, int which);
    }
}
