<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo List</title>
</head>
<body>
    <h2>Todo List</h2>
    <form action="todos" method="post">
        <label for="task">New Todo:</label>
        <input type="text" id="task" name="task" required>
        <input type="submit" value="Add Todo">
    </form>
    <ul>
        <c:forEach var="todo" items="${todos}">
            <li>
                ${todo.task}
                <form action="complete" method="post" style="display: inline;">
                    <input type="hidden" name="task" value="${todo.task}">
                    <input type="submit" value="Complete">
                </form>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
