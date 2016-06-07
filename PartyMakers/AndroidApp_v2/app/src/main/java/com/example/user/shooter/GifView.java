package com.example.user.shooter;

import java.io.InputStream;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Build;
import android.os.SystemClock;
import android.text.BoringLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class GifView extends View{

    private InputStream gifInputStream;
    private Movie gifMovie;
    private int movieWidth, movieHeight;
    private long movieDuration;
    private long movieStart;

    public GifView(Context context) {
        super(context);
        init(context);
    }


    public GifView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GifView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context) {
        // Get the dimensions of the View
        int targetW = this.getWidth();
        int targetH = this.getHeight();



        setFocusable(true);
        gifInputStream = context.getResources().openRawResource(R.drawable.bd1);
        gifMovie = Movie.decodeStream(gifInputStream);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrix = new DisplayMetrics();
        display.getMetrics(metrix);
        movieWidth = metrix.widthPixels;
        movieHeight = metrix.heightPixels;
        movieDuration = gifMovie.duration();


        // Get the dimensions of the bitmap
        /*BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        // Determine how much to scale down the image
        int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

        Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        mImageView.setImageBitmap(bitmap);*/


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(movieWidth, movieHeight);
    }

    public int getMovieWidth() {
        return movieWidth;
    }

    public int getMovieHeight() {
        return movieHeight;
    }

    public long getMovieDuration() {
        return movieDuration;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        long now = SystemClock.uptimeMillis();

        if(movieStart == 0) {
            movieStart = now;
        }

        if(gifMovie != null) {

            int dur = gifMovie.duration();
            if(dur == 0) {
                dur = 1000;
            }

            int relTime = (int)((now - movieStart) % dur);

            gifMovie.setTime(relTime);

            gifMovie.draw(canvas, -80, 0);
            invalidate();
        }
    }
}
