package com.ruobai.layui.controller;

import com.ruobai.layui.mapper.ProductMapper;
import com.ruobai.layui.service.ProductService;
import com.ruobai.layui.vo.BarVO;
import com.ruobai.layui.vo.DataVO;
import com.ruobai.layui.vo.PieVO;
import com.ruobai.layui.vo.ProductBarVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;
    @RequestMapping("/list")
    @ResponseBody
    public DataVO list(Integer page,Integer limit){
        System.out.println(page+"" + limit);
        return productService.findData(page,limit);
    }
    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url){
        return url;
    }

    @RequestMapping("/barVO")
    @ResponseBody
    public BarVO getBarVO(){
        return productService.getBarVO();
    }
//    @RequestMapping("/pieVO")
//    @ResponseBody
//    public List<PieVO> getPieVO(){
//        return productService.getPieVO();
//    }
    @RequestMapping("/pieVO")
    @ResponseBody
    public List<ProductBarVO> getPieVO(){
        return productMapper.findAllProductBarVO();
    }
}
