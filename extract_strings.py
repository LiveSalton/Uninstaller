import os
import re
import xml.etree.ElementTree as ET

layout_dir = 'app/src/main/res/layout'
strings_path = 'app/src/main/res/values/strings.xml'

# 读取已有 strings.xml，避免重复
try:
    tree = ET.parse(strings_path)
    root = tree.getroot()
    existing = {e.text for e in root.findall('string')}
except Exception:
    existing = set()

# 匹配硬编码中文字符串
pattern = re.compile(r'android:text="([^@"][^"]*[\u4e00-\u9fa5][^"]*)"')

new_strings = []
for filename in os.listdir(layout_dir):
    if not filename.endswith('.xml'):
        continue
    path = os.path.join(layout_dir, filename)
    with open(path, 'r', encoding='utf-8') as f:
        content = f.read()
    matches = pattern.findall(content)
    for match in matches:
        key = f'auto_{abs(hash(match))}'
        if match not in existing:
            new_strings.append(f'    <string name="{key}">{match}</string>')
            existing.add(match)
        content = content.replace(f'android:text="{match}"', f'android:text="@string/{key}"')
    with open(path, 'w', encoding='utf-8') as f:
        f.write(content)

# 追加到 strings.xml
if new_strings:
    with open(strings_path, 'r', encoding='utf-8') as f:
        lines = f.readlines()
    # 在 </resources> 前插入
    for i, line in enumerate(lines):
        if '</resources>' in line:
            lines = lines[:i] + new_strings + ['\n'] + lines[i:]
            break
    with open(strings_path, 'w', encoding='utf-8') as f:
        f.writelines(lines)

print('处理完成，已自动替换并追加到 strings.xml') 