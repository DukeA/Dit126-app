var map;
var marker;
function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat:  57.687799, lng: 11.978534},
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

function placeMarker(location) {
    marker.setPosition(location);

    document.getElementById("j_idt18:lat").value = location.lat();
    document.getElementById("j_idt18:lng").value = location.lng();
}

$("#go").click(function foo(){
    $("#second").removeClass("hide");
    $("#first").addClass("hide");
    $("#map").removeClass("big-map").addClass("small-map");
    $(this).addClass("hide");
    map.setOptions({gestureHandling: "none", zoomControl: false})
    google.maps.event.clearListeners(map, 'click');
    map.panTo(marker.getPosition())
});