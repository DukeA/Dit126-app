var map;
var markers = [];

function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat:  57.687799, lng: 11.978534},
        zoom: 15
    });
}

function addMarker({lat, lng}) {
  var marker = new google.maps.Marker({
    position: {lat: Number(lat), lng: Number(lng)},
    map: map
  });
  markers.push(marker);
}

function deleteMarkers() {
  console.log("DELETING MARKERS");
  markers.forEach(marker => marker.setMap(null));
  markers = [];
}
