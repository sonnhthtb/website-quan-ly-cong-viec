package org.sonptit.ToDo.converter;

import org.sonptit.ToDo.dto.WorkDTO;
import org.sonptit.ToDo.entity.WorkEntity;
import org.springframework.stereotype.Component;


@Component
public class WorkConverter {

    public WorkEntity toEntity(WorkDTO workDTO){
        WorkEntity workEntity = new WorkEntity();
        workEntity.setContent(workDTO.getContent());
        workEntity.setStatus(workDTO.getStatus());
        return workEntity;
    }

    public WorkEntity toEntity(WorkDTO workDTO, WorkEntity workEntity){
        workEntity.setContent(workDTO.getContent());
        workEntity.setStatus(workDTO.getStatus());
        return workEntity;
    }


    public WorkDTO toDTO(WorkEntity workEntity){
        WorkDTO workDTO = new WorkDTO();
        if(workEntity.getId() != null){
            workDTO.setId(workEntity.getId());
        }
        workDTO.setContent(workEntity.getContent());
        workDTO.setStatus(workEntity.getStatus());
        workDTO.setUserid(workEntity.getUser().getId());
        return workDTO;
    }
}
