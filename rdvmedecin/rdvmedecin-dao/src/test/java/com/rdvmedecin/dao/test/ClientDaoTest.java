package com.rdvmedecin.dao.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rdvmedecin.config.DaoConfig;
import com.rdvmedecin.entity.Client;
import com.rdvmedecin.springdatajpa.SpringDataClientDao;

/**
 * 
 * @author Skan
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfig.class)
public class ClientDaoTest {

	private static Logger LOGGER = LoggerFactory.getLogger(ClientDaoTest.class);
	@Autowired
	SpringDataClientDao clientDao;

	@Test
	@Ignore
	public void getAllClient() {
		List<Client> clients = clientDao.findAll();
		System.err.println(" Client's list : " + clients.size());
	}

	@Test
	@Ignore
	public void addClient() {
		try {
			String dateNaissance = "22/12/2004";
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = formatter.parse(dateNaissance);
			Client client = new Client("title", "nom", "prenom", date);
			clientDao.save(client);
		} catch (ParseException e) {
			LOGGER.error("Parsing date error : " + e.getMessage());
		}
	}

}
