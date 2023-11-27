package kr.or.connect.reservation.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.domain.FileInfoDB;

@Repository
public class FileDao {
	private SimpleJdbcInsert insertActionFile;
	
	public FileDao(DataSource dataSource) {
		this.insertActionFile = new SimpleJdbcInsert(dataSource).withTableName("file_info").usingGeneratedKeyColumns("id");
	}
	
	public int insertFile(FileInfoDB fileInfoDB) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(fileInfoDB);
		return insertActionFile.executeAndReturnKey(params).intValue();
	}
}