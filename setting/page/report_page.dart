import 'dart:convert';
import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_healme/res/intl.dart';
import 'package:flutter_healme/l10n/heal_localizations.dart';
import 'package:flutter_healme/res/resources.dart';
import 'package:flutter_healme/heal/routers/fluro_navigator.dart';
import 'package:flutter_healme/util/toast_utils.dart';
import 'package:flutter_healme/widgets/my_app_bar.dart';
import 'package:flutter_healme/widgets/my_scroll_view.dart';
import 'package:provider/provider.dart';
import 'package:wechat_assets_picker/wechat_assets_picker.dart';
import '../provider/report_provider.dart';

/// 举报与反馈页面
class ReportPage extends StatefulWidget {
  const ReportPage({super.key});

  @override
  _ReportPageState createState() => _ReportPageState();
}

class _ReportPageState extends State<ReportPage> {
  final TextEditingController _descriptionController = TextEditingController();
  final TextEditingController _phoneController = TextEditingController();
  final TextEditingController _emailController = TextEditingController();

  @override
  void initState() {
    super.initState();
    // 监听输入变化
    _descriptionController.addListener(_onDescriptionChanged);
    _phoneController.addListener(_onPhoneChanged);
    _emailController.addListener(_onEmailChanged);
  }

  @override
  void dispose() {
    _descriptionController.removeListener(_onDescriptionChanged);
    _phoneController.removeListener(_onEmailChanged);
    _emailController.removeListener(_onEmailChanged);
    _descriptionController.dispose();
    _phoneController.dispose();
    _emailController.dispose();
    super.dispose();
  }

  void _onDescriptionChanged() {
    context.read<ReportProvider>().updateDescription(_descriptionController.text);
  }

  void _onPhoneChanged() {
    context.read<ReportProvider>().updatePhoneNumber(_phoneController.text);
  }

  void _onEmailChanged() {
    context.read<ReportProvider>().updateEmail(_emailController.text);
  }

  /// 选择图片
  Future<void> _pickImages() async {
    try {
      final List<AssetEntity>? result = await AssetPicker.pickAssets(
        context,
        pickerConfig: AssetPickerConfig(
          maxAssets: 6 - context.read<ReportProvider>().selectedAssets.length,
          requestType: RequestType.image,
        ),
      );
      
      if (result != null && result.isNotEmpty) {
        for (final asset in result) {
          context.read<ReportProvider>().addAsset(asset);
        }
      }
    } catch (e) {
      if (e is MissingPluginException) {
        Toast.show('当前平台暂不支持！');
      } else {
        Toast.show('没有权限，无法打开相册！');
      }
    }
  }

  /// 提交举报
  Future<void> _submitReport() async {
    final provider = context.read<ReportProvider>();
    
    if (!provider.canSubmit) {
      Toast.show(intl.pleaseEnterDescription);
      return;
    }

    provider.setSubmitting(true);

    try {
      // 上传图片
      List<String> imageUrls = [];
      for (final asset in provider.selectedAssets) {
        final file = await asset.file;
        if (file != null) {
          // 这里应该调用实际的图片上传接口
          // 暂时模拟上传成功
          imageUrls.add('https://example.com/uploaded_image.jpg');
        }
      }

      // 提交举报数据
      final Map<String, dynamic> postData = {
        'description': provider.description,
        'phone': provider.phoneNumber,
        'email': provider.email,
        'images': json.encode(imageUrls),
        'timestamp': DateTime.now().millisecondsSinceEpoch,
      };

      // 这里应该调用实际的举报接口
      // 暂时模拟提交成功
      await Future.delayed(const Duration(seconds: 1));
      
      Toast.show(intl.uploadSuccessful);
      NavigatorUtils.goBack(context);
      
    } catch (e) {
      Toast.show(intl.uploadFailed);
    } finally {
      provider.setSubmitting(false);
    }
  }

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
      create: (_) => ReportProvider(),
      child: Scaffold(
        appBar: MyAppBar(
          title: intl.reportAndFeedback,
        ),
        body: MyScrollView(
          padding: const EdgeInsetsDirectional.all(16.0),
          children: [
            _buildDescriptionSection(),
            Gaps.vGap16,
            _buildImageSection(),
            Gaps.vGap16,
            _buildContactSection(),
            Gaps.vGap32,
            _buildSubmitButton(),
          ],
        ),
      ),
    );
  }

  /// 构建描述部分
  Widget _buildDescriptionSection() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(
          intl.reportDescription,
          style: TextStyles.textBold16,
        ),
        Gaps.vGap8,
        Container(
          decoration: BoxDecoration(
            color: Colours.bg_color,
            borderRadius: BorderRadius.circular(8.0),
          ),
          child: TextField(
            controller: _descriptionController,
            maxLines: 5,
            decoration: InputDecoration(
              hintText: intl.reportDescriptionHint,
              border: InputBorder.none,
              contentPadding: const EdgeInsetsDirectional.all(16.0),
            ),
          ),
        ),
      ],
    );
  }

  /// 构建图片上传部分
  Widget _buildImageSection() {
    return Consumer<ReportProvider>(
      builder: (context, provider, child) {
        return Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              intl.uploadScreenshots,
              style: TextStyles.textBold16,
            ),
            Gaps.vGap8,
            Wrap(
              spacing: 8.0,
              runSpacing: 8.0,
              children: [
                ...provider.selectedAssets.map((asset) => _buildImageItem(asset)),
                if (provider.selectedAssets.length < 6) _buildAddImageButton(),
              ],
            ),
          ],
        );
      },
    );
  }

  /// 构建单个图片项
  Widget _buildImageItem(AssetEntity asset) {
    return Stack(
      children: [
        Container(
          width: 80.0,
          height: 80.0,
          decoration: BoxDecoration(
            borderRadius: BorderRadius.circular(8.0),
            image: DecorationImage(
              image: AssetEntityImageProvider(asset, isOriginal: false),
              fit: BoxFit.cover,
            ),
          ),
        ),
        PositionedDirectional(
          top: 4.0,
          end: 4.0,
          child: GestureDetector(
            onTap: () => context.read<ReportProvider>().removeAsset(asset),
            child: Container(
              width: 20.0,
              height: 20.0,
              decoration: const BoxDecoration(
                color: Colors.red,
                shape: BoxShape.circle,
              ),
              child: const Icon(
                Icons.close,
                color: Colors.white,
                size: 14.0,
              ),
            ),
          ),
        ),
      ],
    );
  }

  /// 构建添加图片按钮
  Widget _buildAddImageButton() {
    return GestureDetector(
      onTap: _pickImages,
      child: Container(
        width: 80.0,
        height: 80.0,
        decoration: BoxDecoration(
          color: Colours.bg_color,
          borderRadius: BorderRadius.circular(8.0),
          border: Border.all(color: Colours.line, width: 1.0),
        ),
        child: const Icon(
          Icons.add_photo_alternate_outlined,
          color: Colours.text_gray,
          size: 32.0,
        ),
      ),
    );
  }

  /// 构建联系方式部分
  Widget _buildContactSection() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(
          intl.contactInformation,
          style: TextStyles.textBold16,
        ),
        Gaps.vGap16,
        _buildContactInput(
          controller: _phoneController,
          hint: intl.phoneNumberHint,
          icon: Icons.phone,
        ),
        Gaps.vGap12,
        _buildContactInput(
          controller: _emailController,
          hint: intl.emailHint,
          icon: Icons.email,
        ),
      ],
    );
  }

  /// 构建联系方式输入框
  Widget _buildContactInput({
    required TextEditingController controller,
    required String hint,
    required IconData icon,
  }) {
    return Container(
      decoration: BoxDecoration(
        color: Colours.bg_color,
        borderRadius: BorderRadius.circular(8.0),
      ),
      child: Row(
        children: [
          Padding(
            padding: const EdgeInsetsDirectional.only(start: 16.0, ),
            child: Icon(icon, color: Colours.text_gray, size: 20.0),
          ),
          Expanded(
            child: TextField(
              controller: controller,
              decoration: InputDecoration(
                hintText: hint,
                border: InputBorder.none,
                contentPadding: const EdgeInsetsDirectional.all(16.0),
              ),
            ),
          ),
        ],
      ),
    );
  }

  /// 构建提交按钮
  Widget _buildSubmitButton() {
    return Consumer<ReportProvider>(
      builder: (context, provider, child) {
        return SizedBox(
          width: double.infinity,
          height: 48.0,
          child: ElevatedButton(
            onPressed: provider.canSubmit && !provider.isSubmitting ? _submitReport : null,
            style: ElevatedButton.styleFrom(
              backgroundColor: provider.canSubmit ? Theme.of(context).primaryColor : Colours.text_gray,
              shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.circular(8.0),
              ),
            ),
            child: provider.isSubmitting
                ? const SizedBox(
                    width: 20.0,
                    height: 20.0,
                    child: CircularProgressIndicator(
                      strokeWidth: 2.0,
                      valueColor: AlwaysStoppedAnimation<Color>(Colors.white),
                    ),
                  )
                : Text(
                    intl.submit,
                    style: const TextStyle(
                      color: Colors.white,
                      fontSize: 16.0,
                      fontWeight: FontWeight.w600,
                    ),
                  ),
          ),
        );
      },
    );
  }
} 