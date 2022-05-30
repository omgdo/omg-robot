基于simbot的聊天机器人


### 第一次新设备登录，需要进行验证
#### 第一步 idea中设置JVM参数
1. 选择Run下面的Edit Configurations
   - 构建并运行 -> 修改选项 -> 添加VM参数并键入下列参数
   - `-Dmirai.no-desktop -Dmirai.slider.acptcha.supported`
2. 在浏览器复制验证码校验，f12 获取 ticket
3. 将ticket粘贴到命令行
啊手动阀