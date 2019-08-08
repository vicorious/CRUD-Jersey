/**
 * 
 */
package com.com.joel.rest;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.com.joel.facade.UserFacade;

import co.com.joel.dto.CustomerDTO;


/**
 * @author Joel Santiago Vargas Lindarte
 * Encargada de encapsular el servicio web
 *
 */
@Path("/rest")
public class Rest 
{
	private UserFacade facade;
	public Rest()
	{
		this.facade = new UserFacade();
	}
	
	/**
	 * 
	 * @param _user
	 * @return
	 */
	@Path("/user/{_user}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers(@PathParam("_user") String _user)
	{
		CustomerDTO customer = this.facade.mappingGetUser(_user);
		return Response.ok(customer).build();
	}
	
	/**
	 * 
	 * @param _body
	 * @return
	 */
	@Path("/insertUser")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertUser(String _body)
	{
		CustomerDTO customer = this.facade.mappingInsertUser(_body);
		return Response.ok(customer).build();
	}
	
	/**
	 * 
	 * @param _body
	 * @return
	 */
	@Path("/updateUser")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(String _body)
	{
		CustomerDTO customer = this.facade.mappingUpdateUser(_body);
		return Response.ok(customer).build();
	}
			
}
