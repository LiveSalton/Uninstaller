import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_healme/res/constant.dart';
import 'package:flutter_healme/user/utils/mmkv_helper.dart';

class LocaleProvider extends ChangeNotifier {

  Locale? get locale {
    final String? locale = MMKVHelper.getString(Constant.locale);
    switch(locale) {
      case 'zh':
        return const Locale('zh', 'CN');
      case 'en':
        return const Locale('en', 'US');
      default:
        return const Locale('en', 'US');
    }
  }

  void setLocale(String locale) {
    MMKVHelper.putString(Constant.locale, locale);
    notifyListeners();
  }

}
