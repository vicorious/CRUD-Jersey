/**
 * 
 */
package co.com.joel.tools;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author alindartec
 *
 */
public abstract class ReflectionTools 
{
	/**
	 * 
	 * @param object
	 * @param fieldName
	 * @param fieldValue
	 * @return
	 */
	public static boolean set(Object object, String fieldName, Object fieldValue) 
	{
	    Class<?> clazz = object.getClass();
	    while (clazz != null) 
	    {
	        try 
	        {
	            Field field = clazz.getDeclaredField(fieldName);
	            field.setAccessible(true);
	            field.set(object, fieldValue);
	            return true;
	        } catch (NoSuchFieldException e) 
	        {
	            clazz = clazz.getSuperclass();
	        } catch (Exception e) 
	        {
	            throw new IllegalStateException(e);
	        }
	    }
	    return false;
	}
	
	/**
	 * 
	 * @param _init
	 * @param _final
	 * @return
	 */
	public static Object mapping(Object _init, Object _final)
	{
		Arrays.asList(_init.getClass().getDeclaredFields()).stream().forEach(
		p -> 
		{
			p.setAccessible(true);
								
			try 
			{
				Object value = p.get(_init);
				set(_final, p.getName(), value);				
			} catch (IllegalArgumentException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});	
		
		return _final;
		
	}

}
