package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
class azh {
    public final int aO;
    public static final int a = zzpt.c("ftyp");
    public static final int b = zzpt.c("avc1");
    public static final int c = zzpt.c("avc3");
    public static final int d = zzpt.c("hvc1");
    public static final int e = zzpt.c("hev1");
    public static final int f = zzpt.c("s263");
    public static final int g = zzpt.c("d263");
    public static final int h = zzpt.c("mdat");
    public static final int i = zzpt.c("mp4a");
    public static final int j = zzpt.c(".mp3");
    public static final int k = zzpt.c("wave");
    public static final int l = zzpt.c("lpcm");
    public static final int m = zzpt.c("sowt");
    public static final int n = zzpt.c("ac-3");
    public static final int o = zzpt.c("dac3");
    public static final int p = zzpt.c("ec-3");
    public static final int q = zzpt.c("dec3");
    public static final int r = zzpt.c("dtsc");
    public static final int s = zzpt.c("dtsh");
    public static final int t = zzpt.c("dtsl");
    public static final int u = zzpt.c("dtse");
    public static final int v = zzpt.c("ddts");
    public static final int w = zzpt.c("tfdt");
    public static final int x = zzpt.c("tfhd");
    public static final int y = zzpt.c("trex");
    public static final int z = zzpt.c("trun");
    public static final int A = zzpt.c("sidx");
    public static final int B = zzpt.c("moov");
    public static final int C = zzpt.c("mvhd");
    public static final int D = zzpt.c("trak");
    public static final int E = zzpt.c("mdia");
    public static final int F = zzpt.c("minf");
    public static final int G = zzpt.c("stbl");
    public static final int H = zzpt.c("avcC");
    public static final int I = zzpt.c("hvcC");
    public static final int J = zzpt.c("esds");
    public static final int K = zzpt.c("moof");
    public static final int L = zzpt.c("traf");
    public static final int M = zzpt.c("mvex");
    public static final int N = zzpt.c("mehd");
    public static final int O = zzpt.c("tkhd");
    public static final int P = zzpt.c("edts");
    public static final int Q = zzpt.c("elst");
    public static final int R = zzpt.c("mdhd");
    public static final int S = zzpt.c("hdlr");
    public static final int T = zzpt.c("stsd");
    public static final int U = zzpt.c("pssh");
    public static final int V = zzpt.c("sinf");
    public static final int W = zzpt.c("schm");
    public static final int X = zzpt.c("schi");
    public static final int Y = zzpt.c("tenc");
    public static final int Z = zzpt.c("encv");
    public static final int aa = zzpt.c("enca");
    public static final int ab = zzpt.c("frma");
    public static final int ac = zzpt.c("saiz");
    public static final int ad = zzpt.c("saio");
    public static final int ae = zzpt.c("sbgp");
    public static final int af = zzpt.c("sgpd");
    public static final int ag = zzpt.c("uuid");
    public static final int ah = zzpt.c("senc");
    public static final int ai = zzpt.c("pasp");
    public static final int aj = zzpt.c("TTML");
    private static final int aP = zzpt.c("vmhd");
    public static final int ak = zzpt.c("mp4v");
    public static final int al = zzpt.c("stts");
    public static final int am = zzpt.c("stss");
    public static final int an = zzpt.c("ctts");
    public static final int ao = zzpt.c("stsc");
    public static final int ap = zzpt.c("stsz");
    public static final int aq = zzpt.c("stz2");
    public static final int ar = zzpt.c("stco");
    public static final int as = zzpt.c("co64");
    public static final int at = zzpt.c("tx3g");
    public static final int au = zzpt.c("wvtt");
    public static final int av = zzpt.c("stpp");
    public static final int aw = zzpt.c("c608");
    public static final int ax = zzpt.c("samr");
    public static final int ay = zzpt.c("sawb");
    public static final int az = zzpt.c("udta");
    public static final int aA = zzpt.c("meta");
    public static final int aB = zzpt.c("ilst");
    public static final int aC = zzpt.c("mean");
    public static final int aD = zzpt.c("name");
    public static final int aE = zzpt.c("data");
    public static final int aF = zzpt.c("emsg");
    public static final int aG = zzpt.c("st3d");
    public static final int aH = zzpt.c("sv3d");
    public static final int aI = zzpt.c("proj");
    public static final int aJ = zzpt.c("vp08");
    public static final int aK = zzpt.c("vp09");
    public static final int aL = zzpt.c("vpcC");
    public static final int aM = zzpt.c("camm");
    public static final int aN = zzpt.c("alac");

    public azh(int i2) {
        this.aO = i2;
    }

    public static int a(int i2) {
        return (i2 >> 24) & 255;
    }

    public static int b(int i2) {
        return i2 & 16777215;
    }

    public String toString() {
        return c(this.aO);
    }

    public static String c(int i2) {
        StringBuilder sb = new StringBuilder(4);
        sb.append((char) (i2 >>> 24));
        sb.append((char) ((i2 >> 16) & 255));
        sb.append((char) ((i2 >> 8) & 255));
        sb.append((char) (i2 & 255));
        return sb.toString();
    }
}
