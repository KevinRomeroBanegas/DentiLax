package interfaz;

import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.RowFilter;

import java.util.Arrays;
import java.util.Collection;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

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

	public ArrayList consultaEspecialidades() throws SQLException {
		ArrayList dato = new ArrayList();
		this.conectar();
		Resultado = stm.executeQuery("select * from bbdd_dentista.especialidad");
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
				"select * from bbdd_dentista.doctor where especialidad_Nombre=(select Especialidad from bbdd_dentista.tratamiento where Nombre='"
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
			System.out.println(query);
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
				condicion += valor + " AND ";
			}
			condicion = condicion.substring(0, condicion.length() - 4);

			String query = "DELETE FROM bbdd_dentista." + tableName + " WHERE " + condicion;
			System.out.println(query);
			Statement statement = cn.createStatement();
			statement.executeUpdate(query);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modificar(String tableName, String[] valoresFinales, boolean AutoInc, JTable table) {
		conectar();
		try {
			DatabaseMetaData metaData = (DatabaseMetaData) cn.getMetaData();
			ResultSet resultSet = metaData.getColumns(null, null, tableName, null);
			String columnNames = "";
			String valoresNames = "";
			String v = "";
			String[] valores = SacarValoresTabla(table);
			String[] ArrayC;
			String condicion = "";
			if (AutoInc == false) {
				while (resultSet.next()) {
					String columnName = resultSet.getString("COLUMN_NAME");
					columnNames += columnName + ",";
				}
				columnNames = columnNames.substring(0, columnNames.length() - 1);
				ArrayC = columnNames.split(",");
				ArrayList<String> val = new ArrayList<String>(Arrays.asList(valores));
				StringBuilder str = new StringBuilder();
				for (String ColumnasDefinitivas : val) {
					str.append(ColumnasDefinitivas);
					str.append(",");
				}
				valoresNames = str.substring(0, str.length() - 1);
				valores = valoresNames.split(",");
			} else {
				ArrayList<String> val = new ArrayList<String>(Arrays.asList(valores));
				val.remove(0);
				StringBuilder str = new StringBuilder();
				for (String ColumnasDefinitivas : val) {
					str.append(ColumnasDefinitivas);
					str.append(",");
				}
				valoresNames = str.substring(0, str.length() - 1);
				valores = valoresNames.split(",");
				while (resultSet.next()) {
					String columnName = resultSet.getString("COLUMN_NAME");
					columnNames += columnName + ",";
				}
				columnNames = columnNames.substring(0, columnNames.length() - 1);
				ArrayC = columnNames.split(",");
				ArrayList<String> Columnas = new ArrayList<String>(Arrays.asList(ArrayC));
				Columnas.remove(0);
				StringBuilder strColumnas = new StringBuilder();
				for (String ColumnasDefinitivas : Columnas) {
					strColumnas.append(ColumnasDefinitivas);
					strColumnas.append(",");
				}
				columnNames = strColumnas.substring(0, strColumnas.length() - 1);
				ArrayC = columnNames.split(",");
			}

			for (int i = 0; i < valoresFinales.length; i++) {
				String valor = ArrayC[i] + "=" + valoresFinales[i];
				condicion += valor + ",";
			}
			condicion = condicion.substring(0, condicion.length() - 1);

			for (int i = 0; i < valores.length; i++) {
				String valor = ArrayC[i] + "= '" + valores[i] + "'";

				v += valor + "AND ";
			}
			v = v.substring(0, v.length() - 4);

			String query = "UPDATE bbdd_dentista." + tableName + " SET " + condicion + " WHERE " + v;
			System.out.println(query);
			Statement statement = cn.createStatement();
			statement.executeUpdate(query);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void obtenerCantidadActual(String tableNa, String idStock) {

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

	public void filtro(String consulta, JTable jtableBuscar) {
		DefaultTableModel dm = new DefaultTableModel();
		dm = (DefaultTableModel) jtableBuscar.getModel();
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
		jtableBuscar.setModel(dm);
		jtableBuscar.setRowSorter(tr);
		int[] indices = { 0 }; // Aquí, 0 representa la primera columna
		tr.setRowFilter(RowFilter.regexFilter(consulta, indices));

	}

	public void CambiarContraseña(String DNI) {
		this.conectar();
		try {
			String contraseña = "'" + JOptionPane.showInputDialog("Añada la nueva contraseña") + "'";
			String query = "UPDATE bbdd_dentista.usuario SET Contraseña=" + contraseña + " WHERE DNI='" + DNI + "'";
			Statement statement;

			statement = cn.createStatement();

			statement.executeUpdate(query);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int sacarIdCita(JTable table) {
		this.conectar();
		int idCita = 0;

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int rowCount = model.getRowCount();

		if (rowCount > 0) {
			for (int i = 0; i < 1; i++) {
				Object valor = model.getValueAt(rowCount - 1, i);
				idCita = Integer.parseInt(valor.toString());
			}
		}
		return idCita;
	}

	public String buscarCliente(String Nombre) {
		this.conectar();
		ResultSet Resultado;
		String DNI_cliente = "";
		int contador = 0;
		try {
			Resultado = stm.executeQuery("select DNI from bbdd_dentista.cliente WHERE Nombre='" + Nombre + "'");
			while (Resultado.next()) {
				DNI_cliente = Resultado.getString("DNI");
				contador++;
			}
			if (contador >= 2) {
				String Edad = "" + JOptionPane.showInputDialog(
						"Vaya, parece que hay más de un cliente con ese nombre, escriba la edad para filtrar con más exactitud")
						+ "";
				Resultado = stm.executeQuery(
						"select DNI from bbdd_dentista.cliente WHERE Nombre='" + Nombre + "' AND Edad=" + Edad + "");
				while (Resultado.next()) {
					DNI_cliente = Resultado.getString("DNI");
				}
			} else if (contador == 0) {
				JOptionPane.showMessageDialog(null, "No existe ningún usuario con ese nombre", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
			stm.close();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DNI_cliente;

	}

	public boolean existeCita(String[] valores) {
		boolean existe = false;
		this.conectar();

		try {
			String query = "SELECT * FROM bbdd_dentista.cita WHERE DniClientes=" + valores[0] + " AND NombreDoctor="
					+ valores[1] + " AND NombreTrat=" + valores[2] + " AND Fecha=" + valores[3] + " AND Hora="
					+ valores[4] + " AND Observaciones=" + valores[5] + "";

			System.out.println(query);

			Resultado = stm.executeQuery(query);

			if (Resultado.next()) {
				existe = true;
			} else {

			}

		} catch (SQLException e) {
			// Manejar la excepción de manera adecuada
			e.printStackTrace();
		}
		return existe;
	}

	public boolean buscarOdontograma(String dni) {
		boolean existe = false;
		this.conectar();

		try {
			Resultado = stm.executeQuery("select * from bbdd_dentista.odontograma WHERE DNI_cliente='" + dni + "'");

			if (Resultado.next()) {
				existe = true;
			} else {
				existe = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existe;
	}

	public String infoDiente(String Columna, String DNI) {
		String Descripcion = "";
		this.conectar();
		ResultSet Resultado;
		try {

			String query = "select " + Columna + " from bbdd_dentista.odontograma WHERE DNI_cliente='" + DNI + "'";

			System.out.println(query);

			Resultado = stm.executeQuery(query);

			if (Resultado.next()) {
				Descripcion = Resultado.getString("" + Columna + "");
			} else {

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Descripcion;

	}

	public boolean colorDiente(String dni, String columna) {
		boolean existe = false;
		this.conectar();
		String Descripcion = " ";
		ResultSet Resultado;

		try {
			Resultado = stm.executeQuery(
					"select " + columna + " from bbdd_dentista.odontograma WHERE DNI_cliente='" + dni + "'");

			if (Resultado.next()) {
				Descripcion = Resultado.getString("" + columna + "");
				if (Descripcion == null) {
					existe = false;
				} else {
					existe = true;
				}
			} else {

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existe;
	}

	public void modificarOdontograma(String columna, String Descripcion, String DNI) {
		this.conectar();
		try {
			String query = "UPDATE bbdd_dentista.odontograma SET " + columna + "='" + Descripcion
					+ "' WHERE DNI_cliente='" + DNI + "'";
			System.out.println(query);
			Statement statement;

			statement = cn.createStatement();

			statement.executeUpdate(query);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void crearOdontograma(String DNI) {
		this.conectar();
		try {
			String query = "INSERT INTO bbdd_dentista.odontograma (DNI_cliente) VALUES (" + DNI + ")";
			System.out.println(query);
			Statement statement;
			statement = cn.createStatement();
			statement.executeUpdate(query);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void borrarOdontograma(String DNI) {
		this.conectar();
		try {
			String query = "DELETE FROM bbdd_dentista.odontograma WHERE DNI_cliente=" + DNI;
			System.out.println(query);
			Statement statement;
			statement = cn.createStatement();
			statement.executeUpdate(query);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void tramitarProductos(String id, String cant) {
		int Descripcion = 0;
		this.conectar();
		ResultSet Resultado;
		try {
			String query = "SELECT Cantidad FROM bbdd_dentista.stock WHERE idStock='" + id + "'";
			System.out.println(query);
			Resultado = stm.executeQuery(query);

			if (Resultado.next()) {
				Descripcion = Resultado.getInt("Cantidad");
				int suma = Descripcion + Integer.parseInt(cant);
				String querydos = "UPDATE bbdd_dentista.stock SET Cantidad=" + suma + " WHERE idStock='" + id + "'";
				System.out.println(querydos);

				// Utiliza executeUpdate en lugar de executeQuery para realizar la actualización
				int filasActualizadas = stm.executeUpdate(querydos);

				if (filasActualizadas > 0) {
					System.out.println("Actualización exitosa");
				} else {
					System.out.println("No se pudo actualizar la cantidad");
				}
			} else {
				// Manejo para el caso en que no se encuentra el ID en la base de datos
				System.out.println("Producto no encontrado");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean existeSolicitud() {
		boolean existe = false;
		this.conectar();

		try {
			String query = "SELECT * FROM bbdd_dentista.solicitud_material";

			System.out.println(query);

			Resultado = stm.executeQuery(query);

			if (Resultado.next()) {
				existe = true;
			} else {

			}

		} catch (SQLException e) {
			// Manejar la excepción de manera adecuada
			e.printStackTrace();
		}
		return existe;
	}

}
