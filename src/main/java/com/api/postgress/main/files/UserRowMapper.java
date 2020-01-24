package com.api.postgress.main.files;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<UserLoginDO> {

	@Override
	public UserLoginDO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserLoginDO userDetailPo = new UserLoginDO();
		userDetailPo.setUserId(rs.getString("user_id"));
		userDetailPo.setUserName(rs.getString("user_name"));
//		userDetailPo.setModel(rs.getString("model"));
		return userDetailPo;
	}

}