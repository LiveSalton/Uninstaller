package com.salton123.unstaller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.salton123.unstaller.fm.SpeedUpListFragment;
import com.salton123.unstaller.util.FragmentUtil;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AbsImmersionAtivity {
    private EditText etInput;
    private CheckBox mCheckBox;
    private SpeedUpListFragment mInstalledFragment;
    private Button btnDelete, btnBackup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInstalledFragment = SpeedUpListFragment.newInstance();
        setContentView(R.layout.activity_main);
        etInput = findViewById(R.id.etInput);
        mCheckBox = findViewById(R.id.checkbox_select_all);
        btnDelete = findViewById(R.id.btn_left);
        btnBackup = findViewById(R.id.btn_right);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(ActionCode.CODE_DELETE);
            }
        });

        btnBackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(ActionCode.CODE_BACKUP);
            }
        });
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    EventBus.getDefault().post(ActionCode.CODE_CHECK);
                } else {
                    EventBus.getDefault().post(ActionCode.CODE_UNCHECK);
                }
            }
        });
        FragmentUtil.addOrReplaceFragment(
                getFragmentManager(),
                mInstalledFragment,
                R.id.flAppList);
    }
}