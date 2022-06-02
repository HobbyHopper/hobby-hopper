mapboxgl.accessToken = MAPBOX_API_TOKEN;

const map = new mapboxgl.Map({
	container: 'map', // container ID
	style: 'mapbox://styles/mapbox/streets-v11', // style URL
	center: centerCoords, // starting position [lng, lat]
	zoom: 8.8 // starting zoom
});


	mapboxgl.accessToken = 'pk.eyJ1Ijoic2hhei1zb3RvLW11bmV0IiwiYSI6ImNsMGxsZzdwczBtNzgzam8zMHZoaWNhZzIifQ.xvCWK-Woj2PD7_1cbTF70A';

	const map = new mapboxgl.Map({
	container: 'map',
	style: 'mapbox://styles/mapbox/streets-v11',
	center: [-79.4512, 43.6568],
	zoom: 13
});

	// Add the control to the map.
	map.addControl(
	new MapboxGeocoder({
	accessToken: mapboxgl.accessToken,
	mapboxgl: mapboxgl
})
	);
