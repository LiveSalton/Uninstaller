package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.IOUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzduc {
    public static File a(String str, String str2, File file) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return new File(a(str, file), str2);
    }

    public static boolean a(File file, byte[] bArr) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (IOException unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            IOUtils.a(fileOutputStream);
            return true;
        } catch (IOException unused2) {
            fileOutputStream2 = fileOutputStream;
            IOUtils.a(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            IOUtils.a(fileOutputStream2);
            throw th;
        }
    }

    public static File a(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a(new File(file, str), false);
    }

    public static File a(File file, boolean z) {
        if (z && file.exists() && !file.isDirectory()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static boolean a(File file) {
        boolean z;
        if (!file.exists()) {
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            z = true;
            for (int i = 0; i < length; i++) {
                File file2 = listFiles[i];
                z = file2 != null && a(file2) && z;
            }
        } else {
            z = true;
        }
        return file.delete() && z;
    }

    public static byte[] b(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] d = zzeiu.a(fileInputStream).d();
                IOUtils.a(fileInputStream);
                return d;
            } catch (IOException unused) {
                IOUtils.a(fileInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                IOUtils.a(fileInputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
