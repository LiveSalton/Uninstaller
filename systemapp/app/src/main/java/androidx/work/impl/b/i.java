package androidx.work.impl.b;

/* compiled from: source */
/* loaded from: classes.dex */
public final class i implements h {
    private final androidx.room.i a;
    private final androidx.room.b b;

    public i(androidx.room.i iVar) {
        this.a = iVar;
        this.b = new androidx.room.b<g>(iVar) { // from class: androidx.work.impl.b.i.1
            @Override // androidx.room.m
            public String a() {
                return "INSERT OR IGNORE INTO `WorkName`(`name`,`work_spec_id`) VALUES (?,?)";
            }

            AnonymousClass1(androidx.room.i iVar2) {
                super(iVar2);
            }

            @Override // androidx.room.b
            public void a(androidx.g.a.f fVar, g gVar) {
                if (gVar.a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, gVar.a);
                }
                if (gVar.b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, gVar.b);
                }
            }
        };
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.b.i$1 */
    class AnonymousClass1 extends androidx.room.b<g> {
        @Override // androidx.room.m
        public String a() {
            return "INSERT OR IGNORE INTO `WorkName`(`name`,`work_spec_id`) VALUES (?,?)";
        }

        AnonymousClass1(androidx.room.i iVar2) {
            super(iVar2);
        }

        @Override // androidx.room.b
        public void a(androidx.g.a.f fVar, g gVar) {
            if (gVar.a == null) {
                fVar.a(1);
            } else {
                fVar.a(1, gVar.a);
            }
            if (gVar.b == null) {
                fVar.a(2);
            } else {
                fVar.a(2, gVar.b);
            }
        }
    }

    @Override // androidx.work.impl.b.h
    public void a(g gVar) {
        this.a.f();
        this.a.g();
        try {
            this.b.a((androidx.room.b) gVar);
            this.a.j();
        } finally {
            this.a.h();
        }
    }
}
