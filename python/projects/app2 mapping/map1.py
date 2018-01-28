import folium
import pandas
# read data from txt file, which is save in  data variable
data = pandas.read_csv("Volcanoes.txt")

# convert LAT and LON data into list
lat = list(data["LAT"])
lon = list(data["LON"])
elev = list(data["ELEV"])


#dir(folium)
map = folium.Map(location = [38.58, -99.09],zoom_start = 6, tiles = "Mapbox Bright")

fgv = folium.FeatureGroup(name = "Volcanoes")

coordinates = [[38.2, -99.1], [39.2, -94.1]]
# Adding marker with forloop
"""
for coordinate in coordinates:
    fg.add_child(folium.Marker(location = coordinate, popup = "Hey there!!!", icon = folium.Icon(color = "green")))
"""
# function for colors
def color(elevation):
    if elevation < 1000:
        return "green"
    elif 1000 <= elevation < 3000:
        return "orange"
    else:
        return "red"

#Adding marker with dataFile
#if you iterate two list at the same time  ==> use zip
"""
for lt, ln,el in zip(lat, lon, elev):
    fg.add_child(folium.Marker(location = [lt, ln], popup = str(el), icon = folium.Icon(color = color(el))))
"""
# help(folium.Marker)

    
# CircleMarker

for lt, ln,el in zip(lat, lon, elev):
    fgv.add_child(folium.CircleMarker(location = [lt, ln], radius = 6,   popup = str(el), fill_color = color(el),color = "grey", fill = True, fill_opacity = 0.7))

fgp = folium.FeatureGroup(name = "Population")

#adding polygun by using Geojson method
fgp.add_child(folium.GeoJson(data = open("world.json", "r", encoding = "utf-8-sig").read(),
                            style_function = lambda x : {"fillColor" : "green" if x["properties"]["POP2005"] < 1000000
                                                         else "orange" if 10000000<= x["properties"]["POP2005"] < 20000000 else "red"}))



#   map.add_child(folium.Marker(location = [38.2, -99.1], popup = "Hey !!  Whatsupp", icon = folium.Icon(color =  "green")))

map.add_child(fgv)
map.add_child(fgp)
map.add_child(folium.LayerControl())

map.save("Map1.html")
