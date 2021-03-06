package com.berrontech.erp.web.user;

import com.berrontech.erp.commons.context.ContextPackage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Create By Levent8421
 * Create Time: 2021/3/5 18:27
 * Class Name: ErpUserApplication
 * Author: Levent8421
 * Description:
 * 启动类
 *
 * @author Levent8421
 */
@SpringBootApplication(scanBasePackages = ContextPackage.BASE_PACKAGE)
@MapperScan(basePackages = ContextPackage.MAPPER_PACKAGE)
public class ErpUserApplication {
    /**
     * Main Method
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        SpringApplication.run(ErpUserApplication.class, args);
    }
}
