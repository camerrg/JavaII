package product.beans;

import java.util.Random;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Game {
	private String player1;
	private String computerPlayer;
	private String winner;
	
	public Game(String player1) {
		super();
		this.player1 = player1;
		this.setComputerPlayerToRandom();
		this.determineWinner();
	}

		private void determineWinner() {
		String winner = "player1";
		setComputerPlayerToRandom();
	
		
	   if (player1.equals(computerPlayer)) {
		   winner = "Its a tie!";
	   }
	   if (player1.equals("rock") && (computerPlayer.equals("paper"))) {
		   winner = "lose";
	   }
	   if (player1.equals("paper") && (computerPlayer.equals("scissors"))){
		   winner = "lose";
	   }
	   if (player1.equals("scissors") && (computerPlayer.equals("rock"))){
		   winner = "lose";
	   }
	   this.setWinner(winner);
	}
	   
	   
	   	
	
	   


		public String getComputerPlayer() {
			return computerPlayer;
		}

		public void setComputerPlayer(String computerPlayer) {
			this.computerPlayer = computerPlayer;
		}

		public String getWinner() {
			return winner;
		}

		public void setWinner(String winner) {
			this.winner = winner;
		}

		private void setComputerPlayerToRandom() {
		String computerPlayer = "";
		Random theChoice = new Random();
		int ComputerPlayerToRandom = theChoice.nextInt(3);
		if(ComputerPlayerToRandom == 0) {
			computerPlayer ="rock";
		}
		if(ComputerPlayerToRandom == 1) {
			computerPlayer = "paper";	
		}
		if (ComputerPlayerToRandom == 2) {
			computerPlayer = "scissor";
			}
		this.setComputerPlayer(computerPlayer);
		
		
		
		
	}

	
	

}
