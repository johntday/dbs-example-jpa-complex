/**
 * 
 */
package com.dbs.training.util;


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

}
