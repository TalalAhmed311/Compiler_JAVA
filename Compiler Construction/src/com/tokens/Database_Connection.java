package com.tokens;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;



class Scope{
	
	String KW;
	int scope;
	int isLoop;
	
	public Scope(String KW,int scope,int isloop) {

		this.KW=KW;
		this.scope=scope;
		this.isLoop=isloop;
	}
}


class Type_MT{

	String type;
	String cat;
	String parent;
	int id;
	String name;
	
	public Type_MT(int id, String name, String type,String cat,String parent) {

		this.id=id;
		this.name=name;
		this.type=type;
		this.cat=cat;
		this.parent=parent;
		
		
	}
}

class Type_DT{
	
	int mainid;
	int f_id;
	String name;
	String type;
	String accessMod;
	String typeMod;
	int isStatic;
	String parent;
	
	public Type_DT(int main_id,int f_id,String name,String type,String accessMod,String typeMod,int isStatic,String parent) {

		this.mainid=main_id;
		this.f_id=f_id;
		this.name=name;
		this.type=type;
		this.accessMod=accessMod;
		this.typeMod=typeMod;
		this.isStatic=isStatic;
		this.parent=parent;
	
	}
}

class Type_FT{
	
	int id;
	String name;
	String type;
	String typeMod;
	
	public Type_FT(int id, String name, String type, String typeMod) {
		
		this.id = id;
		this.name = name;
		this.type = type;
		this.typeMod = typeMod;
	}
	
}


public class Database_Connection {

	private static Connection con;
	private static PreparedStatement pst;
	private static Statement st;
	private static ResultSet rSet;
	static ArrayList<ArrayList<String>> tokenSet = new ArrayList<ArrayList<String>>();

	private static ArrayList<ArrayList<String>> OP = new ArrayList<ArrayList<String>>();
	static { 
		OP.add(new ArrayList<String>(Arrays.asList("++","inc_dec")));
		OP.add(new ArrayList<String>(Arrays.asList("--","inc_dec")));
		OP.add(new ArrayList<String>(Arrays.asList("*","MDM")));
		OP.add(new ArrayList<String>(Arrays.asList("/","MDM")));
		OP.add(new ArrayList<String>(Arrays.asList("%","MDM")));
		OP.add(new ArrayList<String>(Arrays.asList("+","PM")));
		OP.add(new ArrayList<String>(Arrays.asList("-","PM")));
		OP.add(new ArrayList<String>(Arrays.asList("<","ROP")));
		OP.add(new ArrayList<String>(Arrays.asList(">","ROP")));
		OP.add(new ArrayList<String>(Arrays.asList("<=","ROP")));
		OP.add(new ArrayList<String>(Arrays.asList(">=","ROP")));
		OP.add(new ArrayList<String>(Arrays.asList("==","ROP")));
		OP.add(new ArrayList<String>(Arrays.asList("!=","ROP")));
		OP.add(new ArrayList<String>(Arrays.asList("&&","AND")));
		OP.add(new ArrayList<String>(Arrays.asList("||","OR")));
		OP.add(new ArrayList<String>(Arrays.asList("=","=")));
		OP.add(new ArrayList<String>(Arrays.asList("+=","CAO")));
		OP.add(new ArrayList<String>(Arrays.asList("/=","CAO")));
		OP.add(new ArrayList<String>(Arrays.asList("-=","CAO")));
		OP.add(new ArrayList<String>(Arrays.asList("*=","CAO")));
		OP.add(new ArrayList<String>(Arrays.asList("%=","CAO")));
	}
	
	
	static {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/semantics", "root", "ROOT_talalahmed123");
			st=con.createStatement();
			
		    tokenSet = new Lexical_Analyzer().getTokens();
		    
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static int FT_id=20000; //20000-3000 for function and data_table both
	static int MT_id=1;// 1-10000
	
	
	int create_dataTable() {
		return MT_id++;
	}
	
	int create_funTable() {
		return FT_id++;
	}
	
	void deleteErntries() {
		try {
			
			pst=con.prepareStatement("delete from function_table;");
			pst.executeUpdate();
			
			pst=con.prepareStatement("delete from data_table;");
			pst.executeUpdate();
		
			
			pst=con.prepareStatement("delete from main_table;");
			pst.executeUpdate();
		
			pst=con.prepareStatement("delete from scope;");
			pst.executeUpdate();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Scope 
	
	void createScope(String KW,int scope,int isLoop) {
		
		try {
			
			pst=con.prepareStatement("insert into scope values(?,?,?)");
			pst.setString(1, KW);
			pst.setInt(2, scope);
			pst.setInt(3, isLoop);
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	Scope getScope() {
		
		try {
			
			rSet=st.executeQuery("select * from scope;");
			if(rSet.next()==true) {
				
				return new Scope(rSet.getString(1),rSet.getInt(2),rSet.getInt(3));
			}
			
		} catch (Exception e) {
				
			e.printStackTrace();
		
		}
		
		return null;
	}
	
	
	void destroyScope() {
		
		try {
			
			pst=con.prepareStatement("delete from scope order by scope desc limit 1;");
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//CR
	boolean insert_MT(int CR,String name,String type,String cat,String parent) {
		
		String query1="select * from main_table where name= binary'"+name+"';";
		
		
		String query="insert into main_table values(?,?,?,?,?);";
		try {
		
			rSet=st.executeQuery(query1);
			if(rSet.next()==true) {
				
				return false;
			}else {
			
			pst = con.prepareStatement(query);
			pst.setInt(1, CR);
			pst.setString(2, name);
			pst.setString(3, type);
			pst.setString(4, cat);
			pst.setString(5, parent);
			pst.executeUpdate();
			return true;
			

			}
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	boolean insert_DT(int id,int f_id,String name,String type,String accessModifier,String typeModifier,int isStatic, String parent) {
		
		String query1="select * from data_table where main_id="+id+";";
		String query3="select * from data_table where name=binary'"+name+"' and main_id='"+id+"';";
		
		String query="insert into data_table values(?,?,?,?,?,?,?,?);";
		
		
		try {
			
			rSet=st.executeQuery(query1);
			
			if (f_id!=0) {
				
				while (rSet.next()) {
					
					if (rSet.getInt(2)!=0) {

						String t=rSet.getString(4);
						String query2="select * from data_table where name=binary'"+name+"' and type=binary'"+t+"' and main_id="+id;

						ResultSet set=st.executeQuery(query2);
						if (set.next()==true) {
							return false;
						}
						
					}
					
				}
			}else {
				rSet=st.executeQuery(query3);
				if(rSet.next()==true) {
					return false;
				}
			}
			
			
		
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			pst.setInt(2, f_id);
			pst.setString(3, name);
			pst.setString(4, type);
			pst.setString(5, accessModifier);
			pst.setString(6, typeModifier);
			pst.setInt(7, isStatic);
			pst.setString(8, parent);
			
			pst.executeUpdate();
		
			return true;

		
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	boolean insert_FT(int id,String name, String type, String typeMod) {
		
		try {
			

			String query1="select * from function_table where name=binary'"+name+"' and f_id="+id+";";
			String query="insert into function_table values (?,?,?,?)";
			
			rSet=st.executeQuery(query1);
			if(rSet.next()==true) {
			
				return false;
			}else {
			
			pst=con.prepareStatement(query);
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, type);
			pst.setString(4, typeMod);
			pst.executeUpdate();
			return true;
	
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
		return false;
	}
	
	// On the basis of ID
	
	static Type_MT lookUp_MT(int id) {
	
		
		try {
			
			rSet=st.executeQuery("select * from main_table where ID="+id+";");
		
			if(	rSet.next()!=false) {
				
				return new Type_MT(rSet.getInt(1),rSet.getString(2),rSet.getString(3),rSet.getString(4),rSet.getString(5));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	

	static Type_MT lookUp_MT(String name) {
	
		
		try {
			
			rSet=st.executeQuery("select * from main_table where name= binary'"+name+"';");

			if(rSet.next()!=false) {
				
				return new Type_MT(rSet.getInt(1),rSet.getString(2),rSet.getString(3),rSet.getString(4),rSet.getString(5));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	static Type_DT lookUp_fn_DT(int id,String name,String pl) {
		
		try {
			
			
			rSet=st.executeQuery("select * from data_table where name=binary'"+name+"' and main_id="+id+" and type=binary'"+pl+"';");
			
			if(rSet.next()!=false) {
				
				return new Type_DT(rSet.getInt(1),rSet.getInt(2),rSet.getString(3),rSet.getString(4),rSet.getString(5)
						,rSet.getString(6),rSet.getInt(7),rSet.getString(8));
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

	static Type_DT lookUp_fn_DT(int id) {
		
		try {
			
			
			rSet=st.executeQuery("select * from data_table where f_id="+id+";");
			
			if(rSet.next()!=false) {
				
				return new Type_DT(rSet.getInt(1),rSet.getInt(2),rSet.getString(3),rSet.getString(4),rSet.getString(5)
						,rSet.getString(6),rSet.getInt(7),rSet.getString(8));
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	static Type_DT lookUp_att_DT(int id,String name) {
		
		try {
			
			
			rSet=st.executeQuery("select * from data_table where name=binary'"+name+"' and main_id='"+id+"';");
			
			if(rSet.next()!=false) {
				return new Type_DT(rSet.getInt(1),rSet.getInt(2),rSet.getString(3),rSet.getString(4),rSet.getString(5)
						,rSet.getString(6),rSet.getInt(7),rSet.getString(8));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	static Type_DT lookUp_C_DT(int id,String name) {
		
		try {
			
			
			rSet=st.executeQuery("select * from data_table where name=binary'"+name+"' and main_id='"+id+"';");
			
			if(rSet.next()!=false) {
				
				return new Type_DT(rSet.getInt(1),rSet.getInt(2),rSet.getString(3),rSet.getString(4),rSet.getString(5)
						,rSet.getString(6),rSet.getInt(7),rSet.getString(8));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	static Type_FT lookUp_FT(int id, String name) {
		
		
		try {
			
			
			rSet=st.executeQuery("select * from function_table where name= binary'"+name+"' and f_id="+id+";");
			
		
			if(rSet.next()!=false) {
				
				return new Type_FT(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	static String compatibility(String operandType) {

		if(operandType.equals("int") ||operandType.equals("float") || operandType.equals("char")
				|| operandType.equals("short") || operandType.equals("long")) {
		
	         		
			
			return operandType;
		}
		
		return null;
	}
	


	static String compatibility(String leftType,String rightType, String op) {

		if(leftType.equals("String") && rightType.equals("String")) {
		
			if(op.equals("!=") || op.equals("==") || op.equals("+") || op.equals("+=") || op.equals("=")) {
				return "String";
			}
		}else if(leftType.equals("bool") && rightType.equals("bool") ){
		
			if(op.equals("&&") || op.equals("||") || op.equals("=")) {
				return "bool";
			}
			
		}else {
		
			op=isOP(op);
			try {
				rSet=st.executeQuery("select resultant from compatible where leftType=binary'"+leftType+"' and rightType=binary'"+rightType+"' and operator=binary'"+op+"';");
				
				if(rSet.next()!=false) {
					
					return rSet.getString(1);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	
		
		return null;
	}
	
	static int get_FR() {
		
		try {
			
			if(rSet.next()) {
				
				rSet=st.executeQuery("select f_id from data_table order by f_id desc limit 1;");
				
				
				rSet.next();
				return rSet.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	private static String isOP (String word) {
		
		String Class = "";
		for (int i = 0; i < OP.size(); i++) {
			
			if(OP.get(i).get(0).equals(word)) {
				Class = OP.get(i).get(1);
			}
		}
		return Class;
	}
	

}