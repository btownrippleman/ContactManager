package org.openjfx.hellofx;

import java.util.Random;
import java.io.IOException;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

public class PrimaryController {
	@FXML
	MenuBar menuBar;
	@FXML
	private MenuItem quitItem;
	@FXML
	private TableView<Contact> table = new TableView<>();
	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField addressField;
	@FXML
	private TextField emailField;
	@FXML
	private TextField numberField;
	@FXML
	private Button addButton;
	@FXML
	private Button searchButton;
	@FXML
	private Button viewAllContactsButton;
	@FXML
	private TableColumn<Contact, String> lastNameColumn;
	@FXML
	private TableColumn<Contact, String> emailColumn;
	@FXML
	private TableColumn<Contact, String> numberColumn;
	@FXML
	private TableColumn<Contact, String> addressColumn;
	@FXML
	private TableColumn<Contact, String> firstNameColumn;
	@FXML
	private TableColumn<Contact, Button> buttonColumn;
	@FXML
	private GridPane addContactFields;
	Random rnd = new Random();
	public String[] first_names = { "Amanda", "Mattie", "James", "Jennifer", "Donald", "Maria", "Brenda", "Hosea",
			"Homer", "Robert", "Phillip", "Michael", "Wanda", "Mimi", "Erik", "Mildred", "Jessica", "Ruth", "Leon",
			"Jackie", "Richelle", "Susie", "Rick", "David", "Gladys", "Leonard", "Charles", "Helen", "Carolyn", "Allen",
			"Debbie", "Joshua", "Jeffrey", "Kathy", "Giuseppe", "Wilson", "Maria", "Lawrence", "Sean", "Andrew",
			"William", "Patricia", "Zachary", "Tracy", "Amanda", "Linda", "Gene", "Sonia", "Marion", "Tina", "William",
			"Carol", "Tonya", "Martha", "Robert", "Herman", "Maureen", "Tiffany", "Carla", "Warren", "James", "Steve",
			"Raymond", "James", "Kirk", "Regina", "Christopher", "Preston", "Barbara", "Lisa", "Aaron", "Jenni",
			"Michael", "Christopher", "Howard", "Karen", "Tammy", "Erika", "Marie", "Corey", "Karin", "John", "Amanda",
			"Valerie", "Clarence", "Arron", "Lonnie", "Barbara", "Mellisa", "Mary", "Rose", "Douglas", "Earl", "Henry",
			"Timothy", "Arturo", "Vicki", "John", "Ed", "Samuel", "Dennis", "Frank", "Ruth", "Deanna", "Mamie",
			"Terence", "Tracy", "Elizabeth", "Joanne", "Steven", "Bill", "Andre", "Cameron", "Clare", "Mark",
			"Kimberly", "George", "Alexandria", "Sharon", "Ethel", "Jason", "Betty", "Dennis", "Paula", "Dolly",
			"Anita", "Ruth", "Gabriel", "Rosalba", "Tina", "Elizabeth", "Dorothy", "Jennifer", "Amanda", "Alfred",
			"Ryan", "Myrtis", "Gertrude", "Nancy", "James", "Joseph", "Bryan", "Nicole", "Peter", "Timothy", "Hannah",
			"Donald", "Richard", "Chad", "Alphonse", "Raymond", "Monique", "Darius", "Robert", "Matthew", "Richard",
			"Francisco", "John", "Julio", "Irma", "Jeff", "Daniel", "Doris", "Nicole", "Charles", "Amy", "Toni", "Judy",
			"Boyd", "Justine", "Edgar", "Robert", "Philip", "Gary", "Chad", "Louise", "Mary", "Jeffry", "Robert",
			"Terry", "Dorothy", "Ramon", "Donald", "Diane", "Allyson", "Leroy", "Karolyn", "Sandra", "Sandy", "Javier",
			"Amber", "Lorna", "Dorothy", "Chris", "Sharon", "Wayne", "Christian", "Carol", "Guadalupe", "Johnny",
			"Elizabeth", "Kimberly", "Joseph", "Betty", "Margaret", "Debbie", "Andrea", "Ann", "Tara", "Charlie",
			"Diane", "Kevin", "Michelle", "Jeremy", "Ricky", "Dawn", "Petra", "Tiffany", "Shanae", "Alfred", "Aja",
			"Jan", "Gerald", "Donna", "Kathleen", "Stephen", "Mary", "Mary", "Joan", "Joe", "Walter", "Scott", "Brian",
			"Alvin", "Dana", "Carolyn", "Ruby", "Christopher", "Betty", "William", "David", "Lolita", "Paul",
			"Rosemary", "Russell", "Stacey", "Norma", "William", "Christen", "Jeffery" };
	public String[] last_names = { "Davis", "Belanger", "Laskin", "Washington", "Mata", "Gray", "Thompson", "Taylor",
			"Carmichael", "Goldman", "Ruschmeyer", "Burnell", "Martin", "Crawford", "Thompson", "Bonner", "Cunningham",
			"Hedgepeth", "Page", "Watson", "Castro", "Hall", "Kirkpatrick", "Miller", "Ryan", "Dipiano", "Torres",
			"Johnson", "Wallace", "Scott", "Mcconnell", "Schmitt", "Cunningham", "Castaneda", "Howard", "Wall",
			"Walton", "Reilly", "Huckleberry", "Mair", "Robb", "Anderson", "Lancaster", "Drumm", "Alvarez", "Claggett",
			"Girdley", "Chalmers", "Fulmer", "Zimmerman", "Gutierrez", "Schaefer", "Kampa", "Mills", "Taylor", "Verch",
			"Hall", "Robertson", "Joiner", "Sliz", "Dawkins", "Bell", "Berlinski", "Ryan", "Smith", "Walsh", "Harlan",
			"Short", "Macias", "Story", "Hartman", "Morris", "Scroggins", "Hancher", "Scott", "Barcellos", "Sea",
			"Callahan", "Reynolds", "Noriega", "Harrison", "Jackson", "Mcpherson", "Richard", "Gray", "Bailey",
			"Richardson", "Ramirez", "Laws", "Prideaux", "Peterson", "Brown", "Lazar", "Clark", "Dinatale", "Randall",
			"Lopez", "Salter", "Henry", "Burnett", "Williams", "Starkey", "Rader", "Klug", "Thomas", "Jackson",
			"Garcia", "Rakel", "Craun", "Pharr", "Watts", "Francis", "Cox", "Voyles", "Russell", "Ballard", "Scott",
			"Serrano", "Albright", "Bookman", "Weiner", "Kam", "Kornegay", "Anderson", "James", "Krause", "Hearn",
			"Isaacs", "Reyes", "Rose", "Tanner", "Thornton", "Lumukanda", "Brereton", "Patel", "Johnson", "Chen",
			"Vildosola", "Green", "Brown", "Reyes", "Reyes", "Pearson", "West", "Mcdaniel", "Pearson", "Hopper",
			"Rozmus", "Puckett", "Ramirez", "Worstell", "Delara", "Greene", "Rivero", "Rodriguez", "Dambrose", "Alter",
			"Oliver", "Turner", "Claridge", "Steinberger", "Wang", "Massey", "Johansen", "Clark", "Baylon", "Lewis",
			"Johnson", "Ball", "Anderson", "Heninger", "Gugino", "Harrison", "Trombetta", "Perng", "Jackson", "Morgan",
			"Oloughlin", "Rivera", "Matheney", "Harrison", "Maddox", "Knox", "Daley", "Pooler", "Roman", "Jugo",
			"Stefani", "Huneycutt", "Holler", "Ogilvie", "Bishop", "Venema", "Biancuzzo", "Stone", "Espinosa", "Garcia",
			"Bird", "Heuer", "Lanza", "Skinner", "Miller", "Meeks", "Slade", "Foster", "Ferguson", "Franz", "Hams",
			"Evans", "Moultry", "Pfahler", "Beller", "Mccarron", "Hatcher", "Petree", "Citizen", "Diggs", "Hungerford",
			"Cornelius", "Obermeyer", "Schuetze", "Schexnayder", "Mcleod", "Davison", "Hoover", "Douglas", "Bermudez",
			"Myers", "Greene", "Nickerson", "Jordan", "Klemke", "Blake", "Wood", "Hansen", "Marquez", "French",
			"Thompson", "Coleman", "Johnson", "Skinner", "Opheim", "Kim", "Williams", "Smith", "Williams", "Bushee",
			"Bragg", "Brey", "Berdan" };
	public String[] street_names = { "Davis", "Terrell", "Prideaux", "Morgan", "Fournier", "Patterson", "Arend",
			"Duhon", "Kimmes", "Aubert", "Carmack", "Sandstrom", "Branch", "Doiron", "Belvin", "Price", "Jones",
			"Hopwood", "Buffin", "Berry", "Jones", "Perkins", "Culpepper", "Nelson", "Apo", "Peevey", "Wynne",
			"Goldblatt", "Rice", "Oldham", "Heckstall", "Tornquist", "Sherman", "Parker", "Samuel", "Welch", "Stone",
			"Miller", "Ball", "Barker", "Johnson", "Spaulding", "Rauth", "Shaw", "Powell", "Reeves", "Miller",
			"Timmerman", "Egbert", "Blache", "Dickerson", "Dolson", "Weatherly", "Rodriguez", "Slater", "Mason",
			"Gosnell", "Rodino", "Jenkins", "Mestas", "Rios", "Jagger", "Helm", "Goble", "Davis", "Evangelista",
			"Williams", "Williams", "Gallo", "Kovach", "Womack", "Smith", "Odom", "Wyatt", "Brown", "Jenkins",
			"Moseley", "King", "Gaskins", "Barrette", "Limbaugh", "Barrera", "Whaley", "Perez", "Larson", "Coronado",
			"Susanin", "Malachi", "Toler", "Dawson", "Mook", "Pike", "Edwards", "Holland", "Baptiste", "Rivas",
			"Joseph", "Pollard", "Archuleta", "Agosto", "Battle", "Whitlow", "Mains", "Spalding", "Beeman", "Bates",
			"Betschart", "Bartlett", "Welk", "Carbonaro", "Edwards", "Wilbanks", "Nelms", "Gibson", "Vanek", "Welch",
			"Bonner", "Howzell", "Jordan", "Davis", "Garver", "Wilkins", "Munoz", "Lankford", "Mora", "Calloway",
			"Reed", "Frye", "Adrian", "Gray", "Cameron", "Schreiber", "Simpson", "Dugger", "Reeves", "Robinson",
			"Owens", "Andersen", "Santana", "Hottle", "Chang", "Shumate", "Puig", "Stargel", "Scott", "Anderson",
			"Pierce", "Nelson", "Simmons", "Kelley", "Lara", "Fleagle", "Nason", "Hledik", "Moss", "Robinson",
			"Kuhlmann", "Cortez", "Krauss", "Contreras", "Morgan", "Gonzalez", "Bresnahan", "Ivy", "Barker", "Diaz",
			"Lyle", "Paya", "Bevis", "Smith", "Mcgee", "Dominguez", "Pettway", "Ackies", "Goldman", "Turpin", "Crader",
			"Mumbower", "Collazo", "Franklin", "Pena", "Rodriguez", "Renshaw", "Guthrie", "Grissom", "Walker", "Garvin",
			"Nims", "Rovinsky", "Hobson", "Sauls", "Brackman", "Arguello", "Wright", "Bernier", "Hall", "Pelayo",
			"Beverly", "Mccrary", "Shipley", "Rodgers", "Engen", "Anderson", "Blevins", "Acker", "Colbert", "Shephard",
			"Hogg", "Woodall", "Zak", "Lara", "Wilson", "Haney", "Knox", "Watkins", "Clark", "Stump", "Harris",
			"Olivares", "Linn", "Harwell", "Harris", "Green", "Carter", "Belzer", "Stoltz", "Bull", "Martin", "Lewis",
			"Butler", "Blumenthal", "Allen", "Hamilton", "Anderson", "Calabro", "Shockley", "Smith", "Page", "Bailey",
			"Webb", "Williams", "Billington", "Moritz", "Ladner", "Lewis", "Clark", "Becerra", "Porter", "Wallace",
			"Henderson" };
	public String[] roadTypes = { "Lane", "Avenue", "Boulevard", "Way", "Road", "Street", "Court", "Plaza", "Terrace",
			"Drive" };
	public String[] domains = { "yahoo", "gmail", "hotmail", "rambler", "comcast", "heaven", "godaddydaddy123",
			"securemail", "random_domain" };
	public String[] gltds = { "net", "com", "ru", "ca", "org", "gov", "mil", "edu" };
	private ObservableList<Contact> contactData = FXCollections.observableArrayList();

	public void addContact() {
		System.out.println("adding tcontact");
		Contact contact = new Contact();
		contact.setAddress(addressField.getText());
		contact.setEmail(emailField.getText());
		contact.setFirstName(firstNameField.getText());
		contact.setLastName(lastNameField.getText());
		contact.setNumber(numberField.getText());

		contactData.add(contact);

		table.setItems(contactData);
		for (Node n : addContactFields.getChildren())
			((TextField) n).setText("");

	}

	public String randomPhoneNumberGenerator() {
		String number = "";
		for (int i : new int[10]) {
			number = number + Integer.toString(rnd.nextInt(7) + 2);
		}
		return number;
	}

	public Contact randomContactGenerator() {
		Contact c = new Contact();
		c.setFirstName(first_names[rnd.nextInt(first_names.length - 1)]);
		c.setLastName(last_names[rnd.nextInt(last_names.length - 1)]);
		c.setEmail(c.getFirstName() + c.getLastName() + "@" + domains[rnd.nextInt(domains.length - 1)] + "."
				+ gltds[rnd.nextInt(gltds.length - 1)]);
		c.setEmail(c.getEmail().toLowerCase());
		c.setAddress(rnd.nextInt(2000) + " " + street_names[rnd.nextInt(street_names.length - 1)] + " "
				+ roadTypes[rnd.nextInt(roadTypes.length - 1)]);
		c.setNumber(randomPhoneNumberGenerator());
		Button btn = new Button();
		btn.setText("Delete");
		btn.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				contactData.remove(c);
				table.setItems(contactData);
			}
		});
		c.setDeleteButton(btn);
		return c;
	}

	public void deleteContact(Contact c) {
		contactData.remove(c);
		table.setItems(contactData);
	}

	public void searchContact() {
		ObservableList<Contact> paginate = FXCollections.observableArrayList();
		for (Contact c : contactData) {
			boolean addContact = true;
			if (!c.getFirstName().contains(firstNameField.getText()))
				addContact = false;
			else if (!c.getLastName().contains(lastNameField.getText()))
				addContact = false;
			else if (!c.getEmail().contains(emailField.getText()))
				addContact = false;
			else if (!c.getAddress().contains(addressField.getText()))
				addContact = false;
			else if (!c.getNumber().contains(numberField.getText()))
				addContact = false;
			if (addContact)
				paginate.add(c);
		}
		table.setItems(paginate);
		for (Node n : addContactFields.getChildren())
			((TextField) n).setText("");
		System.out.println("search contact");

	}

	public void loadTable() {
		System.out.println("load table");
		table.setEditable(true);
		for (int i : new int[100])
			contactData.add(randomContactGenerator());
		table.setItems(contactData);

	}

	public void viewAllContacts() {
		table.setItems(contactData);
	}

	public void initialize() {
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("lastName"));
		emailColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("Email"));
		numberColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("Number"));
		addressColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("Address"));
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Contact, String>("firstName"));
		buttonColumn.setCellValueFactory(new PropertyValueFactory<Contact, Button>("deleteButton"));
		quitItem.setOnAction(e -> Platform.exit());

		loadTable();
	}
}

class Table {

}
