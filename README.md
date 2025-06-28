# Android 应用卸载器

一个简单而强大的Android应用卸载工具，支持应用列表显示、搜索和卸载功能。

## 功能特性

### 🎯 核心功能
- **应用列表显示**: 显示所有已安装的第三方应用
- **搜索功能**: 支持按应用名称搜索
- **单个卸载**: 点击应用即可卸载
- **批量卸载**: 支持选择多个应用进行批量卸载
- **应用信息**: 显示应用图标、名称、版本、大小和更新时间

### 🔧 技术实现

#### 权限配置
```xml
<!-- 卸载应用权限 -->
<uses-permission android:name="android.permission.REQUEST_DELETE_PACKAGES" />
<!-- 查询已安装应用权限 -->
<uses-permission android:name="android.permission.QUERY_ALL_PACKAGES" />
```

#### 核心组件

1. **MainActivity**: 主活动，负责权限检查和Fragment初始化
2. **SpeedUpListFragment**: 应用列表Fragment，实现列表显示和卸载功能
3. **SpeedUpAdapter**: 列表适配器，负责应用项的UI展示
4. **PreloadCore**: 应用数据预加载核心类
5. **AppManager**: 应用管理工具类
6. **Utils**: 通用工具类

## 使用方法

### 基本使用

1. **启动应用**: 应用启动后会自动加载已安装的第三方应用列表
2. **浏览应用**: 在列表中浏览所有已安装的应用
3. **搜索应用**: 使用顶部搜索框按名称搜索应用
4. **卸载应用**: 点击任意应用项即可进入系统卸载界面

### 批量操作

1. **多选模式**: 长按应用项进入多选模式（如果实现）
2. **批量卸载**: 选择多个应用后点击"删除"按钮进行批量卸载

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

### 卸载方法
```java
private void uninstallApp(AppEntity entity) {
    Uri packageURI = Uri.parse("package:" + entity.appInfo.packageName);
    Intent intent = new Intent(Intent.ACTION_DELETE, packageURI);
    startActivityForResult(intent, 0x101);
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
- **权限**: 需要查询应用包权限和删除应用权限

## 注意事项

1. **权限说明**: 应用需要`REQUEST_DELETE_PACKAGES`权限来卸载其他应用
2. **系统限制**: 只能卸载用户安装的第三方应用，无法卸载系统应用
3. **安全性**: 每次卸载都会弹出系统确认对话框，确保用户操作安全

## 扩展功能

可以基于现有架构扩展以下功能：
- 应用备份和恢复
- 应用移动到SD卡
- 应用使用统计
- 应用权限管理
- 应用分类（系统应用/用户应用）

## 参考文档

参考 `systemapp` 目录下的完整实现案例，了解更多高级功能的实现方式。 