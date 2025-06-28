package androidx.work.impl.b;

import android.database.Cursor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class f implements e {
    private final androidx.room.i a;
    private final androidx.room.b b;
    private final androidx.room.m c;

    public f(androidx.room.i iVar) {
        this.a = iVar;
        this.b = new androidx.room.b<d>(iVar) { // from class: androidx.work.impl.b.f.1
            @Override // androidx.room.m
            public String a() {
                return "INSERT OR REPLACE INTO `SystemIdInfo`(`work_spec_id`,`system_id`) VALUES (?,?)";
            }

            AnonymousClass1(androidx.room.i iVar2) {
                super(iVar2);
            }

            @Override // androidx.room.b
            public void a(androidx.g.a.f fVar, d dVar) {
                if (dVar.a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, dVar.a);
                }
                fVar.a(2, dVar.b);
            }
        };
        this.c = new androidx.room.m(iVar2) { // from class: androidx.work.impl.b.f.2
            @Override // androidx.room.m
            public String a() {
                return "DELETE FROM SystemIdInfo where work_spec_id=?";
            }

            AnonymousClass2(androidx.room.i iVar2) {
                super(iVar2);
            }
        };
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.b.f$1 */
    class AnonymousClass1 extends androidx.room.b<d> {
        @Override // androidx.room.m
        public String a() {
            return "INSERT OR REPLACE INTO `SystemIdInfo`(`work_spec_id`,`system_id`) VALUES (?,?)";
        }

        AnonymousClass1(androidx.room.i iVar2) {
            super(iVar2);
        }

        @Override // androidx.room.b
        public void a(androidx.g.a.f fVar, d dVar) {
            if (dVar.a == null) {
                fVar.a(1);
            } else {
                fVar.a(1, dVar.a);
            }
            fVar.a(2, dVar.b);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.b.f$2 */
    class AnonymousClass2 extends androidx.room.m {
        @Override // androidx.room.m
        public String a() {
            return "DELETE FROM SystemIdInfo where work_spec_id=?";
        }

        AnonymousClass2(androidx.room.i iVar2) {
            super(iVar2);
        }
    }

    @Override // androidx.work.impl.b.e
    public void a(d dVar) {
        this.a.f();
        this.a.g();
        try {
            this.b.a((androidx.room.b) dVar);
            this.a.j();
        } finally {
            this.a.h();
        }
    }

    @Override // androidx.work.impl.b.e
    public void b(String str) {
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

    @Override // androidx.work.impl.b.e
    public d a(String str) {
        androidx.room.l a = androidx.room.l.a("SELECT * FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            a.a(1);
        } else {
            a.a(1, str);
        }
        this.a.f();
        Cursor a2 = androidx.room.b.b.a(this.a, a, false);
        try {
            return a2.moveToFirst() ? new d(a2.getString(androidx.room.b.a.a(a2, "work_spec_id")), a2.getInt(androidx.room.b.a.a(a2, "system_id"))) : null;
        } finally {
            a2.close();
            a.a();
        }
    }
}
