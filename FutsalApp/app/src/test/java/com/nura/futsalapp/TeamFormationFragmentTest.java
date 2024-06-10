package com.nura.futsalapp;

import com.nura.futsalapp.data.PlayingPlayers;
import com.nura.futsalapp.model.PlayersList;
import com.nura.futsalapp.model.TeamFormation;
import com.nura.futsalapp.ui.TeamFormationFragment;

import org.junit.Test;

public class TeamFormationFragmentTest {
	@Test
	public void initTeamOne() {

		String playingPlayersJson = PlayingPlayers.getPlayingPlayers();
		PlayersList playingPlayers = MainOperations.testPlayerData( playingPlayersJson);
		TeamFormation teamFormation = new TeamFormation(playingPlayers.getPlayers());
		System.out.println("players size" + playingPlayers.getPlayers().size());
		teamFormation.createTeam();
		System.out.println("\n \n===============================");
		for (int i = 0; i < teamFormation.getTeamOne().size(); i++) {
			System.out.println(teamFormation.getTeamOne().get(i).getName() + " " +teamFormation.getTeamOne().get(i).getRating()  );
		}

		System.out.println("\n \n===============================");
		for (int i = 0; i < teamFormation.getTeamTwo().size(); i++) {
			System.out.println(teamFormation.getTeamTwo().get(i).getName() + " " + teamFormation.getTeamTwo().get(i).getRating() );
		}
	}
}
