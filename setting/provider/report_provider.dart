import 'dart:io';

import 'package:flutter/material.dart';
import 'package:wechat_assets_picker/wechat_assets_picker.dart';

/// 举报页面状态管理
class ReportProvider extends ChangeNotifier {
  /// 描述内容
  String _description = '';
  String get description => _description;

  /// 手机号
  String _phoneNumber = '';
  String get phoneNumber => _phoneNumber;

  /// 邮箱
  String _email = '';
  String get email => _email;

  /// 选中的图片资源
  List<AssetEntity> _selectedAssets = [];
  List<AssetEntity> get selectedAssets => _selectedAssets;

  /// 是否正在提交
  bool _isSubmitting = false;
  bool get isSubmitting => _isSubmitting;

  /// 是否满足提交条件
  bool get canSubmit => _description.trim().isNotEmpty;

  /// 更新描述内容
  void updateDescription(String value) {
    _description = value;
    notifyListeners();
  }

  /// 更新手机号
  void updatePhoneNumber(String value) {
    _phoneNumber = value;
    notifyListeners();
  }

  /// 更新邮箱
  void updateEmail(String value) {
    _email = value;
    notifyListeners();
  }

  /// 添加图片
  void addAsset(AssetEntity asset) {
    if (_selectedAssets.length < 6) {
      _selectedAssets.add(asset);
      notifyListeners();
    }
  }

  /// 移除图片
  void removeAsset(AssetEntity asset) {
    _selectedAssets.remove(asset);
    notifyListeners();
  }

  /// 清空所有图片
  void clearAssets() {
    _selectedAssets.clear();
    notifyListeners();
  }

  /// 设置提交状态
  void setSubmitting(bool value) {
    _isSubmitting = value;
    notifyListeners();
  }

  /// 重置表单
  void reset() {
    _description = '';
    _phoneNumber = '';
    _email = '';
    _selectedAssets.clear();
    _isSubmitting = false;
    notifyListeners();
  }
} 