package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdtl {
    private final Context a;
    private final zzdsi b;

    public zzdtl(Context context, zzdsi zzdsiVar) {
        this.a = context;
        this.b = zzdsiVar;
    }

    private final void a(byte[] bArr, String str) {
        if (this.b == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("os.arch:");
        sb.append(zzdwd.OS_ARCH.a());
        sb.append(";");
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
            if (strArr != null) {
                sb.append("supported_abis:");
                sb.append(Arrays.toString(strArr));
                sb.append(";");
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
        sb.append("CPU_ABI:");
        sb.append(Build.CPU_ABI);
        sb.append(";");
        sb.append("CPU_ABI2:");
        sb.append(Build.CPU_ABI2);
        sb.append(";");
        if (bArr != null) {
            sb.append("ELF:");
            sb.append(Arrays.toString(bArr));
            sb.append(";");
        }
        if (str != null) {
            sb.append("dbg:");
            sb.append(str);
            sb.append(";");
        }
        this.b.a(4007, sb.toString());
    }

    private final String b() {
        HashSet hashSet = new HashSet(Arrays.asList("i686", "armv71"));
        String a = zzdwd.OS_ARCH.a();
        if (!TextUtils.isEmpty(a) && hashSet.contains(a)) {
            return a;
        }
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
            if (strArr != null && strArr.length > 0) {
                return strArr[0];
            }
        } catch (IllegalAccessException e) {
            if (this.b != null) {
                this.b.a(2024, 0L, e);
            }
        } catch (NoSuchFieldException e2) {
            if (this.b != null) {
                this.b.a(2024, 0L, e2);
            }
        }
        if (Build.CPU_ABI != null) {
            return Build.CPU_ABI;
        }
        return Build.CPU_ABI2;
    }

    private final zzgn c() {
        FileInputStream fileInputStream;
        byte[] bArr;
        File file = new File(new File(this.a.getApplicationInfo().dataDir), "lib");
        if (!file.exists()) {
            if (this.b != null) {
                this.b.a(5017, "No lib/");
            }
            return zzgn.UNKNOWN;
        }
        File[] listFiles = file.listFiles(new zzdxl(Pattern.compile(".*\\.so$", 2)));
        if (listFiles == null || listFiles.length == 0) {
            if (this.b != null) {
                this.b.a(5017, "No .so");
            }
            return zzgn.UNKNOWN;
        }
        try {
            fileInputStream = new FileInputStream(listFiles[0]);
            try {
                bArr = new byte[20];
            } finally {
            }
        } catch (IOException e) {
            a(null, e.toString());
        }
        if (fileInputStream.read(bArr) == 20) {
            byte[] bArr2 = {0, 0};
            if (bArr[5] == 2) {
                a(bArr, null);
                zzgn zzgnVar = zzgn.UNSUPPORTED;
                fileInputStream.close();
                return zzgnVar;
            }
            bArr2[0] = bArr[19];
            bArr2[1] = bArr[18];
            short s = ByteBuffer.wrap(bArr2).getShort();
            if (s == 3) {
                zzgn zzgnVar2 = zzgn.X86;
                fileInputStream.close();
                return zzgnVar2;
            }
            if (s == 40) {
                zzgn zzgnVar3 = zzgn.ARM7;
                fileInputStream.close();
                return zzgnVar3;
            }
            if (s == 62) {
                zzgn zzgnVar4 = zzgn.X86_64;
                fileInputStream.close();
                return zzgnVar4;
            }
            if (s == 183) {
                zzgn zzgnVar5 = zzgn.ARM64;
                fileInputStream.close();
                return zzgnVar5;
            }
            a(bArr, null);
            zzgn zzgnVar6 = zzgn.UNSUPPORTED;
            fileInputStream.close();
            return zzgnVar6;
        }
        fileInputStream.close();
        return zzgn.UNSUPPORTED;
    }

    public final zzgn a() {
        zzgn c = c();
        if (c == zzgn.UNKNOWN) {
            String b = b();
            if (TextUtils.isEmpty(b)) {
                a(null, "Empty dev arch");
                c = zzgn.UNSUPPORTED;
            } else if (b.equalsIgnoreCase("i686") || b.equalsIgnoreCase("x86")) {
                c = zzgn.X86;
            } else if (b.equalsIgnoreCase("x86_64")) {
                c = zzgn.X86_64;
            } else if (b.equalsIgnoreCase("arm64-v8a")) {
                c = zzgn.ARM64;
            } else if (b.equalsIgnoreCase("armeabi-v7a") || b.equalsIgnoreCase("armv71")) {
                c = zzgn.ARM7;
            } else {
                a(null, b);
                c = zzgn.UNSUPPORTED;
            }
        }
        if (this.b != null) {
            this.b.a(5018, c.name());
        }
        return c;
    }

    public static boolean a(zzgn zzgnVar) {
        switch (zzgnVar) {
            case ARM7:
            case X86:
            case ARM64:
            case X86_64:
                return true;
            default:
                return false;
        }
    }
}
