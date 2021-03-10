package pers.cocoadel.user.platform.controller;

import pres.cocoadel.web.mvc.controller.PageController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/hello")
public class HelloController implements PageController {

    @GET
    @Path("/world")
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        return "hello-world.jsp";
    }
}
