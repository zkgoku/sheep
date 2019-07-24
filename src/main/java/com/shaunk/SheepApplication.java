package com.shaunk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Project sheep
 * @Package com.shaunk.web
 * @Name SheepApplication
 * @Version 1.0
 * @Data: 2019/6/28 3:28 PM
 * @Author: shaunk
 * @Description: 启动入口
 */
@Slf4j
@SpringBootApplication
@MapperScan("com.shaunk.mapper")
@RestController
public class SheepApplication {

	@GetMapping("/")
	public String index(){
		return "the sheep start success";
	}

	public static void main(String[] args) {
		SpringApplication.run(SheepApplication.class, args);
		log.info("启动成功,0.0");
	}

}
