package com.casestudy.case_study.servlet;

import com.casestudy.case_study.model.EducationDegree;
import com.casestudy.case_study.service.IEducationDegreeService;
import com.casestudy.case_study.service.impl.EducationDegreeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EducationDegreeServlet", value = "/educationDegrees")
public class EducationDegreeServlet extends HttpServlet {
    private final IEducationDegreeService degreeService = new EducationDegreeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EducationDegree> educationDegrees = degreeService.findAll();

        try {
            request.setAttribute("educationDegreeList",educationDegrees);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/educationDegrees/list.jsp");
            dispatcher.forward(request,response);
        }catch (ServletException | IOException e){
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
