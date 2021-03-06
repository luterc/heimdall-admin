package com.luter.heimdall.admin.module.sys.dto;

import com.luter.heimdall.starter.model.base.AbstractDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 字典分类 DTO对象
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "字典分类DTO对象", description = "字典分类DTO")
@EqualsAndHashCode(callSuper = true)
public class SysDictTypeDTO extends AbstractDTO implements Serializable {

    @ApiModelProperty("")
    private String name;
    private List<SysDictItemDTO> items;
}
