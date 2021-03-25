package org.sonptit.ToDo.repository;

import org.sonptit.ToDo.entity.WorkEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface WorkRepository extends JpaRepository<WorkEntity, Long> {

    Page<WorkEntity> findAllByUserId(Long userid, Pageable pageable);

    @Transactional
    @Modifying
    void deleteByIdAndUserId(@Param("id")long id, @Param("userid") Long userid);

    @Transactional
    @Modifying
    void deleteAllByUserId(Long userid);

    WorkEntity findByIdAndUserId(long id, Long userid);

}
