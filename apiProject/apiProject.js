const getInfo = function(){
    const vin = $("#vin").val();
    const year = $("#yearIn").val();
    $.get(`https://vpic.nhtsa.dot.gov/api/vehicles/DecodeVin/${vin}?format=JSON&modelyear=${year}`,
        function(data, textStatus, jqXHR){
            for(let i = 1; i < data.Results.length; i++){
                if(`${data.Results[i].Variable}` === "Make"){
                    var make = data.Results[i].Value;
                }
                if(`${data.Results[i].Variable}` === "Model"){
                    var model = data.Results[i].Value;
                }
                if(`${data.Results[i].Variable}` === "Series"){
                    var series = data.Results[i].Value;
                }
                if(`${data.Results[i].Variable}` === "Model Year"){
                    var mYear = data.Results[i].Value;
                }
                if(`${data.Results[i].Variable}` === "Vehicle Type"){
                    var vType = data.Results[i].Value;
                }
                if(`${data.Results[i].Variable}` === "Body Class"){
                    var bClass = data.Results[i].ValueId;
                }
            }
            console.log(make, model, series, mYear, vType, bClass);
            $("#makeVin").text(make);
            $("#model").text(model);
            $("#series").text(series);
            $("#year").text(mYear);
            $("#bodyType").text(vType);
            let imageUrl = "BodyClassImages/" + bClass + ".png";
            $("#bodyClass").attr("src", imageUrl);
            console.log(data);
            console.log(textStatus);
            console.log(jqXHR);
        }
    );
}

const getList = function(){
    $("#container").empty();
    const make = $("#make").val();
    const year = $("#yearInM").val();
    $.get(`https://vpic.nhtsa.dot.gov/api/vehicles/GetModelsForMakeYear/make/${make}/modelyear/${year}?format=JSON`,
        function(data, textStatus, jqXHR){
            var allModels = [];
            for(let i = 0; i < data.Results.length; i++){
                    allModels.push(`${data.Results[i].Model_Name}`);
            }
            var list = document.createElement('ul');
            for (var i = 0; i < allModels.length; i++) {
                var item = document.createElement('li');
                item.appendChild(document.createTextNode(allModels[i]));
                list.appendChild(item);
            }
            document.getElementById("container").appendChild(list);
            console.log(data);
            console.log(textStatus);
            console.log(jqXHR);
        }
    );
}

const makeList = function(array) {
    var list = document.createElement('ul');
    for (var i = 0; i < array.length; i++) {
        var item = document.createElement('li');
        item.appendChild(document.createTextNode(array[i]));
        list.appendChild(item);
    }
    return list;
}