package com.ryu.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import jakarta.servlet.http.HttpSession;

@Controller
public class CTRL {

	@Autowired
	MemberDAO mDAO;
	@Autowired
	BoardDAO bDAO;

	@RequestMapping("/")
	public String root() {
		return "redirect:main";
	}

	@RequestMapping("/login")
	public String login(MemberDTO mDTO, HttpSession session) {
		mDTO = mDAO.selectOne(mDTO);
		if (mDTO != null) {
			session.setAttribute("mid", mDTO.getMid());
		}
		return "redirect:main";
	}

	@RequestMapping("/signup")
	public String signup(MemberDTO mDTO) {
		mDTO.setSearchCondition("duplicate");
		MemberDTO mdata=mDAO.selectOne(mDTO);

		if(mdata==null) {

			boolean flag = mDAO.insert(mDTO);
			if (flag) {
				System.out.println("회원가입 성공");
			} else {
				System.out.println("실패");
			}
		}
		else {
			System.out.println("중복된 아이디입니다.");
		}
		return "redirect:main";
	}

	@RequestMapping("/mypage")
	public String join(MemberDTO mDTO, HttpSession session, Model model) {
		mDTO.setMid((String)session.getAttribute("mid"));
		mDTO.setSearchCondition("duplicate");
		mDTO=mDAO.selectOne(mDTO);

		model.addAttribute("mdata", mDTO);

		return "mypage";
	}

	@RequestMapping("/updateMpw")
	public String updateMpw(MemberDTO mDTO, Model model) {
		mDAO.update(mDTO);
		mDTO.setSearchCondition("duplicate");
		MemberDTO mdata=mDAO.selectOne(mDTO);
		
		model.addAttribute("mdata", mdata);
		
		return "mypage";
	}

	@RequestMapping("/deleteMember")
	public String deleteMember(MemberDTO mDTO, HttpSession session) {

		mDAO.delete(mDTO);
		session.removeAttribute("mid");

		return "redirect:main";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("mid");
		return "redirect:main";
	}

	@RequestMapping("/main")
	public String main(MemberDTO mDTO, HttpSession session, Model model) {
		List<BoardDTO> bdatas=bDAO.selectAll(null);
		model.addAttribute("bdatas", bdatas);

		return "main";
	}

	@RequestMapping("/insertBoard")
	public String insertBoard(BoardDTO bDTO) {
		boolean flag=bDAO.insert(bDTO);
		if(!flag) {
			System.out.println("로그: insertBoard 실패");
			return "redirect:main";
		}

		return "redirect:main";
	}

	@RequestMapping("/board")
	public String board(BoardDTO bDTO, Model model) {
		bDTO=bDAO.selectOne(bDTO);

		model.addAttribute("bdata", bDTO);

		return "board";
	}

	@RequestMapping("/updateBoard")
	public String updateBoard(BoardDTO bDTO) {
		bDAO.update(bDTO);
		
		return "redirect:main";
	}

	@RequestMapping("/deleteBoard")
	public String deleteBoard(BoardDTO bDTO) {
		bDAO.delete(bDTO);
		
		return "redirect:main";
	}






}