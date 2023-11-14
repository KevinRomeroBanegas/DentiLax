package interfaz;

import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.swing.JOptionPane;

import com.mysql.jdbc.DatabaseMetaData;

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
		Resultado = stm.executeQuery("SELECT RolAdmin FROM bbdd_dentista.usuario where DNI='"+Nombre+"' && Contraseña='"+Cont+"';");
		if (Resultado.next()) {
			boolean i = Resultado.getBoolean("RolAdmin");
			if (i == true) {
				ent=1;
			} else {
				ent=0;
			}
		} else {
		}
		return ent;
	}

	public String insertarCita(String nombre, String nombreDoctor, String tratamientoNombre, java.util.Date date,
			String Obs) {
		String result = "";
		try {
			this.conectar();
			stm.executeUpdate(
					"INSERT INTO bbdd_dentista.cita (DniClientes, IdDoctor, IdTratamiento, Fecha, Observaciones) VALUES ('"
							+ nombre + "','" + nombreDoctor + "','" + tratamientoNombre + "','" + date + "','" + Obs
							+ "')");
			stm.close();
			cn.close();
			result = "Ok";
		} catch (Exception e) {
			result = "No";
		}
		return result;
	}

	public String crearCliente(String DNI, String nombre, int Edad, String Email, String Direccion, String Ciudad,
			int Telefono) {
		String Direccion_Completa = Direccion + ", " + Ciudad;
		String result = "";
		try {
			this.conectar();
			stm.executeUpdate("INSERT INTO bbdd_dentista.cliente VALUES ('" + DNI + "','" + nombre + "', '"
					+ Direccion_Completa + "', " + Telefono + ", " + Edad + ", '" + Email + "');");
			stm.close();
			cn.close();
			result = "Ok";
		} catch (Exception e) {
			result = "No";
		}
		return result;
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
	
    public void insertar(String tableName, String [] valores, boolean AutoInc) {
        conectar();
        try {
            DatabaseMetaData metaData = (DatabaseMetaData) cn.getMetaData();
            ResultSet resultSet = metaData.getColumns(null, null, tableName, null);
            String columnNames = "";
            String valoresFinales="";

            if(AutoInc==false) {
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
            	String []ArrayC=columnNames.split(",");
            	ArrayList <String>Columnas=new ArrayList<String>(Arrays.asList(ArrayC));
            	Columnas.remove(0);
            	StringBuilder str = new StringBuilder();
                for (String ColumnasDefinitivas : Columnas) {
                  str.append(ColumnasDefinitivas);
                  str.append(",");
                }
                columnNames = str.substring(0, str.length() - 1);
            	}

            

            Statement statement = cn.createStatement();
            for(int i=0; i<valores.length; i++) {
            	String valor = valores[i].toString();
                valoresFinales += valor + ",";
            }
            valoresFinales = valoresFinales.substring(0, valoresFinales.length() - 1);
            String query = "INSERT INTO bbdd_dentista." + tableName + " (" + columnNames + ") VALUES (" + valoresFinales + ")";
            statement.executeUpdate(query);
            statement.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public String modificarCliente(String dNI, String nombre, int edad, String email, String direccion, String ciudad, int tel) {
		String Direccion_Completa = direccion + ", " + ciudad;
		String result = "";
		try {
			this.conectar();
			stm.executeUpdate("UPDATE bbdd_dentista.cliente SET Nombre='"+nombre+"', Direccion='"+Direccion_Completa+"', Edad="+edad+", Telefono="+tel+", Email='"+email+"' WHERE DNI='"+dNI+"'");
			stm.close();
			cn.close();
			result = "Ok";
		} catch (Exception e) {
			result = "No";
		}
		return result;
	}

}
