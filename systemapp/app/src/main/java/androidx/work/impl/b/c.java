package androidx.work.impl.b;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class c implements b {
    private final androidx.room.i a;
    private final androidx.room.b b;

    public c(androidx.room.i iVar) {
        this.a = iVar;
        this.b = new androidx.room.b<a>(iVar) { // from class: androidx.work.impl.b.c.1
            @Override // androidx.room.m
            public String a() {
                return "INSERT OR IGNORE INTO `Dependency`(`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            }

            AnonymousClass1(androidx.room.i iVar2) {
                super(iVar2);
            }

            @Override // androidx.room.b
            public void a(androidx.g.a.f fVar, a aVar) {
                if (aVar.a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, aVar.a);
                }
                if (aVar.b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, aVar.b);
                }
            }
        };
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.b.c$1 */
    class AnonymousClass1 extends androidx.room.b<a> {
        @Override // androidx.room.m
        public String a() {
            return "INSERT OR IGNORE INTO `Dependency`(`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }

        AnonymousClass1(androidx.room.i iVar2) {
            super(iVar2);
        }

        @Override // androidx.room.b
        public void a(androidx.g.a.f fVar, a aVar) {
            if (aVar.a == null) {
                fVar.a(1);
            } else {
                fVar.a(1, aVar.a);
            }
            if (aVar.b == null) {
                fVar.a(2);
            } else {
                fVar.a(2, aVar.b);
            }
        }
    }

    @Override // androidx.work.impl.b.b
    public void a(a aVar) {
        this.a.f();
        this.a.g();
        try {
            this.b.a((androidx.room.b) aVar);
            this.a.j();
        } finally {
            this.a.h();
        }
    }

    @Override // androidx.work.impl.b.b
    public boolean a(String str) {
        androidx.room.l a = androidx.room.l.a("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            a.a(1);
        } else {
            a.a(1, str);
        }
        this.a.f();
        boolean z = false;
        Cursor a2 = androidx.room.b.b.a(this.a, a, false);
        try {
            if (a2.moveToFirst()) {
                if (a2.getInt(0) != 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            a2.close();
            a.a();
        }
    }

    @Override // androidx.work.impl.b.b
    public List<String> b(String str) {
        androidx.room.l a = androidx.room.l.a("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
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

    @Override // androidx.work.impl.b.b
    public boolean c(String str) {
        androidx.room.l a = androidx.room.l.a("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            a.a(1);
        } else {
            a.a(1, str);
        }
        this.a.f();
        boolean z = false;
        Cursor a2 = androidx.room.b.b.a(this.a, a, false);
        try {
            if (a2.moveToFirst()) {
                if (a2.getInt(0) != 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            a2.close();
            a.a();
        }
    }
}
