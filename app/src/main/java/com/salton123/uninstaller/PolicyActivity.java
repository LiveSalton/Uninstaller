package com.salton123.uninstaller;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * User: newSalton@outlook.com
 * Date: 2019/8/17 16:40
 * ModifyTime: 16:40
 * Description:
 */
public class PolicyActivity extends AbsImmersionAtivity {
    private String url = "https://www.salton123.com/privacy-policy";
    private String title = "Privacy Policy";
    private WebView webView;
    private TextView tvTitle;
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_policy);

        initViews();
        initData();
    }

    private void initViews() {
        webView = findViewById(R.id.webView);
        tvTitle = findViewById(R.id.tvTitle);
        btnBack = findViewById(R.id.btn_back);
        
        // 设置返回按钮点击事件
        if (btnBack != null) {
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    private void initData() {
        String targetUrl = getIntent().getStringExtra("url");
        if (!TextUtils.isEmpty(targetUrl)) {
            url = targetUrl;
        }
        
        String targetTitle = getIntent().getStringExtra("title");
        if (!TextUtils.isEmpty(targetTitle)) {
            title = targetTitle;
        }
        
        // 设置标题
        if (tvTitle != null) {
            tvTitle.setText(title);
        }
        
        webView.loadUrl(url);
    }
}