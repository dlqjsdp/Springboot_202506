package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("")
    public String index(Model model) {
        List<Member> memberList = (List<Member>)memberRepository.findAll();
        model.addAttribute("memberList", memberList);
        return "/members/index";
    }

    @GetMapping("/new")
    public String newMember(Model model) {
        return "/members/new";
    }

    @PostMapping("/create")
    public String createMember(MemberForm form) {

        log.info("Create member form: {}", form);

        // 1. MemberForm -> member entity 변환
        Member member = form.toEntity();

        // 2. DB 저장
        Member savedMember = memberRepository.save(member);

        return "redirect:/members";
    }

    @GetMapping("{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        log.info("Show member");

        // 1. {id}값을 DB에서 꺼내오기
        Member memberEntity = memberRepository.findById(id).orElse(null);

        log.info("memberEntity: {}", memberEntity);

        // 2. Entity -> DTO 변환
        // 책에서 생략함

        // 3. view 전달
        model.addAttribute("members", memberEntity);
        return "members/show";
    }

}