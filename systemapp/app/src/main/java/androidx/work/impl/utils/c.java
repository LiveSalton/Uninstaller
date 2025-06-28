package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: source */
/* loaded from: classes.dex */
public class c {
    private final Context a;
    private SharedPreferences b;
    private boolean c;

    public c(Context context) {
        this.a = context;
    }

    public int a(int i, int i2) {
        synchronized (c.class) {
            b();
            int a = a("next_job_scheduler_id");
            if (a >= i && a <= i2) {
                i = a;
            }
            a("next_job_scheduler_id", i + 1);
        }
        return i;
    }

    public int a() {
        int a;
        synchronized (c.class) {
            b();
            a = a("next_alarm_manager_id");
        }
        return a;
    }

    private int a(String str) {
        int i = this.b.getInt(str, 0);
        a(str, i != Integer.MAX_VALUE ? i + 1 : 0);
        return i;
    }

    private void a(String str, int i) {
        this.b.edit().putInt(str, i).apply();
    }

    private void b() {
        if (this.c) {
            return;
        }
        this.b = this.a.getSharedPreferences("androidx.work.util.id", 0);
        this.c = true;
    }
}
