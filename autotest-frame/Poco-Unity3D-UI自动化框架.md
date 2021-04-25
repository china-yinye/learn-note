## Unity3D app Ui 自动化测试（Poco ui 自动化框架）



### 安装poco （其实也不用安装），Airtest  IDE 自带了直接能用🤪，为了保险还是安装一下吧

```shell
pip install pocoui
```



### 如何在Unity3D项目中嵌入PocoSDK

PocoSDK 支持Unity3D 4以上版本，支持ngui、ugui、fairygui，SDK目前只有c#版。如果你的Unity3D游戏使用了其他GUI框架，请参考 [implementation guide](https://poco.readthedocs.io/zh_CN/latest/source/doc/implementation_guide.html) 。接入步骤如下：

1. 从 [poco-sdk repo](https://github.com/AirtestProject/Poco-SDK) clone或下载源码。
2. 拷贝 `Unity3D` 文件夹到你的Unity3D项目脚本（script）目录，任意路径都可以。
3. * 使用 `NGUI` 的话就把 `Unity3D/ugui` 和 `Unity3D/fairygui` 目录删除。
   * 使用 `UGUI` 的话就把 `Unity3D/ngui` 和 `Unity3D/fairygui` 目录删除。
   * 使用 `fairygui` 的话，请参考 [fairygui guide](https://github.com/AirtestProject/Poco-SDK/tree/master/Unity3D/fairygui)
4. 场景中任意 `GameObject` 上选中 `UI Root` 或者 `Top Root` 添加组件 Add Component `Unity3D/PocoManager.cs` ，一般 `GameObject` 选root或者主camera ，建议放在每个 `Ui Root` 最上层
5. 然后进行打包成app就可以了，目前只试过安卓的（持续更新。。。）



### 测试是否成功接入SDK （需要Airtest IDE）

1. 将已经接入SDK的包安装到手机，并连接至电脑且打开Airtest IDE
2. 在Airtest IDE 右侧 `Poco辅助窗` 下拉框中选择Unity，然后在 `Poco辅助窗` 下方看到有控件树了代表接入成功了（一般分很多UI Root）有的页面没有控件树的话需要在其他的页面接入 `PocoManager.cs ` 组件（SDK）
3. 然后就能像操作原生Android app 那样开心的操作Unity控件了~



### 代码中引入poco框架

```python
# -*- encoding=utf8 -*-

from poco.drivers.unity3d import UnityPoco

poco = UnityPoco()

# 可以使用poco下的任意api
poco("控件ID/name").click()

# ...
```



### Poco instance API （关于poco实例化的API）

参考官方文档 [Poco instance API](https://poco.readthedocs.io/zh_CN/latest/source/poco.pocofw.html)



### UI proxy object API （关于poco操作控件的API）

参考官方文档 [UI proxy object API](https://poco.readthedocs.io/zh_CN/latest/source/poco.proxy.html)

