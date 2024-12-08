public class RoomDAO {
    public List<Room> getAvailableRooms() throws SQLException {
        List<Room> rooms = new ArrayList<>();
        String query = "SELECT * FROM Rooms WHERE isAvailable = TRUE";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Room room = new Room();
                room.setRoomID(rs.getInt("roomID"));
                room.setRoomType(rs.getString("roomType"));
                room.setAvailable(rs.getBoolean("isAvailable"));
                room.setPricePerNight(rs.getDouble("pricePerNight"));
                rooms.add(room);
            }
        }
        return rooms;
    }
}
