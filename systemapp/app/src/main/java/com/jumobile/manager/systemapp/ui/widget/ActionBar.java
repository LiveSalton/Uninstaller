package com.jumobile.manager.systemapp.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jumobile.manager.systemapp.R;

/* compiled from: source */
/* loaded from: classes.dex */
public class ActionBar extends LinearLayout {
    public ImageButton a;
    public TextView b;
    private Context c;
    private LinearLayout d;
    private EditText e;
    private int f;

    public ActionBar(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public ActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
        this.f = 0;
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.c = context;
        inflate(context, R.layout.view_action_bar, this);
        this.a = (ImageButton) findViewById(R.id.left);
        this.b = (TextView) findViewById(R.id.title);
        this.e = (EditText) findViewById(R.id.edit_text);
        this.d = (LinearLayout) findViewById(R.id.action_container);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.action_bar);
            String string = obtainStyledAttributes.getString(1);
            if (string != null) {
                this.b.setText(string);
            }
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            if (drawable != null) {
                this.a.setImageDrawable(drawable);
            } else {
                this.a.setVisibility(4);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.getLayoutParams();
                layoutParams.width = (int) getResources().getDimension(R.dimen.activity_left_margin);
                this.a.setLayoutParams(layoutParams);
                requestLayout();
            }
            obtainStyledAttributes.recycle();
        }
    }

    public ImageButton a(int i, View.OnClickListener onClickListener, int i2) {
        ImageButton imageButton = new ImageButton(this.c, null, R.attr.actionbarRightItemStyle);
        imageButton.setLayoutParams(new ViewGroup.LayoutParams((int) this.c.getResources().getDimension(R.dimen.actionbar_right_button_width), -1));
        imageButton.setImageResource(i);
        imageButton.setScaleType(ImageView.ScaleType.CENTER);
        imageButton.setContentDescription(this.c.getString(R.string.common_hint));
        imageButton.setOnClickListener(onClickListener);
        this.d.addView(imageButton, i2);
        requestLayout();
        this.f++;
        return imageButton;
    }

    public ImageButton a(int i, View.OnClickListener onClickListener) {
        return a(i, onClickListener, -1);
    }

    public void setEditChangeListener(TextWatcher textWatcher) {
        this.e.addTextChangedListener(textWatcher);
    }

    public void setEditMode(boolean z) {
        InputMethodManager inputMethodManager = (InputMethodManager) this.c.getSystemService("input_method");
        if (z) {
            this.e.setVisibility(0);
            this.b.setVisibility(8);
            this.e.requestFocus();
            inputMethodManager.toggleSoftInput(2, 0);
            return;
        }
        this.e.setVisibility(8);
        this.b.setVisibility(0);
        this.e.clearFocus();
        inputMethodManager.hideSoftInputFromWindow(this.e.getWindowToken(), 0);
    }
}
