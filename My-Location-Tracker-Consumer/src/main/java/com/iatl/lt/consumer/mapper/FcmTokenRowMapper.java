package com.iatl.lt.consumer.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.iatl.lt.consumer.model.FcmTokenData;

/**
 * @author Apu Das Gupta
 *
 */

public class FcmTokenRowMapper implements RowMapper<FcmTokenData> {
	@Override
	public FcmTokenData mapRow(ResultSet rs, int rowNum) throws SQLException, DataAccessException {
		FcmTokenData ob = new FcmTokenData();
		ob.setPropertyFromResultSet(rs);
		return ob;
	}
}


