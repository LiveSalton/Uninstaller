package com.google.android.gms.tasks;

/* compiled from: source */
/* loaded from: classes.dex */
public final class DuplicateTaskCompletionException extends IllegalStateException {
    private DuplicateTaskCompletionException(String str, Throwable th) {
        super(str, th);
    }

    public static IllegalStateException a(Task<?> task) {
        String str;
        if (!task.a()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception e = task.e();
        if (e != null) {
            str = "failure";
        } else if (task.b()) {
            String valueOf = String.valueOf(task.d());
            StringBuilder sb = new StringBuilder(7 + String.valueOf(valueOf).length());
            sb.append("result ");
            sb.append(valueOf);
            str = sb.toString();
        } else {
            str = task.c() ? "cancellation" : "unknown issue";
        }
        String valueOf2 = String.valueOf(str);
        return new DuplicateTaskCompletionException(valueOf2.length() != 0 ? "Complete with: ".concat(valueOf2) : new String("Complete with: "), e);
    }
}
