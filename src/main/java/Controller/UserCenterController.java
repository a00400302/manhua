package Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("center")
public class UserCenterController {



  @RequestMapping("/userCenter")
  public String userCenter(){
      return  "userCenter";
  }
}
