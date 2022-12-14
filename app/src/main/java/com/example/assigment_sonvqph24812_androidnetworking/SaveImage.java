package com.example.assigment_sonvqph24812_androidnetworking;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.lang.ref.WeakReference;

public class SaveImage implements Target {
    Context context;
    WeakReference<AlertDialog> alertDialogWeakReference;
    WeakReference<ContentResolver> contentResolverWeakReference;
    String name;
    String desc;

    public SaveImage(Context context,AlertDialog alertDialog, ContentResolver contentResolver, String name, String desc) {
        this.context = context;
        this.alertDialogWeakReference = new WeakReference<AlertDialog>(alertDialog);
        this.contentResolverWeakReference = new WeakReference<ContentResolver>(contentResolver);
        this.name = name;
        this.desc = desc;
    }


    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
        ContentResolver resolver = contentResolverWeakReference.get();
        AlertDialog dialog = alertDialogWeakReference.get();
        if (resolver != null){
            MediaStore.Images.Media.insertImage(resolver, bitmap, name, desc);
            dialog.dismiss();
            Toast.makeText(context, "Đã tải xong!",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBitmapFailed(Drawable errorDrawable) {
        Toast.makeText(context, "Tải thất bại!",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {
        Toast.makeText(context, "Đang tải...",Toast.LENGTH_LONG).show();
    }
}
