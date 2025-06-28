package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbfk extends MutableContextWrapper {
    private Activity a;
    private Context b;
    private Context c;

    public zzbfk(Context context) {
        super(context);
        setBaseContext(context);
    }

    @Override // android.content.MutableContextWrapper
    public final void setBaseContext(Context context) {
        this.b = context.getApplicationContext();
        this.a = context instanceof Activity ? (Activity) context : null;
        this.c = context;
        super.setBaseContext(this.b);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void startActivity(Intent intent) {
        if (this.a != null) {
            this.a.startActivity(intent);
        } else {
            intent.setFlags(268435456);
            this.b.startActivity(intent);
        }
    }

    public final Activity a() {
        return this.a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return this.c.getSystemService(str);
    }

    public final Context b() {
        return this.c;
    }
}
