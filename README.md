# fast-architecture 一套基础的以MVP为基础的快速开发架构
[![JCenter](https://img.shields.io/badge/%20JCenter%20-1.0.0-5bc0de.svg)](https://bintray.com/element/maven/fast-architecture/_latestVersion)

一套基础的以MVP为基础的快速开发架构 ，包含OKHttp + Retrofit + RxJava + Dagger2 + RxCache等库，提供了简洁易用的各种基类

本库是基于大神JessYan的[MVPArms](https://github.com/JessYanCoding/MVPArms)上的部分修改

## 使用方法
#### 1.在 build.gradle 中添加依赖
```
implementation 'com.github.chengzhijun0706:fast-architecture:1.0.0'
```
#### 2.实现ConfigModule类，配置BaseUrl以及其他配置（参考demo中的GlobalConfiguration）

#### 3.在AndroidManifest.xml中配置ConfigModule
```
<meta-data
     android:name="ConfigModule实现类的完整名字"
     android:value="ConfigModule" />
```
#### 4.将MVPArmsTemplate文件夹，复制到以下目录，只针对mac
```
/Applications/Android\ Studio.app/Contents/plugins/android/lib/templates/activities
```
