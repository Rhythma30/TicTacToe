import java.io.*;
public class TicTacToe
{
	char ar[][] = new char[3][3];
	int pos[] = new int[10];
	static String player1 = "Player1", player2 = "Player2";
	static char ch1 = 'X',ch2 = 'O';
	BufferedReader br;
	public void choose()throws IOException
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(player1+": Do you want X or O");
		ch1=(char)br.read();
		if(ch1!='X'&&ch1!='O')
		{
			System.out.println("You made wrong selection. Please try again");
			System.exit(0);
		}
		else 
		{//20
			System.out.print(player1+": You will play with "+ch1);
			ch2 = (ch1=='X')?'O':'X';
			System.out.println(" and "+player2+": You will play with "+ch2);
		}
		
	}
	public void startgame()
	{
 		
		for(int i = 1;i<=2; i++)
		{
			for(int j = 1;j<=2; j++)
			{
				System.out.print("   |");
			}
			System.out.println();
			System.out.println("____________");	
			
		}
		System.out.print("   |");
		System.out.println("   |");
	}
	public void playGame(int a, char ch)
	{
		int i,j;//54
		if(a>=1&&a<=3)
		{
			i=0;
			j=a-1;
		}
		else if(a<=6)
		{
			i=1;
			j=a-4;
		}
		else // 65
		{
			i=2;		
			j=a-7;
		}
		ar[i][j]=ch;	
	}
	public void initializeArr()
	{
		for(int i=1;i<=3;i++)
		{
			for(int j=1;j<=3;j++)
			{
				ar[i-1][j-1] = ' ';
			}
		}
	}
	public void display()
	{
		for(int i = 1;i<=2; i++)
		{
			for(int j = 1;j<=2; j++)
			{
				System.out.print(" "+ar[i-1][j-1]+" |");
			}
			System.out.println(ar[i-1][2]);
			System.out.println("____________");	
			
		}
		for(int k = 1;k<=2; k++)
		{
			System.out.print(" "+ar[2][k-1]+" |");
		}
		System.out.println(ar[2][2]);
	}
	public boolean search1(int a)
	{
		System.out.println("checkpoint 2");//executed
		int ub = pos.length, lb = 0, mid;
		while(ub>=lb)
		{
			mid = (lb+ub)/2;
			System.out.println("checkpoint 3");
			if(pos[mid] == a)
				return true;
			else if(pos[mid]>a)
				ub = pos[mid];
			else
				lb = pos[mid];
		}
		System.out.println("checkpoint 4");//not executed
		return false;	
	}
	public boolean search(int a)
	{
		//System.out.println("checkpoint 5");
		for(int i = 0;i<pos.length;i++)
		{
			if(pos[i] == a)
			return true;
		}

		//System.out.println("checkpoint 6");
		return false;
	}
	public void checkWinner(char ch)
	{
		String player = (ch ==ch1)?player1:player2;
		if(ar[0][0]==ch&&ar[0][1]==ch&&ar[0][2]==ch||
		   ar[1][0]==ch&&ar[1][1]==ch&&ar[1][2]==ch||
		   ar[2][0]==ch&&ar[2][1]==ch&&ar[2][2]==ch||
		   ar[0][0]==ch&&ar[1][0]==ch&&ar[2][0]==ch||
		   ar[0][1]==ch&&ar[1][1]==ch&&ar[2][1]==ch||
		   ar[0][2]==ch&&ar[1][2]==ch&&ar[2][2]==ch||
		   ar[0][0]==ch&&ar[1][1]==ch&&ar[2][2]==ch||
		   ar[0][2]==ch&&ar[1][1]==ch&&ar[2][0]==ch)
		{
			System.out.println("Congratulations "+player+". You are the Winner.");
			System.exit(0);
		}
		else
		{
		}
	}
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int p;
		TicTacToe ttt = new TicTacToe();
		ttt.pos[0]=0;
		System.out.println("Player 1: Enter your name");
		player1 = br.readLine();
		System.out.println("Player 2: Enter your name");
		player2 = br.readLine();ttt.choose();
		ttt.startgame();
		ttt.initializeArr();
		char ch;
		int n = 9,l = 1;
		try{
		for(int i = 0;i<n;i++)
		{
			ch = (i%2==0)?ch1:ch2;
			String player = (ch ==ch1)?player1:player2;
			System.out.println(player+": Choose your position(1-9)");
			p = Integer.parseInt(br.readLine());
			if(p>9)
			{
				i=i-1;
				continue;
			}
			else
			{
				if(ttt.search(p)==false)
				{
					//System.out.println("Rhythma");
					ttt.pos[l++] = p;	// p cannot be repeated
				}
				else
				{
					i=i-1;
					System.out.println("This position is already occupied.\nTry Again");
					continue;
				}
			}
			ttt.playGame(p,ch);
			ttt.display();
			ttt.checkWinner(ch);
		}
		System.out.println("It's a tie");
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
	}
}
