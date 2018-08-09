package com.krixon.paneladminui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PanelController
{
    @RequestMapping("/panels")
    public String getList()
    {
        return "panel/list";
    }
}
