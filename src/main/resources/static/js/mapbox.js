function runMap(center) {

	mapboxgl.accessToken = MAPBOX_API_TOKEN;

	const map = new mapboxgl.Map({
		container: 'map', // container ID
		style: 'mapbox://styles/mapbox/streets-v11', // style URL
		center: center, // starting position [lng, lat]
		zoom: 8.8 // starting zoom
	});




}
