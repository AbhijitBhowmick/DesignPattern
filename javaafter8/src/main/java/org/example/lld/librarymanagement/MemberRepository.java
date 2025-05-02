package org.example.lld.librarymanagement;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    void addOrUpdateMember(Member member);
    Optional<Member> findById(String memberId);
    List<Member> findAll();
}
