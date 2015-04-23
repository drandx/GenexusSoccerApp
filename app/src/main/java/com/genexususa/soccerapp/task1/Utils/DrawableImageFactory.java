package com.genexususa.soccerapp.task1.Utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.genexususa.soccerapp.task1.Common.AppContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by juangarcia on 4/23/15.
 */
public class DrawableImageFactory {

    private static volatile DrawableImageFactory INSTANCE;

    private static Map<String, Bitmap> images;


    public static DrawableImageFactory getInstance() {
        DrawableImageFactory result = INSTANCE;
        if (result == null) {
            synchronized (DrawableImageFactory.class) {
                result = INSTANCE;
                if (result == null) {
                    INSTANCE = result = new DrawableImageFactory();
                }
            }
        }
        return result;
    }

    private DrawableImageFactory()
    {
        images = new HashMap<>();
    }

    public Bitmap createImage(String imageName)
    {
        Bitmap imageBitmap = images.get(imageName);
        if(imageBitmap == null)
        {
            Drawable d = ImageProccesing.getDrawable(imageName, AppContext.getContext());
            Bitmap bitmap = ((BitmapDrawable)d).getBitmap();
            imageBitmap = new ImageProccesing().doInBackground(bitmap);
            images.put(imageName, imageBitmap);
        }
        return imageBitmap;
    }
}
