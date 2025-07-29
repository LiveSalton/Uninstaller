import 'package:flutter/material.dart';
import 'package:flutter_healme/res/constant.dart';
import 'package:flutter_healme/setting/provider/locale_provider.dart';
import 'package:flutter_healme/user/utils/mmkv_helper.dart';
import 'package:flutter_healme/util/toast_utils.dart';
import 'package:flutter_healme/widgets/my_app_bar.dart';
import 'package:provider/provider.dart';

class LocalePage extends StatefulWidget {

  const LocalePage({super.key});

  @override
  _LocalePageState createState() => _LocalePageState();
}

class _LocalePageState extends State<LocalePage> {

  final List<String> _list = <String>['跟随系统', '中文', 'English'];

  @override
  Widget build(BuildContext context) {
    final String? locale = MMKVHelper.getString(Constant.locale);
    String localeMode;
    switch(locale) {
      case 'zh':
        localeMode = _list[1];
        break;
      case 'en':
        localeMode = _list[2];
        break;
      default:
        localeMode = _list[0];
        break;
    }
    return Scaffold(
      appBar: const MyAppBar(
        title: '多语言',
      ),
      body: ListView.separated(
        itemCount: _list.length,
        separatorBuilder: (_, __) => const Divider(),
        itemBuilder: (_, int index) {
          return InkWell(
            onTap: () {
              final String locale = index == 0 ? '' : (index == 1 ? 'zh' : 'en');
              context.read<LocaleProvider>().setLocale(locale);
              Toast.show('当前功能仅登录模块有效');
              setState(() {});
            },
            child: Container(
              alignment: AlignmentDirectional.centerStart,
              padding: const EdgeInsetsDirectional.symmetric(horizontal: 16.0),
              height: 50.0,
              child: Row(
                children: <Widget>[
                  Expanded(
                    child: Text(_list[index]),
                  ),
                  Opacity(
                    opacity: localeMode == _list[index] ? 1 : 0,
                    child: const Icon(Icons.done, color: Colors.blue),
                  )
                ],
              ),
            ),
          );
        },
      ),
    );
  }
}
