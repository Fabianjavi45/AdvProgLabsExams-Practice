package Exam3;

public class Village {

	private String villageName;
	private Player[] players;

	public Village(String villageName, int numOfPlayers ,String[][] players) {
		super();
		this.villageName = villageName;
		this.players = new Player[numOfPlayers];
		for(int i = 0; i < numOfPlayers; i++) {
			switch(players[i][0]) {
			case "Villager":
				this.players[i] = 
				new Villager(players[i][1],Integer.parseInt(players[i][2]),Integer.parseInt(players[i][3]),players[i][4]);
				break;
			case "Police":
				this.players[i] = 
				new Police(players[i][1],Integer.parseInt(players[i][2]),Integer.parseInt(players[i][3]),players[i][4]);
				break;
			case "Chief":
				this.players[i] = 
				new Chief(players[i][1],Integer.parseInt(players[i][2]),Integer.parseInt(players[i][3]),Integer.parseInt(players[i][4]));
				break;
			case "Mayor":
				this.players[i] = 
				new Mayor(players[i][1],Integer.parseInt(players[i][2]),Integer.parseInt(players[i][3]),Integer.parseInt(players[i][4]));
				break;
			}
		}
	}
	public String getVillageName() {
		return this.villageName;
	}
	public int numOfPlayers() {
		return players.length;
	}
	/*
	 * Exercise A
	 * Implement the Chief Class by calling the super constructor
	 * and passing the correspondent parameters.
	 */
	public String[] getChiefPolice() {
		String[] ret = new String[4];
		ret[0] = players[0].getName();
		ret[1] = String.valueOf(players[0].getInches());
		ret[2] = String.valueOf(players[0].getWeight());
		ret[3] = String.valueOf(((Chief) players[0]).getYearsInService());
		return ret;
	}
	/*
	 * Exercise B
	 * Override the Chief getSalary method by calling the super
	 * getSalary and adding the bonus times yearInService.
	 */
	public int getChiefSalary() {
		//Implement code on Chief class!
		int ret = 0;
		ret = ((Chief)players[0]).getSalary();
		return ret;
	}
	/*
	 * Exercise C part 1
	 * Override each subclass enterEvent() method.
	 * Villager can only enter the "Party event.
	 * Police can enter the "Party" and "PDMeeting" events.
	 * Mayor can enter the "Party", "PDMeeting", and "Presidential Reunion" events.
	 */
	public boolean[] event(String event) {
		boolean [] ret = new boolean[players.length];
		for (int i = 0; i < players.length; i++) {
			ret[i] = players[i].enterEvent(event);
		}
		return ret;
	}
	/*
	 * Exercise C part 2
	 * Override the disable Alarm in Chief Class to 
	 * return true when asked to disable Alarm.
	 * [disableAlarm() method]
	 */
	public boolean[] alarm() {
		boolean [] ret = new boolean[players.length];
		for (int i = 0; i < players.length; i++) {
			ret[i] = players[i].canDisableAlarm();
		}
		return ret;
	}
	/*
	 * Exercise D
	 * Modify each class to greet as follows: (greet() method).
	 * Villager: "Hello, I am [name] and I work at [work place]."
	 * Police: "I am Police [name] at your service."
	 * Chief: "I am Chief [name]."
	 * Mayor: "Greetings, I am [name], the Mayor of this city."
	 */
	public String[] greetAll() {
		//Implement the code on the subclasses!
		String[] ret = new String[players.length];
		for (int i = 0; i < players.length; i++) {
			ret[i] = players[i].greet();
		}
		return ret;
	}
	/* 
	 * Exercise E
	 * Override players subclasses' method equals considering
	 * the parameter's type and the object's variables.
	 */
	public boolean[] comparePlayers() {
		//Implement the code on the subclasses.
		boolean[] ret = new boolean[players.length+2];
		for(int i = 0; i < players.length; i++) {
			ret[i] = players[i].equals(players[(players.length-1)-i]);
		}
		ret[players.length] = players[0].equals(null);
		ret[players.length+1] = players[0].equals(players[0]);
		return ret;
	}
	/*
	 * BONUS
	 * Implement the method to count the difference types
	 * of players by using instanceof.
	 * Return a new String array with 3 numbers as a String
	 * First one would be the number of Villagers
	 * Second would be number of Police
	 * Third would be number of Mayors
	 * (Hint: Use the method String.valueOf(String) to change from a int to a String)
	 */
	public String[] countTypesOfPlayers() {
		String[] Types= new String[3];
		int Villagers=0;
		int Police=0;
		int Mayors=0;
		for (int i = 0; i < players.length; i++) {
			if(players[i] instanceof Villager) {
				if(players[i] instanceof Police) {Police++;}
				else if(players[i] instanceof Mayor) {Mayors++;}
				Villagers++;
			}
		}
		Types[0]= String.valueOf(Villagers);
		Types[1]= String.valueOf(Police);
		Types[2]= String.valueOf(Mayors);
		return Types;
	}
	
	/*
	 * This is the abstract class Player
	 */
	abstract class Player {
		private String name;
		private int inches;
		private int weight;

		protected Player(String name, int inches, int weight) {
			super();
			this.name = name;
			this.inches = inches;
			this.weight = weight;
		}
		public String getName() {
			return name;
		}
		public int getInches() {
			return inches;
		}
		public int getWeight() {
			return weight;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setInches(int inches) {
			this.inches = inches;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		public boolean canDisableAlarm() {
			return false;
		}
		
		public abstract String greet();
		public abstract boolean enterEvent(String event);
	}
	/*
	 * This is the Villager Class
	 */
	class Villager extends Player {
		
		private String job;

		public Villager(String name, int inches, int weight, String job) {
			super(name, inches, weight);
			this.job = job;
		}
		public String getJob() {
			return job;
		}
		public void setJob(String job) {
			this.job = job;
		}

		/*
		 * Exercise C part 1
		 * Override object's method (enterEvent) considering
		 * the parameter's type String
		 * Villager can only enter the Party event
		 */
		@Override
		public boolean enterEvent(String event) {
			if(event.contentEquals("Party")) {
				return true;
			}
			else return false; //Dummy Return
		} 
		/*
		 * Exercise D
		 */
		@Override
		public String greet() {
			return  "Hello, I am " + this.getName() + " and I work at " + this.getJob() + ".";
		}
		/* 
		 * Exercise E
		 * Override object's equals method considering
		 * the parameter's type and the object's variables.
		 */
		public boolean equals(Object obj) {
			if(obj instanceof Villager) {
				Villager v= (Villager)obj;
				if(v.getName().equals(super.getName()) && v.getInches()==super.getInches() 
						&& v.getWeight()==super.getWeight() && v.getJob().equals(this.getJob())){
					return true;
				}
			}
			return false; //Dummy Return
		}
	}
	/*
	 * This is the Police Class
	 */
	class Police extends Player {
		
		private final int SALARY = 50000;
		
		
		public int getSalary() {
			return SALARY;
		}
		
		private String rank;

		public Police(String name, int inches, int weight, String rank) {
			super(name, inches, weight);
			this.rank = rank;
		}
		public String getRank() {
			return rank;
		}
		public void setRank(String rank) {
			this.rank = rank;
		}
		/*
		 * Exercise C part 1
		 * Override object's method enterEvent considering
		 * the parameter's type String
		 * Police can only enter the Party and PDMeeting events
		 */
		@Override
		public boolean enterEvent(String event) {
			if(event.equals("Party") || event.equals("PDMeeting")) {
				return true;
			}
			else return false; //Dummy Return
		}
		/*
		 * Exercise D
		 */
		@Override
		public String greet() {
			return "I am Police " + this.getName() + " at your service.";
		}
		/* 
		 * Exercise E
		 * Override object's equals method considering
		 * the parameter's type and the object's variables.
		 */
		public boolean equals(Object obj) {
			if(obj instanceof Police) {
				Police p= (Police)obj;
				if(p.getName().equals(super.getName()) && p.getInches()==super.getInches() 
						&& p.getWeight()==super.getWeight() && p.getRank().equals(this.getRank())){
					return true;
				}
			}
			return false; //Dummy Return
		}
	}
	/*
	 * This is the Chief Class
	 */
	class Chief extends Police {

		private int yearsInService;
		
		/*
		 * Exercise A
		 */
		public Chief(String name, int inches, int weight, int yearsInService) {
			super(name,inches,weight,"Chief");//Dummy super
			this.yearsInService=yearsInService;
		}
		public int getYearsInService() {
			return yearsInService;
		}
		public void setYearInService(int yearsInService) {
			this.yearsInService = yearsInService;
		}

		/*
		 * Exercise B
		 * Override the getSalary method by calling the super
		 * getSalary and adding the bonus times yearInService.
		 * If chief has more that 3 years and less than 5 years of service his salary will be raised 25%
		 * If chief has 5 years or more and less that 10 years of service his salary will be raised 50%
		 * If chief has 10 years or more of service his salary will be raised 75%
		 * Else the salary will not be raised.
		 */
		@Override
		public int getSalary() {
			if(yearsInService>3 && yearsInService<5) {
			return (int) (super.SALARY*1.25);
			}
			else if(yearsInService>=5 && yearsInService<10) {
				return (int) (super.SALARY*1.5);
			}
			else if(yearsInService>=10){
				return (int) (super.SALARY*1.75);
			}
			else return super.SALARY;
			//Dummy Return
		}
		/*
		 * Exercise C part 2
		 */
		@Override
		public boolean canDisableAlarm() {
			return !super.canDisableAlarm();
		}
		/*
		 * Exercise D 
		 */
		@Override
		public String greet() {
			return "I am Chief "+ this.getName() + ".";
		}
		/* 
		 * Exercise E
		 * Override object's equals method considering
		 * the parameter's type and the object's variables.
		 */
		public boolean equals(Object obj) {
			if(obj instanceof Chief) {
				Chief p= (Chief)obj;
				if(p.getName().equals(super.getName()) && p.getInches()==super.getInches() 
						&& p.getWeight()==super.getWeight() 
						&& p.getRank().equals(super.getRank()) && p.getYearsInService()==this.getYearsInService()){
					return true;
				}
			}
			return false;//Dummy Return
		}
	}
	/*
	 * This is the Mayor's class
	 */
	class Mayor extends Player {
		
		private int term;

		public Mayor(String name, int inches, int weight, int term) {
			super(name, inches, weight);
			this.term = term;
		}
		public int getTerm() {
			return term;
		}
		public void setTerm(int term) {
			this.term = term;
		}

		/*
		 * Exercise C part 1
		 * Override object's method enterEvent considering
		 * the parameter's type String
		 * Mayor can enter the Party, PDMeeting and Presidential Reunion events
		 */
		@Override
		public boolean enterEvent(String event) {
			if(event.equals("Party") || event.equals("PDMeeting") || event.equals("Presidential Reunion")) {
				return true;
			}
			else return false;
		}
		/*
		 * Exercise D
		 */
		@Override
		public String greet() {
			return "Greetings, I am " + this.getName() + ", the Mayor of this city.";
		}
		/* 
		 * Exercise E
		 * Override object's equals method considering
		 * the parameter's type and the object's variables.
		 */
		public boolean equals(Object obj) {
			if(obj instanceof Mayor) {
				Mayor p= (Mayor)obj;
				if(p.getName().equals(super.getName()) && p.getInches()==super.getInches() 
						&& p.getWeight()==super.getWeight() && p.getTerm()== this.getTerm()){
					return true;
				}
			}
			return false;
		}
	}
}