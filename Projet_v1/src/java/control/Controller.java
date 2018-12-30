/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jee.model.DB;
import jee.model.Employee;
import jee.model.User;

/**
 *
 * @author Jacques
 */
public class Controller extends HttpServlet {

    ArrayList<Employee> listEmployees;
    ArrayList<User> listUsers;
    String queryEmployees;
    String queryUser;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        DB.connect();
        
        HttpSession session = request.getSession();
        
        //Identify the form
        String action = request.getParameter("action");
        
        //First request
        if (action == null) {
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
        } 
        
        /******************** Login Page Section **********************/
        
        //Login
        else if (action.equals("login")) {
            //Get user input
            String loginEntered = request.getParameter("login");
            String pwdEntered = request.getParameter("password");
            
            //Compare credentials only if the user has entered something. Otherwise redirect to login page.
            if (loginEntered == null || loginEntered.isEmpty() || pwdEntered == null || pwdEntered.isEmpty()) {
                //Message d'erreur  
                request.setAttribute("err", "You must enter values in both fields");
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
            }
            
            else {
                try {
                    //Correct credentials: redirect to employeeList.jsp
                    if (DB.login(loginEntered, pwdEntered)) {
                        //the object EmployeeList is set in session scope because it is required many times
                        session.setAttribute("employeesList", DB.getListEmployee());
                        request.getRequestDispatcher("WEB-INF/employeeList.jsp").forward(request, response);
                    }
                    else {
                        //Error message: redirect to login.jsp
                        request.setAttribute("err", "Connection failed! Verify your login/password and try again");
                        request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
                    }
                } catch (SQLException ex) {
                    //Todo: handling ex
                    ex.printStackTrace();
                }
            }
        }
        
        /*********************************************************/
        
        /******************** EmployeeList Page Section **********************/
        
        //Add Employee Btn
        else if (action.equals("listAddBtn")) {
            request.getRequestDispatcher("WEB-INF/employeeDetails.jsp").forward(request, response);
        }
        
        //Delete Employee Btn
        else if (action.equals("listDeleteBtn")) {
            String selectedID = request.getParameter("selector");
           
            //No employee selected
            if (selectedID == null || selectedID.isEmpty()) {
                request.getRequestDispatcher("WEB-INF/employeeList.jsp").forward(request, response);
            }
            
            try {
                DB.removeEmployee(Integer.parseInt(selectedID));
                //Update employee list var in session scope
                session.setAttribute("employeesList", DB.getListEmployee());
                request.getRequestDispatcher("WEB-INF/employeeList.jsp").forward(request, response);
            } catch (SQLException ex) {
                //todo
                ex.printStackTrace();
            }
        }
        
        //Display Employee details Btn
        else if (action.equals("listDetailsBtn")) {
            String selectedID = request.getParameter("selector");

            //No Employee Selected : relaod page
            if (selectedID == null || selectedID.isEmpty()) {
                request.getRequestDispatcher("WEB-INF/employeeList.jsp").forward(request, response);
            }
            
            //Employee selected, redirect to details page. Send concerned employee along.
            else {
                try {
                    Employee emp = DB.getEmployee(Integer.parseInt(selectedID));
                    request.setAttribute("employee", emp);
                    request.getRequestDispatcher("WEB-INF/employeeDetails.jsp").forward(request, response);
                } catch (SQLException ex) {
                    //Todo: handle ex
                    ex.printStackTrace();
                }
            }
        }
        
        /**********************************************************/
        
        /******************** Employee Details Page Section **********************/
        
        //Employee Details: Cancel Button
        else if (action.equals("cancelDetails")) {
            request.getRequestDispatcher("WEB-INF/employeeList.jsp").forward(request, response);
        }
        
        //Employee Details: Create Employee (save Btn)
        else if (action.equals("createEmployee")) {
            String lastName = request.getParameter("lastName");
            String firstName = request.getParameter("firstName");
            String homePhone = request.getParameter("homePhone");
            String mobilePhone = request.getParameter("mobilePhone");
            String proPhone = request.getParameter("proPhone");
            String address = request.getParameter("address");
            String zipCode = request.getParameter("zipCode");
            String city = request.getParameter("city");
            String email = request.getParameter("email");
            
            try {
                DB.addEmployee(lastName, firstName, homePhone, mobilePhone,
                       proPhone, address, zipCode, city, email);
                //Update employeeList attribute in session
                session.setAttribute("employeesList", DB.getListEmployee());
                request.getRequestDispatcher("WEB-INF/employeeList.jsp").forward(request, response);
            } catch (SQLException ex) {
                //Todo
                ex.printStackTrace();
            }
        }
        
        //Employee Details: Save Details
        else if (action.equals("saveDetails")) {            
            String lastName = request.getParameter("lastName");
            String firstName = request.getParameter("firstName");
            String homePhone = request.getParameter("homePhone");
            String mobilePhone = request.getParameter("mobilePhone");
            String proPhone = request.getParameter("proPhone");
            String address = request.getParameter("address");
            String zipCode = request.getParameter("zipCode");
            String city = request.getParameter("city");
            String email = request.getParameter("email");
            String id = request.getParameter("id");           
            
            try {
                DB.updateEmployee(lastName, firstName, homePhone, mobilePhone, 
                        proPhone, address, zipCode, city, email, Integer.parseInt(id));
                //Update employeeList attribute in session
                session.setAttribute("employeesList", DB.getListEmployee());
                request.getRequestDispatcher("WEB-INF/employeeList.jsp").forward(request, response);
            } catch (SQLException ex) {
                //Todo
                ex.printStackTrace();
            }
        }
    }
    
    /*
    public void goToEmpListPage(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws ServletException, IOException {
        //Update employeeList attribute in session
        session.setAttribute("employeesList", DB.getListEmployee());
        request.getRequestDispatcher("employeeList.jsp").forward(request, response);
    }
    */

    /***********************************************************/
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
