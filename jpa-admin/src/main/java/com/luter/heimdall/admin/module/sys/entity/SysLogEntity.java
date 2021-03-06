package com.luter.heimdall.admin.module.sys.entity;

import com.luter.heimdall.starter.jpa.base.entity.JpaAbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 系统日志 实体类
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "m_log")
@Data
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Accessors(chain = true)
public class SysLogEntity extends JpaAbstractEntity implements Serializable {

    @Column(name = "app_host_ip")
    private String appHostIp;

    @Column(name = "app_name")
    private String appName;

    @Column(name = "app_port")
    private String appPort;

    @Column(name = "browser_name")
    private String browserName;

    @Column(name = "browser_version")
    private String browserVersion;

    @Column(name = "business_type")
    private Integer businessType;

    @Column(name = "consuming_time")
    private Long consumingTime;

    @Column(name = "exception_message")
    private String exceptionMessage;

    @Column(name = "method")
    private String method;

    @Column(name = "request_ip")
    private String requestIp;

    @Column(name = "request_method")
    private String requestMethod;

    @Column(name = "request_param")
    private String requestParam;

    @Column(name = "request_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime requestTime;

    @Column(name = "request_url")
    private String requestUrl;

    @Column(name = "response_result")
    private String responseResult;

    @Column(name = "status")
    private Integer status;

    @Column(name = "terminal_os_name")
    private String terminalOsName;

    @Column(name = "terminal_type")
    private Integer terminalType;

    @Column(name = "title")
    private String title;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_location")
    private String userLocation;

    @Column(name = "username")
    private String username;

}
