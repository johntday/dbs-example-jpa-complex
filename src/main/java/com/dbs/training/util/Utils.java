/**
 * 
 */
package com.dbs.training.util;

import java.util.Collection;
import com.dbs.training.model.Role;

/**
 * Utilities.
 * 
 * @author John T Day
 * 
 */
public class Utils {

	/**
	 * Unwind messages from Throwable.
	 * 
	 * @param t
	 * @return HTML message.
	 */
	public static String unwindExceptionStackMessages(Throwable t) {
		final String ITEM = "<li>%s</li>";
		String message = "<ol>";
		while (t != null) {
			message += String.format(ITEM, t.getMessage());

			t = t.getCause();
		}
		message += "</ol>";
		return message;
	}

	public static String[] getRoleNames(Collection<Role> roles) {
		if (roles == null)
			return new String[] {};
		int i = 0;
		String[] codes = new String[roles.size()];
		for (Role role : roles) {
			codes[i] = role.getName();
			i++;
		}
		return codes;
	}
}
