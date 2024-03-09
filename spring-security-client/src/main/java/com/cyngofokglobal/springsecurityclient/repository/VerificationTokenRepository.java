package com.cyngofokglobal.springsecurityclient.repository;

import com.cyngofokglobal.springsecurityclient.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long> {
    VerificationToken findByToken(String token);
}
