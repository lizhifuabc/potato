# nacos配置中心配置
## 配置信息
### 官方文档
https://nacos.io/zh-cn/docs/quick-start.html
### 版本选择
下载地址为：https://github.com/alibaba/nacos/releases

选用版本为2.0.3

启动命令(standalone代表着单机模式运行，非集群模式):

sh startup.sh -m standalone

### 访问

[Nacos](http://127.0.0.1:8848/nacos/#/login)


### 常见错误

jdk不兼容问题：[使用startup.sh启动nacos时，如果JAVA_OPT_EXT_FIX变量值为空，将不能正常启动 · Issue #6609 · alibaba/nacos (github.com)](https://github.com/alibaba/nacos/issues/6609)
> 找不到或无法加载主类: java.lang.ClassNotFoundException:



```sh
# JAVA_OPT_EXT_FIX="-Djava.ext.dirs=${JAVA_HOME}/jre/lib/ext:${JAVA_HOME}/lib/ext"
JAVA ="${JAVA} -Djava.ext.dirs=${JAVA_HOME}/jre/lib/ext:${JAVA_HOME}/lib/ext"

# echo "$JAVA $JAVA_OPT_EXT_FIX ${JAVA_OPT}"
echo "$JAVA ${JAVA_OPT}"

# echo "$JAVA $JAVA_OPT_EXT_FIX ${JAVA_OPT}" > ${BASE_DIR}/logs/start.out 2>&1 &
# nohup "$JAVA" "$JAVA_OPT_EXT_FIX" ${JAVA_OPT} nacos.nacos >> ${BASE_DIR}/logs/start.out 2>&1 &

echo "$JAVA ${JAVA_OPT}" > ${BASE_DIR}/logs/start.out 2>&1 &
nohup "$JAVA" ${JAVA_OPT} nacos.nacos >> ${BASE_DIR}/logs/start.out 2>&1 &
```

