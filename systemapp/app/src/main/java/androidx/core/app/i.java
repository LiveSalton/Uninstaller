package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.h;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
class i implements g {
    private final Notification.Builder a;
    private final h.c b;
    private RemoteViews c;
    private RemoteViews d;
    private final List<Bundle> e = new ArrayList();
    private final Bundle f = new Bundle();
    private int g;
    private RemoteViews h;

    i(h.c cVar) {
        this.b = cVar;
        if (Build.VERSION.SDK_INT >= 26) {
            this.a = new Notification.Builder(cVar.a, cVar.I);
        } else {
            this.a = new Notification.Builder(cVar.a);
        }
        Notification notification = cVar.P;
        this.a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, cVar.h).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(cVar.d).setContentText(cVar.e).setContentInfo(cVar.j).setContentIntent(cVar.f).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(cVar.g, (notification.flags & 128) != 0).setLargeIcon(cVar.i).setNumber(cVar.k).setProgress(cVar.r, cVar.s, cVar.t);
        if (Build.VERSION.SDK_INT < 21) {
            this.a.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.a.setSubText(cVar.p).setUsesChronometer(cVar.n).setPriority(cVar.l);
            Iterator<h.a> it = cVar.b.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            if (cVar.B != null) {
                this.f.putAll(cVar.B);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (cVar.x) {
                    this.f.putBoolean("android.support.localOnly", true);
                }
                if (cVar.u != null) {
                    this.f.putString("android.support.groupKey", cVar.u);
                    if (cVar.v) {
                        this.f.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f.putBoolean("android.support.useSideChannel", true);
                    }
                }
                if (cVar.w != null) {
                    this.f.putString("android.support.sortKey", cVar.w);
                }
            }
            this.c = cVar.F;
            this.d = cVar.G;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.a.setShowWhen(cVar.m);
            if (Build.VERSION.SDK_INT < 21 && cVar.R != null && !cVar.R.isEmpty()) {
                this.f.putStringArray("android.people", (String[]) cVar.R.toArray(new String[cVar.R.size()]));
            }
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.a.setLocalOnly(cVar.x).setGroup(cVar.u).setGroupSummary(cVar.v).setSortKey(cVar.w);
            this.g = cVar.M;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.a.setCategory(cVar.A).setColor(cVar.C).setVisibility(cVar.D).setPublicVersion(cVar.E).setSound(notification.sound, notification.audioAttributes);
            Iterator<String> it2 = cVar.R.iterator();
            while (it2.hasNext()) {
                this.a.addPerson(it2.next());
            }
            this.h = cVar.H;
            if (cVar.c.size() > 0) {
                Bundle bundle = cVar.a().getBundle("android.car.EXTENSIONS");
                bundle = bundle == null ? new Bundle() : bundle;
                Bundle bundle2 = new Bundle();
                for (int i = 0; i < cVar.c.size(); i++) {
                    bundle2.putBundle(Integer.toString(i), j.a(cVar.c.get(i)));
                }
                bundle.putBundle("invisible_actions", bundle2);
                cVar.a().putBundle("android.car.EXTENSIONS", bundle);
                this.f.putBundle("android.car.EXTENSIONS", bundle);
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.a.setExtras(cVar.B).setRemoteInputHistory(cVar.q);
            if (cVar.F != null) {
                this.a.setCustomContentView(cVar.F);
            }
            if (cVar.G != null) {
                this.a.setCustomBigContentView(cVar.G);
            }
            if (cVar.H != null) {
                this.a.setCustomHeadsUpContentView(cVar.H);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.a.setBadgeIconType(cVar.J).setShortcutId(cVar.K).setTimeoutAfter(cVar.L).setGroupAlertBehavior(cVar.M);
            if (cVar.z) {
                this.a.setColorized(cVar.y);
            }
            if (!TextUtils.isEmpty(cVar.I)) {
                this.a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.a.setAllowSystemGeneratedContextualActions(cVar.N);
            this.a.setBubbleMetadata(h.b.a(cVar.O));
        }
        if (cVar.Q) {
            if (this.b.v) {
                this.g = 2;
            } else {
                this.g = 1;
            }
            this.a.setVibrate(null);
            this.a.setSound(null);
            notification.defaults &= -2;
            notification.defaults &= -3;
            this.a.setDefaults(notification.defaults);
            if (Build.VERSION.SDK_INT >= 26) {
                if (TextUtils.isEmpty(this.b.u)) {
                    this.a.setGroup("silent");
                }
                this.a.setGroupAlertBehavior(this.g);
            }
        }
    }

    public Notification a() {
        Bundle a;
        RemoteViews d;
        RemoteViews c;
        h.d dVar = this.b.o;
        if (dVar != null) {
            dVar.a(this);
        }
        RemoteViews b = dVar != null ? dVar.b(this) : null;
        Notification b2 = b();
        if (b != null) {
            b2.contentView = b;
        } else if (this.b.F != null) {
            b2.contentView = this.b.F;
        }
        if (Build.VERSION.SDK_INT >= 16 && dVar != null && (c = dVar.c(this)) != null) {
            b2.bigContentView = c;
        }
        if (Build.VERSION.SDK_INT >= 21 && dVar != null && (d = this.b.o.d(this)) != null) {
            b2.headsUpContentView = d;
        }
        if (Build.VERSION.SDK_INT >= 16 && dVar != null && (a = h.a(b2)) != null) {
            dVar.a(a);
        }
        return b2;
    }

    private void a(h.a aVar) {
        Notification.Action.Builder builder;
        Bundle bundle;
        if (Build.VERSION.SDK_INT >= 20) {
            IconCompat a = aVar.a();
            if (Build.VERSION.SDK_INT >= 23) {
                builder = new Notification.Action.Builder(a != null ? a.d() : null, aVar.b(), aVar.c());
            } else {
                builder = new Notification.Action.Builder(a != null ? a.b() : 0, aVar.b(), aVar.c());
            }
            if (aVar.f() != null) {
                for (RemoteInput remoteInput : l.a(aVar.f())) {
                    builder.addRemoteInput(remoteInput);
                }
            }
            if (aVar.d() != null) {
                bundle = new Bundle(aVar.d());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.e());
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(aVar.e());
            }
            bundle.putInt("android.support.action.semanticAction", aVar.g());
            if (Build.VERSION.SDK_INT >= 28) {
                builder.setSemanticAction(aVar.g());
            }
            if (Build.VERSION.SDK_INT >= 29) {
                builder.setContextual(aVar.h());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.j());
            builder.addExtras(bundle);
            this.a.addAction(builder.build());
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.e.add(j.a(this.a, aVar));
        }
    }

    protected Notification b() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.a.build();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Notification build = this.a.build();
            if (this.g != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && this.g == 2) {
                    a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.g == 1) {
                    a(build);
                }
            }
            return build;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.a.setExtras(this.f);
            Notification build2 = this.a.build();
            if (this.c != null) {
                build2.contentView = this.c;
            }
            if (this.d != null) {
                build2.bigContentView = this.d;
            }
            if (this.h != null) {
                build2.headsUpContentView = this.h;
            }
            if (this.g != 0) {
                if (build2.getGroup() != null && (build2.flags & 512) != 0 && this.g == 2) {
                    a(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.g == 1) {
                    a(build2);
                }
            }
            return build2;
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.a.setExtras(this.f);
            Notification build3 = this.a.build();
            if (this.c != null) {
                build3.contentView = this.c;
            }
            if (this.d != null) {
                build3.bigContentView = this.d;
            }
            if (this.g != 0) {
                if (build3.getGroup() != null && (build3.flags & 512) != 0 && this.g == 2) {
                    a(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.g == 1) {
                    a(build3);
                }
            }
            return build3;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            SparseArray<Bundle> a = j.a(this.e);
            if (a != null) {
                this.f.putSparseParcelableArray("android.support.actionExtras", a);
            }
            this.a.setExtras(this.f);
            Notification build4 = this.a.build();
            if (this.c != null) {
                build4.contentView = this.c;
            }
            if (this.d != null) {
                build4.bigContentView = this.d;
            }
            return build4;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            Notification build5 = this.a.build();
            Bundle a2 = h.a(build5);
            Bundle bundle = new Bundle(this.f);
            for (String str : this.f.keySet()) {
                if (a2.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a2.putAll(bundle);
            SparseArray<Bundle> a3 = j.a(this.e);
            if (a3 != null) {
                h.a(build5).putSparseParcelableArray("android.support.actionExtras", a3);
            }
            if (this.c != null) {
                build5.contentView = this.c;
            }
            if (this.d != null) {
                build5.bigContentView = this.d;
            }
            return build5;
        }
        return this.a.getNotification();
    }

    private void a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
