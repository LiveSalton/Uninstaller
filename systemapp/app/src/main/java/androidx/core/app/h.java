package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public class h {

    /* compiled from: source */
    public static abstract class d {
        public void a(Bundle bundle) {
        }

        public void a(g gVar) {
        }

        public RemoteViews b(g gVar) {
            return null;
        }

        public RemoteViews c(g gVar) {
            return null;
        }

        public RemoteViews d(g gVar) {
            return null;
        }
    }

    /* compiled from: source */
    public static class c {
        String A;
        Bundle B;
        int C;
        int D;
        Notification E;
        RemoteViews F;
        RemoteViews G;
        RemoteViews H;
        String I;
        int J;
        String K;
        long L;
        int M;
        boolean N;
        b O;
        Notification P;
        boolean Q;

        @Deprecated
        public ArrayList<String> R;
        public Context a;
        public ArrayList<a> b;
        ArrayList<a> c;
        CharSequence d;
        CharSequence e;
        PendingIntent f;
        PendingIntent g;
        RemoteViews h;
        Bitmap i;
        CharSequence j;
        int k;
        int l;
        boolean m;
        boolean n;
        d o;
        CharSequence p;
        CharSequence[] q;
        int r;
        int s;
        boolean t;
        String u;
        boolean v;
        String w;
        boolean x;
        boolean y;
        boolean z;

        public c(Context context, String str) {
            this.b = new ArrayList<>();
            this.c = new ArrayList<>();
            this.m = true;
            this.x = false;
            this.C = 0;
            this.D = 0;
            this.J = 0;
            this.M = 0;
            this.P = new Notification();
            this.a = context;
            this.I = str;
            this.P.when = System.currentTimeMillis();
            this.P.audioStreamType = -1;
            this.l = 0;
            this.R = new ArrayList<>();
            this.N = true;
        }

        @Deprecated
        public c(Context context) {
            this(context, null);
        }

        public c a(long j) {
            this.P.when = j;
            return this;
        }

        public c a(int i) {
            this.P.icon = i;
            return this;
        }

        public c a(CharSequence charSequence) {
            this.d = d(charSequence);
            return this;
        }

        public c b(CharSequence charSequence) {
            this.e = d(charSequence);
            return this;
        }

        public c c(CharSequence charSequence) {
            this.j = d(charSequence);
            return this;
        }

        public c a(int i, int i2, boolean z) {
            this.r = i;
            this.s = i2;
            this.t = z;
            return this;
        }

        public c a(PendingIntent pendingIntent) {
            this.f = pendingIntent;
            return this;
        }

        public c b(PendingIntent pendingIntent) {
            this.P.deleteIntent = pendingIntent;
            return this;
        }

        public c a(boolean z) {
            a(16, z);
            return this;
        }

        private void a(int i, boolean z) {
            if (z) {
                Notification notification = this.P;
                notification.flags = i | notification.flags;
            } else {
                Notification notification2 = this.P;
                notification2.flags = (~i) & notification2.flags;
            }
        }

        public Bundle a() {
            if (this.B == null) {
                this.B = new Bundle();
            }
            return this.B;
        }

        public Notification b() {
            return new i(this).a();
        }

        protected static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }
    }

    /* compiled from: source */
    public static class a {
        final Bundle a;
        boolean b;

        @Deprecated
        public int c;
        public CharSequence d;
        public PendingIntent e;
        private IconCompat f;
        private final l[] g;
        private final l[] h;
        private boolean i;
        private final int j;
        private final boolean k;

        public IconCompat a() {
            if (this.f == null && this.c != 0) {
                this.f = IconCompat.a(null, "", this.c);
            }
            return this.f;
        }

        public CharSequence b() {
            return this.d;
        }

        public PendingIntent c() {
            return this.e;
        }

        public Bundle d() {
            return this.a;
        }

        public boolean e() {
            return this.i;
        }

        public l[] f() {
            return this.g;
        }

        public int g() {
            return this.j;
        }

        public boolean h() {
            return this.k;
        }

        public l[] i() {
            return this.h;
        }

        public boolean j() {
            return this.b;
        }
    }

    /* compiled from: source */
    public static final class b {
        private PendingIntent a;
        private PendingIntent b;
        private IconCompat c;
        private int d;
        private int e;
        private int f;

        public PendingIntent a() {
            return this.a;
        }

        public PendingIntent b() {
            return this.b;
        }

        public IconCompat c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }

        public boolean f() {
            return (this.f & 1) != 0;
        }

        public boolean g() {
            return (this.f & 2) != 0;
        }

        public static Notification.BubbleMetadata a(b bVar) {
            if (bVar == null) {
                return null;
            }
            Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setAutoExpandBubble(bVar.f()).setDeleteIntent(bVar.b()).setIcon(bVar.c().d()).setIntent(bVar.a()).setSuppressNotification(bVar.g());
            if (bVar.d() != 0) {
                suppressNotification.setDesiredHeight(bVar.d());
            }
            if (bVar.e() != 0) {
                suppressNotification.setDesiredHeightResId(bVar.e());
            }
            return suppressNotification.build();
        }
    }

    public static Bundle a(Notification notification) {
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return j.a(notification);
        }
        return null;
    }
}
