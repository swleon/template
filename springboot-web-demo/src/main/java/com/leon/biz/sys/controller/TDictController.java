package com.leon.biz.sys.controller;


import com.leon.biz.sys.entity.TDict;
import com.leon.biz.sys.service.ITDictService;
import com.leon.biz.sys.model.DictVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * <p>
 * 字典数据表 前端控制器
 * </p>
 *
 * @author minglei.chen
 * @since 2020-12-14
 */
@Api(tags = "系统字典", description = "字典接口", position = 2)
@ApiSupport(order = 2)
@RestController
@RequestMapping("/dict")
public class TDictController {

    @Autowired
    private ITDictService dictService;
    @Autowired
    Cache<String, List<TDict>> dictListCache;

    @ApiOperationSupport(author = "minglei.chen",
            ignoreParameters = {"xx", "xx2"})
    @ApiOperation(value = "列表分页查询", position = 1, notes = "数据源列表", produces = "application/json")
    @ApiImplicitParam(name = "uuid", value = "测试字段", paramType = "query", required = true, dataType = "string")
    @GetMapping("/pageslist")
    public ResponseEntity list(DictVO dictVO) {

        IPage<TDict> dictIPage = dictService.getPageList(dictVO);

        return ResponseEntity.ok(dictIPage);
    }

    @ApiOperation(value = "列表数据查询", position = 2)
    @GetMapping("/list")
    public ResponseEntity list() {

        List<TDict> dictList = dictListCache.getIfPresent("dictList");
        if (null != dictList) {
            return ResponseEntity.ok(dictList);
        }

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByDesc("id");
        queryWrapper.orderByAsc("dict_sort");

        dictList = dictService.list();
        dictListCache.put("dictList", dictList);

        return ResponseEntity.ok(dictList);
    }


    @ApiOperation(value = "根据字典类型获取详细字典列表", position = 3)
    @GetMapping("/get/{dict_type}")
    public ResponseEntity getListByType(@NotEmpty @PathVariable("dict_type") String dictType) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("dict_type", dictType);
        queryWrapper.orderByAsc("dict_sort");

        List<TDict> dictList = dictService.list(queryWrapper);
        return ResponseEntity.ok(dictList);
    }


}
