package com.ndh.demo4ssh.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ndh.demo4ssh.domain.User;
import com.ndh.demo4ssh.service.UserService;

@Controller
@RequestMapping("/webapi")
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
    private TokenStore tokenStore;

	@RequestMapping("")
	public String home() {
		return "index";
	}

	@RequestMapping("/json")
	@ResponseBody
	public List<User> json() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value = "/logout")
	@ResponseStatus(org.springframework.http.HttpStatus.OK)
    public void logout(HttpServletRequest request) {
        String access_token = request.getParameter("access_token");
        if (access_token != null) {
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(access_token);
            if (accessToken != null) {
            	tokenStore.removeAccessToken(accessToken);
            }
        }
    }
	
}
