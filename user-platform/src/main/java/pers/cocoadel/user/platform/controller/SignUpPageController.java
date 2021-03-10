package pers.cocoadel.user.platform.controller;

import pres.cocoadel.web.mvc.controller.PageController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * 注册页面
 * 注册逻辑的处理在 {@link RegisterController}
 */
@Path("")
public class SignUpPageController implements PageController {


    @Path("/")
    @GET
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return "index.jsp";
    }
}
