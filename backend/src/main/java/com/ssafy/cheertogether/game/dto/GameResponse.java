package com.ssafy.cheertogether.game.dto;

import java.time.LocalDateTime;

import com.ssafy.cheertogether.game.domain.Game;
import com.ssafy.cheertogether.game.domain.GameStatus;
import com.ssafy.cheertogether.team.domain.Team;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GameResponse {
	private Long id;
	private Team home;
	private Team away;
	private LocalDateTime kickoff;
	private String stadium;
	private GameStatus status;
	private Integer homeScore;
	private Integer awayScore;
	private Long apiId;

	public GameResponse(Game game) {
		id = game.getApiId();
		home = game.getHome();
		away = game.getAway();
		kickoff = game.getKickoff();
		stadium = game.getStadium();
		status = game.getStatus();
		homeScore = game.getHomeScore();
		awayScore = game.getAwayScore();
		apiId = game.getApiId();
	}
}