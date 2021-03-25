package org.sonptit.ToDo.api;


import org.sonptit.ToDo.api.output.WorkOutput;
import org.sonptit.ToDo.dto.UserDTO;
import org.sonptit.ToDo.dto.WorkDTO;
import org.sonptit.ToDo.service.IUserService;
import org.sonptit.ToDo.service.IWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkAPI {

    @Autowired
    private IWorkService workService;

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/todo")
    public List<WorkDTO> getAll(@AuthenticationPrincipal UserDetails currentUser){
        UserDTO userDTO = userService.findByUsername(currentUser.getUsername());
        Long id = userDTO.getId();
        return workService.findAll(1,5, id);
    }

    @PostMapping(value = "/todo")
    public WorkDTO createWork(@RequestBody WorkDTO model, @AuthenticationPrincipal UserDetails currentUser){
        UserDTO userDTO = userService.findByUsername(currentUser.getUsername());
        Long id = userDTO.getId();
        return workService.save(model, id);
    }

    @PutMapping(value = "/todo/{id}")
    public WorkDTO updateWork(@RequestBody WorkDTO model, @PathVariable("id") Long id, @AuthenticationPrincipal UserDetails currentUser){
        model.setId(id);
        UserDTO userDTO = userService.findByUsername(currentUser.getUsername());
        Long userid = userDTO.getId();
        return workService.save(model,userid);
    }

    @DeleteMapping(value = "/todo/{id}")
    public void delete(@PathVariable("id") long id, @AuthenticationPrincipal UserDetails currentUser){
        UserDTO userDTO = userService.findByUsername(currentUser.getUsername());
        Long userid = userDTO.getId();
        workService.delete(id, userid);
    }

    @DeleteMapping(value = "/todo")
    public void delete(@AuthenticationPrincipal UserDetails currentUser){
        UserDTO userDTO = userService.findByUsername(currentUser.getUsername());
        Long id = userDTO.getId();
        workService.deleteAll(id);
    }

}
