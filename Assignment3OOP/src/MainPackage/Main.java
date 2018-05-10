package MainPackage;

import GameFrame.GameFrame;

public class Main {

	public static void main(String[] args) {
		
		String[][] s = new String[3][3];
		
		for(int i = 0; i<3; i++)
		{
			for(int j = 0; j<3; j++)
			{
				int t = 3*i +j +1;
				s[i][j] = "images/cat/cat_3x3/" + t + ".jpeg"; 
			}
		}
		
		new GameFrame(s);
	}

}
