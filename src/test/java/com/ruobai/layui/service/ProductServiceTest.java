package com.ruobai.layui.service;

import com.ruobai.layui.vo.BarVO;
import com.ruobai.layui.vo.DataVO;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@MapperScan("com.ruobai.layui.mapper")
class ProductServiceTest {
    @Autowired
    private  ProductService service;
    @Test
    void findData() {
//        DataVO dataVO = service.findData();
        int i=0;
    }
    @Test
    void test(){
        BarVO barVO = service.getBarVO();
        int i=0;
    }
}