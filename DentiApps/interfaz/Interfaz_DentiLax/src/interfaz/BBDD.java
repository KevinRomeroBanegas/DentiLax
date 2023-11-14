package interfaz;

import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import java.util.Arrays;
import java.util.Collection;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.ResultSetMetaData;

public class BBDD {
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bbdd_dentista?useSSL=false";
	private static final String USUARIO = "root";
	private static final String CLAVE = "1234";
	protected static final Component ConsultarCliente = null;

	Connection cn = null;
	Statement stm = null;
	ResultSet Resultado = null;

	static {
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}

	public Connection conectar() {

		try {
			cn = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("Conexión OK");
			stm = cn.createStatement();

		} catch (SQLException e) {
			System.out.println("Error en la conexión");
			e.printStackTrace();
		}

		return cn;
	}

	public int entrar(String Nombre, String Cont) throws SQLException {
		this.conectar();
		int ent = 2;
		Resultado = stm.executeQuery(
				"SELECT RolAdmin FROM bbdd_dentista.usuario where DNI='" + Nombre + "' && Contraseña='" + Cont + "';");
		if (Resultado.next()) {
			boolean i = Resultado.getBoolean("RolAdmin");
			if (i == true) {
				ent = 1;
			} else {
				ent = 0;
			}
		} else {
		}
		return ent;
	}

	public ArrayList consultaTratamientos() throws SQLException {
		ArrayList dato = new ArrayList();
		this.conectar();
		Resultado = stm.executeQuery("select * from bbdd_dentista.tratamiento");
		while (Resultado.next()) {
			String nombre_paciente = Resultado.getString("Nombre");
			dato.add(nombre_paciente);
		}
		stm.close();
		cn.close();

		return dato;
	}

	public ArrayList consultaDoctores() throws SQLException {
		ArrayList dato = new ArrayList();
		this.conectar();
		Resultado = stm.executeQuery("select * from bbdd_dentista.doctor");
		while (Resultado.next()) {
			String nombre_paciente = Resultado.getString("Nombre");
			dato.add(nombre_paciente);
		}
		stm.close();
		cn.close();

		return dato;
	}

	public ArrayList consultaDoctoresFiltrado(String Tratamiento) throws SQLException {
		ArrayList dato = new ArrayList();
		this.conectar();
		ResultSet ResultadoDoctor = stm.executeQuery(
				"select * from bbdd_dentista.doctor where Especialidad_Doctor=(select Especialidad from bbdd_dentista.tratamiento where Nombre='"
						+ Tratamiento + "')");
		while (ResultadoDoctor.next()) {
			String nombre_doctor = ResultadoDoctor.getString("Nombre");
			dato.add(nombre_doctor);
		}
		stm.close();
		cn.close();

		return dato;
	}

	public void insertar(String tableName, String[] valores, boolean AutoInc) {
		conectar();
		try {
			DatabaseMetaData metaData = (DatabaseMetaData) cn.getMetaData();
			ResultSet resultSet = metaData.getColumns(null, null, tableName, null);
			String columnNames = "";
			String valoresFinales = "";

			if (AutoInc == false) {
				while (resultSet.next()) {
					String columnName = resultSet.getString("COLUMN_NAME");
					columnNames += columnName + ",";
				}
				columnNames = columnNames.substring(0, columnNames.length() - 1);
			} else {
				while (resultSet.next()) {
					String columnName = resultSet.getString("COLUMN_NAME");
					columnNames += columnName + ",";
				}
				columnNames = columnNames.substring(0, columnNames.length() - 1);
				String[] ArrayC = columnNames.split(",");
				ArrayList<String> Columnas = new ArrayList<String>(Arrays.asList(ArrayC));
				Columnas.remove(0);
				StringBuilder str = new StringBuilder();
				for (String ColumnasDefinitivas : Columnas) {
					str.append(ColumnasDefinitivas);
					str.append(",");
				}
				columnNames = str.substring(0, str.length() - 1);
			}

			Statement statement = cn.createStatement();
			for (int i = 0; i < valores.length; i++) {
				String valor = valores[i].toString();
				valoresFinales += valor + ",";
			}
			valoresFinales = valoresFinales.substring(0, valoresFinales.length() - 1);
			String query = "INSERT INTO bbdd_dentista." + tableName + " (" + columnNames + ") VALUES (" + valoresFinales
					+ ")";
			statement.executeUpdate(query);
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void borrar(String tableName, String[] valoresFinales, boolean AutoInc) {
		conectar();
		try {
			DatabaseMetaData metaData = (DatabaseMetaData) cn.getMetaData();
			ResultSet resultSet = metaData.getColumns(null, null, tableName, null);
			String columnNames = "";
			String[] ArrayC;
			String condicion = "";
			if (AutoInc == false) {
				while (resultSet.next()) {
					String columnName = resultSet.getString("COLUMN_NAME");
					columnNames += columnName + ",";
				}
				columnNames = columnNames.substring(0, columnNames.length() - 1);
				ArrayC = columnNames.split(",");
			} else {
				while (resultSet.next()) {
					String columnName = resultSet.getString("COLUMN_NAME");
					columnNames += columnName + ",";
				}
				columnNames = columnNames.substring(0, columnNames.length() - 1);
				ArrayC = columnNames.split(",");
				ArrayList<String> Columnas = new ArrayList<String>(Arrays.asList(ArrayC));
				Columnas.remove(0);
				StringBuilder str = new StringBuilder();
				for (String ColumnasDefinitivas : Columnas) {
					str.append(ColumnasDefinitivas);
					str.append(",");
				}
				columnNames = str.substring(0, str.length() - 1);
				ArrayC = columnNames.split(",");
			}

			for (int i = 0; i < valoresFinales.length; i++) {
				String valor = ArrayC[i] + "=" + valoresFinales[i];
				condicion += valor + ",";
			}
			condicion = condicion.substring(0, condicion.length() - 1);

			String query = "DELETE FROM bbdd_dentista." + tableName +" WHERE " + condicion;
			Statement statement = cn.createStatement();
			statement.executeUpdate(query);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modificar(String tableName, String[] valoresFinales, boolean AutoInc) {
		conectar();
		try {
			DatabaseMetaData metaData = (DatabaseMetaData) cn.getMetaData();
			ResultSet resultSet = metaData.getColumns(null, null, tableName, null);
			String columnNames = "";
			String valores = "";
			String[] ArrayC;
			String condicion = "";
			if (AutoInc == false) {
				while (resultSet.next()) {
					String columnName = resultSet.getString("COLUMN_NAME");
					columnNames += columnName + ",";
				}
				columnNames = columnNames.substring(0, columnNames.length() - 1);
				ArrayC = columnNames.split(",");
				valores = ArrayC[0] + "= '" + valoresFinales[0];
			} else {
				while (resultSet.next()) {
					String columnName = resultSet.getString("COLUMN_NAME");
					columnNames += columnName + ",";
				}
				columnNames = columnNames.substring(0, columnNames.length() - 1);
				ArrayC = columnNames.split(",");
				ArrayList<String> Columnas = new ArrayList<String>(Arrays.asList(ArrayC));
				Columnas.remove(0);
				StringBuilder str = new StringBuilder();
				for (String ColumnasDefinitivas : Columnas) {
					str.append(ColumnasDefinitivas);
					str.append(",");
				}
				columnNames = str.substring(0, str.length() - 1);
				ArrayC = columnNames.split(",");
				valores = ArrayC[0] + "=" + valoresFinales[0];
			}

			for (int i = 0; i < valoresFinales.length; i++) {
				String valor = ArrayC[i] + "=" + valoresFinales[i];
				condicion += valor + ",";
			}
			condicion = condicion.substring(0, condicion.length() - 1);

			String query = "UPDATE bbdd_dentista." + tableName + " SET " + valores + " WHERE " + condicion;
			Statement statement = cn.createStatement();
			statement.executeUpdate(query);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public JTable MostrarTabla(String TableName, JTable table) {
		conectar();
		try {
			String sql = "SELECT * FROM bbdd_dentista." + TableName;
			Statement st = cn.createStatement();
			ResultSet res = st.executeQuery(sql);

			DefaultTableModel model = new DefaultTableModel();

			// Obtén metadatos para agregar columnas
			ResultSetMetaData metaData = (ResultSetMetaData) res.getMetaData();
			int columnCount = metaData.getColumnCount();
			DatabaseMetaData Data = (DatabaseMetaData) cn.getMetaData();
			ResultSet resultSet;
			resultSet = Data.getColumns(null, null, TableName, null);

			String columnNames = "";
			while (resultSet.next()) {
				String columnName = resultSet.getString("COLUMN_NAME");
				columnNames += columnName + ",";
				model.addColumn(columnName);
			}
			String[] Array = columnNames.split(",");

			table.setModel(model);
			model.addRow(Array);
			// Agrega filas al modelo
			while (res.next()) {
				String[] rowData = new String[columnCount];
				for (int i = 1; i <= columnCount; i++) {
					rowData[i - 1] = res.getString(i);
				}
				model.addRow(rowData);
			}

			// Cierra recursos
			res.close();
			st.close();
			cn.close();

			// Establece el modelo en la tabla
			table.setModel(model);
			// Hace que no puedas editar la tabla
			for (int i = 0; i < columnCount; i++) {
				Class<?> col_class = table.getColumnClass(i);
				table.setDefaultEditor(col_class, null); // remove editor
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return table;
	}

	public String[] SacarValoresTabla(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String[] valores = new String[table.getColumnCount()];
		for (int i = 0; i < valores.length; i++) {
			valores[i] = String.valueOf(model.getValueAt(table.getSelectedRow(), i));
		}
		return valores;

	}

}
