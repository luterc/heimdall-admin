package com.luter.heimdall.admin.module.sys.controller;


import cn.hutool.core.util.StrUtil;
import com.luter.heimdall.admin.module.sys.dto.SysDictItemDTO;
import com.luter.heimdall.admin.module.sys.entity.SysDictItemEntity;
import com.luter.heimdall.admin.module.sys.service.SysDictItemService;
import com.luter.heimdall.admin.module.sys.vo.SysDictItemVO;
import com.luter.heimdall.starter.jpa.base.controller.BaseJpaController;
import com.luter.heimdall.starter.model.base.ResponseVO;
import com.luter.heimdall.starter.model.pagination.PageDTO;
import com.luter.heimdall.starter.model.pagination.PagerVO;
import com.luter.heimdall.starter.syslog.annotation.SysLog;
import com.luter.heimdall.starter.syslog.enums.BizType;
import com.luter.heimdall.starter.utils.response.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 字典项 控制器
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/sys/dict/item")
@Api(value = "字典项", tags = "字典项")
public class SysDictItemController extends BaseJpaController {

    private final SysDictItemService sysDictItemService;

    /**
     * 根据ID查询单条字典项记录详情
     *
     * @param id 对象唯一ID
     * @return 单个对象DTO
     */
    @GetMapping("/detail/{id}")
    @ApiOperation(value = "根据ID查询单条字典项记录详情", notes = "根据ID查询单条字典项记录详情", response = ResponseVO.class)
    @SysLog(value = "根据ID查询单条字典项记录详情", type = BizType.DETAIL)
    public ResponseEntity<ResponseVO<SysDictItemDTO>> getById(@PathVariable Long id) {
        SysDictItemDTO data = sysDictItemService.getById(id);
        return ResponseUtils.ok(data);
    }

    /**
     * 字典项列表分页排序查询
     *
     * @return 统一分页列表数据
     */
    @GetMapping("/list")
    @ApiOperation(value = "字典项列表数据查询", notes = "字典项列表数据查询", response = PageDTO.class)
    @SysLog(value = "字典项列表数据查询", type = BizType.LIST)
    public ResponseEntity<ResponseVO<PageDTO<SysDictItemDTO>>> list(SysDictItemVO param, PagerVO pager) {
        PageDTO<SysDictItemDTO> list = sysDictItemService.list(param, pager);
        return ResponseUtils.ok(list);
    }

    @GetMapping("/list/type")
    @ApiOperation(value = "根据分类ID获取字典分类下所有数据", notes = "根据分类ID获取字典分类下所有数据", response = PageDTO.class)
    @SysLog(value = "根据分类ID获取字典分类下所有数据", type = BizType.LIST)
    public ResponseEntity<ResponseVO<List<SysDictItemDTO>>> listAll(SysDictItemVO param) {
        List<SysDictItemDTO> list = sysDictItemService.listByTypeId(param.getTypeId());
        return ResponseUtils.ok(list);
    }

    /**
     * 新增字典项数据
     *
     * @param param 新增对象DTO
     * @return 新增结果
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增字典项数据", notes = "新增字典项数据", response = ResponseVO.class)
    @SysLog(value = "新增字典项数据", type = BizType.INSERT)
    public ResponseEntity<ResponseVO<SysDictItemDTO>> save(@Validated @RequestBody SysDictItemVO param) {
        SysDictItemDTO data = sysDictItemService.save(param);
        return ResponseUtils.ok("新增成功", data);
    }

    /**
     * 修改字典项数据
     *
     * @param param 修改对象DTO
     * @return 修改结果
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改字典项数据", notes = "修改字典项数据", response = ResponseVO.class)
    @SysLog(value = "修改字典项数据", type = BizType.UPDATE)
    public ResponseEntity<ResponseVO<Void>> update(@Validated @RequestBody SysDictItemVO param) {
        sysDictItemService.update(param);
        return ResponseUtils.ok("修改成功");
    }

    /**
     * 删除字典项数据
     *
     * @param id 对象唯一ID
     * @return 删除成功或失败
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除字典项数据", notes = "删除字典项数据", response = ResponseVO.class)
    @SysLog(value = "根据ID删除单条字典项记录", type = BizType.DELETE)
    public ResponseEntity<ResponseVO<Void>> delete(@PathVariable Long id) {
        int i = sysDictItemService.deleteById(id);
        if (i == 1) {
            return ResponseUtils.ok("删除成功:" + i);
        }
        return ResponseUtils.fail("删除失败" + i);
    }

    /**
     * 判断字典项某个属性值是否存在
     */
    @PostMapping("/exist")
    @ApiOperation(value = "判断字典项某个属性值是否存在", notes = "判断字典项某个属性值是否存在", response = ResponseVO.class)
    @SysLog
    public ResponseEntity<ResponseVO<Boolean>> isExisted(String prop, String value) {
        if (null == prop || StrUtil.isEmpty(value)) {
            return ResponseUtils.fail("参数错误,属性名称和值不能为空", null);
        }
        return ResponseUtils.ok("", sysDictItemService.isExist(SysDictItemEntity.class, prop, value));
    }
}


