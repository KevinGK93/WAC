function initpage(){
fetch("https://ipapi.co/82.161.32.26/json/")
  .then(response => response.json())

  .then(function(myJson){
  	var country = document.createTextNode(myJson.country);
    var countryname = document.createTextNode(myJson.country_name);
    var region = document.createTextNode(myJson.region);
    var city = document.createTextNode(myJson.city);
    var postal = document.createTextNode(myJson.postal);
    var latitude = document.createTextNode(myJson.latitude);
    var longitude = document.createTextNode(myJson.longitude);
    var ip = document.createTextNode(myJson.ip);



    document.querySelector("#landcode").append(country);
    document.querySelector("#land").append(countryname);
    document.querySelector("#regio").append(region);
    document.querySelector("#stad").append(city);
    document.querySelector("#postcode").append(postal);
    document.querySelector("#latitude").append(latitude);
    document.querySelector("#longitude").append(longitude);
    document.querySelector("#ip").append(ip);
    
    weatherInfo(myJson.city);
    loadCountries();
    toevoegenLand();
  });
}
function weatherInfo(city){
	

	    if(window.localStorage.getItem(city) != null && JSON.parse(window.localStorage.getItem(city)).name === city && JSON.parse(window.localStorage.getItem(city)).time > new Date().getTime()){
	        
	    	var weerdata = JSON.parse(window.localStorage.getItem(city));

	        console.log("IFNO VAN LOCALSTORAGE");
	        var sunriseM = new Date((weerdata.sys.sunrise) * 1000);
	        var sunsetM = new Date((weerdata.sys.sunset) * 1000);

	        var sunset = sunsetM.getHours() + ":" + sunsetM.getMinutes() + ":" + sunsetM.getSeconds();
	        var sunrise = sunriseM.getHours() + ":" + sunriseM.getMinutes() + ":" + sunriseM.getSeconds();
	        
	        var windrichting = weerdata.wind.deg;
	        var windrichingen 
	        
	        if(windrichting > 247 && windrichting < 290){
	        	windrichtingen = "West"
	        }
	        else if(windrichting > 201 && windrichting < 247){
	        	windrichtingen = "Zuid West"
	        }
	        else if(windrichting > 157 && windrichting < 202){
	        	windrichtingen = "Zuid"
	        }
	        else if(windrichting > 111 && windrichting < 157){
	        	windrichtingen = "Zuid Oost"
	        }
	        else if(windrichting > 67 && windrichting < 111){
	        	windrichtingen = "Oost"
	        }
	        else if(windrichting > 21 && windrichting < 67){
	        	windrichtingen = "Noord Oost"
	        }
	        else if(windrichting > 337 && windrichting < 21){
	        	windrichtingen = "Noord"
	        }
	        else if(windrichting > 292 && windrichting < 337){
	        	windrichtingen = "Noord West"
	        }
	       
	        var temperatuur = (weerdata.main.temp - 273.15).toFixed(1);

	        document.querySelector("#temperatuur").innerHTML = temperatuur;
	        document.querySelector("#luchtvochtigheid").innerHTML = weerdata.main.humidity;
	        document.querySelector("#windsnelheid").innerHTML = weerdata.wind.speed;
	        document.querySelector("#windrichting").innerHTML = windrichtingen;
	        document.querySelector("#zonsopgang").innerHTML = sunrise;
	        document.querySelector("#zonsondergang").innerHTML = sunset;
	        document.querySelector("#h2").innerHTML = "Het weer in " + weerdata.name;

	    }else{
	fetch("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=ef38c137d9054a70d85465b6c79eafbe")
	        .then(response => response.json())
	        .then(function(weerdata) {
	        console.log("INFO VERZAMELEN");

	        weerdata["time"] = new Date().getTime() + 600000;
	        console.log(weerdata["time"]);
	        window.localStorage.setItem(city, JSON.stringify(weerdata));
	        var sunriseM = new Date((weerdata.sys.sunrise) * 1000);
	        var sunsetM = new Date((weerdata.sys.sunset) * 1000);

	        var sunset = sunsetM.getHours() + ":" + sunsetM.getMinutes() + ":" + sunsetM.getSeconds();
	        var sunrise = sunriseM.getHours() + ":" + sunriseM.getMinutes() + ":" + sunriseM.getSeconds();

	        var temperatuur = (weerdata.main.temp - 273.15).toFixed(1);

	        document.querySelector("#temperatuur").innerHTML = temperatuur;
	        document.querySelector("#luchtvochtigheid").innerHTML = weerdata.main.humidity;
	        document.querySelector("#windsnelheid").innerHTML = weerdata.wind.speed;
	        document.querySelector("#windrichting").innerHTML = weerdata.wind.deg;
	        document.querySelector("#zonsopgang").innerHTML = sunrise;
	        document.querySelector("#zonsondergang").innerHTML = sunset;
	        document.querySelector("#h2").innerHTML = "Het weer in " + weerdata.name;
	        });
	    }
	}
initpage();
