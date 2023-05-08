package my.khss.action.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {

    @GetMapping("/hello")
    public String helloGitAction() {
        return "Hello";
    }

    @GetMapping("/test01")
    public String test01() {
        return "test01";
    }
}
