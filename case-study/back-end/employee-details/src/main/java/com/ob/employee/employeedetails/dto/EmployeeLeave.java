package com.ob.employee.employeedetails.dto;

import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_leave")
public class EmployeeLeave {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="leave_date")
	private String leaveDate;
	@Column(name="leave_status")
	private String leaveStatus;
	@Column(name="employee_id")
	private int employeeId;
//	@OneToMany(mappedBy = "employeeLeave")
//	private Employees employees;
	@Override
	public String toString() {
		return "EmployeeLeave [id=" + id + ", leaveDate=" + leaveDate + ", leaveStatus=" + leaveStatus + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeLeave other = (EmployeeLeave) obj;
		if (id != other.id)
			return false;
		if (leaveDate == null) {
			if (other.leaveDate != null)
				return false;
		} else if (!leaveDate.equals(other.leaveDate))
			return false;
		if (leaveStatus == null) {
			if (other.leaveStatus != null)
				return false;
		} else if (!leaveStatus.equals(other.leaveStatus))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((leaveDate == null) ? 0 : leaveDate.hashCode());
		result = prime * result + ((leaveStatus == null) ? 0 : leaveStatus.hashCode());
		return result;
	}
	
	
}
