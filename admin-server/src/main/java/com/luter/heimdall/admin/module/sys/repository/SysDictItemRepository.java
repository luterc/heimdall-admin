package com.luter.heimdall.admin.module.sys.repository;

import com.luter.heimdall.admin.module.sys.entity.SysDictItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
public interface SysDictItemRepository extends JpaRepository<SysDictItemEntity, Long>, JpaSpecificationExecutor<SysDictItemEntity> {
    }
