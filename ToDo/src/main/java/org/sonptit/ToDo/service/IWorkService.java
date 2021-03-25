package org.sonptit.ToDo.service;

import org.sonptit.ToDo.dto.WorkDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IWorkService {

    WorkDTO save(WorkDTO workDTO, Long userid);
    void delete(long id, Long userid);
    WorkDTO findById(long id, Long userid);
    List<WorkDTO> findAll(int page, int limit, Long id);
    void deleteAll(Long userid);
    int getTotalPages(int page, int limit, Long id);
    long getTotalItems(int page, int limit, Long id);
}
