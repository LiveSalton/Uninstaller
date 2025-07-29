import 'package:flutter/material.dart';
import 'package:flutter_healme/heal/login/login_router.dart';
import 'package:flutter_healme/res/dimens.dart';
import 'package:flutter_healme/res/styles.dart';
import 'package:flutter_healme/heal/routers/fluro_navigator.dart';
import 'package:flutter_healme/widgets/base_dialog.dart';

class ExitDialog extends StatefulWidget {

  const ExitDialog({
    super.key,
  });

  @override
  _ExitDialog createState() => _ExitDialog();
  
}

class _ExitDialog extends State<ExitDialog> {

  @override
  Widget build(BuildContext context) {
    return BaseDialog(
      title: '提示',
      child: const Padding(
        padding: EdgeInsetsDirectional.symmetric(horizontal: 16.0, vertical: 8.0),
        child: Text('您确定要退出登录吗？', style: TextStyle(
          fontSize: Dimens.font_sp16,
          fontFamily: 'Urbanist',
        )),
      ),
      onPressed: () {
        NavigatorUtils.push(context, LoginRouter.loginPage, clearStack: true);
      },
    );
  }
}
