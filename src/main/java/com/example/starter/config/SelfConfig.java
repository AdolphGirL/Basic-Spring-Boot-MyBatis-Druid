package com.example.starter.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.example.starter.bean.BeanPet;
import com.example.starter.bean.BeanUser;
import com.example.starter.bean.ImportUser;

/**
 * annotation方式的設定檔；
 * (配置類的實現，其實也是個single bean)
 * 
 * spring boot 2.x，多增加了一個屬性proxyBeanMethods(@since 5.2，spring)
 * proxyBeanMethods，代理類方法
 * 
 * 簡易結論，在proxyBeanMethods=true的情況下，多次使用設定檔取得bean實例，
 * 理論上都是單一的
 * 細節，請再自行參閱文件
 * 
 * @import
 * 導入類別，使用該類別的無參建構器；默認名稱，全類名(com.example.starter.bean.ImportUser)
 * 
 * @ImportResource，自行查閱
 * @ConfigurationProperties
 */
@Import(ImportUser.class)
@Configuration
public class SelfConfig {
	
	/**
	 * proxyBeanMethods = true，表示，SelfConfig本身就是個spring的代理對象。
	 * 使用SelfConfig.getBeanPet()獲取的BeanPet實例，透過代理對象(SelfConfig)，都會去容器中檢查註冊的實例是否存在
	 * 存在則調用，不存在才重新new一個實例
	 * 
	 * @ConditionalOnBean(value = BeanUser.class)，當存在BeanUser，再生成BeanPet
	 * 若標註在class上，則條件成立十，該class內做的事情才會生成
	 */
	@ConditionalOnBean(value = BeanUser.class)
	@Bean(name = "pet")
	public BeanPet getBeanPet() {
		return new BeanPet();
	}
	
//	@Bean(name = "beanuser")
//	public BeanUser getBeanUser() {
//		return new BeanUser();
//	}
	
}
