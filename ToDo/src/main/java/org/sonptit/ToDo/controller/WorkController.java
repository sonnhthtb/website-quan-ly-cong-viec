package org.sonptit.ToDo.controller;


import org.sonptit.ToDo.dto.UserDTO;
import org.sonptit.ToDo.dto.WorkDTO;
import org.sonptit.ToDo.service.IUserService;
import org.sonptit.ToDo.service.IWorkService;
import org.sonptit.ToDo.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class WorkController {


    @Autowired
    private IWorkService workService;

    @Autowired
    private IUserService userService;

    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView showList(@RequestParam(value = "message", required = false) String message,
                                 @RequestParam(value = "page", defaultValue = "1") int page,
                                 @AuthenticationPrincipal UserDetails currentUser){
        UserDTO userDTO = userService.findByUsername(currentUser.getUsername());
        Long id = userDTO.getId();
        WorkDTO model = new WorkDTO();
        int limit = 5;
        ModelAndView mav = new ModelAndView("view/home");
        Pageable pageable = PageRequest.of(page,limit);
        model.setListResult(workService.findAll(page, limit, id));
        model.setPage(page);
        model.setLimit(limit);
        mav.addObject("totalPages", workService.getTotalPages(page, limit, id));
        mav.addObject("totalItem", workService.getTotalItems(page,limit, id));
        if(message != null) {
            Map<String, String> messageMap = messageUtil.getMessage(message);
            mav.addObject("message", messageMap.get("message"));
            mav.addObject("alert", messageMap.get("alert"));
        }
        mav.addObject("model",model);
        return mav;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("id")  long id, @RequestParam(value = "message", required = false) String message,
                                @AuthenticationPrincipal UserDetails currentUser){
        UserDTO userDTO = userService.findByUsername(currentUser.getUsername());
        Long userid = userDTO.getId();
        ModelAndView mav = new ModelAndView("view/update");
        WorkDTO model = new WorkDTO();
        model = workService.findById(id, userid);
        model.setStatus(1);
        if(message != null) {
            Map<String, String> messageMap = messageUtil.getMessage(message);
            mav.addObject("message", messageMap.get("message"));
            mav.addObject("alert", messageMap.get("alert"));
        }
        mav.addObject("model",model);
        return mav;
    }

}
