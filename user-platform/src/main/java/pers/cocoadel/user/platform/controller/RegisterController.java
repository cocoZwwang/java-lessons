package pers.cocoadel.user.platform.controller;

import pers.cocoadel.user.platform.bean.SingletonBeanContainer;
import pers.cocoadel.user.platform.domain.User;
import pers.cocoadel.user.platform.exception.BusinessException;
import pers.cocoadel.user.platform.service.UserService;
import pres.cocoadel.web.mvc.controller.PageController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/user")
public class RegisterController implements PageController {

    private final UserService userService;

    public RegisterController() {
        userService = SingletonBeanContainer.getInstance().get(UserService.class);
    }

    @Path("/register")
    @POST
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            User user = new User();
            user.setName(email);
            user.setEmail(email);
            user.setPassword(password);
            user.setPhoneNumber("125635489654");
            System.out.println(user.toString());
            userService.signUp(user);
            System.out.println("注册成功！");
            return "register-success.jsp";
        } catch (Throwable e) {
            if (e instanceof BusinessException) {
                request.setAttribute("error",e.getMessage());
            }
            e.printStackTrace();
            return "sign-up.jsp";
        }
    }
}
