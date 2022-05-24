package com.solvd.realestate.dao.Implemented;

import com.solvd.realestate.dao.IDAOAptEntity;
import com.solvd.realestate.entity.apt.AptEntity;
import com.solvd.realestate.exception.BadAddressException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AptEntityImplementedDAO implements IDAOAptEntity {

    final String GETONE = "SELECT * FROM aptentity WHERE idAirport = ?";
    final String GETALL = "SELECT * FROM aptentity";
    final String INSERT = "INSERT INTO aptentity (name, shortName) VALUES (?,?) ";

    private Connection conn;

    public AptEntityImplementedDAO(Connection conn){
        this.conn = conn;
    }

    public AptEntityImplementedDAO() {
    }

    public void closeRsPs(ResultSet rs, PreparedStatement ps){
        if (rs != null){
            try{
                rs.close();
            } catch (SQLException e) {
                new BadAddressException("Unable to close Result Set");
            }
        }
        if (ps != null){
            try{
                ps.close();
            } catch (SQLException e) {
                new BadAddressException("Unable to close Prepared Statement");
            }
        }
    }

    public AptEntity mapper(ResultSet rs) throws SQLException {

        AptEntity temp = new AptEntity();

        temp.setAptId(rs.getInt("aptid"));
        temp.setAddress(rs.getString("address"));
        temp.setCost(rs.getDouble("cost"));

        return temp;
    }

    @Override
    public AptEntity getById(Integer id) throws BadAddressException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        AptEntity a = null;
        try{
            ps = conn.prepareStatement(GETONE);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()){
                a = mapper(rs);
            }else{
                throw new BadAddressException("Return value is null");
            }
        } catch (SQLException e) {
            throw new BadAddressException("Error while executing SQL");
        }finally{
            closeRsPs(rs, ps);
        }
        System.out.println(a);
        return a;
    }

    @Override
    public List<AptEntity> getAll() throws BadAddressException {

            PreparedStatement ps = null;
            ResultSet rs = null;
            List<AptEntity> aptList = new ArrayList<>();
            try{
                ps = conn.prepareStatement(GETALL);
                rs = ps.executeQuery();

                while(rs.next()){
                    aptList.add(mapper(rs));
                }

            } catch (SQLException e) {
                throw new BadAddressException("Error while executing SQL");
            }finally{
                closeRsPs(rs, ps);
            }

            aptList.forEach((final AptEntity a) -> System.out.println(a));
            System.out.println();
            return aptList;
    }

    @Override
    public void save(AptEntity o) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        //for testing
        System.out.println(o.getAddress());
        System.out.println(o.getCost());
        try{
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, o.getAddress());
            ps.setInt(2, o.getAptId());
            if (ps.executeUpdate() == 0){
                throw new BadAddressException("Error processing SQL Statement");
            }
        } catch (SQLException e) {
            throw new BadAddressException("SQL Error");
        } finally {
            closeRsPs(rs, ps);
        }

    }

    @Override
    public void update(AptEntity o) {

    }

    @Override
    public void delete(Integer id) {

    }
}
