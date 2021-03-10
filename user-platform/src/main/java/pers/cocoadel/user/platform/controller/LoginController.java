package pers.cocoadel.user.platform.controller;

import pers.cocoadel.user.platform.service.UserService;
import pres.cocoadel.web.mvc.controller.PageController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * 由{@link SignInPageController} forward 过来
 * 登录逻辑的处理
 */
@Path("")
public class LoginController implements PageController {

    @Resource(name = "bean/UserService")
    private UserService userService;

    @Path("/login")
    @POST
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String message = "";
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            if (userService.signIn(email, password)) {
                message = "登录成功！ 欢迎 " + email;
                request.setAttribute("message", message);
                return "login-success.jsp";
            }
        } catch (Throwable e) {
            message = "登录失败：" + e.getMessage();
        }
//        return "login-success.jsp";
        request.setAttribute("message", message);
        return "login-form.jsp";
    }
}
