package com.salieri.community.controller;

import com.salieri.community.dto.AccessTokenDTO;
import com.salieri.community.dto.GithubUser;
import com.salieri.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8787/callback");
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id("6ae5d1dc4818592a298d");
        accessTokenDTO.setClient_secret("5498c97394240f288e17b089b1ee32ef6c65c1e1");
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        System.out.println("accessToken= " + accessToken);
        GithubUser user = githubProvider.getUser(accessToken/*"9880e0b5bb634dc57c19684aa4f4225ca9ba0042"*/);
        System.out.println("username: " + user.getName());
        return "index";
    }

}
