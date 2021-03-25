package org.sonptit.ToDo.service.impl;


import org.sonptit.ToDo.converter.WorkConverter;
import org.sonptit.ToDo.dto.WorkDTO;
import org.sonptit.ToDo.entity.WorkEntity;
import org.sonptit.ToDo.repository.UserRepository;
import org.sonptit.ToDo.repository.WorkRepository;
import org.sonptit.ToDo.service.IWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkService implements IWorkService {


    @Autowired
    private WorkRepository workRepository;


    @Autowired
    private WorkConverter workConverter;

    @Autowired
    private UserRepository userRepository;

    @Override
    public WorkDTO save(WorkDTO workDTO, Long userid) {
        WorkEntity workEntity = new WorkEntity();
        if(workDTO.getId() != null) {
            WorkEntity oldEntity = workRepository.findById(workDTO.getId()).orElse(null);
            workEntity = workConverter.toEntity(workDTO,oldEntity);
        }
        else {
            workEntity = workConverter.toEntity(workDTO);
        }
        workEntity.setUser(userRepository.findById(userid).orElse(null));
        workEntity = workRepository.save(workEntity);
        return workConverter.toDTO(workEntity);
    }

    @Override
    public void delete(long id, Long userid) {
            workRepository.deleteByIdAndUserId(id,userid);
    }


    @Override
    public WorkDTO findById(long id, Long userid) {
        WorkEntity workEntity = workRepository.findByIdAndUserId(id,userid);
        return workConverter.toDTO(workEntity);
    }

    @Override
    public List<WorkDTO> findAll(int page, int limit, Long id) {
        Pageable pageable = PageRequest.of(page-1, limit, Sort.by("id").descending());
        Page<WorkEntity> pages = workRepository.findAllByUserId(id,pageable);
        List<WorkEntity> entities = pages.getContent();
        List<WorkDTO> result = new ArrayList<>();
        for(WorkEntity item: entities) {
            WorkDTO workDTO = workConverter.toDTO(item);
            result.add(workDTO);
        }
        return result;
    }

    @Override
    public void deleteAll(Long userid) {
        workRepository.deleteAllByUserId(userid);
    }

    @Override
    public int getTotalPages(int page, int limit, Long id) {
        Pageable pageable = PageRequest.of(page-1, limit,Sort.by("id").descending());
        Page<WorkEntity> pages = workRepository.findAllByUserId(id,pageable);
        return pages.getTotalPages();
    }

    @Override
    public long getTotalItems(int page, int limit, Long id) {
        Pageable pageable = PageRequest.of(page-1, limit, Sort.by("id").descending());
        Page<WorkEntity> pages = workRepository.findAllByUserId(id, pageable);
        return pages.getTotalElements();
    }
}
