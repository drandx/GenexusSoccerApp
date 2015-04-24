package com.genexususa.soccerapp.task1.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;

/**
 *  functionality: Util class with util methods to process images
 *  created:       2015-04-21
 *  @author:       Juan Garcia
 *  changes:
 *  xpm:
 **/
public class ImageProccesing extends AsyncTask<Bitmap, Void, Bitmap> {

    /**
     *  functionality: Gets rid of the white background that shows up in Lollipop
     *  @author: Juan Garcia
     *  @param:
     *  @param:
     *  @return: Bitmap
     *  @exception:
     **/
    public static Bitmap eraseBG(Bitmap src, int color) {
        int width = src.getWidth();
        int height = src.getHeight();
        Bitmap b = src.copy(Config.ARGB_8888, true);
        b.setHasAlpha(true);

        int[] pixels = new int[width * height];
        src.getPixels(pixels, 0, width, 0, 0, width, height);

        for (int i = 0; i < width * height; i++) {
            if (pixels[i] == color) {
                pixels[i] = 0;
            }
        }

        b.setPixels(pixels, 0, width, 0, 0, width, height);

        return b;
    }

    public static Drawable getDrawable(String name, Context context) {
        int resourceId = context.getResources().getIdentifier(name, "drawable", context.getPackageName());
        return context.getResources().getDrawable(resourceId);
    }

    protected void onPreExecute (){
        Log.d("PreExceute", "On pre Exceute......");
    }

    protected Bitmap doInBackground(Bitmap...arg0) {
        Log.d("DoINBackGround","On doInBackground...");
        return eraseBG(arg0[0],-1);
    }

    protected void onProgressUpdate(Void...a){
        //Log.d("You are in progress update ... " + a[0]);
    }

    protected void onPostExecute(String result) {
        //Log.d(""+result);
    }
}
