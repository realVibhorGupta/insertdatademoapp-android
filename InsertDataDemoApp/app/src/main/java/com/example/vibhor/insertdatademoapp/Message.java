package com.example.vibhor.insertdatademoapp;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by vibhor on 01-May-16.
 */
public class Message {

    public static void message(Context context, String message)
    {
        Toast.makeText(context , message,Toast.LENGTH_LONG ).show();
    }
}
