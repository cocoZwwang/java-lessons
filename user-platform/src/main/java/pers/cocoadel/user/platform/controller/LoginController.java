package pers.cocoadel.user.platform.controller;

import pers.cocoadel.user.platform.bean.SingletonBeanContainer;
import pers.cocoadel.user.platform.service.UserService;
import pres.cocoadel.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/user")
public class LoginController implements PageController {

    private final UserService userService;

    public LoginController() {
        this.userService = SingletonBeanContainer.getInstance().get(UserService.class);
    }

    @Path("/login")
    @POST
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String message = "";
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            if(userService.signIn(email, password)){
                message = "登录成功！ 欢迎 " + email;
            }
        } catch (Exception e) {
            message = "登录失败：" + e.getMessage();
        }
        request.setAttribute("message",message);
        return "login-success.jsp";
    }
}
