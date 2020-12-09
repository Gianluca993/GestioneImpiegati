package com.gianluca.architecture.dao;

public interface DAOConstants {
	
	String IMPSEQ_NEXTVAL = "select imp_seq.nextval from dual";

	String SELECT_IMPIEGATO = "select * from impiegato order by id";
	String SELECT_UTENTE = "select * from utente";
	
	String SELECT_IMPIEGATO_BYID = "select * from impiegato where id = ?";
	String SELECT_UTENTE_BYUSER = "select * from utente where username = ?";
	
	String INSERT_IMPIEGATO = "insert into impiegato values(?,?,?,?,?)";
	String INSERT_UTENTE = "insert into utente values(?,?,?,?,?)";
	
	String UPDATE_IMPIEGATO = "update impiegato set nome = ?, stipendio = ?, reparto = ?, img_url = ? where id = ?";
	String UPDATE_UTENTE = "update utente set nome = ?, cognome = ?, email = ?, password = ?, where username = ?";

	String DELETE_IMPIEGATO = "delete from impiegato where id = ?";
	String DELETE_UTENTE = "delete from utente where username = ?";
	
	String SELECT_USER_PASS = "select password from utente where username = ?";
	
	//purtroppo funziona solo fino a quando gli stipendi sono tutti diversi
	// se due stipendi sono uguali anche in reparti diversi la query restituisce risultati sbagliati
	String SELECT_HIGH_STIP = "select * from impiegato where (reparto, stipendio) in (select reparto, max(stipendio) from impiegato group by reparto) order by stipendio desc";
	String SELECT_LOW_STIP = "select * from impiegato where (reparto, stipendio) in (select reparto, min(stipendio) from impiegato group by reparto) order by stipendio";
}
