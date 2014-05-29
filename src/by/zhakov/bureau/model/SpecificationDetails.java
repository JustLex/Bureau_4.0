package by.zhakov.bureau.model;

public class SpecificationDetails {
	private int id;
	private int idSpecification;
	private int idRequiredQualification;
	private int requiredWorkersCount;
	public SpecificationDetails(int id, int idSpecification,
			int idRequiredQualification, int requiredWorkersCount) {
		super();
		this.id = id;
		this.idSpecification = idSpecification;
		this.idRequiredQualification = idRequiredQualification;
		this.requiredWorkersCount = requiredWorkersCount;
	}
	public int getId() {
		return id;
	}
	public int getIdSpecification() {
		return idSpecification;
	}
	public int getIdRequiredQualification() {
		return idRequiredQualification;
	}
	public int getRequiredWorkersCount() {
		return requiredWorkersCount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + idRequiredQualification;
		result = prime * result + idSpecification;
		result = prime * result + requiredWorkersCount;
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
		SpecificationDetails other = (SpecificationDetails) obj;
		if (id != other.id)
			return false;
		if (idRequiredQualification != other.idRequiredQualification)
			return false;
		if (idSpecification != other.idSpecification)
			return false;
		if (requiredWorkersCount != other.requiredWorkersCount)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SpecificationDetails [id=" + id + ", idSpecification="
				+ idSpecification + ", idRequiredQualification="
				+ idRequiredQualification + ", requiredWorkersCount="
				+ requiredWorkersCount + "]";
	}
	
}
