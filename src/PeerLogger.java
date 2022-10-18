import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class PeerLogger {

    BufferedWriter writer = null;

    public PeerLogger(int peerID) {
        String filename = "log_peer_" + peerID + ".log";
        try {
            writer = new BufferedWriter(new FileWriter(filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeLog(String message) {
        LocalDateTime now = LocalDateTime.now();
        try {
            writer.write(now + ": " + message);
        } catch (IOException e) {
            System.out.println("Error writing log");
        }
    }

    public void flushBuffer() {
        try {
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeFile() {
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
