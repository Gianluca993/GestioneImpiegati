package com.gianluca.architecture.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.gianluca.bc.model.Impiegato;

//non è proprio un dao è più un bc che richiama il dao interno di Spring
public class ImpiegatoDAO implements DAOConstants {

	// deve chiamarsi così altrimenti non va la injection!!!
	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int create(Impiegato i) {
		SqlRowSet rs = jdbcTemplate.queryForRowSet(IMPSEQ_NEXTVAL);
		rs.next();
		long id = rs.getLong(1);
		i.setId(id);
		// esegue in automatico un preparedstatement inseguendo i parametri passati come
		// array di Object
		return jdbcTemplate.update(INSERT_IMPIEGATO,
				new Object[] { id, i.getNome(), i.getStipendio(), i.getReparto(), i.getImgUrl() });
	}

	public int update(Impiegato i) {
		// ritorna il numero di righe modificate (o inserite sopra)
		return jdbcTemplate.update(UPDATE_IMPIEGATO,
				new Object[] { i.getNome(), i.getStipendio(), i.getReparto(), i.getImgUrl(), i.getId() });
	}

	public int delete(long id) {
		return jdbcTemplate.update(DELETE_IMPIEGATO, new Object[] { id });
	}

	public Impiegato getById(long id) {
		// il BeanPropertyRowMapper mappa la riga ritornata dalla ricerca
		return jdbcTemplate.queryForObject(SELECT_IMPIEGATO_BYID, new Object[] { id },
				new BeanPropertyRowMapper<Impiegato>(Impiegato.class));
	}

	public List<Impiegato> getAll() {
		return jdbcTemplate.query(SELECT_IMPIEGATO, new RowMapper<Impiegato>() {
			@Override
			public Impiegato mapRow(ResultSet rs, int rigaCorrente) throws SQLException {
				Impiegato imp = new Impiegato();
				imp.setId(rs.getLong(1));
				imp.setNome(rs.getString(2));
				imp.setStipendio(rs.getDouble(3));
				imp.setReparto(rs.getString(4));
				imp.setImgUrl(rs.getString(5));
				return imp;
			}
		});
	}
	
	public List<Impiegato> getHighStip() {
		return jdbcTemplate.query(SELECT_HIGH_STIP, new RowMapper<Impiegato>() {
			@Override
			public Impiegato mapRow(ResultSet rs, int rigaCorrente) throws SQLException {
				Impiegato imp = new Impiegato();
				imp.setId(rs.getLong(1));
				imp.setNome(rs.getString(2));
				imp.setStipendio(rs.getDouble(3));
				imp.setReparto(rs.getString(4));
				imp.setImgUrl(rs.getString(5));
				return imp;
			}
		});
	}
	
	public List<Impiegato> getLowStip() {
		return jdbcTemplate.query(SELECT_LOW_STIP, new RowMapper<Impiegato>() {
			@Override
			public Impiegato mapRow(ResultSet rs, int rigaCorrente) throws SQLException {
				Impiegato imp = new Impiegato();
				imp.setId(rs.getLong(1));
				imp.setNome(rs.getString(2));
				imp.setStipendio(rs.getDouble(3));
				imp.setReparto(rs.getString(4));
				imp.setImgUrl(rs.getString(5));
				return imp;
			}
		});
	}
}
