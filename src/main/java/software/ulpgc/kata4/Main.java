package software.ulpgc.kata4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:chinook.db")){
            TrackLoader loader = new SquliteTrackLoader(connection);
            List<Track> tracks = loader.loadAll();
            for (Track track : tracks){
                System.out.println(track);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
