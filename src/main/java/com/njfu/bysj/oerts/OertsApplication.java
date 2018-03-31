/**
 * @FileName:		OertsApplication.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年1月10日 下午10:25:29
 *
 */
package com.njfu.bysj.oerts;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName:     	OertsApplication
 * @Description:	TODO
 *
 * @author:    		徐至彦
 * @date:        	2018年1月10日 下午10:25:29
 *
 */
@SpringBootApplication
@MapperScan("com.njfu.bysj.oerts.mapper")
public class OertsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OertsApplication.class, args);
	}
}
