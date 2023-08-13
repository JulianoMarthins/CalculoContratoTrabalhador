package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	// Atributos
	private String name;
	private WorkerLevel workerLevel;
	private Double baseSalary;

	// Associações
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();

	// Contrutor
	public Worker() {

	}

	public Worker(String name, WorkerLevel workerLevel, Double baseSalary, Department department) {
		this.name = name;
		this.workerLevel = workerLevel;
		this.baseSalary = baseSalary;
		this.department = department;

	}

	public void addContract(HourContract contract) {
		contracts.add(contract);
	} // Adiciona um contrato ao trabalhador

	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	} // Remove um contrato do trabalhador

	public Double income(int year, int month) {
		double sum = baseSalary;

		for (HourContract c : contracts) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(c.getDate());
			int c_year = calendar.get(Calendar.YEAR);
			int c_month = 1 + calendar.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				sum += c.totalValue();
			}

		}

		return sum;

	} // Retona todos os contratos do trabalhador selecionados por mês e ano

	// Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getWorkerLevel() {
		return workerLevel;
	}

	public void setWorkerLevel(WorkerLevel workerLevel) {
		this.workerLevel = workerLevel;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

}
