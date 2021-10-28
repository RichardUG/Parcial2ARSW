app= (function (){

    var _funcModify = function (variable) {
        if(variable != null){
            var arreglo = variable.map(function(country){
                return {key:country.country,value:country}
            })
            $("#tabla tbody").empty();

            arreglo.map(function(country){
                var temporal = '<tr><td id="Country" type="button" onclick="app.covidByCity(\''+country.key+'\')>'+country.key+'</td></tr>';
                $("#table tbody").append(temporal);
            })
        }
    };

    return {
        generalStats: function () {
            api.generalStats(_funcModify);
        }
    };
})();
