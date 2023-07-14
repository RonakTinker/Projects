//Enhancements - 

//1.  Umpire will take the range of numbers from user. Guesser as well as the players 
//	  must guess the numbers within that range only.Umpire has some Strict rules here-->

				// Minimum 4 numbers has to be there to play the game
				
				// Range in reverse is not allowed that means end of range 
				// must be greater than the start of range.

				// Negative numbers are not allowed. only the numbers 
				// greater than 0 are allowed. 0 is also not allowed.

//2.  Umpire will give the user three different multiplayer options. User can choose to play with 
//    3 players or 4 players or 5 players.

//3.  User can give his own names to the different players. 

//4.  There are multiple rounds in the game. game will go on until any one player wins. if 
//    more than one players guess the right number then again a round of game will happen only 
//    between the players who guessed the number right and this process will continue until any 
//    one of them wins.

//5.  At the end ,after declaring the final winner, umpire will ask the user whether he wants
//	  to play the game again or not. If he wants he can play again and if not the game will
//	  end for him with a good note.


package in.ineuron.main;
import java.util.*;

//Guesser will guess the number and give that number to umpire
class Guesser
{
	int guesserNo;
	int guess()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Guesser guess the Number:");
		guesserNo=scan.nextInt();
		return guesserNo;
	}		
}

//Players will guess the number and give that to umpire
class Player
{
	int playerNo;
	int guess()
	{
		Scanner scan=new Scanner(System.in);
		playerNo=scan.nextInt();
		return playerNo;
	}
}

//Players name will be taken from user and given to the umpire
class PlayerName
{
	String playerName()
	{
		Scanner scan=new Scanner(System.in);
		String playerName=scan.next();
		return playerName;
	}
}
	
//Umpire will do his activities here
class Umpire
{
	int guesserNo;
	int player1No;
	int player2No;
	int player3No;
	int player4No;
	int player5No;
	int startOfRange;
	int endOfRange;
	int noOfPlayers;
	String pName1;
	String pName2;
	String pName3;
	String pName4;
	String pName5;
	
//	Umpire will take and store player 1 name
	void name1()
	{
		PlayerName name1=new PlayerName();
		System.out.println("Tell the player 1 name");
		pName1=name1.playerName();
	}
	
//	Umpire will take and store player 2 name
	void name2()
	{
		PlayerName name2=new PlayerName();
		System.out.println("Tell the player 2 name");
		pName2=name2.playerName();	
	}
	
//	Umpire will take and store player 3 name
	void name3()
	{
		PlayerName name3=new PlayerName();
		System.out.println("Tell the player 3 name");
		pName3=name3.playerName();	
	}
	
//	Umpire will take and store player 4 name
	void name4()
	{
		PlayerName name4=new PlayerName();
		System.out.println("Tell the player 4 name");
		pName4=name4.playerName();
	}
	
//	Umpire will take and store player 5 name
	void name5()
	{
		PlayerName name5=new PlayerName();
		System.out.println("Tell the player 5 name");
		pName5=name5.playerName();	
	}
	
//	Umpire will take the no of players from user. He will check it then store it
//	Umpire will provide 3 playing options
	int noOfPlayers() 
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("With how many players you want to play the game : 3/4/5");
	    int temp=scan.nextInt();
	    
	    if(temp==3 || temp==4 || temp==5)
	    {
	    	 noOfPlayers=temp;
	    }
	    else
	    {
	    	System.out.println("Tell your answer as 3 or 4 or 5 only");
	    	noOfPlayers();
	    }
	   return noOfPlayers;
	}
	
	
//	Umpire will take Range of numbers user wants to play with. 
//	Here umpire will take starting number of the range.
//	Umpire will only allow the numbers Greater than zero(not equal to 0)
//	Negative numbers are not allowed to be guessed
	void startOfRange()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Hey Gammer,Tell the Starting of range :");
		int temp=scan.nextInt();
		
		if (temp>0)
		{
			startOfRange=temp;
		}
		else
		{
			System.out.println("Tell a positive number only between 1 to infinite ...");
			startOfRange();
		}
	}
	
//	Umpire will take the number for end of the range from user. and check for the 
//	suitable conditions.
	void endOfRange()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Please tell the Ending of range");
		int temp=scan.nextInt();
		
		if (temp>startOfRange+2)
		{
			endOfRange=temp;
		}
		else 
		{
			System.out.println("End of Range should be greater than Starting of the Range and minimum 4 numbers should be there to play with ");
			startOfRange();
			endOfRange();
		}
	}
	
//	Umpire will take the number from guesser and check whether the number is within 
//	the range or not.
	void guesserNo()
	{
		Guesser guesser=new Guesser();
		int temp=guesser.guess();
		
		if(temp>=startOfRange && temp<=endOfRange)
		{
			guesserNo=temp;
		}
		else
		{
			System.out.println("Please enter a number in the range "+ startOfRange +" and "+endOfRange);
			guesserNo();
		}
	}
	
//	Umpire will take the number from player1 and check whether the number is within 
//	the range or not.
	void player1No()
	{
		Player player1=new Player();
		System.out.println(pName1+" guess the Number");
		int temp=player1.guess();
		
		if(temp>=startOfRange && temp<=endOfRange)
		{
			player1No=temp;
		}
		else
		{
			System.out.println("Please enter a number in the range "+ startOfRange +" and "+endOfRange);
			player1No();
		}
	}
	
//	Umpire will take the number from player2 and check whether the number is within 
//	the range or not.
	void player2No()
	{
		Player player2=new Player();
		System.out.println(pName2+" guess the Number");
		int temp=player2.guess();
		
		if(temp>=startOfRange && temp<=endOfRange)
		{
			player2No=temp;
		}
		else
		{
			System.out.println("Please enter a number in the range "+ startOfRange +" and "+endOfRange);
			player2No();
		}
	}
	
//	Umpire will take the number from player3 and check whether the number is within 
//	the range or not.
	void player3No()
	{
		Player player3=new Player();
		System.out.println(pName3+" guess the Number");
		int temp=player3.guess();
		
		if(temp>=startOfRange && temp<=endOfRange)
		{
			player3No=temp;
		}
		else
		{
			System.out.println("Please enter a number in the range "+ startOfRange +" and "+endOfRange);
			player3No();
		}
	}
	
//	Umpire will take the number from player4 and check whether the number is within 
//	the range or not.
	void player4No()
	{
		Player player4=new Player();
		System.out.println(pName4+" guess the Number");
		int temp=player4.guess();
		
		if(temp>=startOfRange && temp<=endOfRange)
		{
			player4No=temp;
		}
		else
		{
			System.out.println("Please enter a number in the range "+ startOfRange +" and "+endOfRange);
			player4No();
		}
	}
	
//	Umpire will take the number from player5 and check whether the number is within 
//	the range or not.
	void player5No()
	{
		Player player5=new Player();
		System.out.println(pName5+" guess the Number");
		int temp=player5.guess();
		
		if(temp>=startOfRange && temp<=endOfRange)
		{
			player5No=temp;
		}
		else
		{
			System.out.println("Please enter a number in the range "+ startOfRange +" and "+endOfRange);
			player5No();
		}
	}
	
//	Umpire will check who told the same number as the guesser number.
//	The Game will go on until any one player wins.
//	The moment umpire gets only one player correct he will declare him as winner.
	void check2()
	{
		if(player1No==guesserNo)
		{
			if (player2No==guesserNo && player3No==guesserNo && player4No==guesserNo && player5No==guesserNo)
			{
				System.out.println("Game is tie between all the players");
				System.out.println("");
				System.out.println("Lets play the next round ...");
				guesserNo();
				player1No();
				player2No();
				player3No();
				player4No();
				player5No();
				check2();
			}
			
			else if(player2No!=player1No)
			{
				if (player3No==guesserNo && player4No==guesserNo && player5No==guesserNo)
				{
					System.out.println("Game is tie between " +pName1+" "+pName3+" "+pName4+" "+pName5);
					System.out.println("");
					System.out.println("Lets play the next round ...");
					guesserNo();
					player1No();
					player3No();
					player4No();
					player5No();
					player2No=0;
					check2();
				}
				
				else if(player3No!=player1No)
				{
					if(player4No==guesserNo && player5No==guesserNo)
					{
						System.out.println("Game is tie between " +pName1+" "+pName4+" "+pName5);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player4No();
						player5No();
						player2No=0;
						player3No=0;
						
						check2();
						
					}
					else if(player4No==guesserNo)
					{
						System.out.println("game is tie between "+pName1+" "+pName4);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player4No();
						player2No=0;
						player3No=0;
						player5No=0;
						check2();
					}
					else if(player5No==guesserNo)
					{
						System.out.println("Game is tie between "+pName1+" "+pName5);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player5No();
						player2No=0;
						player3No=0;
						player4No=0;
						check2();
					}
					else
					{
						System.out.println(pName1+" "+" wins");
					}
				}
				
				else if(player4No!=player1No)
				{
					if(player3No==guesserNo && player5No==guesserNo)
					{
						System.out.println("Game is tie between "+pName1+" "+pName3+" "+pName5);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player3No();
						player5No();
						player2No=0;
						player4No=0;
						check2();
					}
					else if(player3No==guesserNo)
					{
						System.out.println("game is tie between "+pName1+" "+pName3);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player3No();
						player2No=0;
						player4No=0;
						player5No=0;
						check2();
					}
					else if(player5No==guesserNo)
					{
						System.out.println("Game is tie between "+pName1+" "+pName5);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player5No();
						player2No=0;
						player3No=0;
						player4No=0;
						check2();
					}
					else
					{
						System.out.println(pName1+" "+" wins");
					}
				}
				
				else if(player5No!=player1No)
				{
					if(player3No==guesserNo && player4No==guesserNo)
					{
						System.out.println("Game is tie between "+pName1+" "+pName3+" "+pName4);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player3No();
						player4No();
						player2No=0;
						player5No=0;
						check2();
					}
					else if(player3No==guesserNo)
					{
						System.out.println("game is tie between "+pName1+" "+pName3);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player3No();
						player2No=0;
						player4No=0;
						player5No=0;
						check2();
					}
					else if(player4No==guesserNo)
					{
						System.out.println("Game is tie between "+pName1+" "+pName4);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player4No();
						player2No=0;
						player3No=0;
						player5No=0;
						check2();
					}
					else
					{
						System.out.println(pName1+" "+" wins");
					}
				}	
			}
			
			else if(player3No!=player1No)
			{
				if (player2No==guesserNo && player4No==guesserNo && player5No==guesserNo)
				{
					System.out.println("Game is tie between "+pName1+" "+pName2+" "+pName4+" "+pName5);
					System.out.println("");
					System.out.println("Lets play the next round ...");
					guesserNo();
					player1No();
					player2No();
					player4No();
					player5No();
					player3No=0;
					check2();
				}
				
				else if(player2No!=player1No)
				{
					if(player4No==guesserNo && player5No==guesserNo)
					{
						System.out.println("Game is tie between "+pName1+" "+pName4+" "+pName5);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player4No();
						player5No();
						player2No=0;
						player3No=0;
						check2();
					}
					else if(player4No==guesserNo)
					{
						System.out.println("game is tie between "+pName1+" "+pName4);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player4No();
						player2No=0;
						player3No=0;
						player5No=0;
						check2();
					}
					else if(player5No==guesserNo)
					{
						System.out.println("Game is tie between "+pName1+" "+pName5);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player5No();
						player2No=0;
						player3No=0;
						player4No=0;
						check2();
					}
					else
					{
						System.out.println(pName1+" "+" wins");
					}
				}
				
				else if(player4No!=player1No)
				{
					if(player2No==guesserNo && player5No==guesserNo)
					{
						System.out.println("Game is tie between "+pName1+" "+pName2+" "+pName5);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player2No();
						player5No();
						player3No=0;
						player4No=0;
						check2();
					}
					else if(player2No==guesserNo)
					{
						System.out.println("game is tie between "+pName1+" "+pName2);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player2No();
						player3No=0;
						player4No=0;
						player5No=0;
						check2();
					}
					else if(player5No==guesserNo)
					{
						System.out.println("Game is tie between "+pName1+" "+pName5);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player5No();
						player2No=0;
						player3No=0;
						player4No=0;
						check2();
					}
					else
					{
						System.out.println(pName1+" "+" wins");
					}
				}
				
				else if(player5No!=player1No)
				{
					if(player2No==guesserNo && player4No==guesserNo)
					{
						System.out.println("Game is tie between "+pName1+" "+pName2+" "+pName4);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player2No();
						player4No();
						player3No=0;
						player5No=0;
						check2();
					}
					else if(player2No==guesserNo)
					{
						System.out.println("game is tie between "+pName1+" "+pName2);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player2No();
						player3No=0;
						player4No=0;
						player5No=0;
						check2();
					}
					else if(player4No==guesserNo)
					{
						System.out.println("Game is tie between "+pName1+" "+pName4);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player4No();
						player2No=0;
						player3No=0;
						player5No=0;
						check2();
					}
					else
					{
						System.out.println(pName1+" "+" wins");
					}
				}	
			}
			
			else if(player4No!=player1No)
			{
				if (player2No==guesserNo && player3No==guesserNo && player5No==guesserNo)
				{
					System.out.println("Game is tie between "+pName1+" "+pName2+" "+pName3+" "+pName5);
					System.out.println("");
					System.out.println("Lets play the next round ...");
					guesserNo();
					player1No();
					player2No();
					player3No();
					player5No();
					player4No=0;
					check2();
				}
				
				else if(player2No!=player1No)
				{
					if(player3No==guesserNo && player5No==guesserNo)
					{
						System.out.println("Game is tie between "+pName1+" "+pName3+" "+pName5);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player3No();
						player5No();
						player2No=0;
						player4No=0;
						check2();
					}
					else if(player3No==guesserNo)
					{
						System.out.println("game is tie between "+pName1+" "+pName3);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player3No();
						player2No=0;
						player4No=0;
						player5No=0;
						check2();
					}
					else if(player5No==guesserNo)
					{
						System.out.println("Game is tie between "+pName1+" "+pName5);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player5No();
						player2No=0;
						player3No=0;
						player4No=0;
						check2();
					}
					else
					{
						System.out.println(pName1+" "+" wins");
					}
				}
				
				else if(player3No!=player1No)
				{
					if(player2No==guesserNo && player5No==guesserNo)
					{
						System.out.println("Game is tie between "+pName1+" "+pName2+" "+pName5);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player2No();
						player5No();
						player3No=0;
						player4No=0;
						check2();
					}
					else if(player2No==guesserNo)
					{
						System.out.println("game is tie between "+pName1+" "+pName2);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player2No();
						player3No=0;
						player4No=0;
						player5No=0;
						check2();
					}
					else if(player5No==guesserNo)
					{
						System.out.println("Game is tie between "+pName1+" "+pName5);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player5No();
						player2No=0;
						player3No=0;
						player4No=0;
						check2();
					}
					else
					{
						System.out.println(pName1+" "+" wins");
					}
				}
				
				else if(player5No!=player1No)
				{
					if(player2No==guesserNo && player3No==guesserNo)
					{
						System.out.println("Game is tie between "+pName1+" "+pName2+" "+pName3);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player2No();
						player3No();
						player4No=0;
						player5No=0;
						check2();
					}
					else if(player2No==guesserNo)
					{
						System.out.println("game is tie between "+pName1+" "+pName2);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player2No();
						player3No=0;
						player4No=0;
						player5No=0;
						check2();
					}
					else if(player3No==guesserNo)
					{
						System.out.println("Game is tie between "+pName1+" "+pName3);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player3No();
						player2No=0;
						player4No=0;
						player5No=0;
						check2();
					}
					else
					{
						System.out.println(pName1+" "+" wins");
					}
				}
			}
			
			
			else if(player5No!=player1No)
			{
				if (player2No==guesserNo && player3No==guesserNo && player4No==guesserNo)
				{
					System.out.println("Game is tie between "+pName1+" "+pName2+" "+pName3+" "+pName4);
					System.out.println("");
					System.out.println("Lets play the next round ...");
					guesserNo();
					player1No();
					player2No();
					player3No();
					player4No();
					player5No=0;
					check2();
				}
				
				else if(player2No!=player1No)
				{
					if(player3No==guesserNo && player4No==guesserNo)
					{
						System.out.println("Game is tie between "+pName1+" "+pName3+" "+pName4);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player3No();
						player4No();
						player2No=0;
						player5No=0;
						check2();
					}
					else if(player3No==guesserNo)
					{
						System.out.println("game is tie between "+pName1+" "+pName3);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player3No();
						player2No=0;
						player4No=0;
						player5No=0;
						check2();
					}
					else if(player4No==guesserNo)
					{
						System.out.println("Game is tie between "+pName1+" "+pName4);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player4No();
						player2No=0;
						player3No=0;
						player5No=0;
						check2();
					}
					else
					{
						System.out.println(pName1+" "+" wins");
					}
				}
				
				else if(player3No!=player1No)
				{
					if(player2No==guesserNo && player4No==guesserNo)
					{
						System.out.println("Game is tie between "+pName1+" "+pName2+" "+pName4);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player2No();
						player4No();
						player3No=0;
						player5No=0;
						check2();
					}
					else if(player2No==guesserNo)
					{
						System.out.println("game is tie between "+pName1+" "+pName2);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player2No();
						player3No=0;
						player4No=0;
						player5No=0;
						check2();
					}
					else if(player4No==guesserNo)
					{
						System.out.println("Game is tie between "+pName1+" "+pName4);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player4No();
						player2No=0;
						player3No=0;
						player5No=0;
						check2();
					}
					else
					{
						System.out.println(pName1+" "+" wins");
					}
				}
				
				else if(player5No!=player1No)
				{
					if(player3No==guesserNo && player4No==guesserNo)
					{
						System.out.println("Game is tie between "+pName1+" "+pName3+" "+pName4);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player3No();
						player4No();
						player2No=0;
						player5No=0;
						check2();
					}
					else if(player3No==guesserNo)
					{
						System.out.println("game is tie between "+pName1+" "+pName3);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player3No();
						player2No=0;
						player4No=0;
						player5No=0;
						check2();
					}
					else if(player4No==guesserNo)
					{
						System.out.println("Game is tie between "+pName1+" "+pName4);
						System.out.println("");
						System.out.println("Lets play the next round ...");
						guesserNo();
						player1No();
						player4No();
						player2No=0;
						player3No=0;
						player5No=0;
						check2();
					}
					else
					{
						System.out.println(pName1+" "+" wins");
					}
				}	
			}
		}
		
		else if(player2No==guesserNo)
		{
			if (player3No==guesserNo && player4No==guesserNo && player5No==guesserNo)
			{
				System.out.println("Game is tie between "+pName2+" "+pName3+" "+pName4+" "+pName5);
				System.out.println("");
				System.out.println("Lets play the next round ...");
				guesserNo();
				player2No();
				player3No();
				player4No();
				player5No();
				player1No=0;
				check2();
			}
			
			else if(player3No!=player2No)
			{
				if (player4No==guesserNo && player5No==guesserNo)
				{
					System.out.println("Game is tie between "+pName2+" "+pName4+" "+pName5);
					System.out.println("");
					System.out.println("Lets play the next round ...");
					guesserNo();
					player2No();
					player4No();
					player5No();
					player1No=0;
					player3No=0;
					check2();
				}
				
				else if(player4No==guesserNo)
				{
					System.out.println("Game is tie between "+pName2+" "+pName4);
					System.out.println("");
					System.out.println("Lets play the next round ...");
					guesserNo();
					player2No();
					player4No();
					player1No=0;
					player3No=0;
					player5No=0;
					check2();
				}
				
				else if(player5No==guesserNo)
				{
					System.out.println("Game is tie between "+pName2+" "+pName5);
					System.out.println("");
					System.out.println("Lets play the next round ...");
					guesserNo();
					player2No();
					player5No();
					player1No=0;
					player3No=0;
					player4No=0;
					check2();
				}
				
				else
				{
					System.out.println(pName2+" "+" won the game");
				}
			}
			
			else if(player4No!=player2No)
			{
				if (player3No==guesserNo && player5No==guesserNo)
				{
					System.out.println("Game is tie between "+pName2+" "+pName3+" "+pName5);
					System.out.println("");
					System.out.println("Lets play the next round ...");
					guesserNo();
					player2No();
					player3No();
					player5No();
					player1No=0;
					player4No=0;
					check2();
				}
				
				else if(player3No==guesserNo)
				{
					System.out.println("Game is tie between "+pName2+" "+pName3);
					System.out.println("");
					System.out.println("Lets play the next round ...");
					guesserNo();
					player2No();
					player3No();
					player1No=0;
					player4No=0;
					player5No=0;
					check2();
				}
				
				else if(player5No==guesserNo)
				{
					System.out.println("Game is tie between "+pName2+" "+pName5);
					System.out.println("");
					System.out.println("Lets play the next round ...");
					guesserNo();
					player2No();
					player5No();
					player1No=0;
					player3No=0;
					player4No=0;
					check2();
				}
				
				else
				{
					System.out.println(pName2+" "+" won the game");
				}
			}
			
			else if(player5No!=player2No)
			{
				if (player3No==guesserNo && player4No==guesserNo)
				{
					System.out.println("Game is tie between "+pName2+" "+pName3+" "+pName4);
					System.out.println("");
					System.out.println("Lets play the next round ...");
					guesserNo();
					player2No();
					player3No();
					player4No();
					player1No=0;
					player5No=0;
					check2();
				}
				
				else if(player3No==guesserNo)
				{
					System.out.println("Game is tie between "+pName2+" "+pName3);
					System.out.println("");
					System.out.println("Lets play the next round ...");
					guesserNo();
					player2No();
					player3No();
					player1No=0;
					player4No=0;
					player5No=0;
					check2();
				}
				
				else if(player4No==guesserNo)
				{
					System.out.println("Game is tie between "+pName2+" "+pName4);
					System.out.println("");
					System.out.println("Lets play the next round ...");
					guesserNo();
					player2No();
					player4No();
					player1No=0;
					player3No=0;
					player5No=0;
					check2();
				}
				
				else
				{
					System.out.println(pName2+" "+" won the game");
				}
			}	
		}
		
		else if(player3No==guesserNo)
		{
			if(player4No==guesserNo && player5No==guesserNo)
			{
				System.out.println("Game is tie between "+pName3+" "+pName4+" "+pName5);
				System.out.println("");
				System.out.println("Lets play the next round ...");
				guesserNo();
				player3No();
				player4No();
				player5No();
				player1No=0;
				player2No=0;
				check2();
			}
			else if(player4No==guesserNo)
			{
				System.out.println("Game is tie between "+pName3+" "+pName4);
				System.out.println("");
				System.out.println("Lets play the next round ...");
				guesserNo();
				player3No();
				player4No();
				player1No=0;
				player2No=0;
				player5No=0;
				check2();
			}
			else if(player5No==guesserNo)
			{
				System.out.println("Game is tie between "+pName3+" "+pName5);
				System.out.println("");
				System.out.println("Lets play the next round ...");
				guesserNo();
				player3No();
				player5No();
				player1No=0;
				player2No=0;
				player4No=0;
				check2();
			}
			else
			{
				System.out.println(pName3+" "+" won the game");
			}
		}
		
		else if (player4No==guesserNo)
		{
			if (player5No==guesserNo)
			{
				System.out.println("Game is tie between "+pName4+" "+pName5);
				System.out.println("");
				System.out.println("Lets play the next round ...");
				guesserNo();
				player4No();
				player5No();
				player1No=0;
				player2No=0;
				player3No=0;
				check2();
			}
			else
			{
				System.out.println(pName4+" "+" won the game");
			}
		}
		
		else if (player5No==guesserNo)
		{
			System.out.println(pName5+" "+" won the game");
		}
		
		else
		{
			System.out.println("All the players lost");
		}
	}

//	After final declaration of the winner umpire will ask the user whether he want to
//	play the game again or not.
	void replay()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Gammer,Do you want to play again : y/n");
		int temp=scan.next().charAt(0);
		
		if(temp=='y' || temp=='Y')
		{
			GuesserGame.main(null);
		}
		else if(temp=='n' || temp=='N')
		{
			System.out.println("Thank you for playing the game");
			System.out.println("Come back soon...");
		}
		else
		{
			System.out.println("To play again press: y");
			System.out.println("To Exit press:n");
			replay();
		}
	}
}

//Umpire will do his activities here
public class GuesserGame {

	public static void main(String[] args) 
	{
		System.out.println("welcome");
		Umpire umpire=new Umpire();
		
		int noOfPlayers=umpire.noOfPlayers();
		umpire.startOfRange();
		umpire.endOfRange();
		
		if(noOfPlayers==3)
		{
			umpire.name1();
			umpire.name2();
			umpire.name3();
		}
		
		else if(noOfPlayers==4)
		{
			umpire.name1();
			umpire.name2();
			umpire.name3();
			umpire.name4();
		}
		
		else if(noOfPlayers==5)
		{
			umpire.name1();
			umpire.name2();
			umpire.name3();
			umpire.name4();
			umpire.name5();
		}
		
		umpire.guesserNo();
		
		if(noOfPlayers==3)
		{
			umpire.player1No();
			umpire.player2No();
			umpire.player3No();
			umpire.check2();
		}
		
		else if(noOfPlayers==4)
		{
			umpire.player1No();
			umpire.player2No();
			umpire.player3No();
			umpire.player4No();
			umpire.check2();
		}
		
		else if(noOfPlayers==5)
		{
			umpire.player1No();
			umpire.player2No();
			umpire.player3No();
			umpire.player4No();
			umpire.player5No();
			umpire.check2();
		}
		
		umpire.replay();
	
	}
}

