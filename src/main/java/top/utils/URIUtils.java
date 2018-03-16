package top.utils;

import top.type.URIGroupType;

public class URIUtils {

	public static URIGroupType groupURI(String uri) {
		String[] uriPieces = uri.split("/");
		if(uriPieces.length < 2) {
			return null;
		}
		URIGroupType group = URIGroupType.getTypeByName(uriPieces[1]);
		if(URIGroupType.MAIN.equals(group) && uriPieces.length != 2) {
			return null;
		}
		return group;
	}
}
