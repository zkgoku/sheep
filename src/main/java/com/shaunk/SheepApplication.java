package com.shaunk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@Slf4j
@SpringBootApplication
@MapperScan("com.shaunk.mapper")
public class SheepApplication {

	public static void main(String[] args) {
		SpringApplication.run(SheepApplication.class, args);
		log.info("启动成功,0.0");
	}

}
