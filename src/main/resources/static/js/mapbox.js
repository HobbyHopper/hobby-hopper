//map variable created outside function in order to be accessed by any function
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
		//TODO: edit styling on this html element, looks kinda ugly the way it is
		.setHTML("<p>" + address + "</p>")
		.addTo(map);

}
