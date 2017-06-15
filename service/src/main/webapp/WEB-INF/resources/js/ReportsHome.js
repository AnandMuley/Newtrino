
    // Load the Visualization API and the piechart package.
    google.load('visualization', '1.0', {'packages':['corechart']});

    // Set a callback to run when the Google Visualization API is loaded.
    google.setOnLoadCallback(drawChart);



    // Callback that creates and populates a data table,
    // instantiates the pie chart, passes in the data and
    // draws it.
    function drawChart() {
        // Fetch Data
        $.ajax({
            type: "POST",
            url : "fetchdata"
        }).done(function(msg){
            console.log(msg);
            fnDrawReportCharts(msg);
            //var pchart = new google.visualization.ColumnChart(document.getElementById('proteinsReport'));
            //pchart.draw(google.visualization.arrayToDataTable(msg[0].data), msg[0].options);
        });

    }

    function fnDrawReportCharts(msg){
        for(var i=0;i<msg.length;i++){
            $('#reportsContainer').append('<div id="'+msg[i].nutrientName+'" class="col-lg-3"></div>');
            var pchart = new google.visualization.ColumnChart(document.getElementById(msg[i].nutrientName));
            pchart.draw(google.visualization.arrayToDataTable(msg[i].data), msg[i].options);
            //$('#reportsContainer').append();
        }
    }
