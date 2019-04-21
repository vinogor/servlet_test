import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello") // альтернатива настройкам в web.xml
public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("init !!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=== doGet");
        // req - то, что получаем от пользователя
        // resp - то, что отправится в ответ на запрос
        PrintWriter writer = resp.getWriter(); // получаем стрим в который будем записывать информацию
//        writer.write("hello world!!!!!111233322!!!!!");

        String one = req.getParameter("one");
        String two = req.getParameter("two");

        // создаём 2 поля для ввода текста и кнопку отправить введённую в эти поля инфу
        //      form action='hello' - куда перекинет после нажатия кнопки
        //      method='get' - отправка будет сделана через get запрос
        writer.write("" +
                "<html>" +
                "<head></head>" +

                "<body>" +
                "one = " + one +
                "<br>" +
                "two = " + two +
//                "   <form action='hello' method='get'>" +
                "   <form action='hello' method='post'>" +
                "       <input type='text' name='one'/>" +
                "       <input type='text' name='two'/>" +
                "       <input type='submit' name='submit'/>" +
                "   </form>" +
                "</body>" +
                "</html>");

        // получаем значение параметра из адресной строки после "?"
        String param = req.getParameter("param");
        System.out.println("значение параметра param: " + param);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=== doPost");
        doGet(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=== service!!");
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("destroy!!!!!");
    }
}
