package com.bfs.authserver.controller;

import com.bfs.authserver.dbconfig.HibernateConfig;
import com.bfs.authserver.domain.User;
import com.bfs.authserver.security.CookieUtil;
import com.bfs.authserver.security.JwtUtil;
import com.bfs.authserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    private static final String jwtTokenCookieName = "JWT-TOKEN";
    private static final String signingKey = "signingKey";
    private static final Map<String, String> credentials = new HashMap<>();


    public LoginController() {
        //credentials.put("admin@admin.com", "admin");
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletResponse httpServletResponse, String username, String password, String redirect, Model model){
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        List<User> userList = userService.getAllUsers();
        for(User u : userList){
            credentials.put(u.getEmail(),u.getPassword());
        }
        if (username == null || !credentials.containsKey(username) || !credentials.get(username).equals(password)){
            model.addAttribute("error", "Invalid username or password!");
            return "login";
        }

        String token = JwtUtil.generateToken(signingKey, username);
        CookieUtil.create(httpServletResponse, jwtTokenCookieName, token, false, -1, "localhost");

        return "redirect:" + redirect;
    }
}
