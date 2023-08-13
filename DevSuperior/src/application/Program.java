package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter departmen name: ");
		String department = sc.nextLine();

		System.out.println("Enter worker date: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base Salary: ");
		Double baseSalary = sc.nextDouble();

		Worker worker = new Worker(name, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(department));

		System.out.println("How many contracts to this worker? ");
		int num = sc.nextInt();

		for (int i = 0; i < num; i++) {
			System.out.println("Enter contracts #" + (i + 1) + " data: ");
			System.out.print("Enter (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration in hours: ");
			int hours = sc.nextInt();

			HourContract contract = new HourContract(contractDate, valuePerHour, hours);

			worker.addContract(contract);
		}

		System.out.println();

		System.out.println("Enter month and year to calulate income (MM/YYYY): ");
		String monthAndYear = sc.next();

		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));

		System.out.println();

		System.out.println("Name: " + worker.getName());
		System.out.println("Departmetn: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

		sc.close();
	}

}
