package com.lib.api.app.v1.repository;

import com.lib.api.app.v1.entity.Admin;

public interface AdminRepositoryCustom {
    Admin findByIdx(Long adminIdx);
}
