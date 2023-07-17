package com.kjczwl.commons;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/***
* @Description: 分页查询结果数据对象
* @Param: 
* @return: 
* @Author: Mr.Tang
* @Date: 2022/10/9
*/
@Data
@ApiModel(value = "分页查询结果数据对象")
public class PageResultVo<T> implements Serializable {

    private static final long serialVersionUID = 1539833190685888420L;

    /**
     * 每页显示的条数
     */
    @ApiModelProperty("每页数据条数，默认10")
    private long size = 10;
    /**
     * 当前的页码
     */
    @ApiModelProperty("当前页码")
    private long current;
    /**
     * 一共有多少条记录
     */
    @ApiModelProperty("数据条数")
    private long total;
    /**
     * 一共有多少页
     */
    @ApiModelProperty("一共有多少页")
    private long pages;
    /**
     * 每一页所显示的数据
     */
    @ApiModelProperty("数据列表")
    private List<T> records;


    /**
     * 将MyBatisPlus返回的IPage数据封装为自定义的PageBean
     *
     * @param page
     * @param <T>
     * @return
     */
    public static <T> PageResultVo<T> init(IPage<T> page) {
        PageResultVo<T> pageResultVo = new PageResultVo<>();
        if (page != null) {
            pageResultVo.setCurrent(page.getCurrent());
            pageResultVo.setPages(page.getPages());
            pageResultVo.setSize(page.getSize());
            pageResultVo.setTotal(page.getTotal());
            pageResultVo.setRecords(page.getRecords());
        }
        return pageResultVo;
    }
}
