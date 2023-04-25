package hello.servlet.domain.member;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach    //각 실행 종료마다 실행되는 함수
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("choi", 20);

        //when
        Member saveMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("member1", 22);
        Member member2 = new Member("member2", 33);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when

        List<Member> allMembers = memberRepository.findAll();

        //then
        assertThat(allMembers.size()).isEqualTo(2);
        assertThat(allMembers).contains(member1, member2);
    }
}
