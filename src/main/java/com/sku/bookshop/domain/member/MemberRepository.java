package com.sku.bookshop.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByUserid(String userid);

    Member findByEmail(String email);
}
