package com.ryu.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberService implements InterfaceMemberService {

	@Autowired
	private InterfaceMemberDAO mDAO;
	
	@Override
	public List<MemberDTO> selectAll(MemberDTO mDTO) {
		return mDAO.selectAll(mDTO);
	}

	@Override
	public MemberDTO selectOne(MemberDTO mDTO) {
		return mDAO.selectOne(mDTO);
	}

	@Override
	public boolean insert(MemberDTO mDTO) {
		return false;
	}

	@Override
	public boolean update(MemberDTO mDTO) {
		return false;
	}

	@Override
	public boolean delete(MemberDTO mDTO) {
		return false;
	}

}
