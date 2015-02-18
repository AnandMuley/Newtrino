
    // Load the Visualization API and the piechart package.
    google.load('visualization', '1.0', {'packages':['corechart']});

    // Set a callback to run when the Google Visualization API is loaded.
    google.setOnLoadCallback(drawChart);

    // Callback that creates and populates a data table,
    // instantiates the pie chart, passes in the data and
    // draws it.
    function drawChart() {

        // Create the data table.
        var data = google.visualization.arrayToDataTable([
            ['Genre', 'Consumed', 'Not Consumed',
                 { role: 'annotation' } ],
            ['Coffee', 50, 20, ''],
            ['Protein', 10, 30, ''],
            ['Carbohydrate', 20, 40, ''],
            ['Fats', 30, 20, '']
        ]);

        // Set chart options
        var options = {
            'title':'Nutrients consumed today',
            'width':600,
            'height':300,
            'isStacked': true,
            'colors' : ['#09AE85','#fe7a15']
        };

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
        chart.draw(data, options);
    }
