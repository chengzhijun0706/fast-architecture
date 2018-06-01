package com.justdoit.elementlibrary.imageloader.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import com.bumptech.glide.request.target.Target;
import com.justdoit.elementlibrary.imageloader.imagei.ImageDownLoadCallBack;
import com.justdoit.elementlibrary.imageloader.loader.GlideApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 图片下载
 */


public class DownLoadImageService implements Runnable {
    private String url;
    private Context context;
    private ImageDownLoadCallBack callBack;
    private File currentFile;
    private String fileName;

    private boolean isSetMediaStore;

    public DownLoadImageService(Context context, String url, boolean isSetMediaStore, String fileName, ImageDownLoadCallBack callBack) {
        this.url = url;
        this.callBack = callBack;
        this.context = context;
        this.isSetMediaStore = isSetMediaStore;
        this.fileName = fileName;
    }

    @Override
    public void run() {

        Bitmap bitmap = null;
        try {
            bitmap = GlideApp.with(context)
                    .asBitmap()
                    .load(url)
                    .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .get();
            if (bitmap != null) {
                // 在这里执行图片保存方法
                saveImageToGallery(context, bitmap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bitmap != null && currentFile.exists()) {
                callBack.onDownLoadSuccess(bitmap);
            } else {
                callBack.onDownLoadFailed();
            }
        }

    }

    public void saveImageToGallery(Context context, Bitmap bmp) {
        // 首先保存图片
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsoluteFile();//注意小米手机必须这样获得public绝对路径

        File appDir = new File(file, fileName);
        if (!appDir.exists()) {
            appDir.mkdirs();
        }

        if (url.endsWith("gif") || url.endsWith("GIF"))
            fileName = System.currentTimeMillis() + ".gif";
        else if (url.endsWith("jpeg") || url.endsWith("JPEG")) {
            fileName = System.currentTimeMillis() + ".jpeg";
        } else if (url.endsWith("jpg") || url.endsWith("JPG")) {
            fileName = System.currentTimeMillis() + ".jpg";
        } else if (url.endsWith("webp") || url.endsWith("WEBP")) {
            fileName = System.currentTimeMillis() + ".webp";
        } else
            fileName = System.currentTimeMillis() + ".png";

        currentFile = new File(appDir, fileName);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(currentFile);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (isSetMediaStore) {
            setMediaDtore(fileName);
        }

        // 最后通知图库更新
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                Uri.fromFile(new File(currentFile.getPath()))));
    }

    /**
     * 加入到系统图库
     *
     * @param fileName
     */
    public void setMediaDtore(String fileName) {
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(),
                    currentFile.getAbsolutePath(), fileName, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
