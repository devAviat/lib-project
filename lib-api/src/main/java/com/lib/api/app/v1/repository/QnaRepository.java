package com.lib.api.app.v1.repository;

import com.lib.api.app.v1.entity.Qna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QnaRepository extends JpaRepository<Qna, Long>, QnaRepositoryCustom{
}
