package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbLivre {

	public static ArrayList<Livre> getLivres() {
		Connection con = DbUtil.dbConnect("geslibr", "ayman", "ayman");
		ArrayList<Livre> lv = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String Query = "SELECT * FROM `livre` ";
		try {
			ps = con.prepareStatement(Query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Livre l = new Livre();
				l.setId_Livre(rs.getInt("Id_Lib"));
				l.setDescription(rs.getString("Description"));
				l.setPrix(rs.getDouble("Prix"));
				l.setQuentite(rs.getInt("QttStock"));
				lv.add(l);
			}
		} catch (SQLException e) {

		} finally {
			DbUtil.ClosePreparedStatemnt(ps);
			DbUtil.CloseResultSet(rs);
		}
		return lv;
	}

	public static Livre getLivresbyId(int id) {
		Connection con = DbUtil.dbConnect("geslibr", "ayman", "ayman");
		PreparedStatement ps = null;
		ResultSet rs = null;
		Livre l = new Livre();
		String Query = "SELECT * FROM `livre` WHERE `Id_Lib`=? ";
		try {

			ps = con.prepareStatement(Query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				l.setId_Livre(rs.getInt("Id_Lib"));
				l.setDescription(rs.getString("Description"));
				l.setPrix(rs.getDouble("Prix"));
				l.setQuentite(rs.getInt("QttStock"));
			}
		} catch (SQLException e) {

		} finally {
			DbUtil.ClosePreparedStatemnt(ps);
			DbUtil.CloseResultSet(rs);
		}
		return l;
	}
}
