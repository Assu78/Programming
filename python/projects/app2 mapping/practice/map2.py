import folium
import pandas

map = folium.Map(location = [38.58,99.09], zoom_start = 6, tiles = "Mapbox Bright")

fgm = folium.StepColormap(color = "yellow", index=3)

#map.addChild(map)
map.save("Map2.html")
