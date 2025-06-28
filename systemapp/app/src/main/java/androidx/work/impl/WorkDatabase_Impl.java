package androidx.work.impl;

import androidx.g.a.c;
import androidx.room.b.d;
import androidx.room.i;
import androidx.room.k;
import androidx.work.impl.b.k;
import androidx.work.impl.b.l;
import androidx.work.impl.b.n;
import androidx.work.impl.b.o;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: source */
/* loaded from: classes.dex */
public final class WorkDatabase_Impl extends WorkDatabase {
    private volatile k d;
    private volatile androidx.work.impl.b.b e;
    private volatile n f;
    private volatile androidx.work.impl.b.e g;
    private volatile androidx.work.impl.b.h h;

    /* compiled from: source */
    /* renamed from: androidx.work.impl.WorkDatabase_Impl$1 */
    class AnonymousClass1 extends k.a {
        @Override // androidx.room.k.a
        public void g(androidx.g.a.b bVar) {
        }

        AnonymousClass1(int i) {
            super(i);
        }

        @Override // androidx.room.k.a
        public void b(androidx.g.a.b bVar) {
            bVar.c("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.c("CREATE  INDEX `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
            bVar.c("CREATE  INDEX `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
            bVar.c("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
            bVar.c("CREATE  INDEX `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
            bVar.c("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.c("CREATE  INDEX `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
            bVar.c("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.c("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.c("CREATE  INDEX `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
            bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            bVar.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c84d23ade98552f1cec71088c1f0794c')");
        }

        @Override // androidx.room.k.a
        public void a(androidx.g.a.b bVar) {
            bVar.c("DROP TABLE IF EXISTS `Dependency`");
            bVar.c("DROP TABLE IF EXISTS `WorkSpec`");
            bVar.c("DROP TABLE IF EXISTS `WorkTag`");
            bVar.c("DROP TABLE IF EXISTS `SystemIdInfo`");
            bVar.c("DROP TABLE IF EXISTS `WorkName`");
        }

        @Override // androidx.room.k.a
        protected void d(androidx.g.a.b bVar) {
            if (WorkDatabase_Impl.this.c != null) {
                int size = WorkDatabase_Impl.this.c.size();
                for (int i = 0; i < size; i++) {
                    ((i.b) WorkDatabase_Impl.this.c.get(i)).a(bVar);
                }
            }
        }

        @Override // androidx.room.k.a
        public void c(androidx.g.a.b bVar) {
            WorkDatabase_Impl.this.a = bVar;
            bVar.c("PRAGMA foreign_keys = ON");
            WorkDatabase_Impl.this.a(bVar);
            if (WorkDatabase_Impl.this.c != null) {
                int size = WorkDatabase_Impl.this.c.size();
                for (int i = 0; i < size; i++) {
                    ((i.b) WorkDatabase_Impl.this.c.get(i)).b(bVar);
                }
            }
        }

        @Override // androidx.room.k.a
        public void f(androidx.g.a.b bVar) {
            androidx.room.b.b.a(bVar);
        }

        @Override // androidx.room.k.a
        protected void e(androidx.g.a.b bVar) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("work_spec_id", new d.a("work_spec_id", "TEXT", true, 1));
            hashMap.put("prerequisite_id", new d.a("prerequisite_id", "TEXT", true, 2));
            HashSet hashSet = new HashSet(2);
            hashSet.add(new d.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            hashSet.add(new d.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
            HashSet hashSet2 = new HashSet(2);
            hashSet2.add(new d.C0043d("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id")));
            hashSet2.add(new d.C0043d("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id")));
            androidx.room.b.d dVar = new androidx.room.b.d("Dependency", hashMap, hashSet, hashSet2);
            androidx.room.b.d a = androidx.room.b.d.a(bVar, "Dependency");
            if (!dVar.equals(a)) {
                throw new IllegalStateException("Migration didn't properly handle Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + dVar + "\n Found:\n" + a);
            }
            HashMap hashMap2 = new HashMap(23);
            hashMap2.put("id", new d.a("id", "TEXT", true, 1));
            hashMap2.put("state", new d.a("state", "INTEGER", true, 0));
            hashMap2.put("worker_class_name", new d.a("worker_class_name", "TEXT", true, 0));
            hashMap2.put("input_merger_class_name", new d.a("input_merger_class_name", "TEXT", false, 0));
            hashMap2.put("input", new d.a("input", "BLOB", true, 0));
            hashMap2.put("output", new d.a("output", "BLOB", true, 0));
            hashMap2.put("initial_delay", new d.a("initial_delay", "INTEGER", true, 0));
            hashMap2.put("interval_duration", new d.a("interval_duration", "INTEGER", true, 0));
            hashMap2.put("flex_duration", new d.a("flex_duration", "INTEGER", true, 0));
            hashMap2.put("run_attempt_count", new d.a("run_attempt_count", "INTEGER", true, 0));
            hashMap2.put("backoff_policy", new d.a("backoff_policy", "INTEGER", true, 0));
            hashMap2.put("backoff_delay_duration", new d.a("backoff_delay_duration", "INTEGER", true, 0));
            hashMap2.put("period_start_time", new d.a("period_start_time", "INTEGER", true, 0));
            hashMap2.put("minimum_retention_duration", new d.a("minimum_retention_duration", "INTEGER", true, 0));
            hashMap2.put("schedule_requested_at", new d.a("schedule_requested_at", "INTEGER", true, 0));
            hashMap2.put("required_network_type", new d.a("required_network_type", "INTEGER", false, 0));
            hashMap2.put("requires_charging", new d.a("requires_charging", "INTEGER", true, 0));
            hashMap2.put("requires_device_idle", new d.a("requires_device_idle", "INTEGER", true, 0));
            hashMap2.put("requires_battery_not_low", new d.a("requires_battery_not_low", "INTEGER", true, 0));
            hashMap2.put("requires_storage_not_low", new d.a("requires_storage_not_low", "INTEGER", true, 0));
            hashMap2.put("trigger_content_update_delay", new d.a("trigger_content_update_delay", "INTEGER", true, 0));
            hashMap2.put("trigger_max_content_delay", new d.a("trigger_max_content_delay", "INTEGER", true, 0));
            hashMap2.put("content_uri_triggers", new d.a("content_uri_triggers", "BLOB", false, 0));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(1);
            hashSet4.add(new d.C0043d("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at")));
            androidx.room.b.d dVar2 = new androidx.room.b.d("WorkSpec", hashMap2, hashSet3, hashSet4);
            androidx.room.b.d a2 = androidx.room.b.d.a(bVar, "WorkSpec");
            if (!dVar2.equals(a2)) {
                throw new IllegalStateException("Migration didn't properly handle WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + dVar2 + "\n Found:\n" + a2);
            }
            HashMap hashMap3 = new HashMap(2);
            hashMap3.put("tag", new d.a("tag", "TEXT", true, 1));
            hashMap3.put("work_spec_id", new d.a("work_spec_id", "TEXT", true, 2));
            HashSet hashSet5 = new HashSet(1);
            hashSet5.add(new d.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            HashSet hashSet6 = new HashSet(1);
            hashSet6.add(new d.C0043d("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id")));
            androidx.room.b.d dVar3 = new androidx.room.b.d("WorkTag", hashMap3, hashSet5, hashSet6);
            androidx.room.b.d a3 = androidx.room.b.d.a(bVar, "WorkTag");
            if (!dVar3.equals(a3)) {
                throw new IllegalStateException("Migration didn't properly handle WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + dVar3 + "\n Found:\n" + a3);
            }
            HashMap hashMap4 = new HashMap(2);
            hashMap4.put("work_spec_id", new d.a("work_spec_id", "TEXT", true, 1));
            hashMap4.put("system_id", new d.a("system_id", "INTEGER", true, 0));
            HashSet hashSet7 = new HashSet(1);
            hashSet7.add(new d.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            androidx.room.b.d dVar4 = new androidx.room.b.d("SystemIdInfo", hashMap4, hashSet7, new HashSet(0));
            androidx.room.b.d a4 = androidx.room.b.d.a(bVar, "SystemIdInfo");
            if (!dVar4.equals(a4)) {
                throw new IllegalStateException("Migration didn't properly handle SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + dVar4 + "\n Found:\n" + a4);
            }
            HashMap hashMap5 = new HashMap(2);
            hashMap5.put("name", new d.a("name", "TEXT", true, 1));
            hashMap5.put("work_spec_id", new d.a("work_spec_id", "TEXT", true, 2));
            HashSet hashSet8 = new HashSet(1);
            hashSet8.add(new d.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
            HashSet hashSet9 = new HashSet(1);
            hashSet9.add(new d.C0043d("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id")));
            androidx.room.b.d dVar5 = new androidx.room.b.d("WorkName", hashMap5, hashSet8, hashSet9);
            androidx.room.b.d a5 = androidx.room.b.d.a(bVar, "WorkName");
            if (dVar5.equals(a5)) {
                return;
            }
            throw new IllegalStateException("Migration didn't properly handle WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + dVar5 + "\n Found:\n" + a5);
        }
    }

    @Override // androidx.room.i
    protected androidx.g.a.c b(androidx.room.a aVar) {
        return aVar.a.a(c.b.a(aVar.b).a(aVar.c).a(new androidx.room.k(aVar, new k.a(6) { // from class: androidx.work.impl.WorkDatabase_Impl.1
            @Override // androidx.room.k.a
            public void g(androidx.g.a.b bVar) {
            }

            AnonymousClass1(int i) {
                super(i);
            }

            @Override // androidx.room.k.a
            public void b(androidx.g.a.b bVar) {
                bVar.c("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                bVar.c("CREATE  INDEX `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
                bVar.c("CREATE  INDEX `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
                bVar.c("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
                bVar.c("CREATE  INDEX `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
                bVar.c("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                bVar.c("CREATE  INDEX `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
                bVar.c("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                bVar.c("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                bVar.c("CREATE  INDEX `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
                bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c84d23ade98552f1cec71088c1f0794c')");
            }

            @Override // androidx.room.k.a
            public void a(androidx.g.a.b bVar) {
                bVar.c("DROP TABLE IF EXISTS `Dependency`");
                bVar.c("DROP TABLE IF EXISTS `WorkSpec`");
                bVar.c("DROP TABLE IF EXISTS `WorkTag`");
                bVar.c("DROP TABLE IF EXISTS `SystemIdInfo`");
                bVar.c("DROP TABLE IF EXISTS `WorkName`");
            }

            @Override // androidx.room.k.a
            protected void d(androidx.g.a.b bVar) {
                if (WorkDatabase_Impl.this.c != null) {
                    int size = WorkDatabase_Impl.this.c.size();
                    for (int i = 0; i < size; i++) {
                        ((i.b) WorkDatabase_Impl.this.c.get(i)).a(bVar);
                    }
                }
            }

            @Override // androidx.room.k.a
            public void c(androidx.g.a.b bVar) {
                WorkDatabase_Impl.this.a = bVar;
                bVar.c("PRAGMA foreign_keys = ON");
                WorkDatabase_Impl.this.a(bVar);
                if (WorkDatabase_Impl.this.c != null) {
                    int size = WorkDatabase_Impl.this.c.size();
                    for (int i = 0; i < size; i++) {
                        ((i.b) WorkDatabase_Impl.this.c.get(i)).b(bVar);
                    }
                }
            }

            @Override // androidx.room.k.a
            public void f(androidx.g.a.b bVar) {
                androidx.room.b.b.a(bVar);
            }

            @Override // androidx.room.k.a
            protected void e(androidx.g.a.b bVar) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("work_spec_id", new d.a("work_spec_id", "TEXT", true, 1));
                hashMap.put("prerequisite_id", new d.a("prerequisite_id", "TEXT", true, 2));
                HashSet hashSet = new HashSet(2);
                hashSet.add(new d.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                hashSet.add(new d.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
                HashSet hashSet2 = new HashSet(2);
                hashSet2.add(new d.C0043d("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id")));
                hashSet2.add(new d.C0043d("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id")));
                androidx.room.b.d dVar = new androidx.room.b.d("Dependency", hashMap, hashSet, hashSet2);
                androidx.room.b.d a = androidx.room.b.d.a(bVar, "Dependency");
                if (!dVar.equals(a)) {
                    throw new IllegalStateException("Migration didn't properly handle Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + dVar + "\n Found:\n" + a);
                }
                HashMap hashMap2 = new HashMap(23);
                hashMap2.put("id", new d.a("id", "TEXT", true, 1));
                hashMap2.put("state", new d.a("state", "INTEGER", true, 0));
                hashMap2.put("worker_class_name", new d.a("worker_class_name", "TEXT", true, 0));
                hashMap2.put("input_merger_class_name", new d.a("input_merger_class_name", "TEXT", false, 0));
                hashMap2.put("input", new d.a("input", "BLOB", true, 0));
                hashMap2.put("output", new d.a("output", "BLOB", true, 0));
                hashMap2.put("initial_delay", new d.a("initial_delay", "INTEGER", true, 0));
                hashMap2.put("interval_duration", new d.a("interval_duration", "INTEGER", true, 0));
                hashMap2.put("flex_duration", new d.a("flex_duration", "INTEGER", true, 0));
                hashMap2.put("run_attempt_count", new d.a("run_attempt_count", "INTEGER", true, 0));
                hashMap2.put("backoff_policy", new d.a("backoff_policy", "INTEGER", true, 0));
                hashMap2.put("backoff_delay_duration", new d.a("backoff_delay_duration", "INTEGER", true, 0));
                hashMap2.put("period_start_time", new d.a("period_start_time", "INTEGER", true, 0));
                hashMap2.put("minimum_retention_duration", new d.a("minimum_retention_duration", "INTEGER", true, 0));
                hashMap2.put("schedule_requested_at", new d.a("schedule_requested_at", "INTEGER", true, 0));
                hashMap2.put("required_network_type", new d.a("required_network_type", "INTEGER", false, 0));
                hashMap2.put("requires_charging", new d.a("requires_charging", "INTEGER", true, 0));
                hashMap2.put("requires_device_idle", new d.a("requires_device_idle", "INTEGER", true, 0));
                hashMap2.put("requires_battery_not_low", new d.a("requires_battery_not_low", "INTEGER", true, 0));
                hashMap2.put("requires_storage_not_low", new d.a("requires_storage_not_low", "INTEGER", true, 0));
                hashMap2.put("trigger_content_update_delay", new d.a("trigger_content_update_delay", "INTEGER", true, 0));
                hashMap2.put("trigger_max_content_delay", new d.a("trigger_max_content_delay", "INTEGER", true, 0));
                hashMap2.put("content_uri_triggers", new d.a("content_uri_triggers", "BLOB", false, 0));
                HashSet hashSet3 = new HashSet(0);
                HashSet hashSet4 = new HashSet(1);
                hashSet4.add(new d.C0043d("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at")));
                androidx.room.b.d dVar2 = new androidx.room.b.d("WorkSpec", hashMap2, hashSet3, hashSet4);
                androidx.room.b.d a2 = androidx.room.b.d.a(bVar, "WorkSpec");
                if (!dVar2.equals(a2)) {
                    throw new IllegalStateException("Migration didn't properly handle WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + dVar2 + "\n Found:\n" + a2);
                }
                HashMap hashMap3 = new HashMap(2);
                hashMap3.put("tag", new d.a("tag", "TEXT", true, 1));
                hashMap3.put("work_spec_id", new d.a("work_spec_id", "TEXT", true, 2));
                HashSet hashSet5 = new HashSet(1);
                hashSet5.add(new d.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                HashSet hashSet6 = new HashSet(1);
                hashSet6.add(new d.C0043d("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id")));
                androidx.room.b.d dVar3 = new androidx.room.b.d("WorkTag", hashMap3, hashSet5, hashSet6);
                androidx.room.b.d a3 = androidx.room.b.d.a(bVar, "WorkTag");
                if (!dVar3.equals(a3)) {
                    throw new IllegalStateException("Migration didn't properly handle WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + dVar3 + "\n Found:\n" + a3);
                }
                HashMap hashMap4 = new HashMap(2);
                hashMap4.put("work_spec_id", new d.a("work_spec_id", "TEXT", true, 1));
                hashMap4.put("system_id", new d.a("system_id", "INTEGER", true, 0));
                HashSet hashSet7 = new HashSet(1);
                hashSet7.add(new d.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                androidx.room.b.d dVar4 = new androidx.room.b.d("SystemIdInfo", hashMap4, hashSet7, new HashSet(0));
                androidx.room.b.d a4 = androidx.room.b.d.a(bVar, "SystemIdInfo");
                if (!dVar4.equals(a4)) {
                    throw new IllegalStateException("Migration didn't properly handle SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + dVar4 + "\n Found:\n" + a4);
                }
                HashMap hashMap5 = new HashMap(2);
                hashMap5.put("name", new d.a("name", "TEXT", true, 1));
                hashMap5.put("work_spec_id", new d.a("work_spec_id", "TEXT", true, 2));
                HashSet hashSet8 = new HashSet(1);
                hashSet8.add(new d.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                HashSet hashSet9 = new HashSet(1);
                hashSet9.add(new d.C0043d("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id")));
                androidx.room.b.d dVar5 = new androidx.room.b.d("WorkName", hashMap5, hashSet8, hashSet9);
                androidx.room.b.d a5 = androidx.room.b.d.a(bVar, "WorkName");
                if (dVar5.equals(a5)) {
                    return;
                }
                throw new IllegalStateException("Migration didn't properly handle WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + dVar5 + "\n Found:\n" + a5);
            }
        }, "c84d23ade98552f1cec71088c1f0794c", "1db8206f0da6aa81bbdd2d99a82d9e14")).a());
    }

    @Override // androidx.room.i
    protected androidx.room.f c() {
        return new androidx.room.f(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName");
    }

    @Override // androidx.work.impl.WorkDatabase
    public androidx.work.impl.b.k o() {
        androidx.work.impl.b.k kVar;
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            if (this.d == null) {
                this.d = new l(this);
            }
            kVar = this.d;
        }
        return kVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public androidx.work.impl.b.b p() {
        androidx.work.impl.b.b bVar;
        if (this.e != null) {
            return this.e;
        }
        synchronized (this) {
            if (this.e == null) {
                this.e = new androidx.work.impl.b.c(this);
            }
            bVar = this.e;
        }
        return bVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public n q() {
        n nVar;
        if (this.f != null) {
            return this.f;
        }
        synchronized (this) {
            if (this.f == null) {
                this.f = new o(this);
            }
            nVar = this.f;
        }
        return nVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public androidx.work.impl.b.e r() {
        androidx.work.impl.b.e eVar;
        if (this.g != null) {
            return this.g;
        }
        synchronized (this) {
            if (this.g == null) {
                this.g = new androidx.work.impl.b.f(this);
            }
            eVar = this.g;
        }
        return eVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public androidx.work.impl.b.h s() {
        androidx.work.impl.b.h hVar;
        if (this.h != null) {
            return this.h;
        }
        synchronized (this) {
            if (this.h == null) {
                this.h = new androidx.work.impl.b.i(this);
            }
            hVar = this.h;
        }
        return hVar;
    }
}
