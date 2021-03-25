package org.sonptit.ToDo.service.impl;

import org.hibernate.NonUniqueResultException;
import org.sonptit.ToDo.converter.UserConverter;
import org.sonptit.ToDo.dto.CustomUserDetials;
import org.sonptit.ToDo.dto.UserDTO;
import org.sonptit.ToDo.entity.UserEntity;
import org.sonptit.ToDo.repository.UserRepository;
import org.sonptit.ToDo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) {
        UserEntity userEntity = userRepository.findByUsername(s);
        if(userEntity == null){
            throw new UsernameNotFoundException(s);
        }
        return new CustomUserDetials(userEntity);
    }

    @Override
    public UserDTO save(UserDTO userDTO){
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        UserEntity userEntity = userConverter.toEntity(userDTO);
        return userConverter.toDTO(userRepository.save(userEntity));
    }

    @Override
    public UserDTO findByUsername(String username) throws NonUniqueResultException {
        UserEntity entity = userRepository.findByUsername(username);
        if(entity != null) {
            return userConverter.toDTO(entity);
        }
        return null;
    }

}
