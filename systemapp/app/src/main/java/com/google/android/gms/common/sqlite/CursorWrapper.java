package com.google.android.gms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public class CursorWrapper extends android.database.CursorWrapper implements CrossProcessCursor {
    private AbstractWindowedCursor a;

    @Override // android.database.CrossProcessCursor
    @KeepForSdk
    public CursorWindow getWindow() {
        return this.a.getWindow();
    }

    @Override // android.database.CrossProcessCursor
    @KeepForSdk
    public void fillWindow(int i, CursorWindow cursorWindow) {
        this.a.fillWindow(i, cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    public boolean onMove(int i, int i2) {
        return this.a.onMove(i, i2);
    }

    @Override // android.database.CursorWrapper
    public /* synthetic */ Cursor getWrappedCursor() {
        return this.a;
    }
}
