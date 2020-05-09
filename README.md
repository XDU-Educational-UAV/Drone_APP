# 西电航协微型四轴PID版本Android APP源码

## Status

![Android CI](https://github.com/uav-operation-system/Drone_APP/workflows/Android%20CI/badge.svg?branch=master)

![stars](https://img.shields.io/github/stars/uav-operation-system/Drone_APP.svg) ![forks](https://img.shields.io/github/forks/uav-operation-system/Drone_APP.svg) ![tag](https://img.shields.io/github/tag/uav-operation-system/Drone_APP.svg) ![release](https://img.shields.io/github/release/uav-operation-system/Drone_APP.svg) ![issues](https://img.shields.io/github/issues/uav-operation-system/Drone_APP.svg)

## Overview

This is the source code of Android client for XDU Aero Association micro quadcopter.You could control the quadcopter from an Android smartphone through the Bluetooth 4.0 LE connection.This client need Android system 4.3 at least.

The latest version of Android 10.0 operating system will flash back when running this app. The reason is unknown.

This is the [Android Studio](http://developer.android.com/sdk/index.html) project.So you could import to Android Studio and run from source code easily.

At present, the project is in the stage of to be completed. Non producers should not clone the source code of the master branch.

When modifying the code, please create a new feature branch under the master branch, modify the code under the feature branch, and then perform the pull request operation through the branch. Confirm and merge to the main branch.

For bug related and suggestions, please move to the issue column

By Kidominox,phillweston

## 概要说明

这是西电航协微型四轴飞行器Android客户端的源代码，通过最新蓝牙4.0 BLE连接控制飞行器。BLE技术需要Android 4.3及以上系统支持。

最新版Android10.0操作系统运行此应用会黑屏闪退，原因不明。

这是一个[Android Studio](http://developer.android.com/sdk/index.html)工程，直接导入到Android Studio中就可以编译运行。

该项目目前出于待完成阶段，非制作人员勿克隆master分支源码

修改代码的时候，请在master分支下面新建一个特性分支，在该特性分支下进行代码的修改然后通过该分支执行pull request操作。确认无误后再合并至主分支。

bug相关和建议请移步至issue栏目

## 作者名单

作者：Kidominox,Phillweston

## 项目进度
已完成：
1、蓝牙的搜索与连接
2、虚拟摇杆的控制
3、界面完备
4、数据串口（未测试）

|Tag|功能|完成日期|
|:-:|:-:|:-:|
|0.1.0|搭建最基本博客环境并线上构建成功|待定|
|0.1.1|创建博客核心页面|待定|
|0.1.2|添加导言区、页面自动跳转|待定|
|0.1.3|READ.ME功能说明|待定|
|0.1.4|APP与无人机数据传输测试|2020年5月中旬|