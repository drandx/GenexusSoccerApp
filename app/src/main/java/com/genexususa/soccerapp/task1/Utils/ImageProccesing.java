package com.genexususa.soccerapp.task1.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by juangarcia on 4/22/15.
 */
public class ImageProccesing extends AsyncTask<Bitmap, Void, Bitmap> {

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

        /*for(int i=0; i<10; i++){
            Integer in = new Integer(i);
            publishProgress(i);
        }*/
        return eraseBG(arg0[0],-1);
    }

    protected void onProgressUpdate(Void...a){
        //Log.d("You are in progress update ... " + a[0]);
    }

    protected void onPostExecute(String result) {
        //Log.d(""+result);
    }
}
