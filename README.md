## 技术架构

- 服务降级和流量控制：sentinel
- 服务注册与发现：nacos
- 分布式配置& 事件驱动消息总线：nacos
- 分布式事务&dubbo：nacos
- 服务网关组件：gateway
- 服务间通信组件：restTemplate+ribbon,Openfeign



## DNS

- nacos数据库：127.0.0.1 config.db.com 
- 服务注册地址: 127.0.0.1 server.addr.com 
- 配置中心地址: 127.0.0.1 config.addr.com 

api接口模块基础包：


多租户：

- 独立数据库
- 共享数据库，独立 Schema
- 共享数据库，共享 Schema，共享数据表


> 参考项目：

