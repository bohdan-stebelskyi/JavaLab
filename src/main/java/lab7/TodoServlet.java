package lab7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/todos")
public class TodoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private List<TodoItem> todoList;

    public TodoServlet() {
        // Ініціалізуємо список у конструкторі
        todoList = new ArrayList<>();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("todos", todoList);
        request.getRequestDispatcher("/WEB-INF/views/todos.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String task = request.getParameter("task");

        if (task != null && !task.isEmpty()) {
            // Створюємо нове завдання та додаємо його до списку
            TodoItem todoItem = new TodoItem(task);
            todoList.add(todoItem);
        }

        // Перенаправляємо користувача назад на сторінку зі списком завдань
        response.sendRedirect(request.getContextPath() + "/todos");
    }
}
