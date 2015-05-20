package com.com.bxtyfufff.helper;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by Bxtyfufff on 2015/5/1.
 */
public class helper {
    static Toast mToast;
    static void ShowToast(Context context,String text) {
        if (!TextUtils.isEmpty(text)) {
            if (mToast == null) {
                mToast = Toast.makeText(context, text,
                        Toast.LENGTH_SHORT);
            } else {
                mToast.setText(text);
            }
            mToast.show();
        }
    }
}
