package GlobalLogicClassHokeyScore;

import java.util.Scanner;

public class HockeyScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("Enter the name of team 1.");
        String teamOne = scanner.nextLine();
        System.out.println("Enter the name of team 2.");
        String teamTwo = scanner.nextLine();
        System.out.println("Enter hockey scores for seven games.");
        String scores = scanner.nextLine();
        System.out.println("Enter the number of power play goals for both teams in each game.");
        String powerPlay = scanner.nextLine();
        scanner.close();

        // The values of each of the scores are defined below, you should use these int variables
        /* The string has 7 scores so the format of the string is
         * scoreOneTeamOne-scoreOneTeamTwo,scoreTwoTeamOne-scoreTwoTeamTwo,scoreThreeTeamOne-scoreThreeTeamTwo,
         * ...
         */
        int currentScoreIndex = 0;
        int scoreOneTeamOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreOneTeamTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreTwoTeamOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreTwoTeamTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreThreeTeamOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreThreeTeamTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreFourTeamOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreFourTeamTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreFiveTeamOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreFiveTeamTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreSixTeamOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreSixTeamTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreSevenTeamOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int scoreSevenTeamTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        // The values of each of the power play goals are defined below, you should use these int variables
        /* The string has the number of power play goals listed for both teams in each of the seven games so
         * the format of the string is
         * powerPlayOneTeamOne-powerPlayOneTeamTwo,powerPlayTwoTeamOne-powerPlayTwoTeamTwo,powerPlayThreeTeamOne-powerPlayThreeTeamTwo,
         * ...
         */
        int currentPowerPlayIndex = 0;
        int powerPlayOneTeamOne = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlayOneTeamTwo = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlayTwoTeamOne = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlayTwoTeamTwo = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlayThreeTeamOne = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlayThreeTeamTwo = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlayFourTeamOne = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlayFourTeamTwo = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlayFiveTeamOne = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlayFiveTeamTwo = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlaySixTeamOne = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlaySixTeamTwo = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlaySevenTeamOne = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        currentPowerPlayIndex += 3;
        int powerPlaySevenTeamTwo = Integer.parseInt(powerPlay.substring(currentPowerPlayIndex,
                currentPowerPlayIndex + 2));
        
//        The predators won the series by a score of 4-3
//        The blackhawks scored 20 total goals
//        The predators scored 18 total goals
//        The blackhawks scored 6 power play goals
//        The predators scored 6 power play goals
//        The blackhawks scored 14 standard goals
//        The predators scored 12 standard goals
//        The blackhawks recorded 1 shutout
//        The predators recorded 0 shutouts
//        The maximum number of goals scored was 8 by the blackhawks in game 3
        
        
        int teamOneStandardGoals = scoreOneTeamOne + scoreTwoTeamOne + scoreThreeTeamOne + scoreFourTeamOne
        		+ scoreFiveTeamOne + scoreSixTeamOne + scoreSevenTeamOne;
        
        int teamTwoStandardGoals = scoreOneTeamTwo + scoreTwoTeamTwo + scoreThreeTeamTwo + scoreFourTeamTwo
        		+ scoreFiveTeamTwo + scoreSixTeamTwo + scoreSevenTeamTwo;
        
        int teamOneWins = 0;
        int teamTwoWins = 0;
        
        if(scoreOneTeamOne > scoreOneTeamTwo) {
        	teamOneWins++;
        }
        else {
        	teamTwoWins++;
        }
        
        if(scoreTwoTeamOne > scoreTwoTeamTwo) {
        	teamOneWins++;
        }
        else {
        	teamTwoWins++;
        }
        
        if(scoreThreeTeamOne > scoreThreeTeamTwo) {
        	teamOneWins++;
        }
        else {
        	teamTwoWins++;
        }
        
        if(scoreFourTeamOne > scoreFourTeamTwo) {
        	teamOneWins++;
        }
        else {
        	teamTwoWins++;
        }
        
        if(scoreFiveTeamOne > scoreFiveTeamTwo) {
        	teamOneWins++;
        }
        else {
        	teamTwoWins++;
        }
        
        if(scoreSixTeamOne > scoreSixTeamTwo) {
        	teamOneWins++;
        }
        else {
        	teamTwoWins++;
        }
        
        if(scoreSevenTeamOne > scoreSevenTeamTwo) {
        	teamOneWins++;
        }
        else {
        	teamTwoWins++;
        }
        
        
        int teamOnePowerPlayGoals = powerPlayOneTeamOne + powerPlayTwoTeamOne + powerPlayThreeTeamOne + powerPlayFourTeamOne
        		+ powerPlayFiveTeamOne + powerPlaySixTeamOne + powerPlaySevenTeamOne;
        
        int teamTwoPowerPlayGoals = powerPlayOneTeamTwo + powerPlayTwoTeamTwo + powerPlayThreeTeamTwo + powerPlayFourTeamTwo
        		+ powerPlayFiveTeamTwo + powerPlaySixTeamTwo + powerPlaySevenTeamTwo;
        
        
       
    }
}


