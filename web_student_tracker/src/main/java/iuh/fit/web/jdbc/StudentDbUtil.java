package iuh.fit.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;

public class StudentDbUtil {
	private DataSource dataSource;

	public StudentDbUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public List<Student> getStdents() {
		List<Student> student_List = new ArrayList<Student>();
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "Select * from student";
			statement = con.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				String email = rs.getString("email");
				String first = rs.getString("first_Name");
				String last = rs.getString("last_Name");
				int id = rs.getInt("id");
				Student a = new Student(id, first, last, email);
				student_List.add(a);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con, statement, rs);
		}
		return student_List;
	}

	public void addStudent(Student s) {
		Connection con = null;
		PreparedStatement statement = null;

		try {
			con = dataSource.getConnection();
			String sql = "insert into student (first_Name , last_Name , email) values (? , ? , ?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, s.getFirstName());
			statement.setString(2, s.getLastName());
			statement.setString(3, s.getEmail());

			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con, statement, null);
		}
	}

	public void updateStudent(Student s) {
		Connection con = null;
		PreparedStatement statement = null;

		try {
			con = dataSource.getConnection();
			String sql = "update student set first_Name = ? , last_Name = ? , email = ? where id = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, s.getFirstName());
			statement.setString(2, s.getLastName());
			statement.setString(3, s.getEmail());
			statement.setInt(4, s.getId());

			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con, statement, null);
		}
	}

	public void deleteStudent(String studentId) {
		Connection con = null;
		PreparedStatement statement = null;

		try {
			con = dataSource.getConnection();
			String sql = "delete from student where id = ?";
			statement = con.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(studentId));
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con, statement, null);
		}
	}

	public Student getStdent(String studentId) throws Exception {
		Student a = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		int id = Integer.parseInt(studentId);
		try {
			con = dataSource.getConnection();
			String sql = "Select * from student where id = ?";
			statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			if (rs.next()) {
				String first = rs.getString("first_Name");
				String last = rs.getString("last_Name");
				String email = rs.getString("email");
				a = new Student(id, first, last, email);
			} else {
				throw new Exception("Couldn't find student id: " + studentId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con, statement, rs);
		}
		return a;
	}

	private void close(Connection con, Statement state, ResultSet rs) {
		try {
			if (con != null)
				con.close();
			if (state != null)
				state.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
