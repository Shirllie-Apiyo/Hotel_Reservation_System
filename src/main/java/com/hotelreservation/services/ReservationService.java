public class ReservationService {
    public void makeReservation(Reservation reservation) throws SQLException {
        String query = "INSERT INTO Reservations (customerID, roomID, startDate, endDate, status) VALUES (?, ?, ?, ?, 'Active')";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, reservation.getCustomerID());
            pstmt.setInt(2, reservation.getRoomID());
            pstmt.setString(3, reservation.getStartDate());
            pstmt.setString(4, reservation.getEndDate());
            pstmt.executeUpdate();
        }
    }

    public void cancelReservation(int reservationID) throws SQLException {
        String query = "UPDATE Reservations SET status = 'Cancelled' WHERE reservationID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, reservationID);
            pstmt.executeUpdate();
        }
    }
}
