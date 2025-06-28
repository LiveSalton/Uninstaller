package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzdmu;
import com.google.android.gms.internal.ads.zzdvd;
import com.google.android.gms.internal.ads.zzdvx;
import com.google.android.gms.internal.ads.zzwq;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nonnull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbq {
    public static boolean a(int i) {
        if (((Boolean) zzwq.e().a(zzabf.bt)).booleanValue()) {
            return ((Boolean) zzwq.e().a(zzabf.bu)).booleanValue() || i <= 15299999;
        }
        return true;
    }

    public static JSONObject a(Context context, View view) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (view == null) {
            return jSONObject2;
        }
        try {
            int[] b = b(view);
            int[] iArr = new int[2];
            if (view != null) {
                iArr[0] = view.getMeasuredWidth();
                iArr[1] = view.getMeasuredHeight();
                for (ViewParent parent = view.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    iArr[0] = Math.min(((ViewGroup) parent).getMeasuredWidth(), iArr[0]);
                    iArr[1] = Math.min(((ViewGroup) parent).getMeasuredHeight(), iArr[1]);
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("width", a(context, view.getMeasuredWidth()));
            jSONObject3.put("height", a(context, view.getMeasuredHeight()));
            jSONObject3.put("x", a(context, b[0]));
            jSONObject3.put("y", a(context, b[1]));
            jSONObject3.put("maximum_visible_width", a(context, iArr[0]));
            jSONObject3.put("maximum_visible_height", a(context, iArr[1]));
            jSONObject3.put("relative_to", "window");
            jSONObject2.put("frame", jSONObject3);
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                jSONObject = a(context, rect);
            } else {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("width", 0);
                jSONObject4.put("height", 0);
                jSONObject4.put("x", a(context, b[0]));
                jSONObject4.put("y", a(context, b[1]));
                jSONObject4.put("relative_to", "window");
                jSONObject = jSONObject4;
            }
            jSONObject2.put("visible_bounds", jSONObject);
        } catch (Exception unused) {
            zzd.e("Unable to get native ad view bounding box");
        }
        if (((Boolean) zzwq.e().a(zzabf.du)).booleanValue()) {
            String str = "";
            ViewParent parent2 = view.getParent();
            if (parent2 != null) {
                try {
                    str = (String) parent2.getClass().getMethod("getTemplateTypeName", new Class[0]).invoke(parent2, new Object[0]);
                } catch (IllegalAccessException | SecurityException | InvocationTargetException e) {
                    zzd.c("Cannot access method getTemplateTypeName: ", e);
                } catch (NoSuchMethodException unused2) {
                }
            }
            char c = 65535;
            try {
                int hashCode = str.hashCode();
                if (hashCode != -2066603854) {
                    if (hashCode == 2019754500 && str.equals("medium_template")) {
                        c = 1;
                    }
                } else if (str.equals("small_template")) {
                    c = 0;
                }
                switch (c) {
                    case 0:
                        jSONObject2.put("native_template_type", 1);
                        break;
                    case 1:
                        jSONObject2.put("native_template_type", 2);
                        break;
                    default:
                        jSONObject2.put("native_template_type", 0);
                        break;
                }
            } catch (JSONException e2) {
                zzd.c("Could not log native template signal to JSON", e2);
            }
        }
        return jSONObject2;
    }

    public static JSONObject a(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            if (((Boolean) zzwq.e().a(zzabf.ee)).booleanValue()) {
                zzp.c();
                jSONObject.put("contained_in_scroll_view", zzm.e(view));
            } else {
                zzp.c();
                jSONObject.put("contained_in_scroll_view", zzm.d(view) != -1);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject b(Context context, View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            zzp.c();
            jSONObject.put("can_show_on_lock_screen", zzm.c(view));
            zzp.c();
            jSONObject.put("is_keyguard_locked", zzm.i(context));
        } catch (JSONException unused) {
            zzd.e("Unable to get lock screen information");
        }
        return jSONObject;
    }

    public static JSONObject a(Context context, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View view) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (map == null || view == null) {
            return jSONObject2;
        }
        int[] b = b(view);
        for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
            View view2 = entry.getValue().get();
            if (view2 != null) {
                int[] b2 = b(view2);
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put("width", a(context, view2.getMeasuredWidth()));
                    jSONObject4.put("height", a(context, view2.getMeasuredHeight()));
                    boolean z = false;
                    jSONObject4.put("x", a(context, b2[0] - b[0]));
                    jSONObject4.put("y", a(context, b2[1] - b[1]));
                    jSONObject4.put("relative_to", "ad_view");
                    jSONObject3.put("frame", jSONObject4);
                    Rect rect = new Rect();
                    if (view2.getLocalVisibleRect(rect)) {
                        jSONObject = a(context, rect);
                    } else {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("width", 0);
                        jSONObject5.put("height", 0);
                        jSONObject5.put("x", a(context, b2[0] - b[0]));
                        jSONObject5.put("y", a(context, b2[1] - b[1]));
                        jSONObject5.put("relative_to", "ad_view");
                        jSONObject = jSONObject5;
                    }
                    jSONObject3.put("visible_bounds", jSONObject);
                    if (view2 instanceof TextView) {
                        TextView textView = (TextView) view2;
                        jSONObject3.put("text_color", textView.getCurrentTextColor());
                        jSONObject3.put("font_size", textView.getTextSize());
                        jSONObject3.put("text", textView.getText());
                    }
                    if (map2 != null && map2.containsKey(entry.getKey()) && view2.isClickable()) {
                        z = true;
                    }
                    jSONObject3.put("is_clickable", z);
                    jSONObject2.put(entry.getKey(), jSONObject3);
                } catch (JSONException unused) {
                    zzd.e("Unable to get asset views information");
                }
            }
        }
        return jSONObject2;
    }

    public static JSONObject a(String str, Context context, Point point, Point point2) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("click_point", a(context, point, point2));
                jSONObject.put("asset_id", str);
            } catch (Exception e) {
                e = e;
                zzd.c("Error occurred while grabbing click signals.", e);
                return jSONObject;
            }
        } catch (Exception e2) {
            e = e2;
            jSONObject = null;
        }
        return jSONObject;
    }

    private static int[] b(View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    public static Point a(MotionEvent motionEvent, View view) {
        int[] b = b(view);
        return new Point(((int) motionEvent.getRawX()) - b[0], ((int) motionEvent.getRawY()) - b[1]);
    }

    private static JSONObject a(Context context, Point point, Point point2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", a(context, point2.x));
            jSONObject.put("y", a(context, point2.y));
            jSONObject.put("start_x", a(context, point.x));
            jSONObject.put("start_y", a(context, point.y));
            return jSONObject;
        } catch (JSONException e) {
            zzd.c("Error occurred while putting signals into JSON object.", e);
            return null;
        }
    }

    public static boolean a(Context context, zzdmu zzdmuVar) {
        if (!zzdmuVar.I) {
            return false;
        }
        if (((Boolean) zzwq.e().a(zzabf.ef)).booleanValue()) {
            return ((Boolean) zzwq.e().a(zzabf.ei)).booleanValue();
        }
        String str = (String) zzwq.e().a(zzabf.eg);
        if (str.isEmpty() || context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        Iterator<String> it = zzdvx.a(zzdvd.a(';')).a(str).iterator();
        while (it.hasNext()) {
            if (it.next().equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    public static JSONObject a(@Nonnull Context context) {
        JSONObject jSONObject = new JSONObject();
        zzp.c();
        DisplayMetrics a = zzm.a((WindowManager) context.getSystemService("window"));
        try {
            jSONObject.put("width", a(context, a.widthPixels));
            jSONObject.put("height", a(context, a.heightPixels));
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static WindowManager.LayoutParams a() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 0, 0, -2);
        layoutParams.flags = ((Integer) zzwq.e().a(zzabf.eh)).intValue();
        layoutParams.type = 2;
        layoutParams.gravity = 8388659;
        return layoutParams;
    }

    private static int a(Context context, int i) {
        return zzwq.a().b(context, i);
    }

    private static JSONObject a(Context context, Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", a(context, rect.right - rect.left));
        jSONObject.put("height", a(context, rect.bottom - rect.top));
        jSONObject.put("x", a(context, rect.left));
        jSONObject.put("y", a(context, rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }
}
