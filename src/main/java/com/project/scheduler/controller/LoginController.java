package com.project.scheduler.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.scheduler.controller.request.LoginRequest;
import com.project.scheduler.dto.UserDto;
import com.project.scheduler.service.CommonService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    private CommonService commonService;
    
    // @PostMapping("/join")
    // public Response<UserJoinResponse> join(@RequestBody UserJoinRequest request) {
    //     User user = userService.join(request.getName(), request.getPassword());
    //     return Response.success(UserJoinResponse.fromUser(user));
    // }

    @GetMapping("/login")
    public String login(){
        System.out.println("login Page를 통과합니다.");
        return "main/loginForm.html";
    }
    
    @PostMapping("/member/loginGo")
    @ResponseBody
    public Map<String, Object> login(@RequestBody LoginRequest request
    // , @RequestParam(value = "userId") String userId, 
    //                                 @RequestParam(value = "userPw") String userPw
                                    ) 
    {
        System.out.println("request : "+request);
        Map<String, Object> loginResult = new HashMap<String, Object>();
        try {
            System.out.println("login 중 입니다.");
            if (!request.getId().isEmpty() && !request.getPassword().isEmpty()) {
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

                UserDto userInfo = new UserDto();
                userInfo.setId(request.getId());
                userInfo.setPassword(request.getPassword());

                String savedPwd = commonService.getPassword(userInfo);
                if (passwordEncoder.matches(request.getPassword(), savedPwd)) {
                    loginResult.put("created", "true");
                }  else if (!passwordEncoder.matches(request.getPassword(), savedPwd)) {// password 입력 오류
                    loginResult.put("userPassword", "false");
                } else if (savedPwd.isEmpty()) {// 사용자 없음
                    loginResult.put("userId", "false");
                }
            }
            loginResult.put("result", "Success");
        } catch (Exception e) {
            loginResult.put("result", "Error");
            loginResult.put("message", e.getMessage());
            log.error("ErrorMessage : "+ e.getMessage());
        }
        return loginResult;
    }

}
