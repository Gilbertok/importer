package com.funsoft.importer.utils;

public class CommonUtils {
	
	public static boolean isNotNull(final Object value) {
        return value != null;
    }
	
	public static boolean isNotEmpty(final Object[] value) {
        return !isEmpty(value);
    }
	
	public static boolean isEmpty(final Object[] value) {
        return value == null || value.length == 0 || (value.length == 1 && value[0] == null);
    }
	
	public static boolean isNull(final Object value) {
        return value == null;
    }
	

}
