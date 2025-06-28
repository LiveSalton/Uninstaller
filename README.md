# Android 应用卸载器

一个简单而强大的Android应用卸载工具，支持应用列表显示、搜索、卸载、备份和恢复功能。

## 功能特性

### 🎯 核心功能
- **应用列表显示**: 显示所有已安装的第三方应用
- **搜索功能**: 支持按应用名称搜索
- **单个卸载**: 点击应用即可卸载
- **批量卸载**: 支持选择多个应用进行批量卸载
- **应用备份**: 备份APK文件到本地存储
- **应用恢复**: 从备份文件恢复已删除的应用
- **备份管理**: 完整的备份文件管理界面
- **应用信息**: 显示应用图标、名称、版本、大小和更新时间

### 🔧 技术实现

#### 权限配置
```xml
<!-- 卸载应用权限 -->
<uses-permission android:name="android.permission.REQUEST_DELETE_PACKAGES" />
<!-- 安装应用权限 -->
<uses-permission android:name="android.permission.REQUEST_INSTALL_PACKAGES" />
<!-- 查询已安装应用权限 -->
<uses-permission android:name="android.permission.QUERY_ALL_PACKAGES" />
<!-- 存储权限 -->
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```

#### 核心组件

1. **MainActivity**: 主活动，负责权限检查和Fragment初始化
2. **SpeedUpListFragment**: 应用列表Fragment，实现列表显示和卸载功能
3. **BackupActivity**: 备份管理Activity，显示和管理备份文件
4. **SpeedUpAdapter**: 列表适配器，负责应用项的UI展示
5. **BackupManager**: 备份和恢复管理器
6. **PreloadCore**: 应用数据预加载核心类
7. **AppManager**: 应用管理工具类
8. **Utils**: 通用工具类

## 使用方法

### 基本使用

1. **启动应用**: 应用启动后会自动加载已安装的第三方应用列表
2. **浏览应用**: 在列表中浏览所有已安装的应用
3. **搜索应用**: 使用顶部搜索框按名称搜索应用
4. **卸载应用**: 点击任意应用项即可进入系统卸载界面

### 备份功能

1. **选择应用**: 使用复选框选择要备份的应用
2. **开始备份**: 点击"备份"按钮开始备份选中的应用
3. **备份进度**: 实时显示备份进度和状态
4. **备份完成**: 备份完成后会显示成功消息

### 恢复功能

1. **进入备份管理**: 点击"备份管理"按钮进入备份管理界面
2. **查看备份**: 浏览所有已备份的应用文件
3. **恢复应用**: 点击备份项即可恢复应用
4. **删除备份**: 长按备份项可以删除备份文件

### 备份管理

1. **备份列表**: 显示所有备份文件的详细信息
2. **刷新列表**: 点击"刷新"按钮更新备份列表
3. **清空备份**: 点击"清空全部"删除所有备份文件
4. **文件信息**: 显示应用名称、版本、备份时间、文件大小等

## 代码架构

### 应用实体类
```java
public class AppEntity {
    public String mAppName;      // 应用名
    public Drawable mIcon;       // 图标
    public String mSize;         // 大小
    public PackageInfo appInfo;  // 包信息
    public boolean isChecked;    // 是否选中
    public String mPath;         // APK路径
}
```

### 备份信息类
```java
public static class BackupInfo {
    public File backupFile;      // 备份文件
    public String packageName;   // 包名
    public String appName;       // 应用名
    public String versionName;   // 版本名
    public Date backupTime;      // 备份时间
    public long fileSize;        // 文件大小
}
```

### 卸载方法
```java
private void uninstallApp(AppEntity entity) {
    Uri packageURI = Uri.parse("package:" + entity.appInfo.packageName);
    Intent intent = new Intent(Intent.ACTION_DELETE, packageURI);
    startActivityForResult(intent, 0x101);
}
```

### 备份方法
```java
public static void toBackup(List<AppEntity> apps, IBackupProgress callback) {
    // 异步备份应用APK文件
    // 支持进度回调和完成通知
}
```

### 恢复方法
```java
public static void restoreApp(Context context, BackupInfo backupInfo) {
    // 从备份文件恢复应用
    // 使用系统安装界面进行安装
}
```

## 安装和配置

1. **克隆项目**:
   ```bash
   git clone <repository-url>
   ```

2. **导入Android Studio**: 使用Android Studio打开项目

3. **构建项目**: 确保所有依赖正确配置后构建项目

4. **运行应用**: 在Android设备或模拟器上运行

## 系统要求

- **最低Android版本**: Android 7.0 (API Level 24)
- **目标Android版本**: Android 14 (API Level 35)
- **权限**: 需要查询应用包权限、删除应用权限、安装应用权限和存储权限

## 备份存储

- **备份目录**: `/sdcard/UninstallerBackup/`
- **文件格式**: `{包名}_v{版本}_{时间戳}.apk.backup`
- **信息文件**: 每个备份都有对应的`.info`信息文件
- **安全性**: 使用FileProvider安全地共享文件

## 注意事项

1. **权限说明**: 应用需要多项系统权限来实现完整功能
2. **系统限制**: 只能卸载用户安装的第三方应用，无法卸载系统应用
3. **安全性**: 每次卸载和恢复都会弹出系统确认对话框
4. **存储空间**: 备份功能需要足够的存储空间
5. **兼容性**: 恢复功能需要Android 7.0及以上版本的FileProvider支持

## 扩展功能

可以基于现有架构扩展以下功能：
- 应用数据备份（需要Root权限）
- 应用移动到SD卡
- 应用使用统计
- 应用权限管理
- 应用分类（系统应用/用户应用）
- 云端备份同步
- 定时自动备份

## 技术亮点

- **异步处理**: 备份和恢复操作在后台线程执行
- **进度回调**: 实时显示操作进度和状态
- **错误处理**: 完善的异常处理和用户提示
- **界面友好**: 现代化的Material Design界面
- **文件安全**: 使用FileProvider确保文件访问安全

## 参考文档

参考 `systemapp` 目录下的完整实现案例，了解更多高级功能的实现方式。 