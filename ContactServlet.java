package com.ps;


import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/contact")

public class ContactServlet extends HttpServlet {

    protected void doPost(

            HttpServletRequest request,

            HttpServletResponse response)

            throws ServletException, IOException {

        String name =
                request.getParameter("name");

        String email =
                request.getParameter("email");

        String phone =
                request.getParameter("phone");

        try{

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(

            "insert into contacts(name,email,phone) values(?,?,?)"

                    );

            ps.setString(1,name);

            ps.setString(2,email);

            ps.setString(3,phone);

            ps.executeUpdate();

            response.getWriter().print(

                "Contact Stored Successfully"

            );

        }
        catch(Exception e){

            e.printStackTrace();

        }

    }
}