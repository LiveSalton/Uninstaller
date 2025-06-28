package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.a;
import androidx.appcompat.widget.v;

/* compiled from: source */
/* loaded from: classes.dex */
public final class f {
    private static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
    private static f b;
    private v c;

    public static synchronized void a() {
        synchronized (f.class) {
            if (b == null) {
                b = new f();
                b.c = v.a();
                b.c.a(new v.e() { // from class: androidx.appcompat.widget.f.1
                    private final int[] a = {a.e.abc_textfield_search_default_mtrl_alpha, a.e.abc_textfield_default_mtrl_alpha, a.e.abc_ab_share_pack_mtrl_alpha};
                    private final int[] b = {a.e.abc_ic_commit_search_api_mtrl_alpha, a.e.abc_seekbar_tick_mark_material, a.e.abc_ic_menu_share_mtrl_alpha, a.e.abc_ic_menu_copy_mtrl_am_alpha, a.e.abc_ic_menu_cut_mtrl_alpha, a.e.abc_ic_menu_selectall_mtrl_alpha, a.e.abc_ic_menu_paste_mtrl_am_alpha};
                    private final int[] c = {a.e.abc_textfield_activated_mtrl_alpha, a.e.abc_textfield_search_activated_mtrl_alpha, a.e.abc_cab_background_top_mtrl_alpha, a.e.abc_text_cursor_material, a.e.abc_text_select_handle_left_mtrl_dark, a.e.abc_text_select_handle_middle_mtrl_dark, a.e.abc_text_select_handle_right_mtrl_dark, a.e.abc_text_select_handle_left_mtrl_light, a.e.abc_text_select_handle_middle_mtrl_light, a.e.abc_text_select_handle_right_mtrl_light};
                    private final int[] d = {a.e.abc_popup_background_mtrl_mult, a.e.abc_cab_background_internal_bg, a.e.abc_menu_hardkey_panel_mtrl_mult};
                    private final int[] e = {a.e.abc_tab_indicator_material, a.e.abc_textfield_search_material};
                    private final int[] f = {a.e.abc_btn_check_material, a.e.abc_btn_radio_material, a.e.abc_btn_check_material_anim, a.e.abc_btn_radio_material_anim};

                    AnonymousClass1() {
                    }

                    private ColorStateList a(Context context) {
                        return b(context, aa.a(context, a.C0001a.colorButtonNormal));
                    }

                    private ColorStateList b(Context context) {
                        return b(context, 0);
                    }

                    private ColorStateList c(Context context) {
                        return b(context, aa.a(context, a.C0001a.colorAccent));
                    }

                    private ColorStateList b(Context context, int i) {
                        int a2 = aa.a(context, a.C0001a.colorControlHighlight);
                        return new ColorStateList(new int[][]{aa.a, aa.d, aa.b, aa.h}, new int[]{aa.c(context, a.C0001a.colorButtonNormal), androidx.core.graphics.a.a(a2, i), androidx.core.graphics.a.a(a2, i), i});
                    }

                    private ColorStateList d(Context context) {
                        int[][] iArr = new int[3][];
                        int[] iArr2 = new int[3];
                        ColorStateList b2 = aa.b(context, a.C0001a.colorSwitchThumbNormal);
                        if (b2 != null && b2.isStateful()) {
                            iArr[0] = aa.a;
                            iArr2[0] = b2.getColorForState(iArr[0], 0);
                            iArr[1] = aa.e;
                            iArr2[1] = aa.a(context, a.C0001a.colorControlActivated);
                            iArr[2] = aa.h;
                            iArr2[2] = b2.getDefaultColor();
                        } else {
                            iArr[0] = aa.a;
                            iArr2[0] = aa.c(context, a.C0001a.colorSwitchThumbNormal);
                            iArr[1] = aa.e;
                            iArr2[1] = aa.a(context, a.C0001a.colorControlActivated);
                            iArr[2] = aa.h;
                            iArr2[2] = aa.a(context, a.C0001a.colorSwitchThumbNormal);
                        }
                        return new ColorStateList(iArr, iArr2);
                    }

                    @Override // androidx.appcompat.widget.v.e
                    public Drawable a(v vVar, Context context, int i) {
                        if (i == a.e.abc_cab_background_top_material) {
                            return new LayerDrawable(new Drawable[]{vVar.a(context, a.e.abc_cab_background_internal_bg), vVar.a(context, a.e.abc_cab_background_top_mtrl_alpha)});
                        }
                        return null;
                    }

                    private void a(Drawable drawable, int i, PorterDuff.Mode mode) {
                        if (p.c(drawable)) {
                            drawable = drawable.mutate();
                        }
                        if (mode == null) {
                            mode = f.a;
                        }
                        drawable.setColorFilter(f.a(i, mode));
                    }

                    @Override // androidx.appcompat.widget.v.e
                    public boolean a(Context context, int i, Drawable drawable) {
                        if (i == a.e.abc_seekbar_track_material) {
                            LayerDrawable layerDrawable = (LayerDrawable) drawable;
                            a(layerDrawable.findDrawableByLayerId(R.id.background), aa.a(context, a.C0001a.colorControlNormal), f.a);
                            a(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), aa.a(context, a.C0001a.colorControlNormal), f.a);
                            a(layerDrawable.findDrawableByLayerId(R.id.progress), aa.a(context, a.C0001a.colorControlActivated), f.a);
                            return true;
                        }
                        if (i != a.e.abc_ratingbar_material && i != a.e.abc_ratingbar_indicator_material && i != a.e.abc_ratingbar_small_material) {
                            return false;
                        }
                        LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                        a(layerDrawable2.findDrawableByLayerId(R.id.background), aa.c(context, a.C0001a.colorControlNormal), f.a);
                        a(layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress), aa.a(context, a.C0001a.colorControlActivated), f.a);
                        a(layerDrawable2.findDrawableByLayerId(R.id.progress), aa.a(context, a.C0001a.colorControlActivated), f.a);
                        return true;
                    }

                    private boolean a(int[] iArr, int i) {
                        for (int i2 : iArr) {
                            if (i2 == i) {
                                return true;
                            }
                        }
                        return false;
                    }

                    @Override // androidx.appcompat.widget.v.e
                    public ColorStateList a(Context context, int i) {
                        if (i == a.e.abc_edit_text_material) {
                            return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_edittext);
                        }
                        if (i == a.e.abc_switch_track_mtrl_alpha) {
                            return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_switch_track);
                        }
                        if (i == a.e.abc_switch_thumb_material) {
                            return d(context);
                        }
                        if (i == a.e.abc_btn_default_mtrl_shape) {
                            return a(context);
                        }
                        if (i == a.e.abc_btn_borderless_material) {
                            return b(context);
                        }
                        if (i == a.e.abc_btn_colored_material) {
                            return c(context);
                        }
                        if (i == a.e.abc_spinner_mtrl_am_alpha || i == a.e.abc_spinner_textfield_background_material) {
                            return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_spinner);
                        }
                        if (a(this.b, i)) {
                            return aa.b(context, a.C0001a.colorControlNormal);
                        }
                        if (a(this.e, i)) {
                            return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_default);
                        }
                        if (a(this.f, i)) {
                            return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_btn_checkable);
                        }
                        if (i == a.e.abc_seekbar_thumb_material) {
                            return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_seek_thumb);
                        }
                        return null;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0062 A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0047  */
                    @Override // androidx.appcompat.widget.v.e
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public boolean b(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
                        /*
                            r6 = this;
                            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.f.c()
                            int[] r1 = r6.a
                            boolean r1 = r6.a(r1, r8)
                            r2 = 16842801(0x1010031, float:2.3693695E-38)
                            r3 = -1
                            r4 = 0
                            r5 = 1
                            if (r1 == 0) goto L17
                            int r2 = androidx.appcompat.a.C0001a.colorControlNormal
                        L14:
                            r1 = r3
                        L15:
                            r8 = r5
                            goto L45
                        L17:
                            int[] r1 = r6.c
                            boolean r1 = r6.a(r1, r8)
                            if (r1 == 0) goto L22
                            int r2 = androidx.appcompat.a.C0001a.colorControlActivated
                            goto L14
                        L22:
                            int[] r1 = r6.d
                            boolean r1 = r6.a(r1, r8)
                            if (r1 == 0) goto L2d
                            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                            goto L14
                        L2d:
                            int r1 = androidx.appcompat.a.e.abc_list_divider_mtrl_alpha
                            if (r8 != r1) goto L3d
                            r2 = 16842800(0x1010030, float:2.3693693E-38)
                            r8 = 1109603123(0x42233333, float:40.8)
                            int r8 = java.lang.Math.round(r8)
                            r1 = r8
                            goto L15
                        L3d:
                            int r1 = androidx.appcompat.a.e.abc_dialog_material_background
                            if (r8 != r1) goto L42
                            goto L14
                        L42:
                            r1 = r3
                            r8 = r4
                            r2 = r8
                        L45:
                            if (r8 == 0) goto L62
                            boolean r8 = androidx.appcompat.widget.p.c(r9)
                            if (r8 == 0) goto L51
                            android.graphics.drawable.Drawable r9 = r9.mutate()
                        L51:
                            int r7 = androidx.appcompat.widget.aa.a(r7, r2)
                            android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.f.a(r7, r0)
                            r9.setColorFilter(r7)
                            if (r1 == r3) goto L61
                            r9.setAlpha(r1)
                        L61:
                            return r5
                        L62:
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.f.AnonymousClass1.b(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
                    }

                    @Override // androidx.appcompat.widget.v.e
                    public PorterDuff.Mode a(int i) {
                        if (i == a.e.abc_switch_thumb_material) {
                            return PorterDuff.Mode.MULTIPLY;
                        }
                        return null;
                    }
                });
            }
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.widget.f$1 */
    class AnonymousClass1 implements v.e {
        private final int[] a = {a.e.abc_textfield_search_default_mtrl_alpha, a.e.abc_textfield_default_mtrl_alpha, a.e.abc_ab_share_pack_mtrl_alpha};
        private final int[] b = {a.e.abc_ic_commit_search_api_mtrl_alpha, a.e.abc_seekbar_tick_mark_material, a.e.abc_ic_menu_share_mtrl_alpha, a.e.abc_ic_menu_copy_mtrl_am_alpha, a.e.abc_ic_menu_cut_mtrl_alpha, a.e.abc_ic_menu_selectall_mtrl_alpha, a.e.abc_ic_menu_paste_mtrl_am_alpha};
        private final int[] c = {a.e.abc_textfield_activated_mtrl_alpha, a.e.abc_textfield_search_activated_mtrl_alpha, a.e.abc_cab_background_top_mtrl_alpha, a.e.abc_text_cursor_material, a.e.abc_text_select_handle_left_mtrl_dark, a.e.abc_text_select_handle_middle_mtrl_dark, a.e.abc_text_select_handle_right_mtrl_dark, a.e.abc_text_select_handle_left_mtrl_light, a.e.abc_text_select_handle_middle_mtrl_light, a.e.abc_text_select_handle_right_mtrl_light};
        private final int[] d = {a.e.abc_popup_background_mtrl_mult, a.e.abc_cab_background_internal_bg, a.e.abc_menu_hardkey_panel_mtrl_mult};
        private final int[] e = {a.e.abc_tab_indicator_material, a.e.abc_textfield_search_material};
        private final int[] f = {a.e.abc_btn_check_material, a.e.abc_btn_radio_material, a.e.abc_btn_check_material_anim, a.e.abc_btn_radio_material_anim};

        AnonymousClass1() {
        }

        private ColorStateList a(Context context) {
            return b(context, aa.a(context, a.C0001a.colorButtonNormal));
        }

        private ColorStateList b(Context context) {
            return b(context, 0);
        }

        private ColorStateList c(Context context) {
            return b(context, aa.a(context, a.C0001a.colorAccent));
        }

        private ColorStateList b(Context context, int i) {
            int a2 = aa.a(context, a.C0001a.colorControlHighlight);
            return new ColorStateList(new int[][]{aa.a, aa.d, aa.b, aa.h}, new int[]{aa.c(context, a.C0001a.colorButtonNormal), androidx.core.graphics.a.a(a2, i), androidx.core.graphics.a.a(a2, i), i});
        }

        private ColorStateList d(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            ColorStateList b2 = aa.b(context, a.C0001a.colorSwitchThumbNormal);
            if (b2 != null && b2.isStateful()) {
                iArr[0] = aa.a;
                iArr2[0] = b2.getColorForState(iArr[0], 0);
                iArr[1] = aa.e;
                iArr2[1] = aa.a(context, a.C0001a.colorControlActivated);
                iArr[2] = aa.h;
                iArr2[2] = b2.getDefaultColor();
            } else {
                iArr[0] = aa.a;
                iArr2[0] = aa.c(context, a.C0001a.colorSwitchThumbNormal);
                iArr[1] = aa.e;
                iArr2[1] = aa.a(context, a.C0001a.colorControlActivated);
                iArr[2] = aa.h;
                iArr2[2] = aa.a(context, a.C0001a.colorSwitchThumbNormal);
            }
            return new ColorStateList(iArr, iArr2);
        }

        @Override // androidx.appcompat.widget.v.e
        public Drawable a(v vVar, Context context, int i) {
            if (i == a.e.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{vVar.a(context, a.e.abc_cab_background_internal_bg), vVar.a(context, a.e.abc_cab_background_top_mtrl_alpha)});
            }
            return null;
        }

        private void a(Drawable drawable, int i, PorterDuff.Mode mode) {
            if (p.c(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = f.a;
            }
            drawable.setColorFilter(f.a(i, mode));
        }

        @Override // androidx.appcompat.widget.v.e
        public boolean a(Context context, int i, Drawable drawable) {
            if (i == a.e.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                a(layerDrawable.findDrawableByLayerId(R.id.background), aa.a(context, a.C0001a.colorControlNormal), f.a);
                a(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), aa.a(context, a.C0001a.colorControlNormal), f.a);
                a(layerDrawable.findDrawableByLayerId(R.id.progress), aa.a(context, a.C0001a.colorControlActivated), f.a);
                return true;
            }
            if (i != a.e.abc_ratingbar_material && i != a.e.abc_ratingbar_indicator_material && i != a.e.abc_ratingbar_small_material) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            a(layerDrawable2.findDrawableByLayerId(R.id.background), aa.c(context, a.C0001a.colorControlNormal), f.a);
            a(layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress), aa.a(context, a.C0001a.colorControlActivated), f.a);
            a(layerDrawable2.findDrawableByLayerId(R.id.progress), aa.a(context, a.C0001a.colorControlActivated), f.a);
            return true;
        }

        private boolean a(int[] iArr, int i) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.appcompat.widget.v.e
        public ColorStateList a(Context context, int i) {
            if (i == a.e.abc_edit_text_material) {
                return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_edittext);
            }
            if (i == a.e.abc_switch_track_mtrl_alpha) {
                return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_switch_track);
            }
            if (i == a.e.abc_switch_thumb_material) {
                return d(context);
            }
            if (i == a.e.abc_btn_default_mtrl_shape) {
                return a(context);
            }
            if (i == a.e.abc_btn_borderless_material) {
                return b(context);
            }
            if (i == a.e.abc_btn_colored_material) {
                return c(context);
            }
            if (i == a.e.abc_spinner_mtrl_am_alpha || i == a.e.abc_spinner_textfield_background_material) {
                return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_spinner);
            }
            if (a(this.b, i)) {
                return aa.b(context, a.C0001a.colorControlNormal);
            }
            if (a(this.e, i)) {
                return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_default);
            }
            if (a(this.f, i)) {
                return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_btn_checkable);
            }
            if (i == a.e.abc_seekbar_thumb_material) {
                return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_seek_thumb);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.v.e
        public boolean b(Context context, int i, Drawable drawable) {
            /*
                this = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.f.c()
                int[] r1 = r6.a
                boolean r1 = r6.a(r1, r8)
                r2 = 16842801(0x1010031, float:2.3693695E-38)
                r3 = -1
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L17
                int r2 = androidx.appcompat.a.C0001a.colorControlNormal
            L14:
                r1 = r3
            L15:
                r8 = r5
                goto L45
            L17:
                int[] r1 = r6.c
                boolean r1 = r6.a(r1, r8)
                if (r1 == 0) goto L22
                int r2 = androidx.appcompat.a.C0001a.colorControlActivated
                goto L14
            L22:
                int[] r1 = r6.d
                boolean r1 = r6.a(r1, r8)
                if (r1 == 0) goto L2d
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                goto L14
            L2d:
                int r1 = androidx.appcompat.a.e.abc_list_divider_mtrl_alpha
                if (r8 != r1) goto L3d
                r2 = 16842800(0x1010030, float:2.3693693E-38)
                r8 = 1109603123(0x42233333, float:40.8)
                int r8 = java.lang.Math.round(r8)
                r1 = r8
                goto L15
            L3d:
                int r1 = androidx.appcompat.a.e.abc_dialog_material_background
                if (r8 != r1) goto L42
                goto L14
            L42:
                r1 = r3
                r8 = r4
                r2 = r8
            L45:
                if (r8 == 0) goto L62
                boolean r8 = androidx.appcompat.widget.p.c(r9)
                if (r8 == 0) goto L51
                android.graphics.drawable.Drawable r9 = r9.mutate()
            L51:
                int r7 = androidx.appcompat.widget.aa.a(r7, r2)
                android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.f.a(r7, r0)
                r9.setColorFilter(r7)
                if (r1 == r3) goto L61
                r9.setAlpha(r1)
            L61:
                return r5
            L62:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.f.AnonymousClass1.b(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        @Override // androidx.appcompat.widget.v.e
        public PorterDuff.Mode a(int i) {
            if (i == a.e.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }
    }

    public static synchronized f b() {
        f fVar;
        synchronized (f.class) {
            if (b == null) {
                a();
            }
            fVar = b;
        }
        return fVar;
    }

    public synchronized Drawable a(Context context, int i) {
        return this.c.a(context, i);
    }

    synchronized Drawable a(Context context, int i, boolean z) {
        return this.c.a(context, i, z);
    }

    public synchronized void a(Context context) {
        this.c.a(context);
    }

    synchronized ColorStateList b(Context context, int i) {
        return this.c.b(context, i);
    }

    static void a(Drawable drawable, ad adVar, int[] iArr) {
        v.a(drawable, adVar, iArr);
    }

    public static synchronized PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2;
        synchronized (f.class) {
            a2 = v.a(i, mode);
        }
        return a2;
    }
}
