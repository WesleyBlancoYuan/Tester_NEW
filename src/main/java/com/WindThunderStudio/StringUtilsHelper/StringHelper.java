package com.WindThunderStudio.StringUtilsHelper;

import org.apache.commons.lang.StringUtils;

public class StringHelper {
	
	public static boolean existsNullOrEmpty(String str1, String str2, String str3){
		return StringUtils.isBlank(str1) || StringUtils.isBlank(str2) || StringUtils.isBlank(str3);
	}
}
