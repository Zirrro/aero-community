package com.salieri.community.controller;

import com.salieri.community.dto.AccessTokenDTO;
import com.salieri.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;


    @GetMapping("callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("6ae5d1dc4818592a298d");
        accessTokenDTO.setClient_secret("5498c97394240f288e17b089b1ee32ef6c65c1e1");
        accessTokenDTO.setRedirect_uri("http://localhost:8787/callback");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        githubProvider.getAccessToken(accessTokenDTO);
        return "index";
    }

}
