package socoge;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.etematica.model.Project;

public class generate {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/socoge?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	// Database credentials
	static final String USER = "socogeuser";
	static final String PASS = "sOcoge@2";
	static Connection conn = null;

	public static void main(String[] args) throws SQLException {
		Integer projectId = 10;

		if (args.length > 0) {
			projectId = Integer.parseInt(args[0]);
		}
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

		generateProject(projectId);

		conn.close();
		System.out.println("Goodbye!");
	}

	private static void generateProject(Integer projectId) throws SQLException {
		Project project = getProject(projectId);

		createFolder(project);
		makeFromTemplate(project);
	}

	private static void makeFromTemplate(Project project) throws SQLException {
		List<Template> templates = getTemplate(project);

	}

	private static List<Template> getTemplate(Project project) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement("SELECT Templates.* \r\n"
				+ "FROM LinguagemXTemplate INNER JOIN Templates ON LinguagemXTemplate.cdTemplate = Templates.id \r\n"
				+ "WHERE (((LinguagemXTemplate.cdLinguagem)=?)) ");
		pstmt.setLong(1, project.getFrontLanguage());

		ResultSet rs = pstmt.executeQuery();

		List<Template> templates = new ArrayList<>();
		while ((rs != null) && (rs.next())) {
			Template template = new Template();

			template.setId(rs.getLong("id"));
			template.setName(rs.getString("nmTemplate"));
			template.setSqlCommand(rs.getString("dsSqlCommand"));
			template.setSqlParameter(rs.getString("dsSqlParameter"));
			template.setParameterType(rs.getString("dsParameterType"));

			templates.add(template);
		}

		return templates;
	}

	private static void createFolder(Project project) {
		new File(project.getDirectory()).mkdirs();
		new File(project.getDirectory() + "\\app").mkdirs();
	}

	private static Project getProject(Integer projectId) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement("select * from projects where id=?");

		pstmt.setInt(1, projectId);

		ResultSet rs = pstmt.executeQuery();

		if ((rs != null) && (rs.next())) {
			Project project = new Project();
			project.setId(rs.getLong("id"));
			project.setName(rs.getString("nmProject"));
			project.setDirectory(rs.getString("nmDirectory"));
			project.setFrontLanguage(rs.getLong("cdFrontLanguage"));
			getEntities(project);
			return project;
		}
		return null;
	}

	private static void getEntities(Project project) {
		// TODO Auto-generated method stub

	}

}
