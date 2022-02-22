package study.studyspring.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import study.studyspring.domain.Member;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //어떤 메서드 동작이 끝나면 실행되는 콜백 메서드 여기서는 테스트 데이터 를 클리어 해주기위해 사용하고있음.
    //새로 알게된 사실이다. 클래스 단위로 테스트시 순서와 상관없이 테스트 메서드가 실행이 되는데 그중 데이터 겹침으로 인해
    //필요 없는 오류가 생길 수 있다 이를 방지하기 위해 클린 콜백메서드를 생성하여 테스트가 종료되면 데이터 클리어를 진행한다.
    //즉 테스트는 서로 순서와 관계 없이 서로 의존관계가 없이 설계가 되어야 한다.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
