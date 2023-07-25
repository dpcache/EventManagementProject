package eventManagement;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GameSummaryDAO  {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public GameSummary saveGameSummary(GameSummary gameSummary) {
        String sql = "INSERT INTO GAMESUMMARY (CLIENTGESTURE, SERVERGESTURE, RESULT, TIMEPLAYED) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, gameSummary.getClientGesture(), gameSummary.getServerGesture(), gameSummary.getResult(), gameSummary.getTimePlayed());
        return gameSummary;
	}

	public Collection<GameSummary> getAllGameSummarys() {
		// Replace this statement with the call to jdbcTemplate.
		
		return jdbcTemplate.query("Select * from GAMESUMMARY", new
				BeanPropertyRowMapper<GameSummary>(GameSummary.class));
	}

	public GameSummary getGameSummary(int id) {
		String sql = "SELECT * FROM GAMESUMMARY WHERE id = ?";
		List<GameSummary> gameSummarys = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(GameSummary.class), id);
		return gameSummarys.isEmpty() ? null : gameSummarys.get(0);
	}

}