package org.sonptit.ToDo.service;

import org.sonptit.ToDo.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

    UserDTO save(UserDTO userDTO);

    UserDTO findByUsername(String username);

}
