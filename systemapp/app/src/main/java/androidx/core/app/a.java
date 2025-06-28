package androidx.core.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

/* compiled from: source */
/* loaded from: classes.dex */
public class a extends androidx.core.content.a {
    private static b a;

    /* compiled from: source */
    /* renamed from: androidx.core.app.a$a */
    public interface InterfaceC0017a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* compiled from: source */
    public interface b {
        boolean a(Activity activity, int i, int i2, Intent intent);

        boolean a(Activity activity, String[] strArr, int i);
    }

    /* compiled from: source */
    public interface c {
        void b(int i);
    }

    public static b a() {
        return a;
    }

    public static void a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Activity activity, String[] strArr, int i) {
        if (a == null || !a.a(activity, strArr, i)) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof c) {
                    ((c) activity).b(i);
                }
                activity.requestPermissions(strArr, i);
            } else if (activity instanceof InterfaceC0017a) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.core.app.a.1
                    final /* synthetic */ String[] a;
                    final /* synthetic */ Activity b;
                    final /* synthetic */ int c;

                    AnonymousClass1(String[] strArr2, Activity activity2, int i2) {
                        strArr = strArr2;
                        activity = activity2;
                        i = i2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        int[] iArr = new int[strArr.length];
                        PackageManager packageManager = activity.getPackageManager();
                        String packageName = activity.getPackageName();
                        int length = strArr.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            iArr[i2] = packageManager.checkPermission(strArr[i2], packageName);
                        }
                        ((InterfaceC0017a) activity).onRequestPermissionsResult(i, strArr, iArr);
                    }
                });
            }
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.core.app.a$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String[] a;
        final /* synthetic */ Activity b;
        final /* synthetic */ int c;

        AnonymousClass1(String[] strArr2, Activity activity2, int i2) {
            strArr = strArr2;
            activity = activity2;
            i = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[strArr.length];
            PackageManager packageManager = activity.getPackageManager();
            String packageName = activity.getPackageName();
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = packageManager.checkPermission(strArr[i2], packageName);
            }
            ((InterfaceC0017a) activity).onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            if (androidx.core.app.c.a(activity)) {
                return;
            }
            activity.recreate();
        }
    }
}
