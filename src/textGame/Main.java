package textGame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class Main {
	
	
	
	JFrame window;
	Container con;
	JPanel titleNamePanel, characterPanel, enemyPanel, abilityPanel, textCharacter,  textEnemy, textAbility, back, titleNameEnemy,titleNameEnemy1 ;
	JLabel titleNameLabel,titleNameEnemyLabel, titleNameEnemyLabel1;
	Font titleFont = new Font("AR Julian", Font.PLAIN, 90);
	
	Font smallerTitleFont = new Font("AR Julian", Font.PLAIN, 50);// for enmies info and abilities info
	
	Font characterFont = new Font("Bell MT", Font.PLAIN, 25);
	
	Font smallerCharacterFont = new Font("Times New Roman",Font.PLAIN,25);
	Font smallerCharacterFont2 = new Font("Times New Roman",Font.PLAIN,15); // for abilities
	
	Font smallerFont = new Font("Times New Roman",Font.PLAIN,10);
	JButton characterButton, enemyButton, abilityButton, backButton, textButton, textButton2, textButton3,textButton4;
	
	JTextArea textCharacterArea, textCharacterArea1, textCharacterArea2, textCharacterArea3, textEnemiesArea;
	
	
	
	Handler tsHandler = new Handler();
	Handler1 tsHandler1 = new Handler1();// back button
	Handler2 tsHandler2= new Handler2();
	Handler3 tsHandler3 = new Handler3();
	Handler4 tsHandler4 = new Handler4();
	Handler5 tsHandler5 = new Handler5();
	Handler6 tsHandler6 = new Handler6();
	Handler7 tsHandler7 = new Handler7();
	//Text Based Game
	
	//cleaner UI, adjust info UI with java swing (learn more java swing)
	
	//add shopkeeper and some form of currency (another class maybe?) -- buy armor, upgrade weapon, buy blood vials, buy muslce paralyzer, chance of execution appearing is like 2%
	//shop has limited number of items (use random generalyzer), upgrade for all types of attacks, food for flees
		
	
	
	
	
	//possible upgrades for paralyzer, deal some type damage instead of 0;
	//precision strike upgrades : less damagetaken
	
	//detailed STATS sheet with dmg and everything somewhere
	
	//need some form of scaling of normal enemies and possibly bosses, how to scale bosses, nerf player( max number of silver bulelts or something else) maybe only first class needs nerf

	//advanced use AI to play against another hunter (has same ability and inventory or smtg), Corrupted Huntsmen
	//maybe add some kind of late game idk how to though
	
	public static void main(String[] args) {
		
		
		new Main();

		System.out.println("Welcome to the city of the Damned. Set in the 1800s, a mysterious virus has infected and transformed the inhabitants of this city into blood thirsty creatures. Hunters from around the world have been called to exterminate the beasts. You are one of them. Enjoy your stay and happy hunting!");
		
		
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		
		
		//Game monsters and creatures, beasts
		String[] enemies = {"Cursed Succubus ","Rabid Dog ","Mindless Undead ","Werewolf ","Unholy Warrior ","Witch Assassin ", "Berserker ", "Mad Ones ","Maneater Cultist ", "Scourge Beast ","Tough Brute ","Juggernaut Ghoul ", "Moonman ", "Cursed Teddy Bear ","Monster ", "Giant ", "Cave Monster ", "Succubus ","Faceless ", "Corrupted Military Purifier",
				"Corrupted Huntsmen ", "Executioner ", "Crazed Puppeteer ", "Rotted Corpses ", "Brainsucker ", "Brick Troll ", "Crawler","Giant Crawler ", "Undead Giant ","Blood Serpent ","Acidic Beast ", "Puppet ","Ghoul ","Acidic Ghoul ", "Buffer ", "Colossal Monster ", "Martyr ","Armored Ghoul ", "Corrupted GateKeeper ","Brood Horror " ,
				"BERSERKER QUEEN ", "NIGHTMARISH CREATURE ", "RAGED TWIN BRUTES ", "BLOOD-STARVED BEAST ", "MIMIC ","SCREAMER ", "HELL EXECUTIONNER "}; // another special monster would HELL EXECUTIONNER
		


		//Buffer gives all future enenmies +30 atk damage
		//upgrades for damageReductionNumb
		// and precision strike
		
		//create other chracter stats other than HP and attack damage, maybe like mental fortitude, luck, defense, chance of deflection
		int maxEnemyHealth = 75;
		int enemyAttackDamage = 25;
		
		int healthRegen = 0;
		
		
		int score = 0;
		
		//Player variables
		int maxPlayerHP = 200;
		int health = 100;
		int attackDamage = 50;
		int numHealthPots = 3;
		int numfullHealthPots = 0;
		
		//player's abilities
		int damageDealtPrecisionStrike = 50;
		int execute = 0;
		int ammo = 0; //attack with no retatliation
		int damageReduction = 0; //reduce the damage to the oponenet
		int damageReductionNumb = 15;
		int precisionStrike = 0;
		int flee = 3;
		int money = 0;
		int armor = 0; // another type of HP, difference is cannot heal, some enemies appearance can destroy the armor, chance to deflect/reflect damage when armor > 0 ,
		
		//blood injections
		int healthPotionHealAmount = 30;
		int healthPotionHealAmountMega = 100;
		int healthPotionDropChance = 30; // In terms of percentage
		
		
		
		int executionsDropChance1 = 50; // from  enemies like the Executionner, Mimic and HELL EXECUTIONNER
		int executionsDropChance2 = 25; // from enemies like Corrupted Huntsmen Brainsucker
		int executionsDropChance3= 10; // from enemies like Crazed Puppeteer and Cursed Teddy Bear
		
		
		int ammoDropChance = 65;// from enemies like Witch Assasin, Maneater Cultist, Corrupted Huntsmen, Ghoul, Rotted Corpses,Crawler, Cursed Succubus, Rotted Corpses, Cursed Teddy Bear
		int muscleParalyzerDrop = 30; // Cursed Teddy Bear
		int fleeDropChance = 10; // all enemies
		int precisionStrikeDrop = 10; // all enemies
		boolean running = true;
		
		
		//can decide to make more classes with unique abilities maybe
		//here choosing classes, only affect player stats and not enemy
		System.out.println("Select class");
		System.out.print("\t1. Professional Hunter"); // passive ability +1 health for each attack maybe?, maybe ability to lifesteal
		System.out.print("\t2. Marksmen");
		System.out.print("\t3. Military Veteran"); // increase attack ability +1, late game character
		System.out.print("\t4. Amateur Hunter");
		
		String input1= in.nextLine();
		
		if(input1.equals("1")) {
			System.out.println("\tYou've chosen to be a Professional Hunter. Born specialist and best suited for the job, fit for melee slaugtering and early endurance.");
			
			maxPlayerHP = 200;

			health = 130;
			healthRegen = 5;
			attackDamage = 60;
			
			numHealthPots = 5;
			numfullHealthPots = 1;
			
			execute = 0;
			ammo = 0;
			damageReduction = 0;
			precisionStrike = 3;
			flee = 3;
			money = 100;
			armor = 20;
			
			
			healthPotionHealAmount = 30;
			healthPotionDropChance = 30;
			
			
			
			
		}
		
		if(input1.equals("2")) {
			
			System.out.println("\tYou've chosen to be a Marksmen. Expert precision and high intellect, handles subjects from distance. Minimal chance of contamination.");
			
			maxPlayerHP = 130;

			health = 70;
			attackDamage = 40;
			numHealthPots = 3;
			
			numfullHealthPots = 0;
			
			
			healthRegen = 0;
			execute = 0;
			ammo = 4;
			damageReduction = 2;
			precisionStrike = 0;
			flee = 5;
			money = 100;
			armor = 20;
			
			healthPotionHealAmount = 20;
			healthPotionDropChance = 30; // In terms of percentage
		}
		
		if(input1.equals("3")) {
			
			System.out.println("\tYou've chosen to be a Military Veteran. Experienced in war and luckier than most. A soldier with equal strength and skill of a competent hunter.");
			maxPlayerHP = 150;
			health = 100;
			attackDamage = 50;
			numHealthPots = 3;
			
			numfullHealthPots = 0;
			
			healthRegen = 1;
			execute = 2;
			ammo = 1;
			damageReduction = 1;
			precisionStrike = 0;
			flee = 2;
			money = 200;
			armor = 50;
			
			healthPotionHealAmount = 30;
			healthPotionDropChance = 35; // In terms of percentage
			
			
			
		}
		
		if(input1.equals("4")) {
			System.out.println("You've chosen to be an Amateur Hunter. Confident or even arrogant. Young and foolish. Minimal chance of survival. Looking for the best possible challenge. ");
			maxPlayerHP = 100;
			health = 50;
			attackDamage = 45;
			numHealthPots =2;
			numfullHealthPots = 1;
			healthRegen = 1;
			execute = 0;
			ammo = 1;
			damageReduction = 0;
			precisionStrike = 2;
			flee = 1;
			money = 50;
			armor = 10;
			
			healthPotionHealAmount = 30;
			healthPotionDropChance = 30;
			
		}
		
		
		GAME:
		while(running) {
			System.out.println("---------------------------------------------");
			
			//how to create multiple arrays for different kind of things
			
	
			int enemyHealth = rand.nextInt(maxEnemyHealth); // maximum enemy health using nextInt
			String enemy = enemies[rand.nextInt(enemies.length)]; //randomly pick enemy
			
			if(!enemy.equals("BERSERKER QUEEN ") || !enemy.equals("NIGHTMARISH CREATURE ") || !enemy.equals("RAGED TWIN BRUTES ") || !enemy.equals("BLOOD-STARVED BEAST ") || !enemy.equals("MIMIC ") || !enemy.equals("SCREAMER ") || !enemy.equals("Brainsucker ") || !enemy.equals("Moonman ")
					|| !enemy.equals("Giant Crawler ") || !enemy.equals("Undead Giant ") || !enemy.equals("Tough Brute ") || !enemy.equals("Scourge Beast ") || !enemy.equals("Juggernaut Ghoul ") || !enemy.equals("Ghoul ") || !enemy.equals("Cursed Teddy Bear ") || !enemy.equals("HELL EXECUTIONNER ") )
				enemyAttackDamage = 30;
			    maxEnemyHealth = 90;
			    
			//enemy scaling
				
			//test enemy scaling
				
			if(score >= 3) {
					System.out.println("##You have defeated more than 3 enemies, enemies are getting stronger!##");
					enemyAttackDamage += 5;
				    maxEnemyHealth += 10;
					
				}
				
			if(score >= 10) {
					System.out.println("##You have defeated more than 10 enemies, enemies are getting stronger!##");
					
					enemyAttackDamage += 50;
				    maxEnemyHealth +=50;
					
				}  
			    
			//enemy variants with some kind of ability, don't forget to modify if statement in line 189
			    
			if(enemy.equals("Cursed Succubus ")) { // no set health or enemyAttackDamage, maybe have something to some kind of input to approach or not (make it a special encounter
				
				int rng =rand.nextInt(3);
				if(rng == 3 ) {flee-=1;System.out.println("Energy sucked! ( -1 flee)");}
				System.out.println("This creatures has the ability to suck energy from you!");
				
				int rng1 = rand.nextInt(2);
				if(rng1 ==2) {attackDamage -=5; System.out.println("Attack damage decreased! (-10)");}
				
				
			}
			
			    
			    
			if(enemy.equals("Moonman ")) { // when defeated gains small atk boost
				
				if(input1.equals("3")) {System.out.println("The Moonman always watches you... Strikes fear into veterans. Max player HP reduced by 10");maxPlayerHP -=10;}
				enemyHealth = 50;
				enemyAttackDamage = 50;
				
				
			}
			    
			if(enemy.equals("Brainsucker ")) { // really tough lifesteal
				System.out.println("This beast has great lifestealing capabilities! It also has 50 % of sucking some energy from you! (-1 flee)");
				int rng = rand.nextInt(2);
				if(rng==1) {flee -= 1; System.out.println("Energy sucked! (-1 flee)");}
				
				enemyHealth = 30;
				enemyAttackDamage = 30;
				
			}
			    
			if(enemy.equals("Cursed Teddy Bear ")) { //  guaranteed weak enemy, guaranteed to drop loot
				enemyHealth = 10;
				enemyAttackDamage = 2;
				
			}    
			    
			if(enemy.equals("Ghoul ")) { // guaranteed weak enemy
				enemyHealth = 10;
				enemyAttackDamage= 10;
				
				
			}   
			    
			if(enemy.equals("Giant Crawler ")) { //just guaranteed to be more tanky
				enemyHealth = 125;
				enemyAttackDamage = 25;
								
			}    
			
			if(enemy.equals("Undead Giant ")) { // just guaranteed to be more tanky
				enemyHealth = 125;
				enemyAttackDamage = 15;
				
				
			}
			
			if(enemy.equals("Tough Brute ")) {// just guaranteed to be more tanky
				enemyHealth = 150;
				enemyAttackDamage = 20;
				
				
			}
			
			if(enemy.equals("Scourge Beast ")) { // dps focused enemy
				System.out.println("This beast has lifestealing capabilities!");
				enemyHealth = 55;
				enemyAttackDamage = 60;
				
			}
			
			
			if(enemy.equals("Juggernaut Ghoul ")) { //dps and tankier focused enemy, probably guaranteed loot drop
				enemyHealth = 130;
				enemyAttackDamage = 45;
				
				
			}
			
			
			
		
			
			//special enemy (mini bosses)
			if(enemy.equals("BERSERKER QUEEN ")) { //gain more hp regenerated per blood injection
				System.out.println("\t@ A SPECIAL ENEMY ENCOUTERED @");
				enemyHealth = 200;
				enemyAttackDamage = 20;
				
				}
			
			if(enemy.equals("NIGHTMARISH CREATURE ")) {// damage reduction for all enemies encountered in the future (-10) +5 max health augment
				enemyHealth = 250;
				enemyAttackDamage = 5; // gains more damage per attack
				
				System.out.println("\t@ SPECIAL ENEMY ENCOUTERED @" );
			}
			
			if(enemy.equals("RAGED TWIN BRUTES ")) { // gain bonus attack damage when defeated ( +70) + 5 max health augment
				enemyAttackDamage = 70;
				enemyHealth = 80;
				
				System.out.println("\t@ SPECIAL ENEMY ENCOUTERED @");
			}
			
			if(enemy.equals("BLOOD-STARVED BEAST ")) { //better odds of enemies dropping blood injections (+7), maybe gain ability to lifesteal (+5) for normal attack?
				
				enemyAttackDamage = 35;
				enemyHealth = 150;
				
				System.out.println("\t@ SPECIAL ENEMY ENCOUTERED @ \n\tThis beast has lifestealing capabilities!" );
			}
			
			
			if(enemy.equals("MIMIC ")) { // gain like +2 ammo, maybe 75 chance of dropping an execute, +20 max health augment
				enemyAttackDamage = attackDamage;
				enemyHealth = health;
				
				System.out.println("\t@ SPECIAL ENEMY ENCOUTERED @ \n\tThis creature copied your stats. ");
				
			}
			
			if(enemy.equals("SCREAMER ")) {// encountering this enemy reduces your attackDamage permenantly + gain 50 health for defeating this enemy + drops 2 muscles paralyzer, +30 max health augment
				enemyHealth = 160;
				enemyAttackDamage = 30;
				attackDamage -= 10;
				
				System.out.println("\t@ SPECIAL ENEMY ENCOUTERED @ This vile and unregonizable creature creates doubt and fear inside you. Attack damage permenantly reduced (-10).");
				
			}
			
			
			if(enemy.equals("HELL EXECUTIONNER ")) { // drops an execute for sure when defeated
				enemyHealth = 300;
				enemyAttackDamage = 130;
				System.out.println("\t@ SPECIAL ENEMY ENCOUTERED @");
				
				
			}
			
			
			
			
			System.out.println("\t# " + enemy + " has appeared! #\n");
			
			while(enemyHealth >0) {
				System.out.print("\tHP: " + health);
				System.out.println("\n\tAttack Damage: " + attackDamage );
				System.out.println("\t||| Blood Injection(s): " + numHealthPots);
				System.out.println("\t||| Mega Blood Injection(s): " + numfullHealthPots);
				System.out.println("\t||| Silver bullet(s): " + ammo);
				System.out.println("\t||| Precision Strikes(s): " + precisionStrike);
				System.out.println("\t||| Muscle Paralyzer(s): " + damageReduction );
				System.out.println("\t||| Execution(s): " + execute);
				System.out.println("\t||| Flee(s): " + flee);
				System.out.println("\t---");
				
				
				
				System.out.print("\t" + enemy + "'s HP: " + enemyHealth);
				System.out.print("\n\t" + enemy + "'s attack damage: " + enemyAttackDamage);
				System.out.print("\t---");
				System.out.print("\n\tWhat would you like to do?");
				System.out.print("\t1. Attack");
				System.out.print("\t2. Use Blood Injection");
				System.out.print("\t3. Use Mega Blood Injection");
				System.out.print("\t4. Use Gun");
				System.out.print("\t5. Use Precision Strike");
				System.out.print("\t6. Use Muscle Paralyzer");
				System.out.print("\t7. Execute");
				System.out.print("\t8. Flee!");
				
				
				
				
				
				
				String input = in.nextLine();
				if(input.equals("1")) {
					int damageDealt = rand.nextInt(attackDamage);
					int damageTaken = rand.nextInt(enemyAttackDamage);
					
					//System.out.println("\n\t***This creature's max attack damage is " + enemyAttackDamage + ".***");
					
				
						
					
					enemyHealth -= damageDealt;
					health -= damageTaken;
					
					System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
					System.out.println("\t> You receive " + damageTaken + " in retatliation!");
					System.out.println("\t-----------");
					if(health < 1) {
						System.out.println("\t> You have taken too much damage, you are too weak to go on...");
						
					}
					
					//gains more attack damage per attack
					
					if(enemy.equals("NIGHTMARISH CREATURE ")) {
						int gainAttack = 5;
						enemyAttackDamage += 5;
						System.out.println("\n\t***The NIGHTMARISH CREATURE enrages and gains " + gainAttack +" attack damage.***");
						System.out.println("");
					}
					
					//lifestealing abilities enemy
					if(enemy.equals("BLOOD-STARVED BEAST ")) {
						int enemyHealing = rand.nextInt(20);
						System.out.println("\n\t***The BLOOD-STARVED BEAST sucks blood out of you! He heals for " + enemyHealing +".***");
						enemyHealth += enemyHealing;
						System.out.println("");
						
						
					}
					
					
					if(enemy.equals("Scourge Beast ")) { // dps focused enemy 
						int enemyHealing = rand.nextInt(15);
						System.out.println("\n\t***The Scourge Beast sucks the life out of you! He heals for " + enemyHealing +".***");
						enemyHealth += enemyHealing;
						System.out.println("");
					}
					
					if(enemy.equals("Brainsucker ")) { // really tough lifesteal
						int enemyHealing = rand.nextInt(30);
						System.out.println("\n\t***The Brainsucker sucks the life out of you! He heals for " + enemyHealing +".***");
						enemyHealth += enemyHealing;
						System.out.println("");
						
					}
					
					
					
		
					
					
				}
				else if (input.equals("2")) {
					if(numHealthPots>0 && health + healthPotionHealAmount < maxPlayerHP) {
						
						health += healthPotionHealAmount;																			
						numHealthPots --;
						System.out.println("\tYou've injected a blood vial, healing yourself for " + healthPotionHealAmount + "!" +"\n\t>You now have " + health + " HP"
								+"\n\t> You have " + numHealthPots + " blood injections left.\n");
								
					} 
					
					else if(numHealthPots>0 && health + healthPotionHealAmount > maxPlayerHP) {
						
						System.out.println("\tYou've injected a blood vial, healing yourself for " +  (maxPlayerHP - health ) + "!" +"\n\t>You now have " + health + " HP"
								+"\n\t> You have " + numHealthPots + " blood injections left.\n");
						System.out.println("!!!You have achieved maximum HP!!!");
						health = maxPlayerHP;
						numHealthPots --;
						
					}
					
					
					
					
					
					else {
						System.out.println("\t>You have no blood injections left, defeat enemies to gain blood injections");
						
					}
					
				}
				
				else if (input.equals("3")) {
					if(numfullHealthPots>0 && health + healthPotionHealAmountMega < maxPlayerHP) {
						health += healthPotionHealAmountMega;
						numfullHealthPots --;
						System.out.println("\tYou've injected a mega blood vial, healing yourself for " + healthPotionHealAmountMega + "!" +"\n\t>You now have " + health + " HP"
								+"\n\t> You have " + numfullHealthPots + " blood injections left.\n");
								
					}
					
	            else if(numHealthPots>0 && health + healthPotionHealAmountMega > maxPlayerHP) {
				 		
						System.out.println("\tYou've injected a blood vial, healing yourself for " +  (maxPlayerHP - health )+ "!" +"\n\t>You now have " + health + " HP"
								+"\n\t> You have " + numHealthPots + " blood injections left.\n");
						System.out.println("!!!You have achieved maximum HP!!!");
						health = maxPlayerHP;
						numfullHealthPots --;
						
					}
					
					
					
					else {
						System.out.println("\t>You have no mega blood injections left.");
						
					}
					
				}
				
				
				else if(input.equals("4")) {
					if(ammo > 0) {
						int damageDealt = rand.nextInt(50);
						enemyHealth -= damageDealt;
						ammo --;
						System.out.println("\t> You shoot the " + enemy + " for " + damageDealt + " damage.");
						System.out.println("\t> You receive 0 in retatliation!");
						System.out.println("\t>You have " + ammo + " silver bullets left.");
					}
					
					
					if(enemy.equals("NIGHTMARISH CREATURE ")) {
						int gainAttack = 5;
						enemyAttackDamage += 5;
						System.out.println("\n\t***The NIGHTMARISH CREATURE enrages and gains " + gainAttack +" attack damage.***");
						System.out.println("");
					}
					
					else {
						System.out.println("\t>You have no silver bullets left, defeat Witch Assasins, Maneater Cultists, Corrupted Huntsmens, Ghouls, Rotted Corpses, Crawlers to gain silver bullets. ");
						
					}
					
				}
				
				else if(input.equals("5")) {
					if(precisionStrike > 0) {
						damageDealtPrecisionStrike = 50;
						int damageTaken = rand.nextInt(enemyAttackDamage);
						enemyHealth -= damageDealtPrecisionStrike;
						precisionStrike --;
						health -= damageTaken;
						System.out.println("\t> You precisely strike the " + enemy + " for " + damageDealtPrecisionStrike + " damage.");
						System.out.println("\t> You receive " + damageTaken + " in retatliation!");
						System.out.println("\t>You have " + precisionStrike + " precision strikes.");
					}
					
					
					if(enemy.equals("NIGHTMARISH CREATURE ")) {
						int gainAttack = 5;
						enemyAttackDamage += 5;
						System.out.println("\n\t***The NIGHTMARISH CREATURE enrages and gains " + gainAttack +" attack damage.***");
						System.out.println("");
					}
					
					if(enemy.equals("BLOOD-STARVED BEAST ")) {
						int ennemyHealing = rand.nextInt(20);
						System.out.println("\n\t***The BLOOD-STARVED BEAST sucks blood out of you! He heals for " + ennemyHealing +".***");
						enemyHealth += ennemyHealing;
						System.out.println("");
												
					}
					
					
					if(enemy.equals("Scourge Beast ")) { // dps focused enemy
						int enemyHealing = rand.nextInt(15);
						System.out.println("\n\t***The Scourge Beast sucks the life out of you! He heals for " + enemyHealing +".***");
						enemyHealth += enemyHealing;
						System.out.println("");
					}
					
					
					if(enemy.equals("Brainsucker ")) { // really tough lifesteal
						int enemyHealing = rand.nextInt(30);
						System.out.println("\n\t***The Brainsucker sucks the life out of you! He heals for " + enemyHealing +".***");
						enemyHealth += enemyHealing;
						System.out.println("");
						
					}
					
					else {
						System.out.println("\t>You have no precision strikes left. ");
						
					}
					
					
				}
				
				
				else if (input.equals("6")) {
					if(damageReduction > 0) {
						int damageDealt = 0;
					    //int damageUpgrade = rand.nextInt(damageDealt);
						damageReductionNumb = 15;
						enemyAttackDamage -= damageReductionNumb;
						damageReduction--;
						System.out.println("\t>You have weakened the attacks of this creature by " + damageReductionNumb + ".");
						System.out.println("\t> You strike the " + enemy + " for " + damageDealt);
						System.out.println("\t> You receive 0 in retatliation!");
						System.out.println("\t-----------");
					}
					
					else if (enemyAttackDamage < damageReductionNumb) {
						enemyAttackDamage =0;
						System.out.println("\t>You have weakened the attacks of this creature by " + damageReductionNumb + ".");
					}
					
					
					else {
						
						System.out.println("\t>You have no muscle paralyzer lefts. ");
					}
					
					
					
				}
				
				
				else if (input.equals("7")) { // probably need to nerf this ability, take some damage when executing like 25, upgrade could be to reduce the damage taken
					if(execute >0 ) {
						enemyHealth -=225;
						health -= 20;
						maxPlayerHP -=10;
						execute --;
						System.out.println("\t>EXECUTED! This move fatigued and has taken a toll on your body. You now have " + health + " HP.");
						System.out.println("Max player HP is now " + maxPlayerHP);
					}
					else {
						
						System.out.println("\t>You have no executes left.");
					}
					
				}
				
				
				
				else if (input.equals("8")) {
					if(flee > 0) {
					System.out.println("\tYou run away from the " + enemy);		
					flee --;
					continue GAME;
					}
					else {
						System.out.println("\t> You have no energy left. You cannot flee anymore. Fight or die.");
						
					}
	
				}
				
				else {
					System.out.println("\tInvalid command! Please press valid inputs. ");
					
					
				}
				
				
			}
			
			if(health <1) {
				System.out.println("You limp out of the quanrantined city, weak from all the battles and the nightmares endured.");
				running = false;
				break;
				
			}
			
			System.out.println("---------------------------------------------");
			

			
			
			
			
			System.out.println(" # " + enemy + " was defeated! # ");
			score++;
			

			
			
			
			
			System.out.println("--You have defeated " + score + "  enemie(s).--");
			System.out.println(" # You have " + health + " HP left. #");
			if(rand.nextInt(100) < healthPotionDropChance) {
				numHealthPots++;
				System.out.println("The " + enemy + "dropped a health potion!");
				System.out.println(" # You now have " + numHealthPots +  " health potion(s). # ");
				
				
			}
			
			if(rand.nextInt(100) < fleeDropChance) { // flee drop chance for all enemies
				flee+=1;
				System.out.println("The " + enemy + "dropped a flee!");
			}
			
			if(rand.nextInt(100) < precisionStrikeDrop ) { // precision strike drop chance for all enemies
				precisionStrike +=1;
				System.out.println(enemy + " dropped a precision strike");
			}
			
			if(rand.nextInt(100) < precisionStrikeDrop) {// damage boost for precision strike  augments as late game
				damageDealtPrecisionStrike+=10;
				System.out.println(">Precision strikes now deals " + damageDealtPrecisionStrike);
			}
			
			
			//Blood Serpent drops 2 health pots
			//10% MEGA BLOOD INJECTION
			if(enemy.equals("Blood Serpent ")) {
				health+=40;
				System.out.println("Defeating this monster healed you for 40 HP." );
				numHealthPots +=2;
				System.out.println("This enemy dropped 2 health pots");
				int toughRng = rand.nextInt(10);
				if(toughRng == 1) {
				numfullHealthPots +=1;
				System.out.println("!!!This creature dropped a MEGA BLOOD INJECTION!!!");
				}
			}

			//Muscle paralyzer drops from Corrupted Huntsmen, Brick Troll, Undead Giant, Crazed Puppeteer, Puppet
			
			if(enemy.equals("Executioner ")) { // 50% drop chance when killing an executioner, 10% MEGA BLOOD INJECTION
				attackDamage +=5;
				System.out.println("!!!You've gained bonus attack damage!!! You may now deal " + attackDamage + " to enemies!" );
				
				if(rand.nextInt(100) < executionsDropChance1 ) {
					execute +=1;
					System.out.println("!!!You've gained an EXECUTION!!!");
					
				}
				
				int toughRng = rand.nextInt(10);
				if(toughRng == 1) {
				numfullHealthPots +=1;
				System.out.println("!!!This creature dropped a MEGA BLOOD INJECTION!!!");
				}
				
			}
			
			if(enemy.equals("Corrupted Huntsmen ") || enemy.equals("Brainsucker ") || enemy.equals("Crazed Puppeteer ") ) { // 25% of dropping an execution, 10% MEGA BLOOD INJECTION
				if(rand.nextInt(100) < executionsDropChance2 ) {
					execute +=1;
					System.out.println("!!!You've gained an EXECUTION!!!");
					
				}
				
			}

			
			
			if(enemy.equals("Witch Assasin ") || enemy.equals("Maneater Cultist ") || enemy.equals("Corrupted Huntsmen ")|| enemy.equals("Ghoul ") || enemy.equals("Rotted Corpses ") || enemy.equals("Crawler ")|| enemy.equals("Cursed Succubus ")) {// silvers bullets drop chance
				if(rand.nextInt(100) < ammoDropChance) {
					ammo+=1;
					
				}
			}
			
			//loot dropped when special enemy is killed
			
			if(enemy.equals("Cursed Teddy Bear ")) { //high chance of dropping silver bullets (1 or 2), precision strikes, for sure one blood injections, low chance of executions
				maxPlayerHP += 10;
				System.out.println("!!!You've gained bonus max HP!!! You now have " + maxPlayerHP + " maximum HP!" );
				numHealthPots +=1;
				precisionStrike +=1;
				System.out.println("The " + enemy + "dropped an extra health potion!");
				System.out.println(" # You now have " + numHealthPots +  " health potion(s). # ");
				
				if(rand.nextInt(100)< ammoDropChance) {
					ammo +=1;
					System.out.println("The " + enemy + "dropped 1 silver bullet!");
				}
				
				if(rand.nextInt(100) < muscleParalyzerDrop){
					damageReduction +=1;
					
					
				}
				
				if(rand.nextInt(100) < executionsDropChance3 ) { // 10% chance
					execute +=1;
					System.out.println("!!!You've gained an EXECUTION!!!");
				}
		
			} 
			
			
	        if(enemy.equals("Moonman ")) { // when defeated gains small atk boost
				attackDamage += 15;
				System.out.println("!!!You've gained bonus attack damage!!! You may now deal " + attackDamage + " to enemies!" );
				ammo +=1;
				System.out.println("The " + enemy + "dropped 1 silver bullet!");
				
			}
	        
	        
	    	if(enemy.equals("BERSERKER QUEEN ")) { //gain more hp regenerated per blood injection
	    		maxPlayerHP+=10;
	    		System.out.println("!!!You've gained bonus max HP!!! You now have " + maxPlayerHP + " maximum HP!" );
	    		healthRegen +=5;
				System.out.println("Gained 5 HP regen when resting by the bonfire!");
	    		health+=30;
	    		System.out.println("Defeating this monster healed you for 30 HP." );
	    		healthPotionHealAmount +=15;
	    		System.out.println("Defeating this enemy gave you a boost in hp regenrated per blood injection. You now heal for " + healthPotionHealAmount +" per injections.");
				
				}
	    	
	    	if(enemy.equals("NIGHTMARISH CREATURE ")) {// damage reduction for all enemies encountered in the future (-10) +5 max health augment
				maxPlayerHP+=5;
				System.out.println("!!!You've gained bonus max HP!!! You now have " + maxPlayerHP + " maximum HP!" );
				enemyAttackDamage -= 10; // gains more damage per attack
				System.out.println("Defeating this enemy caused all further enemies to have a damage reduction of -10");
				
				int toughRng = rand.nextInt(10);
				if(toughRng == 1) {
				numfullHealthPots +=1;
				System.out.println("!!!This creature dropped a MEGA BLOOD INJECTION!!!");
				}
				
			}
			
			if(enemy.equals("RAGED TWIN BRUTES ")) { // when defeating Raged Twin Brutes
				attackDamage += 60;
				System.out.println("!!!You've gained bonus attack damage!!! You may now deal " + attackDamage + " to enemies!" );
				numHealthPots += 1;
				System.out.println("The " + enemy + "dropped an extra health potion!");
				System.out.println(" # You now have " + numHealthPots +  " health potion(s). # ");
				 }
			
			
	        if(enemy.equals("BLOOD-STARVED BEAST ")) { //better odds of enemies dropping blood injections (+7), maybe gain ability to lifesteal (+5) for normal attack?
	        	maxPlayerHP +=10;
	        	System.out.println("!!!You've gained bonus max HP!!! You now have " + maxPlayerHP + " maximum HP!" );
	        	healthPotionDropChance +=7;
	        	System.out.println("Defeating this enemy gave you better odds of enemies dropping blood injections " + healthPotionDropChance + "%.");
	        	attackDamage +=10;
	        	System.out.println("Attack damage increased by 10" );
			}
	        
	    	if(enemy.equals("MIMIC ")) { // gain like +2 ammo,  +20 max health augment
	    		maxPlayerHP += 20;
	    		System.out.println("!!!You've gained bonus max HP!!! You now have " + maxPlayerHP + " maximum HP!" );
	    		ammo +=2;
	    		System.out.println("The " + enemy + "dropped 2 silver bullet!");
	    		attackDamage +=10;
	        	System.out.println("Attack damage increased by 10" );
	        	damageReduction +=2;
	        	System.out.println("This enemy dropped 2 muscles paralyzers");
			
				
				
				
			}
	        
	        
	    	if(enemy.equals("SCREAMER ")) {// encountering this enemy reduces your attackDamage permenantly + gain 50 health for defeating this enemy + drops 2 muscles paralyzer, +30 max health augment
				maxPlayerHP += 30;
				System.out.println("!!!You've gained bonus max HP!!! You now have " + maxPlayerHP + " maximum HP!" );
				health += 50;
				System.out.println("Defeating this monster healed you for 50 HP." );
				damageReduction +=2;
				System.out.println("Dropped 2 muscles paralyzers!");
			}
			
			
			
			if(enemy.equals("HELL EXECUTIONNER ")) {
				
				maxPlayerHP+=10;
				System.out.println("!!!You've gained bonus max HP!!! You now have " + maxPlayerHP + " maximum HP!" );
				health +=30;
				System.out.println("Defeating this monster healed you for 30 HP." );
				healthRegen +=5;
				System.out.println("Gained 5 HP regen when resting by the bonfire!");
				attackDamage +=5;
				System.out.println("Attack damage increased." + attackDamage );
				execute +=1;
				System.out.println("!!!You've gained an EXECUTION!!!");
				
				
				
			}
			
			System.out.println("---------------------------------------------");
			System.out.println("What would you like to do now?");
			System.out.println("1.Rest by the bonfire and continue hunting");
			System.out.println("2.Visit shopkeeper");
			System.out.println("3.Exit city");
			
			
			String input = in.nextLine();
			
		
			while(!input.equals("1") && !input.equals("2") && !input.equals("3")) {
				System.out.println("Invalid command!");
				input = in.nextLine();
				
			}
			
			if(input.equals("1")) {
				 // need to be unlocked
				health += healthRegen;
				
				System.out.println("You rest and continue on your hunting...");
				System.out.println(">You have regained " + healthRegen + " HP.");
				
				System.out.println(">Chance of dropping blood vials: " + healthPotionDropChance + "%");
				System.out.println(">Chance of dropping ammo: " + ammoDropChance + "%");
				System.out.println(">Chance of dropping muscle paralyzer: " + muscleParalyzerDrop + "%");
				System.out.println(">Chance of flees: " + fleeDropChance + "%");
			}
			

			
			else if (input.equals("2")) {// shopkeeper
				
				System.out.println("Visiting shopkeeper");// energy drink and food, upgrades for all abilities all rng
				
			}
			else if(input.equals("3")) {
				System.out.println("You exit the cursed city, succesful from all the fighting you did. You defeated " + score + " enemies.");
				break;
				
				
			}
			
		}
		
		System.out.println("#################");
		System.out.println("Thanks for playing!");
		System.out.println("#################");
	}
	
	
	public Main() {
		
		
		window = new JFrame();
		window.setSize(800, 600);
		
		//window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
	
		con = window.getContentPane();
	
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		
		
		titleNameLabel = new JLabel("GAME INFO");
		titleNameLabel.setForeground(Color.white); // color of the text
		titleNameLabel.setFont(titleFont);
		
		
		characterPanel = new JPanel();
		characterPanel.setBounds(300, 230, 200, 50);
		characterPanel.setBackground(Color.black);
		
		characterButton = new JButton("CHARACTERS");
		characterButton.setBackground(Color.black);
		characterButton.setForeground(Color.white);
		characterButton.setFont(characterFont);
		
		characterButton.addActionListener(tsHandler);

		enemyPanel = new JPanel();
		enemyPanel.setBounds(300, 300, 200, 50);
		enemyPanel.setBackground(Color.black);
				
		enemyButton = new JButton("ENEMIES");
		enemyButton.setBackground(Color.black);
		enemyButton.setForeground(Color.white);
		enemyButton.setFont(characterFont);
		enemyButton.addActionListener(tsHandler2);
		
		
		abilityPanel = new JPanel();
		abilityPanel.setBounds(300, 370, 200, 50);
		abilityPanel.setBackground(Color.black);
		
		abilityButton = new JButton("ABILITIES");
		abilityButton.setBackground(Color.black);
		abilityButton.setForeground(Color.white);
		abilityButton.setFont(characterFont);
		abilityButton.addActionListener(tsHandler3);
		
		titleNamePanel.add(titleNameLabel);
		characterPanel.add(characterButton);
		enemyPanel.add(enemyButton);
		abilityPanel.add(abilityButton);

		con.add(titleNamePanel);
		con.add(characterPanel);
		con.add(enemyPanel);
		con.add(abilityPanel);
		
	}
	

	public void textHunter() {
	
		
		
		textCharacter.setVisible(false);
		textCharacter = new JPanel();
		textCharacter.setBounds(100, 100, 600, 250);
		textCharacter.setBackground(Color.black);
		con.add(textCharacter);

		textCharacterArea = new JTextArea("1.Professional Hunter \n Max HP : 200\n Health Regen. : 5\n Base Atk Dmg : 60 \n Starting Blood Injections : 5 \n Starting Mega Blood Injections : 1 \n Execute : 1 \n Ammo : 0 \n Muscle Paralyzer : 1 \n Precision Strike = 3 \n Flee : 3");
		textCharacterArea.setBounds(100,100,600, 600);
		textCharacterArea.setBackground(Color.black);
		textCharacterArea.setForeground(Color.white);		
		textCharacterArea.setFont(characterFont);
		textCharacterArea.setLineWrap(true);		
		textCharacter.add(textCharacterArea);
		
	}
	
	public void textMarksmen() {
		textCharacter.setVisible(false);
		
		textCharacter = new JPanel();
		textCharacter.setBounds(100, 100, 600, 250);
		textCharacter.setBackground(Color.black);
		con.add(textCharacter);

		textCharacterArea1 = new JTextArea("1.Marksmen \n Max HP : 130\n Health Regen. : 0\n Base Atk Dmg : 40 \n Starting Blood Injections : 3 \n Starting Mega Blood Injections : 0 \n Execute : 0 \n Ammo : 4 \n Muscle Paralyzer : 2 \n Precision Strike = 0 \n Flee : 5");
		textCharacterArea1.setBounds(100,100,600, 600);
		textCharacterArea1.setBackground(Color.black);
		textCharacterArea1.setForeground(Color.white);		
		textCharacterArea1.setFont(characterFont);
		textCharacterArea1.setLineWrap(true);		
		textCharacter.add(textCharacterArea1);
		
		
		
		
	}
	
	public void textVeteran() {
		textCharacter.setVisible(false);
		
		textCharacter = new JPanel();
		textCharacter.setBounds(100, 100, 600, 250);
		textCharacter.setBackground(Color.black);
		con.add(textCharacter);

		textCharacterArea2 = new JTextArea("1.Military Veteran \n Max HP : 150\n Health Regen. : 1\n Base Atk Dmg : 50 \n Starting Blood Injections : 3 \n Starting Mega Blood Injections : 0 \n Execute : 2 \n Ammo : 1 \n Muscle Paralyzer : 1 \n Precision Strike = 0 \n Flee : 2");
		textCharacterArea2.setBounds(100,100,600, 600);
		textCharacterArea2.setBackground(Color.black);
		textCharacterArea2.setForeground(Color.white);		
		textCharacterArea2.setFont(characterFont);
		textCharacterArea2.setLineWrap(true);		
		textCharacter.add(textCharacterArea2);
		
	}
	
	
	public void textAmateur() {
		textCharacter.setVisible(false);
		
		textCharacter = new JPanel();
		textCharacter.setBounds(100, 100, 600, 250);
		textCharacter.setBackground(Color.black);
		con.add(textCharacter);

		textCharacterArea3 = new JTextArea("1.Amateur Hunter \n Max HP : 100\n Health Regen. :1 1\n Base Atk Dmg : 45 \n Starting Blood Injections : 2 \n Starting Mega Blood Injections : 1 \n Execute : 0 \n Ammo : 1 \n Muscle Paralyzer : 0 \n Precision Strike = 2 \n Flee : 1");
		textCharacterArea3.setBounds(100,100,600, 600);
		textCharacterArea3.setBackground(Color.black);
		textCharacterArea3.setForeground(Color.white);		
		textCharacterArea3.setFont(characterFont);
		textCharacterArea3.setLineWrap(true);		
		textCharacter.add(textCharacterArea3);
	}
	
	
	
	public void textForCharacter() {
		
		//need to create 
		
		//disable 
		titleNamePanel.setVisible(false);
		characterPanel.setVisible(false);
		enemyPanel.setVisible(false);
		abilityPanel.setVisible(false);

		textCharacter = new JPanel();
		textCharacter.setBounds(250, 100, 300, 300);
		textCharacter.setBackground(Color.red);
				
		textButton = new JButton("Professional Hunter");
		textButton .setBackground(Color.black);
		textButton .setForeground(Color.white);
		textButton .setFont(characterFont);
		textButton .addActionListener(tsHandler4);
		
		textCharacter.add(textButton);
		
		textButton2 = new JButton("Marksmen");
		textButton2 .setBackground(Color.black);
		textButton2 .setForeground(Color.white);
		textButton2 .setFont(characterFont);
		textButton2 .addActionListener(tsHandler5);
		
		textCharacter.add(textButton2);
		
		
		textButton3 = new JButton("Military Veteran");
		textButton3 .setBackground(Color.black);
		textButton3 .setForeground(Color.white);
		textButton3 .setFont(characterFont);
		textButton3 .addActionListener(tsHandler6);
		
		textCharacter.add(textButton3);
		
		
		textButton4 = new JButton("Amateur Hunter");
		textButton4 .setBackground(Color.black);
		textButton4 .setForeground(Color.white);
		textButton4 .setFont(characterFont);
		textButton4 .addActionListener(tsHandler7);
		
		textCharacter.add(textButton4);
		
		textCharacter.setLayout(new GridLayout(4,1));
		con.add(textCharacter);
		back = new JPanel();
		back.setBounds(250,500,300,150);
		back.setBackground(Color.black);
		
		con.add(back);
		
		backButton = new JButton("BACK");
		backButton.setBackground(Color.black);
		backButton.setForeground(Color.white);
		backButton.setFont(characterFont);
		back.add(backButton);
		backButton.addActionListener(tsHandler1);
		
		
	}
	
	
	public void textForEnemies() {
		
		titleNamePanel.setVisible(false);
		characterPanel.setVisible(false);
		enemyPanel.setVisible(false);
		abilityPanel.setVisible(false);
		
		
		
		
		titleNameEnemy = new JPanel();
		titleNameEnemy.setBounds(100, 100, 600, 150);
		titleNameEnemy.setBackground(Color.black);
		
		
		/*titleNameEnemyLabel = new JLabel("ENEMY INFO");
		titleNameEnemyLabel.setForeground(Color.white); // color of the text
		titleNameEnemyLabel.setFont(smallerTitleFont);*/
		
		/*titleNameEnemy.add(titleNameEnemyLabel);
		con.add(titleNameEnemy);*/
		
		
		
		textCharacter = new JPanel();
		textCharacter.setBounds(100, 200, 600, 250);
		textCharacter.setBackground(Color.black);
		con.add(textCharacter);

		
		
		textCharacterArea3 = new JTextArea("The city has a large number of enemies and variants (30+). #Special enemies possess have unique characterestics such lifestealing capabilities and fear-inducing attacks, they also drop rare loot when defeated.# Enemies scale as more enemies are killed. "  );
		textCharacterArea3.setBounds(100,200,500, 500);
		textCharacterArea3.setBackground(Color.black);
		textCharacterArea3.setForeground(Color.white);		
		textCharacterArea3.setFont(smallerCharacterFont);
		textCharacterArea3.setLineWrap(true);		
		textCharacter.add(textCharacterArea3);
		
		back = new JPanel();
		back.setBounds(250,500,300,150);
		back.setBackground(Color.black);
		
		con.add(back);
		
		backButton = new JButton("BACK");
		backButton.setBackground(Color.black);
		backButton.setForeground(Color.white);
		backButton.setFont(characterFont);
		back.add(backButton);
		backButton.addActionListener(tsHandler1);
	}
	
	
	public void textForAbilities() {
		
		titleNamePanel.setVisible(false);
		characterPanel.setVisible(false);
		enemyPanel.setVisible(false);
		abilityPanel.setVisible(false);
		
		/*titleNameEnemy = new JPanel();
		titleNameEnemy.setBounds(100, 100, 600, 150);
		titleNameEnemy.setBackground(Color.black);
		
		
		titleNameEnemyLabel = new JLabel("ABILITIES INFO");
		titleNameEnemyLabel.setForeground(Color.white); // color of the text
		titleNameEnemyLabel.setFont(smallerTitleFont);
		
		titleNameEnemy.add(titleNameEnemyLabel);
		con.add(titleNameEnemy);*/
		
		
		
		textCharacter = new JPanel();
		textCharacter.setBounds(100, 200, 600, 250);
		textCharacter.setBackground(Color.black);
		con.add(textCharacter);

		
		
		textCharacterArea3 = new JTextArea("1. Attack - Attack the Enemy and Receive Retaliation \n2. Use Blood Injection - Heals Player's HP \n3. Use Mega Blood Injections - Heals Player's HP for a significant amount \n4. Use Gun - Attack Enemy Without Receiving Retaliation \n5. Use Precision Strike - Attack the Enemy for a Precise Amount of Damage, receive retaliation \n6. Muscle Paralyzer - Reduce Maximum Damage of an Enemy \n7. Execute - Deal a Significant Amount of Damage to an Enemy, receive no Retaliation \n 8. Flee - Go to the Next Enemy."  );
		textCharacterArea3.setBounds(100,200,500, 500);
		textCharacterArea3.setBackground(Color.black);
		textCharacterArea3.setForeground(Color.white);		
		textCharacterArea3.setFont(smallerCharacterFont2);
		textCharacterArea3.setLineWrap(true);		
		textCharacter.add(textCharacterArea3);
		
		back = new JPanel();
		back.setBounds(250,500,300,150);
		back.setBackground(Color.black);
		
		con.add(back);
		
		backButton = new JButton("BACK");
		backButton.setBackground(Color.black);
		backButton.setForeground(Color.white);
		backButton.setFont(characterFont);
		back.add(backButton);
		backButton.addActionListener(tsHandler1);
		
		
		
	}
	
	

// need to also implement a back button that goes back to the initial gamescreen	
	
	public class Handler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			textForCharacter();
			
			
		}
		
		
		
	}
	
	
    public class Handler2 implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			textForEnemies();
			
			
		}
		
		
		
	}
    
	public class Handler3 implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			textForAbilities();
			
			
		}
		
		
		
	}
	
public class Handler4 implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			textHunter();
			
			
		}
		
		
		
		
		
	}
	
	
public class Handler5 implements ActionListener {
	
	public void actionPerformed(ActionEvent event) {
		
		textMarksmen();
		
		
	}
	
	
	
	
	
}
public class Handler6 implements ActionListener {
	
	public void actionPerformed(ActionEvent event) {
		
		textVeteran();
		
		
	}
	
	
	
	
	
}
	
	
public class Handler7 implements ActionListener {
	
	public void actionPerformed(ActionEvent event) {
		
		textAmateur();
		
		
	}
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	public class Handler1 implements ActionListener { // for the back button
		
		public void actionPerformed(ActionEvent event) {
			
			
			titleNamePanel.setVisible(true);
			characterPanel.setVisible(true);
			enemyPanel.setVisible(true);
			abilityPanel.setVisible(true);
			back.setVisible(false);
			textCharacter.setVisible(false);
			
			
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
