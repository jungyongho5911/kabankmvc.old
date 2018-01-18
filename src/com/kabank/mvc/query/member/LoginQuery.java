package com.kabank.mvc.query.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DML;
import com.kabank.mvc.enums.MemberProps;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;

public class LoginQuery implements IQuery{
    PreparedStatement pstmt;
    
    public LoginQuery() {
            try {
                pstmt = DataBaseFactory.create(Vendor.ORACLE)
                        .getConnection()
                        .prepareStatement(
                                DML.SELECT
                                +" "
                                +"id,"
                                +"pass,"
                                +"name,"
                                +"ssn,"
                                +"phone,"
                                +"email,"
                                +"profile,"
                                +"addr "
                                +DML.FROM
                                +" Member "
                                +DML.WHERE
                                +" id LIKE ? AND pass LIKE ?");
                String[] arr = InitCommand.cmd.getData().split("/");
                for(int i=0;i<arr.length;i++) {
                    pstmt.setString((i+1), arr[i]);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @Override
    public Object execute() {
        MemberBean member = null;
        try {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                member = new MemberBean();
                member.setId(rs.getString(MemberProps.ID.toString()));
                member.setPass(rs.getString(MemberProps.PASS.toString()));
                member.setName(rs.getString(MemberProps.NAME.toString()));
                member.setEmail(rs.getString(MemberProps.EMAIL.toString()));
                member.setAddr(rs.getString(MemberProps.ADDR.toString()));
                member.setPhone(rs.getString(MemberProps.PHONE.toString()));
                member.setSsn(rs.getString(MemberProps.SSN.toString()));
                member.setProfile(rs.getString(MemberProps.PROFILE.toString()));
            }
            System.out.println(member);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return member;
    }
}
