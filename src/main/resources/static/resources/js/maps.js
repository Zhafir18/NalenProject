let map;
const locationDepok = { lat: -6.355780, lng: 106.800713 };

function createCenterControl(map) {
    const controlButton = document.createElement("button");
    controlButton.classList.add('buttonStyle');
    controlButton.textContent = "Center Map";
    controlButton.title = "Click to recenter the map";
    controlButton.type = "button";
    controlButton.addEventListener("click", () => {
        map.setCenter(locationDepok);
    });
    return controlButton;
}

function initMap() {
    map = new google.maps.Map(document.getElementById("map"), {
        zoom: 15,
        center: locationDepok,
    });

    const marker = new google.maps.Marker({
        position: locationDepok,
        map: map,
        title: "Jalan Rajawali D4 no. 1 Griya Cinere I",
    });

    const centerControlDiv = document.createElement("div");
    const centerControl = createCenterControl(map);

    centerControlDiv.appendChild(centerControl);
    map.controls[google.maps.ControlPosition.TOP_CENTER].push(centerControlDiv);
}

window.initMap = initMap;
