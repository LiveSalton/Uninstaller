package com.github.ybq.android.spinkit.c;

/* compiled from: source */
/* loaded from: classes.dex */
public class g extends com.github.ybq.android.spinkit.b.g {
    @Override // com.github.ybq.android.spinkit.b.g
    public com.github.ybq.android.spinkit.b.f[] s() {
        return new com.github.ybq.android.spinkit.b.f[]{new i(), new i(), new i()};
    }

    @Override // com.github.ybq.android.spinkit.b.g
    public void a(com.github.ybq.android.spinkit.b.f... fVarArr) {
        int i = 0;
        while (i < fVarArr.length) {
            com.github.ybq.android.spinkit.b.f fVar = fVarArr[i];
            i++;
            fVar.g(200 * i);
        }
    }
}
