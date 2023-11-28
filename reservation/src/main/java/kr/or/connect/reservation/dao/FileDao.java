package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.FileDaoSqls.*;

import java.util.Collections;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.domain.FileInfoDB;

@Repository
public class FileDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertActionFile;
	
	public FileDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertActionFile = new SimpleJdbcInsert(dataSource).withTableName("file_info").usingGeneratedKeyColumns("id");
	}
	
	public int insertFile(FileInfoDB fileInfoDB) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(fileInfoDB);
		return insertActionFile.executeAndReturnKey(params).intValue();
	}
	
	public String selectFileName(int fileId) {
		Map<String, Integer> params = Collections.singletonMap("id", fileId);
		return jdbc.queryForObject(SELECT_FILE_NAME, params, String.class);
	}
	
	public String selectSaveFileName(int fileId) {
		Map<String, Integer> params = Collections.singletonMap("id", fileId);
		return jdbc.queryForObject(SELECT_SAVE_FILE_NAME, params, String.class);
	}
	
	public String selectContentType(int fileId) {
		Map<String, Integer> params = Collections.singletonMap("id", fileId);
		return jdbc.queryForObject(SELECT_CONTENT_TYPE, params, String.class);
	}
}