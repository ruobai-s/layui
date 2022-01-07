package com.ruobai.layui.service;

import com.ruobai.layui.vo.BarVO;
import com.ruobai.layui.vo.DataVO;
import com.ruobai.layui.vo.PieVO;
import com.ruobai.layui.vo.ProductVO;

import java.util.List;

public interface ProductService {
    public DataVO<ProductVO> findData(Integer page,Integer limit);
    public BarVO getBarVO();
    public List<PieVO> getPieVO();
}
