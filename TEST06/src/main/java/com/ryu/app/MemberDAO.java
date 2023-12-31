package com.ryu.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO implements InterfaceMemberDAO{

   @Autowired
   private JdbcTemplate jdbcTemplate;// 의존관계(멤버변수)

   // 응집도를 높여줌
   // final이 붙어 상수가 된 변수들은 대문자로 씀 (보통 sql문이나 변하지 않을 값)
   private final String SELECTALL="SELECT MID,MPW FROM MEMBER";
   private final String SELECTONE="SELECT MID,MPW FROM MEMBER WHERE MID = ? AND MPW = ?";
   private final String SELECTONE_DUPLICATE="SELECT MID,MPW FROM MEMBER WHERE MID = ?";
   private final String INSERT="INSERT INTO MEMBER VALUES (?,?)";
   private final String UPDATE="UPDATE MEMBER SET MPW = ? WHERE MID = ?";
   private final String DELETE="DELETE FROM MEMBER WHERE MID =?";

   public List<MemberDTO> selectAll(MemberDTO mDTO){
      // 반복적인 로직을 대신 수행하는 "템플릿 패턴"을 활용
      return jdbcTemplate.query(SELECTALL, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
   }
   public MemberDTO selectOne(MemberDTO mDTO){

      System.out.println("log" + mDTO);
      try {
    	  if(mDTO.getSearchCondition()==null) {
    		  Object[] args = { mDTO.getMid(), mDTO.getMpw() };
    		  return jdbcTemplate.queryForObject(SELECTONE, args, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
    	  }
    	  else if(mDTO.getSearchCondition().equals("duplicate")) {
    		  Object[] args = { mDTO.getMid()};
    		  return jdbcTemplate.queryForObject(SELECTONE_DUPLICATE, args, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
    	  }
    	  else {
    		  return null;
    	  }
      }
      catch(EmptyResultDataAccessException e) {
    	  System.out.println("데이터가 없음");
    	  return null;
      }
   }
   public boolean insert(MemberDTO mDTO) {

      int rs = jdbcTemplate.update(INSERT, mDTO.getMid(), mDTO.getMpw());

      if (rs <= 0) {
         return false;
      }
      return true;
   }
   public boolean update(MemberDTO mDTO) {
      
      int rs = jdbcTemplate.update(UPDATE, mDTO.getMpw(),  mDTO.getMid());

      if (rs <= 0) {
         return false;
      }
      return true;
   }
   public boolean delete(MemberDTO mDTO) {
      int rs = jdbcTemplate.update(DELETE, mDTO.getMid());

      if (rs <= 0) {
         return false;
      }
      return true;
   }
}