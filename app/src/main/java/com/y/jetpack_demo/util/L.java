package com.y.jetpack_demo.util;

import android.util.Log;

/**
 * log日志工具类
 */

public class L {

    public static void e(Object obj) {
        Log.e("-------",obj.toString());
    }

    public static void e(String tag,Object obj) {
        Log.e(tag,obj.toString());
    }
}
