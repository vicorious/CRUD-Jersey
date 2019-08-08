/**
 * 
 */
package com.com.joel.facade;

import org.json.JSONObject;

import com.com.joel.entity.Customer;

import co.com.joel.dao.UserDao;

import co.com.joel.dto.CustomerDTO;

import co.com.joel.tools.ReflectionTools;

/**
 * @author alindartec
 *
 */
public class UserFacade 
{
	private UserDao dao;
	
	public UserFacade()
	{
		this.dao = new UserDao();
	}
	
	/**
	 * 
	 * @param _identification
	 * @return
	 */
	public CustomerDTO mappingGetUser(String _identification)
	{
		CustomerDTO result = new CustomerDTO();
		Customer customer = this.dao.getCustomer(_identification);	
		
		result = (CustomerDTO) ReflectionTools.mapping(customer, result);
		
		return result;		
	}
	
	/**
	 * 
	 * @param _body
	 * @return
	 */
	public CustomerDTO mappingInsertUser(String _body)
	{
		Customer persist = new Customer();
		CustomerDTO final_dto = new CustomerDTO();
		
		JSONObject body = new JSONObject(_body);				
		persist.setIdentification(body.getString("identification"));
		persist.setName(body.getString("name"));
		persist.setLast_name(body.getString("last_name"));
		
		Customer final_ = this.dao.insertCustomer(persist);
		final_dto = (CustomerDTO) ReflectionTools.mapping(final_, final_dto);
		
		return final_dto;
	}
	
	/**
	 * 
	 * @param _body
	 * @return
	 */
	public CustomerDTO mappingUpdateUser(String _body)
	{
		Customer update = new Customer();
		CustomerDTO final_dto = new CustomerDTO();
		
		JSONObject body = new JSONObject(_body);	
		update.setId(body.getBigDecimal("id"));
		if(update.getId() == null)
			throw new IllegalArgumentException("Error al actualizar el usuario. El ID es nulo");
		update.setIdentification(body.getString("identification"));
		update.setName(body.getString("name"));
		update.setLast_name(body.getString("last_name"));
		
		Customer final_ = this.dao.updateCustomer(update);
		final_dto = (CustomerDTO) ReflectionTools.mapping(final_, final_dto);
		
		return final_dto;		
	}

}
