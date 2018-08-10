package com.krixon.paneladminui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class PanelController
{
    @Autowired
    private OAuth2RestTemplate oauth2RestTemplate;

    @RequestMapping("/panels")
    public String getList(Model model)
    {
        ResponseEntity<ArrayList<Panel>> panels = oauth2RestTemplate.exchange(
            "http://localhost:9001/services/panels", HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<Panel>>(){});

        model.addAttribute("panels", panels.getBody());

        return "panel/list";
    }

    public static class Panel
    {
        public String id;
        public String name;

        public Panel() {}

        public Panel(String id, String name){
            this.id = id;
            this.name = name;
        }
    }
}
