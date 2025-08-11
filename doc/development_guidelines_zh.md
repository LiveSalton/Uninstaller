# 统一开发规范指南

本文档整合了Flutter/Dart和Android开发的最佳实践和规范，适用于团队协作和项目维护。

## 一、通用编程原则

### 基本原则
- 所有代码和文档使用英文
- 明确声明每个变量和函数的类型（参数和返回值）
- 避免使用any类型，创建必要的类型定义
- 函数内不要留空行
- 每个文件只导出一个主要组件或类

### 命名规范
- 类名使用PascalCase（大驼峰命名法）
- 变量、函数和方法使用camelCase（小驼峰命名法）
- 文件和目录名使用underscore_case（下划线命名法）
- 环境变量使用UPPERCASE（大写）
- 避免使用魔法数字，定义常量
- 函数名以动词开头
- 布尔变量使用动词，如isLoading、hasError、canDelete等
- 使用完整单词而非缩写，正确拼写
  - 标准缩写例外：API、URL等
  - 常见缩写：i、j（循环），err（错误），ctx（上下文），req、res、next（中间件参数）

### 函数规范
- 编写简短、单一目的的函数（少于20条指令）
- 函数命名：动词+其他，布尔返回值使用isX、hasX、canX等
- 无返回值函数使用executeX、saveX等
- 通过以下方式避免嵌套块：
  - 早期检查和返回
  - 提取到工具函数
- 使用高阶函数（map、filter、reduce等）避免函数嵌套
  - 简单函数使用箭头函数（少于3条指令）
  - 复杂函数使用命名函数
- 使用默认参数值而非检查null或undefined
- 使用RO-RO模式减少函数参数：
  - 使用对象传递多个参数
  - 使用对象返回结果
  - 声明必要的输入参数和输出类型
- 保持单一抽象层级

### 数据规范
- 不要滥用基本类型，将数据封装在复合类型中
- 避免在函数中进行数据验证，使用具有内部验证的类
- 优先使用不可变数据
  - 使用readonly表示不变数据
  - 使用const表示不变字面量

### 类规范
- 遵循SOLID原则
- 优先使用组合而非继承
- 声明接口定义契约
- 编写单一目的的小类
  - 少于200条指令
  - 少于10个公共方法
  - 少于10个属性

### 异常处理
- 使用异常处理未预期的错误
- 捕获异常应该用于：
  - 修复预期问题
  - 添加上下文
  - 否则使用全局处理器

### 测试规范
- 遵循Arrange-Act-Assert测试约定
- 清晰命名测试变量
  - 约定：inputX、mockX、actualX、expectedX等
- 为每个公共函数编写单元测试
  - 使用测试替身模拟依赖
  - 第三方依赖（非昂贵执行）除外
- 为每个模块编写验收测试
  - 遵循Given-When-Then约定

## 二、Flutter/Dart开发规范

### 核心原则
- 编写简洁、技术性的Dart代码，提供准确示例
- 适当使用函数式和声明式编程模式
- 优先使用组合而非继承
- 使用描述性变量名，带有助动词（如isLoading、hasError）
- 文件结构：导出的widget、子widgets、辅助函数、静态内容、类型

### Dart/Flutter规范
- 对不可变widgets使用const构造函数
- 利用Freezed实现不可变状态类和联合类型
- 简单函数和方法使用箭头语法
- 单行getter和setter优先使用表达式体
- 使用尾随逗号以获得更好的格式化和差异对比

### 错误处理和验证
- 在视图中使用SelectableText.rich而非SnackBars实现错误处理
- 以红色显示错误信息以提高可见性
- 在显示屏幕上处理空状态
- 使用AsyncValue进行适当的错误处理和加载状态管理

### Riverpod特定规范
- 使用@riverpod注解生成providers
- 优先使用AsyncNotifierProvider和NotifierProvider而非StateProvider
- 避免使用StateProvider、StateNotifierProvider和ChangeNotifierProvider
- 使用ref.invalidate()手动触发provider更新
- 在widgets销毁时正确取消异步操作

### 性能优化
- 尽可能使用const widgets优化重绘
- 实现列表视图优化（如ListView.builder）
- 静态图片使用AssetImage，远程图片使用cached_network_image
- 为Supabase操作实现适当的错误处理，包括网络错误

### 关键约定
1. 使用GoRouter或auto_route进行导航和深度链接
2. 优化Flutter性能指标（首次有意义绘制、可交互时间）
3. 优先使用无状态widgets：
   - 使用ConsumerWidget处理依赖Riverpod的状态widgets
   - 结合Riverpod和Flutter Hooks时使用HookConsumerWidget

### UI和样式
- 使用Flutter内置widgets并创建自定义widgets
- 使用LayoutBuilder或MediaQuery实现响应式设计
- 使用主题在整个应用中保持一致的样式
- 使用Theme.of(context).textTheme.titleLarge而非headline6，headlineSmall而非headline5等

### 模型和数据库约定
- 在数据库表中包含createdAt、updatedAt和isDeleted字段
- 模型使用@JsonSerializable(fieldRename: FieldRename.snake)
- 只读字段实现@JsonKey(includeFromJson: true, includeToJson: false)

### Widgets和UI组件
- 创建小型私有widget类而非Widget _build...方法
- 实现RefreshIndicator实现下拉刷新功能
- 在TextFields中设置适当的textCapitalization、keyboardType和textInputAction
- 使用Image.network时始终包含errorBuilder

### 其他
- 使用log而非print进行调试
- 适当使用Flutter Hooks / Riverpod Hooks
- 行长度不超过80个字符，在多参数函数的右括号前添加逗号
- 数据库枚举使用@JsonValue(int)

### 代码生成
- 使用build_runner从注解生成代码（Freezed、Riverpod、JSON序列化）
- 修改注解类后运行'flutter pub run build_runner build --delete-conflicting-outputs'

### 文档
- 为复杂逻辑和非显而易见的代码决策添加文档
- 遵循官方Flutter、Riverpod和Supabase文档的最佳实践

## 三、Clean Architecture with Feature-first组织规范

### 核心原则

#### Clean Architecture
- 严格遵循Clean Architecture层：表示层、领域层和数据层
- 遵循依赖规则：依赖始终向内指向
- 领域层包含实体、仓库（接口）和用例
- 数据层实现仓库并包含数据源和模型
- 表示层包含UI组件、blocs和视图模型
- 为每个组件使用适当的抽象（接口/抽象类）
- 每个功能应遵循此分层架构模式

#### Feature-first组织
- 按功能而非技术层组织代码
- 每个功能是包含所有层实现的独立模块
- 核心或共享功能放在单独的'core'目录中
- 功能应尽量减少对其他功能的依赖
- 每个功能的通用目录结构：

```
lib/
├── core/                          # 共享/通用代码
│   ├── error/                     # 错误处理、失败
│   ├── network/                   # 网络工具、拦截器
│   ├── utils/                     # 工具函数和扩展
│   └── widgets/                   # 可复用widgets
├── features/                      # 所有应用功能
│   ├── feature_a/                 # 单一功能
│   │   ├── data/                  # 数据层
│   │   │   ├── datasources/       # 远程和本地数据源
│   │   │   ├── models/            # DTOs和数据模型
│   │   │   └── repositories/      # 仓库实现
│   │   ├── domain/                # 领域层
│   │   │   ├── entities/          # 业务对象
│   │   │   ├── repositories/      # 仓库接口
│   │   │   └── usecases/          # 业务逻辑用例
│   │   └── presentation/          # 表示层
│   │       ├── bloc/              # Bloc/Cubit状态管理
│   │       ├── pages/             # 屏幕widgets
│   │       └── widgets/           # 功能特定widgets
│   └── feature_b/                 # 另一个功能，结构相同
└── main.dart                      # 入口点
```

### flutter_bloc实现
- 使用Bloc处理复杂事件驱动逻辑，Cubit处理简单状态管理
- 为每个Bloc实现正确类型的Events和States
- 使用Freezed实现不可变状态和联合类型
- 为特定功能段创建粒度化、专注的Blocs
- 显式处理加载、错误和成功状态
- 避免在UI组件中包含业务逻辑
- 使用BlocProvider进行Blocs的依赖注入
- 实现BlocObserver用于日志记录和调试
- 分离事件处理和UI逻辑

### 依赖注入
- 使用GetIt作为服务定位器进行依赖注入
- 按功能在单独文件中注册依赖
- 适当实现延迟初始化
- 使用工厂模式创建临时对象，使用单例模式创建服务
- 创建易于测试的适当抽象

## 四、Android开发规范

### 核心原则
- 使用Clean Architecture
- 使用Repository模式进行数据持久化
- 使用MVI模式管理ViewModel中的状态和事件，并在Activities/Fragments中触发和渲染
- 使用Auth Activity管理认证流程
  - 启动屏幕
  - 登录
  - 注册
  - 忘记密码
  - 邮箱验证
- 使用Navigation Component管理Activities/Fragments间的导航
- 使用MainActivity管理主导航
  - 使用BottomNavigationView管理底部导航
  - 主页
  - 个人资料
  - 设置
  - 患者
  - 预约
- 使用ViewBinding管理视图
- 使用Flow/LiveData管理UI状态
- 使用xml和fragments而非jetpack compose
- 使用Material 3作为UI
- 使用ConstraintLayout作为布局

## 五、编码标准

### 状态管理
- 使用Freezed实现不可变状态
- 使用联合类型表示状态（初始、加载、成功、错误）
- 发出特定的、类型化的错误状态及失败详情
- 保持状态类小而专注
- 使用copyWith进行状态转换
- 使用BlocListener处理副作用
- 优先使用BlocBuilder配合buildWhen进行优化重绘

### 错误处理
- 使用Dartz的Either<Failure, Success>进行函数式错误处理
- 为领域特定错误创建自定义Failure类
- 实现层间适当的错误映射
- 集中化错误处理策略
- 提供用户友好的错误消息
- 记录错误用于调试和分析

### Repository模式
- Repositories作为数据的单一真实来源
- 适当实现缓存策略
- 优雅处理网络连接问题
- 将数据模型映射到领域实体
- 使用定义良好的方法签名创建适当抽象
- 处理分页和数据获取逻辑

### 测试策略
- 为领域逻辑、repositories和Blocs编写单元测试
- 为功能实现集成测试
- 为UI组件创建widget测试
- 使用mockito或mocktail为依赖创建模拟
- 遵循Given-When-Then测试结构约定
- 努力实现领域层和数据层的高测试覆盖率

### 性能考虑
- 对不可变widgets使用const构造函数
- 使用ListView.builder实现高效列表渲染
- 使用适当的状态管理最小化widget重绘
- 使用compute()对昂贵操作进行计算隔离
- 为大数据集实现分页
- 适当缓存网络资源
- 分析和优化渲染性能

### 代码质量
- 使用flutter_lints包的lint规则
- 保持函数小而专注（少于30行）
- 在整个代码库中应用SOLID原则
- 为类、方法和变量使用有意义的命名
- 为公共API和复杂逻辑添加文档
- 实现适当的空安全
- 为领域特定类型使用值对象