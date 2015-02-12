<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <%@ include file="../Include.jsp"%>
    <title>Task Home</title>
    <script type="application/javascript">
        $(document).ready(function(){

            $('#date-picker').datepicker({
                todayBtn: "linked",
                todayHighlight: true,
                format: "dd/mm/yyyy",
                autoclose: true
            }).on('changeDate',function(e){
                var dateSel = e.format('dd-M-yyyy');
                var taskDate = dateSel;
                if(undefined!=dateSel){
                    location.href  = "datedtasks?clientDate="+dateSel;
                    //console.log('Selected : '+ dateSel);
                    //$('#queue-date').html(dateSel);
                    //$('#taskDate').val(taskDate);
                }

            });

            $( ".draggable" ).draggable();

            $( "#drop-in-dustbin" ).droppable({
                drop: function( event, ui ) {
                    var elei =  ui.helper[0].getAttribute("href");
                    var delUrl = "delete?"+elei.split('?')[1];
                    location.href = delUrl;
                   console.log('Dropped...: '+delUrl);
                }
            });

        });
    </script>
</head>
<body>
<%@include file="../Navigation.jsp"%>
<div class="table">
    <div class="table-row">
        <div class="table-cell todays-tasks-cell">
            <c:choose>
                <c:when test="${expectedDate==null}">
                    <h2>Tasks Completed Today</h2>
                </c:when>
                <c:otherwise>
                    <h2>Tasks Completed on <br>${expectedDate}</h2>
                </c:otherwise>
            </c:choose>
            <c:choose>
            <c:when test="${fn:length(tasks)>0}">
            <div class="list-group todays-tasks">
                <c:forEach items="${tasks}" var="task">
                    <c:set var="totalTimeSpent" value="${task.timeSpent+totalTimeSpent}"></c:set>
                    <a href="edittask?id=${task.id}" class="list-group-item draggable">
                        <span class="badge">${task.timeSpent}</span>
                        <h4 class="list-group-item-heading">${task.title}</h4>
                        <p class="list-group-item-text">${task.details}</p>
                    </a>
                </c:forEach>
                <a href="#" class="list-group-item active">
                    <span class="badge">${totalTimeSpent}</span>
                    <h4 class="list-group-item-heading">Total Time Spent</h4>
                </a>
            </div>
            </c:when>
            <c:otherwise>
                It seems you did not work on this day !
            </c:otherwise>
            </c:choose>
        </div>
        <div class="table-cell add-task-container">
                <div align="center">
                    <c:choose>
                        <c:when test="${expectedDate==null}">
                            <h2>Add task in today's queue</h2>
                        </c:when>
                        <c:otherwise>
                            <h2>Add task in ${expectedDate} queue</h2>
                        </c:otherwise>
                    </c:choose>

                </div>
                <form id="tasksFrm" role="form" action="create" method="post" enctype="multipart/form-data">
                    <input id="taskDate" name="clientDate" type="hidden" value="${expectedDate}"/>
                    <div>
                        <div>
                            <input name="title" type="text" class="task-name" placeholder="Enter task title..." />
                        </div>
                    </div>
                    <div class="tab-row">
                        <div align="right" class="task-tcat">
                            <input name="timeSpent" type="text" class="task-time-spent" placeholder="Time Spent (hrs)" />
                        </div>
                        <div align="left" class="task-tcat">
                            <input name="category" type="text" class="task-category" placeholder="Category" />
                        </div>
                    </div>
                    <div>
                        <div>
                            <textarea name="details" rows="8" class="task-details" placeholder="Task Details..."></textarea>
                        </div>
                    </div>
                    <div class="save-btn" align="center">
                        <button type="submit" class="btn btn-lg btn-success" href="#" role="button">Save</button>
                    </div>

                </form>
        </div>
        <div align="center" class="table-cell date-picker-container">
            <h2>Tasks on date</h2>
            <div id="date-picker" data-date=""></div>
            <br>
            <div id="drop-in-dustbin">
                <img src="../resources/images/Dustbin.png" width="150" height="150">
            </div>
        </div>
    </div>
</div>

</body>
</html>