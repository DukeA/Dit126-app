var map;
var marker;
function initMap() {
  map = new google.maps.Map(document.getElementById('map'), {
    center: {lat: 10, lng: 10},
    zoom: 15
  }); 

  marker = new google.maps.Marker({
    position: {lat: 57.687799, lng: 11.978534},
    map: map,
    title: 'Hello World!'
  });

  google.maps.event.addListener(map, 'click', function(event) {
    placeMarker(event.latLng);
  });
}

async function foo(json){

  var found = false;
  for(i = json.length-1;i>0;i--){
    for(j = 0;j<json[i].address_components.length;j++){
      if(json[i].address_components[j].types.includes("postal_town") && !found){
        found = true;
      } else if(json[i].address_components[j].types.includes("locality") && !found){
        found = true;
      }
    }

  }
}

function placeMarker(location) {
  marker.setPosition(location);
  
  document.getElementById("j_idt6:lat").value = location.lat();
  document.getElementById("j_idt6:lng").value = location.lng();

  /*const response = fetch("https://maps.googleapis.com/maps/api/geocode/json?latlng="+ location.lat() +"," + location.lng() + "&sensor=false&key=<INSERT API KEY HERE>")
  .then((response) => (
    response.json()
  )).then((json) => (
    foo(json.results)
  ));*/
}