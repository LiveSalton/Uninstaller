package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import androidx.appcompat.a;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.ac;
import androidx.core.h.w;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: source */
/* loaded from: classes.dex */
public class e {
    private static final Class<?>[] a = {Context.class, AttributeSet.class};
    private static final int[] b = {R.attr.onClick};
    private static final String[] c = {"android.widget.", "android.view.", "android.webkit."};
    private static final androidx.b.g<String, Constructor<? extends View>> d = new androidx.b.g<>();
    private final Object[] e = new Object[2];

    protected View a(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    final View a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        Context context2;
        View a2;
        context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = a(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = ac.a(context2);
        }
        switch (str) {
            case "TextView":
                a2 = a(context2, attributeSet);
                a(a2, str);
                break;
            case "ImageView":
                a2 = b(context2, attributeSet);
                a(a2, str);
                break;
            case "Button":
                a2 = c(context2, attributeSet);
                a(a2, str);
                break;
            case "EditText":
                a2 = d(context2, attributeSet);
                a(a2, str);
                break;
            case "Spinner":
                a2 = e(context2, attributeSet);
                a(a2, str);
                break;
            case "ImageButton":
                a2 = f(context2, attributeSet);
                a(a2, str);
                break;
            case "CheckBox":
                a2 = g(context2, attributeSet);
                a(a2, str);
                break;
            case "RadioButton":
                a2 = h(context2, attributeSet);
                a(a2, str);
                break;
            case "CheckedTextView":
                a2 = i(context2, attributeSet);
                a(a2, str);
                break;
            case "AutoCompleteTextView":
                a2 = j(context2, attributeSet);
                a(a2, str);
                break;
            case "MultiAutoCompleteTextView":
                a2 = k(context2, attributeSet);
                a(a2, str);
                break;
            case "RatingBar":
                a2 = l(context2, attributeSet);
                a(a2, str);
                break;
            case "SeekBar":
                a2 = m(context2, attributeSet);
                a(a2, str);
                break;
            case "ToggleButton":
                a2 = n(context2, attributeSet);
                a(a2, str);
                break;
            default:
                a2 = a(context2, str, attributeSet);
                break;
        }
        if (a2 == null && context != context2) {
            a2 = b(context2, str, attributeSet);
        }
        if (a2 != null) {
            a(a2, attributeSet);
        }
        return a2;
    }

    protected AppCompatTextView a(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    protected AppCompatImageView b(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    protected AppCompatButton c(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    protected AppCompatEditText d(Context context, AttributeSet attributeSet) {
        return new AppCompatEditText(context, attributeSet);
    }

    protected AppCompatSpinner e(Context context, AttributeSet attributeSet) {
        return new AppCompatSpinner(context, attributeSet);
    }

    protected AppCompatImageButton f(Context context, AttributeSet attributeSet) {
        return new AppCompatImageButton(context, attributeSet);
    }

    protected AppCompatCheckBox g(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    protected AppCompatRadioButton h(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    protected AppCompatCheckedTextView i(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckedTextView(context, attributeSet);
    }

    protected AppCompatAutoCompleteTextView j(Context context, AttributeSet attributeSet) {
        return new AppCompatAutoCompleteTextView(context, attributeSet);
    }

    protected AppCompatMultiAutoCompleteTextView k(Context context, AttributeSet attributeSet) {
        return new AppCompatMultiAutoCompleteTextView(context, attributeSet);
    }

    protected AppCompatRatingBar l(Context context, AttributeSet attributeSet) {
        return new AppCompatRatingBar(context, attributeSet);
    }

    protected AppCompatSeekBar m(Context context, AttributeSet attributeSet) {
        return new AppCompatSeekBar(context, attributeSet);
    }

    protected AppCompatToggleButton n(Context context, AttributeSet attributeSet) {
        return new AppCompatToggleButton(context, attributeSet);
    }

    private void a(View view, String str) {
        if (view == null) {
            throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
        }
    }

    private View b(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.e[0] = context;
            this.e[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return a(context, str, (String) null);
            }
            for (int i = 0; i < c.length; i++) {
                View a2 = a(context, str, c[i]);
                if (a2 != null) {
                    return a2;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        } finally {
            this.e[0] = null;
            this.e[1] = null;
        }
    }

    private void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (Build.VERSION.SDK_INT < 15 || w.G(view)) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b);
                String string = obtainStyledAttributes.getString(0);
                if (string != null) {
                    view.setOnClickListener(new a(view, string));
                }
                obtainStyledAttributes.recycle();
            }
        }
    }

    private View a(Context context, String str, String str2) throws ClassNotFoundException, InflateException {
        String str3;
        Constructor<? extends View> constructor = d.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(a);
            d.put(str, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.e);
    }

    private static Context a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.View, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(a.j.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(a.j.View_theme, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? ((context instanceof androidx.appcompat.view.d) && ((androidx.appcompat.view.d) context).a() == resourceId) ? context : new androidx.appcompat.view.d(context, resourceId) : context;
    }

    /* compiled from: source */
    private static class a implements View.OnClickListener {
        private final View a;
        private final String b;
        private Method c;
        private Context d;

        public a(View view, String str) {
            this.a = view;
            this.b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.c == null) {
                a(this.a.getContext());
            }
            try {
                this.c.invoke(this.d, view);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }

        private void a(Context context) {
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.b, View.class)) != null) {
                        this.c = method;
                        this.d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.a.getId();
            if (id == -1) {
                str = "";
            } else {
                str = " with id '" + this.a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.a.getClass() + str);
        }
    }
}
