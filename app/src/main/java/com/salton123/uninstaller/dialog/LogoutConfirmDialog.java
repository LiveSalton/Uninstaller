package com.salton123.uninstaller.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.salton123.uninstaller.R;

/**
 * 退出确认对话框
 */
public class LogoutConfirmDialog extends Dialog implements View.OnClickListener {
    
    private Button btnConfirm;
    private Button btnCancel;
    private TextView tvTitle;
    private TextView tvMessage;
    
    private OnConfirmListener confirmListener;
    
    public LogoutConfirmDialog(Context context) {
        super(context);
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_logout_confirm);
        
        // 设置对话框背景为透明
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        
        initView();
    }
    
    private void initView() {
        btnConfirm = findViewById(R.id.btn_confirm);
        btnCancel = findViewById(R.id.btn_cancel);
        tvTitle = findViewById(R.id.tv_title);
        tvMessage = findViewById(R.id.tv_message);
        
        tvTitle.setText(R.string.logout_confirm_title);
        tvMessage.setText(R.string.logout_confirm_message);
        
        btnConfirm.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_confirm) {
            if (confirmListener != null) {
                confirmListener.onConfirm();
            }
            dismiss();
        } else if (v.getId() == R.id.btn_cancel) {
            dismiss();
        }
    }
    
    public void setOnConfirmListener(OnConfirmListener listener) {
        this.confirmListener = listener;
    }
    
    public interface OnConfirmListener {
        void onConfirm();
    }
} 