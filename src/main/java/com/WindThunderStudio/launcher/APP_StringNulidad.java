package com.WindThunderStudio.launcher;

import com.WindThunderStudio.StringUtilsHelper.StringHelper;

public class APP_StringNulidad {

	public static void main(String[] args) {
		String str1 = null;
		String str2;
		String str3;
		
		str2 = "1";
		str3 = "sss";
		System.out.println(StringHelper.existsNullOrEmpty(str1, str2, str3));
		

	}

}
