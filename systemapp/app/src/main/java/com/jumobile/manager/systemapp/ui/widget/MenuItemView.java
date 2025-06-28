package com.jumobile.manager.systemapp.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jumobile.manager.systemapp.R;

/* compiled from: source */
/* loaded from: classes.dex */
public class MenuItemView extends LinearLayout {
    private TextView a;

    public void setText(CharSequence charSequence) {
        this.a.setText(charSequence);
    }

    public MenuItemView(Context context) {
        super(context);
        a(context, null);
    }

    public MenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        inflate(context, R.layout.view_menu_item, this);
        setClickable(true);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.menu_item);
            String string = obtainStyledAttributes.getString(1);
            this.a = (TextView) findViewById(R.id.text);
            this.a.setText(string);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            ImageView imageView = (ImageView) findViewById(R.id.icon);
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            }
            obtainStyledAttributes.recycle();
        }
    }
}
