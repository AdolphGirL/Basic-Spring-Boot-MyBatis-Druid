package com.example.starter.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.starter.domain.ValidUser;
import com.example.starter.response.ResultCode;
import com.example.starter.response.ResultVO;
import com.example.starter.service.ValidUserService;

import lombok.extern.slf4j.Slf4j;
//import com.example.starter.service.impl.ValidUserServiceImpl;

@Slf4j
@RestController
@RequestMapping("/valid")
public class ValidController {
	
//	TODO Resource，是javax.annotation.Resource，非spring註解，但spring支持
//	resource，是byname尋找(也支持by type)
//	建議將此annotation放在setter上，透過getter setter操作
//	@Resource
	private ValidUserService validUserService;
	
	public ValidUserService getValidUserService() {
		return validUserService;
	}

//	by name，by type，不寫就是by name
//	@Resource(name = "validUserServiceImpl")
//	@Resource(type = ValidUserServiceImpl.class)
	@Resource
	public void setValidUserService(ValidUserService validUserService) {
		this.validUserService = validUserService;
	}
	
//	@PostMapping("/addValidUser")
//	public String addValidUser(@RequestBody @Valid ValidUser user, BindingResult bindingResult) {
//		log.info("[+] [addValidUser] bindingResult: {} ", bindingResult.toString());
//		
////		當有任何設定上的錯誤，就會綁定為物件，封裝在bindingResult上
//		for (ObjectError error : bindingResult.getAllErrors()) {
//			return error.getDefaultMessage();
//		}
//		
//		return this.getValidUserService().addValidUser(user);
//	}
	
//	去掉BindingResult，如果不處理，會發生[MethodArgumentNotValidException]
	@PostMapping("/addValidUser")
	public String addValidUser(@RequestBody @Valid ValidUser user) {
		return this.getValidUserService().addValidUser(user);
	}
	
	/**
	 * 會交由RestResponseControllerAdvice處理返回資料
	 * @return
	 */
	@GetMapping("/getValidUser")
	public ValidUser getValidUser() {
		ValidUser user = new ValidUser();
		user.setName("中文名字");
		user.setEmail("XXXX");
		return user;
	}
	
	/**
	 * 測試字串，會交由RestResponseControllerAdvice進行封裝，封裝後交由reponse處理，因此需要添加上produces = "application/json;charset=UTF-8"
	 * 防止中文亂碼
	 * @return
	 */
	@GetMapping(value = "/getValidUserStr", produces = "application/json;charset=UTF-8")
	public String getValidUserStr() {
		return "getValidUserStr";
	}
	
	/**
	 * 不會交由RestResponseControllerAdvice進行封裝，因此reponse交由@RestController定義的處理(雖然getmapping沒有特別指定produces)
	 * @return
	 */
	@GetMapping("/getValidUserRs")
	public ResultVO<String> getValidUserRs() {
		return new ResultVO<>(ResultCode.SUCCESS, "爽的"); 
	}
}
