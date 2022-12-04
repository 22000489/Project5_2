package com.example.board;

import com.example.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardDAO {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    private final String BOARD_INSERT = "insert into BOARD (firstName, lastName, birthday, gender, email, phone, information, userType, account, photo) values (?,?,?,?,?,?,?,?,?,?)";
    private final String BOARD_UPDATE = "update BOARD set firstName=?, lastName=?, birthday=?, gender=?, email=?, phone=?, information=?, userType=?, account=?, photo=? where id=?";
    private final String BOARD_SELECT = "select photo from BOARD where id=?";
    private final String BOARD_DELETE = "delete from BOARD  where id=?";
    private final String BOARD_GET = "select * from BOARD  where id=?";
    private final String BOARD_LIST = "select * from BOARD order by id desc";

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insertBoard(BoardVO vo) {
        System.out.println("===> JDBC로 insertBoard() 기능 처리");
//        String sql = "insert into BOARD (firstName, lastName, birthday, gender, email, phone, information, userType, account, photo) values("
//                + "'" + vo.getFirstName() + "',"
//                + "'" + vo.getLastName() + "',"
//                + "'" + vo.getBirthday() + "',"
//                + "'" + vo.getGender() + "',"
//                + "'" + vo.getEmail() + "',"
//                + "'" + vo.getPhone() + "',"
//                + "'" + vo.getInformation() + "',"
//                + "'" + vo.getUserType() + "',"
//                + "'" + vo.getAccount() + "',"
//                + "'" + vo.getPhoto() + "')";
//        return jdbcTemplate.update(sql);
        return jdbcTemplate.update(BOARD_INSERT, new
                Object[]{vo.getFirstName(), vo.getLastName(), vo.getBirthday(),
                vo.getGender(), vo.getEmail(), vo.getPhone(), vo.getInformation(),
                vo.getUserType(), vo.getAccount(), vo.getPhoto()});
    }

    public int deleteBoard(int id) {
//        String sql = "delete from BOARD where seq = " + seq;
//        return jdbcTemplate.update(sql);
        return jdbcTemplate.update(BOARD_DELETE,
                new Object[]{id});
    }

    public int updateBoard(BoardVO vo) {
//        String sql = "First name='" + vo.getFirstName() + "',"
//                + "Last name='" + vo.getLastName() + "',"
//                + "Birthday='" + vo.getBirthday() + "',"
//                + "Gender='" + vo.getGender() + "',"
//                + "Email='" + vo.getEmail() + "',"
//                + "Phone='" + vo.getPhone() + "',"
//                + "Information='" + vo.getPhone() + "',"
//                + "UserType='" + vo.getUserType() + "',"
//                + "Account='" + vo.getAccount() + "',"
//                + "Photo='" + vo.getPhoto() + "' where seq=" + vo.getId();
//        return jdbcTemplate.update(sql);
        return jdbcTemplate.update(BOARD_UPDATE,
                new Object[]{vo.getFirstName(), vo.getLastName(), vo.getBirthday(),
                        vo.getGender(), vo.getEmail(), vo.getPhone(),
                        vo.getInformation(), vo.getUserType(), vo.getAccount(),
                        vo.getPhoto(), vo.getId()});
    }

    //    class BoardRowMapper implements RowMapper<BoardVO>{
//        @Override
//        public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException{
//            BoardVO vo = new BoardVO();
//            vo.setId(rs.getInt("id"));
//            vo.setFirstName(rs.getString("firstName"));
//            vo.setLastName(rs.getString("lastName"));
//            vo.setBirthday(rs.getString("birthday"));
//            vo.setGender(rs.getString("gender"));
//            vo.setEmail(rs.getString("email"));
//            vo.setPhone(rs.getString("phone"));
//            vo.setInformation(rs.getString("information"));
//            vo.setUserType(rs.getString("userType"));
//            vo.setAccount(rs.getString("account"));
//            vo.setPhoto(rs.getString("photo"));
//            vo.setRegdate(rs.getDate("regdate"));
//            return vo;
//        }
//    }
    public BoardVO getBoard(int seq) {
//        String sql="select * from BOARD where seq=" + seq;
//        return jdbcTemplate.queryForObject(sql, new BoardRowMapper());
        return jdbcTemplate.queryForObject(BOARD_GET,
                new Object[]{seq},
                new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
    }

    public List<BoardVO> getBoardList() {
//        String sql="select * from BOARD order by regdate desc";
//        return jdbcTemplate.query(sql, new BoardRowMapper());
        return jdbcTemplate.query(BOARD_LIST, new RowMapper<BoardVO>() {

            @Override
            public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                BoardVO data = new BoardVO();
                data.setId(rs.getInt("id"));
                data.setFirstName(rs.getString("firstName"));
                data.setLastName(rs.getString("lastName"));
                data.setBirthday(rs.getString("birthday"));
                data.setGender(rs.getString("gender"));
                data.setEmail(rs.getString("email"));
                data.setPhone(rs.getString("phone"));
                data.setInformation(rs.getString("information"));
                data.setUserType(rs.getString("userType"));
                data.setAccount(rs.getString("account"));
                data.setPhoto(rs.getString("photo"));
                data.setRegdate(rs.getDate("regdate"));
                return data;
            }
        });
    }

    public void setTemplate(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }
}

