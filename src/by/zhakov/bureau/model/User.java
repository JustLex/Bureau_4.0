package by.zhakov.bureau.model;

public class User {
	private int id;
	private String name;
	private String phone;
	private String address;
	private boolean isAdmin;
	private String login;
	private String password;
	
	
	
	
	public User(int id, String name, String phone, String address,
			boolean isAdmin, String login, String password) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.isAdmin = isAdmin;
		this.login = login;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	
	

	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + id;
		result = prime * result + (isAdmin ? 1231 : 1237);
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id != other.id)
			return false;
		if (isAdmin != other.isAdmin)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", address=" + address + ", isAdmin=" + isAdmin + ", login="
				+ login + ", password=" + password + "]";
	}
	
}
