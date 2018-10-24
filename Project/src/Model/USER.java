package Model;

import java.util.Date;

public class USER {
	private int id;
	private String login_id;
	private String name;
	private Date birthDate;
	private String password;
	private String createDate;
	private String updateDate;

	public USER(String login_id, String name) {
		this.login_id=login_id;
		this.name=name;
	}
	public USER(int id, String login_id, String name, Date birthDate, String password, String createDate,
			String updateDate){
		this.id=id;
		this.login_id=login_id;
		this.name=name;
		this.birthDate=birthDate;
		this.password=password;
		this.createDate=createDate;
		this.updateDate=updateDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
}