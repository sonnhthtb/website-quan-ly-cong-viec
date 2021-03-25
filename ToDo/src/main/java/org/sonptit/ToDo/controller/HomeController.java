package org.sonptit.ToDo.controller;

import org.sonptit.ToDo.api.WorkAPI;
import org.sonptit.ToDo.dto.WorkDTO;
import org.sonptit.ToDo.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "message", required = false) String message){
        ModelAndView mav = new ModelAndView("/login/login");
        if(message != null) {
            Map<String, String> messageMap = messageUtil.getMessage(message);
            mav.addObject("message", messageMap.get("message"));
            mav.addObject("alert", messageMap.get("alert"));
        }
        return mav;
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public ModelAndView reg(@RequestParam(value = "message", required = false) String message){
        ModelAndView mav = new ModelAndView("/login/reg");
        if(message != null) {
            Map<String, String> messageMap = messageUtil.getMessage(message);
            mav.addObject("message", messageMap.get("message"));
            mav.addObject("alert", messageMap.get("alert"));
        }
        return mav;
    }
}