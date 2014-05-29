package by.zhakov.bureau.model;

public class Specialist {
	private int id;
	private int idQualification;
	private int salary;
	private int idProject;
	private String name;

	public Specialist(int id, int idQualification, int salary, int idProject,
			String name) {
		super();
		this.id = id;
		this.idQualification = idQualification;
		this.salary = salary;
		this.idProject = idProject;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public int getIdQualification() {
		return idQualification;
	}
	public int getSalary() {
		return salary;
	}
	public int getIdProject() {
		return idProject;
	}
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + idProject;
		result = prime * result + idQualification;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + salary;
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
		Specialist other = (Specialist) obj;
		if (id != other.id)
			return false;
		if (idProject != other.idProject)
			return false;
		if (idQualification != other.idQualification)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Specialist [id=" + id + ", idQualification=" + idQualification
				+ ", salary=" + salary + ", idProject=" + idProject + ", name="
				+ name + "]";
	}
	
	
}
