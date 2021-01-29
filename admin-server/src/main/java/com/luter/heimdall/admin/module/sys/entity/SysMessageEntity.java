package com.luter.heimdall.admin.module.sys.entity;

import com.luter.heimdall.starter.jpa.base.entity.JpaAbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "sys_message")
@DynamicInsert
@DynamicUpdate
@org.hibernate.annotations.Table(comment = "系统通知消息内容表", appliesTo = "sys_message")
@Data
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Accessors(chain = true)
public class SysMessageEntity extends JpaAbstractEntity {
    private static final long serialVersionUID = -1161260110746739172L;
    @Column(name = "title", nullable = false, unique = true, length = 100)
    @NotBlank(message = "标题不能为空")
    private String title;
    @Column(name = "sender_id", nullable = false)
    @NotNull(message = "发送人ID不能为空")
    private Long senderId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "send_time", nullable = false)
    private LocalDateTime sendTime;
    @NotNull(message = "类型不能为空")
    @Column(name = "msg_type", nullable = false)
    private Integer msgType;
    @Column(name = "content")
    @Lob
    private String content;
}
