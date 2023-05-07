package shop;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyUtils {

    public static String format(Timestamp timestamp) {
        LocalDateTime date = timestamp.toLocalDateTime();
        LocalDateTime now = LocalDateTime.now();
        // calculate difference between dates
        Duration duration = Duration.between(date, now);
        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;

        if (days > 1) {
            // format date as "dd MMM yyyy"
            return date.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
        } else if (days == 1) {
            return "yesterday";
        } else if (hours > 0) {
            // format as "x hours ago"
            return String.format("%d %s ago", hours, hours == 1 ? "hour" : "hours");
        } else if (minutes > 0) {
            // format as "x minutes ago"
            return String.format("%d %s ago", minutes, minutes == 1 ? "minute" : "minutes");
        } else {
            return "just now";
        }
    }
}