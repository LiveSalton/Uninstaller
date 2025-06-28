package androidx.work.impl.b;

import android.database.Cursor;
import androidx.work.impl.b.j;
import androidx.work.n;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class l implements k {
    private final androidx.room.i a;
    private final androidx.room.b b;
    private final androidx.room.m c;
    private final androidx.room.m d;
    private final androidx.room.m e;
    private final androidx.room.m f;
    private final androidx.room.m g;
    private final androidx.room.m h;
    private final androidx.room.m i;
    private final androidx.room.m j;

    public l(androidx.room.i iVar) {
        this.a = iVar;
        this.b = new androidx.room.b<j>(iVar) { // from class: androidx.work.impl.b.l.1
            @Override // androidx.room.m
            public String a() {
                return "INSERT OR IGNORE INTO `WorkSpec`(`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            AnonymousClass1(androidx.room.i iVar2) {
                super(iVar2);
            }

            @Override // androidx.room.b
            public void a(androidx.g.a.f fVar, j jVar) {
                if (jVar.a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, jVar.a);
                }
                fVar.a(2, p.a(jVar.b));
                if (jVar.c == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, jVar.c);
                }
                if (jVar.d == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, jVar.d);
                }
                byte[] a = androidx.work.e.a(jVar.e);
                if (a == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, a);
                }
                byte[] a2 = androidx.work.e.a(jVar.f);
                if (a2 == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, a2);
                }
                fVar.a(7, jVar.g);
                fVar.a(8, jVar.h);
                fVar.a(9, jVar.i);
                fVar.a(10, jVar.k);
                fVar.a(11, p.a(jVar.l));
                fVar.a(12, jVar.m);
                fVar.a(13, jVar.n);
                fVar.a(14, jVar.o);
                fVar.a(15, jVar.p);
                androidx.work.c cVar = jVar.j;
                if (cVar != null) {
                    fVar.a(16, p.a(cVar.a()));
                    fVar.a(17, cVar.b() ? 1L : 0L);
                    fVar.a(18, cVar.c() ? 1L : 0L);
                    fVar.a(19, cVar.d() ? 1L : 0L);
                    fVar.a(20, cVar.e() ? 1L : 0L);
                    fVar.a(21, cVar.f());
                    fVar.a(22, cVar.g());
                    byte[] a3 = p.a(cVar.h());
                    if (a3 == null) {
                        fVar.a(23);
                        return;
                    } else {
                        fVar.a(23, a3);
                        return;
                    }
                }
                fVar.a(16);
                fVar.a(17);
                fVar.a(18);
                fVar.a(19);
                fVar.a(20);
                fVar.a(21);
                fVar.a(22);
                fVar.a(23);
            }
        };
        this.c = new androidx.room.m(iVar2) { // from class: androidx.work.impl.b.l.2
            @Override // androidx.room.m
            public String a() {
                return "DELETE FROM workspec WHERE id=?";
            }

            AnonymousClass2(androidx.room.i iVar2) {
                super(iVar2);
            }
        };
        this.d = new androidx.room.m(iVar2) { // from class: androidx.work.impl.b.l.3
            @Override // androidx.room.m
            public String a() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }

            AnonymousClass3(androidx.room.i iVar2) {
                super(iVar2);
            }
        };
        this.e = new androidx.room.m(iVar2) { // from class: androidx.work.impl.b.l.4
            @Override // androidx.room.m
            public String a() {
                return "UPDATE workspec SET period_start_time=? WHERE id=?";
            }

            AnonymousClass4(androidx.room.i iVar2) {
                super(iVar2);
            }
        };
        this.f = new androidx.room.m(iVar2) { // from class: androidx.work.impl.b.l.5
            @Override // androidx.room.m
            public String a() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }

            AnonymousClass5(androidx.room.i iVar2) {
                super(iVar2);
            }
        };
        this.g = new androidx.room.m(iVar2) { // from class: androidx.work.impl.b.l.6
            @Override // androidx.room.m
            public String a() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }

            AnonymousClass6(androidx.room.i iVar2) {
                super(iVar2);
            }
        };
        this.h = new androidx.room.m(iVar2) { // from class: androidx.work.impl.b.l.7
            @Override // androidx.room.m
            public String a() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }

            AnonymousClass7(androidx.room.i iVar2) {
                super(iVar2);
            }
        };
        this.i = new androidx.room.m(iVar2) { // from class: androidx.work.impl.b.l.8
            @Override // androidx.room.m
            public String a() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }

            AnonymousClass8(androidx.room.i iVar2) {
                super(iVar2);
            }
        };
        this.j = new androidx.room.m(iVar2) { // from class: androidx.work.impl.b.l.9
            @Override // androidx.room.m
            public String a() {
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            }

            AnonymousClass9(androidx.room.i iVar2) {
                super(iVar2);
            }
        };
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.b.l$1 */
    class AnonymousClass1 extends androidx.room.b<j> {
        @Override // androidx.room.m
        public String a() {
            return "INSERT OR IGNORE INTO `WorkSpec`(`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        AnonymousClass1(androidx.room.i iVar2) {
            super(iVar2);
        }

        @Override // androidx.room.b
        public void a(androidx.g.a.f fVar, j jVar) {
            if (jVar.a == null) {
                fVar.a(1);
            } else {
                fVar.a(1, jVar.a);
            }
            fVar.a(2, p.a(jVar.b));
            if (jVar.c == null) {
                fVar.a(3);
            } else {
                fVar.a(3, jVar.c);
            }
            if (jVar.d == null) {
                fVar.a(4);
            } else {
                fVar.a(4, jVar.d);
            }
            byte[] a = androidx.work.e.a(jVar.e);
            if (a == null) {
                fVar.a(5);
            } else {
                fVar.a(5, a);
            }
            byte[] a2 = androidx.work.e.a(jVar.f);
            if (a2 == null) {
                fVar.a(6);
            } else {
                fVar.a(6, a2);
            }
            fVar.a(7, jVar.g);
            fVar.a(8, jVar.h);
            fVar.a(9, jVar.i);
            fVar.a(10, jVar.k);
            fVar.a(11, p.a(jVar.l));
            fVar.a(12, jVar.m);
            fVar.a(13, jVar.n);
            fVar.a(14, jVar.o);
            fVar.a(15, jVar.p);
            androidx.work.c cVar = jVar.j;
            if (cVar != null) {
                fVar.a(16, p.a(cVar.a()));
                fVar.a(17, cVar.b() ? 1L : 0L);
                fVar.a(18, cVar.c() ? 1L : 0L);
                fVar.a(19, cVar.d() ? 1L : 0L);
                fVar.a(20, cVar.e() ? 1L : 0L);
                fVar.a(21, cVar.f());
                fVar.a(22, cVar.g());
                byte[] a3 = p.a(cVar.h());
                if (a3 == null) {
                    fVar.a(23);
                    return;
                } else {
                    fVar.a(23, a3);
                    return;
                }
            }
            fVar.a(16);
            fVar.a(17);
            fVar.a(18);
            fVar.a(19);
            fVar.a(20);
            fVar.a(21);
            fVar.a(22);
            fVar.a(23);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.b.l$2 */
    class AnonymousClass2 extends androidx.room.m {
        @Override // androidx.room.m
        public String a() {
            return "DELETE FROM workspec WHERE id=?";
        }

        AnonymousClass2(androidx.room.i iVar2) {
            super(iVar2);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.b.l$3 */
    class AnonymousClass3 extends androidx.room.m {
        @Override // androidx.room.m
        public String a() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }

        AnonymousClass3(androidx.room.i iVar2) {
            super(iVar2);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.b.l$4 */
    class AnonymousClass4 extends androidx.room.m {
        @Override // androidx.room.m
        public String a() {
            return "UPDATE workspec SET period_start_time=? WHERE id=?";
        }

        AnonymousClass4(androidx.room.i iVar2) {
            super(iVar2);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.b.l$5 */
    class AnonymousClass5 extends androidx.room.m {
        @Override // androidx.room.m
        public String a() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }

        AnonymousClass5(androidx.room.i iVar2) {
            super(iVar2);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.b.l$6 */
    class AnonymousClass6 extends androidx.room.m {
        @Override // androidx.room.m
        public String a() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }

        AnonymousClass6(androidx.room.i iVar2) {
            super(iVar2);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.b.l$7 */
    class AnonymousClass7 extends androidx.room.m {
        @Override // androidx.room.m
        public String a() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }

        AnonymousClass7(androidx.room.i iVar2) {
            super(iVar2);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.b.l$8 */
    class AnonymousClass8 extends androidx.room.m {
        @Override // androidx.room.m
        public String a() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }

        AnonymousClass8(androidx.room.i iVar2) {
            super(iVar2);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.b.l$9 */
    class AnonymousClass9 extends androidx.room.m {
        @Override // androidx.room.m
        public String a() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }

        AnonymousClass9(androidx.room.i iVar2) {
            super(iVar2);
        }
    }

    @Override // androidx.work.impl.b.k
    public void a(j jVar) {
        this.a.f();
        this.a.g();
        try {
            this.b.a((androidx.room.b) jVar);
            this.a.j();
        } finally {
            this.a.h();
        }
    }

    @Override // androidx.work.impl.b.k
    public void a(String str) {
        this.a.f();
        androidx.g.a.f c = this.c.c();
        if (str == null) {
            c.a(1);
        } else {
            c.a(1, str);
        }
        this.a.g();
        try {
            c.a();
            this.a.j();
        } finally {
            this.a.h();
            this.c.a(c);
        }
    }

    @Override // androidx.work.impl.b.k
    public void a(String str, androidx.work.e eVar) {
        this.a.f();
        androidx.g.a.f c = this.d.c();
        byte[] a = androidx.work.e.a(eVar);
        if (a == null) {
            c.a(1);
        } else {
            c.a(1, a);
        }
        if (str == null) {
            c.a(2);
        } else {
            c.a(2, str);
        }
        this.a.g();
        try {
            c.a();
            this.a.j();
        } finally {
            this.a.h();
            this.d.a(c);
        }
    }

    @Override // androidx.work.impl.b.k
    public void a(String str, long j) {
        this.a.f();
        androidx.g.a.f c = this.e.c();
        c.a(1, j);
        if (str == null) {
            c.a(2);
        } else {
            c.a(2, str);
        }
        this.a.g();
        try {
            c.a();
            this.a.j();
        } finally {
            this.a.h();
            this.e.a(c);
        }
    }

    @Override // androidx.work.impl.b.k
    public int d(String str) {
        this.a.f();
        androidx.g.a.f c = this.f.c();
        if (str == null) {
            c.a(1);
        } else {
            c.a(1, str);
        }
        this.a.g();
        try {
            int a = c.a();
            this.a.j();
            return a;
        } finally {
            this.a.h();
            this.f.a(c);
        }
    }

    @Override // androidx.work.impl.b.k
    public int e(String str) {
        this.a.f();
        androidx.g.a.f c = this.g.c();
        if (str == null) {
            c.a(1);
        } else {
            c.a(1, str);
        }
        this.a.g();
        try {
            int a = c.a();
            this.a.j();
            return a;
        } finally {
            this.a.h();
            this.g.a(c);
        }
    }

    @Override // androidx.work.impl.b.k
    public int b(String str, long j) {
        this.a.f();
        androidx.g.a.f c = this.h.c();
        c.a(1, j);
        if (str == null) {
            c.a(2);
        } else {
            c.a(2, str);
        }
        this.a.g();
        try {
            int a = c.a();
            this.a.j();
            return a;
        } finally {
            this.a.h();
            this.h.a(c);
        }
    }

    @Override // androidx.work.impl.b.k
    public int b() {
        this.a.f();
        androidx.g.a.f c = this.i.c();
        this.a.g();
        try {
            int a = c.a();
            this.a.j();
            return a;
        } finally {
            this.a.h();
            this.i.a(c);
        }
    }

    @Override // androidx.work.impl.b.k
    public j b(String str) {
        Throwable th;
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        int a12;
        int a13;
        j jVar;
        androidx.room.l a14 = androidx.room.l.a("SELECT * FROM workspec WHERE id=?", 1);
        if (str == null) {
            a14.a(1);
        } else {
            a14.a(1, str);
        }
        this.a.f();
        Cursor a15 = androidx.room.b.b.a(this.a, a14, false);
        try {
            a = androidx.room.b.a.a(a15, "id");
            a2 = androidx.room.b.a.a(a15, "state");
            a3 = androidx.room.b.a.a(a15, "worker_class_name");
            a4 = androidx.room.b.a.a(a15, "input_merger_class_name");
            a5 = androidx.room.b.a.a(a15, "input");
            a6 = androidx.room.b.a.a(a15, "output");
            a7 = androidx.room.b.a.a(a15, "initial_delay");
            a8 = androidx.room.b.a.a(a15, "interval_duration");
            a9 = androidx.room.b.a.a(a15, "flex_duration");
            a10 = androidx.room.b.a.a(a15, "run_attempt_count");
            a11 = androidx.room.b.a.a(a15, "backoff_policy");
            a12 = androidx.room.b.a.a(a15, "backoff_delay_duration");
            a13 = androidx.room.b.a.a(a15, "period_start_time");
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            int a16 = androidx.room.b.a.a(a15, "minimum_retention_duration");
            int a17 = androidx.room.b.a.a(a15, "schedule_requested_at");
            int a18 = androidx.room.b.a.a(a15, "required_network_type");
            int a19 = androidx.room.b.a.a(a15, "requires_charging");
            int a20 = androidx.room.b.a.a(a15, "requires_device_idle");
            int a21 = androidx.room.b.a.a(a15, "requires_battery_not_low");
            int a22 = androidx.room.b.a.a(a15, "requires_storage_not_low");
            int a23 = androidx.room.b.a.a(a15, "trigger_content_update_delay");
            int a24 = androidx.room.b.a.a(a15, "trigger_max_content_delay");
            int a25 = androidx.room.b.a.a(a15, "content_uri_triggers");
            if (a15.moveToFirst()) {
                try {
                    String string = a15.getString(a);
                    String string2 = a15.getString(a3);
                    androidx.work.c cVar = new androidx.work.c();
                    cVar.a(p.c(a15.getInt(a18)));
                    cVar.a(a15.getInt(a19) != 0);
                    cVar.b(a15.getInt(a20) != 0);
                    cVar.c(a15.getInt(a21) != 0);
                    cVar.d(a15.getInt(a22) != 0);
                    cVar.a(a15.getLong(a23));
                    cVar.b(a15.getLong(a24));
                    cVar.a(p.a(a15.getBlob(a25)));
                    jVar = new j(string, string2);
                    jVar.b = p.a(a15.getInt(a2));
                    jVar.d = a15.getString(a4);
                    jVar.e = androidx.work.e.a(a15.getBlob(a5));
                    jVar.f = androidx.work.e.a(a15.getBlob(a6));
                    jVar.g = a15.getLong(a7);
                    jVar.h = a15.getLong(a8);
                    jVar.i = a15.getLong(a9);
                    jVar.k = a15.getInt(a10);
                    jVar.l = p.b(a15.getInt(a11));
                    jVar.m = a15.getLong(a12);
                    jVar.n = a15.getLong(a13);
                    jVar.o = a15.getLong(a16);
                    jVar.p = a15.getLong(a17);
                    jVar.j = cVar;
                } catch (Throwable th3) {
                    th = th3;
                    a14 = a14;
                    a15.close();
                    a14.a();
                    throw th;
                }
            } else {
                jVar = null;
            }
            a15.close();
            a14.a();
            return jVar;
        } catch (Throwable th4) {
            th = th4;
            a14 = a14;
            th = th;
            a15.close();
            a14.a();
            throw th;
        }
    }

    @Override // androidx.work.impl.b.k
    public List<j.a> c(String str) {
        androidx.room.l a = androidx.room.l.a("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            a.a(1);
        } else {
            a.a(1, str);
        }
        this.a.f();
        Cursor a2 = androidx.room.b.b.a(this.a, a, false);
        try {
            int a3 = androidx.room.b.a.a(a2, "id");
            int a4 = androidx.room.b.a.a(a2, "state");
            ArrayList arrayList = new ArrayList(a2.getCount());
            while (a2.moveToNext()) {
                j.a aVar = new j.a();
                aVar.a = a2.getString(a3);
                aVar.b = p.a(a2.getInt(a4));
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            a2.close();
            a.a();
        }
    }

    @Override // androidx.work.impl.b.k
    public n.a f(String str) {
        androidx.room.l a = androidx.room.l.a("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            a.a(1);
        } else {
            a.a(1, str);
        }
        this.a.f();
        Cursor a2 = androidx.room.b.b.a(this.a, a, false);
        try {
            return a2.moveToFirst() ? p.a(a2.getInt(0)) : null;
        } finally {
            a2.close();
            a.a();
        }
    }

    @Override // androidx.work.impl.b.k
    public List<androidx.work.e> g(String str) {
        androidx.room.l a = androidx.room.l.a("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            a.a(1);
        } else {
            a.a(1, str);
        }
        this.a.f();
        Cursor a2 = androidx.room.b.b.a(this.a, a, false);
        try {
            ArrayList arrayList = new ArrayList(a2.getCount());
            while (a2.moveToNext()) {
                arrayList.add(androidx.work.e.a(a2.getBlob(0)));
            }
            return arrayList;
        } finally {
            a2.close();
            a.a();
        }
    }

    @Override // androidx.work.impl.b.k
    public List<String> h(String str) {
        androidx.room.l a = androidx.room.l.a("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            a.a(1);
        } else {
            a.a(1, str);
        }
        this.a.f();
        Cursor a2 = androidx.room.b.b.a(this.a, a, false);
        try {
            ArrayList arrayList = new ArrayList(a2.getCount());
            while (a2.moveToNext()) {
                arrayList.add(a2.getString(0));
            }
            return arrayList;
        } finally {
            a2.close();
            a.a();
        }
    }

    @Override // androidx.work.impl.b.k
    public List<String> i(String str) {
        androidx.room.l a = androidx.room.l.a("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            a.a(1);
        } else {
            a.a(1, str);
        }
        this.a.f();
        Cursor a2 = androidx.room.b.b.a(this.a, a, false);
        try {
            ArrayList arrayList = new ArrayList(a2.getCount());
            while (a2.moveToNext()) {
                arrayList.add(a2.getString(0));
            }
            return arrayList;
        } finally {
            a2.close();
            a.a();
        }
    }

    @Override // androidx.work.impl.b.k
    public List<String> a() {
        androidx.room.l a = androidx.room.l.a("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.a.f();
        Cursor a2 = androidx.room.b.b.a(this.a, a, false);
        try {
            ArrayList arrayList = new ArrayList(a2.getCount());
            while (a2.moveToNext()) {
                arrayList.add(a2.getString(0));
            }
            return arrayList;
        } finally {
            a2.close();
            a.a();
        }
    }

    @Override // androidx.work.impl.b.k
    public List<j> a(int i) {
        androidx.room.l lVar;
        Throwable th;
        androidx.room.l a = androidx.room.l.a("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        a.a(1, i);
        this.a.f();
        Cursor a2 = androidx.room.b.b.a(this.a, a, false);
        try {
            int a3 = androidx.room.b.a.a(a2, "id");
            int a4 = androidx.room.b.a.a(a2, "state");
            int a5 = androidx.room.b.a.a(a2, "worker_class_name");
            int a6 = androidx.room.b.a.a(a2, "input_merger_class_name");
            int a7 = androidx.room.b.a.a(a2, "input");
            int a8 = androidx.room.b.a.a(a2, "output");
            int a9 = androidx.room.b.a.a(a2, "initial_delay");
            int a10 = androidx.room.b.a.a(a2, "interval_duration");
            int a11 = androidx.room.b.a.a(a2, "flex_duration");
            int a12 = androidx.room.b.a.a(a2, "run_attempt_count");
            int a13 = androidx.room.b.a.a(a2, "backoff_policy");
            int a14 = androidx.room.b.a.a(a2, "backoff_delay_duration");
            int a15 = androidx.room.b.a.a(a2, "period_start_time");
            try {
                int a16 = androidx.room.b.a.a(a2, "minimum_retention_duration");
                int a17 = androidx.room.b.a.a(a2, "schedule_requested_at");
                int a18 = androidx.room.b.a.a(a2, "required_network_type");
                int i2 = a15;
                int a19 = androidx.room.b.a.a(a2, "requires_charging");
                int i3 = a14;
                int a20 = androidx.room.b.a.a(a2, "requires_device_idle");
                int i4 = a13;
                int a21 = androidx.room.b.a.a(a2, "requires_battery_not_low");
                int i5 = a12;
                int a22 = androidx.room.b.a.a(a2, "requires_storage_not_low");
                int i6 = a11;
                int a23 = androidx.room.b.a.a(a2, "trigger_content_update_delay");
                int i7 = a10;
                int a24 = androidx.room.b.a.a(a2, "trigger_max_content_delay");
                int i8 = a9;
                int a25 = androidx.room.b.a.a(a2, "content_uri_triggers");
                int i9 = a8;
                int i10 = a7;
                ArrayList arrayList = new ArrayList(a2.getCount());
                while (a2.moveToNext()) {
                    try {
                        String string = a2.getString(a3);
                        int i11 = a3;
                        String string2 = a2.getString(a5);
                        int i12 = a5;
                        androidx.work.c cVar = new androidx.work.c();
                        ArrayList arrayList2 = arrayList;
                        cVar.a(p.c(a2.getInt(a18)));
                        cVar.a(a2.getInt(a19) != 0);
                        cVar.b(a2.getInt(a20) != 0);
                        cVar.c(a2.getInt(a21) != 0);
                        cVar.d(a2.getInt(a22) != 0);
                        int i13 = a19;
                        int i14 = a18;
                        cVar.a(a2.getLong(a23));
                        cVar.b(a2.getLong(a24));
                        cVar.a(p.a(a2.getBlob(a25)));
                        j jVar = new j(string, string2);
                        jVar.b = p.a(a2.getInt(a4));
                        jVar.d = a2.getString(a6);
                        int i15 = i10;
                        jVar.e = androidx.work.e.a(a2.getBlob(i15));
                        int i16 = i9;
                        jVar.f = androidx.work.e.a(a2.getBlob(i16));
                        int i17 = a21;
                        int i18 = i8;
                        jVar.g = a2.getLong(i18);
                        int i19 = a20;
                        int i20 = i7;
                        jVar.h = a2.getLong(i20);
                        int i21 = i6;
                        jVar.i = a2.getLong(i21);
                        int i22 = i5;
                        jVar.k = a2.getInt(i22);
                        int i23 = i4;
                        jVar.l = p.b(a2.getInt(i23));
                        int i24 = i3;
                        jVar.m = a2.getLong(i24);
                        int i25 = i2;
                        jVar.n = a2.getLong(i25);
                        int i26 = a16;
                        jVar.o = a2.getLong(i26);
                        int i27 = a17;
                        jVar.p = a2.getLong(i27);
                        jVar.j = cVar;
                        arrayList2.add(jVar);
                        a17 = i27;
                        i8 = i18;
                        i3 = i24;
                        a3 = i11;
                        a5 = i12;
                        a19 = i13;
                        a21 = i17;
                        i10 = i15;
                        a20 = i19;
                        i9 = i16;
                        i7 = i20;
                        i6 = i21;
                        i5 = i22;
                        i4 = i23;
                        i2 = i25;
                        a16 = i26;
                        arrayList = arrayList2;
                        a18 = i14;
                    } catch (Throwable th2) {
                        th = th2;
                        lVar = a;
                        a2.close();
                        lVar.a();
                        throw th;
                    }
                }
                ArrayList arrayList3 = arrayList;
                a2.close();
                a.a();
                return arrayList3;
            } catch (Throwable th3) {
                th = th3;
                lVar = a;
                th = th;
                a2.close();
                lVar.a();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            lVar = a;
        }
    }

    @Override // androidx.work.impl.b.k
    public List<j> c() {
        androidx.room.l lVar;
        Throwable th;
        androidx.room.l a = androidx.room.l.a("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.a.f();
        Cursor a2 = androidx.room.b.b.a(this.a, a, false);
        try {
            int a3 = androidx.room.b.a.a(a2, "id");
            int a4 = androidx.room.b.a.a(a2, "state");
            int a5 = androidx.room.b.a.a(a2, "worker_class_name");
            int a6 = androidx.room.b.a.a(a2, "input_merger_class_name");
            int a7 = androidx.room.b.a.a(a2, "input");
            int a8 = androidx.room.b.a.a(a2, "output");
            int a9 = androidx.room.b.a.a(a2, "initial_delay");
            int a10 = androidx.room.b.a.a(a2, "interval_duration");
            int a11 = androidx.room.b.a.a(a2, "flex_duration");
            int a12 = androidx.room.b.a.a(a2, "run_attempt_count");
            int a13 = androidx.room.b.a.a(a2, "backoff_policy");
            int a14 = androidx.room.b.a.a(a2, "backoff_delay_duration");
            int a15 = androidx.room.b.a.a(a2, "period_start_time");
            try {
                int a16 = androidx.room.b.a.a(a2, "minimum_retention_duration");
                int a17 = androidx.room.b.a.a(a2, "schedule_requested_at");
                int a18 = androidx.room.b.a.a(a2, "required_network_type");
                int i = a15;
                int a19 = androidx.room.b.a.a(a2, "requires_charging");
                int i2 = a14;
                int a20 = androidx.room.b.a.a(a2, "requires_device_idle");
                int i3 = a13;
                int a21 = androidx.room.b.a.a(a2, "requires_battery_not_low");
                int i4 = a12;
                int a22 = androidx.room.b.a.a(a2, "requires_storage_not_low");
                int i5 = a11;
                int a23 = androidx.room.b.a.a(a2, "trigger_content_update_delay");
                int i6 = a10;
                int a24 = androidx.room.b.a.a(a2, "trigger_max_content_delay");
                int i7 = a9;
                int a25 = androidx.room.b.a.a(a2, "content_uri_triggers");
                int i8 = a8;
                int i9 = a7;
                ArrayList arrayList = new ArrayList(a2.getCount());
                while (a2.moveToNext()) {
                    try {
                        String string = a2.getString(a3);
                        int i10 = a3;
                        String string2 = a2.getString(a5);
                        int i11 = a5;
                        androidx.work.c cVar = new androidx.work.c();
                        ArrayList arrayList2 = arrayList;
                        cVar.a(p.c(a2.getInt(a18)));
                        cVar.a(a2.getInt(a19) != 0);
                        cVar.b(a2.getInt(a20) != 0);
                        cVar.c(a2.getInt(a21) != 0);
                        cVar.d(a2.getInt(a22) != 0);
                        int i12 = a19;
                        int i13 = a18;
                        cVar.a(a2.getLong(a23));
                        cVar.b(a2.getLong(a24));
                        cVar.a(p.a(a2.getBlob(a25)));
                        j jVar = new j(string, string2);
                        jVar.b = p.a(a2.getInt(a4));
                        jVar.d = a2.getString(a6);
                        int i14 = i9;
                        jVar.e = androidx.work.e.a(a2.getBlob(i14));
                        int i15 = i8;
                        jVar.f = androidx.work.e.a(a2.getBlob(i15));
                        int i16 = a20;
                        int i17 = i7;
                        jVar.g = a2.getLong(i17);
                        int i18 = a4;
                        int i19 = i6;
                        jVar.h = a2.getLong(i19);
                        int i20 = i5;
                        jVar.i = a2.getLong(i20);
                        int i21 = i4;
                        jVar.k = a2.getInt(i21);
                        int i22 = i3;
                        jVar.l = p.b(a2.getInt(i22));
                        int i23 = i2;
                        jVar.m = a2.getLong(i23);
                        int i24 = i;
                        jVar.n = a2.getLong(i24);
                        int i25 = a16;
                        jVar.o = a2.getLong(i25);
                        int i26 = a17;
                        jVar.p = a2.getLong(i26);
                        jVar.j = cVar;
                        arrayList2.add(jVar);
                        a17 = i26;
                        i7 = i17;
                        i2 = i23;
                        a3 = i10;
                        a5 = i11;
                        a19 = i12;
                        a20 = i16;
                        i9 = i14;
                        a4 = i18;
                        i8 = i15;
                        i6 = i19;
                        i5 = i20;
                        i4 = i21;
                        i3 = i22;
                        i = i24;
                        a16 = i25;
                        arrayList = arrayList2;
                        a18 = i13;
                    } catch (Throwable th2) {
                        th = th2;
                        lVar = a;
                        a2.close();
                        lVar.a();
                        throw th;
                    }
                }
                ArrayList arrayList3 = arrayList;
                a2.close();
                a.a();
                return arrayList3;
            } catch (Throwable th3) {
                th = th3;
                lVar = a;
                th = th;
                a2.close();
                lVar.a();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            lVar = a;
        }
    }

    @Override // androidx.work.impl.b.k
    public List<j> d() {
        androidx.room.l lVar;
        Throwable th;
        androidx.room.l a = androidx.room.l.a("SELECT * FROM workspec WHERE state=1", 0);
        this.a.f();
        Cursor a2 = androidx.room.b.b.a(this.a, a, false);
        try {
            int a3 = androidx.room.b.a.a(a2, "id");
            int a4 = androidx.room.b.a.a(a2, "state");
            int a5 = androidx.room.b.a.a(a2, "worker_class_name");
            int a6 = androidx.room.b.a.a(a2, "input_merger_class_name");
            int a7 = androidx.room.b.a.a(a2, "input");
            int a8 = androidx.room.b.a.a(a2, "output");
            int a9 = androidx.room.b.a.a(a2, "initial_delay");
            int a10 = androidx.room.b.a.a(a2, "interval_duration");
            int a11 = androidx.room.b.a.a(a2, "flex_duration");
            int a12 = androidx.room.b.a.a(a2, "run_attempt_count");
            int a13 = androidx.room.b.a.a(a2, "backoff_policy");
            int a14 = androidx.room.b.a.a(a2, "backoff_delay_duration");
            int a15 = androidx.room.b.a.a(a2, "period_start_time");
            try {
                int a16 = androidx.room.b.a.a(a2, "minimum_retention_duration");
                int a17 = androidx.room.b.a.a(a2, "schedule_requested_at");
                int a18 = androidx.room.b.a.a(a2, "required_network_type");
                int i = a15;
                int a19 = androidx.room.b.a.a(a2, "requires_charging");
                int i2 = a14;
                int a20 = androidx.room.b.a.a(a2, "requires_device_idle");
                int i3 = a13;
                int a21 = androidx.room.b.a.a(a2, "requires_battery_not_low");
                int i4 = a12;
                int a22 = androidx.room.b.a.a(a2, "requires_storage_not_low");
                int i5 = a11;
                int a23 = androidx.room.b.a.a(a2, "trigger_content_update_delay");
                int i6 = a10;
                int a24 = androidx.room.b.a.a(a2, "trigger_max_content_delay");
                int i7 = a9;
                int a25 = androidx.room.b.a.a(a2, "content_uri_triggers");
                int i8 = a8;
                int i9 = a7;
                ArrayList arrayList = new ArrayList(a2.getCount());
                while (a2.moveToNext()) {
                    try {
                        String string = a2.getString(a3);
                        int i10 = a3;
                        String string2 = a2.getString(a5);
                        int i11 = a5;
                        androidx.work.c cVar = new androidx.work.c();
                        ArrayList arrayList2 = arrayList;
                        cVar.a(p.c(a2.getInt(a18)));
                        cVar.a(a2.getInt(a19) != 0);
                        cVar.b(a2.getInt(a20) != 0);
                        cVar.c(a2.getInt(a21) != 0);
                        cVar.d(a2.getInt(a22) != 0);
                        int i12 = a19;
                        int i13 = a18;
                        cVar.a(a2.getLong(a23));
                        cVar.b(a2.getLong(a24));
                        cVar.a(p.a(a2.getBlob(a25)));
                        j jVar = new j(string, string2);
                        jVar.b = p.a(a2.getInt(a4));
                        jVar.d = a2.getString(a6);
                        int i14 = i9;
                        jVar.e = androidx.work.e.a(a2.getBlob(i14));
                        int i15 = i8;
                        jVar.f = androidx.work.e.a(a2.getBlob(i15));
                        int i16 = a20;
                        int i17 = i7;
                        jVar.g = a2.getLong(i17);
                        int i18 = a4;
                        int i19 = i6;
                        jVar.h = a2.getLong(i19);
                        int i20 = i5;
                        jVar.i = a2.getLong(i20);
                        int i21 = i4;
                        jVar.k = a2.getInt(i21);
                        int i22 = i3;
                        jVar.l = p.b(a2.getInt(i22));
                        int i23 = i2;
                        jVar.m = a2.getLong(i23);
                        int i24 = i;
                        jVar.n = a2.getLong(i24);
                        int i25 = a16;
                        jVar.o = a2.getLong(i25);
                        int i26 = a17;
                        jVar.p = a2.getLong(i26);
                        jVar.j = cVar;
                        arrayList2.add(jVar);
                        a17 = i26;
                        i7 = i17;
                        i2 = i23;
                        a3 = i10;
                        a5 = i11;
                        a19 = i12;
                        a20 = i16;
                        i9 = i14;
                        a4 = i18;
                        i8 = i15;
                        i6 = i19;
                        i5 = i20;
                        i4 = i21;
                        i3 = i22;
                        i = i24;
                        a16 = i25;
                        arrayList = arrayList2;
                        a18 = i13;
                    } catch (Throwable th2) {
                        th = th2;
                        lVar = a;
                        a2.close();
                        lVar.a();
                        throw th;
                    }
                }
                ArrayList arrayList3 = arrayList;
                a2.close();
                a.a();
                return arrayList3;
            } catch (Throwable th3) {
                th = th3;
                lVar = a;
                th = th;
                a2.close();
                lVar.a();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            lVar = a;
        }
    }

    @Override // androidx.work.impl.b.k
    public int a(n.a aVar, String... strArr) {
        this.a.f();
        StringBuilder a = androidx.room.b.c.a();
        a.append("UPDATE workspec SET state=");
        a.append("?");
        a.append(" WHERE id IN (");
        int i = 2;
        androidx.room.b.c.a(a, strArr.length);
        a.append(")");
        androidx.g.a.f a2 = this.a.a(a.toString());
        a2.a(1, p.a(aVar));
        for (String str : strArr) {
            if (str == null) {
                a2.a(i);
            } else {
                a2.a(i, str);
            }
            i++;
        }
        this.a.g();
        try {
            int a3 = a2.a();
            this.a.j();
            return a3;
        } finally {
            this.a.h();
        }
    }
}
