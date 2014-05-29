package by.zhakov.bureau.model;

import java.sql.Date;

public class Project {
	private int id;
	private Date startDate;
	private Date endDate;
	private String name;
	private int idSpecification;
	public Project(int id, Date startDate, Date endDate, String name,
			int idSpecification) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.name = name;
		this.idSpecification = idSpecification;
	}
	public int getId() {
		return id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public String getName() {
		return name;
	}
	public int getIdSpecification() {
		return idSpecification;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + id;
		result = prime * result + idSpecification;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
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
		Project other = (Project) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (idSpecification != other.idSpecification)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", startDate=" + startDate + ", endDate="
				+ endDate + ", name=" + name + ", idSpecification="
				+ idSpecification + "]";
	}
	
}
