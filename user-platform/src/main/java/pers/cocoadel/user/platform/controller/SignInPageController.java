package pers.cocoadel.user.platform.controller;


import pres.cocoadel.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * 登录页面
 * 登录逻辑的处理在 {@link LoginController}
 */
@Path("/user")
public class SignInPageController implements PageController {

    @GET
    @Path("/signIn")
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return "login-form.jsp";
    }
}
