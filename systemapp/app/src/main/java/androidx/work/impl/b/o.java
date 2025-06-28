package androidx.work.impl.b;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class o implements n {
    private final androidx.room.i a;
    private final androidx.room.b b;

    public o(androidx.room.i iVar) {
        this.a = iVar;
        this.b = new androidx.room.b<m>(iVar) { // from class: androidx.work.impl.b.o.1
            @Override // androidx.room.m
            public String a() {
                return "INSERT OR IGNORE INTO `WorkTag`(`tag`,`work_spec_id`) VALUES (?,?)";
            }

            AnonymousClass1(androidx.room.i iVar2) {
                super(iVar2);
            }

            @Override // androidx.room.b
            public void a(androidx.g.a.f fVar, m mVar) {
                if (mVar.a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, mVar.a);
                }
                if (mVar.b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, mVar.b);
                }
            }
        };
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.b.o$1 */
    class AnonymousClass1 extends androidx.room.b<m> {
        @Override // androidx.room.m
        public String a() {
            return "INSERT OR IGNORE INTO `WorkTag`(`tag`,`work_spec_id`) VALUES (?,?)";
        }

        AnonymousClass1(androidx.room.i iVar2) {
            super(iVar2);
        }

        @Override // androidx.room.b
        public void a(androidx.g.a.f fVar, m mVar) {
            if (mVar.a == null) {
                fVar.a(1);
            } else {
                fVar.a(1, mVar.a);
            }
            if (mVar.b == null) {
                fVar.a(2);
            } else {
                fVar.a(2, mVar.b);
            }
        }
    }

    @Override // androidx.work.impl.b.n
    public void a(m mVar) {
        this.a.f();
        this.a.g();
        try {
            this.b.a((androidx.room.b) mVar);
            this.a.j();
        } finally {
            this.a.h();
        }
    }

    @Override // androidx.work.impl.b.n
    public List<String> a(String str) {
        androidx.room.l a = androidx.room.l.a("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
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
}
