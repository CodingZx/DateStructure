package lol.cicco.leetcode;

public class Problem5169 {
    public int daysBetweenDates(String date1, String date2) {
        java.time.LocalDate start = java.time.LocalDate.parse(date1);
        java.time.LocalDate end = java.time.LocalDate.parse(date2);

        return Math.abs((int)start.until(end, java.time.temporal.ChronoUnit.DAYS));
    }
}
