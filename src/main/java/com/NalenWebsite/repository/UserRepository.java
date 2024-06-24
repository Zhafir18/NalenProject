package com.NalenWebsite.repository;

import com.NalenWebsite.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
}
