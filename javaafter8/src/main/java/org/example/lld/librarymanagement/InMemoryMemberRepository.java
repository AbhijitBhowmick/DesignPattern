package org.example.lld.librarymanagement;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class InMemoryMemberRepository implements MemberRepository {
    private final ConcurrentMap<String, Member> members = new ConcurrentHashMap<>();
    private static final InMemoryMemberRepository INSTANCE = new InMemoryMemberRepository();
    private InMemoryMemberRepository() {}
    public static InMemoryMemberRepository getInstance() { return INSTANCE; }

    @Override
    public void addOrUpdateMember(Member member) { members.put(member.memberId(), member); }

    @Override
    public Optional<Member> findById(String memberId) { return Optional.ofNullable(members.get(memberId)); }

    @Override
    public List<Member> findAll() { return List.copyOf(members.values()); }
}
