package com.example.firstproject.repository;

import com.example.firstproject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
