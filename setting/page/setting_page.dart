import 'package:flutter/material.dart';
import 'package:flutter_healme/heal/widget/background_widget.dart';
import 'package:flutter_healme/res/constant.dart';
import 'package:flutter_healme/res/resources.dart';
import 'package:flutter_healme/heal/routers/fluro_navigator.dart';
import 'package:flutter_healme/setting/provider/locale_provider.dart';
import 'package:flutter_healme/setting/provider/theme_provider.dart';
import 'package:flutter_healme/setting/widgets/exit_dialog.dart';
import 'package:flutter_healme/user/utils/mmkv_helper.dart';
import 'package:flutter_healme/util/device_utils.dart';
import 'package:flutter_healme/widgets/click_item.dart';
import 'package:flutter_healme/widgets/my_app_bar.dart';
import 'package:provider/provider.dart';

import '../setting_router.dart';

class SettingPage extends StatefulWidget {
  const SettingPage({super.key});

  @override
  _SettingPageState createState() => _SettingPageState();
}

class _SettingPageState extends State<SettingPage> {
  final TextStyle titleStyle = TextStyle(color: Colors.white);
  final TextStyle contentStyle =
      TextStyle(color: Colors.white.withOpacity(0.7), fontSize: Dimens.font_sp14);

  @override
  Widget build(BuildContext context) {
    // 定义通用文本样式
    return Scaffold(
      extendBodyBehindAppBar: true,
      appBar: const MyAppBar(
        centerTitle: 'Setting',
      ),
      body: GradientBackground(
        gradient: const LinearGradient(
          begin: Alignment.topCenter,
          end: Alignment.bottomCenter,
          colors: [
            Color(0xFF0C012B),
            Color(0xFF161A40),
          ],
          stops: [0.0, 1.0],
        ),
        child: SafeArea(
          child: Column(
            children: <Widget>[
              Gaps.vGap5,
              if (Device.isMobile)
                ClickItem(
                  title: '清除缓存',
                  titleStyle: titleStyle,
                  content: '23.5MB',
                  contentStyle: contentStyle,
                  onTap: () {},
                ),
              ClickItem(
                title: '夜间模式',
                titleStyle: titleStyle,
                content: _getCurrentTheme(),
                contentStyle: contentStyle,
                onTap: () => NavigatorUtils.push(context, SettingRouter.themePage),
              ),
              ClickItem(
                title: '多语言',
                titleStyle: titleStyle,
                content: _getCurrentLocale(),
                contentStyle: contentStyle,
                onTap: () => NavigatorUtils.push(context, SettingRouter.localePage),
              ),
              if (Device.isMobile)
                ClickItem(
                  title: '检查更新',
                  titleStyle: titleStyle,
                  onTap: _showUpdateDialog,
                ),
              ClickItem(
                title: '关于我们',
                titleStyle: titleStyle,
                onTap: () => NavigatorUtils.push(context, SettingRouter.aboutPage),
              ),
              ClickItem(
                title: '举报与反馈',
                titleStyle: titleStyle,
                onTap: () => NavigatorUtils.push(context, SettingRouter.reportPage),
              ),
              ClickItem(
                title: '退出当前账号',
                titleStyle: titleStyle,
                onTap: _showExitDialog,
              ),
            ],
          ),
        ),
      ),
    );
  }

  String _getCurrentTheme() {
    final String? theme = MMKVHelper.getString(Constant.theme);
    String themeMode;
    switch (theme) {
      case 'Dark':
        themeMode = '开启';
        break;
      case 'Light':
        themeMode = '关闭';
        break;
      default:
        themeMode = '跟随系统';
        break;
    }
    return themeMode;
  }

  String _getCurrentLocale() {
    final String? locale = MMKVHelper.getString(Constant.locale);
    String localeMode;
    switch (locale) {
      case 'zh':
        localeMode = '中文';
        break;
      case 'en':
        localeMode = 'English';
        break;
      default:
        localeMode = '跟随系统';
        break;
    }
    return localeMode;
  }

  void _showExitDialog() {
    showDialog<void>(context: context, builder: (_) => const ExitDialog());
  }

  void _showUpdateDialog() {}
}
