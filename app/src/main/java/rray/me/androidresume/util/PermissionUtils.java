package rray.me.androidresume.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by RRay on 9/25/2017.
 */

public class PermissionUtils {

    public static final int REQ_CODE_READ_EXTERNAL_STORAGE = 200;
    //public static final int REQ_CODE_WRITE_EXTERNAL_STORAGE = 201;

    public static boolean checkPermission(@NonNull Context context,
                                          @NonNull String permission) {

        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }

    private static void requestPermissions (@NonNull Activity activity,
                                           @NonNull String[] permissions,
                                           int reqCode) {
        ActivityCompat.requestPermissions(activity, permissions, reqCode);
    }

    public static void requestReadExternalStoragePermission(@NonNull Activity activity) {
        String[] permission = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE};
        requestPermissions(activity, permission, REQ_CODE_READ_EXTERNAL_STORAGE);
    }

    public static void requstGooglePhotosPermission(@NonNull Activity activity) {

    }

}
