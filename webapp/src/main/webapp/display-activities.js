var map;
var markers = [];

function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat:  57.687799, lng: 11.978534},
        zoom: 15
    });

    google.maps.event.addListenerOnce(map, 'bounds_changed', () => map.setZoom(Math.min(map.getZoom(), 15)));
}

function addMarker({lat, lng}) {
  var marker = new google.maps.Marker({
    position: {lat: Number(lat), lng: Number(lng)},
    map: map
  });
  markers.push(marker);
}

function deleteMarkers() {
  markers.forEach(marker => marker.setMap(null));
  markers = [];
}

function setMapPosition() {
    const bounds = new google.maps.LatLngBounds();
    markers.forEach(marker => bounds.extend(marker.getPosition()));

    map.fitBounds(bounds);
}
