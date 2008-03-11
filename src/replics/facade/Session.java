package replics.facade;

public class Session {
	
	private Integer Region;
	private Integer District;
	private Integer Center;
	
	private String loginTL;
	private String loginIdent;
	private String loginContr;
	
	private String loginCivil1;
	private String loginCivil2;
	
	static private Session session = null;
	
	static public Session instance(Integer region, Integer district, Integer center){
		
		if(session==null)session=new Session(region, district, center);
		
		return session;
	}	
	
	private Session(Integer region, Integer district, Integer center) {
		super();
		Region = region;
		District = district;
		Center = center;
	}
	
	public Integer getRegion() {
		return Region;
	}
	public void setRegion(Integer region) {
		Region = region;
	}
	public Integer getDistrict() {
		return District;
	}
	public void setDistrict(Integer district) {
		District = district;
	}
	public Integer getCenter() {
		return Center;
	}
	public void setCenter(Integer center) {
		Center = center;
	}
	public String getLoginTL() {
		return loginTL;
	}
	public void setLoginTL(String loginTL) {
		this.loginTL = loginTL;
	}
	public String getLoginIdent() {
		return loginIdent;
	}
	public void setLoginIdent(String loginIdent) {
		this.loginIdent = loginIdent;
	}
	public String getLoginContr() {
		return loginContr;
	}
	public void setLoginContr(String loginContr) {
		this.loginContr = loginContr;
	}

	public String getLoginCivil1() {
		return loginCivil1;
	}

	public void setLoginCivil1(String loginCivil1) {
		this.loginCivil1 = loginCivil1;
	}

	public String getLoginCivil2() {
		return loginCivil2;
	}

	public void setLoginCivil2(String loginCivil2) {
		this.loginCivil2 = loginCivil2;
	}
	
	
	
}

