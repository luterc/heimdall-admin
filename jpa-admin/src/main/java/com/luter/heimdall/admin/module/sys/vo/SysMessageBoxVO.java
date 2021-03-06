package com.luter.heimdall.admin.module.sys.vo;

import com.luter.heimdall.starter.model.base.AbstractVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 系统信箱 VO对象
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "系统信箱VO对象", description = "系统信箱VO对象")
@EqualsAndHashCode(callSuper = true)
public class SysMessageBoxVO extends AbstractVO implements Serializable {

    @ApiModelProperty("")
    private Long messageId;

    @ApiModelProperty("")
    private Integer msgType;

    @ApiModelProperty("")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime receivedTime;

    @ApiModelProperty("")
    private Long receiverId;

    @ApiModelProperty("")
    private Integer status;

    @ApiModelProperty("")
    private String title;

}
