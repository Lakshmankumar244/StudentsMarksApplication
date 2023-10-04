package com.StudentMarks.Faculty;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
public class Dao {
	static Connection con;	
	public static ResultSet selectAll(Dto dto) throws ClassNotFoundException, SQLException
	{	
		con=ConnectionFactory.getConnection();
		PreparedStatement pst=con.prepareStatement("select sname,scode,sid,tm1,om1,tm2,om2,fm from midmarks as m join facultydata as f on m.fid=f.fid where f.fid=?;");
		pst.setString(1,dto.getFid());
		return pst.executeQuery();
	}
	public static ResultSet selectRecord(Dto dto) throws ClassNotFoundException, SQLException
	{
		con=ConnectionFactory.getConnection();
		PreparedStatement pst=con.prepareStatement("SELECT * FROM MIDMARKS WHERE SID=? && FID=?");
		pst.setString(1, dto.getSid());
		pst.setString(2,dto.getFid());
		return pst.executeQuery();
		
	}
	public static int UpdateAll(Dto dto) throws ClassNotFoundException, SQLException
	{
		con=ConnectionFactory.getConnection();
		PreparedStatement pst=con.prepareStatement("UPDATE MIDMARKS SET OM1=?,OM2=? WHERE SID=? && FID=?");
			pst.setInt(1, dto.getOm1());
			pst.setInt(2, dto.getOm2());
			pst.setString(3, dto.getSid());
			pst.setString(4, dto.getFid());
		return pst.executeUpdate();
	}
	public static int DeleteAll(Dto dto) throws ClassNotFoundException, SQLException
	{
		con=ConnectionFactory.getConnection();
		PreparedStatement pst=con.prepareStatement("DELETE FROM STUDENTDATA WHERE SID=?");
		pst.setString(1, dto.getSid());
		return pst.executeUpdate();
	}
	public static int DeleteAll2(Dto dto) throws ClassNotFoundException, SQLException
	{
		con=ConnectionFactory.getConnection();
		PreparedStatement pst=con.prepareStatement("DELETE FROM MIDMARKS WHERE SID=?");
		pst.setString(1, dto.getSid());
		return pst.executeUpdate();
	}
	public static ResultSet StudentSelect(Dto dto) throws SQLException, ClassNotFoundException
	{
		con=ConnectionFactory.getConnection();
		PreparedStatement pst=con.prepareStatement("select sname,scode,f.fid,sid,tm1,om1,tm2,om2,fm from midmarks as m left join facultydata as f on m.fid=f.fid where sid=?;");
		pst.setString(1, dto.getSid());
		return pst.executeQuery();
	}
	public static int AdminStuRegistration(Dto dto) throws ClassNotFoundException, SQLException
	{
		con=ConnectionFactory.getConnection();
		PreparedStatement pst=con.prepareStatement("INSERT INTO STUDENTDATA VALUES(?,?,?,?,?,?)");
		pst.setString(1, dto.getSid());
		pst.setString(2, dto.getStuname());
		pst.setString(3, dto.getMobile());
		pst.setString(4,dto.getEmail());
		pst.setString(5, dto.getDept());
		pst.setString(6, dto.getSec());
		return pst.executeUpdate();
	}
	public static ResultSet adminLogin(Dto dto) throws ClassNotFoundException, SQLException
	{
		con=ConnectionFactory.getConnection();
		PreparedStatement pst=con.prepareStatement("SELECT * FROM ADMINDATA WHERE AID=? && PASSWORD=?");
		pst.setLong(1, dto.getAid());
		pst.setString(2, dto.getPassword());
		return pst.executeQuery();
	}
	public static ResultSet adminSelect() throws ClassNotFoundException, SQLException
	{
		con=ConnectionFactory.getConnection();
		PreparedStatement pst=con.prepareStatement("select f.sname,f.scode,m.sid,m.tm1,m.om1,m.tm2,m.om2,m.fm from midmarks as m left join facultydata as f on m.fid=f.fid;");
		return pst.executeQuery();
	}
	public static ResultSet facultyLogin(Dto dto) throws ClassNotFoundException, SQLException{
		con=ConnectionFactory.getConnection();
		PreparedStatement pst=con.prepareStatement("SELECT * FROM FACULTYDATA WHERE FID=? && SCODE=?");
		pst.setString(1, dto.getFid());
		pst.setString(2, dto.getScode());
		return pst.executeQuery();
	}
	public static ResultSet studentLogin(Dto dto) throws ClassNotFoundException, SQLException{
		con=ConnectionFactory.getConnection();
		PreparedStatement pst=con.prepareStatement("SELECT * FROM STUDENTDATA WHERE SID=? && MOBILE=?");
		pst.setString(1, dto.getSid());
		pst.setString(2, dto.getMobile());
		return pst.executeQuery();
	}
	public static int AdminStuRegistration2(Dto dto) throws ClassNotFoundException, SQLException
	{
		con=ConnectionFactory.getConnection();
		PreparedStatement pst=con.prepareStatement("insert into midmarks(sid,fid) values(?,1001),(?,1002),(?,1003),(?,1004),(?,1005);");
		pst.setString(1, dto.getSid());
		pst.setString(2, dto.getSid());
		pst.setString(3, dto.getSid());
		pst.setString(4, dto.getSid());
		pst.setString(5, dto.getSid());
		
		return pst.executeUpdate();
	}
	public static ResultSet getStudentData() throws ClassNotFoundException, SQLException
	{
		con=ConnectionFactory.getConnection();
		PreparedStatement pst=con.prepareStatement("SELECT * FROM STUDENTDATA;");
		return pst.executeQuery();
	}
	}

