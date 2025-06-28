package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzmd;

/* compiled from: source */
/* loaded from: classes.dex */
final class azx {
    private static final int a = zzpt.c("nam");
    private static final int b = zzpt.c("trk");
    private static final int c = zzpt.c("cmt");
    private static final int d = zzpt.c("day");
    private static final int e = zzpt.c("ART");
    private static final int f = zzpt.c("too");
    private static final int g = zzpt.c("alb");
    private static final int h = zzpt.c("com");
    private static final int i = zzpt.c("wrt");
    private static final int j = zzpt.c("lyr");
    private static final int k = zzpt.c("gen");
    private static final int l = zzpt.c("covr");
    private static final int m = zzpt.c("gnre");
    private static final int n = zzpt.c("grp");
    private static final int o = zzpt.c("disk");
    private static final int p = zzpt.c("trkn");
    private static final int q = zzpt.c("tmpo");
    private static final int r = zzpt.c("cpil");
    private static final int s = zzpt.c("aART");
    private static final int t = zzpt.c("sonm");
    private static final int u = zzpt.c("soal");
    private static final int v = zzpt.c("soar");
    private static final int w = zzpt.c("soaa");
    private static final int x = zzpt.c("soco");
    private static final int y = zzpt.c("rtng");
    private static final int z = zzpt.c("pgap");
    private static final int A = zzpt.c("sosn");
    private static final int B = zzpt.c("tvsh");
    private static final int C = zzpt.c("----");
    private static final String[] D = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    public static zzmd.zza a(zzpn zzpnVar) {
        zzmn zzmnVar;
        int d2 = zzpnVar.d() + zzpnVar.l();
        int l2 = zzpnVar.l();
        int i2 = l2 >>> 24;
        zzmk zzmkVar = null;
        try {
            if (i2 == 169 || i2 == 65533) {
                int i3 = 16777215 & l2;
                if (i3 == c) {
                    int l3 = zzpnVar.l();
                    if (zzpnVar.l() == azh.aE) {
                        zzpnVar.d(8);
                        String e2 = zzpnVar.e(l3 - 16);
                        zzmkVar = new zzmj("und", e2, e2);
                    } else {
                        String valueOf = String.valueOf(azh.c(l2));
                        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(valueOf) : new String("Failed to parse comment attribute: "));
                    }
                    return zzmkVar;
                }
                if (i3 != a && i3 != b) {
                    if (i3 != h && i3 != i) {
                        if (i3 == d) {
                            return a(l2, "TDRC", zzpnVar);
                        }
                        if (i3 == e) {
                            return a(l2, "TPE1", zzpnVar);
                        }
                        if (i3 == f) {
                            return a(l2, "TSSE", zzpnVar);
                        }
                        if (i3 == g) {
                            return a(l2, "TALB", zzpnVar);
                        }
                        if (i3 == j) {
                            return a(l2, "USLT", zzpnVar);
                        }
                        if (i3 == k) {
                            return a(l2, "TCON", zzpnVar);
                        }
                        if (i3 == n) {
                            return a(l2, "TIT1", zzpnVar);
                        }
                    }
                    return a(l2, "TCOM", zzpnVar);
                }
                return a(l2, "TIT2", zzpnVar);
            }
            if (l2 == m) {
                int b2 = b(zzpnVar);
                String str = (b2 <= 0 || b2 > D.length) ? null : D[b2 - 1];
                if (str != null) {
                    zzmnVar = new zzmn("TCON", null, str);
                } else {
                    Log.w("MetadataUtil", "Failed to parse standard genre code");
                    zzmnVar = null;
                }
                return zzmnVar;
            }
            if (l2 == o) {
                return b(l2, "TPOS", zzpnVar);
            }
            if (l2 == p) {
                return b(l2, "TRCK", zzpnVar);
            }
            if (l2 == q) {
                return a(l2, "TBPM", zzpnVar, true, false);
            }
            if (l2 == r) {
                return a(l2, "TCMP", zzpnVar, true, true);
            }
            if (l2 == l) {
                int l4 = zzpnVar.l();
                if (zzpnVar.l() == azh.aE) {
                    int b3 = azh.b(zzpnVar.l());
                    String str2 = b3 == 13 ? "image/jpeg" : b3 == 14 ? "image/png" : null;
                    if (str2 == null) {
                        StringBuilder sb = new StringBuilder(41);
                        sb.append("Unrecognized cover art flags: ");
                        sb.append(b3);
                        Log.w("MetadataUtil", sb.toString());
                    } else {
                        zzpnVar.d(4);
                        byte[] bArr = new byte[l4 - 16];
                        zzpnVar.a(bArr, 0, bArr.length);
                        zzmkVar = new zzmh(str2, null, 3, bArr);
                    }
                } else {
                    Log.w("MetadataUtil", "Failed to parse cover art attribute");
                }
                return zzmkVar;
            }
            if (l2 == s) {
                return a(l2, "TPE2", zzpnVar);
            }
            if (l2 == t) {
                return a(l2, "TSOT", zzpnVar);
            }
            if (l2 == u) {
                return a(l2, "TSO2", zzpnVar);
            }
            if (l2 == v) {
                return a(l2, "TSOA", zzpnVar);
            }
            if (l2 == w) {
                return a(l2, "TSOP", zzpnVar);
            }
            if (l2 == x) {
                return a(l2, "TSOC", zzpnVar);
            }
            if (l2 == y) {
                return a(l2, "ITUNESADVISORY", zzpnVar, false, false);
            }
            if (l2 == z) {
                return a(l2, "ITUNESGAPLESS", zzpnVar, false, true);
            }
            if (l2 == A) {
                return a(l2, "TVSHOWSORT", zzpnVar);
            }
            if (l2 == B) {
                return a(l2, "TVSHOW", zzpnVar);
            }
            if (l2 == C) {
                int i4 = -1;
                int i5 = -1;
                String str3 = null;
                String str4 = null;
                while (zzpnVar.d() < d2) {
                    int d3 = zzpnVar.d();
                    int l5 = zzpnVar.l();
                    int l6 = zzpnVar.l();
                    zzpnVar.d(4);
                    if (l6 == azh.aC) {
                        str3 = zzpnVar.e(l5 - 12);
                    } else if (l6 == azh.aD) {
                        str4 = zzpnVar.e(l5 - 12);
                    } else {
                        if (l6 == azh.aE) {
                            i4 = d3;
                            i5 = l5;
                        }
                        zzpnVar.d(l5 - 12);
                    }
                }
                if ("com.apple.iTunes".equals(str3) && "iTunSMPB".equals(str4) && i4 != -1) {
                    zzpnVar.c(i4);
                    zzpnVar.d(16);
                    zzmkVar = new zzmj("und", str4, zzpnVar.e(i5 - 16));
                }
                return zzmkVar;
            }
            String valueOf2 = String.valueOf(azh.c(l2));
            Log.d("MetadataUtil", valueOf2.length() != 0 ? "Skipped unknown metadata entry: ".concat(valueOf2) : new String("Skipped unknown metadata entry: "));
            return null;
        } finally {
            zzpnVar.c(d2);
        }
    }

    private static zzmn a(int i2, String str, zzpn zzpnVar) {
        int l2 = zzpnVar.l();
        if (zzpnVar.l() == azh.aE) {
            zzpnVar.d(8);
            return new zzmn(str, null, zzpnVar.e(l2 - 16));
        }
        String valueOf = String.valueOf(azh.c(i2));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse text attribute: ".concat(valueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    private static zzmk a(int i2, String str, zzpn zzpnVar, boolean z2, boolean z3) {
        int b2 = b(zzpnVar);
        if (z3) {
            b2 = Math.min(1, b2);
        }
        if (b2 >= 0) {
            if (z2) {
                return new zzmn(str, null, Integer.toString(b2));
            }
            return new zzmj("und", str, Integer.toString(b2));
        }
        String valueOf = String.valueOf(azh.c(i2));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(valueOf) : new String("Failed to parse uint8 attribute: "));
        return null;
    }

    private static zzmn b(int i2, String str, zzpn zzpnVar) {
        int l2 = zzpnVar.l();
        if (zzpnVar.l() == azh.aE && l2 >= 22) {
            zzpnVar.d(10);
            int g2 = zzpnVar.g();
            if (g2 > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(g2);
                String sb2 = sb.toString();
                int g3 = zzpnVar.g();
                if (g3 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(12 + String.valueOf(valueOf).length());
                    sb3.append(valueOf);
                    sb3.append("/");
                    sb3.append(g3);
                    sb2 = sb3.toString();
                }
                return new zzmn(str, null, sb2);
            }
        }
        String valueOf2 = String.valueOf(azh.c(i2));
        Log.w("MetadataUtil", valueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(valueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    private static int b(zzpn zzpnVar) {
        zzpnVar.d(4);
        if (zzpnVar.l() == azh.aE) {
            zzpnVar.d(8);
            return zzpnVar.f();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
