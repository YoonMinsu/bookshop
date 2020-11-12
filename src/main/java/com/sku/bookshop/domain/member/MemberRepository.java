package com.sku.bookshop.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Transactional(readOnly = true)
    Member findByUserid(String userid);

    @Transactional(readOnly = true)
    Member findByEmail(String email);
}
