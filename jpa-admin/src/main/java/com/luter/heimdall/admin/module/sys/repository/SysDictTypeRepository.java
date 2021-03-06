package com.luter.heimdall.admin.module.sys.repository;

import com.luter.heimdall.admin.module.sys.entity.SysDictTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
/**
* 字典分类 Repository
*/
public interface SysDictTypeRepository extends JpaRepository<SysDictTypeEntity, Long>, JpaSpecificationExecutor<SysDictTypeEntity> {
    }
