package edu.zju.cst.gsw.servlet;

import edu.zju.cst.gsw.dao.HeroDao;
import edu.zju.cst.gsw.entity.Hero;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HeroAddServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Hero hero = new Hero();
        hero.setName(req.getParameter("name"));
        hero.setHp(Float.parseFloat(req.getParameter("hp")));
        hero.setDamage(Integer.parseInt(req.getParameter("damage")));

        new HeroDao().add(hero);

        resp.sendRedirect("listHero");
    }
}
