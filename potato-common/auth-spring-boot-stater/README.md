# 三种授权模式
1. 授权码（authorization-code）
2. 隐藏式（implicit）
3. 密码式（password）
4. 客户端凭证（client credentials）



## ketytool

```none
lizhifudeMacBook-Pro:etc lizhifu$ 

sudo keytool -genkeypair -alias config-server -keyalg RSA -keystore config-server.keystore
Password:
输入密钥库口令:
再次输入新口令:
您的名字与姓氏是什么?
  [Unknown]:  lzhifu
您的组织单位名称是什么?
  [Unknown]:  organization
您的组织名称是什么?
  [Unknown]:  organization
您所在的城市或区域名称是什么?
  [Unknown]:  city
您所在的省/市/自治区名称是什么?
  [Unknown]:  province
该单位的双字母国家/地区代码是什么?
  [Unknown]:  china
CN=lzhifu, OU=organization, O=organization, L=city, ST=province, C=china是否正确?
  [否]:  y
```

 有效期365*10天