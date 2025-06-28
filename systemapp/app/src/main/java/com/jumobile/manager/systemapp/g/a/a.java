package com.jumobile.manager.systemapp.g.a;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ImageView;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public class a {
    private static final String c = "a";
    public ImageView a;
    final c b;
    private InterfaceC0088a d;
    private com.jumobile.manager.systemapp.c.c e;
    private b f;

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.g.a.a$a */
    public interface InterfaceC0088a {
        void a();

        void b();
    }

    public void a() {
        this.e.a(this.b);
    }

    public void b() {
        this.a.setImageDrawable(this.e.a(this.f.a, 0));
    }

    /* compiled from: source */
    class c extends Handler {
        final /* synthetic */ a a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.a.b();
                    break;
                case 2:
                    String str = (String) message.obj;
                    if (TextUtils.isEmpty(str)) {
                        if (this.a.d != null) {
                            this.a.d.b();
                            break;
                        }
                    } else {
                        try {
                            this.a.f.a(new JSONObject(str));
                            if (this.a.d != null) {
                                this.a.d.a();
                                break;
                            }
                        } catch (Exception unused) {
                            if (this.a.d != null) {
                                this.a.d.b();
                                return;
                            }
                            return;
                        }
                    }
                    break;
            }
        }
    }

    /* compiled from: source */
    public class b {
        private String a;
        private String b;

        public void a(JSONObject jSONObject) throws JSONException {
            this.a = jSONObject.getString("image_url");
            this.b = jSONObject.getString("page_url");
        }
    }
}
