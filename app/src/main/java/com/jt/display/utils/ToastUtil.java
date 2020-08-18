package com.jt.display.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class ToastUtil {

    private static Toast toast;

//    public static void showToast(Context context, String string) {
//        if(toast == null){
//            toast = Toast.makeText(context, string, Toast.LENGTH_SHORT);
//        }else {
//            toast.setText(string);
//        }
//        toast.show();
//    }

    /**
     * 短时间显示Toast【居中】
     *
     * @param msg 显示的内容-字符串
     */
    public static void showToast(final Context context, final String msg) {
        //放在UI线程弹Toast
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }
}
