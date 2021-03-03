package pers.cocoadel.user.platform.controller;

import pers.cocoadel.user.platform.bean.SingletonBeanContainer;
import pers.cocoadel.user.platform.domain.User;
import pers.cocoadel.user.platform.exception.BusinessException;
import pers.cocoadel.user.platform.service.UserService;
import pres.cocoadel.web.mvc.controller.PageController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/user")
public class SignUpPageController implements PageController {


    @Path("/signUp")
    @GET
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return "sign-up.jsp";
    }
}
