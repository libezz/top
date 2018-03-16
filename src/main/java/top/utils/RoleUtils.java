package top.utils;

import top.type.URIGroupType;

public class RoleUtils {

	public static boolean isRole(Long sumRole, URIGroupType group) {
		if(group.getNeedRole() == null || sumRole.equals(-1000L)) {
			return true;
		}
		Long temp = Long.divideUnsigned(sumRole, group.getNeedRole());
		Long result = Long.remainderUnsigned(temp, 2L);
		return result.equals(1L);
	}
}
