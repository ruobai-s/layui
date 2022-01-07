package com.ruobai.layui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruobai.layui.entity.Product;
import com.ruobai.layui.entity.ProductCategory;
import com.ruobai.layui.mapper.ProductCategoryMapper;
import com.ruobai.layui.mapper.ProductMapper;
import com.ruobai.layui.service.ProductService;
import com.ruobai.layui.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Autowired
    private ProductMapper productMapper;
    @Override
    public DataVO<ProductVO> findData(Integer page,Integer limit) {
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        IPage<Product> productIPage = new Page<>(page,limit);
        IPage<Product> result=productMapper.selectPage(productIPage,null);
        List<Product> productList = result.getRecords();
        dataVO.setCount(result.getTotal());
        List<ProductVO> productVOList = new ArrayList<>();
        for (Product product:productList) {
            ProductVO productVO = new ProductVO();
            BeanUtils.copyProperties(product,productVO);
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("id",product.getCategoryleveloneId());
            ProductCategory productCategory = productCategoryMapper.selectOne(wrapper);
            if (productCategory!=null){
                productVO.setCategorylevelone(productCategory.getName());
            }
            wrapper  = new QueryWrapper();
            wrapper.eq("id",product.getCategoryleveltwoId());
            productCategory = productCategoryMapper.selectOne(wrapper);
            if (productCategory!=null){
                productVO.setCategoryleveltwo(productCategory.getName());
            }
            wrapper  = new QueryWrapper();
            wrapper.eq("id",product.getCategorylevelthreeId());
            productCategory = productCategoryMapper.selectOne(wrapper);
            if (productCategory!=null){
                productVO.setCategorylevelthree(productCategory.getName());
            }
            productVOList.add(productVO);
        }
        dataVO.setData(productVOList);
        return dataVO;
    }

    @Override
    public BarVO getBarVO() {
        List<ProductBarVO> list = productMapper.findAllProductBarVO();
        List<String> names = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        for (ProductBarVO productBarVO : list) {
            names.add(productBarVO.getName());
            values.add(productBarVO.getCount());
        }
        BarVO barVO = new BarVO();
        barVO.setNames(names);
        barVO.setValues(values);
        return barVO;
    }

    @Override
    public List<PieVO> getPieVO() {
        List<ProductBarVO> list = productMapper.findAllProductBarVO();
        List<PieVO> pieVOList = list.stream()
                .map(e -> new PieVO(
                        e.getCount(),
                        e.getName()
                )).collect(Collectors.toList());
        return pieVOList;
    }
}
