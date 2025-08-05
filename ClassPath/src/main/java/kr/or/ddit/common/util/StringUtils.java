package kr.or.ddit.common.util;

public class StringUtils {
	public static boolean startsWithOr(String target, String ... compare) {
		if(compare==null) { 
			return false; 
		}
		
		for (String s : compare) {
			if(target.startsWith(s)) {
				
				return true; 
			}
		}
				
		return false;
	}
	
	public static boolean equalsWithOr(String target, String ... compare) {
		if(compare==null) { 
			return false; 
		}
		
		for (String s : compare) {
			
			if(target.equals(s)) {
				
				return true; 
			}
		}
		
		return false;
	}
}
