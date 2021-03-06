package com.luter.heimdall.admin.module.sys.repository;

import com.luter.heimdall.admin.module.sys.entity.SysDepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
/**
* 组织机构 Repository
*/
public interface SysDepartmentRepository extends JpaRepository<SysDepartmentEntity, Long>, JpaSpecificationExecutor<SysDepartmentEntity> {
    }
