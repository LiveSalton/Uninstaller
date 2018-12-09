package com.salton123.unstaller.util;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;
import android.widget.Toast;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/8 7:05 PM
 * ModifyTime: 7:05 PM
 * Description:
 */
public class FragmentUtil {

    private static final String TAG = "FragmentUtil";

    public static void addOrReplaceFragment(
            FragmentManager manager,
            Fragment targetFragment,
            int containerViewId) {

        if (manager == null) {
            Log.e(TAG, "manager == null");
            return;
        }
        Fragment fragment = manager.findFragmentById(containerViewId);
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragment != null) {
            transaction.replace(containerViewId, targetFragment);
        } else {
            transaction.add(containerViewId, targetFragment);
        }
        transaction.commitAllowingStateLoss();
    }
}
