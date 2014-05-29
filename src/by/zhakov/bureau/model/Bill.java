package by.zhakov.bureau.model;

public class Bill {
	private int id;
	private int sum;
	private int idUser;
	private boolean payed;
	public Bill(int id, int sum, int idUser, boolean payed) {
		super();
		this.id = id;
		this.sum = sum;
		this.idUser = idUser;
		this.payed = payed;
	}
	public int getId() {
		return id;
	}
	public int getSum() {
		return sum;
	}
	public int getIdUser() {
		return idUser;
	}
	public boolean isPayed() {
		return payed;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + idUser;
		result = prime * result + (payed ? 1231 : 1237);
		result = prime * result + sum;
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
		Bill other = (Bill) obj;
		if (id != other.id)
			return false;
		if (idUser != other.idUser)
			return false;
		if (payed != other.payed)
			return false;
		if (sum != other.sum)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Bill [id=" + id + ", sum=" + sum + ", idUser=" + idUser
				+ ", payed=" + payed + "]";
	}
}
