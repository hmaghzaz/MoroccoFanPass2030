package com.morocco.fanPass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.morocco.fanPass.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {
}
