    document.addEventListener( "DOMContentLoaded", fillTable, false );

    function fillTable() {
        updateTable(workerTable, workerData);
    }

    function updateTable(tableId, data){

        var tableHTML = "<tr>";

        for (var eachItem in data) {
        tableHTML += "<tr>";
        var dataObj = data[eachItem];
        for (var eachValue in dataObj){
          tableHTML += "<td>" + dataObj[eachValue] + "</td>";
        }
        tableHTML += "</tr>";
      }

      document.getElementById(tableId).innerHTML += tableHTML;
    }