package androidx.room.b;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import androidx.g.a.e;
import androidx.room.i;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public class b {
    public static Cursor a(i iVar, e eVar, boolean z) {
        Cursor a = iVar.a(eVar);
        if (z && (a instanceof AbstractWindowedCursor)) {
            AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) a;
            int count = abstractWindowedCursor.getCount();
            int numRows = abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count;
            if (Build.VERSION.SDK_INT < 23 || numRows < count) {
                return a.a(abstractWindowedCursor);
            }
        }
        return a;
    }

    public static void a(androidx.g.a.b bVar) {
        ArrayList<String> arrayList = new ArrayList();
        Cursor b = bVar.b("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (b.moveToNext()) {
            try {
                arrayList.add(b.getString(0));
            } catch (Throwable th) {
                b.close();
                throw th;
            }
        }
        b.close();
        for (String str : arrayList) {
            if (str.startsWith("room_fts_content_sync_")) {
                bVar.c("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }
}
