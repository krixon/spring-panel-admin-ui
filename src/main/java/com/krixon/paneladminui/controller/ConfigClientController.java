package com.krixon.paneladminui.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RefreshScope
public class ConfigClientController
{
    @Value("${bgcolor}")
    String backgroundColor = "white";

    @RequestMapping("/config-client/demo")
    public String demo(Model model)
    {
        model.addAttribute("backgroundColor", backgroundColor);

        return "config-client/demo";
    }
}
