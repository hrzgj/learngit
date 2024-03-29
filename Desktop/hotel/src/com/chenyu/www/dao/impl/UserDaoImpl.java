package com.chenyu.www.dao.impl;
import com.chenyu.www.po.User;
import com.chenyu.www.util.DaoUtil;

import java.sql.*;
import java.util.ArrayList;

public class UserDaoImpl implements UserDao{
    private  static DaoUtil util =new DaoUtil();

    @Override
    //登录验证密码
    public User login(String userAccount,String password) {
        Connection con = util.getCon();
        PreparedStatement pstmt = null;
        try {
            String sql = "select * from user where user_account=? ";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userAccount);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                if( password.equals(rs.getString("user_password")))
                {
                    User user =new User();
                    user=load(user,rs);
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(pstmt, con);

        }
        return null;
    }

    //注册，将用户信息传入数据库
   @Override
    public Boolean register(String userName, String usePassword, String phone,String userAccount,String userIdNumber) {
        Connection con =util.getCon();
        PreparedStatement pstmt=null;
       int t = 0;
        String sql = "insert into user values(0,?,?,?,0,?,?)";
       try {
           pstmt=con.prepareStatement(sql);
           pstmt.setString(1,userName);
           pstmt.setString(2,userAccount);
           pstmt.setString(3,phone);
           pstmt.setString(4,usePassword);
           pstmt.setString(5,userIdNumber);
           t=pstmt.executeUpdate();
       } catch (SQLException e) {
           e.printStackTrace();
       }finally {
           util.close(pstmt,con);
       }
       if (t !=0) {
           return true;
       } else {
           return false;
       }

    }

    //从数据库寻找是否有该用户账户
    @Override
    public Boolean findAccount(String userAccount) {
        Connection con = util.getCon();
        PreparedStatement pstmt = null;
        try {
            String sql = "select * from user where user_account=? ";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userAccount);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next())
            return  true;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(pstmt,con);
        }

        return false;
    }

    //用户身份的判断
    @Override
    public User loginIdentity(String userAccount)
    {
        Connection con = util.getCon();
        PreparedStatement pstmt = null;
        try {
            String sql = "select * from user where user_account=? ";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userAccount);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                User u = new User();
                if(rs.getInt("user_identity")==0)
                {
                    u.setIdentity("普通用户");
                }
                if(rs.getInt("user_identity")==1)
                {
                    u.setIdentity("管理员");
                }
                return  u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(pstmt, con);

        }
        return null;
    }

    //从数据库找出所有用户
    @Override
    public ArrayList<User> getMaterialsList() {
        ArrayList<User> list = new ArrayList<>();
        Connection con=util.getCon();
        PreparedStatement pstmt =null;
        String sql ="select * from user";

        try {
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
               User user =new User();
               user= load(user,rs);
               list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            util.close(pstmt,con);
        }
        return list;
    }

    //从数据库找出指定的用户
    @Override
    public User load(User user, ResultSet rs) throws SQLException {
        user.setId(rs.getInt("user_id"));
        user.setUserName(rs.getString("user_name"));
        user.setUserAccount(rs.getString("user_account"));
        user.setUserPhone(rs.getString("user_phone"));
        user.setUserIdNumber(rs.getString("user_idnumber"));
        if(rs.getInt("user_identity")==0)
        {
            user.setIdentity("普通用户");
        }
        if(rs.getInt("user_identity")==1)
        {
            user.setIdentity("管理员");
        }
        return  user;
    }

    //修改数据库的指定用户信息
    @Override
    public Boolean update(User user)
    {
        Connection con=util.getCon();
        PreparedStatement psmt =null;
        int t = 0;

        try {
            String sql="update user set user_name=?,user_phone=?,user_password=?,user_idnumber=? where user_account=?";
            psmt=con.prepareStatement(sql);
            psmt.setString(1,user.getUserName());
            psmt.setString(2,user.getUserPhone());
            psmt.setString(3,user.getUserPassword());
            psmt.setString(4,user.getUserIdNumber());
            psmt.setString(5,user.getUserAccount());
            t=psmt.executeUpdate();
            if(t!=0)
            {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(psmt,con);
        }
        return null;

    }

    //修改数据库指定用户信息但不修改密码
    @Override
    public Boolean updateWithoutPassword(User user) {
        Connection con=util.getCon();
        PreparedStatement psmt=null;
        String sql="update user set user_name=?,user_phone=?,user_idnumber=? where user_account=?";
        int t=0;
        try {
            psmt=con.prepareStatement(sql);
            psmt.setString(1,user.getUserName());
            psmt.setString(2,user.getUserPhone());
            psmt.setString(3,user.getUserIdNumber());
            psmt.setString(4,user.getUserAccount());
            t=psmt.executeUpdate();
            if(t!=0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(psmt,con);
        }

            return  false;
    }

    //找出数据库中用户的身份
    @Override
    public int findIdentity(String userAccount) throws SQLException {
        Connection con=util.getCon();
        PreparedStatement psmt=null;
        String sql="select * from user where user_account=?";

        try {
            psmt=con.prepareStatement(sql);
            psmt.setString(1,userAccount);
            ResultSet rs=psmt.executeQuery();
            if(rs.next())
            {
                return  rs.getInt("user_identity");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(psmt,con);

        }

        return -1;
    }

    //更新用户身份
    @Override
    public Boolean updateAdmin(String userAccount, int userIdentity) {
        Connection con=util.getCon();
        PreparedStatement psmt=null;
        String sql ="update user set user_identity=? where user_account=?";
        try {
            psmt=con.prepareStatement(sql);
            psmt.setInt(1,userIdentity);
            psmt.setString(2,userAccount);
            if(psmt.executeUpdate()!=0)
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User findUser(int id) {
        Connection connection=util.getCon();
        PreparedStatement preparedStatement=null;
        String sql="select * from user where user_id=?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next())
            {
                User user = new User();
                user=load(user,resultSet);
                return  user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(preparedStatement,connection);
        }
        return  null;
    }


}

