package com.Finzly.ForenExchange.Dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.Finzly.ForenExchange.Model.Currency;


public class CurrencyDao {

	@Autowired
	SessionFactory sessionFactory;
	
	/*
     * This method checks if a given currency pair exists in the database.
     * It returns a List of CurrencyInfo objects if found, or null if not found.
     *
     * @param currencyPair The currency pair to check for existence.
     * @return A List of CurrencyInfo objects representing the currency pair if found, or null if not found.
     */
	
	Logger logger = LoggerFactory.getLogger(CurrencyDao.class);
	public Object checkcurrencyPair(String currencyPair) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Currency.class);
		criteria.add(Restrictions.eq("currencyPair", currencyPair));
		if (criteria.list().size() != 0) {
			logger.info("currency-pair  list is" + criteria.list());
			return criteria.list();    // Return a list of matching CurrencyInfo objects.

		} 
		else {
			logger.info("currency-pair  list is empty");
			return null;    // Return null if the currency pair is not found.
		}
	}


	/*
     * This method retrieves a list of all currency pairs from the database.
     *
     * @return A List of Currency objects representing all currency pairs.
     */
	public List<com.Finzly.ForenExchange.Model.Currency> getAllCurrencyPair() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Currency.class);
		logger.info("currency-pair  list is" + criteria.list());
		return criteria.list();
	}
	
	
	/*
     * This method retrieves a list of currency exchange rates for a specific currency pair from the database.
     *
     * @param currencyPair The currency pair for which to retrieve exchange rates.
     * @return A List of Currency objects representing exchange rates for the specified currency pair.
     */
	public List<Currency> getCurrencyPairRate(String currencyPair) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Currency.class);
		criteria.add(Restrictions.eq("currencyPair", currencyPair));
		return criteria.list();

	}

	/*
     * This method updates a currency pair's exchange rate in the database.
     *
     * @param currencyExchangerObj The Currency object containing the updated exchange rate information.
     * @return A string indicating that the currency pair has been updated.
     */
	public String updateCurrencyPair(com.Finzly.ForenExchange.Model.Currency currencyExchangerObj) {
		Session session = sessionFactory.openSession();
		session.update(currencyExchangerObj);
		Criteria criteria = session.createCriteria(Currency.class);
		logger.info("currency-pair  is updated " + criteria.list());
		return "currency pair updated";
		
	}

	 /*
     * This method adds a new currency pair and its exchange rate to the database.
     *
     * @param currencyExchangerObj The Currency object containing the new currency pair and exchange rate.
     * @return A string indicating that the currency pair has been added.
     */
	public String addCurrencyExchange(Currency currency) {
		Session session = sessionFactory.openSession();
		session.save(currency);
		session.beginTransaction().commit();
		logger.info("currency pair is added" + currency);
		return "Currency Pair added";
	}

}
