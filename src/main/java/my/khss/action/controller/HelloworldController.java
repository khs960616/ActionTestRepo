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
        // action 변경 및 포트 추가 후 재 테스트,
        // key값 환경변수 오타 수정 후 재 테스트
        // 스크립트 파일 수정 1
        return "test01";
    }
}
