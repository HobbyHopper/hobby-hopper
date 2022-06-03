let map;

function runMap(center) {

	mapboxgl.accessToken = MAPBOX_API_TOKEN;

	map = new mapboxgl.Map({
		container: 'map', // container ID
		style: 'mapbox://styles/mapbox/streets-v11', // style URL
		center: center, // starting position [lng, lat]
		zoom: 8.8 // starting zoom
	});

}

function addAddressMarker(center, address) {

	let popup = new mapboxgl.Popup({closeOnClick: false})
		.setLngLat(center)
		.setHTML("<p>" + address + "</p>")
		.addTo(map);

}
