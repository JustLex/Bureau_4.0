package by.zhakov.bureau.model;

public class Specification {
	private int id;
	private int idUser;
	public Specification(int id, int idUser) {
		super();
		this.id = id;
		this.idUser = idUser;
	}
	public int getId() {
		return id;
	}
	public int getIdUser() {
		return idUser;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + idUser;
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
		Specification other = (Specification) obj;
		if (id != other.id)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Specification [id=" + id + ", idUser=" + idUser + "]";
	}
}
