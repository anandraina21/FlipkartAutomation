package anandraina.FlipkartAutomation.constants;

public class Constants {

	private Constants() {
	}

	public static final class ElementFactory {
		public static final String EMAIL_TEXTFIELD = "._2zrpKA._1dBPDZ";
		public static final String PASSWORD_PASSWORDFIELD = "//input[@type=\"password\"]";
		public static final String LOGIN_BUTTON = "._2AkmmA._1LctnI._7UHT_c";
		public static final String SEARCHBOX_TEXTFIELD = "//input[@name=\"q\"]";
		public static final String PRODUCT_LISTITEM = "//li[@class=\"_1va75j\"]";
		public static final String PRODUCTNAME_LINKTEXT = "._3wU53n";
		public static final String ADDTOCART_BUTTON = "._2AkmmA._2Npkh4._2MWPVK";
		public static final String REMOVE_LINKTEXT = "//div[.='Remove']";
		public static final String REMOVE_BUTTON = ".gdUKd9._3Z4XMp._2nQDKB";
		public static final String PROFILESECTION_DROPDOWN = ".dHGf8H";
		public static final String LOGOUT_LISTITEM = "//div[.='Logout']";
		public static final String MYCART_ID = "._1lBhq8";
	}

	public static final class Resources {
		// *****Change email and password before commit*****
		public static final String EMAIL = "sample";
		public static final String PASSWORD = "sample";
		
		public static final String URL = "https://www.flipkart.com/";
		public static final String PRODUCT_NAME = "IPhone 7";
	}
}