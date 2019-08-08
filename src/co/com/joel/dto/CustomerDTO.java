/**
 * 
 */
package co.com.joel.dto;

import java.math.BigDecimal;

/**
 * @author alindartec
 *
 */
public class CustomerDTO 
{
	private BigDecimal id;
	
	private String identification;
	
	private String name;
	
	private String last_name;

	public CustomerDTO(BigDecimal id, String identification, String name, String last_name) {
		super();
		this.id = id;
		this.identification = identification;
		this.name = name;
		this.last_name = last_name;
	}

	public CustomerDTO() {
		super();
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((identification == null) ? 0 : identification.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (identification == null) {
			if (other.identification != null)
				return false;
		} else if (!identification.equals(other.identification))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", identification=" + identification + ", name=" + name + ", last_name="
				+ last_name + "]";
	}
	
	

}
