package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: source */
@TargetApi(14)
/* loaded from: classes.dex */
public final class zzbac extends zzbap implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private static final Map<Integer, String> c = new HashMap();
    private final zzbbe d;
    private final zzbbh e;
    private final boolean f;
    private int g;
    private int h;
    private MediaPlayer i;
    private Uri j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private zzbbc p;
    private boolean q;
    private int r;
    private zzbam s;
    private Integer t;

    public zzbac(Context context, zzbbe zzbbeVar, boolean z, boolean z2, zzbbf zzbbfVar, zzbbh zzbbhVar) {
        super(context);
        this.g = 0;
        this.h = 0;
        this.t = null;
        setSurfaceTextureListener(this);
        this.d = zzbbeVar;
        this.e = zzbbhVar;
        this.q = z;
        this.f = z2;
        this.e.a(this);
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final long f() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final String a() {
        String valueOf = String.valueOf(this.q ? " spherical" : "");
        return valueOf.length() != 0 ? "MediaPlayer".concat(valueOf) : new String("MediaPlayer");
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final void a(zzbam zzbamVar) {
        this.s = zzbamVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        zztf a = zztf.a(parse);
        if (a == null || a.a != null) {
            if (a != null) {
                parse = Uri.parse(a.a);
            }
            this.j = parse;
            this.r = 0;
            i();
            requestLayout();
            invalidate();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final void b() {
        zzd.a("AdMediaPlayerView stop");
        if (this.i != null) {
            this.i.stop();
            this.i.release();
            this.i = null;
            h(0);
            this.h = 0;
        }
        this.e.b();
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdMediaPlayerView size changed: ");
        sb.append(i);
        sb.append(" x ");
        sb.append(i2);
        zzd.a(sb.toString());
        this.k = mediaPlayer.getVideoWidth();
        this.l = mediaPlayer.getVideoHeight();
        if (this.k == 0 || this.l == 0) {
            return;
        }
        requestLayout();
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        zzd.a("AdMediaPlayerView prepared");
        h(2);
        this.e.a();
        com.google.android.gms.ads.internal.util.zzm.a.post(new fz(this, mediaPlayer));
        this.k = mediaPlayer.getVideoWidth();
        this.l = mediaPlayer.getVideoHeight();
        if (this.r != 0) {
            a(this.r);
        }
        j();
        int i = this.k;
        int i2 = this.l;
        StringBuilder sb = new StringBuilder(62);
        sb.append("AdMediaPlayerView stream dimensions: ");
        sb.append(i);
        sb.append(" x ");
        sb.append(i2);
        zzd.d(sb.toString());
        if (this.h == 3) {
            c();
        }
        h();
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        zzd.a("AdMediaPlayerView completion");
        h(5);
        this.h = 5;
        com.google.android.gms.ads.internal.util.zzm.a.post(new gc(this));
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = c.get(Integer.valueOf(i));
        String str2 = c.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(37 + String.valueOf(str).length() + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer info: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzd.a(sb.toString());
        return true;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = c.get(Integer.valueOf(i));
        String str2 = c.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(38 + String.valueOf(str).length() + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer error: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzd.e(sb.toString());
        h(-1);
        this.h = -1;
        com.google.android.gms.ads.internal.util.zzm.a.post(new gb(this, str, str2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.m = i;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzd.a("AdMediaPlayerView surface created");
        i();
        com.google.android.gms.ads.internal.util.zzm.a.post(new ge(this));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzd.a("AdMediaPlayerView surface changed");
        boolean z = false;
        boolean z2 = this.h == 3;
        if (this.k == i && this.l == i2) {
            z = true;
        }
        if (this.i != null && z2 && z) {
            if (this.r != 0) {
                a(this.r);
            }
            c();
        }
        if (this.p != null) {
            this.p.a(i, i2);
        }
        com.google.android.gms.ads.internal.util.zzm.a.post(new gd(this, i, i2));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzd.a("AdMediaPlayerView surface destroyed");
        if (this.i != null && this.r == 0) {
            this.r = this.i.getCurrentPosition();
        }
        if (this.p != null) {
            this.p.a();
        }
        com.google.android.gms.ads.internal.util.zzm.a.post(new gg(this));
        a(true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.e.b(this);
        this.a.a(surfaceTexture, this.s);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(58);
        sb.append("AdMediaPlayerView window visibility changed to ");
        sb.append(i);
        zzd.a(sb.toString());
        com.google.android.gms.ads.internal.util.zzm.a.post(new Runnable(this, i) { // from class: com.google.android.gms.internal.ads.ga
            private final zzbac a;
            private final int b;

            {
                this.a = this;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.b(this.b);
            }
        });
        super.onWindowVisibilityChanged(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x006a, code lost:
    
        if (r1 > r6) goto L97;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.k
            int r0 = getDefaultSize(r0, r6)
            int r1 = r5.l
            int r1 = getDefaultSize(r1, r7)
            int r2 = r5.k
            if (r2 <= 0) goto L8c
            int r2 = r5.l
            if (r2 <= 0) goto L8c
            com.google.android.gms.internal.ads.zzbbc r2 = r5.p
            if (r2 != 0) goto L8c
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L4f
            if (r1 != r2) goto L4f
            int r0 = r5.k
            int r0 = r0 * r7
            int r1 = r5.l
            int r1 = r1 * r6
            if (r0 >= r1) goto L3f
            int r6 = r5.k
            int r6 = r6 * r7
            int r0 = r5.l
            int r0 = r6 / r0
            r6 = r0
            goto L8e
        L3f:
            int r0 = r5.k
            int r0 = r0 * r7
            int r1 = r5.l
            int r1 = r1 * r6
            if (r0 <= r1) goto L8e
            int r7 = r5.l
            int r7 = r7 * r6
            int r0 = r5.k
            int r1 = r7 / r0
            goto L8d
        L4f:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L60
            int r0 = r5.l
            int r0 = r0 * r6
            int r2 = r5.k
            int r0 = r0 / r2
            if (r1 != r3) goto L5e
            if (r0 <= r7) goto L5e
            goto L8e
        L5e:
            r7 = r0
            goto L8e
        L60:
            if (r1 != r2) goto L6f
            int r1 = r5.k
            int r1 = r1 * r7
            int r2 = r5.l
            int r1 = r1 / r2
            if (r0 != r3) goto L6d
            if (r1 <= r6) goto L6d
            goto L8e
        L6d:
            r6 = r1
            goto L8e
        L6f:
            int r2 = r5.k
            int r4 = r5.l
            if (r1 != r3) goto L7e
            if (r4 <= r7) goto L7e
            int r1 = r5.k
            int r1 = r1 * r7
            int r2 = r5.l
            int r1 = r1 / r2
            goto L80
        L7e:
            r1 = r2
            r7 = r4
        L80:
            if (r0 != r3) goto L6d
            if (r1 <= r6) goto L6d
            int r7 = r5.l
            int r7 = r7 * r6
            int r0 = r5.k
            int r1 = r7 / r0
            goto L8d
        L8c:
            r6 = r0
        L8d:
            r7 = r1
        L8e:
            r5.setMeasuredDimension(r6, r7)
            com.google.android.gms.internal.ads.zzbbc r0 = r5.p
            if (r0 == 0) goto L9a
            com.google.android.gms.internal.ads.zzbbc r0 = r5.p
            r0.a(r6, r7)
        L9a:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 16
            if (r0 != r1) goto Lb7
            int r0 = r5.n
            if (r0 <= 0) goto La8
            int r0 = r5.n
            if (r0 != r6) goto Lb0
        La8:
            int r0 = r5.o
            if (r0 <= 0) goto Lb3
            int r0 = r5.o
            if (r0 == r7) goto Lb3
        Lb0:
            r5.j()
        Lb3:
            r5.n = r6
            r5.o = r7
        Lb7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbac.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public final String toString() {
        String name = getClass().getName();
        String hexString = Integer.toHexString(hashCode());
        StringBuilder sb = new StringBuilder(1 + String.valueOf(name).length() + String.valueOf(hexString).length());
        sb.append(name);
        sb.append("@");
        sb.append(hexString);
        return sb.toString();
    }

    private final void i() {
        zzd.a("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.j == null || surfaceTexture == null) {
            return;
        }
        a(false);
        try {
            zzp.s();
            this.i = new MediaPlayer();
            this.i.setOnBufferingUpdateListener(this);
            this.i.setOnCompletionListener(this);
            this.i.setOnErrorListener(this);
            this.i.setOnInfoListener(this);
            this.i.setOnPreparedListener(this);
            this.i.setOnVideoSizeChangedListener(this);
            this.m = 0;
            if (this.q) {
                this.p = new zzbbc(getContext());
                this.p.a(surfaceTexture, getWidth(), getHeight());
                this.p.start();
                SurfaceTexture b = this.p.b();
                if (b != null) {
                    surfaceTexture = b;
                } else {
                    this.p.a();
                    this.p = null;
                }
            }
            this.i.setDataSource(getContext(), this.j);
            zzp.t();
            this.i.setSurface(new Surface(surfaceTexture));
            this.i.setAudioStreamType(3);
            this.i.setScreenOnWhilePlaying(true);
            this.i.prepareAsync();
            h(1);
        } catch (IOException | IllegalArgumentException | IllegalStateException e) {
            String valueOf = String.valueOf(this.j);
            StringBuilder sb = new StringBuilder(36 + String.valueOf(valueOf).length());
            sb.append("Failed to initialize MediaPlayer at ");
            sb.append(valueOf);
            zzd.d(sb.toString(), e);
            onError(this.i, 1, 0);
        }
    }

    private final void j() {
        if (this.f && k() && this.i.getCurrentPosition() > 0 && this.h != 3) {
            zzd.a("AdMediaPlayerView nudging MediaPlayer");
            a(0.0f);
            this.i.start();
            int currentPosition = this.i.getCurrentPosition();
            long a = zzp.j().a();
            while (k() && this.i.getCurrentPosition() == currentPosition && zzp.j().a() - a <= 250) {
            }
            this.i.pause();
            h();
        }
    }

    private final void a(boolean z) {
        zzd.a("AdMediaPlayerView release");
        if (this.p != null) {
            this.p.a();
            this.p = null;
        }
        if (this.i != null) {
            this.i.reset();
            this.i.release();
            this.i = null;
            h(0);
            if (z) {
                this.h = 0;
                this.h = 0;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final void c() {
        zzd.a("AdMediaPlayerView play");
        if (k()) {
            this.i.start();
            h(3);
            this.a.a();
            com.google.android.gms.ads.internal.util.zzm.a.post(new gf(this));
        }
        this.h = 3;
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final void d() {
        zzd.a("AdMediaPlayerView pause");
        if (k() && this.i.isPlaying()) {
            this.i.pause();
            h(4);
            com.google.android.gms.ads.internal.util.zzm.a.post(new gh(this));
        }
        this.h = 4;
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final int getDuration() {
        if (k()) {
            return this.i.getDuration();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final int getCurrentPosition() {
        if (k()) {
            return this.i.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final void a(int i) {
        StringBuilder sb = new StringBuilder(34);
        sb.append("AdMediaPlayerView seek ");
        sb.append(i);
        zzd.a(sb.toString());
        if (k()) {
            this.i.seekTo(i);
            this.r = 0;
        } else {
            this.r = i;
        }
    }

    private final boolean k() {
        return (this.i == null || this.g == -1 || this.g == 0 || this.g == 1) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final void a(float f, float f2) {
        if (this.p != null) {
            this.p.a(f, f2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final int getVideoWidth() {
        if (this.i != null) {
            return this.i.getVideoWidth();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final int getVideoHeight() {
        if (this.i != null) {
            return this.i.getVideoHeight();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final long e() {
        if (this.t != null) {
            return (getTotalBytes() * this.m) / 100;
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final long getTotalBytes() {
        if (this.t != null) {
            return getDuration() * this.t.intValue();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzbap
    public final int g() {
        if (Build.VERSION.SDK_INT < 26 || !k()) {
            return -1;
        }
        return this.i.getMetrics().getInt("android.media.mediaplayer.dropped");
    }

    @Override // com.google.android.gms.internal.ads.zzbap, com.google.android.gms.internal.ads.gs
    public final void h() {
        a(this.b.a());
    }

    private final void a(float f) {
        if (this.i != null) {
            try {
                this.i.setVolume(f, f);
            } catch (IllegalStateException unused) {
            }
        } else {
            zzd.e("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    public final void a(MediaPlayer mediaPlayer) {
        MediaPlayer.TrackInfo[] trackInfo;
        if (!((Boolean) zzwq.e().a(zzabf.aW)).booleanValue() || this.d == null || mediaPlayer == null || Build.VERSION.SDK_INT < 19 || (trackInfo = mediaPlayer.getTrackInfo()) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (MediaPlayer.TrackInfo trackInfo2 : trackInfo) {
            if (trackInfo2 != null) {
                switch (trackInfo2.getTrackType()) {
                    case 1:
                        MediaFormat format = trackInfo2.getFormat();
                        if (format == null) {
                            break;
                        } else {
                            if (format.containsKey("frame-rate")) {
                                try {
                                    hashMap.put("frameRate", String.valueOf(format.getFloat("frame-rate")));
                                } catch (ClassCastException unused) {
                                    hashMap.put("frameRate", String.valueOf(format.getInteger("frame-rate")));
                                }
                            }
                            if (format.containsKey("bitrate")) {
                                this.t = Integer.valueOf(format.getInteger("bitrate"));
                                hashMap.put("bitRate", String.valueOf(this.t));
                            }
                            if (format.containsKey("width") && format.containsKey("height")) {
                                int integer = format.getInteger("width");
                                int integer2 = format.getInteger("height");
                                StringBuilder sb = new StringBuilder(23);
                                sb.append(integer);
                                sb.append("x");
                                sb.append(integer2);
                                hashMap.put("resolution", sb.toString());
                            }
                            if (format.containsKey("mime")) {
                                hashMap.put("videoMime", format.getString("mime"));
                            }
                            if (Build.VERSION.SDK_INT >= 30 && format.containsKey("codecs-string")) {
                                hashMap.put("videoCodec", format.getString("codecs-string"));
                                break;
                            }
                        }
                        break;
                    case 2:
                        MediaFormat format2 = trackInfo2.getFormat();
                        if (format2 == null) {
                            break;
                        } else {
                            if (format2.containsKey("mime")) {
                                hashMap.put("audioMime", format2.getString("mime"));
                            }
                            if (Build.VERSION.SDK_INT >= 30 && format2.containsKey("codecs-string")) {
                                hashMap.put("audioCodec", format2.getString("codecs-string"));
                                break;
                            }
                        }
                        break;
                }
            }
        }
        if (hashMap.isEmpty()) {
            return;
        }
        this.d.a("onMetadataEvent", hashMap);
    }

    private final void h(int i) {
        if (i == 3) {
            this.e.c();
            this.b.b();
        } else if (this.g == 3) {
            this.e.d();
            this.b.c();
        }
        this.g = i;
    }

    final /* synthetic */ void b(int i) {
        if (this.s != null) {
            this.s.onWindowVisibilityChanged(i);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            c.put(-1004, "MEDIA_ERROR_IO");
            c.put(-1007, "MEDIA_ERROR_MALFORMED");
            c.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
            c.put(-110, "MEDIA_ERROR_TIMED_OUT");
            c.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        c.put(100, "MEDIA_ERROR_SERVER_DIED");
        c.put(1, "MEDIA_ERROR_UNKNOWN");
        c.put(1, "MEDIA_INFO_UNKNOWN");
        c.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        c.put(701, "MEDIA_INFO_BUFFERING_START");
        c.put(702, "MEDIA_INFO_BUFFERING_END");
        c.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        c.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        c.put(802, "MEDIA_INFO_METADATA_UPDATE");
        if (Build.VERSION.SDK_INT >= 19) {
            c.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            c.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }
}
