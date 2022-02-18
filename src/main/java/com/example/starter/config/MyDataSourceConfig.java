package com.example.starter.config;

/**
 * 只是範例，有要使用再打開
 * 
 * druid: https://github.com/alibaba/druid
 *
 */
@Deprecated
//@Configuration
public class MyDataSourceConfig {
	
	/**
	 * 當有自行配置數據源時，boot autoconfiguration，就不會自動生成com.zaxxer.hikari.HikariDataSource
	 * 
	 * 另外可以啟用spring.datasource，將yml的設定資料，啟用，達到配置抽取；(xxx.set的名稱要一致)
	 * @throws SQLException 
	 */
//	@ConfigurationProperties("spring.datasource")
//	@Bean
//	public DataSource dataSource() throws SQLException {
//		DruidDataSource druid = new DruidDataSource();
//		
////		開啟監控功能。
////		https://github.com/alibaba/druid/wiki/%E9%85%8D%E7%BD%AE_StatFilter
//		druid.setFilters("stat");
//		
//		return druid;
//	}
//	
//	/**
//	 * 自訂義的servlet(以往要再web.xml內配置)
//	 * 配置，druid的監控，https://github.com/alibaba/druid/wiki/%E9%85%8D%E7%BD%AE_StatViewServlet%E9%85%8D%E7%BD%AE
//	 */
//	@Bean
//	public ServletRegistrationBean<StatViewServlet> statViewServlet() {
//		StatViewServlet statViewServlet = new StatViewServlet();
//		ServletRegistrationBean<StatViewServlet> rgBean = new ServletRegistrationBean<StatViewServlet>(statViewServlet, "/druid/*");
//		
//		rgBean.addInitParameter("loginUsername", "druid");
//		rgBean.addInitParameter("loginPassword", "druid");
//		
//		return rgBean;
//	}
//	
//	/**
//	 * 自訂義的filter(以往要再web.xml內配置)
//	 * https://github.com/alibaba/druid/wiki/%E9%85%8D%E7%BD%AE_%E9%85%8D%E7%BD%AEWebStatFilter
//	 */
//	@Bean
//	public FilterRegistrationBean<WebStatFilter> webStatFilter() {
//		WebStatFilter webStatFilter = new WebStatFilter();
//		
//		FilterRegistrationBean<WebStatFilter> fiBean = new FilterRegistrationBean<WebStatFilter>(webStatFilter);
//		fiBean.setUrlPatterns(Arrays.asList("/*"));
//		fiBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//		return fiBean;
//	}
	
}
