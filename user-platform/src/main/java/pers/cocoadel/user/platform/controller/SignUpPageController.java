package pers.cocoadel.user.platform.controller;

import pres.cocoadel.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/user")
public class SignUpPageController implements PageController {


    @Path("/signUp")
    @POST
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return "sign-up.jsp";
    }
}
