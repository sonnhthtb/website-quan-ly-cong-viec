package org.sonptit.ToDo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;


@Getter
@Setter
public class UserDTO extends AbstractDTO<UserDTO>{
    private String username;
    private String fullName;
    private String password;
}
