package com.ruobai.layui.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruobai.layui.entity.Product;
import com.ruobai.layui.vo.ProductBarVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public interface ProductMapper extends BaseMapper<Product> {
    @Select("select p.name,sum(quantity) count from order_detail od,product p where od.product_id=p.id group by  product_id")
    public List<ProductBarVO> findAllProductBarVO();
}
