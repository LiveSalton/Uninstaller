package androidx.room.b;

import android.database.Cursor;
import android.database.MatrixCursor;

/* compiled from: source */
/* loaded from: classes.dex */
public class a {
    public static Cursor a(Cursor cursor) {
        try {
            MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                Object[] objArr = new Object[cursor.getColumnCount()];
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    switch (cursor.getType(i)) {
                        case 0:
                            objArr[i] = null;
                        case 1:
                            objArr[i] = Long.valueOf(cursor.getLong(i));
                        case 2:
                            objArr[i] = Double.valueOf(cursor.getDouble(i));
                        case 3:
                            objArr[i] = cursor.getString(i);
                        case 4:
                            objArr[i] = cursor.getBlob(i);
                        default:
                            throw new IllegalStateException();
                    }
                }
                matrixCursor.addRow(objArr);
            }
            return matrixCursor;
        } finally {
            cursor.close();
        }
    }

    public static int a(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        return cursor.getColumnIndexOrThrow("`" + str + "`");
    }
}
