
## 使用

### 添加Gradle依赖

1.先在项目根目录的 build.gradle 的 repositories 添加:
```
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

2.然后在dependencies添加:

```
// 核心
implementation 'com.github.stepyen.XUtil:xutil-core:1.0'
// 附加
implementation 'com.github.stepyen.XUtil:xutil-sub:1.0'
```

3.在Application进行初始化:

```
XUtil.init(this);
```
------------------------------------

## 文档

### 基础工具类内容(xutil-core)

[点击查看](./xutil-core/README.md)

### 附加工具类内容(xutil-sub)

[点击查看](./xutil-sub/README.md)

### 如何使用Gradle脚本进行代码上传

[点击查看](./README_UPLOAD.md)

## 特别感谢

https://github.com/Blankj/AndroidUtilCode

https://github.com/xuexiangjys/XUtil

