package com.salton123.unstaller.fm;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/9 2:55 PM
 * ModifyTime: 2:55 PM
 * Description:
 */
public class BaseFragment extends Fragment {

    public Activity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

}
