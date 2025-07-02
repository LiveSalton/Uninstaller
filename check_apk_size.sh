#!/bin/bash

# APK大小检查脚本 - 目标1MB

echo "=================================="
echo "极简卸载器 - APK体积分析工具"  
echo "目标大小: 1MB"
echo "=================================="

# 构建Release版本
echo "正在构建Release版本..."
./gradlew assembleRelease

# 查找APK文件
APK_PATH="app/build/outputs/apk/release/app-release-unsigned.apk"

if [ ! -f "$APK_PATH" ]; then
    echo "❌ APK文件未找到: $APK_PATH"
    exit 1
fi

# 获取APK大小
APK_SIZE=$(stat -f%z "$APK_PATH" 2>/dev/null || stat -c%s "$APK_PATH" 2>/dev/null)
APK_SIZE_KB=$((APK_SIZE / 1024))
TARGET_SIZE_KB=1024

echo ""
echo "📱 APK信息:"
echo "文件路径: $APK_PATH"
echo "文件大小: ${APK_SIZE} bytes (${APK_SIZE_KB} KB)"

# 判断是否达到目标
if [ $APK_SIZE_KB -le $TARGET_SIZE_KB ]; then
    echo "✅ 恭喜! APK大小 ${APK_SIZE_KB}KB <= 目标 ${TARGET_SIZE_KB}KB"
    PERCENTAGE=$((APK_SIZE_KB * 100 / TARGET_SIZE_KB))
    echo "📊 达成度: ${PERCENTAGE}%"
else
    echo "❌ APK大小 ${APK_SIZE_KB}KB > 目标 ${TARGET_SIZE_KB}KB"
    EXCESS_KB=$((APK_SIZE_KB - TARGET_SIZE_KB))
    echo "📈 超出: ${EXCESS_KB}KB"
fi

echo ""
echo "🔍 APK内容分析:"

# 使用aapt分析APK内容
if command -v aapt >/dev/null 2>&1; then
    aapt dump badging "$APK_PATH" | head -5
    echo ""
    aapt list -v "$APK_PATH" | head -10
else
    echo "⚠️  aapt工具未找到，无法进行详细分析"
fi

echo ""
echo "💡 优化建议:"
echo "1. 检查 build/outputs/mapping/release/mapping.txt 查看混淆映射"
echo "2. 检查 build/outputs/mapping/release/unused.txt 查看未使用的代码"
echo "3. 使用 'aapt list -v \$APK_PATH' 查看详细内容"
echo "4. 考虑使用 'zipalign -v 4 \$APK_PATH \$APK_PATH.aligned' 优化对齐"

echo ""
echo "=================================="
echo "分析完成!"
echo "==================================" 