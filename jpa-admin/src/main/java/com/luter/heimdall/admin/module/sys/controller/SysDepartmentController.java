package com.luter.heimdall.admin.module.sys.controller;


import cn.hutool.core.util.StrUtil;
import com.luter.heimdall.admin.module.sys.dto.SysDepartmentDTO;
import com.luter.heimdall.admin.module.sys.entity.SysDepartmentEntity;
import com.luter.heimdall.admin.module.sys.service.SysDepartmentService;
import com.luter.heimdall.admin.module.sys.vo.SysDepartmentVO;
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
 * 组织机构 控制器
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/sys/department")
@Api(value = "组织机构", tags = "组织机构")
public class SysDepartmentController extends BaseJpaController {

    private final SysDepartmentService sysDepartmentService;

    /**
     * 根据ID查询单条组织机构记录详情
     *
     * @param id 对象唯一ID
     * @return 单个对象DTO
     */
    @GetMapping("/detail/{id}")
    @ApiOperation(value = "根据ID查询单条组织机构记录详情", notes = "根据ID查询单条组织机构记录详情", response = ResponseVO.class)
    @SysLog(value = "根据ID查询单条组织机构记录详情", type = BizType.DETAIL)
    public ResponseEntity<ResponseVO<SysDepartmentDTO>> getById(@PathVariable Long id) {
        SysDepartmentDTO data = sysDepartmentService.getById(id);
        return ResponseUtils.ok(data);
    }

    /**
     * 组织机构列表分页排序查询
     *
     * @return 统一分页列表数据
     */
    @GetMapping("/list")
    @ApiOperation(value = "组织机构列表数据查询", notes = "组织机构列表数据查询", response = PageDTO.class)
    @SysLog(value = "组织机构列表数据查询", type = BizType.LIST)
    public ResponseEntity<ResponseVO<PageDTO<SysDepartmentDTO>>> list(SysDepartmentVO param, PagerVO pager) {
        PageDTO<SysDepartmentDTO> list = sysDepartmentService.list(param, pager);
        return ResponseUtils.ok(list);
    }

    /**
     * 新增组织机构数据
     *
     * @param param 新增对象DTO
     * @return 新增结果
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增组织机构数据", notes = "新增组织机构数据", response = ResponseVO.class)
    @SysLog(value = "新增组织机构数据", type = BizType.INSERT)
    public ResponseEntity<ResponseVO<SysDepartmentDTO>> save(@Validated @RequestBody SysDepartmentVO param) {
        SysDepartmentDTO data = sysDepartmentService.save(param);
        return ResponseUtils.ok("新增成功", data);
    }

    /**
     * 修改组织机构数据
     *
     * @param param 修改对象DTO
     * @return 修改结果
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改组织机构数据", notes = "修改组织机构数据", response = ResponseVO.class)
    @SysLog(value = "修改组织机构数据", type = BizType.UPDATE)
    public ResponseEntity<ResponseVO<Void>> update(@Validated @RequestBody SysDepartmentVO param) {
        sysDepartmentService.update(param);
        return ResponseUtils.ok("修改成功");
    }

    @GetMapping("/tree")
    @ApiOperation(value = "组织机构树数据查询", notes = "组织机构树数据查询", response = PageDTO.class)
    @SysLog(value = "组织机构树数据查询", type = BizType.LIST)
    public ResponseEntity<ResponseVO<List<SysDepartmentDTO>>> tree(SysDepartmentVO param) {
        SysDepartmentDTO tree = sysDepartmentService.getDepartmentTree(param);
        return ResponseUtils.ok(tree.getChildren());
    }

    /**
     * 删除组织机构数据
     *
     * @param id 对象唯一ID
     * @return 删除成功或失败
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除组织机构数据", notes = "删除组织机构数据", response = ResponseVO.class)
    @SysLog(value = "根据ID删除单条组织机构记录", type = BizType.DELETE)
    public ResponseEntity<ResponseVO<Void>> delete(@PathVariable Long id) {
        int i = sysDepartmentService.deleteById(id);
        if (i == 1) {
            return ResponseUtils.ok("删除成功:" + i);
        }
        return ResponseUtils.fail("删除失败" + i);
    }

    /**
     * 判断组织机构某个属性值是否存在
     */
    @PostMapping("/exist")
    @ApiOperation(value = "判断组织机构某个属性值是否存在", notes = "判断组织机构某个属性值是否存在", response = ResponseVO.class)
    @SysLog
    public ResponseEntity<ResponseVO<Boolean>> isExisted(String prop, String value) {
        if (null == prop || StrUtil.isEmpty(value)) {
            return ResponseUtils.fail("参数错误,属性名称和值不能为空", null);
        }
        return ResponseUtils.ok("", sysDepartmentService.isExist(SysDepartmentEntity.class, prop, value));
    }
}


