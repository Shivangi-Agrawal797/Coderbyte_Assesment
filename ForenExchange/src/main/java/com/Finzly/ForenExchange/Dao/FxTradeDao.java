package com.Finzly.ForenExchange.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Finzly.ForenExchange.Model.Currency;
import com.Finzly.ForenExchange.Model.FxTrade;

@Repository
public class FxTradeDao {
    @Autowired
	SessionFactory sessionFactory;
    
    /*   
     * @Author Shivangi Agrawal
     *   This method checks if a given currency pair exists in the database.
     *  It returns a List of CurrencyInfo objects if found, or null if not found.
     * 
     */
    public Object checkCurrencyPair(String currencypair)
    {
    		Session session=sessionFactory.openSession();
    		Criteria criteria=session.createCriteria(Currency.class);
    		criteria.add(Restrictions.eq("currencyPair",currencypair ));
    		if(criteria.list().size()!=0)
    		{
    			return criteria.list();
    		}
    		else {
    			return null;
    		}
    	
    }
    
    // This method performs a trade operation by saving the provided FxExchangeInfo object in the database.
	public void addTrade(FxTrade fxTrade) {
		Session session=sessionFactory.openSession();
		session.save(fxTrade);
		session.beginTransaction().commit();
	}

	// This method retrieves a list of booked trades from the database.
	public List<FxTrade> getBookedTradeList() {
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(FxTrade.class);
		return criteria.list();
	}
}
