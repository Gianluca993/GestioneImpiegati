package com.gianluca.architecture.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.gianluca.bc.model.Utente;

public class UtenteDAO implements DAOConstants{
	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int create(Utente u) {
		return jdbcTemplate.update(INSERT_UTENTE, new Object[] {u.getNome(), u.getCognome(), u.getEmail(), u.getPassword(), u.getUsername()});
	}
	public int update(Utente u) {
		return jdbcTemplate.update(INSERT_UTENTE, new Object[] {u.getNome(), u.getCognome(), u.getEmail(), u.getPassword(), u.getUsername()});
	}
	
	public int delete(String username) {
		return jdbcTemplate.update(DELETE_UTENTE, new Object[] { username });
	}
	
	public String getUserPassword(String username) {
		Utente u = getByUsername(username);
		if(u == null)
			return null;
		return u.getPassword();
	}

	public Utente getByUsername(String username) {
//		return jdbcTemplate.queryForObject(SELECT_UTENTE_BYUSER, new Object[] { username },
//				new BeanPropertyRowMapper<Utente>(Utente.class));
		SqlRowSet rs = jdbcTemplate.queryForRowSet(SELECT_UTENTE_BYUSER, username);
		Utente utente = new Utente();
		if(rs.next()) {
			utente.setNome(rs.getString(1));
			utente.setCognome(rs.getString(2));
			utente.setEmail(rs.getString(3));
			utente.setPassword(rs.getString(4));
			utente.setUsername(rs.getString(5));
			return utente;
		}
		return null;
	}
	
	public List<Utente> getAll() {
		return jdbcTemplate.query(SELECT_UTENTE, new RowMapper<Utente>(){
			@Override
			public Utente mapRow(ResultSet rs, int rowNum) throws SQLException {
				Utente u = new Utente();
				u.setNome(rs.getString(1));
				u.setCognome(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setUsername(rs.getString(5));
				return u;
			}
		});
	}
}
