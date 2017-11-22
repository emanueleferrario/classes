import java.util.Scanner;

public class Exercise8 {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Individual person1 = new Individual();
		person1.setPerson("Emanuele,Ferrario,1800915350014");

		Individual person2 = new Individual();
		person2.setPerson("Elisa,Ferrario,2110209350120");

		Individual person3 = new Individual();
		person3.setPerson("Marco,Ferrario,1150302350011");

		Individual[] people = { person1, person2, person3 };
		for (int i = 0; i < 3; i++) {
			System.out.println(people[i].getPerson());
		}
		System.out.println();

		for (int i = 0; i < 3; i++) {
			if (people[i].checkCNP() == false) {
				System.out.println("CNP for " + people[i].getFirstName() + " " + people[i].getLastName()
						+ " is not Valid! - please set another Value");
				return;
			}
		}
		for (int i = 0; i < 3; i++) {
			System.out.println("FirstName: " + people[i].getFirstName());
			System.out.println("LastName: " + people[i].getLastName());
			System.out.println("CNP: " + people[i].getCNP());
			System.out.println("Sex: " + people[i].getSex(people[i].getCNP()));
			System.out.println("Date of birth: " + people[i].getDateofBirth(people[i].getCNP()));
			System.out.println("Personal code: " + people[i].getPersonalCode(people[i].getCNP()));
			System.out.println();
		}
	}
}

// ------
class Individual extends Exercise8 {
	private String Human;
	private String firstName;
	private String lastName;
	private String CNP;

	public void setPerson(String human) {
		Human = human;
	}

	public String getPerson() {
		return Human;
	}

	public void displayPerson() {
		System.out.println(getPerson());
	}

	public String getFirstName() {
		if (getPerson() == null) {
			return null;
		}
		firstName = getPerson().split(",", -1)[0].trim();
		return firstName;
	}

	public String getLastName() {
		if (getPerson() == null) {
			return null;
		}
		lastName = getPerson().split(",", -1)[1].trim();
		return lastName;
	}

	// check CNP
	public boolean checkCNP() {
		CNP = getPerson().split(",", -1)[2].trim();
		String[] numbers = CNP.split("");
		int firstCNPnumber = Integer.parseInt(numbers[0]);
		if (numbers.length == 13 && (firstCNPnumber == 1 || firstCNPnumber == 2)) {
			return true;
		} else {
			return false;
		}
	}

	public String getCNP() {
		if (getPerson() == null) {
			return null;
		}
		CNP = getPerson().split(",", -1)[2].trim();
		return CNP;
	}

	public String getSex(String CNP) {
		String sex = "";
		int sexcode = Integer.parseInt(CNP.split("", -1)[0]);
		if (sexcode == 1) {
			sex = "Male";
		}
		if (sexcode == 2) {
			sex = "Female";
		}
		return sex;
	}

	public String getDateofBirth(String CNP) {
		String yearshort = CNP.split("", -1)[1] + CNP.split("", -1)[2];
		String year;
		if (Integer.parseInt(yearshort) > 17) {
			year = "19" + yearshort;
		} else
			year = "20" + yearshort;
		String month = CNP.split("", -1)[3] + CNP.split("", -1)[4];
		String day = CNP.split("", -1)[5] + CNP.split("", -1)[6];

		return day + " / " + month + " / " + year;
	}

	public String getPersonalCode(String CNP) {
		String personalcode = CNP.split("", -1)[7] + CNP.split("", -1)[8] + CNP.split("", -1)[9] + CNP.split("", -1)[10]
				+ CNP.split("", -1)[11] + CNP.split("", -1)[12];
		return personalcode;
	}
}
