package com.genexususa.soccerapp.task1.Utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.genexususa.soccerapp.task1.Common.AppContext;

import java.util.HashMap;
import java.util.Map;

/**
 *  functionality: Implementation of the IIMageFactory that creates images from drawables. Also, this class
 *  implements a FlyWeight Pattern in order to keep the performance when Images are being created.
 *  created:       2015-04-21
 *  @author:       Juan Garcia
 *  changes:
 *  xpm:
 **/
public class DrawableImageFactory implements IImageFactory{

    private static volatile DrawableImageFactory INSTANCE;

    private static Map<String, Bitmap> images;

    /**
     *  functionality: Returns a Singleton of this class
     *  @author: Juan Garcia
     *  @param:
     *  @param:
     *  @return: DrawableImageFactory
     *  @exception:
     **/
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

    /**
     *  functionality: Creates an Image from the Drawables using the Util async task to remove the whit background.
     *  @author: Juan Garcia
     *  @param:
     *  @param:
     *  @return: DrawableImageFactory
     *  @exception:
     **/
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
