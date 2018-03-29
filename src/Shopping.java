import java.util.Scanner;

public class Shopping {
	
	public static void register(Scanner input, UserBuilder userBuilder) {
		
		System.out.println("What's your name?");
		String name = input.next();
		userBuilder.setUserName(name);
		System.out.printf("Nice to meet you, %s! \n ", name);
		System.out.println("");
		
		
	}
	
	public static int occupation(Scanner input, UserBuilder userBuilder) {
		
		Job[] jobs = {
				new Job("Singer",5800),
				new Job("Sales", 5000),
				new Job("Accountant", 6100),
				new Job("Admin", 4800),
				
			};
		
		for (int i = 0; i < jobs.length; i++) {
			String jobName = jobs[i].getJobName();
			System.out.printf("%d. %s\n",i, jobName);
		
		}
		int ChooseJob = input.nextInt();
		
		int money = 0;
		int income = jobs[ChooseJob].getIncome();
		userBuilder.setJob(jobs[ChooseJob]);
		if (ChooseJob ==0){
				System.out.printf("You became famous. You got $%d last year\n", income);
				money = income;
		}else if(ChooseJob == 1) {
				System.out.printf("You often got sick. You got $%d last year\n", income);
				money = income;
		}else if (ChooseJob == 2) {
				System.out.printf("You passed the exam and became CPA! You got $%d last year\n",income);
				money = income;
		}else if (ChooseJob == 3) {
				System.out.printf("You did your best but could't leave good regacy. You got $%d last year\n", income);
				money = income;
		}
		
		
		
		System.out.println("");
		System.out.println("---------------------------");
		
		return money;

	}

	public static int BuyItem(Scanner input, int money) {
		
		Item[] items = {
			new Item("Snack", 4),
			new Item("Hamburger meal", 9),
			new Item("Cosmetic item", 17),
			new Item("Book", 18),
			new Item("T-shirts", 22),
			new Item("Coffee maker", 80),
			new Item("Good pillow", 112),
			new Item("Shoes", 178),
			new Item("Good bed", 1200),
			new Item("PC screen", 1780),
			new Item("Haerdware for Desktop PC", 2450),
			new Item("4K TV(60in)",5000),
			new Item("Car", 34000)
		};
		
		for(int i=0; i<items.length; i++) {
			Item item = items[i];
			int price = item.getPrice();
			String name = item.getName();
			System.out.printf("%d. %s = $%d\n", i, name, price);
		}
		
		String answer = "";
		while(true) {
			System.out.println("------------------------");
			System.out.println("");
			System.out.println("Do you want to buy anything? yes/no : ");
			answer = input.next();
			if(!answer.equals("yes")) {
				System.out.println("ok, shopping is over");
				System.out.printf("Your balance is $%d",money);
				break;
			}
			
			System.out.printf("Your balance is $%d\n",money);
			System.out.print("What is the item id?");
			System.out.println("");
			int buy = input.nextInt();
			if (buy < 0 && buy >= items.length) {
				System.out.println("invalid item");
				continue;
			}
			
			Item wantedItem = items[buy];
			if (money < wantedItem.getPrice()) {
				System.out.println("Not enough money");
				continue;
			}
			
			System.out.printf("You bought %s", wantedItem.getName());
			System.out.println();
			money -= wantedItem.getPrice();
			System.out.printf("Remaining: $%d (-$%d)", money, wantedItem.getPrice());
			System.out.println();
		}
		
		return money;
		
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		UserBuilder userBuilder = new UserBuilder();
		register(input,userBuilder);

		System.out.println("Which job do you want to get? = ");
		int money = occupation(input, userBuilder);
		
		userBuilder.build();
		
		System.out.println("This is shopping list.");
		System.out.println("");
		
		
		BuyItem(input,money);
		
		input.close();
	}
}
