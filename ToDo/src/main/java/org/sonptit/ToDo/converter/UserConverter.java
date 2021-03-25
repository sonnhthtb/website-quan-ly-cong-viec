package org.sonptit.ToDo.converter;

import org.sonptit.ToDo.dto.UserDTO;
import org.sonptit.ToDo.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity toEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setFullName(userDTO.getFullName());
        return userEntity;
    }

    public UserEntity toEntity(UserDTO userDTO, UserEntity userEntity){
        userEntity.setId(userDTO.getId());
        userEntity.setUsername(userDTO.getUsername());
        userDTO.setPassword(userDTO.getPassword());
        userEntity.setFullName(userDTO.getFullName());
        return userEntity;
    }


    public UserDTO toDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        if(userEntity.getId() != null){
            userDTO.setId(userEntity.getId());
        }
        userDTO.setId(userEntity.getId());
        userDTO.setUsername(userEntity.getUsername());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setFullName(userEntity.getFullName());
        return userDTO;
    }
}
