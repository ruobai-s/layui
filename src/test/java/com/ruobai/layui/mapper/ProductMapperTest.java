package com.ruobai.layui.mapper;

import com.ruobai.layui.vo.ProductBarVO;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@MapperScan("com.ruobai.layui.mapper")
class ProductMapperTest {
    @Autowired
    private ProductMapper mapper;
    @Test
    void test(){
        mapper.selectList(null).forEach(System.out::println);
    }
    @Test
    void test2(){
        List<ProductBarVO> list = mapper.findAllProductBarVO();
        int i=0;
    }
}