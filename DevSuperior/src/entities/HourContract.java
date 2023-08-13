package entities;

import java.util.Date;

public class HourContract {

	// Atributos
	private Date date;
	private Double valuePerHour;
	private Integer hours;

	// Contrutores
	public HourContract() {

	}

	public HourContract(Date date, Double valuePerHour, Integer hours) {
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}

	public Double totalValue() {
		return valuePerHour * hours;
	}

	// Getters & Setters
	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setHour(Integer hours) {
		this.hours = hours;
	}

	public Integer getHours() {
		return hours;
	}

}
