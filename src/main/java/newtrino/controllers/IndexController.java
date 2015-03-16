package newtrino.controllers;

import newtrino.dtos.UserDto;
import newtrino.services.UserService;
import newtrino.utils.Messages;
import newtrino.utils.Models;
import newtrino.utils.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public String renderIndexPage(){
        return ViewNames.INDEX;
    }

    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String renderHomePage(){
        return ViewNames.HOME;
    }

    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String renderRegistrationPage(){
        return ViewNames.REGISTRATION;
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public void registerUser(UserDto userDto,Model model,HttpServletResponse response){
        try {
            userService.create(userDto);
            model.addAttribute(Models.MESSAGE, Messages.REGISTRATION_SUCCESSFUL);
            response.sendRedirect("register");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String renderLoginPage(){
        return ViewNames.LOGIN;
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public void loginUser(@RequestParam("u")String username,@RequestParam("p")String password,HttpServletResponse response){
        try {
            UserDto userDto = userService.find(username, password);
            if (null == userDto) {
                response.sendRedirect("login");
            } else {
                response.sendRedirect("home");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public void logout(HttpServletResponse response,HttpServletRequest request){
        try {
            request.getSession().invalidate();
            response.sendRedirect("login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
