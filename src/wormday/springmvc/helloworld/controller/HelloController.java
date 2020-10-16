package wormday.springmvc.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import wormday.springmvc.helloworld.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.springframework.web.servlet.mvc.Controller;
//使用 Servlet 原生 API 来实现接收数据
/*通过注解简化dispatcher-servlet中配置，只需扫描*/
@Controller
public class HelloController {
    //public class HelloController implements Controller{
//    @Override
    @RequestMapping("/hello")
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "Hello Spring MVC");
        return mav;
    }

    //    @RequestMapping("/param")
//    public ModelAndView getParam(HttpServletRequest request,
//                                 HttpServletResponse response) {
//        String userName = request.getParameter("userName");
//        String password = request.getParameter("password");
//
//        System.out.println(userName);
//        System.out.println(password);
//        return null;
//    }

    @RequestMapping("/test")
    public ModelAndView handleRequest1(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("test");
        return mav;
    }

    /**
     *会跟前台产生耦合，用@RequestParam解决
     */
    @RequestMapping("/param")
    public ModelAndView getParam(String userName,
                                 String password) {
        System.out.println(userName);
        System.out.println(password);
        return null;
    }

    @RequestMapping("/param1")
    public ModelAndView getParam1(@RequestParam("userName") String userName, String password) {
        System.out.println(userName);
        System.out.println(password);
        return null;
    }

    /**
     * 使用模型传参
     */
    @RequestMapping("/param2")
    public ModelAndView getParam2(User user) {
        System.out.println(user.getPassword());
        System.out.println(user.getUserName());
        return null;
    }
    /**
     * 使用 Servlet 原生 API 来实现回显数据
     */
    @RequestMapping("/value")
    public ModelAndView handleRequest2(HttpServletRequest request,
                                      HttpServletResponse response) {
        request.setAttribute("message","成功！");
        return new ModelAndView("test1");
    }

    /**
     * 使用 Spring MVC 所提供的 ModelAndView 对象
     */
    @RequestMapping("/value1")
    public  ModelAndView handleRequest3(HttpServletRequest request,HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("test1");
        mav.addObject("message", "ModelAndView成功！");
                return mav;
    }

    /**
     * 使用 Spring MVC 所提供的 Model对象
     */
    @RequestMapping("value2")
    public String handleRequest(Model model) {
        model.addAttribute("message", "Model回显成功！");
        return "test1";
    }

    /**
     * 这样写就会在访问控制器方法 handleRequest() 时，会首先调用 model() 方法将 message 添加进页面参数中去，在视图中可以直接调用，
     * 但是这样写会导致该控制器所有的方法都会首先调用 model() 方法，但同样的也很方便，因为可以加入各种各样的数据。
     */
    @ModelAttribute
    public void model(Model model) {
        model.addAttribute("message", "注解成功");
        System.out.println("调用了我");
    }

    @RequestMapping("/value3")
    public String handleRequest() {
        return "test1";
    }

    /**
     * 前面不管是地址 /hello 跳转到 index.jsp 还是 /test 跳转到 test.jsp，这些都是服务端的跳转，
     * 也就是 request.getRequestDispatcher("地址").forward(request, response);
     * 那我们如何进行客户端跳转呢？
     */
    @RequestMapping("/jump")
    public ModelAndView jump() {
        ModelAndView mav = new ModelAndView("redirect:/hello");
        return mav;
    }
    @RequestMapping("/jump1")
    public String jump1() {
        return "redirect: ./hello";
    }
}