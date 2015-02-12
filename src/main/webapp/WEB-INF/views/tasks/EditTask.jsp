<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <%@ include file="../Include.jsp"%>
    <title>Edit Task</title>
</head>
<body>
<%@include file="../Navigation.jsp"%>
<div align="center" class="container">
    <div class="">
        <form role="form" action="savechanges" method="post" enctype="multipart/form-data">
            <input name="id" type="hidden" value="${task.id}"/>
            <input name="date" type="hidden" value="${task.date}"/>
            <div>
                <div>
                    <input name="title" value="${task.title}" type="text" class="task-name" placeholder="Enter task title..." />
                </div>
            </div>
            <div class="tab-row">
                <div align="right" class="task-tcat">
                    <input name="timeSpent" value="${task.timeSpent}" type="text" class="task-time-spent" placeholder="Time Spent (hrs)" />
                </div>
                <div align="left" class="task-tcat">
                    <input name="category" value="${task.category}" type="text" class="task-category" placeholder="Category" />
                </div>
            </div>
            <div>
                <div>
                    <textarea name="details" rows="10" class="task-details" placeholder="Task Details...">${task.details}</textarea>
                </div>
            </div>
            <div class="save-btn">
                <button type="submit" class="btn btn-lg btn-success" href="#" role="button">Save</button>
            </div>

        </form>
    </div>

</div>
</body>
</html>