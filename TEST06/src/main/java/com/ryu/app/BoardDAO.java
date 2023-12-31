package com.ryu.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO implements InterfaceBoardDAO {

   @Autowired
   private JdbcTemplate jdbcTemplate;// 의존관계(멤버변수)

   // 응집도를 높여줌
   // final이 붙어 상수가 된 변수들은 대문자로 씀 (보통 sql문이나 변하지 않을 값)
   private final String SELECTALL="SELECT * FROM BOARD";
   private final String SELECTONE="SELECT * FROM BOARD WHERE BID = ?";
   private final String INSERT="INSERT INTO BOARD VALUES ((SELECT NVL(MAX(BID),0)+1 FROM BOARD),?,?)";
   private final String UPDATE="UPDATE BOARD SET CONTENT = ? WHERE BID=?";
   private final String DELETE="DELETE FROM BOARD WHERE BID = ?";

   public List<BoardDTO> selectAll(BoardDTO bDTO){
      // 반복적인 로직을 대신 수행하는 "템플릿 패턴"을 활용
      return jdbcTemplate.query(SELECTALL, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
   }
   public BoardDTO selectOne(BoardDTO bDTO){

      System.out.println("log" + bDTO);
      Object[] args = { bDTO.getBid()};

      return jdbcTemplate.queryForObject(SELECTONE, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class), args);
   }
   
   
   public boolean insert(BoardDTO bDTO) {

      int rs = jdbcTemplate.update(INSERT, bDTO.getMid(), bDTO.getContent());

      if (rs <= 0) {
         return false;
      }
      return true;
   }
   public boolean update(BoardDTO bDTO) {
      
      int rs = jdbcTemplate.update(UPDATE, bDTO.getContent(), bDTO.getBid());

      if (rs <= 0) {
         return false;
      }
      return true;
   }
   public boolean delete(BoardDTO bDTO) {
      
      int rs = jdbcTemplate.update(DELETE, bDTO.getBid());

      if (rs <= 0) {
         return false;
      }
      return true;
   }

}