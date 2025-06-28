package com.jumobile.manager.systemapp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

/* compiled from: source */
/* loaded from: classes.dex */
public class a {
    private static final Pattern a = Pattern.compile("[\\w%+,./=_-]+");

    public static boolean a(String str, String str2) {
        return a(new File(str), new File(str2));
    }

    public static boolean a(File file, File file2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                boolean a2 = a(fileInputStream, file2);
                fileInputStream.close();
                return a2;
            } catch (Throwable th) {
                fileInputStream.close();
                throw th;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX WARN: Finally extract failed */
    public static boolean a(InputStream inputStream, File file) {
        try {
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read < 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                try {
                    fileOutputStream.getFD().sync();
                } catch (IOException unused) {
                }
                fileOutputStream.close();
                return true;
            } catch (Throwable th) {
                fileOutputStream.flush();
                try {
                    fileOutputStream.getFD().sync();
                } catch (IOException unused2) {
                }
                fileOutputStream.close();
                throw th;
            }
        } catch (IOException unused3) {
            return false;
        }
    }
}
