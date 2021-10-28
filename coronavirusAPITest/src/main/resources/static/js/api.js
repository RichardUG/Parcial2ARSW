var api=(function () {
    var url="http://"+((window.location.href).split('/')[2])+"/covid";
    return{
        generalStats:function(callback) {
            console.log(url)
            $.get(url+"/generalStats").then(responseJSON=>{
                    callback(
                        responseJSON
                    )
               }
            )
        }
    }
})();