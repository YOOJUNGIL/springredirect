package com.myalley.springskill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(Model model, @RequestParam String name) {
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/user/index")
    public RedirectView userIndex(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("name", "999yoojungil999");
        return new RedirectView("/index");
    }

    @GetMapping("/user/index1")
    public RedirectView userIndex1(RedirectAttributes redirectAttributes) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "YOOJUNGIL99999999999999999999");
        map.put("mobileNo", "010254587855");
        map.put("addr", "SHIHEUNG");
        redirectAttributes.addFlashAttribute("map", map);
        return new RedirectView("/user/index11");
    }

    @GetMapping("/user/index11")
    public String userIndex11(Model model, @RequestParam Map<String, String> params, @RequestParam Map<String, Object> map, HttpServletRequest request) {
        Map<String, Object> flashMap = (Map<String, Object>) RequestContextUtils.getInputFlashMap(request);
        if(flashMap != null){
            params = (Map<String, String>) flashMap.get("map");
        }
        model.addAttribute("name", params.get("name"));
        return "index";
    }

    @GetMapping("/user/index2")
    public RedirectView userIndex2(@RequestParam String name) {
        return new RedirectView("/index?name=" + name);
    }

    @GetMapping("/user/index3")
    public RedirectView userIndex3(@RequestParam String name) {
        return new RedirectView("/index?name=" + name);
    }

}
