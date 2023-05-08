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
        // 키 값 변경 후 재 테스트
        return "test01";
    }
}
