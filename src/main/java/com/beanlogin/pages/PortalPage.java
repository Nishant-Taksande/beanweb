package com.beanlogin.pages;

import org.openqa.selenium.WebDriver;

public class PortalPage {

	//// header

	WebDriver driver;

	public static String beanLoginLogo = "xpath://div[@class='row no-gutters align-items-center flex-nowrap']//img[contains(@src,'BeanLoginLogo')]";
	public static String beanLoginLabel = "xpath://a[text()='BEANLOGIN']";

	public static String searchBox = "xpath://input[@id='txtSearch']";

	public static String magnifyIcon = "xpath://span[@class='icon icon-magnify field-icon']";
	public static String sortAtoZ = "xpath://img[contains(@src,'SortAtoZ')]";
	public static String gridView = "xpath://i[@id='gridView']";

	public static String titleView = "xpath://i[@id='tileView']";
	public static String profileImg = "xpath://img[contains(@src,'avatars/profile')]";

	public static String userName = "xpath://span[@class='username mx-3 d-none d-md-block']";
	public static String bellIcon = "xpath://i[@class='icon-bell-ring icon-color-white']";

	public static String helpIcon = "xpath://i[@class='icon-help-circle icon-color-white']";

	// useranme dropdown
	public static String myProfileIcon = "xpath://i[@class='icon-account s-4']";
	public static String myprofileLink = "xpath://span[text()='My Profile']";

	public static String sharedDetailsIcon = "xpath://i[@class='icon-share-variant s-4']";

	public static String sharedDetailsLink = "xpath://span[text()='Shared Details']";
	public static String inviteIcon = "xpath://i[@class='status icon icon-google-circles-invite s-4']";

	public static String inviteLink = "xpath://span[text()='Invite']";
	public static String logoutIcon = "xpath://i[@class='icon-logout s-4']";
    public static String logout = "xpath://span[text()='Logout']";
//------------------------
	public static String beanLoginLogo1 = "xpath://span//img[contains(@src,'BeanLoginLogo')]";
	public static String individualUserLabel = "xpath://span[text()='Individual User']";
	
	public static String backBurger = "xpath://i[@class='icon icon-backburger']";
	public static String portalLabel = "xpath://span[text()='Portal']";
	
	public static String plusButton = "xpath://i[@class='icon icon-plus-circle']";
	public static String favoritesBookMarkIcon = "xpath://i[@class='icon s-4 icon-bookmark-check']";
	
	public static String favoritsLabel = "xpath://span[text()='Favorites']";
	public static String mostUesdIcon = "xpath://i[@class='icon s-4 icon-album']";
	
	public static String mostUsedLabel = "xpath://span[text()='Most Used']";
	public static String folderIcon = "xpath://i[@class='icon s-4 icon-folder-lock-open']";
	
	public static String folderlabel = "xpath://span[text()='Folders']']";
	public static String appIcon = "xpath://i[@class='icon s-4 icon-application']";
	
	public static String appLabel = "xpath://span[text()='Apps']";
	public static String notesIcon = "xpath://i[@class='icon s-4 icon-note-text']";
	
	public static String notesLabel = "xpath://span[text()='Notes']";
	public static String personalIcon = "xpath://i[@class='icon s-4 icon-folder']";
	
	public static String personalLabel = "xpath://span[text()='Personal ']";
	public static String personalthreeDot = "xpath://li[a[span[contains(text(),'Personal ')]]]/span";
	
	public static String sharedIcon = "xpath://i[@class='icon s-4 icon-share-variant']";
	public static String sharedLabel = "xpath://i[@class='icon s-4 icon-folder']";


	////select Type PopUp
	
	
	public static String selectTypeLabel = "xpath://h5[text()='Select Type']";
	public static String closeButton = "xpath://div[h5[text()='Select Type']]//button";
	
	public static String selectAppButton = "xpath://div[@id='selectApp']";
	public static String selctnoteButton = "xpath:/div[@id='selectNote']";
	
	public static String selectfoldrButton = "xpath://div[@id='selectFolder']";
	public static String appsLabel = "xpath://div[text()='App']";

	
	
	
	public static String noteLabel = "xpath://div[contains(text(),'Note')]";
	public static String folderLabel = "xpath://div[contains(text(),'Folder')]";
	
	public static String appImg = "xpath://div//div[@id='selectApp']//img";
	public static String notesImg = "xpath://div//div[@id='selectNote']//img";
	
	public static String folderImg = "xpath://div//div[@id='selectFolder']//img";
	

	
	
	public PortalPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	
	
	
	
	
	
	
	
	
}
