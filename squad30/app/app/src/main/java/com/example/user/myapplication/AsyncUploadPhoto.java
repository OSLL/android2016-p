package com.example.user.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.ContentBody;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.jar.Manifest;

/**
 * Created by user on 6/8/2016.
 */
public class AsyncUploadPhoto extends AsyncTask<String, String, Void> {

    MainActivity m;

    @Override
    protected Void doInBackground(String... params) {
        uploadImage(params[0], params[1], params[2]);
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        m.tex.setText(m.res);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        m.verifyStoragePermissions(m);
        System.out.println("PreExecute");
    }

    public void setMainActivity(MainActivity mainActivity) {
        m = mainActivity;
    }

    private String readStream(InputStream is) {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            int i = is.read();
            while(i != -1) {
                bo.write(i);
                i = is.read();
            }
            return bo.toString();
        } catch (IOException e) {
            return "";
        }
    }

    public void uploadImage(String urlString, String filename, String path) {
        try {
            File root = Environment.getExternalStorageDirectory();
            Bitmap bitmap = BitmapFactory.decodeFile(path);
            Log.d("HERE: " , path);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            if(filename.toLowerCase().endsWith("jpg") || filename.toLowerCase().endsWith("jpeg"))
                bitmap.compress(Bitmap.CompressFormat.JPEG, 70, bos);
            if(filename.toLowerCase().endsWith("png"))
                bitmap.compress(Bitmap.CompressFormat.PNG, 70, bos);
            ContentBody contentPart = new ByteArrayBody(bos.toByteArray(), filename);
            org.apache.http.entity.mime.MultipartEntity reqEntity = new org.apache.http.entity.mime.MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
            reqEntity.addPart("image", contentPart);
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.addRequestProperty("Content-length", reqEntity.getContentLength()+"");
            conn.addRequestProperty(reqEntity.getContentType().getName(), reqEntity.getContentType().getValue());
            OutputStream os = conn.getOutputStream();
            reqEntity.writeTo(conn.getOutputStream());
            os.close();
            conn.connect();
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                Log.d("UPLOAD", "HTTP 200 OK.");
                m.res =  readStream(conn.getInputStream());
            } else {
                Log.d("UPLOAD", "HTTP "+conn.getResponseCode()+" "+conn.getResponseMessage()+".");
                String stream =  readStream(conn.getInputStream());
                m.res =  stream;
            }
        } catch (Exception e) {
            Log.d("UPLOAD_ERROR", "Multipart POST Error: " + e + "(" + urlString + ")");
        }
    }
}