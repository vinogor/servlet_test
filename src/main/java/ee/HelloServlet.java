package ee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // req - то, что получаем от пользователя
        // resp - то, что отправится в ответ на запрос
        PrintWriter writer = resp.getWriter(); // получаем стрим в который будем записывать информацию
        writer.write("hello world!");

    }
}
