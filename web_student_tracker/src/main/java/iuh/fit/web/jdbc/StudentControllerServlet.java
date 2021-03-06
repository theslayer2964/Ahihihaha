package iuh.fit.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDbUtil studentDbUtil;
	
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			studentDbUtil = new StudentDbUtil(dataSource);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	public StudentControllerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		try {
			// TODO Auto-generated method stub
			response.getWriter().append("Served at: ").append(request.getContextPath());

			String theCommand = request.getParameter("command");
			if (theCommand == null)
				theCommand = "LIST";
			switch (theCommand) {
			case "LIST":
				listStudents(request, response);
				break;
			case "ADD":
				addStudents(request, response);
				break;
			case "UPDATE":
				updateStudents(request, response);
				break;
			case "LOAD":
				loadStudents(request, response);
				break;
			case "DELETE":
				deleteStudents(request, response);
				break;
			default:
				listStudents(request,response);
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void deleteStudents(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id = request.getParameter("studentId");
		// TODO Auto-generated method stub
		studentDbUtil.deleteStudent(id);
		listStudents(request, response);
	}

	private void loadStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String studentId = request.getParameter("studentId");
		Student s= studentDbUtil.getStdent(studentId);
		request.setAttribute("THE_STUDENT", s);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("update-student-form.jsp");
		requestDispatcher.forward(request, response);
	}

	private void updateStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("studentId"));
		String first = request.getParameter("firstName");
		String last = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		Student s = new Student(id, first, last, email);
		// TODO Auto-generated method stub
		studentDbUtil.updateStudent(s);
		listStudents(request, response);
	}

	private void addStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String first = request.getParameter("firstName");
		String last = request.getParameter("lastName");
		String email = request.getParameter("email");
		Student s = new Student(first, last , email);
		// TODO Auto-generated method stub
		studentDbUtil.addStudent(s);
		listStudents(request, response);
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Student> students = studentDbUtil.getStdents();
		request.setAttribute("STUDENT_LIST", students);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("list_student.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
