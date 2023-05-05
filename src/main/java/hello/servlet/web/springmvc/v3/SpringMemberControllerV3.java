package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/new-form")
    public String newForm(){
        System.out.println("SpringMemberControllerV3.newForm");
        return "new-form";
    }

    @RequestMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);

        return "members";
    }

    @RequestMapping("/save")
    public String save(@RequestParam("username") String userName, @RequestParam("age") int age, Model model) {

        Member member = new Member(userName, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";

    }
}
