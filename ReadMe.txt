mybatis就有完整配置

1. 全局文件配置
2. SqlSessionFactory配置
3. SqlSession
4. Mapper

mybatis實戰的配置
1. 引入maybatis starter
2. 配置xml位置(yml mapper-locations，或者直接使用註解的方式PersonMapper.java)
3. 編寫mapper接口(@Mapper，寫mapper可以被掃瞄。或者，懶得每個Mapper都寫@Mapper，直接在此 or configuration 使用 mapperscan)

交易管理
1. 啟動類加上，@EnableTransactionManagement
2. service層，加上@Transactional
3. 目前得討論，啟動類加上@EnableTransactionManagement是否需要
4. https://blog.csdn.net/qq_32370913/article/details/105924209
5. spring boot 自動加載的處理，會載入由TransactionAutoConfiguration.EnableTransactionManagementConfiguration；效果EnableTransactionManagement一樣