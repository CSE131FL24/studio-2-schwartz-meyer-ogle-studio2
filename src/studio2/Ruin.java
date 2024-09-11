package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("What is your start amount?");
		int startAmount = in.nextInt();
		System.out.println("What is your win chance in percentage");
		double winChance = in.nextDouble();
		System.out.println("What is your win limit");
		int winLimit = in.nextInt();
		System.out.println("How many days do you want to play for?");
		int totalDays = in.nextInt();
		int totalPlaysInADay = 0;
		int days_gone_by = 0;
		int losses = 0;
		
		double alpha = (1-winChance)/winChance;
		
		double expectedruinRate;
		if(winChance == 50)
		{
			expectedruinRate = 1-((double)startAmount/(double)winLimit);
		}
		else
		{
			expectedruinRate = (Math.pow(alpha, (double)startAmount)-Math.pow(alpha, (double)winLimit))/(1-Math.pow(alpha, (double)winLimit));
		}
	
		
		while (days_gone_by < totalDays) {
			days_gone_by++;
			String winOrLose = "";
			int money = startAmount;
			totalPlaysInADay = 0;
			
				while (money > 0 && money < winLimit) {
					totalPlaysInADay++;
					money--;
					
						if (Math.random() < (winChance/100)){
							money++;
							money++;
						}
					
					if(money == 0)
					{
						winOrLose = "Lose";
						losses++;
					}
					else
					{
						winOrLose = "Win";
					}					
				}
			System.out.println("Simulation "+days_gone_by+": "+ totalPlaysInADay+" "+winOrLose);

			}
		
		System.out.println("Expected Ruin Rate: "+expectedruinRate*100+" - Real Ruin Rate: "+((double)losses/(double)days_gone_by)*100);
		
				
	}

}

