package com.jumobile.manager.systemapp.b;

import android.content.ComponentName;
import android.content.Context;
import com.jumobile.manager.systemapp.R;
import com.jumobile.manager.systemapp.util.f;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public class a {
    private static final String a = "a";

    public static int a(Context context, ArrayList<String> arrayList, long j) {
        return b.a(context, R.raw.appmgr, "resource.jar", 4L, "com.jumobile.commands.appmgr.AppMgr", arrayList, j);
    }

    public static int a(Context context, String str) {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add("movePackage");
        arrayList.add(str);
        arrayList.add("external");
        return a(context, arrayList, 300000L);
    }

    public static int b(Context context, String str) {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add("movePackage");
        arrayList.add(str);
        arrayList.add("internal");
        return a(context, arrayList, 300000L);
    }

    public static int c(Context context, String str) {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add("clearData");
        arrayList.add(str);
        return a(context, arrayList, 5000L);
    }

    public static int d(Context context, String str) {
        ArrayList<ComponentName> k = f.k(context, str);
        int i = 0;
        if (k != null && k.size() > 0) {
            for (ComponentName componentName : k) {
                if (componentName.getPackageName().equals(str)) {
                    ArrayList arrayList = new ArrayList(5);
                    arrayList.add("removeActiveAdmin");
                    arrayList.add(str);
                    arrayList.add(componentName.getClassName());
                    if (a(context, arrayList, 3000L) != 0) {
                        i = -1;
                    }
                }
            }
        }
        return i;
    }
}
