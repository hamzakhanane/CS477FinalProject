# Make & Save
Make and save is a platform that consists of two types of users. A customer and a service provider. The customer is able to
login and post a job request. The service provider is able to look at all the available job requests in a real time map activity
and apply to them.

## Technologies Used
* Firebase
* Email verification
* User authentication
* Image integration
* Paypal API
* Calendar API
* Google Maps API


### Sample code snippet to update google maps in real time
````
@Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            mMap.setMyLocationEnabled(true);
        }
        if (mlocationpermission) {
            getDeviceLocation();

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(false);
            SharedPreferences prefs = getSharedPreferences(PaymentDetails.MY_PREFS_NAME, MODE_PRIVATE);
            int size = prefs.getInt("size",0);
            for(int i=0; i<size; i++)
            {
                lati = prefs.getString("lat" + Integer.toString(i), "0");//"No name defined" is the default value.
                longi  = prefs.getString("longitude" +  Integer.toString(i) , "0"); //0 is the default value.

                Toast.makeText(this, lat +" " + longi, Toast.LENGTH_SHORT).show();
                lat = Double.parseDouble(lati);
                longitude = Double.parseDouble(longi);
                // Add a marker in Sydney and move the camera
                LatLng address = new LatLng(lat, longitude);

                Marker marker = mMap.addMarker(new MarkerOptions().position(address).title("Apply" +Integer.toString(i) ));
                markerHashMap.put(marker.getId(),"Apply" +Integer.toString(i));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(address,5f));
                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        String userId = markerHashMap.get(marker.getId());
                        Intent intent = new Intent(CurrentLocationMap.this, Apply.class);
                        //intent.putExtra("Problem",);
                        startActivity(intent);

                        return false;
                    }
                });
            }
        }
    }


````

### Future Work
* Integrate Firebase to save jobs so that they could be extracted easily when a service provider applies to jobs
* add a notification system, which notifies service provider if a job was posted in their area.


