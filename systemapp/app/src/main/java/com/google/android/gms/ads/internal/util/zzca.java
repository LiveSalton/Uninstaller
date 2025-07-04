package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.util.Range;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzca {
    private static List<MediaCodecInfo> b;
    private static Map<String, List<Map<String, Object>>> a = new HashMap();
    private static final Object c = new Object();

    @TargetApi(16)
    public static List<Map<String, Object>> a(String str) {
        synchronized (c) {
            if (a.containsKey(str)) {
                return a.get(str);
            }
            try {
                synchronized (c) {
                    if (b == null) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            b = Arrays.asList(new MediaCodecList(0).getCodecInfos());
                        } else {
                            int codecCount = MediaCodecList.getCodecCount();
                            b = new ArrayList(codecCount);
                            for (int i = 0; i < codecCount; i++) {
                                b.add(MediaCodecList.getCodecInfoAt(i));
                            }
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (MediaCodecInfo mediaCodecInfo : b) {
                    if (!mediaCodecInfo.isEncoder() && Arrays.asList(mediaCodecInfo.getSupportedTypes()).contains(str)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("codecName", mediaCodecInfo.getName());
                        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                        ArrayList arrayList2 = new ArrayList();
                        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : capabilitiesForType.profileLevels) {
                            arrayList2.add(new Integer[]{Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level)});
                        }
                        hashMap.put("profileLevels", arrayList2);
                        if (Build.VERSION.SDK_INT >= 21) {
                            MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                            hashMap.put("bitRatesBps", a(videoCapabilities.getBitrateRange()));
                            hashMap.put("widthAlignment", Integer.valueOf(videoCapabilities.getWidthAlignment()));
                            hashMap.put("heightAlignment", Integer.valueOf(videoCapabilities.getHeightAlignment()));
                            hashMap.put("frameRates", a(videoCapabilities.getSupportedFrameRates()));
                            hashMap.put("widths", a(videoCapabilities.getSupportedWidths()));
                            hashMap.put("heights", a(videoCapabilities.getSupportedHeights()));
                        }
                        if (Build.VERSION.SDK_INT >= 23) {
                            hashMap.put("instancesLimit", Integer.valueOf(capabilitiesForType.getMaxSupportedInstances()));
                        }
                        arrayList.add(hashMap);
                    }
                }
                a.put(str, arrayList);
                return arrayList;
            } catch (LinkageError | RuntimeException e) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("error", e.getClass().getSimpleName());
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(hashMap2);
                a.put(str, arrayList3);
                return arrayList3;
            }
        }
    }

    @TargetApi(21)
    private static Integer[] a(Range<Integer> range) {
        return new Integer[]{range.getLower(), range.getUpper()};
    }
}
