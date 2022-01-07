package com.ruobai.layui.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@MapperScan("com.ruobai.layui.mapper")
class ProductCategoryMapperTest {
    @Autowired
    private ProductCategoryMapper mapper;
    @Test
    void test(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",655);
        System.out.println(mapper.selectOne(wrapper));
    }
}